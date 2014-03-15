package com.seascape.enterprise.entity;

public class AccountVerification {

	private Long verificationId;
	private Long accountId;
	private String sentDate;
	private String code;
	
	
	public AccountVerification() {}
	
	public AccountVerification (Long verificationId, Long accountId, String code, String sentDate) {
		this.verificationId=verificationId;
		this.accountId=accountId;
		this.code=code;
		this.sentDate=sentDate;
		
	}

	public Long getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(Long verificationId) {
		this.verificationId = verificationId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
