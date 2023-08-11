package com.fssa.inifiniti.services;

import com.fssa.inifiniti.dao.CompanyDAO;
import com.fssa.inifiniti.dao.exceptions.DaoException;
import com.fssa.inifiniti.model.CompanyCard;
import com.fssa.inifiniti.services.exceptions.ServiceException;
import com.fssa.inifiniti.validation.CompanyValidator;
import com.fssa.inifiniti.validationexceptions.InvalidCompanyException;

public class CompanyCardService {
	
	public boolean registerCompany(CompanyCard company) throws ServiceException {
		CompanyDAO companyDao = new CompanyDAO();
		try {
		if(CompanyValidator.validateCompany(company)) {
			if(companyDao.insertCompany(company)){
				System.out.println(company.getCompanyTitle()+ " registration successful");
				return true;
			} else {
				System.out.println("Company registration not successful");
				return false;
			}
		} else {
			System.out.println("Company details are invalid");
			return false;
		}
		}
		 catch (DaoException | InvalidCompanyException e) {
			
			throw new ServiceException(e);
		}
	}


}
