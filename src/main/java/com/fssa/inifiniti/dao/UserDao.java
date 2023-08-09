package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserDao {

	public static Connection getConnection() throws SQLException{

		Connection connect = null ;
        String url = "jdbc:mysql://localhost/inifiniti";
        String userName = "root";
        String passWord = "123456";
        try {
            connect = DriverManager.getConnection(url, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
        return  connect ;
	}
	
	

	
	public boolean insertUser(User user) throws SQLException {
		Connection connection = getConnection();
		String insert_query = "INSERT INTO USER (USERNAME , EMAIL , PASSWORD) VALUES (?,?,?)";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPassword());
		int rows = pst.executeUpdate();
		return (rows == 1) ;
	}
	
	
	public  User findUserByEmail(String email) throws  DaoException {
		User user = new User();
		String insert_query = "SELECT * FROM USER WHERE EMAIL=?";
		try (
			
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insert_query)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
                   }
        return user;
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
	}
	
	public  boolean emailAlreadyExists(String email) throws  InvalidUserException {
		User user = new User();
		String insert_query = "SELECT * FROM USER WHERE EMAIL=?";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insert_query)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
       
		} catch (SQLException e) {
			throw new InvalidUserException(e);
			
		}
	}
	
	
	

}
