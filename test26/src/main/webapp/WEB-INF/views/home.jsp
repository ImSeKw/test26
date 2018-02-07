<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>home</title>
	<%@ include file="/WEB-INF/views/module/head.jsp" %>
</head>
<body>
	<jsp:include page="/WEB-INF/views/module/top1.jsp"></jsp:include>
		LIST <small>BOA</small>
	<jsp:include page="/WEB-INF/views/module/top2.jsp"></jsp:include>
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
