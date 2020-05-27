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

<title>我的收藏-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
	crossorigin="anonymous"></script>

<style>
.confirmBtns {
	text-align: right;
	float: right;
}

.cntTableBtns {
	text-align: right;
	float: right;
}

.titleTableBtns {
	text-align: right;
	float: right;
}

.card {
	clear: both;
}

h1 {
	width: 180px;
}

#groupNewBtn {
	
}

.titleBlock {
	align-items: center;
	display: flex;
}
</style>
<script>
window.onload=function(){
	let group;
	let groupName;
	let groupNameText;
	let titleBtns;
	let cntBtns;
	let comfirmBtns;
	let collectGNo;
	let editName;
	let groupText;
	let header;
	let collectDetail;
	let scrollPosition;
	var collectGNameNum = $('[id^="collectGName"]').length;
	for(let i=0;i<collectGNameNum;i++){
		groupName = $("#collectGName"+i).text().trim();
		if(groupName=='未分類'){
			$("#collectGName"+i).closest("div").next("div").hide();
			}
		}
	
	
}
function buttonHide(){
	titleBtns = $("main").find(".titleTableBtns");
	titleBtns.hide();
	cntBtns = $("main").find(".cntTableBtns");
	cntBtns.attr("style","visibility:hidden");
}
function buttonShow(){
	groupName.show();
	comfirmBtns.remove();
	titleBtns.show();
	cntBtns.attr("style","visibility:visible");
}
function collectionGNameEdit(idx,text){
	groupText=text;
	collectGNo = $("#collectG"+idx).val();
    group = $("#collectGroup"+idx);
    groupName = $("#collectGName"+idx);
    groupName.hide();
    group.append("<input type='text' name='editname' class='form-control' id='editname'>");
    $("#editname").val(groupText).focus();
    buttonHide();
	
	let groupHeader = group.parent();
    groupHeader.append("<div class='confirmBtns'><a class='btn btn-outline-primary' href='#' id='confrimBtn' onclick='gNameEditComfrim("+collectGNo+")'>確認</a><a class='btn btn-outline-secondary' href='#' id='cancelBtn' onclick='gNameEditCancel()'>取消</a></div>");
}
function collectionGroupDel(idx,text){
	collectGNo = $("#collectG"+idx).val();
	group = $("#collectGroup"+idx);
	groupText=text;
	$("#delText").text("若刪除類別，連同明細一併刪除，確定刪除「"+groupText+"」? ");
	$("#delText").attr("data-collectgno",collectGNo);
	
	$("#delModal").modal('show');
}
function gNameEditCancel(){
	editName = $("#editname");
	comfirmBtns = $("main").find(".confirmBtns");
	editName.remove();
	buttonShow();
	
	
}
function gNameEditComfrim(collectGNo){
	let editName = $("#editname").val().trim();
	if  (editName === "") {
		$("#editText").text('不能修改為空白');
		$("#editModal").modal('show');
		}
	
	else if  (editName === groupText) {
		$("#editText").text('名稱未修改');
		$("#editModal").modal('show');
	}
	else {
		$("#editText").attr("data-collectgno",collectGNo);
		$("#editText").attr("data-editname",editName);
		$("#editText").text('確定修改為「'+editName+'」？');
		$("#editalert").attr("style","visibility:hidden");
		$("#editCancel").attr("style","visibility:visible");
		$("#editConfirm").attr("style","visibility:visible");
		$("#editModal").modal('show');
	}
	
}
function collectionGroupNew(){
	let insert = $("#insertText").val().trim();
		if(insert === ""){
			console.log($("#insertErr"));
			$("#insertErr").text('未輸入類別名稱');
		}else if(insert == null){
			$("#insertErr").text('未輸入類別名稱');
		}else{
			document.forms[0].action="<c:url value='InsertColletionGroup?groupNameText="+insert+"'/>" ;
			document.forms[0].method="POST";
			document.forms[0].submit();
		}
}
function editDetail(collectNo,groupName){
	collectDetail = $("#collectDetail"+collectNo);
	detailText = collectDetail.text();
	$("#editDetailModalLabel").text("編輯「"+groupName+"-"+detailText+"」");
	$("#editDetailSel").attr("data-collectno",collectNo)
	$("#editDetailModal").modal('show');
	
}
function delDetail(collectNo,groupName){
	collectDetail = $("#collectDetail"+collectNo);
	detailText = collectDetail.text();
	$("#delDetailText").text("確定刪除「"+groupName+"-"+detailText+"」? ");
	$("#delDetailText").attr("data-collectno",collectNo);
	
	$("#delDetailModal").modal('show');
	
}
</script>
</head>
<body id="body">
	<jsp:include page="/fragment/top1.jsp" />
	<section class="single-page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2>我的收藏</h2>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="/fragment/modal.jsp" />

	<div class="container">
		<!-- 					<ul class="nav nav-pills nav-justified" style="width:800px"> -->
		<!-- 						<li class="nav-item"><a class="nav-link active" data-toggle="pill" href="#post">貼文收藏</a> -->
		<!-- 						</li> -->
		<!-- 						<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#activity">活動收藏</a></li> -->
		<!-- 					</ul> -->
		<div class="tab-content">
			<div class="tab-pane  active" id="post">
				<div class="titleBlock" style="vertical-align: center">
					<h1 class="mt-4">我的收藏</h1>
					<a class="btn btn-outline-primary" href="#" id="groupNewBtn"
						data-toggle="modal" data-target="#insertModal"
						style="margin: 20px 5px 5px 5px"> <i class='fa fa-plus'></i>新增類別
					</a>
				</div>
				<div id="accordion">
					<c:choose>
						<c:when test="${not empty collectionsMap}">
							<c:forEach var='collectionGroup' items='${collectionsMap}'
								varStatus='vs'>
								<c:set var='collectionGroupsKey'
									value='${collectionGroup.key+0}'></c:set>
								<div class="card">
									<div class="card-header" style="background-color: #F0F0F0;">
										<div class="tabletext" id="collectGroup${vs.index}">
											<a class="card-link" data-toggle="collapse"
												id="collectGName${vs.index}">${collectionGroupsMap[collectionGroupsKey]}
											</a> <input type="hidden" id="collectG${vs.index}"
												value="${collectionGroup.key}">
										</div>
										<div class="titleTableBtns" id="titleTableBtns">
											<a class="btn btn-outline-dark" href="#"
												id="groupEditBtn${vs.index}"
												onclick="collectionGNameEdit(${vs.index},'${collectionGroupsMap[collectionGroupsKey]}')">
												<i class='fa fa-pencil'></i>編輯名稱
											</a> <a class="btn btn-outline-danger" href="#"
												id="groupDelBtn${vs.index}" data-idx="${vs.index}"
												data-text="${collectionGroupsMap[collectionGroupsKey]}"
												onclick="collectionGroupDel(${vs.index},'${collectionGroupsMap[collectionGroupsKey]}')">
												<i class='fa fa-trash'></i>刪除類別
											</a>
										</div>
									</div>
									<div id="collapse${vs.index}" class="collapse show"
										data-parent="#accordion">
										<table class="table table-hover">
											<tbody>
												<c:forEach var='collection' items='${collectionGroup.value}'>
													<tr>
														<td><img src="${collection.collectMPic}"
															class="collectImg">${collection.collectMName}</td>
														<td>
															<div style="text-align: left">
																<a id="collectDetail${collection.collectNo}"
																	href="publish?num=${collection.collectPNo}">${collection.collectPTitle}</a>
															</div>
														</td>

														<td>
															<div class="cntTableBtns">
																<a href="#" class="btn btn-primary"
																	onclick="editDetail(${collection.collectNo},'${collectionGroupsMap[collectionGroupsKey]}','${collection.collectMName}')">編輯</a>
																<a href="#" class="btn btn-danger"
																	onclick="delDetail(${collection.collectNo},'${collectionGroupsMap[collectionGroupsKey]}')">刪除</a>
															</div>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<h5 class="shadow p-4 mb-4 bg-white">尚無收藏的資料！</h5>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<!-- 						<div class="tab-pane  fade" id="activity"> -->
			<%-- 							<jsp:include page="/WEB-INF/collection/myactivities.jsp" /> --%>
			<!-- 						</div> -->
		</div>
	</div>

	<!-- ---------------------要加的部份-------------------- -->
	<jsp:include page="/fragment/bottom.jsp" />
	<!-- ---------------------要加的部份-------------------- -->


	<form>
		<input type="hidden" name="a" />
	</form>
	<c:choose>
		<c:when test="${not empty MsgOK}">
			<script>
        let message = "${MsgOK.updateOK}${MsgOK.delOK}${MsgOK.insertOK}";
		$("#alertText").text(message);
		$("#alertModal").modal('show');
        
    </script>
		</c:when>
		<c:when test="${not empty MsgMap}">
			<script>
        let message = "${MsgMap.updateError}${MsgMap.delError}";
        $("#alertText").text(message);
        $("#alertModal").modal('show');
    </script>
		</c:when>

	</c:choose>
	<%
		session.removeAttribute("MsgOK");
	%>
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