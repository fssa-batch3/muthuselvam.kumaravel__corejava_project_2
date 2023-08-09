package com.fssa.inifiniti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.inifiniti.model.CompanyCard;

public class CompanyDao {

//	public boolean insertCompany(CompanyCard companyCard) throws SQLException {
//		UserDao userDao = new UserDao();
//		try (
//		Connection connection = userDao.getConnection();
//		String insert_query = "INSERT INTO COMPANYCARD (COMPANY_TITLE , IMAGE_URL , IS_EDIT , IS_DELETED) VALUES (?,?,?,?)";
//		PreparedStatement pst = connection.prepareStatement(insert_query)){
//		pst.setString(1, companyCard.getCompanyTitle());
//		pst.setString(2, companyCard.getImageUrl());
//		pst.setString(3, companyCard.isEdit());
//		pst.setString(4, companyCard.isDeleted());
//		int rows = pst.executeUpdate();
//		return (rows == 1) ;
//		} catch () {
//			
//			
//		}
//	}
//	
}
