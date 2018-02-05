<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%-- 
	<link href="<c:url value="/resources/css-color/mdb.min.css" />"
		rel="stylesheet">
	<link href="<c:url value="/resources/css-color/bootstrap.min.css" />"
		rel="stylesheet">
	 --%>
		
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css-color/mdb.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css-color/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#insertButton').click(function() {
				if ($('#cityName').val() == '') {
					alert('도시를 입력해주세요.')
					$('#cityName').focus();
				}
			})
		});
	</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/city/insertCity"
		method="post">
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
