<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Inserting Courses
 * Functionality: 	This is a Jsp, which will show the Admin Panel Functionalities for FMS.
 * Models Used : 	CourseMaster.java    
 * Creation date: 	(24/12/2017)
 * Modifications:
 * Author:            Date:          Change Description:
 * Group G3     	  23-12-2017     Updated Version
 ************************************************************************************** --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/style.css" var="CSS" />

<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900" var="font" />
<c:url value="/resources/materialize.min.css" var="mat" />
<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="icons"/>
<c:url value="/resources/notifIt.css" var="notCSS" />

<script type="text/javascript" src="resources/jquery.js"></script>



<!-- Compiled and minified JavaScript -->
<script	type="text/javascript" src="resources/materialize.min.js"></script>
<!-- Compiled and minified CSS -->
<link href="${mat}" rel="stylesheet" >
<link href="${CSS}" rel="stylesheet" />
<link href="${icons}" rel="stylesheet">
<link href="${notCSS}" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/notifIt.min.js"></script>
<script>
insertNewCourse = function(){
	$('#insertCourse').submit();
// 	var courseData = $("#insertCourse").serialize();
// 	$.ajax({
// 		type:'POST',
// 		data: courseData,
// 		url:'courseInsert.mvc',
// 		success: function(resp){
// 				alert("Insertion of Faculty with Id "+resp.success.courseId+" Successful");
// 		},
// 		error: function(){
// 			alert("Unable to Insert Course Try Again!");
// 		}
// 	});
}
	function displaySuccess(data){
		notif({
			msg: "Msg: "+data,
			type: "success",
			position: "left",
			opacity: 0.8,
			width: 250,
			multiline: true
		});
	}

	function displayError(data){
		notif({
			msg: "Msg: "+data,
			type: "error",
			position: "left",
			opacity: 0.8,
			width: 250,
			multiline: true
		});
	}
</script>

</head>
<body>
<c:if test="${successMessage!=null}">
	<script>
	var data = "${successMessage}";
	displaySuccess(data);
	</script>
</c:if>
<c:if test="${errorCause!=null}">
	<script>
	var data = "${errorCause}";
	displayError(data);
	</script>
</c:if>
	<div class="row">
	<div class="col s12 center">
		
			<form:form id="insertCourse" action="processCourseInsert.mvc" method="post"
				modelAttribute="courseIns">
				<div class="input-field inline">
					<!--<input id="email" type="text" class="validate">-->
					<table>
					<tr>
					<td>Course Name </td>
					<td><form:input path="courseName" /> </td>
					<td> <form:errors path="courseName" cssClass="red-text accent-4"/></td></tr>
					<tr>
					<td>No Of Days</td>
					<td><form:input path="noOfDays" /> </td>
					<td><form:errors path="noOfDays"  cssClass="red-text accent-4"/> </td> </tr>
					</table>
					<a onclick="insertNewCourse();" id="insertCourse" class="btn-floating btn-large waves-effect waves-light red">
					<i	class="material-icons">add</i></a> 
						
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>