package com.web.fms.entities;

import java.util.Date;

public class FeedbackReportTwo {

	private Date date;
	private String trainingName;
	private String facultyName;
	private float feedbackPersonalCommunication;
	private float	feedbackClarifyDoubts;
	private float feedbackTimeManagement;
	private float feedbackHandOut;
	private float feedbackHwSwNetwork;
	public FeedbackReportTwo() {
		super();
	}
	public FeedbackReportTwo(Date date, String trainingName,
			String facultyName, float feedbackPersonalCommunication,
			float feedbackClarifyDoubts, float feedbackTimeManagement,
			float feedbackHandOut, float feedbackHwSwNetwork) {
		super();
		this.date = date;
		this.trainingName = trainingName;
		this.facultyName = facultyName;
		this.feedbackPersonalCommunication = feedbackPersonalCommunication;
		this.feedbackClarifyDoubts = feedbackClarifyDoubts;
		this.feedbackTimeManagement = feedbackTimeManagement;
		this.feedbackHandOut = feedbackHandOut;
		this.feedbackHwSwNetwork = feedbackHwSwNetwork;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	@Override
	public String toString() {
		return "FeedbackReportTwo [date=" + date + ", trainingName="
				+ trainingName + ", facultyName=" + facultyName
				+ ", feedbackPersonalCommunication="
				+ feedbackPersonalCommunication + ", feedbackClarifyDoubts="
				+ feedbackClarifyDoubts + ", feedbackTimeManagement="
				+ feedbackTimeManagement + ", feedbackHandOut="
				+ feedbackHandOut + ", feedbackHwSwNetwork="
				+ feedbackHwSwNetwork + "]";
	}
	
	
	
	
}
