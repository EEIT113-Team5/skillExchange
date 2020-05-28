<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>查詢</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
#searchbar {
	margin: 0;
	padding: 0;
}

.wrap {
	width: 70%;
	margin-left: 50px;
	margin-top: 30px;
	margin-bottom: 30px;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 30px;
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

.fixed_div {
	position: fixed;
	top: 55px;
	width: 85%;
	background-color: #FFFFFF;
	border-bottom: 1.5px solid #F0F0F0;
}

.container2 {
	width: 75%;
	margin: 30px;
	padding: 0;
/* 	border: 1px solid black; */
}

.post {
	display: inline-block;
	background-color: #F0F0F0;
	vertical-align: top;
	width: 30%;
	height: 25em;
	margin: 10px;
	margin-bottom: 25px;
}

table {
	width: 100%;
	border: 10px solid #F0F0F0;
	border-radius: 10px;
}

a {
	color: #000000;
}

.img {
	text-align: center;
	height: 13em;
}

img {
	width: auto;
	height: auto;
	max-width: 100%;
	max-height: 100%;
}

.poster {
	font-size: 1.2em;
	margin-top: 1em;
}

.detail {
	font-size: 0.8em;
	height: 5em;
	vertical-align: top;
}

.area {
	font-size: 0.8em
}

.updatetime {
	text-align: right;
	font-size: 0.8em;
	color: #9D9D9D;
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
					<h2>進階搜尋</h2>
				</div>
			</div>
		</div>
	</section>
	<div id="searchbar">
		<form action="InsertKeyword2.do" method="GET">
			<div class="input-group wrap">
				<div class="input-group-prepend">
					<c:choose>
						<c:when test="${((empty keyword1) && (empty keyword2))}">
							<input type="text" class="form-control searchbar-text"
								name="keyword2" placeholder="關鍵字...">
						</c:when>
						<c:when test="${(not empty keyword1) && (empty keyword2)}">
							<input type="text" class="form-control searchbar-text"
								name="keyword2" value="${keyword1}">
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control searchbar-text"
								name="keyword2" value="${keyword2}">
						</c:otherwise>
					</c:choose>
				</div>
				<div class="input-group-append">
					<select name="area2" id="area" class="btn btn-light searchbar"
						style="text-align: center; text-align-last: center;">
						<c:choose>
							<c:when test="${empty area2}">
								<c:choose>
									<c:when test="${area1 eq 地區}">
										<option selected disabled>地區</option>
										<c:forEach var='area' items='${areaList}'>
											<option value="${area.publishAreaCN}">${area.publishAreaCN}</option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<option disabled>地區</option>
										<c:forEach var='area' items='${areaList}' begin='0' end='4'>
											<option
												<c:if test="${area1 eq area.publishAreaCN}">selected="selected"</c:if>
												value="${area.publishAreaCN}">${area.publishAreaCN}</option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${area2 eq 地區}">
										<option selected disabled>地區</option>
										<c:forEach var='area' items='${areaList}'>
											<option value="${area.publishAreaCN}">${area.publishAreaCN}</option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<option disabled>地區</option>
										<c:forEach var='area' items='${areaList}' begin='0' end='4'>
											<option
												<c:if test="${area2 eq area.publishAreaCN}">selected="selected"</c:if>
												value="${area.publishAreaCN}">${area.publishAreaCN}</option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				<select name="skill2" id="skill" class="btn btn-light searchbar"
					style="text-align: center; text-align-last: center;">
					<c:choose>
						<c:when test="${skill1 eq 技能類別}">
							<option selected disabled>技能類別</option>
							<c:forEach var='skill' items='${skillList}'>
								<option value="${skill.skillNameCN}">${skill.skillNameCN}</option>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<option disabled>技能類別</option>
							<c:forEach var='skill' items='${skillList}' begin='0' end='5'>
								<option
									<c:if test="${skill1 eq skill.skillNameCN}">selected="selected"</c:if>
									value="${skill.skillNameCN}">${skill.skillNameCN}</option>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</select>
				<div class="input-group-append">
					<button type="submit" class="btn btn-secondary btn-sm searchbar">
						<i class="fa fa-search"></i>搜尋
					</button>
				</div>
			</div>
		</form>
	</div>
	<hr>
	<div class="container2">
		<c:choose>
			<c:when test="${empty searchList}">
				<div>查無符合資料</div>
			</c:when>
			<c:otherwise>
				<c:forEach var='search' items='${searchList}'>
					<div class="post">
						<table>
							<tr>
								<th class="title"><h4>
										<a href="" title="${search.publishTitle}">${search.publishTitle}</a>
									</h4></th>
							</tr>
							<tr>
								<td class="img"><img src="${search.publishPic}"
									title="${search.publishTitle}"></td>
							</tr>
							<tr>
								<td class="poster"><c:choose>
										<c:when test="${empty search.memberNic}">
											<span>某某某</span>
										</c:when>
										<c:otherwise>${search.memberNic}</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td class="detail"><c:choose>
										<c:when test="${empty search.publishDetail}">
											<span>無</span>
										</c:when>
										<c:otherwise>${search.publishDetail}</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td class="area"><i class="fas fa-map-marker-alt"></i>
									${search.publishArea} - ${search.city}</td>
							</tr>
							<tr>
								<td class="updatetime">最後更新日期: <fmt:formatDate
										value="${search.updateTime}" pattern="yyyy/MM/dd HH:mm" /></td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- ---------------------要加的部份-------------------- -->
	<jsp:include page="/fragment/bottom.jsp" />
	<!-- ---------------------要加的部份-------------------- -->

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			let divPosition = $("#searchbar").offset().top;
			console.log("divPosition=" + divPosition);
			$(window).scroll(function() {
				let scrollTop = $(this).scrollTop();
				//             console.log("scrollTop="+scrollTop);    
				if (scrollTop > divPosition) {
					$("#searchbar").addClass("fixed_div");
				} else {
					$("#searchbar").removeClass("fixed_div");
				}
			});
		});
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
		crossorigin="anonymous"></script>
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