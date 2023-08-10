package com.fssa.inifiniti.model;

public class CompanyCard {

	
	private String companyTitle;
	private String imageUrl;
	
	
	public CompanyCard(String companyTitle, String imageUrl) {
		this.companyTitle = companyTitle;
		this.imageUrl = imageUrl;
	}
	
	public CompanyCard() {
		
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
	
	
	
	
	
	

}
