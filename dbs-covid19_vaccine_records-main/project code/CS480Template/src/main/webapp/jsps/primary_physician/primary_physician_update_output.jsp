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
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Patient ID :<input type="text" name="patient_id" value="${primary_physician.patient_id }"disabled/>
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
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Primary_physicianServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="primary_physician_update"/>
	<input type="hidden" name="primary_physician_patient_id" value="${primary_physician.patient_id }"/>
	Type "-" if you do not know the information of that field
	<br/>
	Input Patient ID : <input type="text" name="primary_physician_patient_id" value="${primary_physician.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	First Name：<input type="text" name="p_first_name" value="${form.p_first_name }"/>
	<span style="color: red; font-weight: 900">${errors.p_first_name}</span>
	<br/>
	Last Name	：<input type="text" name="p_last_name" value="${form.p_last_name }"/>
	<span style="color: red; font-weight: 900">${errors.p_last_name }</span>
	<br/>
	Street Address：<input type="text" name="p_street_address" value="${form.p_street_address}"/>
	<span style="color: red; font-weight: 900">${errors.p_first_name}</span>
	<br/>
	City：<input type="text" name="p_city" value="${form.p_city}"/>
	<span style="color: red; font-weight: 900">${errors.p_city}</span>
	<br/>
	State：<input type="text" name="p_state" value="${form.p_state}"/>
	<span style="color: red; font-weight: 900">${errors.p_state}</span>
	<br/>
	Zip：<input type="number" name="p_zip" value="${form.p_zip}"/>
	<span style="color: red; font-weight: 900">${errors.p_zip}</span>
	<br/>
	Phone Number：<input type="tel" name="p_phone_num" value="${form.p_phone_num}"/>
	<span style="color: red; font-weight: 900">${errors.p_phone_num}</span>
	Do not add dashes (Ex. 1234567890)
	<br/>
	<input type="submit" value="Update Primary Physician"/>
</form>

</body>
</html>
