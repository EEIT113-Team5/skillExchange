<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>

<!-- 有需要再打開 -->
<!-- <script type="text/javascript" -->
<!-- 	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAzOs6J5tZ4kJbV6hKtxJjr3kEBjGME3i0&libraries=places"></script> -->


<style>
body {
	margin: auto;
	background: #eaeaea;
	font-family: 'Open Sans', sans-serif;
}

.info p {
	text-align: center;
	color: #999;
	text-transform: none;
	font-weight: 600;
	font-size: 15px;
	margin-top: 2px
}

.info i {
	color: #F6AA93;
}

.form h1 {
	font-size: 18px;
	background: #F6AA93 none repeat scroll 0% 0%;
	color: rgb(255, 255, 255);
	padding: 22px 25px;
	border-radius: 5px 5px 0px 0px;
	margin: auto;
	text-shadow: none;
	text-align: left
}

.form {
	border-radius: 5px;
	/* 	max-width: 2000px; */
	width: 100%;
	margin: auto;
	background-color: #FFFFFF;
	overflow: hidden;
}

p span {
	color: #F00;
}

p {
	margin: 0px;
	font-weight: 500;
	line-height: 2;
	color: #333;
}

h1 {
	text-align: center;
	color: #666;
	text-shadow: 1px 1px 0px #FFF;
	margin: 50px 0px 0px 0px
}

.input, textarea, select {
	border-radius: 0px 5px 5px 0px;
	border: 1px solid #eee;
	margin-bottom: 15px;
	width: 75%;
	height: 40px;
	float: left;
	padding: 0px 15px;
}

a {
	text-decoration: inherit
}

textarea {
	border-radius: 0px 5px 5px 0px;
	border: 1px solid #EEE;
	margin: 0;
	width: 75%;
	height: 130px;
	float: left;
	padding: 0px 15px;
}

.form-group {
	overflow: hidden;
	clear: both;
}

.icon-case {
	width: 35px;
	float: left;
	border-radius: 5px 0px 0px 5px;
	background: #eeeeee;
	height: 42px;
	position: relative;
	text-align: center;
	line-height: 40px;
}

i {
	color: #555;
}

.contentform {
	padding: 40px 30px;
}

.bouton-contact {
	background-color: #81BDA4;
	color: #FFF;
	text-align: center;
	width: 100%;
	border: 0;
	padding: 17px 25px;
	border-radius: 0px 0px 5px 5px;
	cursor: pointer;
	margin-top: 40px;
	font-size: 18px;
}

.leftcontact {
	width: 49.5%;
	float: left;
	border-right: 1px dotted #CCC;
	box-sizing: border-box;
	padding: 0px 15px 0px 0px;
}

.rightcontact {
	width: 49.5%;
	float: right;
	box-sizing: border-box;
	padding: 0px 0px 0px 15px;
}

.validation {
	display: none;
	margin: 0 0 10px;
	font-weight: 400;
	font-size: 13px;
	color: #DE5959;
}

#sendmessage {
	border: 1px solid #fff;
	display: none;
	text-align: center;
	margin: 10px 0;
	font-weight: 600;
	margin-bottom: 30px;
	background-color: #EBF6E0;
	color: #5F9025;
	border: 1px solid #B3DC82;
	padding: 13px 40px 13px 18px;
	border-radius: 3px;
	box-shadow: 0px 1px 1px 0px rgba(0, 0, 0, 0.03);
}

#sendmessage.show, .show {
	display: block;
}

#fileImg2 {
	width: 100%
}

.err {
	font-size: 1em;
}
</style>

