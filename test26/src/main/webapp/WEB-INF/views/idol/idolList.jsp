<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- spring에서 부트스트랩 경로설정 -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- 부트스트랩 테마적용 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 부트스트랩 테마적용 -->

</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h1 class="h1">
						IDOL<small> LIST</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-md-2 col-lg-2"></div>
		<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 text-center">
			<h2 class="text-center"></h2>
			<table class="table table-hover">
				<thead>
					<tr>
						<td><strong>No.</strong></td>
						<td><strong>IDOL</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="idolList" items="${list}">
						<tr>
							<td>${idolList.idolID}</td>
							<td>${idolList.idolName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-2 col-lg-2"></div>
	</div>
	<div class="container">
		<div class="col-md-4 col-lg-4"></div>
		<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/" class="btn btn-info"
				role="button"><span class="glyphicon glyphicon-home"></span></a>
		</div>
		<div class="col-md-4 col-lg-4"></div>
	</div>
	<%-- <div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>no.</th>
					<th>IDOL</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="idolList" items="${list}">
					<tr>
						<td>${idolList.idolID}</td>
						<td>${idolList.idolName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> --%>

</body>
</html>
