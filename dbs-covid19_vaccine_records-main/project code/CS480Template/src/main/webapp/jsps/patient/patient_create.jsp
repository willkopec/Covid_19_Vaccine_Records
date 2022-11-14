<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Patient Create</title>
    
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
  <h1>Patient Create</h1>
<form action="<c:url value='/PatientServletCreate'/>" method="post">
	First Name    :<input type="text" name="patient_first_name" value="${form.patient_first_name }"/>
	<span style="color: red; font-weight: 900">${errors.patient_first_name }</span>
	<br/>
	Last Name：<input type="text" name="patient_last_name" value="${form.patient_last_name }"/>
	<span style="color: red; font-weight: 900">${errors.patient_last_name }</span>
	<br/>
	Date of Birth	：<input type="date" name="patient_dob" value="${form.patient_dob }"/>
	<span style="color: red; font-weight: 900">${errors.patient_dob }</span>
	<br/>
	Gender(Female, Male, Intersex)	：<input type="text" name="patient_gender" value="${form.patient_gender }"/>
	<span style="color: red; font-weight: 900">${errors.patient_gender }</span>
	<br/>
	<h3>Please use the "Read Patient" tab and input your information to receive your patient ID</h3>
	<input type="submit" value="Create Patient"/>
</form>
  </body>
</html>
