<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Admin Panel
 * Functionality: 	This is a Jsp, which will show the Admin Panel Functionalities for FMS.
 * Models Used : 	EmployeeMaster.java    
 * Creation date: 	(24/12/2017)
 * Modifications:
 * Author:            Date:          Change Description:
 * Group G3     	  23-12-2017     Updated Version
 ************************************************************************************** --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<c:url value="/resources/style.css" var="CSS" />
<c:url value="/resources/style1.css" var="CSS1" />

<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900" var="font" />
<c:url value="/resources/materialize.min.css" var="mat" />
<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="icons"/>

<script type="text/javascript" src="resources/jquery.js"></script>



<!-- Compiled and minified JavaScript -->
<script	type="text/javascript" src="resources/materialize.min.js"></script>
<!-- Compiled and minified CSS -->
<link href="${mat}" rel="stylesheet" >

<link href="${CSS}" rel="stylesheet" />
<link href="${CSS1}" rel="stylesheet" />

<link href="${icons}" rel="stylesheet">

<style>

iframe{
	max-width: 100% !important;
}
</style>

<%-- <link href="${font}"> --%>

<script type="text/javascript">
	$('ul.tabs').tabs();
	$(document).ready(function() {
	    $('select').material_select();
		
	  });

	 function resizeIframe(obj) {
		    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
		  }
</script>

</head>

<jsp:include page="header.jsp">
<jsp:param value="${user.employeeName}" name="name"/>
<jsp:param value="${user.role}" name="role"/>
</jsp:include>

<body>
	<table id="a">
	
	</table>
	<c:if test="${user.role!=null}">
	
		<div class="row">
			<div class="col s12">
				<ul class="tabs tab1">
					<li class="tab col s4"><a href="#test1">Faculty	Skills</a></li>
					<li class="tab col s4"><a href="#test2">Course Maintenance</a></li>
					<li class="tab col s4"><a href="#test3" class="active">Feedback</a></li>
				</ul>
			</div>
			<div id="test1" class="col s12">
				<div class="row second">
				
				<!-- FACULTY MODULES -->
					<div class="col s12">
						<ul id="tabs-swipe-demo" class="tabs">
							<li class="tab col s4"><a class="active" href="#test-swipe-1">Insert Faculty Skills</a></li>
							<li class="tab col s4"><a href="#test-swipe-2">Update Faculty Skills</a></li>
							<li class="tab col s4"><a href="#test-swipe-3">View Faculty Skillset</a></li>
						</ul>
					</div>
					
					<!-- FACULTY SKILLS INSERTION -->
					<div id="test-swipe-1" class="col s12 cont">
						<h2 align="center" class="heading">Insert Faculty Skill Set</h2>
						<iframe width="1270" height="315" src="viewSkillsInsert.mvc" frameborder="0" onload="resizeIframe(this)"></iframe>
					</div>
					
					<!-- FACULTY SKILLS UPDATION -->
					<div id="test-swipe-2" class="col s12 cont">
					<h2 align="center" class="heading">Update Faculty Skills</h2>
						<iframe width="1270" height="315" src="falcultySkillUpdate.mvc" frameborder="0" onload="resizeIframe(this)"></iframe>
					</div>
					
					<!-- ALL FACULTY SKILLS -->
					<div id="test-swipe-3" class="col s12 cont">
					<h2 align="center" class="heading">Faculty Skill Set</h2>
						<iframe width="1270" height="315" src="viewAllSkills.mvc" frameborder="0" onload="resizeIframe(this)"></iframe>
					</div>
				</div>
			</div>
			
			<!-- ALL COURSE MODULES -->
			<div id="test2" class="col s12">
				<div class="row second">
				
					<div class="col s12">
						<ul id="tabs-swipe-demo" class="tabs">
							<li class="tab col s4"><a class="active" href="#test-swipe-4">Insert new Course</a></li>
							<li class="tab col s4"><a href="#test-swipe-5">Update Available Courses</a></li>
							<li class="tab col s4"><a href="#test-swipe-6">View Faculty Courses</a></li>
						</ul>
					</div>
					
					<!-- NEW COURSE INSERTION -->
					<div id="test-swipe-4" class="col s12 cont">
						<h2 align="center" class="heading">Insert A new Course</h2>
						<iframe width="1270" height="315" src="courseInsert.mvc" frameborder="0" onload="resizeIframe(this)"></iframe>							
					</div>
					
					<!-- NEW COURSE UPDATION -->
					<div id="test-swipe-5" class="col s12 cont">
						<h2 align="center" class="heading">Update Available Courses</h2>
						<iframe width="1270" height="315" src="courseViewUpdate.mvc" frameborder="0" onload="resizeIframe(this)"></iframe>
					</div>
					
					<!-- VIEW ALL COURSES -->
					<div id="test-swipe-6" class="col s12 cont">
					<h2 align="center" class="heading">All Available Courses</h2>
						<iframe width="1270" height="315" src="viewAllCourses.mvc" frameborder="0" onload="resizeIframe(this)"></iframe>
					</div>
				</div>
			</div>

			<!-- FEEDBACK MODULES -->
			<div id="test3" class="col s12">
				<div class="row second">
				
					<div class="col s12">
						<ul id="tabs-swipe-demo" class="tabs">
							<li class="tab col s4"><a class="active" href="#test-swipe-7">Feedback By Month</a></li>
							<li class="tab col s4"><a href="#test-swipe-8">Average Feedback By Month</a></li>
							<li class="tab col s4"><a href="#test-swipe-9">Defaulter's Feedback</a></li>
						</ul>
					</div>
					
					<!-- FEEDBACK TYPE -1 -->
					<div id="test-swipe-7" class="col s12 cont">
					<h2 align="center" class="heading">Monthly Feedback</h2>
						<iframe width="1270" height="400" src="monthlyFeedback.mvc" frameborder="0"></iframe>
					</div>
					
					<!-- FEEDBACK TYPE - 2 -->
					<div id="test-swipe-8" class="col s12 cont">
					<h2 align="center" class="heading">Monthly Average Feedback</h2>
						<iframe width="1270" height="400" src="averageFeedback.mvc" frameborder="0"></iframe>
					</div>
						
					<!-- FEEDBACK TYPE - 3 -->
					<div id="test-swipe-9" class="col s12 cont">
					<h2 align="center" class="heading">Defaulters Feedback</h2>
						<iframe width="1270" height="400" src="defaulterMonthly.mvc" frameborder="0"></iframe>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${user.role==null}">
		<h5>UNAUTHROIZED ACCESS</h5>
	</c:if>
	
	<jsp:include page="footer.jsp"/>
	
</body>
</html>
