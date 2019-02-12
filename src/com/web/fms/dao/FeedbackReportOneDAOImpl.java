package com.web.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportOneDAOImpl.java
 * Desc:        DAO Implementation to Fetch FeedbackReport One.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Repository
public class FeedbackReportOneDAOImpl implements FeedbackReportOneDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getMonthlyTrainingDetails(int month)
			throws FeedbackReportException {
		
		
		List<Object[]> feedbackListOne=null;
		try
		{
			 String query="select to_char( end_date, 'dd-mm-yyyy' ),c.course_name as trainingName,e.employee_name as facultyName,f.FB_Prs_comm as feedbackPersonalCommunication ,f.FB_Clrfy_dbts as feedbackClarifyDoubts,f.FB_TM as feedbackTimeManagement,f.FB_Hnd_out as feedbackHandOut,f.FB_Hw_Sw_Ntwrk from training_program t join feedback_master f on f.training_code=t.training_code join employee_master e on e.employee_id=t.faculty_code join course_master c on c.course_id=t.course_code where to_char( end_date, 'mm' )=:month";
			
			Query sqlQuery =  entityManager.createNativeQuery(query);
			 
			sqlQuery.setParameter("month", month);
			 feedbackListOne = sqlQuery.getResultList();
			
		}
		catch(Exception e)
		{
			throw new FeedbackReportException(e);
		}
		return feedbackListOne;
	}

}
