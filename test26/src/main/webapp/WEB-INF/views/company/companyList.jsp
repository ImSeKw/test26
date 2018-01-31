<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	 	  <h2 class="text-center">COMPANY LIST</h2>
	     <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>COMPANYNAME</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="company" items="${list}">
	      <tr>
	        <td>${company.companyId}</td>
	        <td>${company.companyName}</td>
	      </tr>
	      </c:forEach>
	     </tbody>
	  </table>
	</div>
</body>
</html>