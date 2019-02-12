package com.web.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/************************************************************************************
 * File:        CourseMaster.java
 * Desc:        Entity For Course Master Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Entity
@Table(name="course_master")
public class CourseMaster {
	
	//Variables
	@Id
	@Column(name="course_id")
	@SequenceGenerator(name="courseSequence",sequenceName="seq_course_id",allocationSize=1) //used to get sequence value from user defined sequence
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="courseSequence")
	private int courseId;
	
	@Column(name="course_name")
	@Pattern(regexp="[a-zA-Z ]+",message="Provide Valid Course Name")
	private String courseName;
	
	@Column(name="no_of_days")
	@Min(value=1, message="Minimum number of days should be 1.")
	private int noOfDays;
	
	//Default Constructor
	public CourseMaster() {
		super();
	}
	
	//Parameterized Constructor Without CourseId ID
	public CourseMaster(String courseName, int noOfDays) {
		super();
		this.courseName = courseName;
		this.noOfDays = noOfDays;
	}
	
	//Parameterized Constructor
	public CourseMaster(int courseId, String courseName, int noOfDays) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.noOfDays = noOfDays;
	}
	
	//Getters and Setters
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	//toString Method
	@Override
	public String toString() {
		return "CourseMaster [courseId=" + courseId + ", courseName="
				+ courseName + ", noOfDays=" + noOfDays + "]";
	}

}
