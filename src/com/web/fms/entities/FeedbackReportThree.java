package com.web.fms.entities;

import java.util.Date;

public class FeedbackReportThree {

	private Date date;
	private String trainingName;
	private String participantName;
	private String faculityName;
	private float feedbackPersonalCommunication;
	private float	feedbackClarifyDoubts;
	private float feedbackTimeManagement;
	private float feedbackHandOut;
	private float feedbackHwSwNetwork;
	public FeedbackReportThree() {
		super();
	}
	public FeedbackReportThree(Date date, String trainingName,
			String participantName, String faculityName,
			float feedbackPersonalCommunication, float feedbackClarifyDoubts,
			float feedbackTimeManagement, float feedbackHandOut,
			float feedbackHwSwNetwork) {
		super();
		this.date = date;
		this.trainingName = trainingName;
		this.participantName = participantName;
		this.faculityName = faculityName;
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
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getFaculityName() {
		return faculityName;
	}
	public void setFaculityName(String faculityName) {
		this.faculityName = faculityName;
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
		return "FeedbackReportThree [date=" + date + ", trainingName="
				+ trainingName + ", participantName=" + participantName
				+ ", faculityName=" + faculityName
				+ ", feedbackPersonalCommunication="
				+ feedbackPersonalCommunication + ", feedbackClarifyDoubts="
				+ feedbackClarifyDoubts + ", feedbackTimeManagement="
				+ feedbackTimeManagement + ", feedbackHandOut="
				+ feedbackHandOut + ", feedbackHwSwNetwork="
				+ feedbackHwSwNetwork + "]";
	}
	
	
}
