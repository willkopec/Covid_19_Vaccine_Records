<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Address Output</title>
    
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
  <h1>Read Address Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Patient ID: <input type="text" name="patient_id" value="${address.patient_id }" disabled/>
	<br/>
	Street Address：<input type="text" name="address_street_address" value="${address.address }" disabled/>
	<br/>
	 Zip Code：<input type="text" name="address_zip_code" value="${address.zip }" disabled/>
	<br/>
	City : <input type="text" name="address_city" value="${address.city }" disabled/>
	<br/>
	State: <input type="text" name="address_state" value="${address.state }" disabled/> 
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
