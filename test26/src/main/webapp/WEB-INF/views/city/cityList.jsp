<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

	<!-- 검색 -->
	<div class="row justify-content-md-center">
		<div class="col col-md-auto col-lg-4 text-center">
			<div class="input-group">
				<form action="${pageContext.request.contextPath}/city/cityList?word=${word}" method="get">
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
	
<section class="bg-white">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">CITY LIST</h2>
				<hr class="my-5">
				<form action="${pageContext.request.contextPath}/city/cityList?word=${word}" method="get">
						<input type="text" name="word" class="mb-3 n-black" placeholder="검색어를 입력해주세요.">
						<button type="submit" class="btn btn-none n-black">
							<i class="fas fa-search"></i>
						</button>
				</form>
				<a href="${pageContext.request.contextPath}/city/insertCity" class="btn n-blue" role="button">
					<i class="fa fa-plus fa-2x" aria-hidden="true"></i>
				</a>
				<table class="table bg-white">
					<tbody>
						<c:forEach var="list" items="${list}">
							<tr>
								<td><strong>${list.cityName}</strong></td>
								<td>
									<a href="${pageContext.request.contextPath}/city/updateCity?cityId=${list.cityId}" class="btn btn-none n-gray"role="button">
										<i class="fa fa-cog fa-2x" aria-hidden="true"></i>
									</a>
									<a href="${pageContext.request.contextPath}/city/deleteCity?cityId=${list.cityId}" class="btn rgba-red-strong"role="button">
										<i class="fa fa-times fa-2x" aria-hidden="true"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="${pageContext.request.contextPath}/city/insertCity" class="btn n-blue" role="button">
					<i class="fa fa-plus fa-2x" aria-hidden="true"></i>
				</a>
			</div>
		</div>
	</div>
</section>

	<!-- cityList -->
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<table class="table table-hover">
				<thead class="mdb-color darken-3">
					<tr class="text-white">
						<td><strong>No.</strong></td>
						<td><strong>CITY</strong></td>
						<td><strong>UPDATE</strong></td>
						<td><strong>DELETE</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cityList" items="${list}">
						<tr>
							<td><strong>${cityList.cityId}</strong></td>
							<td><strong>${cityList.cityName}</strong></td>
							<td><a href="${pageContext.request.contextPath}/city/updateCity?cityId=${cityList.cityId}" class="btn rgba-teal-strong"role="button"><i class="fa fa-wrench fa-3x" aria-hidden="true"></i></a></td>
							<td><a href="${pageContext.request.contextPath}/city/deleteCity?cityId=${cityList.cityId}" class="btn rgba-red-strong"role="button"><i class="fa fa-times-circle fa-1g" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4"></div>
	</div>
	
	<c:choose>
		<c:when test="${empty word}">
			<!-- 페이징 작업 -->
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<c:set var="currentPage" value="${currentPage}"/>
					<c:set var="countPage" value="${countPage}"/>
					<c:choose>
						<c:when test="${currentPage eq 1}">
							<li class="page-item disabled">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne 1}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage-1}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="1" end="${countPage}" step="1">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${i}">
								${i}
							</a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPage eq countPage}">
							<li class="page-item disabled">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne countPage}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage+1}" aria-label="Next">
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
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage}&word=${word}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne 1}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage-1}&word=${word}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
								</a>
							</li>
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="1" end="${countPage}" step="1">
						<li class="page-item">
							<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${i}&word=${word}">
								${i}
							</a>
						</li>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPage eq countPage}">
							<li class="page-item disabled">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage}&word=${word}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						</c:when>
						<c:when test="${currentPage ne countPage}">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${currentPage+1}&word=${word}" aria-label="Next">
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
	
	<!-- 홈 및 추가 버튼 -->
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			<a href="${pageContext.request.contextPath}/" class="btn rgba-pink-strong" role="button">
				<i class="fa fa-home" aria-hidden="true"></i>
			</a>
			<a href="${pageContext.request.contextPath}/city/insertCity" class="btn rgba-blue-strong" role="button">
				<i class="fa fa-plus-circle" aria-hidden="true"></i>
			</a>
		</div>
		<div class="col-lg-4"></div>
	</div>

<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>
