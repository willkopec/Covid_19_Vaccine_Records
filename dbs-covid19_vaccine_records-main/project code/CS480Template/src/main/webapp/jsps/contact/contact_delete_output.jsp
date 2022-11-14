<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Contact</title>
    
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
  <h1>Delete Contact</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ContactServletDelete'/>" method="post">
	<input type="hidden" name="method" value="contact_delete"/>
	<input type="hidden" name="contact_patient_id" value="${contact.patient_id}"/>
	Patient ID :<input type="text" name="contact_patient_id" value="${contact.patient_id }" disabled/>
	<script type="text/javascript">
	console.log("hi");
	</script>
	<br/>	
	Email Address：<input type="email" name="contact_email_address" value="${contact.email_address }" disabled/>
	<br/>
	Phone Number ：<input type="tel" name="contact_phone_num" value="${contact.phone_num }" disabled/>
	<br/>

	<input type="submit" value="Delete Contact"/>
</form>

</body>
</html>
