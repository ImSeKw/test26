<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h1 class="h1">
						COUNTRY<small> LIST</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-md-2 col-lg-2"></div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center">
			<table class="table table-hover">
				<thead>
					<tr>
						<td><strong>No.</strong></td>
						<td><strong>COUNTRY</strong></td>
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
		</div>
		<div class="col-md-8 col-lg-8"></div>
	</div>
	<div class="container">
		<div class="col-md-4 col-lg-4"></div>
		<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/" class="btn btn-info"
				role="button"><span class="glyphicon glyphicon-home"></span></a>
		</div>
		<div class="col-md-4 col-lg-4"></div>
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