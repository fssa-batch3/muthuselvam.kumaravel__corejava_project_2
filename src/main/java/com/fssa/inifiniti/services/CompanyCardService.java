package com.fssa.inifiniti.services;

import java.util.List;

import com.fssa.inifiniti.dao.CompanyCardDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.CompanyValidator;
import com.fssa.inifiniti.validationexceptions.InvalidCompanyException;

public class CompanyCardService {
	
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
	
	public  List<CompanyCard> readCompany() throws ServiceException {
		try {
			CompanyCardDAO companyDao = new CompanyCardDAO();
			 List<CompanyCard> companyCard = companyDao.viewCompany();
			return companyCard;
		}
		 catch (DaoException  e) {
			throw new ServiceException(e);
		}
	}
	
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
