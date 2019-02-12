package com.web.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.fms.dao.FeedbackReportTwoDAO;
import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportTwoServiceImpl.java
 * Desc:        Implementation Service For FeedbackReportTwo Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Transactional
@Service
public class FeedbackReportTwoServiceImpl implements FeedbackReportTwoService{

	@Autowired
	private FeedbackReportTwoDAO feedbackReportTwo;
	
	public FeedbackReportTwoDAO getFeedbackReportTwo() {
		return feedbackReportTwo;
	}

	public void setFeedbackReportTwo(FeedbackReportTwoDAO feedbackReportTwo) {
		this.feedbackReportTwo = feedbackReportTwo;
	}


	@Override
	public List<Object[]> getMonthlyFacultyDetails(int month)
			throws FeedbackReportException, FMSException {
		
		return feedbackReportTwo.getMonthlyFacultyDetails(month);
	}
	
	

}
