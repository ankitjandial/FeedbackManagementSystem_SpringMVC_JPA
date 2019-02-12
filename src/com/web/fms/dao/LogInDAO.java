package com.web.fms.dao;

import com.web.fms.entities.EmployeeMaster;

/************************************************************************************
 * File:        LogInDAO.java
 * Desc:        DAO Interface to implement Login functionality.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
public interface LogInDAO {
	
	public EmployeeMaster validateUser(int userId,String password);

}
