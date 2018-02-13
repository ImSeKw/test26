<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>COMPANY LIST</title>
</head>
<body>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<table class="table table-hover">
				<thead class="mdb-color darken-3">
					<tr class="text-white">
						<td><strong>No.</strong></td>
						<td><strong>COUNTRY</strong></td>
						<td><strong>UPDATE</strong></td>
						<td><strong>DELETE</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="countryList" items="${list}">
						<tr>
							<td><strong>${countryList.countryId}</strong></td>
							<td><strong>${countryList.countryName}</strong></td>
							<td><a
								href="${pageContext.request.contextPath}/country/updateCountry?countryId=${countryList.countryId}"
								class="btn rgba-teal-strong" role="button"><i
									class="fa fa-wrench fa-3x" aria-hidden="true"></i></a></td>
							<td><a
								href="${pageContext.request.contextPath}/country/deleteCountry?countryId=${countryList.countryId}"
								class="btn rgba-red-strong" role="button"><i
									class="fa fa-times-circle fa-1g" aria-hidden="true"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col col-xs-12 col-sm-12 col-md-auto col-lg-4 text-center">
			    <!-- 아이디 검색 -->
		    <div>
		        <form method="post"	action="${pageContext.request.contextPath}/country/countryList">
		            나라 검색 : <input type="text" name="word"/><input type="submit" value="검색"/>
		        </form>
		    </div>
			<a href="${pageContext.request.contextPath}/"
				class="btn rgba-pink-strong" role="button"> <i
				class="fa fa-home" aria-hidden="true"></i>
			</a> <a href="${pageContext.request.contextPath}/country/insertCountry"
				class="btn rgba-blue-strong" role="button"> <i
				class="fa fa-plus-circle" aria-hidden="true"></i>
			</a> 
			<c:set var="currentPage" value="${currentPage}"/>
			<c:set var="prev" value="${prev}"/>
			<c:set var="next" value="${next}"/>
			<c:choose>
				<c:when test="${prev == false && next == true}">	
					<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
						${i}
					</c:forEach>	
					<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+5}"
					class="btn btn-danger" role="button">다음
					</a> 
					<a href="${pageContext.request.contextPath}/country/countryList"
					class="btn btn-danger" role="button">수정중입니다
					</a> 
				</c:when>				
				<c:when test ="${prev == true && next == false}"> 
				 	<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-5}"
					class="btn btn-danger" role="button">이전
					</a>
					<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" >
						${i}
					</c:forEach>
					<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+5}"
					class="btn btn-danger" role="button">다음
					</a>
				</c:when>
				<c:when test ="${prev == true && next == true }">
				 	<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-1}"
					class="btn btn-danger" role="button">이전
					</a>
				</c:when>
			</c:choose>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>