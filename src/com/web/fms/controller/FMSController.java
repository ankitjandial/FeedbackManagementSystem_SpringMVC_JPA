package com.web.fms.controller;
import java.time.Month;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.fms.entities.CourseMaster;
import com.web.fms.entities.EmployeeMaster;
import com.web.fms.entities.FacultySkill;
import com.web.fms.entities.LogInBean;
import com.web.fms.exception.CourseMasterException;
import com.web.fms.exception.FMSException;
import com.web.fms.exception.FacultySkillException;
import com.web.fms.exception.FeedbackReportException;
import com.web.fms.service.CoursemasterService;
import com.web.fms.service.FacultySkillService;
import com.web.fms.service.FeedbackReportOneService;
import com.web.fms.service.FeedbackReportThreeService;
import com.web.fms.service.FeedbackReportTwoService;
import com.web.fms.service.LogInService;

/************************************************************************************
 * File:        FMSController.java
 * Desc:        Controller For the Spring MVC Application
 * Version:     1.2
 * Modifications:
 * Author:            Date:          Change Description:
 * Author_G3	     23-12-2017    	 Updated Version
 ************************************************************************************/
@Controller
@SessionAttributes("user")
public class FMSController {
	
	
	@Autowired
	LogInService logInService;
	@Autowired
	CoursemasterService coursemasterService;
	@Autowired
	FacultySkillService facultySkillService;
	@Autowired
	FeedbackReportOneService feedbackReportOneService;
	@Autowired
	FeedbackReportTwoService feedbackReportTwoService;
	@Autowired
	FeedbackReportThreeService feedbackReportThreeService;
	
	public FeedbackReportOneService getFeedbackReportOneService() {
		return feedbackReportOneService;
	}

	public void setFeedbackReportOneService(
			FeedbackReportOneService feedbackReportOneService) {
		this.feedbackReportOneService = feedbackReportOneService;
	}

	public FeedbackReportTwoService getFeedbackReportTwoService() {
		return feedbackReportTwoService;
	}

	public void setFeedbackReportTwoService(
			FeedbackReportTwoService feedbackReportTwoService) {
		this.feedbackReportTwoService = feedbackReportTwoService;
	}

	public FeedbackReportThreeService getFeedbackReportThreeService() {
		return feedbackReportThreeService;
	}

	public void setFeedbackReportThreeService(
			FeedbackReportThreeService feedbackReportThreeService) {
		this.feedbackReportThreeService = feedbackReportThreeService;
	}

	public FacultySkillService getFacultySkillService() {
		return facultySkillService;
	}

	public void setFacultySkillService(FacultySkillService facultySkillService) {
		this.facultySkillService = facultySkillService;
	}

	public CoursemasterService getCoursemasterService() {
		return coursemasterService;
	}

	public void setCoursemasterService(CoursemasterService coursemasterService) {
		this.coursemasterService = coursemasterService;
	}

	public LogInService getLogInService() {
		return logInService;
	}

	public void setLogInService(LogInService logInService) {
		this.logInService = logInService;
	}

	@RequestMapping(value="/index.mvc")
	public String returnIndex(Model model){
		model.addAttribute("login", new LogInBean());
		return "index";
	}
	
