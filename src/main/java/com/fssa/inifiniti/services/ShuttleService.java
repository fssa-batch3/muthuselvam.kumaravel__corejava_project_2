package com.fssa.inifiniti.services;

import java.util.List;

import com.fssa.inifiniti.dao.ShuttleDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.ShuttleValidator;
import com.fssa.inifiniti.validationexceptions.InvalidShuttleException;

public class ShuttleService {
	
	 public static final ShuttleDAO shuttleDao = new ShuttleDAO();

	 /**
	  * Registers a new shuttle service in the system.
	  *
	  * @param shuttle The Shuttle object containing shuttle details to be registered.
	  * @return True if the shuttle registration is successful, false otherwise.
	  * @throws ServiceException If an error occurs during the registration process or if the shuttle details are invalid.
	  */
		public  boolean registerShuttle(Shuttle shuttle) throws ServiceException {
 
			try {
			ShuttleValidator.validateShuttle(shuttle);
				return shuttleDao.createShuttle(shuttle); 
			}
			 catch (DaoException  | InvalidShuttleException e) {
				
				throw new ServiceException(e);
			}
		}

		/**
		 * Retrieves a list of shuttle times and dates for a specific company.
		 *
		 * @param name The name of the company for which shuttle times and dates are to be retrieved.
		 * @return A list of Shuttle objects representing time and date information for the company's shuttles.
		 * @throws ServiceException If an error occurs during the retrieval process.
		 */
		public  List<Shuttle> readShuttleTimeAndDate(String name) throws ServiceException {
			try {
				ShuttleDAO shuttleDAO = new ShuttleDAO();
				return shuttleDAO.viewShuttleTimeAndDate(name);
			}
			 catch (DaoException  e) {
				throw new ServiceException(e);
			}
		}
		
		/**
		 * Retrieves the shuttle ID based on the specified date, time, and company name.
		 *
		 * @param date The date of the shuttle.
		 * @param time The time of the shuttle.
		 * @param name The name of the company associated with the shuttle.
		 * @return A Shuttle object containing the shuttle ID.
		 * @throws ServiceException If an error occurs during the retrieval process or if the company name is incorrect.
		 */
		public  Shuttle readIdByShuttleTimeAndDateAndCompanyName(String date , String time , String name) throws ServiceException {
			try {
				ShuttleDAO shuttleDAO = new ShuttleDAO();
				return shuttleDAO.getIdByShuttleDateAndTime(date, time, name);
			}
			 catch (DaoException  e) {
				throw new ServiceException(e);
			}
		}
		
		
		public  List<Shuttle> readAllTime() throws ServiceException {
			try {
				ShuttleDAO shuttleDAO = new ShuttleDAO();
				return shuttleDAO.getAllTime();
			}
			 catch (DaoException  e) {
				throw new ServiceException(e);
			}
		}
		
		public  List<String> readTimeByCompanyDate(String company , String date) throws ServiceException {
			try {
				ShuttleDAO shuttleDAO = new ShuttleDAO();
				return shuttleDAO.viewTimeByCompanyAndDate(company , date);
			}
			 catch (DaoException  e) {
				throw new ServiceException(e);
			}
		}
		
		public  Shuttle readDateAndTimeByShuttleId(int id) throws ServiceException {
			try {
				ShuttleDAO shuttleDAO = new ShuttleDAO();
				return shuttleDAO.viewDateAndTimeByShuttleId(id);
			}
			 catch (DaoException  e) {
				throw new ServiceException(e);
			}
		}
		
		

}
