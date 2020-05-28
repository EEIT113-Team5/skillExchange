<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zt-TW">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ---------------------要加的部份-------------------- -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Bingo One page parallax responsive HTML Template ">

<meta name="author" content="Themefisher.com">

<title>SkillExchange</title>

<!-- Mobile Specific Meta
  ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="imagestemp/favicon.png" />

<!-- CSS
  ================================================== -->
<!-- Themefisher Icon font -->
<link rel="stylesheet" href="pluginstemp/themefisher-font/style.css">
<!-- bootstrap.min css -->
<link rel="stylesheet"
	href="pluginstemp/bootstrap/css/bootstrap.min.css">
<!-- Lightbox.min css -->
<link rel="stylesheet"
	href="pluginstemp/lightbox2/dist/css/lightbox.min.css">
<!-- animation css -->
<link rel="stylesheet" href="pluginstemp/animate/animate.css">
<!-- Slick Carousel -->
<link rel="stylesheet" href="pluginstemp/slick/slick.css">
<!-- Main Stylesheet -->
<link rel="stylesheet" href="csstemp/style.css">
<!-- ---------------------要加的部份-------------------- -->
<title>刊登資訊-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link href="css/pubcss.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>

<link rel="icon" href="img/fav-icon.png" type="image/x-icon" />
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Sierra</title>

<!-- Icon css link -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Rev slider css -->
<link href="vendors/revolution/css/settings.css" rel="stylesheet">
<link href="vendors/revolution/css/layers.css" rel="stylesheet">
<link href="vendors/revolution/css/navigation.css" rel="stylesheet">

<!-- Extra plugin css -->
<link href="vendors/owl-carousel/owl.carousel.min.css" rel="stylesheet">
<link href="vendors/magnify-popup/magnific-popup.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<style>
</style>

</head>

<!-- ---------------------要加的部份-------------------- -->
<body id="body">
	<jsp:include page="/fragment/top1.jsp" />

	<section class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>刊登詳情</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container">

		<c:forEach var="mylistimfor" items="${publishImfor}">
			<!--================Banner Area =================-->
			<section class="banner_area">
				<div class="container">
					<div class="banner_inner_text">
						<h2>Publish Imformation</h2>
						<p>Your Title:${mylistimfor.myTitle}</p>
					</div>
				</div>
			</section>
			<!--================End Banner Area =================-->
			<div class="resume">
				<div class="publishleft" style="display: inline-block">
					<img src="${mylistimfor.publishPic}" width="250px"
						style="display: block; margin: auto; margin-top: 25px; box-shadow: 2px 2px 5px #5D9DC7">

					<h2 class="pubtitle">${mylistimfor.myTitle}</h2>
					<hr style="border: 0; background-color: #009bdd; height: 1px">
					<p class="imformation">
						<b>刊登地區:${mylistimfor.myArea}</b><br> <br> <b>希望地點:${mylistimfor.myPlace}</b><br>
						<br> <br> <b>刊登地點:${mylistimfor.myCity}</b><br> <br>
						<b>刊登鄉鎮:${mylistimfor.myDistrict}</b><br> <br> <b>刊登路名:${mylistimfor.myRoad}</b><br>
						<br>
					</p>
					<div class="icon"></div>
				</div>
				<div class="publishright" style="display: inline-block,">
					<h3 class="about">
						刊登內容
						<hr>
						<p>
						<h5>
							<b>▸內容</b>
						</h5>
						<br>
						<h6>&nbsp;&nbsp;&nbsp;${mylistimfor.myDetail}.</h6>
						</p>
					</h3>
					<br>
					<h3 class="education">
						刊登技能
						<hr>
						<p>
						<h5>
							<b>▸自己的技能</b>
						</h5>
						<br>
						<h6>&nbsp;&nbsp;&nbsp;${mylistimfor.myOwnSkill}</h6>
						</p>
						<p>
						<h5>
							<b>▸想學的技能</b>
						</h5>
						<br>
						<h6>&nbsp;&nbsp;&nbsp;${mylistimfor.myWantSkill}</h6>
						</p>
					</h3>
					<h3 class="esperience">
						備註
						<hr>
						<p>
						<h5>
							<b>▸備註</b>
						</h5>
						<br>
						<h6>&nbsp;&nbsp;&nbsp;${mylistimfor.myMark}</h6>
						</p>
					</h3>
				</div>
			</div>
			<!--================End Testimonials Slider Area =================-->
		</c:forEach>

		<form action="myPublish" method="GET"
			enctype="application/x-www-form-urlencoded">

			<input type='submit' value='我的刊登'>
		</form>


	</div>

	<!-- ---------------------要加的部份-------------------- -->
	<jsp:include page="/fragment/bottom.jsp" />
	<!-- ---------------------要加的部份-------------------- -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- Rev slider js -->
	<script src="vendors/revolution/js/jquery.themepunch.tools.min.js"></script>
	<script src="vendors/revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script
		src="vendors/revolution/js/extensions/revolution.extension.actions.min.js"></script>
	<script
		src="vendors/revolution/js/extensions/revolution.extension.video.min.js"></script>
	<script
		src="vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<script
		src="vendors/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
	<script
		src="vendors/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
	<script
		src="vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
	<!-- Extra plugin css -->
	<script src="vendors/counterup/jquery.waypoints.min.js"></script>
	<script src="vendors/counterup/jquery.counterup.min.js"></script>
	<script src="vendors/counterup/apear.js"></script>
	<script src="vendors/counterup/countto.js"></script>
	<script src="vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="vendors/magnify-popup/jquery.magnific-popup.min.js"></script>
	<script src="js/smoothscroll.js"></script>

	<script src="js/theme.js"></script>
	<!-- ---------------------要加的部份-------------------- -->
	<!-- 
    Essential Scripts
    =====================================-->
	<!-- Main jQuery -->
	<script src="pluginstemp/jquery/jquery.min.js"></script>
	<!-- Google Map -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu5nZKbeK-WHQ70oqOWo-_4VmwOwKP9YQ"></script>
	<script src="pluginstemp/google-map/gmap.js"></script>

	<!-- 	<!-- Form Validation -->
	-->
	<script src="pluginstemp/form-validation/jquery.form.js"></script>
	<script src="pluginstemp/form-validation/jquery.validate.min.js"></script>

	<!-- Bootstrap4 -->
	<script src="pluginstemp/bootstrap/js/bootstrap.min.js"></script>
	<!-- Parallax -->
	<script src="pluginstemp/parallax/jquery.parallax-1.1.3.js"></script>
	<!-- lightbox -->
	<script src="pluginstemp/lightbox2/dist/js/lightbox.min.js"></script>
	<!-- Owl Carousel -->
	<script src="pluginstemp/slick/slick.min.js"></script>
	<!-- filter -->
	<script src="pluginstemp/filterizr/jquery.filterizr.min.js"></script>
	<!-- Smooth Scroll js -->
	<script src="pluginstemp/smooth-scroll/smooth-scroll.min.js"></script>

	<!-- Custom js -->
	<script src="jstemp/script.js"></script>

	<!-- ---------------------要加的部份-------------------- -->

</body>

</html>