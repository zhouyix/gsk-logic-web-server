package com.gsk.server.protobuf.convert;

import com.gsk.server.protobuf.PbGskReq.PbReqReport;
import com.gsk.server.protobuf.PbGskReq.PbReqReq;

public class PbReqReqCodec {
	public static PbReqReq.Builder getReqReqBuilder() {
		PbReqReq.Builder builder = PbReqReq.newBuilder();
		PbReqReport.Builder reportBuilder = PbReqReport.newBuilder();
		reportBuilder.setOs("linux");
		reportBuilder.setNetwork("http-server");
		builder.setReport(reportBuilder.build());
		
		return builder;
	}
}