	@RequestMapping(value="/processLogIn.mvc",method=RequestMethod.POST)
	public String processLogIn(@ModelAttribute("login") @Valid LogInBean logInBean,@ModelAttribute("facultyDet") FacultySkill facultySkill, @ModelAttribute("courseIns") CourseMaster courseMaster, BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors())
		{
			return "index";
		}
		try{
		EmployeeMaster emp = logInService.validateUser(Integer.parseInt(logInBean.getEmployeeId()), logInBean.getPassword());
		if(emp.getRole()=="invalid"){
			model.addAttribute("errMsg", emp.getRole());
			return "ErrorPage";
		}
		else if(emp.getRole().equals("Coordinator") || emp.getRole().equals("Participant")) {
			model.addAttribute("user", emp);
			return "OutUser";
		}
		else
		{
			model.addAttribute("user", emp);
			return "Admin";
		}
		} catch(NumberFormatException e) {
			model.addAttribute("errorCause", "Invalid User Id Alphabets not Allowed");
			return "index";
		}
	}
	
	
	/*FACULTY METHODS*/
	
	/*INSERT VIEW*/
	@RequestMapping(value="/viewSkillsInsert.mvc")
	public String returnSkillViewInsert(Model model) {
		model.addAttribute("facultyDet", new FacultySkill());
		return "InsertSkills";
	}
	
	/*INSERT OPERATION*/
	@RequestMapping(value="skillsInsert.mvc",method=RequestMethod.POST)
	public String facultySkillsInsert(@ModelAttribute("facultyDet") @Valid FacultySkill facultySkill,BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()) {
			return "InsertSkills";
		}
		
		try {
			facultySkillService.mapFacultySkillSet(facultySkill);
			model.addAttribute("successMessage", "Insertion of Faculty Skills With Id "+facultySkill.getFacultyId()+" Successful");
			return "InsertSkills";
		} catch (FacultySkillException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "InsertSkills";
		} catch(TransactionSystemException | ConstraintViolationException e) {
			model.addAttribute("errorCause", e.getCause());
			return "InsertSkills";
		}
	}
	
	/*UPDATE VIEW*/
	@RequestMapping(value="/falcultySkillUpdate.mvc")
	public String returnFSUPage() {
		return "FacultySkillUpdate";
	}
	
	/*UPDATE FETCH*/
	@RequestMapping(value="/fetchForUpdate.mvc")
	public String fsUpdateFetch(@RequestParam("fId") String fId,Model model) {
		try {
				FacultySkill facultySkill = facultySkillService.findFaculty(Integer.parseInt(fId));
				System.out.println("Skills "+facultySkill);
				if(facultySkill == null) {
					model.addAttribute("noSkills", "Faculty With Id "+fId+" Not Presesnt");
				}
				else {
					model.addAttribute("facultyData",facultySkill);
				}
				
		} catch (NumberFormatException | FacultySkillException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
		}
		return "FacultySkillUpdate";
	}
	
	/*UPDATE OPERATION*/
	@RequestMapping(value="/updateFacultySkills.mvc")
	public String performUpdateSkills(@ModelAttribute("facultyData") @Valid FacultySkill facultySkill, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "FacultySkillUpdate";
		}
		try {
			facultySkillService.updateFacultySkillSet(facultySkill);
			model.addAttribute("success", "Successfully Updated Faculty Skills with Id "+facultySkill.getFacultyId());
			return "FacultySkillUpdate";
		} catch (FacultySkillException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
		}
	}
	
	/*F View Call*/
	@RequestMapping(value="viewAllSkills.mvc")
	public String viewAllSkills(Model model) {
		try {
			model.addAttribute("allSkills", returnAllSkills());
		} catch (FacultySkillException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
		}
		return "AllSkills";
	}
	
	/*VIEW ALL fACULTY skILLS*/
	private List<FacultySkill> returnAllSkills() throws FacultySkillException{
		List<FacultySkill> listOfSkills = null;
		try {
			listOfSkills = facultySkillService.viewFacultySkill(); 
			
		} catch (FacultySkillException e) {
			throw new FacultySkillException("Unable to Fetch Faculty Skills");
		}
		return listOfSkills;
	}
	
	/*COURSE METHODS*/
	
	/*INSERT VIEW*/
	@RequestMapping(value="/courseInsert.mvc")
	public String returnCourseInsert(Model model) {
		model.addAttribute("courseIns", new CourseMaster());
		return "InsertCourse";
	}
	
	/*INSERT OPERATION*/
	@RequestMapping(value="/processCourseInsert.mvc",method=RequestMethod.POST)
	public String processCourseInsert(@ModelAttribute("courseIns") @Valid CourseMaster courseMaster, BindingResult bindingResult ,Model model) {
		if(bindingResult.hasErrors()) {
			return "InsertCourse"; 
		}
		
		try {
			coursemasterService.addCourse(courseMaster);
			model.addAttribute("successMessage", "Insertion With Course Id "+courseMaster.getCourseId()+" Successful");
			return "InsertCourse";
			
		} catch (CourseMasterException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "InsertCourse";
		}
	}
	
	/*UPDATE VIEW*/
	@RequestMapping(value="/courseViewUpdate.mvc")
	public String returnCUPage() {
		return "CourseUpdate";
	}
	
	/*UPDATE FETCH*/
	@RequestMapping(value="/fetchForCUpdate.mvc")
	public String cUpdateFetch(@RequestParam("cId") String courseId,Model model) {
		try {
			model.addAttribute("courseData",coursemasterService.findCourse(Integer.parseInt(courseId)));
		} catch (NumberFormatException | CourseMasterException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "CourseUpdate";
		}
		return "CourseUpdate";
	}
	
	/*UPDATE OPERATION*/
	@RequestMapping(value="/updateCourse.mvc")
	public String performUpdateCourse(@ModelAttribute("courseData") @Valid CourseMaster courseMaster, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "CourseUpdate";
		}
		try {
			coursemasterService.updateCourseDetails(courseMaster);
			model.addAttribute("successMessage", "Update of Course Id "+courseMaster.getCourseId()+" Successful");
			return "CourseUpdate";
		} catch (CourseMasterException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "CourseUpdate";
		}
	}
	
	/*C View Call*/
	@RequestMapping(value="/viewAllCourses.mvc")
	public String viewAllCourses(Model model) {
		try {model.addAttribute("allCourses", returnAllCourses());} catch (CourseMasterException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
		}
		return "AllCourses";
	}
	
	/*VIEW ALL COURSES*/
	private List<CourseMaster> returnAllCourses() throws CourseMasterException{
		List<CourseMaster> listOfCourses = null;
		try {
			listOfCourses = coursemasterService.viewCourses(); 
			
		} catch (CourseMasterException e) {
			throw new CourseMasterException("Unable to Fetch ");
		}
		return listOfCourses;
	}
	
	/*FEEDBACK METHODS*/
	
	/*MONTHLY FEEDBACK*/
	
	/*Feedback View Return*/
	@RequestMapping(value="/monthlyFeedback.mvc")
	public String monthlyFeedbackFrame()
	{
		return "monthlyFeedback";
	}
	
	/*Feedback Values Return*/
	@RequestMapping(value="/fetchMonthlyFeedback.mvc",method=RequestMethod.GET)
	public String returnMonthlyFeedback(@RequestParam("month1") String month,Model model){
		System.out.println("This is "+month);
		
		try 
		{
			model.addAttribute("month",Month.of(Integer.parseInt(month)).name());
			if(returnMonthlyFeedback(Integer.parseInt(month)).isEmpty()) {
				System.out.println("True All");
				model.addAttribute("isEmpty", "No Entries");
				return "monthlyFeedback";
			}
			else {
				model.addAttribute("feedbackMonthly", returnMonthlyFeedback(Integer.parseInt(month)));
				model.addAttribute("isEmpty", "");
			}
			
			return "monthlyFeedback";
		} catch (FeedbackReportException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
		}
	}
	
	/*Feedback Service Call*/
	private List<Object[]> returnMonthlyFeedback(int month) throws FeedbackReportException{
		List<Object[]> feedbackListOne = null;
		try {
			feedbackListOne = feedbackReportOneService.getMonthlyTrainingDetails(month); 
		} catch (FeedbackReportException e) {
			e.printStackTrace();
			throw new FeedbackReportException("Unable to Fetch Feedback Details");
		} catch (FMSException e) {
			e.printStackTrace();
			throw new FeedbackReportException("Unable to Fetch Feedback Details");
			
		} 
		return feedbackListOne;
	}
	
	
	/*MONTHLY AVERAGE*/
	
	@RequestMapping(value="/averageFeedback.mvc")
	public String averageFeedbackFrame()
	{
		return "averageFeedback";
	}
	
	@RequestMapping(value="/fetchMonthlyAverage.mvc",method=RequestMethod.GET)
	public String returnMonthlyAverage(@RequestParam("month2") String month,Model model){
		try 
		{
			model.addAttribute("month",Month.of(Integer.parseInt(month)).name());
			if(returnFacultyFeedback(Integer.parseInt(month)).isEmpty()) {
				model.addAttribute("isEmpty", "No Entries");
				return "averageFeedback";
			}
			else {
				model.addAttribute("avgFeedback", returnFacultyFeedback(Integer.parseInt(month)));
			}
			
		} catch (FeedbackReportException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
		}
		return "averageFeedback";
	}
	
	private List<Object[]> returnFacultyFeedback(int month) throws FeedbackReportException{
		List<Object[]> feedbackListTwo = null;
		try {
			feedbackListTwo =feedbackReportTwoService.getMonthlyFacultyDetails(month);
			
		} catch (FeedbackReportException e) {
			e.printStackTrace();
			throw new FeedbackReportException("Unable to Fetch Feedback Details");
		} catch (FMSException e) {
			e.printStackTrace();
			throw new FeedbackReportException("Unable to Fetch Feedback Details");
			
		} 
		return feedbackListTwo;
	}
	
	/*DEFAUTERS FEEDBACK*/
	
	@RequestMapping(value="/defaulterMonthly.mvc")
	public String defaulterFeedbackFrame()
	{
		return "defaulterFeedback";
	}
	
	@RequestMapping(value="/fetchDefaulters.mvc",method=RequestMethod.GET)
	public String returnDefaulters(@RequestParam("month3") String month,Model model){
		try 
		{
			model.addAttribute("month",Month.of(Integer.parseInt(month)).name());
			if(returnDefaultersFeedback(Integer.parseInt(month)).isEmpty()) {
				model.addAttribute("isEmpty", "No Entries");
				return "defaulterFeedback";
			}
			else {
				model.addAttribute("defaultersFeedback", returnDefaultersFeedback(Integer.parseInt(month)));				
			}
		} catch (FeedbackReportException e) {
			model.addAttribute("errorCause", e.getMessage());
			return "Error";
			//e.printStackTrace();
		}
		return "defaulterFeedback";
	}
	
	private List<Object[]> returnDefaultersFeedback(int month) throws FeedbackReportException{
		List<Object[]> feedbackListThree = null;
		try {
			feedbackListThree = feedbackReportThreeService.getMonthlyDefaultersDetails(month);
		} catch (FeedbackReportException e) {
			e.printStackTrace();
			throw new FeedbackReportException("Unable to Fetch Feedback Details");
		} catch (FMSException e) {
			e.printStackTrace();
			throw new FeedbackReportException("Unable to Fetch Feedback Details");
			
		} 
		return feedbackListThree;
	}
	
	/*LOGOUT*/
	@RequestMapping(value="/logOut.mvc")
	public String processLogOut(Model model){
		model.addAttribute("user", new EmployeeMaster());
		model.addAttribute("login", new LogInBean());
		return "index";
	}
}
