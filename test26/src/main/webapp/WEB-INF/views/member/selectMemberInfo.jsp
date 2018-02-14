<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<section class="bg-white">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">MY ACCOUNT</h2>
				<hr class="my-4">
				<br>
				<form action="${pageContext.request.contextPath}/member/updateMember" method="post">
					<table class="table bg-white">
						<thead>
							<tr>
								<td>MEMBER NO.</td>
								<td>ID</td>
								<td>PASSWORD</td>
								<td>LEVEL</td>
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
					<br>
					<button type="submit" id="insertButton" class="btn btn-none n-black">
						<i class="fa fa-check-circle fa-2x"></i>
					</button>
					<!-- 취소버튼 -->
					<!-- <button type="button" id="cancelButton" class="btn btn-none n-black">
						<i class="fa fa-times-circle fa-2x"></i>
					</button> -->
					<a href="${pageContext.request.contextPath}/member/deleteMember?memberNo=${member.memberNo}" role="button" class="btn btn-none n-black">
						<i class="fa fa-times-circle fa-2x"></i>
					</a>	
				</form>	
			</div>
		</div>
	</div>
</section>			
	<%-- <form action="${pageContext.request.contextPath}/member/updateMember" method="post">
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
	</form> --%> 
<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>