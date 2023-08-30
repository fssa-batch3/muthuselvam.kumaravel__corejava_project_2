package com.fssa.inifiniti.model;

public class CompanyCard {

	
	
	

	private int companyId;
	private String companyTitle;
	private String imageUrl;
	
	
	public CompanyCard(String companyTitle, String imageUrl) {
		this.companyTitle = companyTitle;
		this.imageUrl = imageUrl;
	}
	public CompanyCard(String companyTitle,String imageUrl, int companyId ) {
		super();
		this.companyTitle = companyTitle;
		this.companyId = companyId ;
		this.imageUrl = imageUrl;
	}
	public CompanyCard(int companyId) {
		super();
		this.companyId = companyId;
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
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	@Override
	public String toString() {
		return "CompanyCard [companyId=" + companyId + ", companyTitle=" + companyTitle + ", imageUrl=" + imageUrl
				+ "]";
	}
	
	
	
	

}
