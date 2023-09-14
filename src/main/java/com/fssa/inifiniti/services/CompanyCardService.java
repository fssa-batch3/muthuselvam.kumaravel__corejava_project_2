package com.fssa.inifiniti.services;

import java.util.List;
import com.fssa.inifiniti.dao.CompanyCardDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.CompanyValidator;
import com.fssa.inifiniti.validationexceptions.InvalidCompanyException;

public class CompanyCardService {
	
	/**
	 * Registers a new company by validating and inserting its details into the database.
	 *
	 * @param company The CompanyCard object containing company information to be registered.
	 * @return True if the company registration is successful, false otherwise.
	 * @throws ServiceException If an error occurs during the registration process.
	 */
	
	public boolean registerCompany(CompanyCard company) throws ServiceException {
		CompanyCardDAO companyDao = new CompanyCardDAO();
		try {
		if(CompanyValidator.validateCompany(company)) {
			if(companyDao.insertCompany(company)){
				return true;
			} else {
				throw new DaoException("Company registration not successful");
			}
		} else {
			throw new DaoException("Company details are invalid");
		}
		}
		 catch (DaoException | InvalidCompanyException e) {
			 
			throw new ServiceException(e);
		}
	}

	/**
	 * Updates an existing company's details in the database after validation.
	 *
	 * @param companyCard The CompanyCard object containing updated company information.
	 * @return True if the company details are successfully updated, false otherwise.
	 * @throws ServiceException If an error occurs during the update process.
	 */
	
	public  boolean updateCompany(CompanyCard companyCard) throws ServiceException {
		try {
		CompanyValidator.validateName(companyCard.getCompanyTitle());	
		CompanyValidator.validateUrl(companyCard.getImageUrl());
		CompanyCardDAO companyCardDAO = new CompanyCardDAO();
		if(!companyCardDAO.companyIdAlreadyExists(companyCard.getCompanyId())) {
			throw new DaoException("Edit Company : Not Successful");
		} else {
			companyCardDAO.editCompany(companyCard);
			return true;
		}
		}
		 catch (DaoException   e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Retrieves a list of all company records from the database.
	 *
	 * @return A list of CompanyCard objects representing all companies in the database.
	 * @throws ServiceException If an error occurs during the retrieval process.
	 */
	public  List<CompanyCard> readCompany() throws ServiceException {
		try {
			CompanyCardDAO companyDao = new CompanyCardDAO();
			 return  companyDao.viewCompany();
		}
		 catch (DaoException  e) { 
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Deletes an existing company record from the database after validation.
	 *
	 * @param companyCard The CompanyCard object containing the company's ID to be deleted.
	 * @return True if the company is successfully deleted, false otherwise.
	 * @throws ServiceException If an error occurs during the deletion process.
	 */
	
	public  boolean deleteCompany(CompanyCard companyCard) throws ServiceException {
		try {
		CompanyCardDAO companyCardDAO = new CompanyCardDAO();
		if(!companyCardDAO.companyIdAlreadyExists(companyCard.getCompanyId())) {
			throw new DaoException("Delete Company : Not Successful");
		} else {
			companyCardDAO.deleteCompany(companyCard.getCompanyId());
			return true;
		} 
		}
		 catch (DaoException   e) { 
			throw new ServiceException(e);
		}
	}

}
