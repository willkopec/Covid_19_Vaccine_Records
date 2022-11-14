<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Contact Create</title>
    
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
  <h1>Contact Create</h1>
<form action="<c:url value='/ContactServletCreate'/>" method="post">
	Patient ID :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Email Address	：<input type="email" name="contact_email_address" value="${form.contact_email_address }"/>
	<span style="color: red; font-weight: 900">${errors.contact_email_address }</span>
	<br/>
	Phone Number (No Dashes)：<input type="tel" name="contact_phone_num" value="${form.contact_phone_num }"/>
	<span style="color: red; font-weight: 900">${errors.contact_phone_num }</span>
	<br/>
	<input type="submit" value="Create Contact"/>
</form>
  </body>
</html>
