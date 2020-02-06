<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>

	.fo{
		width: 500px;
		height: 500px;
		background: #ffd663;
		color: #40b004;
		margin:auto;
	}
	
	#memberJoinform table{
		width: 100%;
		margin:auto;
	}
	
	
	#memberJoinForm td{
		text-align: right;
	}
	
	#idCheck, #pwdResult{
		float:left;
	}
	
	input{
		margin-top: 2px;
	}
	
	button{
		height: 25px;
		width: 80px;
		background: yellowgreen;
		border:yellowgreen;
		color: white;
		border-radius: 5px;
	}
	
	button:hover{
		cursor: pointer;
	}

</style>
</head>
<body>
	<%@ include file="../common/mainMenu.jsp"%>
	
	<div class="fo">
		<br>
		<h2 align="center">회원가입</h2>
		<form id="memberJoinForm" name="memberJoinForm" action="<%= cp %>/insert.me" method="post" onsubmit="return chkJoin();">
			<table>
				<tr>
					<td width="150px">아이디</td>
					<td><input type="text" maxlength="13" name="memberId" required="required"></td>
					<td width="150px"><button id="idCheck" type="button" onclick="checkId()">중복확인</button></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" maxlength="15" name="pwd1" required="required"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" maxlength="15" name="pwd2" required="required"></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="10" name="name" required></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" maxlength="11" name="phone" placeholder="전화번호를 입력하세요"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>흥미</td>
					<td>
						<input type="checkbox" id="sport" name="interest" value="운동"><label for="sport">운동</label>
						<input type="checkbox" id="game" name="interest" value="게임"><label for="sport">게임</label>
						<input type="checkbox" id="movie" name="interest" value="영화"><label for="movie">영화</label>
						<input type="checkbox" id="else" name="interest" value="기타"><label for="sport">기타</label>
					</td>
					<td></td>
				</tr>
			</table>
			<div class="sub" align="center">
				<button id="Main" onclick="returnMain()" type="button">메인으로</button>
				<button id="joinBtn">가입하기</button>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		function returnMain(){
			location.href="<%= cp %>";
		}
		
		function chkJoin(){
			if(!(/^[a-z\dㄱ-ㅎ가-힣]{4,12}$/.member($("#memberJoinForm input[name=memberId]").val()))){
				alert('아이디는 최소 영/한/숫자로 시작하여 4자부터 12자');
				$("#memberJoinForm input[name=memberId]").select();
				return false;
			}
			
			if($("#memberJoinForm input[name=pwd1]").val() != $("#memberJoinForm input[name=pwd2]").val()){
				$("#pwdResult").text('비밀번호 불일치').css("color","red");
				return false;
			}else{
				$("#pwdResult").text('비밀번호 일치').css("color","green");
			}
			
			return true;
		}
		
		function checkId(){
			window.open("idCheck.jsp","checkForm","width=300, height=200");
		}
	</script>

</body>
</html>