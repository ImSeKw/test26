<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/member/updateMember" method="post">
		<table border=1>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원아이디</th>
					<th>회원패스워드</th>
					<th>회원레벨</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="memberNo" value="${member.memberNo}" readonly></td>
					<td><input type="text" name="memberId" value="${member.memberId}"></td>
					<td><input type="text" name="memberPw" value="${member.memberPw}"></td>
					<td><input type="text" name="memberLevel" value="${member.memberLevel}"readonly></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">수정</button>
		<a href="${pageContext.request.contextPath}/member/deleteMember?memberNo=${member.memberNo}">삭제</a>
	</form> 
</body>
</html>