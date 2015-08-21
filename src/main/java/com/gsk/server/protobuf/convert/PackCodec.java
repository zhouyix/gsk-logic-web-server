package com.gsk.server.protobuf.convert;

import java.nio.ByteBuffer;

import com.gsk.server.global.Global;
import com.gsk.server.protobuf.GSKPackage;

public class PackCodec {
	public static GSKPackage decode(ByteBuffer buf) {
		GSKPackage pack = new GSKPackage();
		buf.position(0);
		byte startTag = buf.get();
		pack.setStartTag(startTag);
		byte[] heard = new byte[64];
		buf.position(0);
		buf.get(heard);
		pack.setHeard(heard);
		int totallen = buf.getInt(1);
		short cmd = buf.getShort(5);
		pack.setwCommand(cmd);
		int uid = buf.getInt(7);
		pack.setDwUin(uid);
		short clientId = buf.getShort(11);
		pack.setwClientId(clientId);
		short channelId = buf.getShort(17);
		pack.setwChannelId(channelId);
		int crc = buf.getInt(19);
		pack.setDwCRC(crc);
		byte result = buf.get(23);
		pack.setcResult(result);
		int bodyLen = totallen - (Global.PACK_HEARD_LENGTH + 2);
		byte[] body = new byte[bodyLen];
		buf.position(Global.PACK_HEARD_LENGTH + 1);
		buf.get(body);
		pack.setProtoBody(body);
		byte endTag = buf.get();
		pack.setEndTag(endTag);
		
		return pack;
	}
	
	public static ByteBuffer encode(GSKPackage pack) {
		byte[] bytes = pack.getProtoBody();
		int bodyLen = 0;
		if(null != bytes) {
			bodyLen = bytes.length;
		}
		ByteBuffer buf = ByteBuffer.allocate(Global.PACK_HEARD_LENGTH + 2 + bodyLen);
		buf.put(Global.HEARD_START_TAG);  //start
		//buf.put(pack.getHeard());
		buf.putInt(1, Global.PACK_HEARD_LENGTH + 2 + bodyLen);
		buf.putShort(5, pack.getwCommand());
		buf.putInt(7, pack.getDwUin());
		buf.putInt(19, Global.GSK_HEAD_CRC);
		//buf.put(23, pack.getcResult());
		if(bodyLen > 0) {
			buf.position(Global.PACK_HEARD_LENGTH + 1);
			buf.put(bytes);
		}
		buf.put(Global.PACK_HEARD_LENGTH + 1 + bodyLen, Global.HEARD_END_TAG);  //end
		
		return buf;
	}
}
