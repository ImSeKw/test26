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
				<br>
				
				<!-- 검색 -->
				<form action="${pageContext.request.contextPath}/idol/idolList?word=${word}" method="get">
					<input type="text" name="word" class="mb-5 n-black" placeholder="검색어를 입력해주세요">
					<button type="submit" class="btn btn-none n-black">
						<i class="fas fa-search fa-lg"></i>
					</button>
					<!-- 추가 -->
					<a href="${pageContext.request.contextPath}/idol/insertIdol" class="btn center-block bg-green n-white" role="button">add</a>
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
			<jsp:include page="/WEB-INF/views/module/paginationList.jsp"></jsp:include>
		</div>
	</div>
	<!-- 하단 회사정보 추가 -->
	<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>
<!-- end  -->
</section>
</body>
</html>