package com.web.fms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.fms.dao.FeedbackReportThreeDAO;
import com.web.fms.exception.FMSException;
import com.web.fms.exception.FeedbackReportException;

/************************************************************************************
 * File:        FeedbackReportThreeServiceImpl.java
 * Desc:        Implementation Service For FeedbackReportThree Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Transactional
@Service
public class FeedbackReportThreeServiceImpl implements
		FeedbackReportThreeService {

	@Autowired
	private FeedbackReportThreeDAO feedbackReportThree;
	
	public FeedbackReportThreeDAO getFeedbackReportThree() {
		return feedbackReportThree;
	}

	public void setFeedbackReportThree(FeedbackReportThreeDAO feedbackReportThree) {
		this.feedbackReportThree = feedbackReportThree;
	}


	@Override
	public List<Object[]> getMonthlyDefaultersDetails(int month)
			throws FeedbackReportException, FMSException {
		
		return feedbackReportThree.getMonthlyDefaultersDetails(month);
	}

}
