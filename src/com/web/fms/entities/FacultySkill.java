package com.web.fms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/************************************************************************************
 * File:        FacultySkill.java
 * Desc:        Entity For Faculty Skill Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
@Entity
@Table(name="faculty_skill")
public class FacultySkill {
	
	//Variables
	@Id
	@Column(name="faculty_id")
	@Min(value=1,message="Enter a Valid Faculty ID")
	@Max(value=99999,message="Enter a Valid Faculty ID")
	private int facultyId;
	
	@Column(name="skill_set")
	@Pattern(regexp="[a-zA-Z0-9,.+\\s]+",message="Provide Valid Skill Set")
	private String skillSet;
	
	//Default Constructor
	public FacultySkill() {
		
	}
	
	//Parameterized Constructor
	public FacultySkill(int facultyId, String skillSet) {
		super();
		this.facultyId = facultyId;
		this.skillSet = skillSet;
	}
	
	//Getters and Setters
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	
	//toString Method
	@Override
	public String toString() {
		return "FacultySkill [facultyId=" + facultyId + ", skillSet="
				+ skillSet + "]";
	}

}

/*
 * @desc: Bean Class for Faculty Skill 
 */
