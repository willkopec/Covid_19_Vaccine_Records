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
  <h1>Delete Booster Dose</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Booster_DoseServletDelete'/>" method="post">
	<input type="hidden" name="method" value="booster_dose_delete"/>
		<input type="hidden" name="patient_id" value="${booster.patient_id }"/>
	Patient ID： <input type="text" name="patient_id" value="${booster.patient_id }" disabled/>
	<br/>
	Type： <input type="text" name="booster_type" value="${booster.type }" disabled/>
	<br/>
	Lot Number for Booster Dose： <input type="text" name="booster_lot_num" value="${booster.lot_number }" disabled/>
	<br/>
	Date of Booster Dose： <input type="date" name="booster_date" value="${booster.date_of_dose }" disabled/>
	<br/>
	Location： <input type="text" name="booster_location" value="${booster.location }" disabled/>
	<br/>
	<input type="submit" value="Delete Booster Dose"/>
</form>

</body>
</html>
