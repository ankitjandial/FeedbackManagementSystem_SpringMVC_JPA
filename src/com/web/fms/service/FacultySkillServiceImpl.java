package com.web.fms.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.fms.dao.FacultySkillDAO;
import com.web.fms.entities.FacultySkill;
import com.web.fms.exception.FacultySkillException;

/************************************************************************************
 * File:        FacultySkillServiceImpl.java
 * Desc:        Implementation Service For FacultySkill Functionalities.
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/

@Transactional
@Service
public class FacultySkillServiceImpl implements FacultySkillService {
	
	
	@Autowired
	FacultySkillDAO facultySkillDAO;
	 
	public FacultySkillDAO getFacultySkillDAO() {
		return facultySkillDAO;
	}

	public void setFacultySkillDAO(FacultySkillDAO facultySkillDAO) {
		this.facultySkillDAO = facultySkillDAO;
	}

	@Override
	public FacultySkill mapFacultySkillSet(FacultySkill facultySkill)
			throws FacultySkillException {
		
		return facultySkillDAO.mapFacultySkillSet(facultySkill);
	}

	@Override
	public List<FacultySkill> viewFacultySkill() throws FacultySkillException {
		
		return facultySkillDAO.viewFacultySkill();
	}

	@Override
	public FacultySkill updateFacultySkillSet(FacultySkill facultySkill)
			throws FacultySkillException {
		
		return facultySkillDAO.updateFacultySkillSet(facultySkill);
	}

	@Override
	public FacultySkill findFaculty(int facultyId) throws FacultySkillException {
		// TODO Auto-generated method stub
		return facultySkillDAO.findFaculty(facultyId);
	}

}
