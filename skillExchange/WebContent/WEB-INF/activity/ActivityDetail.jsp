<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
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

<title>SkillExchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script type="text/javascript">
    var displaybtn = function(token) {
    	 $.ajax({
 			url : "VerifyRecaptcha", //請求的url地址
 			dataType : "json", //返回格式為json
 			async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
 			data : {
 				"token":token,
 			}, //引數值
 			type : "POST", //請求方式
 			success : function(req) { 
 	 			console.log(req)
 	 			if(req.success==true){
 	 			   $("#submitmessage").attr('disabled', false);
 	 			   setTimeout(disableagn, 60000);
 	 			} else {
                  alert("機器人走開!!!!")
 	 	 		}
 			 },
 			complete : function() {
 				//請求完成的處理
 			},
 			error : function() {
 				console.log("出錯了!")
 			}
 		});

    	function disableagn(){
    		$("#submitmessage").attr('disabled', true);
        }
       
         
      };
      var onloadCallback = function() {
        grecaptcha.render('html_element', {
          'sitekey' : '6LcVo_sUAAAAADjGq79VnqJf2MyBfGXMLa6whS_b',
          'callback': displaybtn
        });
      };
    </script>
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/leaflet.css" />
<script src="js/leaflet.js"></script>
<!-- <script src="https://www.google.com/recaptcha/api.js"></script> -->
<style>
* {
	font-family: 微軟正黑體;
}

.a {
	background-color: #FFECF5;
}

.mapimg:hover {
	color: #004B97;
}

.btn {
    color:black !important;
}
.user_img {
	height: 70px;
	width: 70px;
	border: 1.5px solid #f5f6fa;
	border-radius: 50%;
}

.msgheader {
	background-color: #ACD6FF;
	padding-top: 4px;
	padding-bottom: 4px;
}

.user_nick {
	display: inline-block;
}

