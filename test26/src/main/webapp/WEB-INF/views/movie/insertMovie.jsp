<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/movie/insertMovie" method="post">
		<table>
			<tr>
				<td>Movie</td>
				<td><input type="text" name="movieName"></td>
			</tr>
		</table>
		<button type="submit">입력</button>
	</form>
</body>
</html>