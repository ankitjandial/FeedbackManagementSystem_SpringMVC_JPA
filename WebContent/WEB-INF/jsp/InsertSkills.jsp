<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Inserting Skills
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
<title>Insert title here</title>

<c:url value="/resources/style.css" var="CSS" />

<c:url value="/resources/materialize.min.css" var="mat" />
<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="icons"/>
<c:url value="/resources/notifIt.css" var="notCSS" />

<link href="${mat}" rel="stylesheet" >
<link href="${CSS}" rel="stylesheet" />

<link href="${icons}" rel="stylesheet">
<link href="${notCSS}" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/notifIt.min.js"></script>
<script type="text/javascript" src="resources/jquery.js"></script>
<script	type="text/javascript" src="resources/materialize.min.js"></script>

<script>
$(document).ready(function(){

	facultySkillInsert = function(){
		$('#skillInsert').submit();
	}
});

function displaySuccess(data){
	notif({
		msg: "<b>Success</b> "+data,
		type: "success",
		position: "left",
		opacity: 0.8,
		width: 250,
		multiline: true
	});
}

function displayError(data){
	notif({
		msg: "<b>Error:</b> Something Went Wrong, Faculty Id Already mapped or not present",
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
	<form:form id="skillInsert" method="post" action="skillsInsert.mvc" modelAttribute="facultyDet">
		<div class="input-field inline">
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
			<a onclick="facultySkillInsert();" id="skillsInsert" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a> 
			
		</div>
	</form:form>	
	</div>
</div>
</body>
</html>