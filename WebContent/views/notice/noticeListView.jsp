<%@page import="notice.model.vo.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, notice.model.vo.Notice"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
	String con = (String) request.getAttribute("condition");
	String search = (String) request.getAttribute("search");

	Page pG = (Page) request.getAttribute("pG");
	int listCt = pG.getListCt();
	int curPage = pG.getCurPage();
	int maxPage = pG.getMaxPage();
	int startPage = pG.getStartPage();
	int endPage = pG.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<style>
.fo {
	margin-top: 50px;
	width: 800px;
	height: 600px;
	background: #ffd663;
	margin: auto;
}

#listArea tr>td {
	text-align: center;
}

.list {
	margin: auto;
	margin-top: 50px;
	border-top: 1px solid rgba(48, 46, 46, 0.363);
	width: 618px;
	height: 400px;
}

.search {
	margin-top: 30px;
}

button {
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

#listArea {
	border-right: 1px solid rgba(48, 46, 46, 0.363);
	border-left: 1px solid rgba(48, 46, 46, 0.363);
	border-bottom: 1px solid rgba(48, 46, 46, 0.363);
}

.sub_b, .main_b {
	background: white;
	color: black;
	width: 25px;
	height: 20px;
}
</style>
<body>
	<%@ include file="../common/mainMenu.jsp"%>
	<script type="text/javascript">
		document.getElementById("mainName").innerHTML = "공지 사항";
	</script>

	<div class="fo">
		<br>
		<div class="list">
			<table id="listArea">
				<tr>
					<th width="50">글번호</th>
					<th width="50">분야</th>
					<th width="200">제목</th>
					<th width="100">작성자</th>
					<th width="100">조회수</th>
					<th width="100">작성일</th>
				</tr>

				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td colspan="5" onclick="event.cacelBubble=true;">공지사항이 존재하지
						않습니다.</td>
				</tr>
				<%
					} else {
				%>
				<%
					for (Notice n : list) {
				%>
				<tr>
					<td><%=n.getnNo()%></td>
					<td><%=n.getnCid()%></td>
					<td><%=n.getnTitle()%></td>
					<td><%=n.getnWriter()%></td>
					<td><%=n.getViewCt()%></td>
					<td><%=n.getnDate()%></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>
		</div>
		<br>
		<div class="pageInfo" align="center">
			<%
				if (con == null && search == null) {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/list.no?curPage=1'">
				&lt;&lt;</button>
			<%
				} else {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/search.no?curPage=1&condition=<%=con%>&search=<%=search%>'">
				&lt;&lt;</button>
			<%
				}
			%>
			<%
				if (curPage == 1) {
			%>
			<button class="sub_b" disabled>&lt;</button>
			<%
				} else {
			%>
			<%
				if (con == null && search == null) {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/list.no?curPage=<%=curPage - 1%>'">
				&lt;</button>
			<%
				} else {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/search.no?curPage=<%=curPage - 1%>&condition=<%=con%>&search=<%=search%>'">
				&lt;</button>
			<%
				}
			%>
			<%
				}
			%>

			<%
				for (int p = startPage; p <= endPage; p++) {
			%>
			<%
				if (p == curPage) {
			%>
			<button class="main_b" style='background-color: yellowgreen;'
				disabled>
				<%=p%>
			</button>
			<%
				} else {
			%>
			<%
				if (con == null && search == null) {
			%>
			<button class="main_b"
				onclick="location.href='<%=cp%>/list.no?curPage=<%=p%>'">
				<%=p%>
			</button>
			<%
				} else {
			%>
			<button class="main_b"
				onclick="location.href='<%=cp%>/search.no?curPage=<%=p%>&condition=<%=con%>&search=<%=search%>'">
				<%=p%>
			</button>
			<%
				}
			%>
			<%
				}
			%>
			<%
				}
			%>


			<%
				if (curPage == maxPage) {
			%>
			<button class="sub_b" disabled>&gt;</button>
			<%
				} else {
			%>
			<%
				if (con == null && search == null) {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/list.no?curPage=<%=curPage + 1%>'">
				&gt;</button>
			<%
				} else {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/search.no?curPage=<%=curPage + 1%>&condition=<%=con%>&search=<%=search%>'">
				&gt;</button>
			<%
				}
			%>
			<%
				}
			%>
			<%
				if (con == null && search == null) {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/list.no?curPage=<%=maxPage%>'">
				&gt;&gt;</button>
			<%
				} else {
			%>
			<button class="sub_b"
				onclick="location.href='<%=cp%>/search.no?curPage=<%=maxPage%>&condition=<%=con%>&search=<%=search%>'">
				&gt;&gt;</button>
			<%
				}
			%>
		</div>

		<div class="search" align="center">
			<form action="<%=cp%>/search.no" method="GET"
				onsubmit="return checkCsubmit();">
				<select id="condition" name="condition">
					<option>---</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select> <input type="search" name="search" style="width: 150px;">
				<button type="submit">검색하기</button>
				<%
					if (search != null && con != null) {
				%>
				<span><%=search%>의 검색결과
				</span>
				<%
					}
				%>
				<%
					if (loginMember != null && loginMember.gettId().equals("admin")) {
				%>
				<button id="noticeInsert" type="button"
					onclick="location.href='<%=cp%>/views/notice/noticeInsertForm.jsp'">작성하기</button>
				<%
					}
				%>
			</form>

			<script>
		function checkCsubmit() {
			if ($("#condition option:selected").val() == "---") {
				alert("---는 검색 불가능");
				return false;
			} else {
				return true;
			}
		}
		
		$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({"text-decoration":"underline","cursor":"pointer"});
			}).mouseout(function(){
				$(this).parent().css("text-decoration","none");
			}).click(function(){
				var num = $(this).parent().children().eq(0).text();
				if(num!="공지사항이 존재하지 않습니다."){	
					location.href="<%=cp%>/detail.no?nno=" + num;
						}
					});
				});
			</script>

		</div>
	</div>

</body>
</html>