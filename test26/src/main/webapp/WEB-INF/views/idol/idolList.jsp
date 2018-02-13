<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>
</head>
<body>

<!-- 검색 -->
<div class="row justify-content-md-center">
	<div class="col col-md-auto col-lg-4 text-center">
		<div class="input-group">
			<form action="${pageContext.request.contextPath}/idol/idolList?word=${word}" method="get">
				<div class="input-group-prepend">
					<button type="submit" class="btn btn-outline-secondary">검색</button>
				</div>
				<input type="text" name="word" class="form-control" aria-label="Text input with segmented dropdown button">
			</form>
		</div>
	</div>
</div>
	
<!-- start -->
<section class="bg-white">
	<!-- IDOL LIST -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">IDOL LIST</h2>
				<hr class="my-5">
				<table class="table bg-white">
					<tbody>
						<c:forEach var="list" items="${list}">
							<tr>
								<td><strong>${list.idolName}</strong></td>
								<td>
									<a href="${pageContext.request.contextPath}/idol/updateidol?idolID=${idolList.idolID}" class="btn btn-none n-gray"role="button">
										<i class="fa fa-cog fa-2x" aria-hidden="true"></i>
									</a>
									<a href="${pageContext.request.contextPath}/idol/deleteidol?idolID=${idolList.idolID}" class="btn rgba-red-strong"role="button">
										<i class="fa fa-times fa-2x" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- 페이징 -->
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:set var="currentPage" value="${currentPage}"/>
			<c:set var="countPage" value="${countPage}"/>
			<c:choose>
				<c:when test="${currentPage eq 1}">
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage}&word=${word}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
						</a>
					</li>
				</c:when>
				<c:when test="${currentPage ne 1}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage-1}&word=${word}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
						</a>
					</li>
				</c:when>
			</c:choose>
			<c:forEach var="i" begin="1" end="${countPage}" step="1">
				<li class="page-item">
					<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${i}&word=${word}">
						${i}
					</a>
				</li>
			</c:forEach>
			<c:choose>
				<c:when test="${currentPage eq countPage}">
					<li class="page-item disabled">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage}&word=${word}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</li>
				</c:when>
				<c:when test="${currentPage ne countPage}">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage+1}&word=${word}" aria-label="Next">
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
	<!-- 하단 회사정보 추가 -->
	<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>
<!-- end  -->
</section>
</body>
</html>