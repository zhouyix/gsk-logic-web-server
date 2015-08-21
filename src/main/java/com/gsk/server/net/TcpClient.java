package com.gsk.server.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gsk.server.global.CommandManager;
import com.gsk.server.global.Global;
import com.gsk.server.protobuf.GSKPackage;
import com.gsk.server.protobuf.PbGsk.PbCltUser;
import com.gsk.server.protobuf.PbGskReq.PbReqReq;
import com.gsk.server.protobuf.convert.PackCodec;

public class TcpClient {
	static Logger log = LoggerFactory.getLogger(TcpClient.class);
	
	final static String ip = Global.GSK_SERVER_IP;
	final static int port = Global.GSK_SERVER_PORT;
	
	private static Socket socket = null;
	public static TcpClient instance;
	
	public static TcpClient getInstance() {
		if(instance == null) {
			instance = new TcpClient();
		}
		return instance;
	}
	
	private TcpClient() {
		
	}
	
	private void connect() {
		try {
			socket = new Socket(ip, port);
			socket.setKeepAlive(true);
			socket.setTcpNoDelay(true);
			socket.setSendBufferSize(1024 * 1000);
			socket.setReceiveBufferSize(1024 * 1000);
			socket.setSoTimeout(3000);
		} catch (Exception e) {
			log.error("connect:", e);
		}
	}
	
	public GSKPackage send(GSKPackage pack) {
		OutputStream out = null;
		InputStream in = null;
		try {
			if(socket == null || socket.isClosed()) {
				connect();
			}
			if(socket != null && socket.isConnected()) {
//				short cmd = pack.getwCommand();
//				int uin = pack.getDwUin();
//				int crc = pack.getDwCRC();//81208878
				out = socket.getOutputStream();
				//ByteBuffer buf = PackCodec.encode(pack);
				out.write(PackCodec.encode(pack).array());
				out.flush();
				
				in = socket.getInputStream();
				byte[] head = new byte[Global.PACK_HEARD_LENGTH + 1];
				in.read(head);
				ByteBuffer headBuf =  ByteBuffer.wrap(head);
				headBuf.get();
				int length = headBuf.getInt();
				//short cmd = headBuf.getShort();
				ByteBuffer retBuf = ByteBuffer.allocate(length);
				headBuf.position(0);
				retBuf.put(headBuf);
				//int resultCode = headBuf.get(23);
				byte[] body = new byte[length - (Global.PACK_HEARD_LENGTH + 1)];
				in.read(body);
				retBuf.put(body);
				return	PackCodec.decode(retBuf);
				//return body;
			} else {
				connect();
			}
		} catch (Exception e) {
			log.error("send:", e);
			return null;
		} finally {
			try {
				if(null != out) {
					out.close();
				}
				if(null != in) {
					in.close();
				}
			} catch (IOException e) {
				log.error("send out close:", e);
			}
		}
		return null;
	}
	
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			log.error("close:", e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		TcpClient client =TcpClient.getInstance();
		
		
		PbReqReq.Builder builder = PbReqReq.newBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_LIST);
		//builder.addSArgs("12320361");
		//builder.addSArgs("5582b8ea6a6950103025d2ac");
		builder.addIArgs(21791994);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_LIST);
		pack.setDwUin(21791994);
		pack.setProtoBody(builder.build().toByteArray());
		
		GSKPackage b = client.send(pack);
		PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
		//String msg = user.getImGroupDetails().getGroupInfo().getLastMsg();
		System.out.println(user.toString());
		
	}
}