<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>비밀번호 변경</title>
<script type="text/javascript">
	var msg = "<%= msg %>";
	
	$(function(){
		if(msg != 'null'){
			alert("비밀번호 변경 성공");
		}
		
		if(msg == "true"){
			window.close();
		}
	});
</script>
</head>
<style>
	h3{
		text-align: center;
	}
	table{
		margin:auto;
	}
	td{
		text-align: right;
	}
	
	button{
		height: 21px;
		width: 100px;
		background: yellowgreen;
		border: yellowgreen;
		color: white;
		border-radius: 5px; 
	}
	button:hover{
		cursor:pointer;
	}
</style>
<body>
	<h3>비밀번호 변경</h3>
	<br>
	<form id="updatePwdForm" action="<%= request.getContextPath() %>/updatePwd.me" method="post" onsubmit="return checkPwd()">
		<table>
			<tr>
				<td><label>현재 비밀번호</label></td>
				<td width="30"></td>
				<td><input type="password" name="pwd" id="pwd" maxlength="15"></td>
			</tr>
			<tr>
				<td><label>변경할 비밀번호</label></td>
				<td width="30"></td>
				<td><input type="password" name="nPwd" id="nPwd" maxlength="15"></td>
 			</tr>
 			<tr>
				<td><label>변경할 비밀번호 확인</label></td>
				<td width="30"></td>
				<td><input type="password" name="nPwd2" id="nPwd2" maxlength="15"></td>
 			</tr>
		</table>
		<br><br>
		<div class="btns" align="center">
			<button id="updatePwdBtn">변경하기</button>
		</div>
	</form>
	<script>
		function checkPwd(){
			var pwd = $("#pwd");
			var nPwd = $("#nPwd");
			var nPwd2 = $("#nPwd2");
			
			if(pwd.val().trim() == "" || nPwd.val().trim() == "" || nPwd2.val().trim() == ""){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			if(nPwd.val() != nPwd2.val()){
				alert('비밀번호가 다릅니다.');
				nPwd2.select();
				return false;
			}
			
			return true;
			
		}
	</script>

</body>
</html>