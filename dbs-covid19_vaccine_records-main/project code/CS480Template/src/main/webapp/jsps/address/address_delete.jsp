<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Dose 1</title>
    
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
  <h1>Delete Address</h1>
<form action="<c:url value='/AddressServletDelete'/>" method="post">
	<input type="hidden" name="method" value="search"/>
	Patient ID :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	<!-- First Name   :<input type="text" name="patient_first_name" value="${form.patient_first_name }"/>
	<span style="color: red; font-weight: 900">${errors.patient_first_name }</span>
	<br/>
	Last Name   :<input type="text" name="patient_last_name" value="${form.patient_last_name }"/>
	<span style="color: red; font-weight: 900">${errors.patient_last_name }</span>
	<br/>
	Date of Birth   :<input type="date" name="patient_dob" value="${form.patient_dob }"/>
	<span style="color: red; font-weight: 900">${errors.patient_dob }</span>
	<br/>
	Gender(Female, Male, Intersex)   :<input type="text" name="patient_gender" value="${form.patient_gender }"/>
	<span style="color: red; font-weight: 900">${errors.patient_gender }</span>
	<br/> -->
	<input type="submit" value="Delete Address"/>
</form>
  </body>
</html>
