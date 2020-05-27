<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<c:set var='jspPath' value='${pageContext.request.contextPath}' />
<head>
</head>


<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<a class="navbar-brand" href="${jspPath}/">Skill Exchange</a>
	<button class="btn btn-link btn-sm order-1 order-lg-0"
		id="sidebarToggle" href="#">
		<i class="fa fa-bars"></i>
	</button>
	<!-- Navbar Search-->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group">
			<!-- 			<input class="form-control" type="text" placeholder="Search for..." -->
			<!-- 				aria-label="Search" aria-describedby="basic-addon2" /> -->
			<div class="input-group-append">
				<!-- 				<button class="btn btn-primary" type="button" onclick="callHome()"> -->
				<!-- 					<i class="fa fa-search"></i> -->
				<!-- 				</button> -->

				<!-- 登出按鈕 -->
				<c:if test="${ ! empty memberBean}">
					<%-- 				<img src="${memberBean.memberPic}" /> --%>
					<a href="<c:url value='Logout' />"><button type="button"
							class="btn btn-info">登出</button> </a>
				</c:if>

				<!-- 登入按鈕 -->
				<c:if test="${empty memberBean}">
					<a href="${jspPath}/loginInit"><button type="button"
							class="btn btn-info">我要登入</button> </a>
				</c:if>

			</div>
		</div>
	</form>
	<!-- Navbar-->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown">
			<!-- 		<a class="nav-link dropdown-toggle" --> <!-- 			id="userDropdown" href="#" role="button" data-toggle="dropdown" -->
			<!-- 			aria-haspopup="true" aria-expanded="false"> --> <!-- 			<i class="fa fa-user fa-fw"></i> -->
			<!-- 			</a> -->
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="#">Settings</a><a
					class="dropdown-item" href="#">Activity Log</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="login.html">Logout</a>
			</div>
		</li>
	</ul>
