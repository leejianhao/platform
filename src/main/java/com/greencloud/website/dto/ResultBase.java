package com.greencloud.website.dto;

/**
 * 接口返回基类，该类职责越简单越好
 */
public class ResultBase {
	/**
	 * 接口返回code,0:success,1:failure
	 */
	private String resultCode;
	/**
	 * 接口返回message
	 */
	private String resultMsg;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
}
