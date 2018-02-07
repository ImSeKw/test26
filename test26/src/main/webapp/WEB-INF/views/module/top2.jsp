<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</h1>
			</div>
		</div>
	</div>
</div>
<c:set var="loginMember" value="${loginMember}"/>
	<c:choose>
		<c:when test="${not empty loginMember}">
			<a href="${pageContext.request.contextPath}/member/selectMemberInfo">나의정보</a>
			<a href="${pageContext.request.contextPath}/member/logoutMember">로그아웃</a>
		</c:when>
		<c:when test="${empty loginMember}">
			<a href="${pageContext.request.contextPath}/member/insertMember">회원가입</a>
			<a href="${pageContext.request.contextPath}/member/loginMember">로그인</a>
		</c:when>
	</c:choose>