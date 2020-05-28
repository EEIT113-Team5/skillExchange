<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SkillExchange</title>
<link href="css/styles.css" rel="stylesheet" />
<!-- <!-- Favicon -->
<!-- <link rel="shortcut icon" type="image/x-icon" -->
<!-- 	href="imagestemp/favicon.png" /> -->

<!-- <!-- CSS -->
<!--   ================================================== -->
<!-- <!-- Themefisher Icon font -->
<link rel="stylesheet" href="pluginstemp/themefisher-font/style.css">
<!-- <!-- bootstrap.min css -->
<link rel="stylesheet"
	href="pluginstemp/bootstrap/css/bootstrap.min.css">
<!-- <!-- Lightbox.min css -->
<link rel="stylesheet"
	href="pluginstemp/lightbox2/dist/css/lightbox.min.css">
<!-- <!-- animation css -->
<link rel="stylesheet" href="pluginstemp/animate/animate.css">
<!-- <!-- Slick Carousel -->
<link rel="stylesheet" href="pluginstemp/slick/slick.css">
<!-- <!-- Main Stylesheet -->
<link rel="stylesheet" href="csstemp/style.css">
<!-- <!-- ---------------------要加的部份-------------------- -->
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
* {
	font-family: 微軟正黑體;
}

.a {
	background-color: #FFECF5;
}
</style>
</head>
<body id="body">
	<!-- 	<div id="layoutSidenav"> -->
	<jsp:include page="/fragment/top1.jsp" />
	<section class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>由我舉辦</h2>
				</div>
			</div>
		</div>
	</section>
	<%-- 		<jsp:include page="/fragment/left.jsp" /> --%>
	<!-- 		<DIV ID="LAYOUTSIDENAV_CONTENT"> -->
	<!-- 			<MAIN CLASS="A"> -->
	<div class="container">
		<c:if test="${empty searchList}">
			<h2 class='rounded w-25 mx-auto p-5 text-center'>目前沒有你舉辦的活動</h2>
		</c:if>
		<c:forEach var='search' varStatus="var" items='${searchList}'>
			<div class="row m-3 rounded">
				<div class="col-3">
					<c:choose>

						<c:when test="${empty search.imgB64}">
							<!-- 												class="stretched-link" -->
							<a href="ChooseOneActivity?activityid=${search.activityid}"><img
								src="activityimg/default.jpg" class="card-img-top"
								style="width: 100%; height: 300px;" /></a>
						</c:when>
						<c:otherwise>
							<!-- 												class="stretched-link" -->
							<a href="ChooseOneActivity?activityid=${search.activityid}"><img
								src="data:image/jpg;base64,${search.imgB64}"
								class="card-img-top" style="width: 100%; height: 300px" /></a>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col-7" Style="background-color: #FFCCCC">
					<h1 class="m-4">
						<b>${search.title}</b>
					</h1>
					<h4 class="m-4">描述:${search.descript}</h4>
					<h5 class="m-4">
						<i class="fa fa-clock-o" aria-hidden="true"></i>${search.beginDay}
					</h5>
					<p class="m-4">
						<i class="fa fa-map-marker" aria-hidden="true"></i>${search.position}</p>
					<p class="m-4">${search.interest}人有興趣&nbsp;${search.attendency}人要參加</p>
				</div>
				<div class="col-2" Style="background-color: #EEFFBB">
					<div>
						<a href="#"
							onclick=updateform(${search.activityid},${search.memberid})
							class="btn btn-warning w-50 d-block mt-5 mx-auto" type="button">修改</a>
					</div>
					<div class="m-2 mx-auto">
						<a href="#"
							onclick=deleteconfirm(${search.activityid},${search.memberid})
							class="btn btn-danger w-50 d-block mb-5 mx-auto" type="button">刪除</a>
					</div>

				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 			</main> -->
	<jsp:include page="/fragment/bottom.jsp" />
	<!-- 		</div> -->
	<!-- 	</div> -->
	<form>
		<input type="hidden" name="a" />
	</form>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>
	<script>
		function updateform(activityid,memberid) {
            console.log("hello");
			var w_width = 1000;
			var w_height = 500;
			var x = (screen.width - w_width) / 2;
			var y = (screen.height - w_height) / 3;
// 			var url='UpdateActivity?activityid='+activityid+"&memberid="+memberid+"&title="+title+"&category="+category+"&descript="+descript+"&beginDay="+beginDay+"&beginTime="+beginTime+"&endDay="+endDay+"&endTime="+endTime+"&position="+position+"&lat="+lat+"&long1="+long1+"&group1="+group1+"&group2="+group2+"&imgB64="+imgB64;
			window.open('UpdateActivity?activityid='+activityid+"&memberid="+memberid, '活動表單',
					config = 'height=700,width=1000,top=' + y + ',left=' + x
							+ ',location=no,resizable=no,toolbar=no');
		}
		function deleteconfirm(activityid, memberid){
		if (confirm("確定刪除此貼文嗎?") ) { 
// 			document.forms[0].action="<c:url value='DeleteActivity?activityid="+activityid +"&memberid="+memberid+"' />" ;
            document.forms[0].action="DeleteActivity/"+activityid
			document.forms[0].method="GET";
			document.forms[0].submit();
			return;
		} else {
			return;
		}
		}
	</script>
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