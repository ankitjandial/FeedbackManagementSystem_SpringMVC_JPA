<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Coordinator Panel
 * Functionality: 	This is a Jsp, which will show the Coordinator Panel Functionalities for FMS(Out Of Scope).
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

</head>
<body>
<jsp:include page="header.jsp">
<jsp:param value="${user.employeeName}" name="name"/>
<jsp:param value="${user.role}" name="role"/>
</jsp:include>
<h1 align="center" style="font-style: normal;margin: 20px">IMPLEMENTATION OF THIS ACTOR OUT OF SCOPE</h1>
<div class="row">
<div class="col s12 center">
<a href="index.mvc" class="waves-effect waves-light btn center">Return to LogIn Page</a>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>