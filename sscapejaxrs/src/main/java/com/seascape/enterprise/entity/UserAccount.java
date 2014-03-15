package com.seascape.enterprise.entity;


public class UserAccount {

	private Long accountId;
	private String username;
	private String password;
	private String emailAddress;
	private String dob;
	private String gender;
	private String contactPhone;
	private String location;
	private String tosAgreementFlag;
	private String creationDate;
	private String verifiedDate;
	

	// Must have no-argument constructor
	public UserAccount() {

	}

	public UserAccount(Long accountId, String username, String password, String emailAddress, String dob, String gender, String contactPhone, 
			String location, String tosAgreementFlag, String creationDate, String verifiedDate) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.dob = dob;
		this.gender = gender;
		this.contactPhone = contactPhone;
		this.location = location;
		this.tosAgreementFlag = tosAgreementFlag;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTosAgreementFlag() {
		return tosAgreementFlag;
	}

	public void setTosAgreementFlag(String tosAgreementFlag) {
		this.tosAgreementFlag = tosAgreementFlag;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(String verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	
}
