<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<table border=1>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원아이디</th>
					<th>회원패스워드</th>
					<th>회원레벨</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name=memberNo placeholder="${member.memberNo}" readonly></td>
					<td><input type="text" name=memberId placeholder="${member.memberId}"></td>
					<td><input type="text" name=memberPw placeholder="${member.memberPw}"></td>
					<td><input type="text" name=memberLevel placeholder="${member.memberLevel}"readonly></td>
					<td><a href="${pageContext.request.contextPath}/member/updateMember">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/member/deleteMember">삭제</a></td>
					
					
				</tr>
			</tbody>
		
		</table>
	</form> 
</body>
</html>