<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>
</head>
<body>

<!-- start -->
<section class="bg-white">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">IDOL LIST</h2>
				<hr class="my-4">
				
				<!-- 검색 -->
				<form action="${pageContext.request.contextPath}/idol/idolList?word=${word}" method="get">
					<input type="text" name="word" class="mb-5 n-black" placeholder="검색어를 입력해주세요">
					<button type="submit" class="btn btn-none n-black">
						<i class="fas fa-search fa-lg"></i>
					</button>
					<!-- 추가 -->
					<a href="${pageContext.request.contextPath}/idol/insertIdol" class="btn center-block bg-green n-white" role="button">
						<!-- <i class="fa fa-plus fa-lg" aria-hidden="true"></i> -->
						add
					</a>
				</form>
				
				<!-- 리스트 -->
				<table class="table table-hover bg-white">
					<tbody>
						<c:forEach var="list" items="${list}">
							<tr>
								<td><strong>${list.idolName}</strong></td>
								<td>
									<a href="${pageContext.request.contextPath}/idol/updateIdol?idolID=${list.idolID}" class="btn btn-none n-gray"role="button">
										<i class="fa fa-cog fa-2x" aria-hidden="true"></i>
									</a>
									<a href="${pageContext.request.contextPath}/idol/deleteIdol?idolID=${list.idolID}" class="btn rgba-red-strong"role="button">
										<i class="fa fa-times fa-2x" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
		</div>
	</div>
	<!-- 하단 회사정보 추가 -->
	<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>
<!-- end  -->
</section>
</body>
</html>