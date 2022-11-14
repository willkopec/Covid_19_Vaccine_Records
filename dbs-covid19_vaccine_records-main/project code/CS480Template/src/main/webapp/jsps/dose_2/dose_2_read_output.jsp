<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Dose #2 Output</title>
    
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
  <h1>Read Dose #2 Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
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
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
