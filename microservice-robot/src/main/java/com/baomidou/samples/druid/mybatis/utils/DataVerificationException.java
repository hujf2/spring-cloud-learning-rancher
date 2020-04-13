package com.baomidou.samples.druid.mybatis.utils;

import com.mapabc.springboot.common.log.LogBeanBuilders;
import com.mapabc.springboot.common.log.LoggerLogcenterUtil;

public class DataVerificationException extends RuntimeException {

	private String retCd;  //异常对应的返回码
	private String msgDes;  //异常对应的描述信息

	public DataVerificationException() {
		super();
	}

	public DataVerificationException(String message) {
		super(message);
		msgDes = message;
	}

	public DataVerificationException(String retCd, String msgDes) {
		super();
		this.retCd = retCd;
		this.msgDes = msgDes;
		LoggerLogcenterUtil.error(getClass(), new LogBeanBuilders()
				.setAccessLog("retCd = {0} , msgDes = {1} ", retCd, msgDes));
	}

	public String getRetCd() {
		return retCd;
	}

	public String getMsgDes() {
		return msgDes;
	}
}