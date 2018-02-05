<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/movie/updateMovie" method="post">
		<input type="hidden" name="movieId" value="${movie.movieId}">
		<table>
			<tr>
				<td>Movie</td>
				<td><input type="text" name="movieName" value="${movie.movieName}"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>