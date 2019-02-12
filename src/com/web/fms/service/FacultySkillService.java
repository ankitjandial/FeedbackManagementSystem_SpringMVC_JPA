package com.web.fms.service;

import java.util.List;

import com.web.fms.entities.FacultySkill;
import com.web.fms.exception.FacultySkillException;


/************************************************************************************
 * File:        FacultySkillService.java
 * Desc:        FacultySkill Service Functionalities Interface.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/


public interface FacultySkillService {

	public FacultySkill mapFacultySkillSet(FacultySkill facultySkill) throws FacultySkillException;
	
	public List<FacultySkill> viewFacultySkill() throws FacultySkillException;
	
	public FacultySkill updateFacultySkillSet(FacultySkill facultySkill) throws FacultySkillException;
	
	public FacultySkill findFaculty(int facultyId) throws FacultySkillException;
}