</nav>
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<!-- <div class="sb-sidenav-menu-heading">Core</div> -->
					<c:if test="${memberBean.memberAcc!='eeit11321'}">
						<a class="nav-link collapsed" href="#" data-toggle="collapse"
							data-target="#collapseLayouts" aria-expanded="true"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fa fa-tasks"></i>
							</div> 技能類別
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse.in" id="collapseLayouts"
							aria-labelledby="headingOne" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav" />
							<a class="nav-link" href="${jspPath}/query?class=all">全部</a> <a
								class="nav-link" href="${jspPath}/query?class=才藝">才藝</a> <a
								class="nav-link" href="${jspPath}/query?class=運動">運動</a> <a
								class="nav-link" href="${jspPath}/query?class=語言">語言</a> <a
								class="nav-link" href="${jspPath}/query?class=寵物">寵物</a> <a
								class="nav-link" href="${jspPath}/query?class=生活">生活</a>
						</div>

						<a class="nav-link collapsed" href="#" data-toggle="collapse"
							data-target="#collapseLayouts1" aria-expanded="true"
							aria-controls="collapseLayouts1">
							<div class="sb-nav-link-icon">
								<i class="fa fa-trophy" aria-hidden="true"></i>
							</div> 尋找活動
							<div class="sb-sidenav-collapse-arrow">
								<i class="fa fa-angle-down"></i>
							</div>
						</a>
						<c:choose>
							<c:when test="${empty memberBean}">
								<div class="collapse.in" id="collapseLayouts1"
									aria-labelledby="headingOne" data-parent="#sidenavAccordion">
									<nav class="sb-sidenav-menu-nested nav" />

									<a class="nav-link" href="${jspPath}/SelectActivityNo?name=全部">全部</a>
									<a class="nav-link" href="${jspPath}/SelectActivityNo?name=音樂">音樂</a>
									<a class="nav-link" href="${jspPath}/SelectActivityNo?name=語言">語言</a>
									<a class="nav-link" href="${jspPath}/SelectActivityNo?name=運動">運動</a>
									<a class="nav-link" href="${jspPath}/SelectActivityNo?name=電腦">電腦</a>
									<a class="nav-link" href="${jspPath}/SelectActivityNo?name=其他">其他</a>

								</div>
							</c:when>
							<c:otherwise>
								<div class="collapse.in" id="collapseLayouts1"
									aria-labelledby="headingOne" data-parent="#sidenavAccordion">
									<nav class="sb-sidenav-menu-nested nav" />

									<a class="nav-link" href="${jspPath}/SelectActivity?name=全部">全部</a>
									<a class="nav-link" href="${jspPath}/SelectActivity?name=音樂">音樂</a>
									<a class="nav-link" href="${jspPath}/SelectActivity?name=語言">語言</a>
									<a class="nav-link" href="${jspPath}/SelectActivity?name=運動">運動</a>
									<a class="nav-link" href="${jspPath}/SelectActivity?name=電腦">電腦</a>
									<a class="nav-link" href="${jspPath}/SelectActivity?name=其他">其他</a>

								</div>

							</c:otherwise>
						</c:choose>



						<a class="nav-link" href="${jspPath}/publishSkill">
							<div class="sb-nav-link-icon">
								<i class="fa fa-pencil"></i>
							</div>刊登頁面
						</a>
						<a class="nav-link" href="myPublish">
							<div class="sb-nav-link-icon">
								<i class="fa fa-star"></i>
							</div>我的刊登
						</a>
						<a class="nav-link" href="${jspPath}/QueryCollections.do">
							<div class="sb-nav-link-icon">
								<i class="fa fa-heart"></i>
							</div>我的收藏
						</a>
						<a class="nav-link" href="${jspPath}/contactus">
							<div class="sb-nav-link-icon">
								<i class="fa fa-envelope-o"></i>
							</div>聯絡我們
						</a>
						<a class="nav-link" href="${jspPath}/registerInit">
							<div class="sb-nav-link-icon">
								<i class="fa fa-arrow-circle-right"></i>
							</div>加入會員
						</a>
					</c:if>
					<%-- 					</a> <a class="nav-link" href="${jspPath}/loginInit"> --%>
					<!-- 						<div class="sb-nav-link-icon"> -->
					<!-- 							<i class="fa fa-edit"></i> -->
					<!-- 						</div>會員登入 -->
					<!-- 					 </a> -->


					<c:if test="${memberBean.memberAcc=='eeit11321'}">
						<a class="nav-link" href="FindWebComment"><div
								class="sb-nav-link-icon">
								<i class="fa fa-area-chart"></i>
							</div> 網站回饋意見分析</a>
						<a class="nav-link" href="FindUserComment"><div
								class="sb-nav-link-icon">
								<i class="fa fa-table"></i>
							</div> 使用者互評分析</a>
							
						<a class="nav-link" href="Promotion"><div
								class="sb-nav-link-icon">
								<i class="fa fa-table"></i>
							</div>推播功能</a>
						<!-- 						<a class="nav-link" href="StatisticSearch"><div -->
						<!-- 								class="sb-nav-link-icon"> -->
						<!-- 								<i class="fa fa-table"></i> -->
						<!-- 							</div> 網站流量分析</a> -->
					</c:if>
				</div>

			</div>
		</nav>
		<form>
			<input type="hidden" name="a" />
		</form>
	</div>
</div>

<!-- <script> -->

<!-- </script> -->

<!-- 		<script src="https://code.jquery.com/jquery-3.4.1.min.js" -->
<!-- 			crossorigin="anonymous"></script> -->
<!-- 		<script -->
<!-- 			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" -->
<!-- 			crossorigin="anonymous"></script> -->

<!-- 		<script -->
<!-- 			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" -->
<!-- 			crossorigin="anonymous"></script> -->
<!-- 		<script -->
<!-- 			src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" -->
<!-- 			crossorigin="anonymous"></script> -->
<!-- 		<script -->
<!-- 			src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" -->
<!-- 			crossorigin="anonymous"></script> -->
