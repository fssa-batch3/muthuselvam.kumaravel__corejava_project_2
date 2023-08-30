package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.inifiniti.App;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;

public class BookingDAO {
	
	private static final String SHUTTLE = "shuttle_id";
	private static final String SEATNO = "seat_num";
	private static final String DEST = "destination";
	private static final String USER = "username";

	public boolean createBooking(Booking booking) throws DaoException{
		String insertQuery = "INSERT INTO bookings (shuttle_id , username , email, destination , seat_num ) VALUES (?,?,?,?,?)";
		try(Connection connection = App.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setInt(1, booking.getShuttleId());
			pst.setString(2, booking.getUserName());
			pst.setString(3, booking.getEmail());
			pst.setString(4, booking.getDestination());
			pst.setInt(5, booking.getSeatNum());
			int rows = pst.executeUpdate();
			return (rows == 1) ;
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
		
	}
	
	public  boolean emailAlreadyExists(String email) throws  DaoException {
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
       
		} catch (SQLException e) {
			throw new DaoException("Email Already Exists");
			
		}
	}
	
	public  boolean seatNumAlreadyExists(int shuttleId , int seatNum) throws  DaoException {
		String insertQuery = "SELECT * FROM bookings WHERE shuttle_id=? AND seat_num=?";
		try 
			(
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery))
				{
		pst.setInt(1, shuttleId);
		pst.setInt(2, seatNum);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
		} catch (SQLException e) {
			throw new DaoException("Seat num exists");
			
		}
	}
	
	public  Booking findUserForEditSeatNum(int shuttleId ,String email,  int seatNum ) throws  DaoException {
		Booking booking = new Booking();
		
		String insertQuery = "SELECT * FROM bookings WHERE shuttle_id=? AND seat_num=? AND email=?";
		try (
			
		Connection connection = App.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setInt(1, shuttleId);
		pst.setInt(2, seatNum);
		pst.setString(3, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            booking.setEmail(rs.getString("email"));
            booking.setShuttleId(rs.getInt(SHUTTLE));
            booking.setSeatNum(rs.getInt(SEATNO));
            booking.setDestination(rs.getString(DEST));
            booking.setUserName(rs.getString(USER));
                   }
        return booking;
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
	}
	
	public boolean editBooking(Booking booking) throws DaoException {
		String insertQuery = "UPDATE  bookings  SET seat_num=?  WHERE  username=? AND email=? AND destination=? AND shuttle_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
		pst.setInt(1, booking.getSeatNum());
		pst.setString(2, booking.getUserName());
		pst.setString(3, booking.getEmail());
		pst.setString(4, booking.getDestination());
		pst.setInt(5, booking.getShuttleId());
		int rows = pst.executeUpdate();
		return rows > 0 ;
		} catch (SQLException e ) {
			throw new DaoException(e);
		}
	}
	
	public  boolean deleteBooking(int shuttleId , String email) throws DaoException {
		String insertQuery = "DELETE FROM  bookings WHERE email = ? AND shuttle_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		pst.setInt(2, shuttleId);
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e ) {
			throw new DaoException(e);
		}
	}
	
	public  boolean viewBookingsByUser(Booking booking) throws DaoException {
		String insertQuery = "SELECT * FROM  bookings WHERE email = ?";
		try (
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setString(1, booking.getEmail());
			StringBuilder str = new StringBuilder();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				  String userName = rs.getString(USER);
		           int shuttleId= rs.getInt(SHUTTLE);
		          int seatNum =rs.getInt(SEATNO);
		          String destination = rs.getString(DEST);
		          
		          str.append("Name: ").append(userName).append(", Shuttle ID: ").append(shuttleId).append(", Seat NO: ").append(seatNum).append(", Destination: ").append(destination);
		 
			}
			return true;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	
		
	}
	
	public boolean viewBookingsByAdmin() throws DaoException {
		String insertQuery = "SELECT * FROM  bookings";
		try (
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery)){
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				StringBuilder str = new StringBuilder();
				  String userName = rs.getString(USER);
		           int shuttleId= rs.getInt(SHUTTLE);
		          int seatNum =rs.getInt(SEATNO);
		          String destination = rs.getString(DEST);
		          str.append("Name: ").append(userName).append(", Shuttle ID: ").append(shuttleId).append(", Seat NO: ").append(seatNum).append(", Destination: ").append(destination);
		           
			}
			return true;
		} catch (SQLException e) {
		
			throw new DaoException(e);
		}
	
		
	}
	
	
	

}
