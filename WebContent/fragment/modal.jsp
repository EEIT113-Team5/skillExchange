<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<script>
function closeModal(type){
	if(type==='C'){
		$("#insertErr").text("");
	}
}
function collectionGroupDelConfirm(){
	let collectGNo=$("#delText").data("collectgno");
	document.forms[0].action="<c:url value='UpdateCollections?cmd=DEL&collectGNo=" + collectGNo +"' />" ;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
function gNameEditComfrimBtn(){
	let editName=$("#editText").data("editname");
	let collectGNo=$("#editText").data("collectgno");
	console.log(editName);
	console.log(collectGNo);
	document.forms[0].action="<c:url value='UpdateCollections?cmd=MOD&groupNameText="+editName+"&collectGNo=" + collectGNo +"' />" ;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
function delDetailConfirm(){
	let collectNo=$("#delDetailText").data("collectno");
	console.log(collectNo);
	document.forms[0].action="<c:url value='UpdateCollections?cmd=dDEL&collectNo=" + collectNo +"' />" ;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
function editDetailConfirm(){
	let collectNo=$("#editDetailSel").data("collectno");
// 	console.log($(":selected").val());
	let newCollectGNo = $(":selected").val();
	document.forms[0].action="<c:url value='changeCollectionGroup?newCollectGNo="+newCollectGNo+"&collectNo=" + collectNo +"' />" ;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
</script>
</head>
<!-- 新增類別modal -->
<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="insertModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="insertModalLabel">新增類別</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="insertText" placeholder="請輸入要新增的類別名稱" class='form-control'>
                <span id="insertErr" style="color:red"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal('C')">取消</button>
                <button type="button" class="btn btn-primary" onclick="collectionGroupNew()">確認</button>
            </div>
        </div>
    </div>
</div>
<!-- 刪除類別modal -->
<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="delModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="delModalLabel">刪除類別</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="delText"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
                <button type="button" class="btn btn-primary" onclick="collectionGroupDelConfirm()">確認</button>
            </div>
        </div>
    </div>
</div>
<!-- 編輯類別modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editModalLabel">編輯類別</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="editText"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="editalert">確認</button>
                <button type="button" class="btn btn-default" data-dismiss="modal" id="editCancel" style="display:none;">取消</button>
                <button type="button" class="btn btn-primary" id="editConfirm" onclick="gNameEditComfrimBtn()" style="display:none;">確認</button>
            </div>
        </div>
    </div>
</div>
<!-- 刪除明細modal -->
<div class="modal fade" id="delDetailModal" tabindex="-1" role="dialog" aria-labelledby="delDetailModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="delDetailModalLabel">刪除明細</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="delDetailText"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
                <button type="button" class="btn btn-primary" onclick="delDetailConfirm()">確認</button>
            </div>
        </div>
    </div>
</div>
<!-- 編輯明細modal -->
<div class="modal fade" id="editDetailModal" tabindex="-1" role="dialog" aria-labelledby="editDetailModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="editDetailModalLabel">編輯明細</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <label>請選擇類別</label>
                <select class="btn btn-light searchbar" style="width:400px" id="editDetailSel">
                <c:forEach var="groupList" items="${collectionGroupsMap}">
                	<option value="${groupList.key}">${groupList.value}</option>
                </c:forEach>
                </select>
            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
                <button type="button" class="btn btn-primary" onclick="editDetailConfirm()">確認</button>
            </div>
        </div>
    </div>
</div>
<!-- 結果訊息modal -->
<div class="modal fade bd-example-modal-sm" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="alertModalLabel">
    <div class="modal-dialog modal-sm" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="alertModalLabel">執行結果</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="alertText"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">確認</button>
            </div>
        </div>
    </div>
</div>