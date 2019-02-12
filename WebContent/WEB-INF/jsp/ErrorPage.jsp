<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="refresh" content="5;url=http://localhost:8080/FeedbackManagementSystem_SpringMVC_JPA/" /> -->
<title>ERROR</title>
<c:url value="/resources/style.css" var="CSS" />
<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900" var="font" />
<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" var="bootstrap" />
<link href="${CSS}" rel="stylesheet" />
<link href="${font}">
<link href="${bootstrap}">
</head>
<body onload="DelayRedirect()">
<c:if test="${errMsg!=null && errMsg=='invalid'}">
<div class="errorUser">
	<h1>Invalid User</h1>
	<h5>Redirecting to Home Page in <span id = "lblCount"></span>&nbsp;seconds.</h5>
</div>
</c:if>
<c:if test="${errMsg!=null && errMsg!='invalid'}">
<div class="errorUser">
	<h1>Out of scope User</h1>
	<h5>Redirecting to Home Page in <span id = "lblCount"></span>&nbsp;seconds.</h5>
</div>
</c:if>

<script type="text/javascript">
function DelayRedirect() {
    var seconds = 5;
    var lblCount = document.getElementById("lblCount");
    lblCount.innerHTML = seconds;
    setInterval(function () {
        seconds--;
        lblCount.innerHTML = seconds;
        if (seconds == 0) {
            window.location = "index.mvc";
        }
    }, 1000);
}
</script>
</body>
</html>