package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.validation.CompanyValidator;

public class CompanyDao {

	public boolean insertCompany(CompanyCard companyCard) throws DaoException {
		String insert_query = "INSERT INTO COMPANY (COMPANY_NAME , IMAGE_URL) VALUES (?,?)";
		CompanyValidator.validateName(companyCard.getCompanyTitle());
		CompanyValidator.validateUrl(companyCard.getImageUrl());
		try (
		Connection connection = UserDao.getConnection();
		PreparedStatement pst = connection.prepareStatement(insert_query);)
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
