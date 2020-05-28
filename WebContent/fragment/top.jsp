<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<c:set var='jspPath' value='${pageContext.request.contextPath}' />

<!--
  Start Preloader
  ==================================== -->
<div id="preloader">
	<div class='preloader'>
		<span></span> <span></span> <span></span> <span></span> <span></span>
		<span></span>
	</div>
</div>
<!--
  End Preloader
  ==================================== -->
<head>

<style>
.nav-link {
	font-size: 18px !important;
}

.navigation .navbar-light .navbar-nav .nav-item .nav-link {
	padding: 20px 13px !important;
}

.collectImg {
	width: 50px;
	height: 50px;
	border-radius: 50%;
	margin-right: 10px;
}

#popupmsg {
	position: fixed;
	width: 300px;
	height: 100px;
	bottom: 50px;
	right: 30px;
	border-radius: 5px;
	background-color: #E0E0E0;
	display: none;
	z-index: 10;
}

</style>
<link href="https://fonts.googleapis.com/css2?family=Kalam&display=swap"
	rel="stylesheet">

</head>

<header class="navigation fixed-top">
	<div class="container">
		<!-- main nav -->
		<nav class="navbar navbar-expand-lg navbar-light">
			<!-- logo -->
			<a class="navbar-brand" href="${jspPath}/"><h2 class="logo-white"
					style="color: white; font-family: 'Kalam', cursive">SkillExchange</h2>
				<h2 class="logo-default"
					style="color: black; font-family: 'Kalam', cursive">SkillExchange</h2>
			</a>
			<!-- /logo -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navigation" aria-controls="navigation"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navigation">
				<ul class="navbar-nav ml-auto text-center">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 技能類別 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${jspPath}/query?class=all">全部</a>
							<a class="dropdown-item" href="${jspPath}/query?class=才藝">才藝</a>
							<a class="dropdown-item" href="${jspPath}/query?class=運動">運動</a>
							<a class="dropdown-item" href="${jspPath}/query?class=語言">語言</a>
							<a class="dropdown-item" href="${jspPath}/query?class=寵物">寵物</a>
							<a class="dropdown-item" href="${jspPath}/query?class=生活">生活</a>

						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 尋找活動 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<c:choose>
								<c:when test="${empty memberBean}">
									<a class="dropdown-item"
										href="${jspPath}/SelectActivityNo?name=全部">全部</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivityNo?name=音樂">音樂</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivityNo?name=語言">語言</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivityNo?name=運動">運動</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivityNo?name=電腦">電腦</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivityNo?name=其他">其他</a>
								</c:when>
								<c:otherwise>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivity?name=全部">全部</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivity?name=音樂">音樂</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivity?name=語言">語言</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivity?name=運動">運動</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivity?name=電腦">電腦</a>
									<a class="dropdown-item"
										href="${jspPath}/SelectActivity?name=其他">其他</a>
								</c:otherwise>
							</c:choose>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 技能刊登 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${jspPath}/publishSkill">刊登頁面</a>
							<a class="dropdown-item" href="myPublish">我的刊登</a>
						</div></li>



					<!-- 					</li> -->
					<li class="nav-item "><a class="nav-link"
						href="${jspPath}/QueryCollections.do">我的收藏</a></li>
					<li class="nav-item "><a class="nav-link"
						href="${jspPath}/contactus">聯絡我們</a></li>
					<!-- 					<li class="nav-item "><a class="nav-link" -->
					<%-- 						href="${jspPath}/registerInit">加入會員</a></li> --%>


					<!--加入會員 -->
					<!--<li class="nav-item "><a class="nav-link" -->
					<%--href="${jspPath}/registerInit">加入會員</a></li> --%>
					<li class="nav-item "><a class="nav-link"></a></li>
					<li class="nav-item "><a class="nav-link"></a></li>
					<li class="nav-item "><a class="nav-link"></a></li>
					<!-- 										<li class="nav-item "><a class="nav-link"></a></li> -->
					<!-- 										<li class="nav-item "><a class="nav-link"></a></li> -->
					<!-- 										<li class="nav-item "><a class="nav-link"></a></li> -->


					<!-- 登出按鈕 -->
					<%-- 					<c:if test="${ ! empty memberBean}"> --%>
					<%-- 						<img class="collectImg" src="${ memberBean.memberPic }" /> --%>
					<!-- 						<li class="nav-item "><a class="nav-link" -->
					<%-- 							href="<c:url value='Logout' />">登出</a></li> --%>
					<%-- 					</c:if> --%>
					<c:if test="${ ! empty memberBean}">
						<img class="collectImg" src="${ memberBean.memberPic }" />
					</c:if>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">會員</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${jspPath}/registerInit">加入會員</a>
							<c:if test="${empty memberBean}">
								<a class="dropdown-item" href="${jspPath}/loginInit">我要登入</a>
							</c:if>
							<c:if test="${ ! empty memberBean}">
								<a class="dropdown-item" href="<c:url value='Logout' />">登出</a>
							</c:if>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fa fa-bell" id="navbarbell"
							aria-hidden="true"></i></a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">test</a>
						</div></li>
				</ul>
			</div>
		</nav>
		<!-- /main nav -->
	</div>
