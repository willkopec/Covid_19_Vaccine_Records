<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Patient Output</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Read Patient Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Patient ID: <input type="text" name="patient_id" value="${patient.patient_id }" disabled/>
	<br/>
	First Name    :<input type="text" name="patient_first_name" value="${patient.first_name }" disabled/>
	<br/>
	Last Name：<input type="text" name="patient_last_name" value="${patient.last_name }" disabled/>
	<br/>
	Date of Birth	：<input type="date" name="patient_dob" value="${patient.dob }" disabled/>
	<br/>
	Gender	：<input type="text" name="patient_gender" value="${patient.gender }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
