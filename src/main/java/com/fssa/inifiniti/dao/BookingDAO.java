package com.fssa.inifiniti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;
import com.fssa.inifiniti.validationexceptions.InvalidUserException;

public class BookingDAO {

	public boolean createBooking(Booking booking) throws DaoException{
		String insertQuery = "INSERT INTO bookings (shuttleid , username , email, destination , seat_num ) VALUES (?,?,?,?,?)";
		try(Connection connection = UserDAO.getConnection();
				PreparedStatement pst = connection.prepareStatement(insertQuery)){
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
	
	public  boolean emailAlreadyExists(String email) throws  DaoException {
		String insertQuery = "SELECT * FROM user WHERE email=?";
		try (
		Connection connection = UserDAO.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
       
		} catch (SQLException e) {
			throw new DaoException("Invalid in Email Already Exists");
			
		}
	}
	
	public  boolean seatNumAlreadyExists(int shuttleId , int seatNum) throws  DaoException {
		String insertQuery = "SELECT * FROM bookings WHERE shuttle_id=? AND seat_num=?";
		try 
			(
			Connection connection = UserDAO.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery))
				{
		pst.setInt(1, shuttleId);
		pst.setInt(2, seatNum);
		ResultSet rs = pst.executeQuery();
		 return  rs.next();
		} catch (SQLException e) {
			throw new DaoException("Invalid in seat num exists");
			
		}
	}
	
	public  Booking findUserForEditSeatNum(int shuttleId ,String email,  int seatNum ) throws  DaoException {
		Booking booking = new Booking();
		
		String insertQuery = "SELECT * FROM bookings WHERE shuttle_id=? AND seat_num=? AND email=?";
		try (
			
		Connection connection = UserDAO.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
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
			throw new DaoException(e);
			
		}
	}
	
	public boolean editBooking(Booking booking) throws DaoException {
		String insertQuery = "UPDATE  bookings  SET seat_num=?  WHERE  username=? AND email=? AND destination=? AND shuttle_id=?";
		try (
		Connection connection = UserDAO.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)
				){
		pst.setInt(1, booking.getSeatNum());
		pst.setString(2, booking.getUserName());
		pst.setString(3, booking.getEmail());
		pst.setString(4, booking.getDestination());
		pst.setInt(5, booking.getShuttle_id());
		int rows = pst.executeUpdate();
		return rows > 0 ;
		} catch (SQLException e ) {
			throw new DaoException(e);
		}
	}
	
	public  boolean deleteBooking(int shuttle_id , String email) throws DaoException {
		String insertQuery = "DELETE FROM  bookings WHERE email = ? AND shuttle_id=?";
		try (
		Connection connection = UserDAO.getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery)){
		pst.setString(1, email);
		pst.setInt(2, shuttle_id);
		int rows = pst.executeUpdate();
		return (rows == 1) ;
		} catch (SQLException e ) {
			throw new DaoException(e);
		}
	}
	
	public  boolean viewBookingsByUser(Booking booking) throws DaoException {
		String insertQuery = "SELECT * FROM  bookings WHERE email = ?";
		try (
			Connection connection = UserDAO.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery)){
			pst.setString(1, booking.getEmail());
			StringBuilder str = new StringBuilder();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				  String userName = rs.getString("username");
		           int shuttle_id= rs.getInt("shuttle_id");
		          int seat_num =rs.getInt("seat_num");
		          String destination = rs.getString("destination");
		          
		          str.append("Name: ").append(userName).append(", Shuttle ID: ").append(shuttle_id).append(", Seat NO: ").append(seat_num).append(", Destination: ").append(destination);
		            System.out.println(str);
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
	
		
	}
	
	public boolean viewBookingsByAdmin() throws DaoException {
		String insertQuery = "SELECT * FROM  bookings";
		try (
			Connection connection = UserDAO.getConnection();
			PreparedStatement pst = connection.prepareStatement(insertQuery)){
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				StringBuilder str = new StringBuilder();
				  String userName = rs.getString("username");
		           int shuttle_id= rs.getInt("shuttle_id");
		          int seat_num =rs.getInt("seat_num");
		          String destination = rs.getString("destination");
		          str.append("Name: ").append(userName).append(", Shuttle ID: ").append(shuttle_id).append(", Seat NO: ").append(seat_num).append(", Destination: ").append(destination);
		            System.out.println(str);
			}
			return true;
		} catch (SQLException e) {
		
			throw new DaoException(e);
		}
	
		
	}
	
	
	

}
