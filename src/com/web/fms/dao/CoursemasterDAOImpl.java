package com.web.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.web.fms.entities.CourseMaster;
import com.web.fms.exception.CourseMasterException;

/************************************************************************************
 * File:        CoursemasterDAOImpl.java
 * Desc:        DAO Implementation to implement Course Master Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Repository
public class CoursemasterDAOImpl implements CoursemasterDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public CourseMaster addCourse(CourseMaster courseMaster)
			throws CourseMasterException {
		try {
			entityManager.persist(courseMaster);
			entityManager.flush();
		} catch (Exception e) {
			throw new CourseMasterException("Error occured while inserting course details"+e.getMessage());
		}
		return courseMaster;
	}

	@Override
	public List<CourseMaster> viewCourses() throws CourseMasterException {
		List<CourseMaster> courseMasters=null;
		
		try {
			
			String sql="Select courseMaster from CourseMaster courseMaster";
			TypedQuery<CourseMaster> typedQuery=entityManager.createQuery(sql,CourseMaster.class);
			courseMasters=typedQuery.getResultList();
			
		} catch (Exception e) {
			throw new CourseMasterException("Something went wrong while fetching Course Details. Reason: "+e.getMessage());
		}
		
		return courseMasters;
	}

	@Override
	public void updateCourseDetails(CourseMaster courseMaster)
			throws CourseMasterException {
		try {
			CourseMaster courseMasterNew=entityManager.find(CourseMaster.class, courseMaster.getCourseId());
			if(courseMasterNew==null){
				throw new CourseMasterException("No course found with ID "+courseMaster.getCourseId());
			}else{
				entityManager.merge(courseMaster);
			}
			
		} catch (Exception e) {
			
			throw new CourseMasterException("Could not update Course with ID "+courseMaster.getCourseId()+". Reason: "+e.getMessage());
		}
		
	}

	@Override
	public CourseMaster findCourse(int courseId) throws CourseMasterException {
		CourseMaster courseMaster = null;
		
		try {
			courseMaster = entityManager.find(CourseMaster.class, courseId);
			if(courseMaster==null)
			{
				throw new CourseMasterException("No Course Exist with Id: "+courseId);
			}
		} catch (Exception e) {
			throw new CourseMasterException("Error occured while searching Course Details "+e.getMessage());
		}
		
		return courseMaster;
	}
	
	

	

}
