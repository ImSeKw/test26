<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<section id="services">
	<div class="container">
		<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">MEMBERSHIP</h2>
				<hr class="my-4">
		</div>
		<div class="col-lg-8 mx-auto text-center">
		</div>	
		<div class="col-lg-8 mx-auto text-center">
			
				<form action="${pageContext.request.contextPath}/member/insertMember" method="post" id="companyAdd">
				<!-- 	<h3 class="mb-3 n-white"></h3> -->
					<input type="text" name="memberId" id="memberId" class="mb-3" placeholder="id를 입력하세요">
					<br>
					<input type="text" name="memberPw" id="memberPw" class="mb-3" placeholder="password를 입력하세요">
					<br>
					<button type="submit" id="insertButton" class="btn btn-none n-black">
						<i class="fa fa-check-circle fa-2x"></i>
					</button>
				</form>
			
		</div>
	</div>	
		
</section>	


<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>