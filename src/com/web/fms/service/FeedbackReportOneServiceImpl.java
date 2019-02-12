package com.web.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.fms.dao.FeedbackReportOneDAO;
import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportOneServiceImpl.java
 * Desc:        Implementation Service For FeedbackReportOne Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Transactional
@Service
public class FeedbackReportOneServiceImpl implements FeedbackReportOneService {

	@Autowired
	private FeedbackReportOneDAO feedbackReportOne;
	
	public FeedbackReportOneDAO getFeedbackReportOne() {
		return feedbackReportOne;
	}

	public void setFeedbackReportOne(FeedbackReportOneDAO feedbackReportOne) {
		this.feedbackReportOne = feedbackReportOne;
	}

	@Override
	public List<Object[]> getMonthlyTrainingDetails(int month)
			throws FeedbackReportException, FMSException {
		
		return feedbackReportOne.getMonthlyTrainingDetails(month);
	}

}
