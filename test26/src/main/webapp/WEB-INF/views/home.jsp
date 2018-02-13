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
					<i class="fa fa-4x fa-diamond text-primary mb-3 sr-icons"></i>
					<h3 class="mb-3">Sturdy Templates</h3>
					<p class="text-muted mb-0">Our templates are updated regularly so they don't break.</p>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<i class="fa fa-4x fa-paper-plane text-primary mb-3 sr-icons"></i>
					<h3 class="mb-3">Ready to Ship</h3>
					<p class="text-muted mb-0">You can use this theme as is, or you can make changes!</p>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<i class="fa fa-4x fa-newspaper-o text-primary mb-3 sr-icons"></i>
					<h3 class="mb-3">Up to Date</h3>
					<p class="text-muted mb-0">We update dependencies to keep things fresh.</p>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
				<div class="service-box mt-5 mx-auto">
					<i class="fa fa-4x fa-heart text-primary mb-3 sr-icons"></i>
					<h3 class="mb-3">Made with Love</h3>
					<p class="text-muted mb-0">You have to make your websites with love these days!</p>
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
