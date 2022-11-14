<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Medical History</title>
    
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
  <h1>Update Medical History</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Patient ID :<input type="text" name="patient_id" value="${medical_history.patient_id }" disabled/>
	<br/>
	Notes:<input type="text" name="medical_history_notes" value="${medical_history.notes}" disabled/>
	<br/>	
	Pre-existing Conditions：<input type="text" name="medical_history_pre_existing_conditions" value="${medical_history.pre_existing_conditions}" disabled />
	<br/>
	Contracted Covid：<input type="date" name="medical_history_contracted_covid" value="${medical_history.contracted_covid}" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Medical_HistoryServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="medical_history_update"/>
		<input type="hidden" name="medical_history_patient_id" value="${medical_history.patient_id }"/>
	Type "-" if you do not know the information of that field
	<br/>
	Input Patient ID : <input type="text" name="medical_history_patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Update Notes:<input type="text" name="medical_history_notes" value="${form.medical_history_notes}" />
	<br/>	
	Update Pre-existing Conditions：<input type="text" name="medical_history_pre_existing_conditions" value="${form.medical_history_pre_existing_conditions}"  />
	<br/>
	Update Contracted Covid：<input type="date" name="medical_history_contracted_covid" value="${form.medical_history_contracted_covid}" />
	<br/>
	<input type="submit" value="Update Medical History"/>
</form>

</body>
</html>
