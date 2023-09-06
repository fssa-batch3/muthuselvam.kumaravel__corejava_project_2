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
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class UserDAO {

	
	private static final String SQLINSERTQUERY = "SELECT * FROM user WHERE email=?";

	
	public boolean insertUser(User user) throws DaoException {
		String insertQuery = "INSERT INTO user (username , email , password) VALUES (?,?,?)";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery);
				){
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getEmail());
		pst.setString(3, user.getPassword());
		int rows = pst.executeUpdate();
		if (rows == 1){
			return true;
		} else {
			throw new DaoException("Invalid details for register");
		}
		}
		catch (SQLException e ) {
			throw new DaoException(e);
		}
	}
	
	
	public  User findUserByEmail(String email) throws  DaoException {
		User user = new User();
		String insertQuery = SQLINSERTQUERY;
		try (
			
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setLoggedIn(rs.getBoolean("logged_in"));
                   } else {
                	   throw new DaoException("Email is not registered");
                   }
        return user;
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
	}
	
	public  User findUserNameByEmail(String email) throws  DaoException {
		User user = new User();
		String insertQuery = SQLINSERTQUERY;
		try (
			
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            user.setUserName(rs.getString("username"));
                   }
        return user;
		} catch (SQLException e) {
			throw new DaoException("Username Doesn't Exists");
			
		}
	}
	
	
	public  boolean emailAlreadyExists(String email) throws  DaoException {
		String insertQuery = SQLINSERTQUERY;
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		 if(  rs.next()) {
			 throw new DaoException("Email Already Exists"); 
		 } else {
			 return true;
		 }
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
	}
	
	public List<User> viewAllUser() throws DaoException {
		String insertQuery = "SELECT * FROM  user";
		  List<User> users = new ArrayList<>();
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				User  user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));			
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e ) {
			throw new DaoException("Unable to View the user");
		}
		return users;
	}
	
	
	
public  boolean setLoggedIn(String email) throws DaoException {
		
		String insertQuery = "UPDATE user SET logged_in ='1' WHERE email=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		int count  = pst.executeUpdate();
		 if (count==1) {
			 return true;
		 } else {
			 throw new DaoException("Invalid in logging In");
		 }
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}
	
	
	

}
