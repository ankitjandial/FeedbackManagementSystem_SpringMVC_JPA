package com.web.fms.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedbackReportOne {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sNo;
	private Date fDate;
	private String trainingName;
	private String facultyName;
	private float feedbackPersonalCommunication;
	private float feedbackClarifyDoubts;
	private float feedbackTimeManagement;
	private float feedbackHandOut;
	private float feedbackHwSwNetwork;
	
	public FeedbackReportOne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackReportOne(int sNo, Date fDate, String trainingName,
			String facultyName, float feedbackPersonalCommunication,
			float feedbackClarifyDoubts, float feedbackTimeManagement,
			float feedbackHandOut, float feedbackHwSwNetwork) {
		super();
		this.sNo = sNo;
		this.fDate = fDate;
		this.trainingName = trainingName;
		this.facultyName = facultyName;
		this.feedbackPersonalCommunication = feedbackPersonalCommunication;
		this.feedbackClarifyDoubts = feedbackClarifyDoubts;
		this.feedbackTimeManagement = feedbackTimeManagement;
		this.feedbackHandOut = feedbackHandOut;
		this.feedbackHwSwNetwork = feedbackHwSwNetwork;
	}

	@Override
	public String toString() {
		return "FeedbackReportOne [sNo=" + sNo + ", date=" + fDate
				+ ", trainingName=" + trainingName + ", facultyName="
				+ facultyName + ", feedbackPersonalCommunication="
				+ feedbackPersonalCommunication + ", feedbackClarifyDoubts="
				+ feedbackClarifyDoubts + ", feedbackTimeManagement="
				+ feedbackTimeManagement + ", feedbackHandOut="
				+ feedbackHandOut + ", feedbackHwSwNetwork="
				+ feedbackHwSwNetwork + "]";
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public Date getDate() {
		return fDate;
	}

	public void setDate(Date fDate) {
		this.fDate = fDate;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public float getFeedbackPersonalCommunication() {
		return feedbackPersonalCommunication;
	}

	public void setFeedbackPersonalCommunication(float feedbackPersonalCommunication) {
		this.feedbackPersonalCommunication = feedbackPersonalCommunication;
	}

	public float getFeedbackClarifyDoubts() {
		return feedbackClarifyDoubts;
	}

	public void setFeedbackClarifyDoubts(float feedbackClarifyDoubts) {
		this.feedbackClarifyDoubts = feedbackClarifyDoubts;
	}

	public float getFeedbackTimeManagement() {
		return feedbackTimeManagement;
	}

	public void setFeedbackTimeManagement(float feedbackTimeManagement) {
		this.feedbackTimeManagement = feedbackTimeManagement;
	}

	public float getFeedbackHandOut() {
		return feedbackHandOut;
	}

	public void setFeedbackHandOut(float feedbackHandOut) {
		this.feedbackHandOut = feedbackHandOut;
	}

	public float getFeedbackHwSwNetwork() {
		return feedbackHwSwNetwork;
	}

	public void setFeedbackHwSwNetwork(float feedbackHwSwNetwork) {
		this.feedbackHwSwNetwork = feedbackHwSwNetwork;
	}

	 
	
}
