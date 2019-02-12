package com.web.fms.service;

import java.util.List;

import com.web.fms.entities.CourseMaster;
import com.web.fms.exception.CourseMasterException;

/************************************************************************************
 * File:        CoursemasterService.java
 * Desc:        CourseMaster Service Functionalities Interface.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/


public interface CoursemasterService {
	
	public CourseMaster addCourse(CourseMaster courseMaster) throws CourseMasterException;
	
	public List<CourseMaster> viewCourses() throws CourseMasterException;

	public void updateCourseDetails(CourseMaster courseMaster) throws CourseMasterException;
	
	public CourseMaster findCourse(int courseId) throws CourseMasterException;
	
}
