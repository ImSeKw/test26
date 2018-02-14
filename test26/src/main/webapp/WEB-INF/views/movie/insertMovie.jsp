<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			$('#insertButton').click(function() {
				if ($('#movieName').val() == '') {
					alert('영화를 입력해주세요.')
					$('#movieName').focus();
				} else {
					$('#movieAdd').submit();	
				}
			})
			/* 취소버튼 경로 설정 */
			$('#cancelButton').click(function(){
				document.location.href="<%= request.getContextPath() %>/movie/movieList"
			});
		});
	</script>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>
<section id="services">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">MOVIE</h2>
				<hr class="my-4">
			</div>
		</div>
	</div>
</section>

	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<form action="${pageContext.request.contextPath}/movie/insertMovie" method="post" id="movieAdd">
					<h3 class="mb-3 n-white"></h3>
					<input type="text" name="movieName" id="movieName" class="mb-3 bg-white input-black" placeholder="이곳에 영화 이름을 입력하세요">
					<br>
					<button type="button" id="insertButton" class="btn btn-none n-black">
						<i class="fa fa-check-circle fa-2x"></i>
					</button>
					<!-- 취소버튼 -->
					<button type="button" id="cancelButton" class="btn btn-none n-black">
						<i class="fa fa-times-circle fa-2x"></i>
					</button>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>