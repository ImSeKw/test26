<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MOVIE LIST</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h1 class="h1">
						MOVIE <small>LIST</small>
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
						<td><strong>MOVIE</strong></td>
						<td><strong>UPDATE</strong></td>
						<td><strong>DELETE</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="movieList" items="${list}">
						<tr>
							<td><strong>${movieList.movieId}</strong></td>
							<td><strong>${movieList.movieName}</strong></td>
							<td><a href="${pageContext.request.contextPath}/movie/updateMovie?movieId=${movieList.movieId}" class="btn rgba-teal-strong"role="button"><i class="fa fa-wrench fa-3x" aria-hidden="true"></i></a></td>
							<td><a href="${pageContext.request.contextPath}/movie/deleteMovie?movieId=${movieList.movieId}" class="btn rgba-red-strong"role="button"><i class="fa fa-times-circle fa-1g" aria-hidden="true"></i></a></td>
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
			<a href="${pageContext.request.contextPath}/" class="btn rgba-pink-strong"
				role="button"><i class="fa fa-home" aria-hidden="true"></i></a>
			<a href="${pageContext.request.contextPath}/movie/insertMovie" class="btn rgba-blue-strong"
				role="button"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>	
		</div>
		<div class="col-lg-4"></div>
	</div>
	<%-- <div class="container">
		<h2>MOVIE LIST</h2>
		<p>한국의 대표적인 MOVIE TOP10</p>
		<table class="table">
			<thead>
				<tr>
					<th>no.</th>
					<th>MOVIE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movieList" items="${list}">
					<tr>
						<td>${movieList.movieId}</td>
						<td>${movieList.movieName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
 --%>
</body>
</html>