<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>companyList</h1>


	<table border="1">
		<c:forEach var="company" items="${list}">
		<thead>
			<tr>
			<td>아이디</td>
			<td>${company.companyId}</td>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td>회사명</td>
			<td>${company.companyName}</td>
			</tr>
		</tbody>
		</c:forEach>
	</table>

</body>
</html>