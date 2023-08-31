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
			throw new DaoException(e);
		}
		return companyCard;
	}
	
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
