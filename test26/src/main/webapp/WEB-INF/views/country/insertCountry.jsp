<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Country INSERT</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
	<script>
		$(document).ready(function() {
			$('#insertButton').click(function() {
				if ($('#countryName').val() == '') {
					alert('나라를 입력해주세요.')
					$('#countryName').focus();
				} else {
					$('#countryAdd').submit();	
				}
			})
		});
	</script>
</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h1 class="h1">
						COUNTRY<small> INSERT</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<form method="post"	action="${pageContext.request.contextPath}/country/insertCountry">
				<table class="table table-hover">
					<thead class="mdb-color darken-3">
						<tr class="text-white">
							<td><strong>COUNTRY</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="countryName" id="countryName" placeholder="이곳에 나라 이름을 입력하세요"></td>
						</tr>
						<tr>
							<td><button type="submit" id="insertButton" class="btn rgba-blue-strong"><i class="fa fa-check-circle" aria-hidden="true"></i></button></td>
						</tr>
					</tbody>
				</table>
			</form>
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