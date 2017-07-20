package com.ad.compaign.exception;
 
public class CampaignException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public CampaignException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public CampaignException() {
		super();
	}
}