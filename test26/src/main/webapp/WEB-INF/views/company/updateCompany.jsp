<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>COMPANY UPDATE</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
	<script>
		$(document).ready(function() {
			$('#updateButton').click(function() {
				if ($('#companyName').val() == '') {
					alert('회사를 입력해주세요.')
					$('#companyName').focus();
				} else {
					$('#companyUpdate').submit();	
				}
			})
			/* 취소버튼 경로 설정 */
			$('#cancelButton').click(function(){
				document.location.href="<%= request.getContextPath() %>/company/companyList"
			});
		});
	</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/module/top1.jsp"></jsp:include>
		COMPANY <small>UPDATE</small>
	<jsp:include page="/WEB-INF/views/module/top2.jsp"></jsp:include>
	<div class="row justify-content-md-center">
		<div class="col-lg-4"></div>
		<div class="col col-md-auto col-lg-4 text-center">
			<h2 class="text-center"></h2>
			<form action="${pageContext.request.contextPath}/company/updateCompany" method="post" id="companyUpdate">
				<input type="hidden" name="companyId" value="${company.companyId}">
				<table class="table table-hover">
					<thead class="mdb-color darken-3">
						<tr class="text-white">
							<td><strong>COMPANY</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>	
							<td><input type="text" name="companyName" id="companyName" value="${company.companyName}"></td>
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