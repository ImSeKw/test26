<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>
	<!-- JQUERY 공백시 경고창  -->
	<script>
		$(document).ready(function() {
			$('#insertButton').click(function() {
				if ($('#idolName').val() == '') {
					alert('아이돌명을 입력해주세요.')
					$('#idolName').focus();
				} else {
					$('#idolAdd').submit();	
				}
			})
			/* 취소버튼 경로 설정 */
			$('#cancelButton').click(function(){
				document.location.href="<%= request.getContextPath() %>/idol/idolList"
			});
		});
	</script>
</head>
<body>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<form action="${pageContext.request.contextPath}/idol/insertIdol" id="idolAdd" method = "post">
				<table class="table table-hover">
					<thead class="mdb-color darken-3">
						<tr class="text-white">
							<td><strong>IDOL</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" name="idolName" id="idolName" placeholder="이곳에 아이돌 이름을 입력하세요"></td>
						</tr>
						<tr>
							<td>
								<button type="button" id="insertButton" class="btn rgba-blue-strong">
								<i class="fa fa-check-circle" aria-hidden="true"></i>
								</button>
								<!-- 취소버튼 -->
								<button type="button" id="cancelButton" class="btn danger-color-dark">
								<i class="fa fa-times-circle" aria-hidden="true"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>