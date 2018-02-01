<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
</head>
<body>
	
	<div class="jumbotron jumbotron-sm">
	    <div class="container">
	        <div class="row">
	            <div class="col-sm-12 col-lg-12">
	                <h1 class="h1">
	                    LIST<small>BOA</small></h1>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="container">
	
		<div class="row" style="padding-top:50px">
			<div class="col-md-4 col-lg-4"></div>	
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-center">
	            <div class="list-group list-group-horizontal">
	            	
	                <a href="${pageContext.request.contextPath}/idol/idolList" class="list-group-item"><strong>IDOL</strong></a>
	                <a href="${pageContext.request.contextPath}/city/cityList" class="list-group-item"><strong>CITY</strong></a>
	                <a href="${pageContext.request.contextPath}/company/companyList" class="list-group-item"><strong>CONPANY</strong></a>
	                <a href="${pageContext.request.contextPath}/country/countryList" class="list-group-item"><strong>COUNTRY</strong></a>
	                <a href="${pageContext.request.contextPath}/movie/movieList" class="list-group-item"><strong>MOVIE</strong></a>
            	</div>
        	</div>
        	<div class="col-md-4 col-lg-4"></div>
        </div>
        <div class="col-md-4 col-lg-4"></div>
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-center">
        <a href="${pageContext.request.contextPath}/" class="btn btn-info" role="button"><span class="glyphicon glyphicon-home"></span></a>	
    	</div>
    	<div class="col-md-4 col-lg-4"></div>
    </div>
    
</body>
</html>