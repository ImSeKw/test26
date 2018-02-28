<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			/* 도시 공백 설정 */
			$('#updateButton').click(function() {
				if ($('#cityName').val() == '') {
					alert('도시를 입력해주세요.')
					$('#cityName').focus();
				} else {
					$('#cityUpdate').submit();	
				}
			})
			/* 취소버튼 경로 설정 */
			$('#cancelButton').click(function(){
				document.location.href="<%= request.getContextPath() %>/city/cityList"
			});
			/* 이미지 삭제 */
			$('.photo-of-list').click(function(){
				document.location.href="<%= request.getContextPath() %>/city/deleteCityFile?cityId="
			});
		});
	</script>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<section id="services">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">CITY</h2>
				<hr class="my-4">
			</div>
		</div>
	</div>
</section>

<section class="bg-black">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<form action="${pageContext.request.contextPath}/city/updateCity" method="post" id="cityUpdate">
					<input type="hidden" name="cityId" value="${cityAndCityFile.cityId}">
					<h3 class="mb-3 n-white"></h3>
					<input type="text" name="cityName" id="cityName" class="mb-3 bg-black input-white" value="${cityAndCityFile.cityName}" placeholder="이곳에 도시 이름을 입력하세요">
					<br>
					<c:forEach var="cityFile" items="${cityAndCityFile.list}">
						<button type="button" class="btn photo-of-list" name="${cityFile.cityFileId}">
							<img src="${pageContext.request.contextPath}/resources/upload/city/${cityFile.fileName}.${cityFile.fileExt}" width="162" height="87">
						</button>
					</c:forEach>
					<br>
					<button type="button" id="updateButton" class="btn btn-none n-white">
						<i class="fa fa-check-circle fa-2x"></i>
					</button>
					<!-- 취소버튼 -->
					<button type="button" id="cancelButton" class="btn btn-none n-white">
						<i class="fa fa-times-circle fa-2x"></i>
					</button>
				</form>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>

