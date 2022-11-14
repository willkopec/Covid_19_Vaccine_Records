<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #ff8c8c; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">COVID-19 Vaccine Records</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp; 
			<a href="<c:url value='/jsps/initialize/init.jsp'/>" target="body">Initialize Database</a> |&nbsp; 
	
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/user/queries.jsp'/>" target="body">Query Result</a> |&nbsp;&nbsp;
			<a href="<c:url value='/UserServletLogout'/>" target="_parent">Logout</a> |&nbsp; 
			<a href="<c:url value='/jsps/entity1/menu.jsp'/>" target="body">CRUD entity 1</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/patient/patient_menu.jsp'/>" target="body">Patient</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/contact/contact_menu.jsp'/>" target="body">Contact</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/address/address_menu.jsp'/>" target="body">Address</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/dose_1/dose_1_menu.jsp'/>" target="body">Dose #1</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/dose_2/dose_2_menu.jsp'/>" target="body">Dose #2</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/booster/booster_menu.jsp'/>" target="body">Booster Dose</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/primary_physician/primary_physician_menu.jsp'/>" target="body">Primary Physician</a> |&nbsp;&nbsp;
			<a href="<c:url value='/jsps/medical_history/medical_history_menu.jsp'/>" target="body">Medical History</a> &nbsp;&nbsp;
		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>

