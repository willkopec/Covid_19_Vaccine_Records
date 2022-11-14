<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Medical History</title>
    
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
  <h1>Create Medical History</h1>
<form action="<c:url value='/Medical_HistoryServletCreate'/>" method="post">
	Type "-" if you do not know the information of that field
	<br/>
	Patient ID :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Notes:<input type="text" name="medical_history_notes" value="${form.medical_history_notes}"/>
	<span style="color: red; font-weight: 900">${errors.medical_history_notes }</span>
	<br/>
	Pre-existing Conditions：<input type="text" name="medical_history_pre_existing_conditions" value="${form.medical_history_pre_existing_conditions}"/>
	<span style="color: red; font-weight: 900">${errors.medical_history_preexisting_conditions}</span>
	<br/>
	Contracted Covid：<input type="date" name="medical_history_contracted_covid" value="${form.medical_history_contracted_covid }"/>
	<span style="color: red; font-weight: 900">${errors.medical_history_contracted_covid}</span>
	<br/>
	
	<input type="submit" value="Create Medical History"/>
</form>
  </body>
</html>
