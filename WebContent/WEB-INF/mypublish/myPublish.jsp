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
<title>我的刊登-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link href="css/mypublishcard.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
fieldset {
	width: 800px;
	border: 3px solid chocolate;
	border-radius: 30px;
	margin: 20px;
}

legend {
	font-size: 30px;
	font-family: fantasy;
	color: lightsteelblue;
}

/* body { */
/* 	margin: 100px; */
/* } */

.st1 {
	width: 450px;
	border-bottom: 1px solid cornflowerblue;
	margin: 10px;
	padding-bottom: 10px;
}

.st2 {
	width: 450px;
	text-align: center;
}

.l1 {
	width: 100px;
	float: left;
	text-align: right;
}
/* 讓意見表單不可以被拉大小 */
textarea {
	resize: none;
}

tr, td {
	border-bottom: 2px solid black;
	padding-top: 5px;
	width: 300px;
}

.d1 {
	text-align: right;
}
</style>

</head>

<!-- ---------------------要加的部份-------------------- -->
<body id="body">
	<jsp:include page="/fragment/top1.jsp" />

	<section class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>我的刊登</h2>
				</div>
			</div>
		</div>
	</section>
	
	<div class="container">

		<h3>我的刊登</h3>

		<div class="row">
			<!-- 						<th>刊登編號</th><th>刊登標題</th><th>刊登內容</th><th>刊登地區</th><th></th><th></th>			 -->
			<c:forEach var="my" items="${mypublish}">

				<div class="col-sm-3"
					style="background-color: cornflowerblue; height: 450px; margin-top: 20px">
					<div class="card" style="height: 450px">

						<img src="${my.publishPic}" class="card-img-top" alt="..."
							style="height: 180px">
						<div class="" style="height: 124px">
							<h5 class="card-title">編號:${my.publishNo},${my.myTitle}</h5>
							<p class="card-text">${my.myDetail}.</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><a
								href='myPublishImfor?publishNo=${my.publishNo}'>刊登資料</a></li>
							<li class="list-group-item"><a
								href='myPublishUpdate?publishNo=${my.publishNo}'>修改</a></li>
							<li class="list-group-item"><a
								href='myPublishDel?publishNo=${my.publishNo}'>刪除</a></li>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- 					<form action="/skillExchange/PublishPage.jsp" method="POST"> -->
	<!-- 						<input type='submit' value='上一步' >  -->
	<!-- 					</form> -->
	<!-- 					<form action="http://localhost:8080/skillExchange/publishCheckPage.Controller/publishCheckPageServlet" method="POST"> -->
	<!-- 						<input type='submit' value='完成' >  -->
	<!-- 					</form> -->


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