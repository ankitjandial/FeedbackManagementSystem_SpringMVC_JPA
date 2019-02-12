<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Performing Course Master
 * Functionality: 	This is a Jsp, which will show the Admin Panel Functionalities for FMS.
 * Models Used : 	FacultySkill.java    
 * Creation date: 	(24/12/2017)
 * Modifications:
 * Author:            Date:          Change Description:
 * Group G3     	  23-12-2017     Updated Version
 ************************************************************************************** --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:url value="/resources/style.css" var="CSS" />
<c:url value="/resources/style1.css" var="CSS1" />

<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900" var="font" />
<c:url value="/resources/materialize.min.css" var="mat" />
<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="icons"/>
<c:url value="/resources/notifIt.css" var="notCSS" />

<script type="text/javascript" src="resources/jquery.js"></script>
<script type="text/javascript" src="resources/notifIt.min.js"></script>


<!-- Compiled and minified JavaScript -->
<script	type="text/javascript" src="resources/materialize.min.js"></script>
<!-- Compiled and minified CSS -->
<link href="${mat}" rel="stylesheet" >

<link href="${CSS}" rel="stylesheet" />
<link href="${icons}" rel="stylesheet">
<link href="${notCSS}" rel="stylesheet" type="text/css">

<script>
$(document).ready(function(){
	
	submitUpdate = function(){
		$('#fetchForUpdate').submit();	
	}

	updateAction = function(){
		$('#updateAction').submit();
	}
	
});

noSkillsError = function(data){
	notif({
		msg: "<b>Error:</b> "+data,
		type: "error",
		position: "left",
		opacity: 0.8,
		width: 250,
		multiline: true
	});
}

onSuccess = function(data){
	notif({
		msg: "<b>Success:</b> "+data,
		type: "success",
		position: "left",
		opacity: 0.8,
		width: 250,
		multiline: true
	});
}

</script>
</head>
<body>
	<c:if test="${noSkills!=null}">
		<script>
			var data = "${noSkills}"; 
			noSkillsError(data);
		</script>
	</c:if>
	<c:if test="${success!=null}">
		<script>
			var data = "${success}"; 
			onSuccess(data);
		</script>
	</c:if>
	<div class="row">
		<div class="col s12 center">
			<div class="input-field inline">
				<form id="fetchForUpdate" action="fetchForUpdate.mvc">
				<input name="fId" id="fId" type="text" class="validate"> 
				<label for="fId">Faculty ID</label> 
				<a  onclick="submitUpdate();" class="waves-effect waves-light btn">Fetch</a> 
				</form>
			</div>
		</div>
	</div>
	<c:if test="${facultyData!=null && success==null}">
		<div class="row">
			<div class="col s12 center">
				<div class="input-field inline">
					<form:form id="updateAction" action="updateFacultySkills.mvc"
						method="post" modelAttribute="facultyData">
						<table style="border:none">
				<tr>
					<td><b>Faculty Id:</b></td>
					<td><form:input path="facultyId"/></td>
					<td class="red-text accent-4"><form:errors path="facultyId"/></td>
				</tr>
				<tr>
					<td><b>Skill Set:</b></td>
					<td><form:input path="skillSet"/></td>
					<td class="red-text accent-4"><form:errors path="skillSet"/></td>
				</tr>
			</table>
						<a onclick="updateAction();" class="btn-floating btn-large red"><i
							title="Update" class="large material-icons">mode_edit</i></a>
					</form:form>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>