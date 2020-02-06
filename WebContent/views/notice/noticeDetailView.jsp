<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Notice n = (Notice) request.getAttribute("notice");
	String[] nw = n.getnWriter().split(",");
	int userNo = Integer.parseInt(nw[0]);
	n.setnWriter(nw[1]);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<%=
		n.getnTitle()
	%>
</title>
</head>
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

    #header{
        box-sizing: border-box;
        border: 1px solid rgba(48, 46, 46, 0.363);
        width: 100%;
        height: 10%;
    }

    #content{
        box-sizing: border-box;
        height: 70%;
        margin: 30px 50px 0px 50px;
    }

    [id^="h-"]{
        float: left;
        text-align: center;
    }

    #h-writer{
        width: 20%;
        height: 100%;
    }

    #h-con{
        width: 25%;
        height: 100%;
    }

    #h-count{
        font-size: 13px; 
        margin: 5px 5px 0px 0px;
        float: right;
    }

    #footer *{
		height: 22px;
		width: 80px;
		background: yellowgreen;
		border: yellowgreen;
		color: white;
    }

   #h-con span{
        line-height: 55px;
        font-size: 13px; 
    }
</style>
<body>
	<%@ include file="../common/mainMenu.jsp"%>
	<script type="text/javascript">
		document.getElementById("mainName").innerHTML = "게시판 상세내용";
	</script>
	
	<div class="fo">
		<div id="header">
			<div id="h-writer">
				<p>
					작성자 : <b><%= n.getnWriter() %></b>
				</p>
			</div>
			<div id="h-con">
				<span>분야 : <b><%= n.getnCid() %></b></span> <span>·</span> <span><%=n.getnDate() %>
					작성</span>
			</div>
			<div id="h-count">
				조회수 : <b><%= n.getViewCt() %></b>
			</div>
		</div>
		<div id="content">
			<div id="title">
				<h2><%= n.getnTitle() %></h2>
			</div>
			<hr
				style="margin: 20px 0px; border-right: 1px solid #aaaa; border: 0; border-top: 1px solid #eee;">
			<div id="c-content">
				<p><%= n.getnContent().replace("\r\n", "<br>") %></p>
			</div>
		</div>
		<br>
		<div id="footer" align="center">
			<button type="button" onclick="returnList();">목록</button>
			<% if(loginMember != null) { %>
				<% if(userNo == loginMember.gettNo() || loginMember.gettNo() == 1) { %>
					<button id="modifyBtn" type="button" onclick="modifyNotice();">수정</button>
					<button id="deleteBtn" type="button" onclick="deleteNotice();">삭제</button>
				<% } %>
			<% } %>
		</div> 
	</div>

	<form action="" id="detailForm" method="post">
		<input type="hidden" name="nno" value="<%=n.getnNo()%>">
	</form>
	<script type="text/javascript">
		function returnList(){
			location.href="<%= cp %>/list.no";
		}
		
		function modifyNotice(){
			$("#detailForm").attr("action","<%= cp%>/modifyForm.no");
			$("#detailForm").submit();
		}
		
		function deleteNotice(){
			if(confirm("해당 글을 삭제하시겠습니까?")){
				$("#detailForm").attr("action","<%= cp%>/delete.no?nno="+<%= n.getnNo() %>);
				$("#detailForm").submit();
			}
		}
	</script>
</body>
</html>