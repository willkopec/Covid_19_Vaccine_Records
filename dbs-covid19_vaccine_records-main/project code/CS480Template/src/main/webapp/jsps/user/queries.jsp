<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
 	<br>
    <a href="<c:url value='/gmailEmails'/>" target="body">Please list patients with Gmail email addresses</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/stringAggregate'/>" target="body">Please list the count of female patients</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/ILPhys'/>" target="body">Please list all Illinois Primary Physicians</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/CovidDates'/>" target="body">Please list all Patients who contracted covid on 01-05-2022 and have their primary physician's zip code in 60606</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/complexExist'/>" target="body">Please list all States for Primary Physicians that have existing Patient ID's</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/LatestByType'/>" target="body">Please list the latest second dose date that was administered for each vaccine type</a>&nbsp;&nbsp;
    <br>
    <a href="<c:url value='/minPhone'/>" target="body">Please list the minimum phone number value of a primary physician</a>&nbsp;&nbsp;
    
  </body>
</html>
