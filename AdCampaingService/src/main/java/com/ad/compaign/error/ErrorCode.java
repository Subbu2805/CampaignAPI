package com.ad.compaign.error;

public enum ErrorCode {
	SERVICE_ERROR(1,"Error in executing the request. Please try again!");
	
	private String errorMsg;
	private int erroCode;
	
	ErrorCode(int erroCode, String errorMsg) {
		this.erroCode = erroCode;
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getErroCode() {
		return erroCode;
	}
	public void setErroCode(int erroCode) {
		this.erroCode = erroCode;
	}
	

}
