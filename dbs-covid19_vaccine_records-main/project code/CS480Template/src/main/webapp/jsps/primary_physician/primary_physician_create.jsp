
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Primary Physician</title>
    
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
  <h1>Create Primary Physician</h1>
<form action="<c:url value='/Primary_physicianServletCreate'/>" method="post">
    Type "-" if you do not know the information of that field
	<br/>
	Patient ID :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	
	<br/>
	First name： <input type="text" name="p_first_name" value="${form.p_first_name }"/>
	<span style="color: red; font-weight: 900">${errors.p_first_name }</span>
	<br/>
	Last name: <input type="text" name="p_last_name" value="${form.p_last_name }"/>
	<span style="color: red; font-weight: 900">${errors.p_last_name }</span>
	<br/>
	Street Address： <input type="text" name="p_street_address" value="${form.p_street_address }"/>
	<span style="color: red; font-weight: 900">${errors.p_street_address }</span>
	<br/>
	City： <input type="text" name="p_city" value="${form.p_city }"/>
	<span style="color: red; font-weight: 900">${errors.p_city }</span>
	<br/>
	State： <input type="text" name="p_state" value="${form.p_state }"/>
	<span style="color: red; font-weight: 900">${errors.p_state }</span>
	<br/>
	Zip： <input type="text" name="p_zip" value="${form.p_zip }"/>
	<span style="color: red; font-weight: 900">${errors.p_zip }</span>
	</br>
	Phone number： <input type="tel" name="p_phone_num" value="${form.p_phone_num }"/>
	<span style="color: red; font-weight: 900">${errors.p_phone_num }</span>
	Do not add dashes (Ex. 1234567890)
	<input type="submit" value="Create Primary Physician"/>
</form>
  </body>
</html>
