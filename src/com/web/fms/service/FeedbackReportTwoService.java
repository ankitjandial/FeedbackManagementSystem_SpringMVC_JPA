package com.web.fms.service;

import java.util.List;

import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportTwoService.java
 * Desc:        FeedbackReportTwo Service Functionalities Interface.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/


public interface FeedbackReportTwoService {

	public List<Object[]> getMonthlyFacultyDetails(int month) throws FeedbackReportException, FMSException;
	
}
