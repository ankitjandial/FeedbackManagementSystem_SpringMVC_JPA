package com.web.fms.service;

import java.util.List;







import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.fms.dao.CoursemasterDAO;
import com.web.fms.entities.CourseMaster;
import com.web.fms.exception.CourseMasterException;

/************************************************************************************
 * File:        CoursemasterServiceImpl.java
 * Desc:        Implementation Service For Course Master Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Transactional
@Service
public class CoursemasterServiceImpl implements CoursemasterService {
	
	@Autowired
	private CoursemasterDAO courseDao;
	
	

	public CoursemasterServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CoursemasterDAO getCourseDao() {
		return courseDao;
	}



	public void setCourseDao(CoursemasterDAO courseDao) {
		this.courseDao = courseDao;
	}



	@Override
	public CourseMaster addCourse(CourseMaster courseMaster)
			throws CourseMasterException {
		
		return courseDao.addCourse(courseMaster);
	}

	@Override
	public List<CourseMaster> viewCourses() throws CourseMasterException {
		
		return courseDao.viewCourses();
	}

	@Override
	public void updateCourseDetails(CourseMaster courseMaster)
			throws CourseMasterException {
		courseDao.updateCourseDetails(courseMaster);
		
	}



	@Override
	public CourseMaster findCourse(int courseId) throws CourseMasterException {
		// TODO Auto-generated method stub
		return courseDao.findCourse(courseId);
	}

	

}
