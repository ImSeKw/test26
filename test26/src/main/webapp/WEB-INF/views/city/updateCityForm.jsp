<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/city/updateCityAction" method="post">
		<input type="hidden" name="cityId" value="${city.cityId}">
		<table>
			<tr>
				<td>도시 이름</td>
				<td><input type="text" name="cityName" value="${city.cityName}"></td>
			</tr>
		</table>
		<button type="submit">도시수정</button>
	</form>
</body>
</html>
