package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.inifiniti.App;
import com.fssa.inifiniti.dao.exceptions.DaoException;

import com.fssa.inifiniti.model.Shuttle;

public class ShuttleDAO {

	public  boolean createShuttle(Shuttle shuttle) throws DaoException{
		String insertQuery = "INSERT INTO shuttle (shuttle_id ,company_name ,  date , time ) VALUES (?,?,?,?)";
		try(Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setInt(1, shuttle.getShuttleId());
			pst.setString(2, shuttle.getCompanyName());
			pst.setString(3, shuttle.getDate());
			pst.setString(4, shuttle.getTime());
			int rows = pst.executeUpdate();
			return (rows == 1) ;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}
	
	
}
