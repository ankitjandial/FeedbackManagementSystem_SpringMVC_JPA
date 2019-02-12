<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%--  
 ***************************************************************************************
 * Description  :   Presentation Layer for Viewing Average Feedback
 * Functionality: 	This is a Jsp, which will show the Admin Panel Functionalities for FMS.    
 * Creation date: 	(24/12/2017)
 * Modifications:
 * Author:            Date:          Change Description:
 * Group G3     	  23-12-2017     Updated Version
 ************************************************************************************** --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/resources/style.css" var="CSS" />
<c:url value="/resources/style1.css" var="CSS1" />

<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900" var="font" />
<c:url value="/resources/materialize.min.css" var="mat" />
<script type="text/javascript" src="resources/jquery.js"></script>

<!-- Compiled and minified JavaScript -->
<script	type="text/javascript" src="resources/materialize.min.js"></script>
<!-- Compiled and minified CSS -->
<link href="${mat}" rel="stylesheet" >

<link href="${CSS}" rel="stylesheet" />
<link href="${CSS1}" rel="stylesheet" />
<%-- <link href="${font}"> --%>
<script type="text/javascript">
$(document).ready(function(){
	 $('select').material_select();
});
</script>
</head>
<body>

<div class="input-field col s12" style="width: 300px !important">
						<form id="form2" method="get" action="fetchMonthlyAverage.mvc">
							<select id="month2" name="month2" onchange="document.getElementById('form2').submit();">
								<option value="" disabled selected>Select Month</option>
								<option value="1">January</option>
								<option value="2">February</option>
								<option value="3">March</option>
								<option value="4">April</option>
								<option value="5">May</option>
								<option value="6">June</option>
								<option value="7">July</option>
								<option value="8">August</option>
								<option value="9">September</option>
								<option value="10">October</option>
								<option value="11">November</option>
								<option value="12">December</option>
							</select>
						</form>
						</div>
<c:if test="${isEmpty!=null && month!=null && avgFeedback==null}">
				<h3 class="center">No Entries Found for the Month ${month}</h3>		
			</c:if>
						<c:if test="${avgFeedback!=null}">
							<h3 align="center" class="heading">Monthly Average Feedback for the month of ${month} </h3>
							<table class="centered highlight striped">
								<thead>
									<tr>
										<th rowspan=2>S.No</th>
										<th rowspan=2>Date</th>
										<th rowspan=2>Training Name</th>
										<th rowspan=2>Faculty Name</th>
										<th colspan=5 class="centered">Feedback Scores</th>
									</tr>

									<tr>
										<th>Personal Communication</th>
										<th>Clarify Doubts</th>
										<th>Time Management</th>
										<th>Hand Out</th>
										<th>Hw/Sw/Network</th>
									</tr>
								</thead>
								<%
									int i = 0;
								%>
								<c:forEach items="${avgFeedback}" var="feedback">
									<tbody>
										<tr>
											<td><%=++i%></td>
											<td>${feedback[1]}</td>
											<td>${feedback[2]}</td>
											<td>${feedback[0]}</td>
											<td>${feedback[3]}</td>
											<td>${feedback[4]}</td>
											<td>${feedback[5]}</td>
											<td>${feedback[6]}</td>
											<td>${feedback[7]}</td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
						</c:if>

</body>
</html>