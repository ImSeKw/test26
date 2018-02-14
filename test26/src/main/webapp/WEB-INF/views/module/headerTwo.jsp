<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body id="page-top">
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="${pageContext.request.contextPath}/">TUTTO LiST</a>
			<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<c:set var="loginMember" value="${loginMember}"/>
					<c:choose>
						<c:when test="${not empty loginMember}">
							<li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/member/selectMemberInfo">My Account</a></li>
							<li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/member/logoutMember">Sign Out</a></li>
						</c:when>
						<c:when test="${empty loginMember}">
							<div class="center"><button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Click Me</button></div>
							 <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/member/loginMember">Sign In</a></li>
							<li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/member/insertMember">Join us</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	