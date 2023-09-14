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

/**
 * This class provides data access methods related to bookings.
 */

public class BookingDAO {
	 // Constants for column names in the database
	private static final String SHUTTLE = "shuttle_id";
	private static final String SEATNO = "seat_num";
	private static final String DEST = "destination";
	private static final String USER = "username";
	private static final String EMAIL = "email";
	
	 /**
     * Creates a new booking record in the database.
     *
     * @param booking The booking object to be created.
     * @return True if the booking was successfully created, false otherwise.
     * @throws DaoException If an error occurs during database interaction.
     */
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
	
	 /**
     * Checks if an email address already exists in the user table.
     *
     * @param email The email address to check.
     * @return True if the email address already exists, false otherwise.
     * @throws DaoException If an error occurs during database interaction.
     */
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
	 /**
     * Checks if a seat number already exists in the bookings table.
     *
     * @param shuttleId The shuttle ID.
     * @param seatNum   The seat number to check.
     * @return True if the seat number already exists, false otherwise.
     * @throws DaoException If an error occurs during database interaction.
     */
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
	
	/**
	 * Checks if a seat number already exists in the same shuttle.
	 *
	 * @param shuttleId The ID of the shuttle to check.
	 * @param seatNum   The seat number to check.
	 * @return True if the seat number already exists in the same shuttle, false otherwise.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
			throw new DaoException(e.getMessage());
		}
	}
	
	/**
	 * Checks if a shuttle ID already exists in the database.
	 *
	 * @param shuttleId The ID of the shuttle to check.
	 * @return True if the shuttle ID already exists, false otherwise.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Retrieves booking information for a specific user with a given shuttle ID, email, and seat number.
	 *
	 * @param shuttleId The ID of the shuttle.
	 * @param email     The email address of the user.
	 * @param seatNum   The seat number to search for.
	 * @return A Booking object containing the user's booking information, or null if not found.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Updates the seat number of a booking for a specific user with matching username, email, destination, and shuttle ID.
	 *
	 * @param booking The Booking object containing the updated seat number and identification information.
	 * @return True if the booking was successfully updated, false otherwise.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Updates the seat number and destination of a booking by its booking ID.
	 *
	 * @param seatNum     The new seat number for the booking.
	 * @param destination The new destination for the booking.
	 * @param bookingId   The unique ID of the booking to be updated.
	 * @return True if the booking was successfully updated, false otherwise.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Deletes a booking with a specific email address and shuttle ID.
	 *
	 * @param shuttleId The ID of the shuttle associated with the booking to be deleted.
	 * @param email     The email address of the user associated with the booking to be deleted.
	 * @return True if the booking was successfully deleted, false otherwise.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Deletes a booking by its unique booking ID.
	 *
	 * @param bookingId The unique ID of the booking to be deleted.
	 * @return True if the booking was successfully deleted, false otherwise.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Retrieves a list of bookings associated with a specific user's email address.
	 *
	 * @param booking The Booking object containing the user's email address.
	 * @return A list of Booking objects representing the bookings associated with the user.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
	
	/**
	 * Retrieves a list of all bookings in the system, intended for use by administrators.
	 *
	 * @return A list of Booking objects representing all bookings in the system.
	 * @throws DaoException If an error occurs during database interaction.
	 */
	
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
