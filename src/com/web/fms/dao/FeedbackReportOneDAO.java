package com.web.fms.dao;

import java.util.List;

import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportOneDAO.java
 * Desc:        DAO Interface to fetch FeedbackReportOneDAO.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

public interface FeedbackReportOneDAO {


	public List<Object[]> getMonthlyTrainingDetails(int month) throws FeedbackReportException,FMSException;
	
}
