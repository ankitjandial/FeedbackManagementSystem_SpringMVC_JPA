package com.web.fms.service;

import java.util.List;

import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportOneService.java
 * Desc:        FeedbackReportOne Service Functionalities Interface.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/


public interface FeedbackReportOneService {

	public List<Object[]> getMonthlyTrainingDetails(int month) throws FeedbackReportException,FMSException;
	
}
