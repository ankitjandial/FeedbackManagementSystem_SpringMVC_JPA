package com.web.fms.dao;

import java.util.List;

import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportThreeDAO.java
 * Desc:        DAO Interface to fetch FeedbackReportThreeDAO.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
public interface FeedbackReportThreeDAO {

	
	public List<Object[]> getMonthlyDefaultersDetails(int month) throws FeedbackReportException, FMSException;
}
