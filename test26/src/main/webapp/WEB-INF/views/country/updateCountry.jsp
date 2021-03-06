<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>COUNTRY UPDATE</title>
	<script>
		$(document).ready(function() {
			$('#updateButton').click(function() {
				if ($('#countryName').val() == '') {
					alert('나라를 입력해주세요.')
					$('#countryName').focus();
				} else {
					$('#countryUpdate').submit();
				}
			})
			/* 취소버튼 경로 설정 */
			$('#cancelButton').click(function(){
				document.location.href="<%= request.getContextPath() %>/country/countryList"
			});
		});
	</script>
</head>
<body>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<form action="${pageContext.request.contextPath}/country/updateCountry?countId=${country.countryId}" method="post" id="countryUpdate">
				<input type="hidden" name="countryId" value="${country.countryId}">
				<table class="table table-hover">
					<thead class="mdb-color darken-3">
						<tr class="text-white">
							<td><strong>COUNTRY</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td><input type="text" name="countryName" id="countryName" value="${country.countryName}"></td>
						</tr>
						<tr>
							<td>
								<button type="button" id="updateButton" class="btn rgba-blue-strong">
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