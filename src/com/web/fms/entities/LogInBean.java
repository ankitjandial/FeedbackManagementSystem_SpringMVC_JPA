package com.web.fms.entities;



import org.hibernate.validator.constraints.NotEmpty;

/************************************************************************************
 * File:        LogInBean.java
 * Desc:        Spring Bean For LogIn Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
public class LogInBean {
	
	@NotEmpty(message="Employee ID cannot be Empty")
	private String employeeId;
	@NotEmpty(message="Password Cannot be empty")
	private String password;
	public LogInBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogInBean(String employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LogInBean [employeeId=" + employeeId + ", password=" + password
				+ "]";
	}

}
