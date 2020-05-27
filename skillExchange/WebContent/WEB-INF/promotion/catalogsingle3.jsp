<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Tables - SB Admin</title>
<link href="css/styles.css" rel="stylesheet" />
<link href="css/calalog.css" rel="stylesheet" />

<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
<style>
* {
	font-family: 微軟正黑體;
}

.card {
	background-color: #ECFFFF !important
}

#catalog {
	display: none;
}

/*  .b {  */
/* 	border: 1px solid blue;  */
/* box-shadow: 2px 2px #FFF;  */
/* position: fixed;  */
/* 	bottom: 0px;  */
/*  	left: 75%;  */
/*   	width: 350px;   */
/*  	height: 400px;  */
/*  }  */
</style>
</head>
<body class="sb-nav-fixed"  onunload="disconnect();"><!-- onload="connect();" -->
	<!-- onload="connect();" -->
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand" href="PublishCommentServlet">SkillExchange</a>
		<button class="btn btn-link btn-sm order-1 order-lg-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2" />
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ml-auto ml-md-0">
			<p>
				您好!<span style="color:white" id='owner'>川普</span>
			</p>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="userDropdown" href="#"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a><a
						class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="login.html">Logout</a>
				</div></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">回饋意見分析</div>
						<a class="nav-link" href="FindWebCommentServlet"><div
								class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> 網站回饋意見分析</a><a class="nav-link" href="FindUserCommentServlet"><div
								class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> 使用者互評分析</a>
					</div>
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div style="background-color: pink; width: 500px; margin: 10px auto">
					<p>來自<span id="sendto">米津玄師</span>的交換邀請</p>
					<button onclick='connect();'>接受</button>
				</div>
				<div id="catalog">
					<div class="card">
						<div class="card-header msg_head">
							<div class="d-flex bd-highlight">
								<div class="img_cont">
									<img src="images/suda.jpeg"
										class="rounded-circle user_img"> <span
										class="online_icon"></span>
								</div>
								<div class="user_info">
									<span>菅田將輝</span>
									<p>1767 Messages</p>
								</div>
								<div class="video_cam">
									<span><i class="fas fa-video"></i></span> <span><i
										class="fas fa-phone"></i></span>
								</div>
								<a type="button" href="Form.jsp" class="btn text-white">結束交換</a>
							</div>
							<span id="action_menu_btn"><i class="fas fa-ellipsis-v"></i></span>
							<div class="action_menu">
								<ul>
									<li><i class="fas fa-user-circle"></i> View profile</li>
									<li><i class="fas fa-users"></i> Add to close friends</li>
									<li><i class="fas fa-plus"></i> Add to group</li>
									<li><i class="fas fa-ban"></i> Block</li>
								</ul>
							</div>

						</div>
						<div id="cardbody" class="card-body msg_card_body">
							<!-- 						<div class="d-flex justify-content-start mb-4"> -->
							<!-- 							<div class="img_cont_msg"> -->
							<!-- 								<img src="images/nemotsukensi.jpg" -->
							<!-- 									class="rounded-circle user_img_msg"> -->
							<!-- 							</div> -->
							<!-- 							<div class="msg_cotainer"> -->
							<!-- 								感謝今天的交換，對於演技方面學到很多<span class="msg_time">時間</span> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 						<div class="d-flex justify-content-end mb-4"> -->
							<!-- 							<div class="msg_cotainer_send"> -->
							<!-- 								我也是!之後有機會在向你學習編曲 <span class="msg_time_send">時間 -->
							<!-- 									Today</span> -->
							<!-- 							</div> -->
							<!-- 							<div class="img_cont_msg"> -->
							<!-- 								<img src="images/suda.jpeg" class="rounded-circle user_img_msg"> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 						<div class="d-flex justify-content-start mb-4"> -->
							<!-- 							<div class="img_cont_msg"> -->
							<!-- 								<img src="images/nemotsukensi.jpg" -->
							<!-- 									class="rounded-circle user_img_msg"> -->
							<!-- 							</div> -->
							<!-- 							<div class="msg_cotainer"> -->
							<!-- 								那今天就先這樣啦，掰掰 <span class="msg_time">時間</span> -->
							<!-- 							</div> -->
							<!-- 						</div> -->

						</div>
						<div class="card-footer">
							<div class="input-group">
								<div class="input-group-append">
									<span class="input-group-text attach_btn"><i
										class="fas fa-paperclip"></i></span>
								</div>
								<textarea name="" class="form-control type_msg" id="textmssg"
									placeholder="Type your message..."></textarea>
								<div class="input-group-append">
									<!-- 							<input type="submit" value="Send" onclick='sendMessage();'/> -->
									<span class="input-group-text send_btn"
										onclick='sendMessage();'><i
										class="fas fa-location-arrow"></i></span>
								</div>
							</div>
						</div>

						<!-- 				<div class="b"> -->
						<!-- 					<p class="c">米津玄師</p> -->
						<!-- 					<p class="d">這次學中文學得很愉快</p> -->
						<!-- 					<p class="e">我也是，之後有機會再向你請教編曲</p> -->
						<!-- 					<p> -->
						<!-- 						請輸入想說的話<input type="button" class="btn btn-primary" value="結束交換"> -->
						<!-- 					</p> -->
						<!-- 				</div> -->
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Exchange platform</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
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
</body>
<script src="js/websocket1by1.js">
	
</script>

</html>