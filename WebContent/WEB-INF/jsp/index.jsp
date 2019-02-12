<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Performing LogIn Fucntionality
 * Functionality: 	This is a Jsp, which is responsible for Authentication of user.
 * Models Used : 	LogInBean.java    
 * Creation date: 	(24/12/2017)
 * Modifications:
 * Author:            Date:          Change Description:
 * Group G3     	  23-12-2017     Updated Version
 ************************************************************************************** --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
<c:url value="/resources/style.css" var="CSS" />
<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900" var="font" />
<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" var="bootstrap" />
<c:url value="/resources/notifIt.css" var="notCSS" />
<link href="${CSS}" rel="stylesheet" />
<link href="${font}">
<link href="${bootstrap}">
<link href="${notCSS}" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/notifIt.min.js"></script>
<script type="text/javascript" src="resources/jquery.js"></script>

<script type="text/javascript">
function displayError(data){
	notif({
		msg: "<b>Error:</b> "+data,
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
<c:if test="${errorCause!=null}">
	<script>
	var data = "${errorCause}";
	displayError(data);
	</script>
</c:if>
<div class="form-title">
  <h1>Feedback Management System</h1><span>Login Page</span>
</div>
<!-- Form Module-->
<div class="module form-module">
<form:form action="processLogIn.mvc" method="post" modelAttribute="login">
  <div class="toggle">
  </div>
  
  <div class="form">
    <h2 align="center">Login to your account</h2>
      <form:input path="employeeId" placeholder="Employee Id"/>
      <form:password path="password" placeholder="Password"/>
	  <button>Login</button>
  </div>
  
  <div class="cta">
  <ul>
  	<li><form:errors path="employeeId" cssClass="loginError"/></li>
  	<li><form:errors path="password" cssClass="loginError"/></li>
  </ul>
  </div>
  </form:form>
</div>
</body>
</html>