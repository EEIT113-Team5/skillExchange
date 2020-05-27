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
<title>回覆留言-Skill Exchange</title>
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script src="../font-awesome/css/font-awesome.min.css"
	crossorigin="anonymous"></script>
<style>
label{
	font-size: 18px;
}
</style>
</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<jsp:include page="/fragment/modal.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid" >
				<h2 class="mt-4">回覆留言</h2>
					<form action="ReplyContactUs" method="POST" id="detailPart">
					<input type="hidden" name="contactNo" value="${cntBean.contactNo}">
						<div class="form-group">
							<label>留言者姓名</label>
							<input type="text" readonly class="form-control" value="${cntBean.contactUser}">
						</div>
						<div class="form-group">
							<label>留言者信箱</label>
							<input type="text" readonly class="form-control" value="${cntBean.email}">

						</div>
						<div class="form-group">
							<label>主旨</label>
							<input type="text" readonly class="form-control" value="${cntBean.title}">
						</div>
						<div class="form-group">
							<label>內容</label>
							<textarea readonly class="form-control">${cntBean.content}</textarea>
						</div>
						<div class="form-group">
							<label for="replyText">回覆內容</label>
							<textarea readonly class="form-control" ${(param.type=="R") ? 'style="display:none"' : ''}>${cntBean.replyContent}</textarea>
							<textarea class="form-control" id="replyContent" name="replyContent"
								${(param.type=="V") ? 'style="display:none"' : ''}>${param.replyContent}</textarea>
						</div>
						<button type="submit" class="btn btn-primary">送出</button>
						<a type="button" class="btn btn-outline-dark" href="queryContactUs">回上一頁</a>
					</form>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2020</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
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
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<c:if test="${not empty MsgOK}">
		<script>
			let message = "${MsgOK.updateOK}";
			$("#alertText").text(message);
			$("#alertModal").modal('show');
		</script>
	</c:if>
	<c:if test="${not empty MsgMap}">
		<script>
			let message = "${MsgMap.updateError}";
			$("#alertText").text(message);
			$("#alertModal").modal('show');
		</script>
	</c:if>
	<%
		session.removeAttribute("MsgOK");
	%>
</body>

</html>