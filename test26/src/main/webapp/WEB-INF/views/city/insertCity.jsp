<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
	<script>
		$(document).ready(function() {
			$('#insertButton').click(function() {
				if ($('#cityName').val() == '') {
					alert('도시를 입력해주세요.')
					$('#cityName').focus();
				} else {
					$('#cityAdd').submit();	
				}
			})
		});
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/city/insertCity" method="post" id="cityAdd">
		<table>
			<tr>
				<td>도시 이름</td>
				<td><input type="text" name="cityName" id="cityName"></td>
			</tr>
		</table>
		<button type="button" id="insertButton">도시입력</button>
	</form>
</body>
</html>
