<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/idol/updateIdol" method = "post">
		<table border="1">
			<tr>
				<td>No.</td>
				<td><input type="text" name="idolID" value="${idol.idolID}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>IDOL NAME</td>
				<td><input type="text" name="idolName" value="${idol.idolName}"></td>
			</tr>
		</table>
		<button type="submit">수정완료</button>
	</form>
</body>
</html>