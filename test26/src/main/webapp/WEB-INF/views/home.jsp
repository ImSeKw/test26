<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
        <div class="col-sm-4">
			<div class="list-group">
				<a href="${pageContext.request.contextPath}/idol/idolList" class="list-group-item">아이돌 목록</a>
				<a href="${pageContext.request.contextPath}/city/cityList" class="list-group-item">도시 목록</a>
				<a href="${pageContext.request.contextPath}/company/companyList" class="list-group-item">회사 목록</a>
				<a href="${pageContext.request.contextPath}/country/countryList" class="list-group-item">나라 목록</a>
				<a href="${pageContext.request.contextPath}/movie/movieList" class="list-group-item">영화 목록</a>
			</div>
		</div>
	</div>
</body>
</html>