<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="<c:url value="/resources/css-color/mdb.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css-color/bootstrap.min.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="jumbotron jumbotron-sm">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-lg-12">
					<h1 class="h1">
						LIST <small>BOA</small>
					</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- 
		http://fruitdev.tistory.com/131
	 -->
	<c:set var="loginMember" value='${httpSession.getAttribute("loginMember")}'/>
	<a href="${pageContext.request.contextPath}/member/selectMemberInfo">나의정보</a>
	<a href="${pageContext.request.contextPath}/member/selectMemberInfo">나의정보</a>
	<div class="container">
		<div class="row" style="padding-top: 50px">
			<div class="col-md-4 col-lg-4"></div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-center">
				<div class="list-group list-group-horizontal">
					<a href="${pageContext.request.contextPath}/idol/idolList" class="list-group-item"><strong>IDOL</strong></a>
					<a href="${pageContext.request.contextPath}/city/cityList" class="list-group-item"><strong>CITY</strong></a>
					<a href="${pageContext.request.contextPath}/company/companyList" class="list-group-item"><strong>COMPANY</strong></a>
					<a href="${pageContext.request.contextPath}/country/countryList" class="list-group-item"><strong>COUNTRY</strong></a>
					<a href="${pageContext.request.contextPath}/movie/movieList" class="list-group-item"><strong>MOVIE</strong></a>
				</div>
			</div>
			<div class="col-md-4 col-lg-4"></div>
		</div>
	</div>
</body>
</html>
