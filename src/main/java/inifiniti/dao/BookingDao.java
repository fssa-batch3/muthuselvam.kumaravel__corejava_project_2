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
		String insert_query = "INSERT INTO BOOKINGS (SHUTTLE_ID , USERNAME , DESTINATION , SEAT_NUM ) VALUES (?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(insert_query);
		pst.setInt(1, booking.getShuttle_id());
		pst.setString(2, booking.getUserName());
		pst.setString(3, booking.getDestination());
		pst.setInt(4, booking.getSeatNum());
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
	
	
	

}
