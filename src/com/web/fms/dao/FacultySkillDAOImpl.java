package com.web.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.web.fms.entities.FacultySkill;
import com.web.fms.exception.FacultySkillException;

/************************************************************************************
 * File:        FacultySkillDAOImpl.java
 * Desc:        DAO Implementation to implement Faculty Skill Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Repository
public class FacultySkillDAOImpl implements FacultySkillDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public FacultySkill mapFacultySkillSet(FacultySkill facultySkill)
			throws FacultySkillException {
		
		
		try
		{
			entityManager.persist(facultySkill);
		
			entityManager.flush();
			
		}
		catch(Exception e)
		{
			throw new FacultySkillException("Error occured while mapping faculty skill set "+e.getMessage());
		}
		
		
		return facultySkill;
	}

	@Override
	public List<FacultySkill> viewFacultySkill() throws FacultySkillException {
		
		List<FacultySkill> facultySkill=null;
		
		try
		{
			String query="Select facultySkill from FacultySkill facultySkill";
			TypedQuery<FacultySkill> tQuery=entityManager.createQuery(query,FacultySkill.class);
			facultySkill=tQuery.getResultList();
		}
		catch(Exception e)
		{
			throw new FacultySkillException("Error occured while viewing faculty skill set "+e.getMessage());
		}
		
		return facultySkill;
	}

	@Override
	public FacultySkill updateFacultySkillSet(FacultySkill facultySkill)
			throws FacultySkillException {
		
		FacultySkill facultySkillSet=null;
		
		try
		{			
			entityManager.merge(facultySkill);
		}
		catch(Exception e)
		{
			throw new FacultySkillException("Error occured while updating faculty skill set "+e.getMessage());
		}
		return facultySkillSet;
	}

	@Override
	public FacultySkill findFaculty(int facultyId) throws FacultySkillException {

		FacultySkill facultySkill = null;
		
		try {
			facultySkill = entityManager.find(FacultySkill.class, facultyId);
			
		} catch (Exception e) {
			throw new FacultySkillException("Error occured while searching faculty skill set "+e.getMessage());
		}
		return facultySkill;
	}
}
