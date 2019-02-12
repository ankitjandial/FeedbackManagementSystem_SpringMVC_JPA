package com.web.fms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.fms.dao.LogInDAO;
import com.web.fms.entities.EmployeeMaster;

/************************************************************************************
 * File:        LogInServiceImpl.java
 * Desc:        Implementation Service For LogIn Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Service
@Transactional
public class LogInServiceImpl implements LogInService {

	@Autowired
	LogInDAO logInDAO;

	public LogInDAO getLogInDAO() {
		return logInDAO;
	}

	public void setLogInDAO(LogInDAO logInDAO) {
		this.logInDAO = logInDAO;
	}

	@Override
	public EmployeeMaster validateUser(int userId, String password) {
		
		return logInDAO.validateUser(userId, password);
	}

}
