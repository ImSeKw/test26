<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>COMPANY LIST</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
</head>
<body>
	<jsp:include page="/WEB-INF/views/module/top1.jsp"></jsp:include>
		COUNTRY <small> LIST</small>
	<jsp:include page="/WEB-INF/views/module/top2.jsp"></jsp:include>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<table class="table table-hover">
				<thead class="mdb-color darken-3">
					<tr class="text-white">
						<td><strong>No.</strong></td>
						<td><strong>COUNTRY</strong></td>
						<td><strong>UPDATE</strong></td>
						<td><strong>DELETE</strong></td>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="countryList" items="${list}">
						<tr>
							<td><strong>${countryList.countryId}</strong></td>
							<td><strong>${countryList.countryName}</strong></td>
							<td><a href="${pageContext.request.contextPath}/country/updateCountry?countryId=${countryList.countryId}"class="btn rgba-teal-strong"role="button"><i class="fa fa-wrench fa-3x" aria-hidden="true"></i></a></td>
							<td><a href="${pageContext.request.contextPath}/country/deleteCountry?countryId=${countryList.countryId}"class="btn rgba-red-strong"role="button"><i class="fa fa-times-circle fa-1g" aria-hidden="true"></i></a></td>
						</tr>	
					</c:forEach>		
						</tbody>
			</table>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/" class="btn rgba-pink-strong" role="button">
				<i class="fa fa-home" aria-hidden="true"></i>
			</a>
			<a href="${pageContext.request.contextPath}/country/insertCountry" class="btn rgba-blue-strong" role="button">
				<i class="fa fa-plus-circle" aria-hidden="true"></i>
			</a>	
		</div>
		<div class="col-lg-4"></div>
	</div>
	<%-- <table class="table">
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
	</table> --%>
</body>
</html>