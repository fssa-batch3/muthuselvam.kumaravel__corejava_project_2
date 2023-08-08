package com.fssa.inifiniti.model;

public class CompanyCard {

	
	private String companyTitle;
	private String imageUrl;
	private String isEdit;
	private String isDeleted;
	
	
	public CompanyCard(String companyTitle, String imageUrl, String isEdit, String isDeleted) {
		this.companyTitle = companyTitle;
		this.imageUrl = imageUrl;
		this.isEdit = isEdit;
		this.isDeleted = isDeleted;
	}
	
	public CompanyCard() {
		// TODO Auto-generated constructor stub
	}

	public String getCompanyTitle() {
		return companyTitle;
	}
	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public String isEdit() {
		return isEdit;
	}
	public void setEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	
	public String isDeleted() {
		return isDeleted;
	}
	public void setDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	

}
