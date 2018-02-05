<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css-color/mdb.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css-color/bootstrap.min.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h1 class="h1">
						COUNTRY<small> LIST</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
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
							<td>${countryList.countryId}</td>
							<td>${countryList.countryName}</td>
							<td><a href="${pageContext.request.contextPath}/country/countryUpdateForm?countryId=${countryList.countryId}">수정</a></td>
							<td><a href="${pageContext.request.contextPath}/country/countryDelete?countryId=${countryList.countryId}">삭제</a></td>
						</tr>	
					</c:forEach>		
						<tr>
						<td><input type= "button"><a href="${pageContext.request.contextPath}/country/countryInsertForm">입력</a></td>
						</tr>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/"
				class="btn rgba-pink-strong" role="button"><i class="fa fa-home"
				aria-hidden="true"></i></a>
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