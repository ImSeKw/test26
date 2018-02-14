<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<section class="bg-white">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">COMPANY LIST</h2>
				<hr class="my-5">
				<br>
				<!--검색  -->
				<form action="${pageContext.request.contextPath}/company/companyList?word=${word}" method="get">
					<input type="text" name="word" class="mb-5 n-black"
						placeholder="검색어를 입력해주세요">
					<button type="submit" class="btn btn-none n-black">
						<i class="fas fa-search fa-lg"></i>
					</button>
					<!-- 추가 -->
					<a href="${pageContext.request.contextPath}/company/insertCompany"
						class="btn center-block bg-green n-white" role="button"> add </a>
				</form>
				<!--리스트 -->
				<table class="table bg-white">
					<tbody>
						<c:forEach var="company" items="${list}">
							<tr>
								<td><strong>${company.companyName}</strong></td>
								<td><a
									href="${pageContext.request.contextPath}/company/updateCompany?companyId=${company.companyId}"
									class="btn btn-none n-gray" role="button"><i
										class="fa fa-cog fa-2x" aria-hidden="true"></i> </a> <a
									href="${pageContext.request.contextPath}/company/deleteCompany?companyId=${company.companyId}"
									class="btn rgba-red-strong" role="button"><i
										class="fa fa-times fa-2x" aria-hidden="true"></i> </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<!--검색이 없을떄  추가로 페이징 까지 한다-->
			<div class="col-lg-8 mx-auto text-center">
				<c:choose>
					<c:when test="${empty word}">
					<!--검색전 페이징 작업 -->
						<div class="pagination">
							<c:set var="currentPage" value="${currentPage}" />
							<c:set var="countPage" value="${countPage}" />
							<c:choose>
								<c:when test="${currentPage eq 1}">
									<a class="disabled" href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
									</a>
								</c:when>
								<c:when test="${currentPage ne 1}">
									<a href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage-1}" aria-label="Previous"> 
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
									</a>
								</c:when>
							</c:choose>
							<c:forEach var="i" begin="1" end="${countPage}" step="1">
								<a href="${pageContext.request.contextPath}/company/companyList?currentPage=${i}">
										${i} 
								</a>
							</c:forEach>
							<c:choose>
								<c:when test="${currentPage eq countPage}">
									<a class="disabled" href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											<span aria-hidden="true">&raquo;</span>
											<span class="sr-only">Next</span>
									</a>
								</c:when>
								<c:when test="${currentPage ne countPage}">
									<a href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage+1}" aria-label="Next"> 
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
									</a>
								</c:when>
							</c:choose>
						</div>
					</c:when>
					<c:otherwise>
					<!--검색했을때 페이징 작업  -->
						<div class="pagination">
							<c:set var="currentPage" value="${currentPage}"/>
							<c:set var="countPage" value="${countPage}"/>
							<c:choose>
								<c:when test="${currentPage eq 1}">
									<a class="disabled" href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage}&word=${word}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
									</a>
								</c:when>
								<c:when test="${currentPage ne 1}">
									<a href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage-1}&word=${word}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
									</a>
								</c:when>
							</c:choose>
							<c:forEach var="i" begin="1" end="${countPage}" step="1">
								<a href="${pageContext.request.contextPath}/company/companyList?currentPage=${i}&word=${word}">
									${i}
								</a>
							</c:forEach>
							<c:choose>
								<c:when test="${currentPage eq countPage}">
									<a class="disabled" href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage}&word=${word}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
									</a>
								</c:when>
								<c:when test="${currentPage ne countPage}">
									<a href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage+1}&word=${word}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
									</a>
								</c:when>
							</c:choose>
						</div>
					</c:otherwise>		
				</c:choose>
			</div>
		</div>
	</div>
</section>
<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>