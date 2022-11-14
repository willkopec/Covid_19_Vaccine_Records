<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Primary Physician</title>
    
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
  <h1>Update Primary Physician</h1>
<form action="<c:url value='/Primary_physicianServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="primary_physician_search_update"/>
	Input Patient ID :<input type="text" name="primary_physician_patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	<!-- Update First Name   :<input type="text" name="primary_physician_first_name" value="${form.primary_physician_first_name}"/>
	<span style="color: red; font-weight: 900">${errors.primary_physician_first_name}</span>
	<br/>
	Update Last Name   :<input type="text" name="primary_physician_last_name" value="${form.primary_physician_last_name}"/>
	<span style="color: red; font-weight: 900">${errors.primary_physician_last_name}</span>
	<br/>
	Update Street Address： <input type="text" name="p_street_address" value="${form.primary_physician_street_address }"/>
	<span style="color: red; font-weight: 900">${errors.p_street_address }</span>
	<br/>
	Update City： <input type="text" name="primary_physician_city" value="${form.primary_physician_city }"/>
	<span style="color: red; font-weight: 900">${errors.p_city }</span>
	<br/>
	Update State： <input type="text" name="primary_physician_state" value="${form.primary_physician_state }"/>
	<span style="color: red; font-weight: 900">${errors.p_state }</span>
	<br/>
	Update Zip： <input type="number" name="primary_physician_zip" value="${form.primary_physician_zip }"/>
	<span style="color: red; font-weight: 900">${errors.p_zip }</span>
	</br>
	Update Phone number： <input type="tel" name="primary_physician_phone_num" value="${form.primary_physician_phone_num }"/>
	<span style="color: red; font-weight: 900">${errors.p_phone_num }</span>
	-->
	</br>
	<input type="submit" value="Update Primary Physician"/>
	
	
</form>
  </body>
</html>
