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
							<li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/member/insertMember">Join us</a></li>
							<li class="nav-item" data-toggle="modal" data-target="#loginModal"><a class="nav-link js-scroll-trigger" href="#">Sign In</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<div class="modal hide" id="loginModal">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">✕</button>
	    </div>
	    <div class="modal-body" style="text-align:center;">
	        <div class="row-fluid">
	            <div class="span10 offset1">
	                <div id="modalTab">
	                    <div class="tab-content">
	                        <div class="tab-pane active" id="login">
	                        	<form action="${pageContext.request.contextPath}/member/loginMember" method="post">
									<input type="text" name="memberId"  placeholder="id">
									<br>
									<input type="text" name="memberPw"  placeholder="password">
									<br>
									<button type="submit" class="btn btn-primary">Sign in</button>
								</form>
	                         </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	
