package com.seascape.enterprise.entity;

public class Category {

	private Long categoryId;
	private String title;
	
	public Category() {}
	
	public Category (Long categoryId, String title) {
		this.categoryId=categoryId;
		this.title=title;
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
	
	
}
