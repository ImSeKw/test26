<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
</head>
<body>
	<form action="${pageContext.request.contextPath}/city/updateCity" method="post">
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
