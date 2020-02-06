<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(date);
	request.getSession().setAttribute("today", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<title>게시글 작성</title>
<style>
.fo {
	margin-top: 50px;
	width: 800px;
	height: 600px;
	background: #ffd663;
	margin: auto;
	border: 1px solid rgba(70, 68, 68, 0.164);
	box-sizing: border-box;
}

#header {
	box-sizing: border-box;
	border: 1px solid rgba(48, 46, 46, 0.363);
	width: 100%;
	height: 10%;
}

#content {
	box-sizing: border-box;
	height: 70%;
	margin: 30px 50px 0px 50px;
}

[id^="h-"] {
	float: left;
	text-align: center;
}

#h-writer {
	width: 20%;
	height: 100%;
}

#h-date {
	width: 20%;
	height: 100%;
}

#c-name {
	width: 100%;
	height: 10%;
}

#c-tag {
	width: 100%;
	height: 10%;
	margin: 10px 0px 10px 0px;
}

#c-content {
	width: 100%;
	height: 75%;
}

[id^="c-"] input, select, textarea {
	box-sizing: border-box;
	width: 100%;
	height: 100%;
}

[id^="c-"] input, select {
	font-size: 15px;
}

#c-content>::content {
	font-family: 'Nanum Gothic', sans-serif;
	font-size: 8px;
}

#footer * {
	height: 22px;
	width: 80px;
	background: yellowgreen;
	border: yellowgreen;
	color: white;
	border-radius: 5px;
}

button:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<%@ include file="../common/mainMenu.jsp"%>
	<script type="text/javascript">
		document.getElementById("mainName").innerHTML = "공지사항 작성";
	</script>

	<form action="<%=cp%>/insert.no" method="post"
		onsubmit="return chkTag();">
		<div class="fo">
			<div id="header">
				<div id="h-writer">
					<p id="writer"><%=loginMember.gettName()%></p>
				</div>
				<div id="h-date">
					<p id="date"><%=today%></p>
				</div>
			</div>
			<div id="content">
				<div id="c-name">
					<input type="text" size="50" name="title"
						placeholder="제목을 입력해 주세요.">
				</div>
				<div id="c-tag">
					<select name="tag">
						<option>태그를 선택해 주세요.</option>
						<option value="10">운동</option>
						<option value="20">게임</option>
						<option value="30">영화</option>
						<option value="40">기타</option>
					</select>
				</div>
				<div id="c-content">
					<textarea name="content" cols="60" rows="15" style="resize: none;"></textarea>
				</div>
			</div>
			<br>
			<div id="footer" align="center">
				<button type="button" onclick="javascript:history.back();">취소</button>
				<button type="submit" type="submit">등록</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function chkTag() {
			if ($("select > option:selected").val() == "태그를 선택해 주세요.") {
				alert("태그를 선택해 주세요.");
				return false;
			}
		}
	</script>
</body>
</html>