package inifiniti.dao;
import inifiniti.dao.UserDao;
import inifiniti.model.CompanyCard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import inifiniti.dao.exceptions.*;
import inifiniti.model.User;
import java.sql.ResultSet;

public class CompanyDao {

	public boolean insertCompany(CompanyCard companyCard) throws SQLException {
		UserDao userDao = new UserDao();
		Connection connection = userDao.getConnection();
		String insert_query = "INSERT INTO COMPANYCARD (COMPANY_TITLE , IMAGE_URL , IS_EDIT , IS_DELETED) VALUES (?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setString(1, companyCard.getCompanyTitle());
		pst.setString(2, companyCard.getImageUrl());
		pst.setString(3, companyCard.isEdit());
		pst.setString(4, companyCard.isDeleted());
		int rows = pst.executeUpdate();
		return (rows == 1) ;
	}
	
}
