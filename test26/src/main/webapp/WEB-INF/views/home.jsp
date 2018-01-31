<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<table>
		<ul>
			<li><a href="${pageContext.request.contextPath}/idol/idolList">아이돌 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/city/cityList">도시 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/company/companyList">회사 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/country/countryList">나라 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/movie/movieList">영화 목록</a></li>
		</ul>
	</table>
</body>
</html>