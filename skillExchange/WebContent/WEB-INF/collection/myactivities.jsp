<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<head>


<style>
/* .confirmBtns { */
/* 	text-align: right; */
/* 	float: right; */
/* } */
/* .cntTableBtns { */
/* 	text-align: right; */
/* 	float: right; */
/* } */
/* .titleTableBtns { */
/* 	text-align: right; */
/* 	float: right; */
/* } */
/* .card{ */
/* 	clear:both;} */
/* h1{ */
/* 	width:180px; */
/* } */
/* #groupNewBtn{ */
/* } */
/* .titleBlock{ */
/* 	align-items: center;  */
/* 	display: flex;  */
}
</style>
<script>

</script>
</head>
<body>
	<div class="titleBlock" style="float: right; margin: 10px 25px">
		<!-- 						<h1 class="mt-4">我的收藏</h1> -->
		<a class="btn btn-outline-primary" href="#" id="groupNewBtn"
			data-toggle="modal" data-target="#insertModal"> <i
			class='fas fa-pencil-alt '></i>新增類別
		</a>
	</div>
	
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
</body>
