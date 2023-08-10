package com.fssa.inifiniti.services;

import com.fssa.inifiniti.dao.BookingDao;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Booking;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.BookingValidator;
import com.fssa.inifiniti.validation.UserValidator;
import com.fssa.inifiniti.validationexceptions.InvalidBookingException;

public class BookingService {

	public static boolean registerBooking(Booking booking) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		try {
		BookingValidator.ValidateBooking(booking);	
		if(bookingdao.seatNumAlreadyExists(booking.getShuttle_id(), booking.getSeatNum())== true) {
			System.out.println("Seat num already exists");
			return false;
		} else {
			if( bookingdao.createBooking(booking)){
				System.out.println(booking.getUserName() +" and seat num: "+ booking.getSeatNum() + " successful");
				return true;
			} else {
				System.out.println("booking not successful");
				return false;
			}
		} 
		
		}
		 catch (DaoException  | InvalidBookingException e) {
			
			throw new ServiceException(e);
		}
	}
	
	public static boolean updateBooking(int shuttle_id , String email , int seatNum , int changeSeatNum) throws ServiceException {
		BookingDao bookingdao =  new BookingDao();
		try {
		BookingValidator.validateSeatNum(seatNum);	
		BookingValidator.validateSeatNum(changeSeatNum);
		if(BookingValidator.validateEmail(email)) {
			Booking booking = bookingdao.findUserForEditSeatNum(shuttle_id, email, seatNum);
			booking.setSeatNum(changeSeatNum);
			bookingdao.editBooking(booking);
			System.out.println("Edit Seat Num : Successful");
			return true;
		} else {
				System.out.println("Edit Seat Num : Not Successful");
				return false;
		}
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}

	
	
	public static boolean deleteBooking(Booking booking) throws ServiceException {
		try {
		if(BookingValidator.validateEmail(booking.getEmail())) {
			BookingDao.deleteBooking(booking.getShuttle_id(),booking.getEmail());
			System.out.println("Delete Booking : Successful");
			return true;
		} else {
				System.out.println("Delete Booking : Not Successful");
				return false;
		}
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}

	
	public static boolean readBookingByUser(Booking booking) throws ServiceException {
		try {
		if(UserValidator.validateEmail(booking.getEmail())) {
			BookingDao.viewBookingsByUser(booking);
			System.out.println("Booking History - User: Successful");
			return true;
		} else {
				System.out.println("Booking History - User: Not Successful");
				return false;
		}
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}
	
	public static boolean readBookingByAdmin() throws ServiceException {
		try {
			BookingDao.viewBookingsByAdmin();
			System.out.println("Booking History - Admin: Successful");
			return true;
		}
		 catch (InvalidBookingException e) {
			throw new ServiceException(e);
		}
	}

}
