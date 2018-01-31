<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<h3 class="text-center">도시 목록</h3>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="container">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<table class="table table-hover text-center">
				<thead class="text-center">
					<tr>
						<th>번호</th>
						<th>도시</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cityList" items="${list}">
					<tr>
						<td>${cityList.cityId}</td>
						<td>${cityList.cityName}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
</html>