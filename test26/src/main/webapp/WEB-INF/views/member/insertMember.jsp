<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="${pageContext.request.contextPath}/member/insertMember" method="post">
		<table border=1>
			<tr>
				<td>회원아이디<td>
				<td><input type="text" name="memberId"><td>
			</tr>
			<tr>
				<td>회원비밀번호</td>
				<td><input type="text" name="memberPw"></td>
			</tr>	
		</table>
	</form>
</body>
</html>