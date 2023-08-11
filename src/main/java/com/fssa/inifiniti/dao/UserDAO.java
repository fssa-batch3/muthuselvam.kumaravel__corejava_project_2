package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserDAO {

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
	
	

	
	public boolean insertUser(User user) throws DaoException {
		String insertQuery = "INSERT INTO user (username , email , password) VALUES (?,?,?)";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery);
				){
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPassword());
		int rows = pst.executeUpdate();
		return (rows == 1); }
		catch (SQLException e ) {
			throw new DaoException("Invalid details for register");
		}
	}
	
	
	public  User findUserByEmail(String email) throws  DaoException {
		User user = new User();
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (
			
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setLoggedIn(rs.getBoolean("logged_in"));
                   }
        return user;
		} catch (SQLException e) {
			throw new DaoException("Cannot find email by user");
			
		}
	}
	
	
	public  boolean emailAlreadyExists(String email) throws  InvalidUserException {
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
       
		} catch (SQLException e) {
			throw new InvalidUserException("Invalid in Email Already Exists");
			
		}
	}
	
	public  boolean setLoggedIn(String email) throws InvalidUserException {
		
		String insertQuery = "UPDATE user SET logged_in ='1' WHERE email=?";
		try (
		Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		int count  = pst.executeUpdate();
		 return (count==1);
		} catch (SQLException e) {
			throw new InvalidUserException("Invalid in logging In");
		}
		
	}
	
	
	

}
