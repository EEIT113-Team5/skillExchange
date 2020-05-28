<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="js/echarts.min.js"></script>
<!-- e chart CDN -->
<style>
</style>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4" style="text-shadow: 1px 1px gray; text-align:center">使用者互評分析</h1>
					<div class="rounded-lg ">
						<div class="card-body">
							<form action="WatchingList" method="get">
								<label style="background-color: #C4E1FF" class="rounded p-2">被評分低於<span
									class="lgtwo p-2">${param.grade}</span>的次數
								</label> <input style="background-color: #C4E1FF; margin-top: 10px;"
									type="range" min='2' max='10' step='1' name="grade" id="grade1">
								<input type="submit" id="grade" value="Search " class="btn"
									style="background-color: #C4E1FF" />

							</form>
							<div style="display: flex">
								<div class="table-responsive tableshow"
									style="flex: 2; max-height: 500px;">
									<table class="table table-bordered" id="dataTable1"
										cellspacing="0">
										<thead>
											<tr>
												<th>被評價會員編號</th>
												<th id="tcount">低於<span>${param.grade}</span>的次數
												</th>
												<th>會員處理</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var='watch' items='${watching}'>
												<tr>

													<td><c:out value="${watch.memCommented}" default="無" /></td>
													<td><c:out value="${watch.exGrading}" default="無" /></td>
													<td><c:choose>
															<c:when test="${param.grade-1<2}">
																<c:choose>
																	<c:when test="${watch.exGrading>=4}">
																		<c:choose>
																			<c:when test='${watch.member.accStatus == 1}'>
																				<a href="#" id="frozen${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},1)
																					class='btn btn-danger'>冷凍</a>
																				<a href="#" id="deFro${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},2)
																					class='btn btn-primary' style="display: none">解凍</a>
																			</c:when>
																			<c:otherwise>
																				<a href='#' id="frozen${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},1)
																					class='btn btn-danger' style="display: none">冷凍</a>
																				<a href='#' id="deFro${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},2)
																					class='btn btn-primary'>解凍</a>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<button class="btn btn-secondary" disabled>
																			紀錄良好</button>
																	</c:otherwise>
																</c:choose>
															</c:when>
															<c:when test="${param.grade-1<3}">
																<c:choose>
																	<c:when test="${watch.exGrading>=6}">
																		<c:choose>
																			<c:when test='${watch.member.accStatus == 1}'>
																				<a href="#" id="frozen${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},1)
																					class='btn btn-danger'>冷凍</a>
																				<a href="#" id="deFro${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},2)
																					class='btn btn-primary' style="display: none">解凍</a>
																			</c:when>
																			<c:otherwise>
																				<a href="#" id="frozen${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},1)
																					class='btn btn-danger' style="display: none">冷凍</a>
																				<a href="#" id="deFro${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},2)
																					class='btn btn-primary'>解凍</a>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<button class="btn btn-secondary" disabled>
																			紀錄良好</button>
																	</c:otherwise>
																</c:choose>
															</c:when>
															<c:when test="${param.grade-1<4}">
																<c:choose>
																	<c:when test="${watch.exGrading>=7}">
																		<c:choose>
																			<c:when test='${watch.member.accStatus == 1}'>
																				<a href="#" id="frozen${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},1)
																					class='btn btn-danger'>冷凍</a>
																				<a href="#" id="deFro${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},2)
																					class='btn btn-primary' style="display: none">解凍</a>
																			</c:when>
																			<c:otherwise>
																				<a href="#" id="frozen${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},1)
																					class='btn btn-danger' style="display: none">冷凍</a>
																				<a href="#" id="deFro${watch.memCommented}"
																					onclick=FrozenMember(${watch.memCommented},2)
																					class='btn btn-primary'>解凍</a>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<button class="btn btn-secondary" disabled>
																			紀錄良好</button>
																	</c:otherwise>
																</c:choose>
															</c:when>
														</c:choose></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

								<div id="main" style="flex: 4; width: 750px; height: 600px;"></div>
							</div>
						</div>


					</div>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fa fa-table mr-1"></i>使用者互評管理
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>評價編號</th>
											<th>評價者編號</th>
											<th>評價者姓名</th>
											<th>評價時間</th>
											<th>給對方評分</th>
											<th>被評價者編號</th>
											<th>對另一方評價內容</th>
											<th>資料處理</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var='data' items='${usercomments}'>
											<tr>

												<td><c:out value="${data.commentNo}" default="無" /></td>
												<td><c:out value="${data.commentorNo}" default="無" /></td>
												<td><c:out value="${data.memberName}" default="無" /></td>
												<td><c:out value="${data.msgTime}" default="無" /></td>
												<td><c:out value="${data.exGrading}" default="無" /></td>
												<td><c:out value="${data.memCommented}" default="無" /></td>
												<td><c:out value="${data.msgDetail}" default="無" /></td>
												<td style="width: 180px"><a class="btn btn-danger"
													href='DeleteUserCommont/${data.commentNo}'>刪除</a> <c:choose>
														<c:when test="${data.stat==1}">
															<a class='btn btn-light'
																href='UpdateStatus?key=${data.commentNo}&stat=${data.stat}'><span>已發布</span></a>
														</c:when>
														<c:otherwise>
															<a class='btn btn-primary'
																href='UpdateStatus?key=${data.commentNo}&stat=${data.stat}'><span>未發布</span></a>

														</c:otherwise>

													</c:choose></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
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
	<script>
		$(document).ready(function() {
			var value;
			$("#grade1").change(function() {
				value = $("#grade1").val();
				console.log(value);
				$(".lgtwo").text(value);
			})

		})
		
		function FrozenMember(memberid, num){
			console.log(num);
			console.log(status);	
			    if(num==1){
			    	var action=0;
                $("#frozen"+memberid).css("display","none");
   			   $("#deFro"+memberid).css("display","inline");
				 }else if(num==2){
			       var action=1;
				console.log(action);
				  $("#frozen"+memberid).css("display","inline");
	   			  $("#deFro"+memberid).css("display","none");
			   }
		     $.ajax({
 				url : "UpdateMemberStatus", //請求的url地址
 				dataType : "json", //返回格式為json
 				async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
 				data : {
     				"memberid":memberid,
     				"action":action
 				}, //引數值
 				type : "GET", //請求方式
 				success : function(req) {
                      console.log(req)
 				 },
 				complete : function() {
 					//請求完成的處理
 				},
 				error : function() {
 					console.log("出錯了!")
 				}
 			});

			}
		
	</script>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));

		// 指定图表的配置项和数据
