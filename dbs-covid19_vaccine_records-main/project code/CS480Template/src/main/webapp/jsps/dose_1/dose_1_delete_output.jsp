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
  <h1>Delete Dose 1</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Dose1ServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="patient_id" value="${dose_1.patient_id}"/>
	Patient ID:<input type="text" name="patient_id" value="${dose_1.patient_id }" disabled/>
	<br/>	
	Type:<input type="text" name="dose_1_type" value="${dose_1.dose_type }" disabled/>
	<br/>	
	Lot Number：<input type="text" name="dose_1_lot_num" value="${dose_1.lot_num }" disabled/>
	<br/>
	Location：<input type="text" name="dose_1_location" value="${dose_1.location }" disabled/>
	<br/>
	Date of dose：<input type="date" name="dose_1_date" value="${dose_1.doseDate }" disabled/>
	<br/>
	<input type="submit" value="Delete Dose 1"/>
</form>

</body>
</html>
