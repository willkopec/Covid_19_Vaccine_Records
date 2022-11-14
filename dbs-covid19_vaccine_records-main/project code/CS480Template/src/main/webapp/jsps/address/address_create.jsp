<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Address</title>
    
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
  <h1>Address</h1>
<form action="<c:url value='/AddressServletCreate'/>" method="post">
	Patient ID :<input type="hidden" name="method" value="search"/>:<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Street Address: <input type="text" name="streetAddress" value="${form.streetAddress }"/>
	<span style="color: red; font-weight: 900">${errors.streetAddress }</span>
	<br/>
	Zip code： <input type="text" name="zipCode" value="${form.zipCode }"/>
	<span style="color: red; font-weight: 900">${errors.zipCode }</span>
	<br/>
	City： <input type="text" name="city" value="${form.city }"/>
	<span style="color: red; font-weight: 900">${errors.city }</span>
	<br/>
	State： <input type="text" name="state" value="${form.state }"/>
	<span style="color: red; font-weight: 900">${errors.state }</span>
	<br/>
	<input type="submit" value="Create Address"/>
</form>
  </body>
</html>
