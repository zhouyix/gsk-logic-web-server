package com.gsk.server.protobuf;


/**
 * 协议对象
 */
public class GSKPackage {
	private byte[] heard;
	private byte startTag; 			// 包开始标示 						byte
	private int dwLength; 			// 包头+包体总长 					uint32
	private short wCommand; 		// 命令字 							uint16
	private int dwUin; 				// userid 						uint32
	private short wClientId; 		// ios/android/pc/mac.... 		uint16
	//private int dwSeq; 			// 客户端生成的seq 					uint32
	private short wChannelId; 		// 小米、360、appstore.... 		uint16
	private int dwCRC; 				// 请求包crc 						uint32
	private byte cResult; 			// response时的error code 		uint8
	//private int dwTime; 			// 服务端生成-clt请求时的服务端时间 		uint32
	//private int dwClientIP; 		// 服务端生成-clt请求时的ip 			uint32
	//private short wClientPort; 	// 服务端生成-clt请求时的port 		uint16
	//private int iFd; 				// 								int
	private long dwRspIP; 			//gateWay ip 					uint32
	private int wRspPort; 			//gateWay port 					uint16
	private int iVersion; 			//客户端版本号						uint32
	//private byte[] sResv; 		// 								char[17]
	//private byte[] body; 			// 								char[0]
	private byte[] protoBody; 		// protobuf内容					byte[]
	private byte endTag; 			// 包结束标示						byte
	
	
	public byte[] getHeard() {
		return heard;
	}
	public void setHeard(byte[] heard) {
		this.heard = heard;
	}
	public byte getStartTag() {
		return startTag;
	}
	public void setStartTag(byte startTag) {
		this.startTag = startTag;
	}
	public int getDwLength() {
		return dwLength;
	}
	public void setDwLength(int dwLength) {
		this.dwLength = dwLength;
	}
	public short getwCommand() {
		return wCommand;
	}
	public void setwCommand(short wCommand) {
		this.wCommand = wCommand;
	}
	public int getDwUin() {
		return dwUin;
	}
	public void setDwUin(int dwUin) {
		this.dwUin = dwUin;
	}
	public short getwClientId() {
		return wClientId;
	}
	public void setwClientId(short wClientId) {
		this.wClientId = wClientId;
	}
	public short getwChannelId() {
		return wChannelId;
	}
	public void setwChannelId(short wChannelId) {
		this.wChannelId = wChannelId;
	}
	public int getDwCRC() {
		return dwCRC;
	}
	public void setDwCRC(int dwCRC) {
		this.dwCRC = dwCRC;
	}
	public byte getcResult() {
		return cResult;
	}
	public void setcResult(byte cResult) {
		this.cResult = cResult;
	}
	public long getDwRspIP() {
		return dwRspIP;
	}
	public void setDwRspIP(long dwRspIP) {
		this.dwRspIP = dwRspIP;
	}
	public int getwRspPort() {
		return wRspPort;
	}
	public void setwRspPort(int wRspPort) {
		this.wRspPort = wRspPort;
	}
	public byte[] getProtoBody() {
		return protoBody;
	}
	public void setProtoBody(byte[] protoBody) {
		this.protoBody = protoBody;
	}
	public byte getEndTag() {
		return endTag;
	}
	public void setEndTag(byte endTag) {
		this.endTag = endTag;
	}
	public int getiVersion() {
		return iVersion;
	}
	public void setiVersion(int iVersion) {
		this.iVersion = iVersion;
	}
	
}
