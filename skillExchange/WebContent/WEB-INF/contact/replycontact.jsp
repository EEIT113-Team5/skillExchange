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
font {
	color: red;
	margin-left: 20px;
}
</style>

</head>

<body class="sb-nav-fixed">
	<div id="layoutSidenav">
		<jsp:include page="/fragment/left.jsp" />
		<jsp:include page="/fragment/modal.jsp" />
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h2 class="mt-4">留言清單</h2>
					<table class="table table-hover">
						<thead style="background-color: #F0F0F0">
							<tr>
								<th>留言者姓名</th>
								<th>留言者Email</th>
								<th>留言主旨</th>
								<th>回覆留言</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cntUs" items="${cntUsList}">
								<tr>
									<td width="200">${cntUs.contactUser}</td>
									<td width="300">${cntUs.email}</td>
									<td width="500">${cntUs.title}</td>
									<td>
										<a class="btn btn-success"
											id="replyBtn${cntUs.contactNo}"
											${(cntUs.isReply==1) ? 'style="display:none"' : ''}
											href="<c:url value='queryContactUsDetail?type=R&contactNo=${cntUs.contactNo}'/>">回覆</a>
										<a class="btn btn-info" id="viewBtn${cntUs.contactNo}"
											${(cntUs.isReply==0) ? 'style="display:none"' : ''}
											href="<c:url value='queryContactUsDetail?type=V&contactNo=${cntUs.contactNo}'/>">查看回覆</a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
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
	<form>
		<input type="hidden" name="a" />
	</form>
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
			let message = "${MsgOK.insertOK}";
			$("#alertText").text(message);
			$("#alertModal").modal('show');
		</script>
	</c:if>
	<%
		session.removeAttribute("MsgOK");
	%>
</body>

</html>