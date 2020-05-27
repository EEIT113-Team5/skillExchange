
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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



<title>會員登入-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
.red-font {
	color: red;
	margin-left: 20px;
}
* {
	font-family: 微軟正黑體;
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
<!--     <div class="container"> -->
<!--     </div> -->
<!-- ---------------------要加的部份-------------------- -->




	<!-- &autoLogAppEvents=1 -->
	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/zh_TW/sdk.js#xfbml=1&version=v7.0&appId=747521719120979"></script>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-5">
				<div class="card shadow-lg border-0 rounded-lg mt-5">
					<div class="card-header">
						<h3 class="text-center font-weight-light my-4">會員登入</h3>
					</div>
					<div class="card-body">

						<!-- 									<input type='button' class="btn btn-primary" -->
						<!-- 										onclick='fbLogin()' value="登入fb帳號" /> -->
						<form Action="loginCheck" method="post">
							<div class="form-group">
								<label class="mb-1" for="inputAcc">帳號</label><font
									class="red-font small">${MsgMap.AccountEmptyError}</font> <input
									class="form-control py-4" id="inputAcc" name="inputAcc"
									type="text" placeholder="請輸入帳號" />
							</div>
							<div class="form-group">
								<label class="mb-1" for="inputPassword">密碼</label><font
									class="red-font small">${MsgMap.PasswordEmptyError}</font> <input
									class="form-control py-4" id="inputPassword"
									name="inputPassword" type="password" placeholder="請輸入密碼" />
							</div>
							<div class="form-group">
								<div class="custom-control custom-checkbox">
									<input class="custom-control-input" id="rememberPasswordCheck"
										name="rememberPasswordCheck" type="checkbox" /><label
										class="custom-control-label" for="rememberPasswordCheck">記住密碼</label>
								</div>
							</div>
							<div
								class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
								<!-- 											<a class="small" href="password.html">忘記密碼?</a> -->

								<input type="button" id="oneInput" class="btn btn-danger"
									onclick='oneKey()' value='一鍵登入' />

								<div>
									<button type="submit" class="btn btn-info">登入</button>
									<!-- 											這裡 -->
									<input type='button' class="btn btn-primary"
										onclick='fbLogin()' value="FaceBook登入" />
								</div>
								<!-- 										這裡 -->
							</div>
						</form>
					</div>
					<div class="card-footer text-center">
						<div class="small">
							<a href="registerInit">還沒有帳號 ! 點我加入會員!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- ---------------------要加的部份-------------------- -->
	<jsp:include page="/fragment/bottom.jsp" />
<!-- ---------------------要加的部份-------------------- -->
	<c:if test="${not empty MsgMap}">
		<c:if test="${not empty MsgMap.LoginError}">
			<script>
				let message = "${MsgMap.LoginError}";
				alert(message);
			</script>
		</c:if>
	</c:if>

	<!-- 	這裡 -->
	<script>
		// document.getElementById("oneInput").onclick=oneKey;

		function oneKey() {
			// 法1.
			// document.getElementById("inputAcc").value = "maggie123";
			// document.getElementById("inputPassword").value = "qq0911";

			$("#inputAcc").val("AngryCat");
			$("#inputPassword").val("2wsxCDE#");
		}
	</script>

	<!-- 	這裡 -->

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="../js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '747521719120979',
				cookie : true,
				xfbml : true,
				version : 'v7.0'
			});

			FB.AppEvents.logPageView();

		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "https://connect.facebook.net/zh_TW/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
		function fbLogin() {
			FB.login(function(response) {
				statusChangeCallback(response);
			}, {
				scope : 'public_profile,email'
			})

		}
		function fbLogout() {
			FB.logout(function(response) {
				statusChangeCallback(response);
			});
		}

		function statusChangeCallback(response) {
			if (response.status === 'connected') {
				FB
						.api(
								'/me?fields=id,name,picture,email',
								function(response) {
									// 					window.location.href="http://localhost:8085/skillExchange/Facebooklogin?email="+response.email+"&userid="+response.id+"&memberName="+response.name+"&memberPic="+response.picture.data.url;
									var home = "${fn:substring(pageContext.request.requestURL, 0, 36)}";
									var reqUrl = home + "Facebooklogin";
									console.log(home);
									console.log(reqUrl);
									$
											.ajax({
												url : reqUrl, //請求的url地址
												dataType : "json", //返回格式為json
												async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
												data : {
													"email" : response.email,
													"userid" : response.id,
													"memberName" : response.name,
													"memberPic" : response.picture.data.url
												}, //引數值
												type : "GET", //請求方式
												success : function(req) {
													console.log(req);
													window.location.href = home;
												},
												complete : function() {
													//請求完成的處理
												},
												error : function() {
													console.log("出錯了!")
												}
											});
								})
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
