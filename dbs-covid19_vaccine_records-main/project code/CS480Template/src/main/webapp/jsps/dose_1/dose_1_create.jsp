<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Dose #1</title>
    
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
  <h1>Dose #1</h1>
<form action="<c:url value='/Dose1ServletCreate'/>" method="post">
	Patient ID :<input type="hidden" name="method" value="search"/>:<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Type： <input type="text" name="dose_1_type" value="${form.type_1 }"/>
	<span style="color: red; font-weight: 900">${errors.type_1 }</span>
	<br/>
	Lot Number： <input type="text" name="dose_1_lot_num" value="${form.lot_num_1 }"/>
	<span style="color: red; font-weight: 900">${errors.lot_num_1 }</span>
	<br/>
	Location： <input type="text" name="dose_1_location" value="${form.location_1 }"/>
	<span style="color: red; font-weight: 900">${errors.location_1 }</span>
	<br/>
	Date of Dose: <input type="date" name="dose_1_date" value="${form.dose_1_date }"/>
	<span style="color: red; font-weight: 900">${errors.dose_1_date }</span>
	<br/>
	<p>If you recieved the Johnson and Johnson vaccine, please use the same information from this page onto the dose #2 page. Thank you!</p>
	<input type="submit" value="Create Dose 1"/>
</form>
  </body>
</html>
