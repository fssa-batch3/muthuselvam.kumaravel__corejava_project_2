package inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import inifiniti.model.Booking;
import inifiniti.model.User;
import inifiniti.validationexceptions.InvalidUserException;

public class BookingDao {

	public boolean insertBooking(Booking booking) throws SQLException {
		UserDao userDao = new UserDao();
		Connection connection = userDao.getConnection();
		String insert_query = "INSERT INTO BOOKINGS (SHUTTLE_ID , USERNAME , EMAIL, DESTINATION , SEAT_NUM ) VALUES (?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setInt(1, booking.getShuttle_id());
		pst.setString(2, booking.getUserName());
		pst.setString(3, booking.getEmail());
		pst.setString(4, booking.getDestination());
		pst.setInt(5, booking.getSeatNum());
		int rows = pst.executeUpdate();
		return (rows == 1) ;
	}
	
	public  boolean seatNumAlreadyExists(int shuttleId , int seatNum) throws  InvalidUserException {
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
			throw new InvalidUserException(e);
			
		}
	}
	
	public  Booking findUserForEditSeatNum(int shuttleId ,String email,  int seatNum ) throws  InvalidUserException {
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
			throw new InvalidUserException(e);
			
		}
	}
	
	public boolean inserteditBooking(Booking booking) throws InvalidUserException {
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
			throw new InvalidUserException(e);
		}
	}
	
	
	

}
