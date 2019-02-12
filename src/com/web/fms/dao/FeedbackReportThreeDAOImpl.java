package com.web.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportThreeDAOImpl.java
 * Desc:        DAO Implementation to Fetch FeedbackReport Three.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
@Repository
public class FeedbackReportThreeDAOImpl implements FeedbackReportThreeDAO {

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
	public List<Object[]> getMonthlyDefaultersDetails(int month)
			throws FeedbackReportException, FMSException {
		
		List<Object[]> feedbackListThree=null;
		
		try
		{
			 String query="select to_char(end_date, 'dd-mm-yyyy'),c.course_name,e.employee_name,"
						+ "(select employee_name from employee_master where employee_id=f.participant_id),"
						+ "f.FB_Prs_comm,f.FB_Clrfy_dbts,f.FB_TM,f.FB_Hnd_out,f.FB_Hw_Sw_Ntwrk from training_program t join feedback_master f "
						+ "on f.training_code=t.training_code join employee_master e on e.employee_id=t.faculty_code join course_master c "
						+ "on c.course_id=t.course_code where (FB_Clrfy_dbts is null OR FB_Prs_comm is null OR FB_TM is null OR	FB_Hnd_out is null "
						+ "OR FB_Hw_Sw_Ntwrk is null) and to_char( end_date, 'mm' )=:month  ";
			Query sqlQuery =  entityManager.createNativeQuery(query);
			 
			sqlQuery.setParameter("month", month);
			feedbackListThree =  sqlQuery.getResultList();
		}
		catch(Exception e)
		{
			throw new FeedbackReportException(e);
		}
		
		return feedbackListThree;
	}

}
