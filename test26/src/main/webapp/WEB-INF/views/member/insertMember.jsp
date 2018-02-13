<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<section class="bg-white">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 mx-auto text-center">
				<h2 class="section-heading">MEMBERSHIP</h2>
				<hr class="my-5">
				<form class="form-horizontal" action="${pageContext.request.contextPath}/member/insertMember" method="post">
				  <div class="form-group col-lg-8 mx-auto text-center">
				   	<div class="col-sm-12 text-center">
				      <input type="id" class="form-control" name="memberId" placeholder="id">
				    </div>
				  </div>
				  <div class="form-group col-lg-8 mx-auto text-center">
				    <div class="col-sm-12 text-center"> 
				      <input type="password" class="form-control" name="memberPw" placeholder="password">
				    </div>
				  </div>
				  <div class="form-group col-lg-8 mx-auto text-center"> 
				    <div class="col-sm-offset-2 col-sm-12">
				      <button type="submit" class="btn btn-default">Submit</button>
				    </div>
				  </div>
				</form>
				<%-- <form action="${pageContext.request.contextPath}/member/insertMember" method="post">
		<table border=1>
			<tr>
				<td>회원아이디<td>
				<td><input type="text" name="memberId"><td>
			</tr>
			<tr>
				<td>회원비밀번호</td>
				<td><input type="text" name="memberPw"></td>
			</tr>	
		</table>
		<button type="submit">확인</button>
	</form> --%>
			</div>
		</div>
	</div>
</section>
<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>