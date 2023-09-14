package com.fssa.inifiniti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.inifiniti.App;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.validation.CompanyValidator;

public class CompanyCardDAO {

	/**
	 * Inserts a new company record into the database.
	 *
	 * @param companyCard The CompanyCard object containing company information.
	 * @return True if the company is successfully inserted, false otherwise.
	 * @throws DaoException If an error occurs during the insertion process.
	 */
	
	public boolean insertCompany(CompanyCard companyCard) throws DaoException{
		String insertQuery = "INSERT INTO company (company_name , image_url) VALUES (?,?)";
		 CompanyValidator.validateName(companyCard.getCompanyTitle());
		CompanyValidator.validateUrl(companyCard.getImageUrl());
		try ( 
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery);)
		{
		pst.setString(1, companyCard.getCompanyTitle());
		pst.setString(2, companyCard.getImageUrl());
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	/**
	 * Updates an existing company record in the database.
	 *
	 * @param companyCard The CompanyCard object containing updated company information.
	 * @return True if the company is successfully updated, false otherwise.
	 * @throws DaoException If an error occurs during the update process.
	 */
	
	public boolean editCompany(CompanyCard companyCard) throws DaoException {
		String insertQuery = "UPDATE  company  SET company_name=? , image_url=? WHERE company_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
		pst.setString(1, companyCard.getCompanyTitle() );
		pst.setString(2, companyCard.getImageUrl());
		pst.setInt(3, companyCard.getCompanyId());
		int rows = pst.executeUpdate();
		return rows > 0 ;
		} catch (SQLException e ) {
			throw new DaoException(e);
		}
	} 
	
	/**
	 * Retrieves a list of all company records from the database.
	 *
	 * @return A list of CompanyCard objects representing all companies in the database.
	 * @throws DaoException If an error occurs during the retrieval process.
	 */
	
	public List<CompanyCard> viewCompany() throws DaoException {
		String insertQuery = "SELECT * FROM  company";
		  List<CompanyCard> companyCard = new ArrayList<>();
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				CompanyCard  company = new CompanyCard();
				company.setCompanyTitle(rs.getString("company_name"));
				company.setImageUrl(rs.getString("image_url"));
				company.setCompanyId(rs.getInt("company_id"));
				companyCard.add(company);
			}
		} catch (SQLException e ) {
			throw new DaoException("Unable to View the Company");
		}
		return companyCard;
	}
	
	/**
	 * Checks if a company with the given company ID already exists in the database.
	 *
	 * @param companyId The ID of the company to be checked.
	 * @return True if the company ID exists, false otherwise.
	 * @throws DaoException If an error occurs during the database query.
	 */
	
	public boolean companyIdAlreadyExists(int companyId) throws DaoException {
		String insertQuery = "SELECT * FROM company WHERE company_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
			pst.setInt(1, companyId);
			ResultSet rs = pst.executeQuery();
			 return  rs.next();
		} catch (SQLException e ) {
			throw new DaoException("Company ID Doesn't Exists");
		}
	}
	
	/**
	 * Deletes a company record from the database based on its company ID.
	 *
	 * @param companyId The ID of the company to be deleted.
	 * @return True if the company is successfully deleted, false otherwise.
	 * @throws DaoException If an error occurs during the deletion process.
	 */
	
	public  boolean deleteCompany(int companyId) throws DaoException {
		String insertQuery = "DELETE FROM  company WHERE company_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setInt(1, companyId);
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e ) {
			throw new DaoException(e);
		}
	}
	
	
	
	
}
