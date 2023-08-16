package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.validation.CompanyValidator;
import com.fssa.inifiniti.validationexceptions.InvalidCompanyException;

public class CompanyDAO {

	public boolean insertCompany(CompanyCard companyCard) throws DaoException, InvalidCompanyException {
		String insertQuery = "INSERT INTO company (company_name , image_url) VALUES (?,?)";
		 CompanyValidator.validateName(companyCard.getCompanyTitle());
		CompanyValidator.validateUrl(companyCard.getImageUrl());
		try ( 
		Connection connection = UserDAO.getConnection();
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
	
	
	
}
