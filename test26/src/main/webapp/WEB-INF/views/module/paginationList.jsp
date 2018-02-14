<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 검색했을 경우와 아닐경우 페이징 작업 -->
<div class="col-lg-8 mx-auto text-center">
	<c:choose>
		<c:when test="${empty word}">
			<!-- 검색하지 않았을 때 페이징 작업 -->
				<div class="pagination">
					<c:set var="currentPage" value="${currentPage}"/>
					<c:set var="countPage" value="${countPage}"/>
					<c:choose>
						<c:when test="${currentPage eq 1}">
							<a class="disabled" href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage}" aria-label="Previous">
								<i class="fas fa-caret-left"></i>
							</a>
						</c:when>
						<c:when test="${currentPage ne 1}">
							<a href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage-1}" aria-label="Previous">
								<i class="fas fa-caret-left"></i>
							</a>
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="1" end="${countPage}" step="1">
						<a href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${i}">
							${i}
						</a>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPage eq countPage}">
							<a class="disabled" href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage}" aria-label="Next">
								<i class="fas fa-caret-right"></i>
							</a>
						</c:when>
						<c:when test="${currentPage ne countPage}">
							<a href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage+1}" aria-label="Next">
								<i class="fas fa-caret-right"></i>
							</a>
						</c:when>
					</c:choose>
				</div>
		</c:when>
		<c:otherwise>
			<!-- 검색했을 때 페이징 작업 -->
			<div class="pagination">
				<c:set var="currentPage" value="${currentPage}"/>
				<c:set var="countPage" value="${countPage}"/>
				<c:choose>
					<c:when test="${currentPage eq 1}">
						<a class="disabled" href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage}&word=${word}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
						</a>
					</c:when>
					<c:when test="${currentPage ne 1}">
						<a href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage-1}&word=${word}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
						</a>
					</c:when>
				</c:choose>
				<c:forEach var="i" begin="1" end="${countPage}" step="1">
					<a href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${i}&word=${word}">
						${i}
					</a>
				</c:forEach>
				<c:choose>
					<c:when test="${currentPage eq countPage}">
						<a class="disabled" href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage}&word=${word}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</c:when>
					<c:when test="${currentPage ne countPage}">
						<a href="${pageContext.request.contextPath}/${category}/${category}List?currentPage=${currentPage+1}&word=${word}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
							<span class="sr-only">Next</span>
						</a>
					</c:when>
				</c:choose>
			</div>
		</c:otherwise>
	</c:choose>
</div>
