<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Latest Second Dose Administered </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Vaccine Type</th>
		<th>Date Last Administered</th>
	</tr>
<c:forEach items="${LatestSecondDoseByType}" var="dose_2">
	<tr>
		<td>${dose_2.type}</td>
		<td>${dose_2.date_of_dose}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
