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
<body class="sb-nav-fixed" onunload="disconnect();">
	<!-- onload="connect();" -->
	<!-- onload="connect();" -->
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div style="background-color: pink; width: 500px; margin: 10px auto">
					<h4 id='sendto'>菅田將輝</h4>
					<p>
						想學的技能:<span>想學編曲</span>
					</p>
					<p>
						可以交換的技能:<span>戲劇表演</span>
					</p>
					<button onclick='connect();'>有興趣，請點擊對話框</button>
				</div>
				<div id="catalog">
					<div class="card">
						<div class="card-header msg_head">
							<div class="d-flex bd-highlight">
								<div class="img_cont">
									<img src="images/nemotsukensi.jpg"
										class="rounded-circle user_img"> <span
										class="online_icon"></span>
								</div>
								<div class="user_info">
									<span>米津玄師</span>
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
<script src="js/websocketmulti.js">
	
</script>

</html>
l>
