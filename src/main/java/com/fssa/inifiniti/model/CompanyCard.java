package com.fssa.inifiniti.model;

/**
 * The CompanyCard class represents a company card with information such as company title and image URL.
 */

public class CompanyCard {

	/**
	 * The unique identifier of the company card.
	 */
	private int companyId;
	/**
	 * The title or name of the company.
	 */
	private String companyTitle;
	/**
	 * The URL of the company's image/logo.
	 */
	private String imageUrl;
	
	/**
	 * Constructs a new CompanyCard with the specified company title and image URL.
	 *
	 * @param companyTitle The title or name of the company.
	 * @param imageUrl     The URL of the company's image/logo.
	 */
	
	public CompanyCard(String companyTitle, String imageUrl) {
		this.companyTitle = companyTitle;
		this.imageUrl = imageUrl;
	}
	
	/**
	 * Constructs a new CompanyCard with the specified company title, image URL, and company ID.
	 *
	 * @param companyTitle The title or name of the company.
	 * @param imageUrl     The URL of the company's image/logo.
	 * @param companyId    The unique identifier of the company card.
	 */
	
	public CompanyCard(String companyTitle,String imageUrl, int companyId ) {
		super();
		this.companyTitle = companyTitle;
		this.companyId = companyId ;
		this.imageUrl = imageUrl;
	} 
	
	/**
	 * Constructs a new CompanyCard with the specified company ID.
	 *
	 * @param companyId The unique identifier of the company card.
	 */
	
	public CompanyCard(int companyId) {
		super();
		this.companyId = companyId;
	}
	
	/**
	 * Default constructor for CompanyCard.
	 */
	
	public CompanyCard() {
		
	}

	/**
	 * Gets the company title.
	 *
	 * @return The title or name of the company.
	 */
	
	public String getCompanyTitle() {
		return companyTitle;
	}
	
	/**
	 * Sets the company title.
	 *
	 * @param companyTitle The title or name of the company.
	 */
	
	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}
	
	/**
	 * Gets the image URL of the company.
	 *
	 * @return The URL of the company's image/logo.
	 */
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	/**
	 * Sets the image URL of the company.
	 *
	 * @param imageUrl The URL of the company's image/logo.
	 */
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	/**
	 * Gets the unique identifier of the company card.
	 *
	 * @return The unique identifier of the company card.
	 */
	
	public int getCompanyId() {
		return companyId;
	}
	
	/**
	 * Sets the unique identifier of the company card.
	 *
	 * @param companyId The unique identifier of the company card.
	 */
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * Returns a string representation of the CompanyCard object.
	 *
	 * @return A string containing the company's information.
	 */
	@Override
	public String toString() {
		return "CompanyCard [companyId=" + companyId + ", companyTitle=" + companyTitle + ", imageUrl=" + imageUrl
				+ "]";
	}
	
	
	
	

}
