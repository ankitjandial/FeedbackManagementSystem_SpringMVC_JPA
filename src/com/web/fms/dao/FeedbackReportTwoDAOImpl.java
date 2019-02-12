package com.web.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportTwoDAOImpl.java
 * Desc:        DAO Implementation to Fetch FeedbackReport Two.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
@Repository
public class FeedbackReportTwoDAOImpl implements FeedbackReportTwoDAO {

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
	public List<Object[]> getMonthlyFacultyDetails(int month)
			throws FeedbackReportException, FMSException {
		
		List<Object[]> feedbackListTwo=null;
		try
		{
			String query="select distinct(e.employee_name),to_char( end_date, 'dd-mm-yyyy' ),c.course_name,round((select avg(FB_Prs_comm) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_PRs_COMM, round((select avg(FB_Clrfy_dbts) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_CLRFY_DBTS, round((select avg(FB_TM) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_TM, round((select avg(FB_Hnd_out) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_HND_OUT, round((select avg(FB_Hw_Sw_Ntwrk) from feedback_master where training_code in (select training_code from training_program where faculty_code = t.faculty_code)),2) as FB_HW_SW_NTWRK from training_program t	join feedback_master f on f.training_code=t.training_code join employee_master e on e.employee_id=t.faculty_code join course_master c on c.course_id=t.course_code	where to_char( end_date, 'mm' )=:month";
			Query sqlQuery =  entityManager.createNativeQuery(query);
			
			sqlQuery.setParameter("month", month);
			
			feedbackListTwo=sqlQuery.getResultList();
			
		}
		catch(Exception e)
		{
			throw new FeedbackReportException(e);
		}
		
		return feedbackListTwo;
	}
	
	

}
