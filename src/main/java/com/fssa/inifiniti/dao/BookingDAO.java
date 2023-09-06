package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.inifiniti.App;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;

public class BookingDAO {
	
	private static final String SHUTTLE = "shuttle_id";
	private static final String SEATNO = "seat_num";
	private static final String DEST = "destination";
	private static final String USER = "username";
	private static final String EMAIL = "email";
	
	
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
			return (rows >0 );
		} catch (SQLException e) {
			throw new DaoException("Invalid in create booking");
			
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
		  if( rs.next()) {
			  return true;
		  } else {
			  throw new SQLException("Seat num already exists");
		  }
		} catch (SQLException e) {
			throw new DaoException("Seat num already exists");
			
		}
	}
	
	public  boolean seatNumAlreadyExistsInSameShuttle(int shuttleId , int seatNum) throws  DaoException {
		String insertQuery = "SELECT * FROM bookings WHERE shuttle_id=? AND seat_num=?";
		try 
			(
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery))
				{
		pst.setInt(1, shuttleId);
		pst.setInt(2, seatNum);
		ResultSet rs = pst.executeQuery();
		  if( rs.next()) {
			  throw new SQLException("Seat num already exists in this shuttle");
		  } else {
			  return true;
		  }
		} catch (SQLException e) {
			throw new DaoException(e);
			
		}
	}
	
	public  boolean shuttleIdAlreadyExists(int shuttleId ) throws  DaoException {
		String insertQuery = "SELECT * FROM shuttle WHERE shuttle_id=? ";
		try 
			(
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery))
				{
		pst.setInt(1, shuttleId);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
		} catch (SQLException e) {
			throw new DaoException("Shuttle ID num doesn't exists");
			
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
            booking.setEmail(rs.getString(EMAIL));
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
	
	public boolean editBookingByBookingId(int seatNum , String destination , int bookingId) throws DaoException {
		String insertQuery = "UPDATE  bookings  SET seat_num=?,   destination=? WHERE booking_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
		pst.setInt(1, seatNum);
		pst.setString(2, destination);
		pst.setInt(3, bookingId);
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
	
	public  boolean deleteBookingByBookingId(int bookingId) throws DaoException {
		String insertQuery = "DELETE FROM  bookings WHERE booking_id=?";
		try (
		Connection connection = App.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setInt(1, bookingId);
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e ) {
			throw new DaoException("Invalid in delete by Booking ID");
		}
	}
	
	public  List<Booking> viewBookingsByUser(Booking booking) throws DaoException {
		String insertQuery = "SELECT * FROM  bookings WHERE email = ?";
		try (
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery)){
			List<Booking> bookingListByUser = new ArrayList<>();
			pst.setString(1, booking.getEmail());
			ResultSet rs = pst.executeQuery();
			
				while (rs.next()) {
					Booking bookingObj = new Booking();
					bookingObj.setBookingId(rs.getInt("booking_id"));
					bookingObj.setUserName(rs.getString(USER));
					bookingObj.setEmail(rs.getString(EMAIL));
					bookingObj.setShuttleId(rs.getInt(SHUTTLE)); 
					bookingObj.setSeatNum(rs.getInt(SEATNO));
					bookingObj.setDestination(rs.getString(DEST));
			          bookingListByUser.add(bookingObj);
				} 
				return  bookingListByUser;
			
			
			
		} catch (SQLException e) {
			throw new DaoException("Unable to view the booking by user's email");
		}
	
		
	}
	
	public List<Booking> viewBookingsByAdmin() throws DaoException {
		String insertQuery = "SELECT * FROM  bookings";
		List<Booking> bookings = new ArrayList<Booking>();
		try (
			Connection connection = App.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery)){
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Booking booking = new Booking();
				 booking.setUserName( rs.getString(USER));
		           booking.setShuttleId(rs.getInt(SHUTTLE));
		           booking.setEmail(rs.getString(EMAIL));
		          booking.setSeatNum(rs.getInt(SEATNO));
		          booking.setDestination(rs.getString(DEST));
		          bookings.add(booking);
		           
			}
			return bookings;
		} catch (SQLException e) {
		
			throw new DaoException("Unable to view all the bookings");
		}
	
		
	}
	
	
	

}
