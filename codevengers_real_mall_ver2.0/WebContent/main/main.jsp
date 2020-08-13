<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String mem_id = (String)session.getAttribute("mem_id");
	String login_check = "";
	String member_register_check = "";
	String login_check1 = "";
	
	if(mem_id == null){  //로그인이 아니라면
		login_check = "location.href='./MemberLogin.do'";
		login_check1="로그인";
		
	} else {  //로그인이라면
		login_check = "location.href='./MemberLogout.do'";
		login_check1="로그아웃";
		
	}
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>

<script src="../js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
function formCK(){
    if(<%=mem_id %> == null){
      alert("로그인하세요");
    }else{
       document.MemberAllInfo.submit();
       return true;
    }
   }

</script>
</head>
<body>

<form action="./ItemMain.no" method="post">
<input type="submit" value="상품목록">
</form>

<form action="./BoardMain.go" method="post">
<input type="submit" value="게시판">
</form>

<button type="button" value="button" onclick="<%=login_check %>"><%=login_check1%></button>

<form action="./AdminLogin.ko" method="post">
<input type="submit" value="관리자 로그인">
</form>

<form action="./MemberAllInfo.do" method="post" onSubmit="formCK();return false" name="MemberAllInfo">
<input type="hidden" name="mem_id" value="<%=mem_id%>">
<input type="submit" value="회원전체정보">
</form>


</body>
</html>