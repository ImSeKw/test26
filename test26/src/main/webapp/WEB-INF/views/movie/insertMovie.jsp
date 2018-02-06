<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MOVIE INSERT</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
	<script>
		$(document).ready(function() {
			$('#insertButton').click(function() {
				if ($('#movieName').val() == '') {
					alert('영화를 입력해주세요.')
					$('#movieName').focus();
				} else {
					$('#movieAdd').submit();	
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
						MOVIE <small>INSERT</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<form action="${pageContext.request.contextPath}/movie/insertMovie" method="post" id="movieAdd">
				<table class="table table-hover">
					<thead class="mdb-color darken-3">
						<tr class="text-white">
							<td><strong>MOVIE</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="movieName" id="movieName" placeholder="이곳에 영화 이름을 입력하세요"></td>
						</tr>
						<tr>
							<td>
								<button type="button" id="insertButton" class="btn rgba-blue-strong">
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