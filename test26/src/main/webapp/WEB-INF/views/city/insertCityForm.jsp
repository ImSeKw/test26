<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/city/insertCityAction" method="post">
		<table>
			<tr>
				<td>도시 이름</td>
				<td><input type="text" name="cityName"></td>
			</tr>
		</table>
		<button type="submit">도시입력</button>
	</form>
</body>
</html>
