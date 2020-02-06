<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
</head>
<script type="text/javascript">
	function idValue(){
		var id;
		
		if("<%= request.getAttribute("result") %>" == "null"){
			id = opener.document.memberJoinForm.memberId.value;
			
		} else{
			id = "<%= request.getAttribute("id") %> ";
			if(<%= request.getAttribute("result") %> == 0){
				document.getElementById("confirm").removeAttribute("disabled");
			}else{
				document.getElementById("confirm").setAttribute("disabled","disabled");
			}
		}
		
		document.getElementById("id").value = id.trim();
	}
	
	function confirm(){
		if(<%= request.getAttribute("result") %> == 0){
			opener.document.memberJoinForm.memberId.value = document.getElementById("id").value;
			opener.document.memberJoinForm.memberId.setAttribute("readonly","readonly");
		}
		
		if(opener != null){
			self.close();
		}
	}
	
</script>
<body onload="idValue();">
	<b>아이디 중복 체크</b>
	<br>
	<form action="<%= request.getContextPath() %>/idCheck.me" id="idCheckForm" method="post">
		<input type="text" id="id" name="id">
		<input type="submit" value="중복확인">
	</form>
	<br>
	
	<% if(request.getAttribute("result") != null) {
		int result = (int)request.getAttribute("result");
		
			if(result>0){
	%>
				이미 사용중인 아이디입니다.
	<%
			} else {
	%>
				사용 가능한 아이디입니다.
	<%
			}
		}
	%>
	
	<br>
	
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	<input type="button" id="confirm" value="확인" onclick="confirm()" disabled>
</body>
</html>