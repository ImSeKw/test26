<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	
</head>
<body>
<h1>countryList</h1>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>나라</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="countryList" items="${list}">
			<tr>
				<td>${countryList.countryId}</td>
				<td>${countryList.countryName}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>