package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;

public class BookingDao {

	public boolean insertBooking(Booking booking) throws DaoException{
		UserDao userDao = new UserDao();
		try(Connection connection = userDao.getConnection()){
			String insert_query = "INSERT INTO BOOKINGS (SHUTTLE_ID , USERNAME , EMAIL, DESTINATION , SEAT_NUM ) VALUES (?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(insert_query);
			pst.setInt(1, booking.getShuttle_id());
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
	
	public  boolean seatNumAlreadyExists(int shuttleId , int seatNum) throws  InvalidBookingException {
		try {
			Booking booking = new Booking();
			UserDao userdao = new UserDao();
		Connection connection = userdao.getConnection();
		String insert_query = "SELECT * FROM BOOKINGS WHERE SHUTTLE_ID=? AND SEAT_NUM=?";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setInt(1, shuttleId);
		pst.setInt(2, seatNum);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
		} catch (SQLException e) {
			throw new InvalidBookingException(e);
			
		}
	}
	
	public  Booking findUserForEditSeatNum(int shuttleId ,String email,  int seatNum ) throws  InvalidBookingException {
		try {
			Booking booking = new Booking();
			UserDao userdao = new UserDao();
		Connection connection = userdao.getConnection();
		String insert_query = "SELECT * FROM BOOKINGS WHERE SHUTTLE_ID=? AND SEAT_NUM=? AND EMAIL=?";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setInt(1, shuttleId);
		pst.setInt(2, seatNum);
		pst.setString(3, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
            booking.setEmail(rs.getString("email"));
            booking.setShuttle_id(rs.getInt("shuttle_id"));
            booking.setSeatNum(rs.getInt("seat_num"));
            booking.setDestination(rs.getString("destination"));
            booking.setUserName(rs.getString("username"));
                   }
        return booking;
		} catch (SQLException e) {
			throw new InvalidBookingException(e);
			
		}
	}
	
	public boolean inserteditBooking(Booking booking) throws InvalidBookingException {
		UserDao userDao = new UserDao();
		try {
		Connection connection = userDao.getConnection();
		String insert_query = "UPDATE  BOOKINGS " + "  SET SEAT_NUM=? " + " WHERE  USERNAME=? " + "AND EMAIL=? " + "AND DESTINATION=?"+"AND SHUTTLE_ID=?";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setInt(1, booking.getSeatNum());
		pst.setString(2, booking.getUserName());
		pst.setString(3, booking.getEmail());
		pst.setString(4, booking.getDestination());
		pst.setInt(5, booking.getShuttle_id());
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e ) {
			throw new InvalidBookingException(e);
		}
	}
	
	public static boolean deleteBooking(int shuttle_id , String email) throws InvalidBookingException {
		UserDao userDao = new UserDao();
		try {
		Connection connection = userDao.getConnection();
		String insert_query = "DELETE FROM  BOOKINGS WHERE EMAIL = ? AND SHUTTLE_ID=?";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setString(1, email);
		pst.setInt(2, shuttle_id);
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e ) {
			throw new InvalidBookingException(e);
		}
	}
	
	public static String viewBookingsByUser(Booking booking) throws InvalidBookingException {
		Booking bookingSet = new Booking();
		try {
			Connection connection = UserDao.getConnection();
			String insert_query = "SELECT * FROM  BOOKINGS WHERE EMAIL = ?";
			PreparedStatement pst = connection.prepareStatement(insert_query);
			pst.setString(1, booking.getEmail());
			StringBuilder str = new StringBuilder();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				  String userName = rs.getString("username");
		           int shuttle_id= rs.getInt("shuttle_id");
		          int seat_num =rs.getInt("seat_num");
		          String destination = rs.getString("destination");
		          
		          str.append("Name: ").append(userName).append(", Shuttle ID: ").append(shuttle_id).append(", Seat NO:").append(seat_num).append(", Destination").append(destination);
		            
			}
			return str.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new InvalidBookingException(e);
		}
	
		
	}
	
	
	

}