</header>



<div id="popupmsg">
	<div class="card">
		<div class="card-header" style="background-color: #FFBFFF">你有一則新的推播訊息</div>
		<div class="card-body" style="background-color: #FFE6FF">
			<h5 class="card-title" id="broadcast">Special title treatment</h5>
		</div>
	</div>
</div>

<script>
	var MyPoint = "/DemoWSmulti";
	var host = window.location.host;
	//		console.log(host);
	var path = window.location.pathname;
	//		console.log(path);
	var webCtx = path.substring(0, path.indexOf('/', 1));
	//		console.log(webCtx);
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;
	//		console.log(endPointURL);
	// 		var statusOutput = document.getElementById("statusOutput");
	var webSocket;

	var broadcast = document.getElementById("broadcast");
	var popupmsg = document.getElementById("popupmsg");

	connect();
	function connect() {
		// 			document.getElementById("catalog").style.display = 'block';
		// 			output = document.getElementById("output");
		// create a websocket
		webSocket = new WebSocket(endPointURL);

		webSocket.onopen = function(event) {
			onOpen(event)
		};

		webSocket.onmessage = function(event) {
			onMessage(event)
		};

		webSocket.onclose = function(event) {
			onClose(event)
		};
		webSocket.onerror = function(event) {
			onError(event)
		};
	}

	function fadeaway() {
		$("#popupmsg").fadeOut(2000);
	}
	function onOpen(evt) { //連線時觸發
		console.log("產生連線");
		// 			writeToScreen("<p style='background-color:#ddd' class='rounded-lg text-center text-secondary py-2'>向對方打個招呼吧</p>");

	}
	function onMessage(evt) { //收到訊息時觸發
		// 		broadcast.innerHTML = evt.data;
		$("#navbarbell").attr("class", "fa fa-bell-o")
		$("#popupmsg").fadeIn(3000);
		$("#broadcast").text(evt.data)
		setTimeout(fadeaway, 5000);
		// 	    alert(evt.data);
	}
	function onClose(evt) { //關閉連線時時觸發
		//	 		writeToScreen("DISCONNECTED");
	}

	function onError(evt) {
		// 			writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
	}

	// 		function sendMessage() {

	// 			var inputMessage = document.getElementById("textmssg");
	// 			var message = inputMessage.value.trim();

	// 			if (message === "") {
	// 				alert("Input a message");
	// 				inputMessage.focus();
	// 			} else {
	// 				// 			writeToScreen("SENT: " + message);
	// 				webSocket.send(message); //!!!! 送留言到endpoint
	// 				inputMessage.value = "";
	// 				inputMessage.focus();
	// 			}
	// 		}

	function disconnect() {
		webSocket.close();
	}

	// 		var cardbody = document.getElementById("cardbody");
	// 		function writeToScreen(message) {
	// 			console.log(message)
	// 			cardbody.innerHTML += message;
	// 		}
</script>






