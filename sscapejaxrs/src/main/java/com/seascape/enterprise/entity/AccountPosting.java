package com.seascape.enterprise.entity;

public class AccountPosting {

	private Long postingId;
	private Long accountId;
	private Long categoryId;
	private String title;
	private String description;
	private String location;
	private String postDate;
	private Long primaryPhotoId;
	private String activeFlag;
	
	public AccountPosting() {}
	
	public AccountPosting(Long postingId, Long accountId, Long categoryId, String title, String description,
			String location, String postDate, Long primaryPhotoId, String activeFlag) {
		this.postingId=postingId;
		this.accountId=accountId;
		this.categoryId=categoryId;
		this.title=title;
		this.description=description;
		this.location=location;
		this.postDate=postDate;
		this.primaryPhotoId=primaryPhotoId;
		this.activeFlag=activeFlag;
	}
	
	public Long getPostingId() {
		return postingId;
	}
	public void setPostingId(Long postingId) {
		this.postingId = postingId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public Long getPrimaryPhotoId() {
		return primaryPhotoId;
	}
	public void setPrimaryPhotoId(Long primaryPhotoId) {
		this.primaryPhotoId = primaryPhotoId;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
}
