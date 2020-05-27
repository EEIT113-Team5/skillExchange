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
</style>
<link href="https://fonts.googleapis.com/css2?family=Kalam&display=swap"
	rel="stylesheet">

</head>

<header class="navigation fixed-top">
	<div class="container">
		<!-- main nav -->
		<nav class="navbar navbar-expand-lg navbar-light">
			<!-- logo -->
			<a class="navbar-brand" href="index.html"><h2
					style="color: white; font-family: 'Kalam', cursive">SkillExchange</h2>
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
						aria-expanded="false"> 活動刊登 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${jspPath}/publishSkill">刊登頁面</a>
							<a class="dropdown-item" href="myPublish">我的刊登</a>
						</div></li>



					<!-- 					</li> -->
					<li class="nav-item "><a class="nav-link"
						href="${jspPath}/QueryCollections.do">我的收藏</a></li>
					<li class="nav-item "><a class="nav-link"
						href="${jspPath}/contactus">聯絡我們</a></li>
					<li class="nav-item "><a class="nav-link"
						href="${jspPath}/registerInit">加入會員</a></li>
					<c:if test="${ ! empty memberBean}">
						<li class="nav-item "><a class="nav-link"
							href="<c:url value='Logout' />">登出</a></li>
					</c:if>
					<c:if test="${empty memberBean}">
						<li class="nav-item "><a class="nav-link"
							href="${jspPath}/loginInit">我要登入</a></li>
					</c:if>
					
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="fa fa-bell"
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








