package com.ad.compaign.util;

import java.io.Serializable;


public class CustomError implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private int errorCode;

	
    public CustomError(String errorMessage){
        this.errorMessage = errorMessage;
    }
    

    public String getErrorMessage() {
        return errorMessage;
    }


	public int getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
