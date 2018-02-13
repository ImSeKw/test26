<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>
	<div class="row justify-content-md-center">
		<div class="col col-md-auto col-lg-4 text-center">
			<div class="input-group">
				<form action="${pageContext.request.contextPath}/Movie/MovieList?word=${word}" method="get">
					<div class="input-group-prepend">
						<button type="submit" class="btn btn-outline-secondary">검색</button>
						<!-- 
						<button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Action</a>
							<a class="dropdown-item" href="#">Another action</a>
							<a class="dropdown-item" href="#">Something else here</a>
							<div role="separator" class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Separated link</a>
						</div>
						 -->
					</div>
					<input type="text" name="word" class="form-control" aria-label="Text input with segmented dropdown button">
				</form>
			</div>
		</div>
	</div>
	
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<table class="table table-hover">
				<thead class="mdb-color darken-3">
					<tr class="text-white">
						<td><strong>No.</strong></td>
						<td><strong>MOVIE</strong></td>
						<td><strong>UPDATE</strong></td>
						<td><strong>DELETE</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="movieList" items="${list}">
						<tr>
							<td><strong>${movieList.movieId}</strong></td>
							<td><strong>${movieList.movieName}</strong></td>
							<td><a href="${pageContext.request.contextPath}/Movie/updateMovie?movieId=${movieList.movieId}" class="btn rgba-teal-strong"role="button"><i class="fa fa-wrench fa-3x" aria-hidden="true"></i></a></td>
							<td><a href="${pageContext.request.contextPath}/Movie/deleteMovie?movieId=${movieList.movieId}" class="btn rgba-red-strong"role="button"><i class="fa fa-times-circle fa-1g" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4"></div>
	</div>
	
	<c:choose>
		<c:when test="${not empty word}">
			<!-- 페이징 작업 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:set var="currentPage" value="${currentPage}"/>
					<c:set var="countPage" value="${countPage}"/>
					<c:choose>
						<c:when test="${currentPage eq 1}">
							<li class="page-item disabled">
								<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage}&word=${word}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne 1}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage-1}&word=${word}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="1" end="${countPage}" step="1">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${i}&word=${word}">
								${i}
							</a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPage eq countPage}">
							<li class="page-item disabled">
								<a class="page-link disabled" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage}&word=${word}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne countPage}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage+1}&word=${word}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</c:when>
					</c:choose>
				</ul>
			</nav>
		</c:when>
		<c:otherwise>
		<!-- 페이징 작업 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:set var="currentPage" value="${currentPage}"/>
					<c:set var="countPage" value="${countPage}"/>
					<c:choose>
						<c:when test="${currentPage eq 1}">
							<li class="page-item disabled">
								<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne 1}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="1" end="${countPage}" step="1">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${i}">
								${i}
							</a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPage eq countPage}">
							<li class="page-item disabled">
								<a class="page-link disabled" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne countPage}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/Movie/MovieList?currentPage=${currentPage+1}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</c:when>
					</c:choose>
				</ul>
			</nav>
		</c:otherwise>
	</c:choose>
	
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/" class="btn rgba-pink-strong"
				role="button"><i class="fa fa-home" aria-hidden="true"></i></a>
			<a href="${pageContext.request.contextPath}/Movie/insertMovie" class="btn rgba-blue-strong"
				role="button"><i class="fa fa-plus-circle" aria-hidden="true"></i></a>	
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>