<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Medical History</title>
    
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
  <h1>Delete Medical History</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Medical_HistoryServletDelete'/>" method="post">
	<input type="hidden" name="method" value="medical_history_delete"/>
	<input type="hidden" name="medical_history_patient_id" value="${medical_history.patient_id}"/>
	Patient ID :<input type="text" name="medical_history_patient_id" value="${medical_history.patient_id }" disabled/>
	<br/>
	Notes:<input type="text" name="medical_history_notes" value="${medical_history.notes}" disabled/>
	<br/>
	Pre-existing Conditions：<input type="text" name="medical_history_pre_existing_conditions" value="${medical_history.pre_existing_conditions }" disabled/>
	<br/>
	Contracted Covid：<input type="date" name="medical_history_contracted_covid" value="${medical_history.contracted_covid }" disabled/>
	<br/>
	<input type="submit" value="Delete Medical History"/>
</form>

</body>
</html>
