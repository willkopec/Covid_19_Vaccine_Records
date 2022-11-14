<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Booster Dose</title>
    
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
  <h1>Delete Primary Physician</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Primary_physicianServletDelete'/>" method="post">
	<input type="hidden" name="method" value="primary_physician_delete"/>
	<input type="hidden" name="primary_physician_patient_id" value="${primary_physician.patient_id}"/>
	Patient ID :<input type="text" name="primary_physician_patient_id" value="${primary_physician.patient_id }"disabled/>
	<br/>
	First name： <input type="text" name="p_first_name" value="${primary_physician.p_first_name }"disabled/>
	<br/>
	Last name: <input type="text" name="p_last_name" value="${primary_physician.p_last_name }"disabled/>
	<br/>
	Street Address： <input type="text" name="p_street_address" value="${primary_physician.p_street_address }"disabled/>
	<br/>
	City： <input type="text" name="p_city" value="${primary_physician.p_city }"disabled/>
	<br/>
	State： <input type="text" name="p_state" value="${primary_physician.p_state }"disabled/>
	<br/>
	Zip： <input type="number" name="p_zip" value="${primary_physician.p_zip }"disabled/>
	</br>
	Phone number： <input type="tel" name="p_phone_num" value="${primary_physician.p_phone_num }"disabled/>
	<input type="submit" value="Delete Primary Physician"/>
</form>

</body>
</html>
