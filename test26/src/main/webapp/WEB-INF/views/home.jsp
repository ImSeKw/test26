<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/module/headerOne.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/module/headerTwo.jsp"></jsp:include>

<section id="services">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading">BOA TEAM</h2>
				<hr class="my-4">
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<!-- <i class="fa fa-4x fa-diamond text-primary mb-3 sr-icons"></i> -->
					<i class="fab fa-reddit-alien fa-4x mb-3 sr-icons n-pink"></i>
					<h3 class="mb-3">SinDock</h3>
					
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<i class="fab fa-napster fa-4x mb-3 sr-icons n-yellow"></i>
					<h3 class="mb-3">YoungShin</h3>
					
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<i class="fas fa-user-secret fa-4x mb-3 sr-icons n-skyblue"></i>
					<h3 class="mb-3">SeungKwon</h3>
					
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<i class="fab fa-qq fa-4x mb-3 sr-icons n-puple"></i>
					<h3 class="mb-3">WonJin</h3>
					
				</div>
			</div>
		</div>
	</div>
</section>

<section class="p-0" > <!-- id="portfolio" -->
	<div class="container-fluid p-0">
		<div class="row no-gutters popup-gallery">
			<c:forEach var="list" items="${list}">
				<div class="col-lg-4 col-sm-6">
					<a href="${pageContext.request.contextPath}/${list.categoryName}/${list.categoryName}List">
						<div class="portfolio-box">
							<img class="img-fluid" src="resources/img/portfolio/thumbnails/${list.categoryNo}_thumbnails.jpg" alt="">
							<div class="portfolio-box-caption">
								<div class="portfolio-box-caption-content">
									<div class="project-name">${list.categoryName}</div>
									<hr class=" light my-3">
								</div>
							</div>
						</div>
					</a>
				</div>
			</c:forEach>
			<div class="col-lg-4 col-sm-6">
				<a class="portfolio-box" href="resources/img/portfolio/fullsize/caterpillar-3107337_1920.jpg">
					<img class="img-fluid" src="resources/img/portfolio/thumbnails/caterpillar-3107337_650.jpg" alt="">
					<div class="portfolio-box-caption">
						<div class="portfolio-box-caption-content">
							<div class="project-category text-faded">PHOTO</div>
							<div class="project-name">Bulldozer</div>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/views/module/bottom.jsp"></jsp:include>