.textalign {
	text-align: right;
}
</style>
</head>
<body id="body">
	<jsp:include page="/fragment/top1.jsp" />
	<!-- -----要改 -->
	<section class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>活動詳情</h2>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div style="display: flex">
				<div style="flex: 0.5"></div>
				<div style="flex: 10">
					<c:forEach var='search' varStatus="var" items='${searchList}'>
						<div class="col-sm-12 mt-3">
							<div class="card">
								<c:choose>
									<c:when test="${search.imgB64==null}">
										<!-- 												class="stretched-link" -->
										<a href="ChooseOneActivity?activityid=${search.activityid}"><img
											src="activityimg/default.jpg" class="card-img-top"
											style="width: 100%; height: 350px;" /></a>
									</c:when>
									<c:otherwise>
										<!-- 												class="stretched-link" -->
										<a href="#"><img
											src="data:image/jpg;base64,${search.imgB64}"
											class="card-img-top" style="width: 100%; height: 350px" /></a>
									</c:otherwise>
								</c:choose>
								<div class="card-body">
									<h1 class="card-title m-2" style="font-weight: 2500">
										${search.title}</h1>
									<h5 class="card-text  m-2 mt-3">
										<i class="fa fa-commenting" aria-hidden="true"></i>&nbsp;說明:&nbsp;
										${search.descript}
									</h5>
									<h5 class="card-text  m-2">
										<i class="fa fa-user-circle-o" aria-hidden="true"></i>&nbsp;主辦:&nbsp;
										${search.member.memberName}
									</h5>

									<h5 class="card-text  m-2">
										<i class="fa fa-clock-o" aria-hidden="true"></i>&nbsp;開始:&nbsp;${search.beginDay}&nbsp;${search.beginTime}&nbsp;&nbsp;<i
											class="fa fa-clock-o" aria-hidden="true"></i>&nbsp;結束:&nbsp;${search.endDay}&nbsp;${search.endTime}
									</h5>

									<h5 class="card-text m-2">
										<i class="fa fa-map-marker" style="size: 30px"
											aria-hidden="true"></i>&nbsp;地點:&nbsp;${fn:substring(search.position, 0, 24)}
										<a type="button" style="color: #46A3FF"
											onclick=updateform(${search.activityid})><i
											class="fa fa-map-o " aria-hidden="true"></i>&nbsp;<small
											class="mapimg">查看圖例</small></a>
									</h5>
									<div class="ml-3">
										<span id="interest${search.activityid}">${search.interest}人有興趣</span><br>
										<span class="card-text" id="attendency${search.activityid}">${search.attendency}人要參加</span>
										<c:choose>
											<c:when test="${search.group2!=null }">
												<span id="limit${search.activityid}">/${search.group2}人為上限</span>
											</c:when>
											<c:otherwise>
												<span>/不限</span>
											</c:otherwise>
										</c:choose>
									</div>
									<c:if
										test='${search.member.memberRegNo!= memberBean.memberRegNo}'>
										<c:choose>
											<c:when
												test="${search.attendency<search.group2 ||search.group2==null }">
												<p class="mt-2">
													<c:choose>
														<c:when test="${search.result2 == 1}">
															<a type="button" class="btn btn-secondary interest"
																onclick=attendency(${search.activityid},0)
																id="cancelint${search.activityid}">取消有興趣</a>
															<a type="button" class="btn btn-secondary interest"
																style="display: none"
																onclick=attendency(${search.activityid},1)
																id="hasinterest${search.activityid}">有興趣</a>
														</c:when>
														<c:otherwise>
															<a type="button" class="btn btn-secondary interest"
																onclick=attendency(${search.activityid},1)
																id="hasinterest${search.activityid}">有興趣</a>
															<a type="button" class="btn btn-secondary interest"
																onclick=attendency(${search.activityid},0)
																style="display: none" id="cancelint${search.activityid}">取消有興趣</a>

														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${search.result == 1}">
															<a type="button"
																onclick=attendency(${search.activityid},3)
																class="btn btn-info cancel"
																id="cancel${search.activityid}">取消參加</a>
															<a type="button"
																onclick=attendency(${search.activityid},2)
																style="display: none" class="btn btn-info attend"
																id="attend${search.activityid}">會參加</a>
														</c:when>
														<c:otherwise>
															<a type="button"
																onclick=attendency(${search.activityid},2)
																class="btn btn-info attend"
																id="attend${search.activityid}">會參加</a>
															<a type="button"
																onclick=attendency(${search.activityid},3)
																style="display: none" class="btn btn-info cancel"
																id="cancel${search.activityid}">取消參加</a>
														</c:otherwise>
													</c:choose>
													<span class="updatetime"
														style="color: #8E8E8E; float: right">最後更新時間:${fn:substring(search.insertime, 0, 10)}</span>
											</c:when>
											<c:otherwise>

												<h3>活動已報名額滿!</h3>
												<span class="updatetime"
													style="color: #8E8E8E; float: right">&nbsp;最後更新時間:${fn:substring(search.insertime, 0, 10)}</span>
											</c:otherwise>
										</c:choose>
									</c:if>

								</div>
							</div>
						</div>
					</c:forEach>

				</div>
				<div style="flex: 0.1"></div>
				<div style="flex: 5">
					<div id="reply">
						<!-- 放對話框 -->
					</div>
					<c:if test="${memberBean.memberRegNo!=searchList[0].memberid}">
						<div class="card  mt-3 mr-5">
							<h5 class="card-header">
								<div class="input-group-prepend">
									<!-- 									 id="basic-addon1" -->
									<span class="input-group-text">暱稱</span>
								</div>
								<input type="text" class="form-control" placeholder="請輸入暱稱..."
									aria-describedby="basic-addon1" id="nickname">
							</h5>
							<div class="card-body">
								<p class="card-text">
									<textarea class="form-control" placeholder="想說的話..."
										aria-label="With textarea" id="message"></textarea>
								</p>
								<button class="btn btn-primary "
									onclick="submitmessage(${searchList[0].memberid},${searchList[0].activityid})"
									id='submitmessage' disabled>送出留言</button>
								<div style="float: right" id="html_element"></div>


							</div>
						</div>
					</c:if>

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
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>
	<!-- 	<script> -->
	<script
		src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
		async defer>
    </script>

	<script>
	function insertform() {
		var w_width = 1000;
		var w_height = 500;
		var x = (screen.width - w_width) / 2;
		var y = (screen.height - w_height) / 3;
		window.open('Activityforms.jsp', '活動表單',
				config = 'height=700,width=1000,top=' + y + ',left=' + x
						+ ',location=no,resizable=no,toolbar=no');
	}
	
	function attendency(activityid,num) {
	    console.log(num);
	    if(num==1){
            var interest="有興趣"
             $("#hasinterest"+activityid).css("display","none");
			 $("#cancelint"+activityid).css("display","inline");
		 } else if (num==0){
			 var interest="取消有興趣"
			$("#cancelint"+activityid).css("display","none");
			 $("#hasinterest"+activityid).css("display","inline");
		 }else if(num==2){
			 var interest="會參加"
		     $("#attend"+activityid).css("display","none");
			 $("#cancel"+activityid).css("display","inline");
		  } else if(num==3){
			 var interest="取消參加"
			  $("#attend"+activityid).css("display","inline");
			  $("#cancel"+activityid).css("display","none");
			}
		$.ajax({
			url : "RetrieveNumber", //請求的url地址
			dataType : "json", //返回格式為json
			async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
			data : {
				"id" : activityid,
// 				"memberid":5, //之後用seesion傳memberid
				"interest":interest
			}, //引數值
			type : "GET", //請求方式
			success : function(req) {
				console.log(req);
				var limit=$("#limit"+activityid).text();
				var limit1=limit.substring(1,limit.indexOf("人"));
				$("#interest"+activityid).text(req[1]+"人有興趣");
				$("#attendency"+activityid).text(req[0]+"人要參加");
				if(limit1==req[0]){
					location.reload();
				}
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
	<script>
	function updateform(activityid) {
		 console.log("hello"); 
	     var w_width = 1000; 
	     var w_height = 500; 
	     var x = (screen.width - w_width) /2;
	     var y = (screen.height - w_height) / 3; 
// 	url='UpdateActivity?activityid='+activityid+"&memberid="+memberid+"&title="+title+"&category="+category+"&descript="+descript+"&beginDay="+beginDay+"&beginTime="+beginTime+"&endDay="+endDay+"&endTime="+endTime+"&position="+position+"&lat="+lat+"&long1="+long1+"&group1="+group1+"&group2="+group2+"&imgB64="+imgB64;
	     window.open('OpenMap?activityid='+activityid,'地圖', config = 'height=515,width=720,top=' + y + ',left=' + x +',location=no,resizable=no,toolbar=no'); }
   window.setInterval(fetch,20000);
   window.onload = fetch;
   function fetch(){
       $.ajax({
			url : "SelectMessage", //請求的url地址
			dataType : "json", //返回格式為json
			async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
			data : {
				"activityid":${searchList[0].activityid}
			}, //引數值
			type : "GET", //請求方式
			success : function(req) {
				console.log(req);
				$("#reply").val("");
//				$("#reply").html("<h5>hello</h5>");
				var content= "";
               for(var i=0; i<req.length; i++){  
            	   var delOrUpdate="";
					if(req[i].memberid==${memberBean.memberRegNo}) {
						delOrUpdate+="<a href='#' class='btn btn-danger ml-5' onclick='del("+req[i].messageid+")'>刪除</a><a href='#' class='btn btn-warning' onclick='promp("+req[i].messageid+")'>修改</a><a href='#' class='btn btn-primary' style='display:none' id='modify"+req[i].messageid+"' onclick='upd("+req[i].messageid+")'>確認</a>";
                    }                  
					 content+="<div class='card mt-3 mr-5'><div class='card-header msgheader'><img src='"+req[i].member.memberPic+"' class='user_img' alt='會員圖片' />"+
 	       			"<h4 class='user_nick'><b>&nbsp;&nbsp;"+req[i].nickname+"</b></h4>"+delOrUpdate+"</div><div class='card-body'><blockquote class='blockquote mb-0'><p id='msgCont"+req[i].messageid+"'>"+req[i].msgContent+"</p><textarea class='form-control'  style='display:none;height:70px' aria-label='With textarea' id='message"+req[i].messageid+"'></textarea><footer class='blockquote-footer'>"+req[i].msgtime1.substr(0,19)+"</footer></blockquote></div>"
                    if(req[i].hostid==${memberBean.memberRegNo}){
                        if(req[i].hostContent==null){
                        content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'><textarea  class='form-control' style='height:70px' placeholder='請輸入回覆內容' id='textreply"+req[i].messageid+"'></textarea><a href='#' class='btn btn-info' onclick='replymsg("+req[i].messageid+")'>主辦人回復訊息</a></p></blockquote></div>";
                         }else {
                         content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>您回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
                         }

                      } else{
                   	   if(req[i].hostContent==null){
                              content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人尚未回覆訊息</p></blockquote></div>";
                               }else {
                               content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
                           }
                      }
                      content+="</div>";
               }
       	 
               document.getElementById("reply").innerHTML=content;
			
				$("#nickname").val("");
				$("#message").val("");
			 },
			complete : function() {
				//請求完成的處理
			},
			error : function() {
				console.log("出錯了!")
			}
		});

	   };
    
    function submitmessage(hostid, activityid){
       var nickname=$("#nickname").val();
       var message=$("#message").val();
       $.ajax({
			url : "SendMessage", //請求的url地址
			dataType : "json", //返回格式為json
			async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
			data : {
				"nickname" : nickname,
				"message":message,
				"hostid":hostid,
				"activityid":activityid
			}, //引數值
			type : "GET", //請求方式
			success : function(req) {
				console.log(req);
				$("#reply").val("");
// 				$("#reply").html("<h5>hello</h5>");
				var content= "";
				for(var i=0; i<req.length; i++){ 
					var delOrUpdate="";
					if(req[i].memberid==${memberBean.memberRegNo}) {
						delOrUpdate+="<a href='#' class='btn btn-danger  ml-5' onclick='del("+req[i].messageid+")'>刪除</a><a href='#' class='btn btn-warning' onclick='upd("+req[i].messageid+")'>修改</a>";
                     }              
					 content+="<div class='card mt-3 mr-5'><div class='card-header msgheader'><img src='"+req[i].member.memberPic+"' class='user_img' alt='會員圖片' />"+
 	       			"<h4 class='user_nick'><b>&nbsp;&nbsp;"+req[i].nickname+"</b></h4>"+delOrUpdate+"</div><div class='card-body'><blockquote class='blockquote mb-0'><p id='msgCont"+req[i].messageid+"'>"+req[i].msgContent+"</p><textarea class='form-control'  style='display:none;height:70px' aria-label='With textarea' id='message"+req[i].messageid+"'></textarea><footer class='blockquote-footer'>"+req[i].msgtime1.substr(0,19)+"</footer></blockquote></div>" 	
                   if(req[i].hostid==${memberBean.memberRegNo}){
                       if(req[i].hostContent==null){
                       content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'><textarea  class='form-control' style='height:70px' placeholder='請輸入回覆內容' id='textreply"+req[i].messageid+"'></textarea><a href='#' class='btn btn-info' onclick='replymsg("+req[i].messageid+")'>主辦人回復訊息</a></p></blockquote></div>";
                        }else {
                        content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>您回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
                        }

                     } else{
                  	   if(req[i].hostContent==null){
                             content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人尚未回覆訊息</p></blockquote></div>";
                              }else {
                              content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
                          }
                     }
                     content+="</div>";
              }
        	 
                document.getElementById("reply").innerHTML=content;
			
				$("#nickname").val("");
				$("#message").val("");
			 },
			complete : function() {
				//請求完成的處理
			},
			error : function() {
				console.log("出錯了!")
			}
		});

        }


       function replymsg(messageid){
         var hostContent= $("#textreply"+messageid).val();
//        alert(messageid);
       $.ajax({
			url : "UpdateHostMessage", //請求的url地址
			dataType : "json", //返回格式為json
			async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
			data : {
				"hostContent":hostContent,
				"Messageid":messageid,
				"activityid":${searchList[0].activityid}
			}, //引數值
			type : "GET", //請求方式
			success : function(req) { 
				console.log(req);
				$("#reply").val("");
//				$("#reply").html("<h5>hello</h5>");
				var content= "";
				for(var i=0; i<req.length; i++){  
					var delOrUpdate="";
					if(req[i].memberid==${memberBean.memberRegNo}) {
						delOrUpdate+="<a href='#' class='btn btn-danger  ml-5' onclick='del("+req[i].messageid+")'>刪除</a><a href='#' class='btn btn-warning' onclick='upd("+req[i].messageid+")'>修改</a>";
                     }                   
					 content+="<div class='card mt-3 mr-5'><div class='card-header msgheader'><img src='"+req[i].member.memberPic+"' class='user_img' alt='會員圖片' />"+
 	       			"<h4 class='user_nick'><b>&nbsp;&nbsp;"+req[i].nickname+"</b></h4>"+delOrUpdate+"</div><div class='card-body'><blockquote class='blockquote mb-0'><p id='msgCont"+req[i].messageid+"'>"+req[i].msgContent+"</p><textarea class='form-control'  style='display:none;height:70px' aria-label='With textarea' id='message"+req[i].messageid+"'></textarea><footer class='blockquote-footer'>"+req[i].msgtime1.substr(0,19)+"</footer></blockquote></div>"
                  if(req[i].hostid==${memberBean.memberRegNo}){
                      if(req[i].hostContent==null){
                      content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'><textarea  class='form-control' style='height:70px' placeholder='請輸入回覆內容' id='textreply"+req[i].messageid+"'></textarea><a href='#' class='btn btn-info' onclick='replymsg("+req[i].messageid+")'>主辦人回復訊息</a></p></blockquote></div>";
                       }else {
                       content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>您回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
                       }

                    } else{
                 	   if(req[i].hostContent==null){
                            content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人尚未回覆訊息</p></blockquote></div>";
                             }else {
                             content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
                         }
                    }
                    content+="</div>";
             }
       	 
               document.getElementById("reply").innerHTML=content;
			
				$("#nickname").val("");
				$("#message").val("");
			 },
			complete : function() {
				//請求完成的處理
			},
			error : function() {
				console.log("出錯了!")
			}
		});
      

        }

       function del(messageid){
    	      $.ajax({
    				url : "DelMessage", //請求的url地址
    				dataType : "json", //返回格式為json
    				async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
    				data : {
    					"Messageid":messageid,
    					"activityid":${searchList[0].activityid}
    				}, //引數值
    				type : "GET", //請求方式
    				success : function(req) { 
    					console.log(req);
    					$("#reply").val("");
//    					$("#reply").html("<h5>hello</h5>");
    					var content= "";
    					for(var i=0; i<req.length; i++){  
    						var delOrUpdate="";
    						if(req[i].memberid==${memberBean.memberRegNo}) {
    							delOrUpdate+="<a href='#' class='btn btn-danger  ml-5' onclick='del("+req[i].messageid+")'>刪除</a><a href='#' class='btn btn-warning' onclick='upd("+req[i].messageid+")'>修改</a>";
    	                     }                   
    						 content+="<div class='card mt-3 mr-5'><div class='card-header msgheader'><img src='"+req[i].member.memberPic+"' class='user_img' alt='會員圖片' />"+
    	    	       			"<h4 class='user_nick'><b>&nbsp;&nbsp;"+req[i].nickname+"</b></h4>"+delOrUpdate+"</div><div class='card-body'><blockquote class='blockquote mb-0'><p id='msgCont"+req[i].messageid+"'>"+req[i].msgContent+"</p><textarea class='form-control'  style='display:none;height:70px' aria-label='With textarea' id='message"+req[i].messageid+"'></textarea><footer class='blockquote-footer'>"+req[i].msgtime1.substr(0,19)+"</footer></blockquote></div>"
    	                  if(req[i].hostid==${memberBean.memberRegNo}){
    	                      if(req[i].hostContent==null){
    	                      content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'><textarea  class='form-control' style='height:70px' placeholder='請輸入回覆內容' id='textreply"+req[i].messageid+"'></textarea><a href='#' class='btn btn-info' onclick='replymsg("+req[i].messageid+")'>主辦人回復訊息</a></p></blockquote></div>";
    	                       }else {
    	                       content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>您回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
    	                       }

    	                    } else{
    	                 	   if(req[i].hostContent==null){
    	                            content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人尚未回覆訊息</p></blockquote></div>";
    	                             }else {
    	                             content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
    	                         }
    	                    }
    	                    content+="</div>";
    	             }
    	       	 
    	               document.getElementById("reply").innerHTML=content;
    				
    					$("#nickname").val("");
    					$("#message").val("");
    				 },
    				complete : function() {
    					//請求完成的處理
    				},
    				error : function() {
    					console.log("出錯了!")
    				}
    			});

           }

       function promp(messageid){
              $("#modify"+messageid).css("display","inline");
              var msgCont=document.getElementById("msgCont"+messageid).innerHTML;
              console.log(msgCont+"hello")
              $("#msgCont"+messageid).css("visibility","hidden");
              $("#msgCont"+messageid).css("font-size","1px")
              $("#message"+messageid).css("display","inline");
              $("#message"+messageid).text(msgCont);
         }


       function upd(messageid){
    	      var message=$("#message"+messageid).val();
    	      console.log(message);
    	      $.ajax({
    				url : "UpdateMemMessage", //請求的url地址
    				dataType : "json", //返回格式為json
    				async : true, //請求是否非同步，預設為非同步，這也是ajax重要特性
    				data : {
        				"Messageid":messageid,
    					"activityid":${searchList[0].activityid},
    					"message":message
    				}, //引數值
    				type : "GET", //請求方式
    				success : function(req) {
    					console.log(req);
    					$("#reply").val("");
//    					$("#reply").html("<h5>hello</h5>");
    					var content= "";
    	               for(var i=0; i<req.length; i++){  
    	            	   var delOrUpdate="";
    						if(req[i].memberid==${memberBean.memberRegNo}) {
    							delOrUpdate+="<a href='#' class='btn btn-danger ml-5' onclick='del("+req[i].messageid+")'>刪除</a><a href='#' class='btn btn-warning' onclick='promp("+req[i].messageid+")'>修改</a><a href='#' class='btn btn-primary' style='display:none' id='modify"+req[i].messageid+"' onclick='upd("+req[i].messageid+")'>確認</a>";
    	                    }                  
    	                      content+="<div class='card mt-3 mr-5'><div class='card-header msgheader'><img src='"+req[i].member.memberPic+"' class='user_img' alt='會員圖片' />"+
    	       			"<h4 class='user_nick'><b>&nbsp;&nbsp;"+req[i].nickname+"</b></h4>"+delOrUpdate+"</div><div class='card-body'><blockquote class='blockquote mb-0'><p id='msgCont"+req[i].messageid+"'>"+req[i].msgContent+"</p><textarea class='form-control'  style='display:none;height:70px' aria-label='With textarea' id='message"+req[i].messageid+"'></textarea><footer class='blockquote-footer'>"+req[i].msgtime1.substr(0,19)+"</footer></blockquote></div>"   	
    	                    if(req[i].hostid==${memberBean.memberRegNo}){
    	                        if(req[i].hostContent==null){
    	                        content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'><textarea  class='form-control' style='height:70px' placeholder='請輸入回覆內容' id='textreply"+req[i].messageid+"'></textarea><a href='#' class='btn btn-info' onclick='replymsg("+req[i].messageid+")'>主辦人回復訊息</a></p></blockquote></div>";
    	                         }else {
    	                         content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>您回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
    	                         }

    	                      } else{
    	                   	   if(req[i].hostContent==null){
    	                              content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人尚未回覆訊息</p></blockquote></div>";
    	                               }else {
    	                               content+="<hr><div class='card-body'><blockquote class='blockquote mb-0'><p class='textalign'>主辦人回復的訊息為:&nbsp;&nbsp;"+req[i].hostContent+"</p><footer class='blockquote-footer textalign'>"+req[i].hostmsgtime1.substr(0,19)+"</footer></blockquote></div>";
    	                           }
    	                      }
    	                      content+="</div>";
    	               }
    	       	 
    	               document.getElementById("reply").innerHTML=content;
    				
    					$("#nickname").val("");
    					$("#message").val("");
    				 },
    				complete : function() {
    					//請求完成的處理
    				},
    				error : function() {
    					console.log("出錯了!")
    				}
    			});

           }

//             DOCUMENT.GETELEMENTBYID('SUBMITMESSAGE').ONCLICK = FUNCTION(E){
//     	       GRECAPTCHA.EXECUTE();
//     	    }
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
