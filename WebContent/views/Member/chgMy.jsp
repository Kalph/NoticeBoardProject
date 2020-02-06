<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member t = (Member) session.getAttribute("loginMember");

	String id = t.gettId();
	String pwd = t.gettPwd();
	String name = t.gettName();
	String phone = (t.getPhone() != null) ? t.getPhone() : "";
	String email = (t.getEmail() != null) ? t.getEmail() : "";
	String intr = (t.getInterest() != null) ? t.getInterest() : "";

	String[] ckint = new String[4];

	if (t.getInterest() != null) {
		String[] intrs = t.getInterest().split(",");

		for (int i = 0; i < intrs.length; i++) {
			switch (intrs[i]) {
			case "운동":
				ckint[0] = "checked";
			case "게임":
				ckint[1] = "checked";
			case "영화":
				ckint[2] = "checked";
			case "기타":
				ckint[3] = "checked";
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
.outer {
	width: 600px;
	height: 500px;
	background: #ffd663;
	color: #40b004;
	margin-left: auto;
	margin-right: auto;
	margin-top: auto;
}

#updateForm table {
	width: 100%;
	margin: auto;
}

#updateForm td {
	text-align: right;
}

button {
	height: 22px;
	width: 100px;
	background: yellowgreen;
	border: yellowgreen;
	color: white;
	border-radius: 5px;
}

button:hover {
	cursor: pointer;
}

#pwdUpdateBtn {
	float: left;
}

#deleteBtn {
	background: orangered;
	border: orangered;
}
</style>
</head>
<body>
	<%@ include file="../common/mainMenu.jsp"%>

	<div class="outer">
		<br>
		<h2 align="center">정보수정</h2>
		<form id="updateForm" name="updateForm" action="<%=cp%>/update.me"
			method="post">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td><input type="text" maxlength="13" name="memberId"
						value=<%=id%> readonly="readonly"></td>
					<td width="200px">
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" maxlength="15" name="pwd1"
						value=<%=pwd%> required="required"></td>
					<td><button id="pwdUpdateBtn" onclick="updatePwd();"
							type="button">비밀번호 변경</button>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="10" name="name"
						value=<%=name%> required></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" maxlength="11" name="phone"
						value=<%=phone%> placeholder="전화번호를 입력하세요"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value=<%=email%>></td>
					<td></td>
				</tr>
				<tr>
					<td>흥미</td>
					<td><input type="checkbox" id="sport" name="interest"
						value="운동" <%=ckint[0]%>><label for="sport">운동</label> <input
						type="checkbox" id="game" name="interest" value="게임"><label
						for="sport" <%=ckint[1]%>>게임</label> <input type="checkbox"
						id="movie" name="interest" value="영화"><label for="movie"
						<%=ckint[2]%>>영화</label> <input type="checkbox" id="else"
						name="interest" value="기타" <%=ckint[3]%>><label
						for="sport">기타</label></td>
					<td></td>
				</tr>
			</table>
			<div align="center">
				<button id="toMain" onclick="returnToMain();" type="button">메인으로</button>
				<button id="updateBtn">수정하기</button>
				<br>
				<br>
				<button id="deleteBtn" onclick="deleteMember();" type="button">탈퇴하기</button>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		function returnToMain(){
			location.href="<%= cp %>";
		}
		
		function updatePwd(){
			window.open("pwdUpdateForm.jsp","비밀번호 변경창","width=500, height=300");
		}
		
		function deleteMember(){
			var pwd = prompt("비밀번호 입력.");
			
			if("<%= pwd %>" == pwd){
				var bool = confirm("정말로 탈퇴하시겠습니가?");
				
				if(bool){
					$("#updateForm").attr("action","<%= cp %>/delete.me");
					$("#updateForm").submit();
				}
			}else{
				alert("비밀번호를 잘못 입력하였습니다.");
			}
		}
	</script>
</body>
</html>