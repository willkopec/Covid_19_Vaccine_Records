<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">01-05-2022 Covid Dates & 60606 Primary Physician Zip Code Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Notes</th>
		<th>Primary Physician Last Name</th>
	</tr>
<c:forEach items="${CovidDateList}" var="medical_history">
	<tr>
		<td>${medical_history.notes}</td>
		<td>${medical_history.p_last_name}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
