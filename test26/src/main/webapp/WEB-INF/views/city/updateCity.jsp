<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>CITY UPDATE</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
	<script>
		$(document).ready(function() {
			$('#updateButton').click(function() {
				if ($('#cityName').val() == '') {
					alert('도시를 입력해주세요.')
					$('#cityName').focus();
				} else {
					$('#cityUpdate').submit();	
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
						CITY <small>UPDATE</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<form action="${pageContext.request.contextPath}/city/updateCity" method="post" id="cityUpdate">
				<input type="hidden" name="cityId" value="${city.cityId}">
				<table class="table table-hover">
					<thead class="mdb-color darken-3">
						<tr class="text-white">
							<td><strong>CITY</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="cityName" id="cityName" value="${city.cityName}" placeholder="이곳에 도시 이름을 입력하세요"></td>
						</tr>
						<tr>
							<td>
								<button type="button" id="updateButton" class="btn rgba-blue-strong">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>
