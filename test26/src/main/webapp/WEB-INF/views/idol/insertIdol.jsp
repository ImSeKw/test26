<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/idol/insertIdol" method = "post">
		<table border="1">
			<tr>
				<td>IDOL NAME</td>
				<td><input type="text" name="idolName"></td>
			</tr>
		</table>
		<button type="submit">입력확인</button>
	</form>
</body>
</html>