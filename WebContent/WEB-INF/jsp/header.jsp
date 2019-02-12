<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/layout.css" var="CSSLayout" />
<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" var="icons"/>
<link href="${CSSLayout}" rel="stylesheet" />
<link href="${icons}" rel="stylesheet">
<!-- <link rel="stylesheet" href="../resources/layout.css" type="text/css"> -->

</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear">
    <div id="hgroup">
      <h1>Feedback Management System</h1>
      <div class="welcome">${param.role} Panel</div>
    </div>
    <div class="header-left">
    	<div class="icn"><i class="small material-icons">account_box</i></div>
    	<div class="panel"><h2>${param.name}</h2></div>
    </div>
    
    
    <form action="logOut.mvc" method="post">
        <input type="submit" id="sf_submit" value="Log Out"/>
    </form>
  </header>
</div>
</body>
</html>
