<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Viewing All Skills
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
<c:url value="/resources/style1.css" var="CSS1" />
<c:url value="/resources/materialize.min.css" var="mat" />
<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="icons"/>


<link href="${mat}" rel="stylesheet" >
<link href="${CSS}" rel="stylesheet" />
<link href="${CSS1}" rel="stylesheet" />
<link href="${icons}" rel="stylesheet">


<script type="text/javascript" src="resources/jquery.js"></script>
<script	type="text/javascript" src="resources/materialize.min.js"></script>
</head>
<body>
<form id="viewAllS" action="viewAllSkills.mvc">
<div class="row">
	<div class="col s12 center">
<a onclick="document.getElementById('viewAllS').submit();" class="waves-effect waves-light btn center"><i class="material-icons">loop</i></a>
</div>
</div>
</form>
<c:if test="${allSkills!=null}">
							<table class="striped centered">
							<thead>
								<tr>
									<th>Faculty ID</th>
									<th>Skill Set</th>
								</tr>
							</thead>
							
							<tbody>
							<c:forEach items="${allSkills}" var="skill">
								<tr>
									<td>${skill.facultyId}</td>
									<td>${skill.skillSet}</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						</c:if>
</body>
</html>