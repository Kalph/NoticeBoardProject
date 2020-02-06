<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String cp = request.getContextPath();
	Member loginMember = (Member) session.getAttribute("loginMember");
	String msg = (String) session.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	var msg = "<%=msg%>";
	$(function(){
		if(msg != "null"){
			alert(msg);
			<%session.removeAttribute("msg");%>
		}
	});
</script>
</head>
<style>
	body {
        background: white;
        display: table;
        margin-top: 0;
        margin-left: auto;
        margin-right: auto;
        width: 100%;
        height: 1600px;
		background-size: cover;
    }
    
    header {
        position: fixed;
        box-sizing: border-box;
        background-color: rgba(0, 0, 0, 0.904);
        width: 100%;
        height: 10%;
        z-index: 10;
        opacity: 0.7;
    } 

    header>section {
        position: relative;
        margin-left: auto;
        margin-right: auto;
        width: 75%;
        height: 100%;
        align-content: center;
    }

    header>section>*, header>section>ul>li{
        float: left;
    }

    .logo_div{
        box-sizing: border-box;
        width: 20%;
        height: 100%;
    }

    .logo_div>#logo{
        width: 100%;
        height: 100%;
    }

    #search_btn{
        position: absolute;
        top: 0;
        bottom: 0;
        left:60%;
        height: 30%;
        margin: auto;
    }

    .grb_u{
        position: absolute;
        top: 0;
        left: 60%;
        right: 0;
        bottom: 0;
        margin: auto;
        width: 70%;
        height: 30%;
    }

    .grb_u>li{
        list-style:none;
    }
    .grb_u>li>div{
        text-decoration: none;
        color:white;
        margin-left: 25px;
        font-size: 23px;
        font-weight: 600;
    }

    header {
	    -webkit-transition: background-color 0.4s ease;
	    -moz-transition: background-color 0.4s ease;
	    -o-transition: background-color 0.4s ease;
	    transition: background-color 0.4s ease;
		float: right;
		left: 0px;
    	right: 0px;
	}	

	#memberJoin, #memberLogin, #myPage, #logoutBtn {
		width: 100px;
		height: 25px;
		color: white;
		border-radius: 5px;
		margin-top: 5px;
	}
	
	
    #footer *{
		height: 22px;
		width: 80px;
		background: yellowgreen;
		border: yellowgreen;
		color: white;
		border-radius: 5px;
    }

    button:hover{
		cursor: pointer;
        box-shadow: 0 80px 0 0 rgba(0,0,0,0.25) inset, 0 -80px 0 0 rgba(0,0,0,0.25) inset;
	}
	
	#memberJoin, #myPage {
		background: yellowgreen;
		border: yellowgreen;
	}
	
	#memberLogin, #logoutBtn {
		background: orangered;
		border: orangered;
	}
	
	#mainName{
		padding: 100px 0px 0px 10px;
	}
	
	.loginArea>form,#memberInfo{
		float: right;
	}
	
	#loginForm, #memberInfo{
		position:absolute;
		right:10px;
		position: fixed;
		z-index:10;
	}
</style>
<body>
	<header>
		<section>
			<div class="logo_div">
				<img id="logo" src="<%=cp%>/resources/m-img/cat.jpg">
			</div>
			<ul class="grb_u">
				<li><div class="menu" onclick="goMain();">HOME</div></li>
				<li><div class="menu" onclick="goNotice();">게시판</div></li>
			</ul>
		</section>
	</header>


	<h1 id="mainName" align="center" style="color: #f5830a;">메인 메뉴</h1>

	<div class="loginArea">
		<%
			if (loginMember == null) {
		%>
		<form id="loginForm" action="<%=cp%>/login.me" method="post"
			onsubmit="return loginCheck();">
			<table>
				<tr>
					<td><label>ID : </label></td>
					<td><input type="text" name="logId" id="logId"></td>
				</tr>
				<tr>
					<td><label>PWD : </label></td>
					<td><input type="password" name="logPwd" id="logPwd"></td>
				</tr>
			</table>
			<div class="btns" align="center">
				<button id="memberJoin" onclick="newJoin();" type="button">회원가입</button>
				<button id="memberLogin" type="submit">로그인</button>
			</div>
		</form>
		<%
			} else {
		%>
		<div id="memberInfo">
			<label><%=loginMember.gettName()%>님의 방문을 환영합니다.</label>
			<div class="btns" align="center">
				<button id="myPage"
					onclick="location.href='<%=cp%>/views/Member/chgMy.jsp';">정보수정</button>
				<button id="logoutBtn" onclick="logout();">로그아웃</button>
			</div>
		</div>
		<%
			}
		%>
	</div>
	
	<%-- 제목 스크립트 --%>
	<script type="text/javascript">
		document.getElementById("mainName").innerHTML="메인 메뉴";
	</script>

	<%-- 메뉴 바 스크립트 --%>
	<script>
	    $(window).scroll(function () {
	        if ($(this).scrollTop() > 1) {
	            $("header").css({"background":"white","box-shadow":"1px 1px 1px 1px rgba(199, 199, 199, 0.658)"});
	            $("header>section>h1").css("color","black");
	            $(".grb_u>li>div").css("color","black");
	        } else {
	            $("header").css({"background":"rgba(0, 0, 0, 0.904)","box-shadow":"none"});
	            $("header>section>h1").css("color","white");
	            $(".grb_u>li>div").css("color","white");
	        }
	    });
	
	    $(function(){
	        $(".grb_u>li>div").hover(function(){
	            $(this).css({"font-size":"1.5em","cursor":"pointer"});
	            
	        }).mouseleave(function(){
	            $(this).css({"font-size":"23px"});
	        });
	    });
	    
	    function goMain(){
	    	location.href="<%= cp%>";
	    }
	    
	    function goNotice(){
	    	location.href="<%=cp%>/list.no";
	    }
	    
	    function goBoard(){
	    	location.href="<%=cp%>/list.bo";
	    }
	</script>

	<%-- 로그인 폼 스크립트 --%>
	<script type="text/javascript">
		function loginCheck() {
			if ($("#logId").val().trim().length == 0) {
				alert("아이디를 입력하세요");
				$("#logId").focus();
				return false;
			}

			if ($("#logPwd").val().trim().length == 0) {
				alert("비밀번호를 입력하세요");
				$("#logPwd").focus();
				return false;
			}

			return true;
		}
		
		function logout(){
			location.href= '<%=cp%>/logout.me'
		}
		
		function newJoin(){
			location.href ="<%=cp%>/views/Member/testMemberJoin.jsp";
		}
	</script>
</body>
</html>