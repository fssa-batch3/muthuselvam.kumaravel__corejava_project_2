package com.fssa.inifiniti.services;

import java.util.List;

import com.fssa.inifiniti.dao.BookingDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.model.User;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.BookingValidator;
import com.fssa.inifiniti.validationexceptions.ValidationException;

public class BookingService {
	
	 public static final BookingDAO bookingDao = new BookingDAO();

	 /**
	  * Registers a new booking in the system.
	  *
	  * @param booking The Booking object to be registered.
	  * @return True if the booking is successfully registered, false otherwise.
	  * @throws ServiceException If an error occurs during the registration process.
	  */ 
	  
	public static boolean registerBooking(Booking booking) throws ServiceException {

		try { 
		BookingValidator.validateBooking(booking);	
		BookingValidator.validateShuttleId(booking.getShuttleId());
		return 	bookingDao.shuttleIdAlreadyExists(booking.getShuttleId()) &&
			    bookingDao.seatNumAlreadyExistsInSameShuttle(booking.getShuttleId(), booking.getSeatNum()) && 
				bookingDao.createBooking(booking);
		} 
		 catch (DaoException  | ValidationException e) { 
			throw new ServiceException(e.getMessage());
		}
	} 
	
	/**
	 * Updates an existing booking in the system with a new seat number.
	 *
	 * @param shuttleId The ID of the shuttle for the booking.
	 * @param email The email of the user making the booking.
	 * @param seatNum The current seat number to be updated.
	 * @param changeSeatNum The new seat number to replace the current one.
	 * @return True if the booking is successfully updated, false otherwise.
	 * @throws ServiceException If an error occurs during the update process.
	 */
	
	public static boolean updateBooking(int shuttleId , String email , int seatNum , int changeSeatNum) throws ServiceException {
		try {
		BookingValidator.validateSeatNum(seatNum);	
		BookingValidator.validateSeatNum(changeSeatNum);
		BookingValidator.validateShuttleId(shuttleId);
		if(bookingDao.shuttleIdAlreadyExists(shuttleId) && BookingValidator.validateEmail(email)) {
			Booking booking = bookingDao.findUserForEditSeatNum(shuttleId, email, seatNum);
			booking.setSeatNum(changeSeatNum);
			bookingDao.editBooking(booking);
			return true;
		}  
		return false;
		}
		 catch (DaoException | ValidationException  e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Updates an existing booking in the system by booking ID with a new seat number and destination.
	 *
	 * @param bookingId The ID of the booking to be updated.
	 * @param destination The new destination for the booking.
	 * @param seatNum The new seat number to replace the current one.
	 * @param shuttleId The ID of the shuttle for the booking.
	 * @return True if the booking is successfully updated, false otherwise.
	 * @throws ServiceException If an error occurs during the update process.
	 */
	
	public boolean updateBookingByBookingId(int bookingId , String destination , int seatNum , int shuttleId) throws ServiceException {
		try {
		BookingValidator.validateSeatNum(seatNum);	
		BookingValidator.validateDestination(destination);	
		BookingValidator.validateShuttleId(shuttleId);
			return bookingDao.seatNumAlreadyExistsInSameShuttle(shuttleId, seatNum) && 				  				 					 				   bookingDao.editBookingByBookingId(seatNum, destination, bookingId);
		}
		 catch (DaoException | ValidationException  e) {
			throw new ServiceException(e.getMessage());
		}
	}
 
	/**
	 * Deletes a booking from the system based on user email and shuttle ID.
	 *
	 * @param booking The Booking object containing email and shuttle ID for deletion.
	 * @return True if the booking is successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs during the deletion process.
	 */
	
	public static boolean deleteBooking(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail()) && BookingValidator.validateShuttleId(booking.getShuttleId())) {
			bookingDao.shuttleIdAlreadyExists(booking.getShuttleId());
			bookingDao.deleteBooking(booking.getShuttleId(),booking.getEmail());
			return true;
		}
		return false;
		}
		 catch (DaoException | ValidationException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Deletes a booking from the system by booking ID.
	 *
	 * @param bookingId The ID of the booking to be deleted.
	 * @return True if the booking is successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs during the deletion process.
	 */
	
	public static boolean deleteBookingByBookingId(int bookingId) throws ServiceException {
		try {
			return bookingDao.deleteBookingByBookingId(bookingId);
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Retrieves a list of bookings by user email.
	 *
	 * @param booking The Booking object containing the user's email.
	 * @return A list of Booking objects associated with the user's email.
	 * @throws ServiceException If an error occurs during the retrieval process.
	 */
	
	public List<Booking> readBookingByUser(Booking booking) throws ServiceException {
		try {
			if( BookingValidator.validateEmail(booking.getEmail())) {
			return  bookingDao.viewBookingsByUser(booking);
			} else {
				throw new DaoException("Invalid Email");
			}
			
		} 
		
		 catch (DaoException | ValidationException e) {
			throw new ServiceException(e);
		}
		
	}
	
	/**
	 * Retrieves a list of all bookings in the system, intended for use by administrators.
	 *
	 * @return A list of Booking objects representing all bookings in the system.
	 * @throws ServiceException If an error occurs during the retrieval process.
	 */
	
	public  List<Booking> readBookingByAdmin() throws ServiceException {
		try {
		return bookingDao.viewBookingsByAdmin();
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}
	
	public  List<Integer> readSeatNumByshuttleId(int shuttleId) throws ServiceException {
		try {
		return bookingDao.readSeatNumByShuttleId(shuttleId);
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}
	
	
	public  boolean registerBookingWithUserId(Booking booking) throws ServiceException {

		try { 
			UserService userService = new UserService();
			User user = new User();
			User user2 = new User();
		BookingValidator.validateEmail(booking.getEmail());	
		BookingValidator.validateDestination(booking.getDestination());
		Booking bookingObj = new Booking();
		bookingObj.setEmail(booking.getEmail());
		bookingObj.setDestination(booking.getDestination());
		bookingObj.setSeatNum(booking.getSeatNum());
		bookingObj.setShuttleId(booking.getShuttleId());
		user = userService.findUserNameByEmail(booking.getEmail());
		bookingObj.setUserName(user.getUserName());
		user2 = userService.getUserIdByEmail(booking.getEmail());
		bookingObj.setUserId(user2.getId());
		return  bookingDao.createBookingWithUserId(bookingObj);
		} 
		 catch (DaoException  | ValidationException e) { 
			throw new ServiceException(e.getMessage());
		}
	} 

}
