package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.inifiniti.App;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Shuttle;

public class ShuttleDAO {

	/**
	 * Inserts a new shuttle record into the database.
	 *
	 * @param shuttle The Shuttle object containing shuttle details to be inserted.
	 * @return True if the shuttle creation is successful, false otherwise.
	 * @throws DaoException If an error occurs during the insertion process.
	 */
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
	
	/**
	 * Retrieves a list of shuttle times and dates for a specific company from the database.
	 *
	 * @param title The company name for which shuttle times and dates are to be retrieved.
	 * @return A list of Shuttle objects representing time and date information for the company's shuttles.
	 * @throws DaoException If an error occurs during the retrieval process.
	 */
	
	public List<Shuttle> viewShuttleTimeAndDate(String title) throws DaoException {
		String insertQuery = "SELECT time , date FROM  shuttle where company_name=?";
		  List<Shuttle> shuttleList = new ArrayList<>();
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
			pst.setString(1,title);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Shuttle  shuttle = new Shuttle();
				shuttle.setDate(rs.getString("date"));
				shuttle.setTime(rs.getString("time"));
				shuttleList.add(shuttle);
			}
		} catch (SQLException e ) {
			throw new DaoException("Unable to View the time and date of shuttle");
		}
		return shuttleList;
	}
	
	/**
	 * Retrieves the shuttle ID based on the specified date, time, and company name.
	 *
	 * @param date        The date of the shuttle.
	 * @param time        The time of the shuttle.
	 * @param companyName The name of the company associated with the shuttle.
	 * @return A Shuttle object containing the shuttle ID.
	 * @throws DaoException If an error occurs during the retrieval process or if the company name is incorrect.
	 */
	
	public  Shuttle getIdByShuttleDateAndTime(String date ,String time , String companyName) throws DaoException{
		String insertQuery = "SELECT shuttle_id from shuttle where date=? and time=? and company_name=?";
		try(Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setString(1, date);
			pst.setString(2, time);
			pst.setString(3, companyName);
			ResultSet rs = pst.executeQuery();
			Shuttle  shuttle = new Shuttle();
			while (rs.next()) {
				shuttle.setShuttleId(rs.getInt("shuttle_id"));
			}
			return shuttle;
		} catch (SQLException e) {
			throw new DaoException("Please enter Correct company name");
		}
		
		
	}
	
	
}
