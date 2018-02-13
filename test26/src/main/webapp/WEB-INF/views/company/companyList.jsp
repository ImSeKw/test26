<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

	
		<div class="row justify-content-md-center">
			<div class="col col-md-auto col-lg-4 text-center">
				<div class="input-group">
					<form action="${pageContext.request.contextPath}/Company/CompanyList?word=${word}" method="get">
						<div class="input-group-prepend">
							<input type="text" name="word" class="form-control" aria-label="Text input with segmented dropdown button">
						</div>
						<button type="submit" class="btn btn-outline-secondary">검색</button>
					</form>
				</div>
			</div>
		</div>
	
	<section class="bg-white">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<h2 class="section-heading">COMPANY LIST</h2>
					<hr class="my-5">
					
					<table class="table bg-white">
						<tbody>
							<c:forEach var="company" items="${list}">
								<tr>
									<td><strong>${company.companyName}</strong></td>
									<td>
										<a href="${pageContext.request.contextPath}/Company/updateCompany?companyId=${company.companyId}"
											class="btn btn-none n-gray" role="button"><i class="fa fa-cog fa-2x" aria-hidden="true"></i></a>
										<a 	href="${pageContext.request.contextPath}/Company/deleteCompany?companyId=${company.companyId}"
											class="btn rgba-red-strong" role="button"><i class="fa fa-times fa-2x" aria-hidden="true"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--검색이 없을떄  추가로 페이징 까지 한다-->
	<c:set var="word" value="${word}" />
				<c:if test="${empty word}">
						<!--페이징 작업  -->
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:set var="currentPage" value="${currentPage}" />
							<c:set var="countPage" value="${countPage}" />
							<c:choose>
								<c:when test="${currentPage eq 1}">
									<li class="page-item disabled"><a class="page-link"
										href="${pageContext.request.contextPath}/Company/CompanyList?currentPage=${currentPage}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
									</a></li>
								</c:when>
								<c:when test="${currentPage ne 1}">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/Company/CompanyList?currentPage=${currentPage-1}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
									</a></li>
								</c:when>
							</c:choose>
							<c:forEach var="i" begin="1" end="${countPage}" step="1">
								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/Company/CompanyList?currentPage=${i}">
										${i} </a></li>
							</c:forEach>
							<c:choose>
								<c:when test="${currentPage eq countPage}">
									<li class="page-item disabled"><a class="page-link"
										href="${pageContext.request.contextPath}/Company/CompanyList?currentPage=${currentPage}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
											class="sr-only">Next</span>
									</a></li>
								</c:when>
								<c:when test="${currentPage ne countPage}">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/Company/CompanyList?currentPage=${currentPage+1}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
											class="sr-only">Next</span>
									</a></li>
								</c:when>
							</c:choose>
						</ul>
					</nav>
				</c:if>
	<!--  홈,추가 버튼 -->
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/"
				class="btn rgba-pink-strong" role="button"> <i
				class="fa fa-home" aria-hidden="true"></i>
			</a> <a href="${pageContext.request.contextPath}/Company/insertCompany"
				class="btn rgba-blue-strong" role="button"> <i
				class="fa fa-plus-circle" aria-hidden="true"></i>
			</a>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>