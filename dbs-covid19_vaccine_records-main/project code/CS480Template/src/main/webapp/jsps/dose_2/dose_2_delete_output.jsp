<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Dose #2</title>
    
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
  <h1>Delete Dose #2</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Dose_2ServletDelete'/>" method="post">
	<input type="hidden" name="method" value="dose_2_delete"/>
		<input type="hidden" name="patient_id" value="${dose_2.patient_id }"/>
	Patient ID： <input type="text" name="patient_id" value="${dose_2.patient_id }" disabled/>
	<br/>
	Type： <input type="text" name="dose_2_type" value="${dose_2.type }" disabled/>
	<br/>
	Lot Number for Dose #2： <input type="text" name="dose_2_lot_num" value="${dose_2.lot_number }" disabled/>
	<br/>
	Date of Dose #2： <input type="date" name="dose_2_date" value="${dose_2.date_of_dose }" disabled/>
	<br/>
	Location： <input type="text" name="dose_2_location" value="${dose_2.location }" disabled/>
	<br/>
	<input type="submit" value="Delete Dose #2"/>
</form>

</body>
</html>
