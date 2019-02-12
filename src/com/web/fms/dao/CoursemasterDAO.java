package com.web.fms.dao;

import java.util.List;

import com.web.fms.entities.CourseMaster;
import com.web.fms.exception.CourseMasterException;


/************************************************************************************
 * File:        CourseMasterDAO.java
 * Desc:        DAO Interface For Course Master.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
public interface CoursemasterDAO {

	public CourseMaster addCourse(CourseMaster courseMaster) throws CourseMasterException;
	
	public List<CourseMaster> viewCourses() throws CourseMasterException;
	
	public void updateCourseDetails(CourseMaster courseMaster) throws CourseMasterException;
	
	public CourseMaster findCourse(int courseId) throws CourseMasterException;
	
	
}
