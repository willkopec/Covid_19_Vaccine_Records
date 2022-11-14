<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Dose #2</title>
    
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
  <h1>Update Dose #2</h1>
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
<h1>Update the values below</h1>
<form action="<c:url value='/Dose_2ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="dose_2_update"/>
				<input type="hidden" name="patient_id" value="${dose_2.patient_id }"/>
	Patient ID: <input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Type： <input type="text" name="dose_2_type" value="${form.type_2 }"/>
	<span style="color: red; font-weight: 900">${errors.type_2 }</span>
	<br/>
	Lot Number： <input type="text" name="dose_2_lot_num" value="${form.lot_num_2 }"/>
	<span style="color: red; font-weight: 900">${errors.lot_num_2 }</span>
	<br/>
	Date of Dose #2: <input type="date" name="dose_2_date" value="${form.dose_2_date }"/>
	<span style="color: red; font-weight: 900">${errors.dose_2_date }</span>
	<br/>
	Location： <input type="text" name="dose_2_location" value="${form.location_2 }"/>
	<span style="color: red; font-weight: 900">${errors.location_2 }</span>
	<br/>
	<input type="submit" value="Update Dose #2"/>
</form>

</body>
</html>
