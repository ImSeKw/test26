<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
</head>
<body>
	<jsp:include page="/WEB-INF/views/module/top1.jsp"></jsp:include>
		IDOL<small> LIST</small>
	<jsp:include page="/WEB-INF/views/module/top2.jsp"></jsp:include>
	
	<!-- List 보여주기 -->
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<table class="table table-hover">
				<thead class="mdb-color darken-3">
					<tr class="text-white">
						<td><strong>No.</strong></td>
						<td><strong>IDOL</strong></td>
						<td><strong>UPDATE</strong></td>
						<td><strong>DELETE</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="idolList" items="${list}">
						<tr>
							<td><strong>${idolList.idolID}</strong></td>
							<td><strong>${idolList.idolName}</strong></td>
							<td><a href="${pageContext.request.contextPath}/idol/updateIdol?idolID=${idolList.idolID}&idolName=${idolList.idolName}" class="btn rgba-teal-strong" role="button"><i class="fa fa-wrench fa-3x" aria-hidden="true"></i></a></td>
							<td><a href="${pageContext.request.contextPath}/idol/deleteIdol?idolID=${idolList.idolID}" class="btn rgba-red-strong" role="button"><i class="fa fa-times-circle fa-1g" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4"></div>
	</div>
	
	<!-- 페이징 -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:set var="currentPage" value="${currentPage}"/>
			<c:set var="countPage" value="${countPage}"/>
			<c:choose>
				<c:when test="${currentPage eq 1}">
					<li class="page-item disabled hm-red-strong">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
						</a>
					</li>
				</c:when>
				<c:when test="${currentPage ne 1}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
						</a>
					</li>
				</c:when>
			</c:choose>
			<c:forEach var="i" begin="1" end="${countPage}" step="1">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${i}">
						${i}
					</a>
				</li>
			</c:forEach>
			<c:choose>
				<c:when test="${currentPage eq countPage}">
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</li>
				</c:when>
				<c:when test="${currentPage ne countPage}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</li>
				</c:when>
			</c:choose>
		</ul>
	</nav>
	
	<!-- 홈, 추가버튼 -->
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/" class="btn rgba-pink-strong"
				role="button"><i class="fa fa-home" aria-hidden="true"></i></a>
			<a href="${pageContext.request.contextPath}/idol/insertIdol" class="btn rgba-blue-strong"
				role="button"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>	
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>