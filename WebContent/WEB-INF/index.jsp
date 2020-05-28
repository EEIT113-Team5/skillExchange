<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- ---------------------上面要加的部份-------------------- -->
<!DOCTYPE html>

<html>
<!--<![endif]-->
<head>

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

<title>首頁-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
.wrap {
	width: 83%;
	margin: 25px;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 25px;
	padding-right: 25px;
	border: 1.5px solid #5B5B5B;
	border-radius: 10px;
}

.searchbar-text {
	width: 350px;
}

.searchbar {
	width: 150px;
	text-align: center;
}

.otext {
	text-align: center;
}

.wrapper {
	position: relative;
	width: 100vw;
	height: 100vh;
	overflow: hidden;
	/* 把超出去的照片隱藏起來 */
}

.form {
	position: absolute;
	width: 70%;
	z-index: 2;
	left: 40%;
	top: 15%;
	transform: translate(-50%, -50%);
}

ul {
	margin: 0;
	padding: 0;
	position: absolute;
}

li {
	margin: 0;
	padding: 0;
	list-style: none;
}

ul.slides {
	width: 400vw;
	left: 0px; /*移動+-800px*/
	transition: all 0.5s;
	height: 100vh;
}

ul.slides li {
	width: 98.7vw;
	height: 100vh;
	/* 	height: 300px; */
	float: left;
	overflow: hidden
}

ul.slides li img {
	opacity: 0.6;
	height: 100vh;
	object-fit: cover;
	width: 100%;
	/* 	width: 100vw; */
}

.title {
	font-family: 微軟正黑體;
	border: none !important;
	font-weight: 1000;
	padding: 0;
}

.block {
	position: relative;
	bottom: 95px;
}
</style>


</head>

<body id="body">

	<jsp:include page="/fragment/top.jsp" />

	<section class="hero-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="block">

						<h3 class="wow fadeInUp" data-wow-duration=".5s"
							data-wow-delay=".3s">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;想學什麼技能嗎?</h3>
						<form action="InsertKeyword1.do" method="GET">
							<div class="input-group wrap">
								<div class="input-group-prepend">
									<input type="text" class="form-control searchbar-text"
										name="keyword" placeholder="關鍵字...">
								</div>
								<div id="getarea" class="input-group-append">
									<select name="area1" id="area" class="btn btn-light searchbar"
										style="text-align: center; text-align-last: center;">
										<option value="地區" selected disabled>地區</option>
									</select>
								</div>
								<div id="getskill" class="input-group-append">
									<select name="skill1" id="skill"
										class="btn btn-light searchbar"
										style="text-align: center; text-align-last: center;">
										<option value="技能類別" selected disabled>技能類別</option>
									</select>
								</div>
								<div class="input-group-append">
									<button type="submit"
										class="btn btn-secondary btn-sm searchbar">
										<i class="fa fa-search"></i>搜尋
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</section>
	<section class="buy-pro" style="padding: 100px 0;"></section>
    
    <jsp:include page="/fragment/bottom.jsp" />
	<!-- end footer -->

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



    	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			let set = setInterval(carousal, 12000);

			let slideNum = 0; //目前的li index
			let slideCount = $(".slides li").length; //有幾張img
			let lastIndex = slideCount - 1;
			$(".dot li").eq(0).css("background", "white");
			$(".dot li").mouseenter(function() {
				slideNum = $(this).index();
				show();
			});

			function show() {
				$(".dot li").eq(slideNum).css("background", "white").siblings()
						.css("background", "transparent");
				var width = $(window).width();
				console.log(width);
				let slideMove = -width * slideNum;
				$("ul.slides").css("left", slideMove);
			}

			function carousal() {
				slideNum++;
				if (slideNum % 4 == 0) {
					slideNum = 0;
				}
				show();
			}
		});
	</script>
	
	 <c:if test="${not empty MsgOK}">
	    <c:if test="${not empty MsgOK.massage}">
		    <script>
		        let message = "${MsgOK.massage}";
		        alert(message);
		    </script>
		</c:if>
	</c:if>
	
	<% 
		session.removeAttribute("MsgOK");
	%>
	
	<script type="text/javascript">
		window.onload = function() {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', "<c:url value='GetArea.do' />", true);
			xhr.send();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						console.log(JSON.parse(xhr.responseText));
						var arr = JSON.parse(xhr.responseText);
						console.log(arr[0][0].publishAreaCN);

						var content1 = "<select name='area1' id='area' class='btn btn-light searchbar'"
									 + "style='text-align: center; text-align-last: center;'>"
									 + "<option value='地區' selected disabled>地區</option>";

						for (var i = 0; i < arr[0].length; i++) {
							content1 += "<option value='" + arr[0][i].publishAreaCN + "'>"
									  + arr[0][i].publishAreaCN + "</option>";
						}
						content1 += "</select>";
						document.getElementById("getarea").innerHTML = content1;
						
						var content2 = "<select name='skill1' id='skill' class='btn btn-light searchbar'"
									 + "style='text-align: center; text-align-last: center;'>"
									 + "<option value='技能類別' selected disabled>技能類別</option>";
									 
						for (var j = 0; j < arr[1].length; j++) {
							content2 += "<option value='" + arr[1][j].skillNameCN + "''>"
									  + arr[1][j].skillNameCN + "</option>";
						}
						content2 += "</select>";
						document.getElementById("getskill").innerHTML = content2;
					}
				}
			}
		}
	</script>

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
</body>
</html>




