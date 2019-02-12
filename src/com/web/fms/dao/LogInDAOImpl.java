package com.web.fms.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.web.fms.entities.EmployeeMaster;

/************************************************************************************
 * File:        LogInDAOImpl.java
 * Desc:        DAO Implementation to perform login functionality.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Repository
public class LogInDAOImpl implements LogInDAO {

	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public EmployeeMaster validateUser(int userId, String password) {
		EmployeeMaster emp = null;
		try{
			String query = "SELECT emp FROM EmployeeMaster emp WHERE employeeId =:id AND password =:pass";
			TypedQuery<EmployeeMaster> result = entityManager.createQuery(query, EmployeeMaster.class);
			result.setParameter("id", userId);
			result.setParameter("pass", password);
			emp = result.getSingleResult();
			if(emp!=null)
			return emp;
			else
			{
				emp = new EmployeeMaster();
				emp.setRole("invalid");
				return emp;				
			}
			
		} catch(NoResultException e){
			emp = new EmployeeMaster();
			emp.setRole("invalid");
			return emp;
		}
	}
}
