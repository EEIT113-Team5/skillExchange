
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
<title>加入會員-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous">
	
</script>

<script>
	var sex = request.getElementsByName('gender');
</script>

<style>
.red-font {
	color: red;
	margin-left: 20px;
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
					<h2>Register</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-7">
				<div class="card shadow-lg border-0 rounded-lg mt-5">
					<div class="card-header">
						<h3 class="text-center font-weight-light my-4 ">加入會員</h3>
					</div>
					<div class="card-body">

						<form class="form" action="registerCheck" method="post"
							enctype="multipart/form-data">
							<fieldset class="fieldset">
								<legend class="legend">帳號資訊</legend>
								<br>
								<table>
									<tr>
										<td><label for="acc">帳號：</label></td>
										<td><input type="text" id="acc" name="memberAcc"></td>
										<td><font class="red-font small">${errorMsg.memberAcc}</font></td>
									</tr>
									<tr>
										<td><label for="pwd">密碼：</label></td>
										<td><input type="password" id="pwd" name="memberPwd"></td>
										<td><font class="red-font small">${errorMsg.memberPwd}</font></td>
									</tr>
									<tr>
										<td><label for="checkpwd">再次確認密碼：</label></td>
										<td><input type="password" id="checkpwd" name="checkpwd"></td>
										<td><font class="red-font small">${errorMsg.checkpwd}</font></td>
									</tr>

								</table>
							</fieldset>
							<br>
							<fieldset class="fieldset">
								<legend class="legend">個人資料</legend>
								<table>
									<br>
									<tr>
										<td><label for="name">姓名：</label></td>
										<td><input type="text" id="name" name="memberName"></td>
										<td><font class="red-font small">${errorMsg.memberName}</font></td>
									</tr>
									<tr>
										<td><label for="nicname">會員暱稱：</label></td>
										<td><input type="text" id="nicname" name="memberNic"></td>
										<td><font class="red-font small">${errorMsg.memberNic}</font></td>
									</tr>
									<tr>
										<td><label for="">性別：</label></td>
										<td><input type="radio" name="memberSex" id="gender_m"
											value="1"> <label for="gender_m">男</label> <input
											type="radio" name="memberSex" id="gender_w" value="2">
											<label for="gender_w">女</label> <input type="radio"
											name="memberSex" id="gender_no" value="3"> <label
											for="gender_no">不提供</label></td>
										<td><font class="red-font small">${errorMsg.memberSex}</font></td>
									</tr>
									<tr>
										<td><label for="birthday">生日：</label></td>
										<td><input type="date" id="birthday" name="memberBirth"></td>
										<td><font class="red-font small">${errorMsg.memberBirth}</font></td>
									</tr>
									<tr>
										<td><label for="phone">電話：</label></td>
										<td><input type="text" id="phone" name="memberPhone"></td>
										<td><font class="red-font small">${errorMsg.memberPhone}</font></td>
									</tr>
									<tr>
										<td><label for="mail">信箱：</label></td>
										<td><input type="text" id="mail" name="memberMail"></td>
										<td><font class="red-font small">${errorMsg.memberMail}</font></td>
									</tr>
									<tr>
										<td>所在縣市：</td>
										<td><select name="memberCountry" id="">
												<option value="Keelung">基隆市</option>
												<option value="Taipei">台北市</option>
												<option value="Chiayi">嘉義縣</option>
												<option value="New Taipei">新北市</option>
												<option value="Tainan">台南市</option>
												<option value="Taoyuan">桃園市</option>
												<option value="Kaohsiung">高雄市</option>
												<option value="Pingtung">屏東縣</option>
												<option value="Hsinchu">新竹縣</option>
												<option value="Taitung ">台東縣</option>
												<option value="Miaoli">苗栗縣</option>
												<option value="Hualien">花蓮縣</option>
												<option value="Taichung">台中市</option>
												<option value="Yilan">宜蘭縣</option>
												<option value="Changhua">彰化縣</option>
												<option value="Penghu">澎湖縣</option>
												<option value="Nantou ">南投縣</option>
												<option value="Kinmen">金門縣</option>
												<option value="Yunlin">雲林縣</option>
												<option value="Lienchiang">連江縣</option>
										</select></td>
									</tr>
								</table>
								<!-- 											<br> -->
								<table>
									<br>
									<tr>
										<td><label for="addr">地址：</label></td>
										<td><input type="text" id="addr" name="memberAddr"
											size="45"></td>
										<td><font class="red-font small">${errorMsg.memberAddr}</font></td>
									</tr>
								</table>
							</fieldset>
							<br>
							<fieldset class="fieldset">
								<legend class="legend">關於我</legend>
								<br>
								<table>
									<tr>
										<td><label for="">照片：</label></td>
										<td><input type="file" onchange="readURL(this)"
											name="memberPic" targetID="prePic"></td>
										<img id="prePic" style="display: none" src="#" width="200px"
											name='prePic' value="${memberPic}" />
										<br>
									</tr>
									<tr>
										<td colspan="2">&nbsp;</td>
									</tr>
									<tr>
										<td><label for="skill"> 有興趣的技能：</label></td>
										<td><textarea id="skill" cols="20" rows="3"
												name="memberInSkill"></textarea></td>
									</tr>
									<tr>
										<td><label for="infosource">來源管道：</label></td>
										<td><input type="checkbox" id="fb" name="infoSource">
											<label for="fb">FaceBook</label> <input type="checkbox"
											id="friend" name="infoSource"> <label for="friend">朋友介紹</label>
											<input type="checkbox" id="ad" name="infoSource"> <label
											for="ad">廣告</label><br> <input type="checkbox" id="else"
											name="infoSource"> <label for="else">其他</label> <input
											type="text" size="30px"></td>
									</tr>
								</table>
							</fieldset>
							<div style="text-align: center;">
								<input type="submit" value="送出"> <input type="reset"
									value="清除">
							</div>
						</form>
					</div>
					<div class="card-footer text-center">
						<div class="small">
							<a href="loginInit">已經有帳戶，我要登入</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ---------------------要加的部份-------------------- -->
	<jsp:include page="/fragment/bottom.jsp" />
	<!-- ---------------------要加的部份-------------------- -->

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
		function readURL(input) {
			if (input.files && input.files[0]) {
				var imageTagID = input.getAttribute("targetID");
				var reader = new FileReader();
				reader.onload = function(e) {
					var img = document.getElementById(imageTagID);
					img.setAttribute("src", e.target.result)
				}
				reader.readAsDataURL(input.files[0]);
				document.getElementById("prePic").style.display = "block";
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