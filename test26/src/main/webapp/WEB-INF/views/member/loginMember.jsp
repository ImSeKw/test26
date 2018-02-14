<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-10 col-md-10 col-lg-10 col-xs-10 input-group">
		<span class="input-group-addon"><span
			class="glyphicon glyphicon-user" style="color: black;"></span></span> <input
			type="text" class="form-control" id="username"
			placeholder="Enter your Username">
	</div>
	<form action="${pageContext.request.contextPath}/member/loginMember"
		method="post">
		<table>
			<tr>
				<td><input type="text" name="memberId"></td>
				<td><input type="text" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">로그인</button>
	</form>
</body>
</html>