// 		window.onload=function(){
	
			myChart.clear();
			myChart.showLoading({
				text : '努力讀取數據中...'
			});	

			 $.ajax({
 				url : "SelectPie", //請求的url地址
 				dataType : "json", //返回格式為json
 				async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
 				type : "GET", //請求方式
 				success : function(req) { 
                       console.log(req);
               		option = {
       				     title: {
       				        text: '使用者互評分析',
       				        left: 'center',
       				    },
       				    tooltip: {
       				        trigger: 'item',
       				        formatter: '{b}: {c} ({d}%)'
       				    },
       				    series: [
       				        {
       				            name: '評分',
       				            type: 'pie',
       				            selectedMode: 'single',
       				            radius: [0, '35%'],

       				            label: {
       				                position: 'inner',
       				                fontSize: 18
       				            },
       				            labelLine: {
       				                show: false
       				            },
       				            data: [
       				                {value: req[0]+req[1]+req[2], name: '差(1~3)'},
       				                {value: req[3]+req[4]+req[5], name: '尚可(4~6)'},
       				                {value: req[6]+req[7]+req[8]+req[9], name: '良好(7~10)'}
       				            ]
       				        },
       				        {
       				         
       				            type: 'pie',
       				            radius: ['40%', '55%'],
       				            label: {
       				                formatter: '{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
       				                backgroundColor: '#eee',
       				                fontSize: 18,
       				                color: '#555',
       				                borderWidth: 1,
       				                rich: {
       				                    a: {
       				                        color: '#999',
       				                        lineHeight: 22,
       				                        align: 'center'
       				                    },
       				                   //  abg: {
       				                    //     backgroundColor: '#333',
       				                    //     width: '100%',
       				                   //      align: 'right',
       				                     //    height: 22,
       				                    //    borderRadius: [4, 4, 0, 0]
       				                   // },
       				                    hr: {
       				                        borderColor: '#aaa',
       				                        width: '100%',
       				                        borderWidth: 0.5,
       				                        height: 0
       				                    },
       				                    b: {
       				                        color: '#000',
       				                        fontSize: 16,
       				                        lineHeight: 20
       				                    },
       				                    per: {
       				                        color: '#eee',
       				                        backgroundColor: '#334455',
       				                        padding: [5, 4],
       				                        fontSize: 16,
       				                        borderRadius: 2
       				                    }
       				                }
       				            },
       				            data: [
       				                {value: req[0], name: 'G-1'},
       				                {value: req[1], name: 'G-2'},
       				                {value: req[2], name: 'G-3'},
       				                {value: req[3], name: 'G-4'},
       				                {value: req[4], name: 'G-5'},
       				                {value: req[5], name: 'G-6'},
       				                {value: req[6], name: 'G-7'},
       				                {value: req[7], name: 'G-8'},
       				                 {value: req[8], name: 'G-9'},
       				                 {value: req[9], name: 'G-10'},
       				            ]
       				        }
       				    ]
       				};
       				
       		      myChart.setOption(option);
       		      myChart.hideLoading();              
 				 },
 				complete : function() {
 					//請求完成的處理
 				},
 				error : function() {
 					console.log("出錯了!")
 				}
 			});	
	
// 	     };

	
		//载入图表
	</script>
</body>
</html>