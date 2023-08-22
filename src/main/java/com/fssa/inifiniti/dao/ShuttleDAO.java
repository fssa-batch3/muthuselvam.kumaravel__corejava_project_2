package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;

import com.fssa.inifiniti.model.Shuttle;

public class ShuttleDAO {

	
	public static boolean createShuttle(Shuttle shuttle) throws DaoException{
		String insertQuery = "INSERT INTO shuttle (shuttle_id , date , time ) VALUES (?,?,?)";
		
		try(Connection connection = UserDAO.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setInt(1, shuttle.getShuttleId());
			int rows = pst.executeUpdate();
			return (rows == 1) ;
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
		
	}
	
	public static void main(String[] args) {
		Shuttle shuttle = new Shuttle(1,"18/08/2023","10:45");
		try {
			 createShuttle(shuttle);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
}
