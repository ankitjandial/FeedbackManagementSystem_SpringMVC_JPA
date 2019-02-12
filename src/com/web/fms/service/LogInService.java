package com.web.fms.service;

import com.web.fms.entities.EmployeeMaster;

/************************************************************************************
 * File:        LogInService.java
 * Desc:        LogIn Service Functionalities Interface.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

public interface LogInService {
	
	public EmployeeMaster validateUser(int userId,String password);

}