</head>
<body class="sb-nav-fixed">
	<%-- 	<jsp:include page="/fragment/left.jsp" /> --%>
	<div id="layoutSidenav_content">
		<main>
			<div style="margin-top: 70px; width: 1300px; margin: 50px auto">
				<form:form class="form" ENCTYPE="multipart/form-data" method="POST"
					action='UpdateActivityContent?activityid=${search.activityid}'
					id="register.do" modelAttribute="search"
					onsubmit="return confirm('確定修改?')">
					<h1>活動表單更改</h1>

					<div class="contentform">
						<div class="leftcontact">
							<div class="form-group">
								<p>
									活動名稱<span>*</span><span class="err"> <form:errors
											path='title' cssClass="error" /></span>
								</p>
								<span class="icon-case"><i class="fa fa-coffee"
									aria-hidden="true"></i></span>
								<form:input path="title" class="input" id="activity"
									placeholder="新增減短且簡顯易懂的活動名稱" />
								<div class="validation"></div>
							</div>
							<div class="form-group">
								<p>
									分類<span>*</span><span class="err"><form:errors
											path='category' cssClass="error" /></span>
								</p>
								<span class="icon-case"><i class="fa fa-tree"
									aria-hidden="true"></i></span>
								<form:select path="category">
									<form:option value="音樂" label="音樂" />
									<form:option value="語言" label="語言" />
									<form:option value="運動" label="運動" />
									<form:option value="電腦" label="電腦" />
									<form:option value="其他" label="其他" />
								</form:select>
								<div class="validation"></div>
							</div>

							<div class="form-group">
								<p>說明</p>
								<span class="icon-case"><i class="fa fa-podcast"
									aria-hidden="true"></i></span>
								<form:textarea path="descript" id="description"
									placeholder="向大家介紹你的活動內容" />
							</div>

							<div class="form-group">
								<p>
									開始(日期/時間)<span>*</span><span class="err"><form:errors
											path='beginDay' cssClass="error" /></span>&nbsp;<span class="err"><form:errors
											path='beginTime' cssClass="error" /></span>
								</p>
								<span class="icon-case"><i class="fa fa-clock-o"
									aria-hidden="true"></i></span>
								<form:input path="beginDay" class="input" type="date"
									id="beginDay" style="display: inline; width: 40%" />
								<form:input path="beginTime" class="input" type="time"
									id="beginTime" style="display: inline; width: 40%" />
							</div>

							<div class="form-group">
								<p>
									結束(日期/時間) <span>*</span><span class="err"><form:errors
											path='endDay' cssClass="error" /></span>&nbsp;<span class="err"><form:errors
											path='endTime' cssClass="error" /></span>
								</p>
								<span class="icon-case"><i class="fa fa-clock-o"
									aria-hidden="true"></i></span>
								<form:input class="input" type="date" path="endDay" id="endDay"
									style="display: inline; width: 40%" />
								<form:input class="input" path="endTime" type="time"
									id="endTime" style="display: inline; width: 40%" />
							</div>
							<div class="form-group">
								<p>
									地點<span>*</span><span class="err"><form:errors
											path='position' cssClass="error" /></span>
								</p>
								<span class="icon-case"><i class="fa fa-map-marker"></i></span>
								<form:input class="input" path="position" id="pac-input"
									placeholder="請輸入活動地點" onchange="codeAddress()" />
								<form:input style="visibility: hidden" path="lat" id="lat" />
								<form:input style="visibility: hidden" type="text" path="long1"
									id="long" />
							</div>
						</div>
					</div>

					<div class="rightcontact">
						<div class="form-group">
							<p>
								是否開啟留言板功能<span>*</span><span class="err"><form:errors
										path='dialog' cssClass="error" /></span>
							</p>
							<!-- 					<span class="icon-case"><i class="fa fa-building-o"></i></span> -->
							<div class="custom-control custom-radio">
								<form:radiobutton path="dialog" class="custom-control-input"
									value="on" id="dialog1" />
								<label class="custom-control-label" for="dialog1">啟用 </label>
							</div>

							<!-- Group of default radios - option 3 -->
							<div class="custom-control custom-radio">
								<form:radiobutton path="dialog" value="off"
									class="custom-control-input" id="dialog2" />
								<label class="custom-control-label" for="dialog2">不啟用 </label>
							</div>
							<!-- 							<input type="radio" name="dialog" /><label>啟用</label><input -->
							<!-- 								type="radio" name="dialog" /><label>不啟用</label> -->
						</div>

						<div class="form-group">
							<p>參與人數(請輸入數字)</p>
							<span class="icon-case"><i class="fa fa-users"
								aria-hidden="true"></i></span>
							<form:input class="input" path="group1" id="group"
								style="display: inline; width: 40%" placeholder="下限" />
							<form:input class="input" path="group2" id="group1"
								style="display: inline; width: 40%" placeholder="上限" />

						</div>
						<div class="form-group">
							<p>活動相片或影片</p>
							<span class="icon-case"><i class="fa fa-picture-o"
								aria-hidden="true"></i></span>
							<form:input class="input" type="file" path="productImage"
								accept="image/gif, image/jpeg, image/png" id="file2" />


						</div>
						<div style="width: 80%">
							<img id="fileImg2"
								src="data:image/jpg;base64,${search.imgB64}" />
						</div>
					</div>

					<input type="submit" class="bouton-contact" value="修改活動內容" />
				</form:form>
			</div>

		</main>
	</div>

	<footer class="py-4 bg-light mt-auto">
		<div class="container-fluid">
			<div class="d-flex align-items-center justify-content-between small">
				<div class="text-muted">Copyright &copy; Exchange platform</div>
			</div>
		</div>
	</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script>
		var input = document.getElementById("pac-input");
		var autocomplete = new google.maps.places.Autocomplete(input);
	</script>
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
		function codeAddress() {
			var add = document.getElementById("pac-input");
			var Longitude = document.getElementById("long");
			var Latitude = document.getElementById("lat");
			var geocoder = new google.maps.Geocoder();
			geocoder.geocode({
				address : add.value
			}, function(results, status) {
				if (status == google.maps.GeocoderStatus.OK) {
					Longitude.value = results[0].geometry.location.lng();
					Latitude.value = results[0].geometry.location.lat();
				} else {
					// 									alert("Geocode was not successful for the following reason: "
					// 											+ status);
				}
			});
		}
		function confirm('確定修改?') {
 			if (confirm('確定修改?')) {
					    		window.opener.location.reload(); //重新整理父視窗中的網頁
					    		window.alert
							    window.close();//關閉當前窗視窗
				return true;
			} else {
				return false;
			}
	</script>
	<script>
		$(document).ready(
				function() {
					$('input[type=file]').change(
							function() {
								var input = $(this);
								if (!!this.files && !!this.files[0]) {
									$(
											'#fileImg'
													+ input.prop('id').substr(
															4, 1)).css({
										'display' : 'block',
										'width' : '100%'
									// 										'height' : '125px'
									});
									var reader = new FileReader();
									reader.onload = function(e) {
										$(
												'#fileImg'
														+ input.prop('id')
																.substr(4, 1))
												.prop('src', e.target.result);
									}
									reader.readAsDataURL(this.files[0]);
								}
							});
				})
	</script>
	<!-- 	<script language="javascript"> -->


	<!-- // 		} -->
	<!-- 	</script> -->
</body>
</html>