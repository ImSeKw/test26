<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- spring에서 부트스트랩 경로설정 -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

<!-- 부트스트랩 테마적용 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 부트스트랩 테마적용 -->

</head>
<body>

	<div class="container">
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

</body>
</html>