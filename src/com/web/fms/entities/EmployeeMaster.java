package com.web.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/************************************************************************************
 * File:        EmployeeMaster.java
 * Desc:        Entity For Employee Master Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Entity
@Table(name="employee_master")
public class EmployeeMaster {
	
	@Id
	@Column(name="employee_id")
	int employeeId;
	
	@Column(name="employee_name")
	String employeeName; 
	
	String password;
	
	String role;

	public EmployeeMaster() {
		
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public EmployeeMaster(int employeeId, String employeeName, String password,
			String role) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
}
