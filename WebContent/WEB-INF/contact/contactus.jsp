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
<title>聯絡我們-Skill Exchange</title>
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

<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
font {
	color: red;
	margin-left: 20px;
}
* {
	font-family: 微軟正黑體;
}
</style>
</head>

<body id="body">
	<jsp:include page="/fragment/top1.jsp" />
	<jsp:include page="/fragment/modal.jsp" />
	<section class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>聯絡我們</h2>
				</div>
			</div>
		</div>
	</section>

	<div class="container w-50">
		<h2 class="mt-4">聯絡我們</h2>
		<form action="InsertContactUs" method="POST">
			<div class="form-group">
				<label for="name">姓名(必填)</label> <font>${MsgMap.errorNameEmpty}</font>
				<c:choose>
					<c:when test='${param.name != null}'>
						<c:set var='inputName' value='${param.name}' />
					</c:when>
					<c:otherwise>
						<c:set var='inputName' value='${memberBean.memberName}' />
					</c:otherwise>
				</c:choose>
				<input type="text" class="form-control" id="name"
					placeholder="請輸入姓名" name="name" value="${inputName}">

			</div>
			<div class="form-group">
				<label for="email">信箱(必填)</label> <font>${MsgMap.errorEmailEmpty}</font>
				<c:choose>
					<c:when test='${param.email != null}'>
						<c:set var='inputMail' value='${param.email}' />
					</c:when>
					<c:otherwise>
						<c:set var='inputMail' value='${memberBean.memberMail}' />
					</c:otherwise>
				</c:choose>
				<input type="email" class="form-control" id="email"
					placeholder="請輸入Email" name="email" value="${inputMail}">
			</div>
			<div class="form-group">
				<label for="title">主旨(必填)</label> <font>${MsgMap.errorTitleEmpty}</font>
				<input type="text" class="form-control" id="title"
					placeholder="請輸入主旨" name="title" value="${param.title}">

			</div>
			<div class="form-group">
				<label for="content">內容(必填)</label><font>${MsgMap.errorContecntEmpty}</font>
				<textarea class="form-control" id="content" name="content">${param.content}</textarea>

			</div>
			<button type="submit" class="btn btn-primary">送出</button>
			<!-- 						<button type="reset" class="btn btn-dark">清除</button> -->
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
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<c:if test="${not empty MsgOK}">
		<script>
			let message = "${MsgOK.insertOK}";
			$("#alertText").text(message);
			$("#alertModal").modal('show');
		</script>
	</c:if>
	<%
		session.removeAttribute("MsgOK");
	%>
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