<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zt-TW">
<c:set var='jspPath' value='${pageContext.request.contextPath}' />
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>PublishDetail-Skill Exchange</title>

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

<link href="${jspPath}/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="${jspPath}/font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
h6 {
	border: 1px solid #000;
	margin-left: 40px
}

.text {
	margin-left: 40px
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
					<h2>Login</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<table class="table table-hover">



			<c:choose>
				<c:when test="${empty allSkills}">
					<tr height='36'>
						<td colspan='7' align='center'><font color='red'>查無技能資料</font></td>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach var='skills' items='${allSkills}'>

						<div class="text" style="margin-top: 20px">

							<img width="100" height="100"
								src="${jspPath}/${skills.member.memberPic}"> <br>
							${skills.member.memberName}
						</div>
						<hr>
						<h2 class="text">${skills.publishTitle}</h2>
						<img style="margin-left: 40px" width="200" height="200"
							src="${jspPath}/${skills.publishPic}">
						<!--刊登圖片-->
						<div class="text">
							<p class="whitespace">${skills.publishDetail}<br />
							</p>
						</div>
						<!--文章內容-->
						<div class="more_content">

							<h6 style="width: 145px">提供交流/交換項目:</h6>
							<div class="text">${skills.ownSkill}</div>
							<!--提供交流/交換項目-->

							<br>
							<h6 style="width: 160px">希望交流/交換的內容:</h6>
							<div class="text">${skills.wantSkill}</div>
							<!--希望交流/交換的內容-->

							<!-- 											<br><h6 style="width:75px">希望時間:</h6> -->
							<!-- 											<div class="text"></div> 希望時間 -->

							<br>
							<h6 style="width: 75px">希望地點:</h6>
							<div class="text">${skills.publishPlace}</div>

							<br>
							<h6 style="width: 75px">更新時間:</h6>
							<div class="text">${skills.updateTime}</div>

						</div>

					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>

	<!-- ---------------------要加的部份-------------------- -->
	<jsp:include page="/fragment/bottom.jsp" />
	<!-- ---------------------要加的部份-------------------- -->

</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
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


</html>
