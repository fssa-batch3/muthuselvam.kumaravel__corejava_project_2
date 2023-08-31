package com.fssa.inifiniti.services;

import com.fssa.inifiniti.dao.ShuttleDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.Shuttle;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.ShuttleValidator;
import com.fssa.inifiniti.validationexceptions.InvalidShuttleException;

public class ShuttleService {
	
	 public static final ShuttleDAO shuttleDao = new ShuttleDAO();

		public  boolean registerShuttle(Shuttle shuttle) throws ServiceException {

			try {
			ShuttleValidator.validateShuttle(shuttle);
				return shuttleDao.createShuttle(shuttle);
			}
			 catch (DaoException  | InvalidShuttleException e) {
				
				throw new ServiceException(e);
			}
		}

}
