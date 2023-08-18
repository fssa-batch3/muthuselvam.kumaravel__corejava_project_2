package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import java.text.*;
import java.time.format.DateTimeFormatter;

import com.fssa.inifiniti.model.Shuttle;

public class ShuttleDAO {

	
	public static boolean createShuttle(Shuttle shuttle) throws DaoException{
		String insertQuery = "INSERT INTO shuttle (shuttle_id , date , time ) VALUES (?,?,?)";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = dateFormat.format(shuttle.getDate());
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");  
		String time = dateFormat.format(shuttle.getTime());
		Date dateObj = new Date(00-00-0000);
		Date timeObj = new Date(00-00);
		try(Connection connection = UserDAO.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setInt(1, shuttle.getShuttleId());
			pst.setDate(2, dateObj.valueOf(date));
			pst.setDate(3, timeObj.valueOf(time));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
