<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Dose 1</title>
    
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
  <h1>Update Dose 1</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Patient ID :<input type="text" name="patient_id" value="${dose_1.patient_id }" disabled/>
	<br/>
	<%--Type    :<input type="text" name="patient_first_name" value="${dose_1.type }" disabled/> --%>
	<br/>	
	Lot Number：<input type="text" name="dose_1_lot_num" value="${dose_1.lot_num }" disabled />
	<br/>
	Location	：<input type="text" name="dose_1_location" value="${dose_1.location }" disabled/>
	<br/>
	Date of Dose	：<input type="date" name="dose_1_doseDate" value="${dose_1.doseDate }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Dose1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="patient_id" value="${dose_1.patient_id }"/>
	Patient ID :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Type：<input type="text" name="patient_first_name" value="${form.type }"/>
	<span style="color: red; font-weight: 900">${errors.type }</span>
	<br/>
	Lot Number：<input type="text" name="dose_1_lot_num" value="${form.lot_num }"/>
	<span style="color: red; font-weight: 900">${errors.patient_last_name }</span>
	<br/>
	Location：<input type="text" name="dose_1_location" value="${form.location }"/>
	<span style="color: red; font-weight: 900">${errors.patient_dob }</span>
	<br/>
	Date of Dose	：<input type="date" name="dose_1_doseDate" value="${form.doseDate }"/>
	<span style="color: red; font-weight: 900">${errors.patient_gender}</span>
	<br/>
	<input type="submit" value="Update Dose 1"/>
</form>

</body>
</html>
