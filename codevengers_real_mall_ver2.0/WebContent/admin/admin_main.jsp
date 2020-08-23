<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String mem_id = (String) session.getAttribute("mem_id");
String login_check = "";
String member_register_check = "";
String login_check1 = "";
String login_ok = "";

 //로그인이라면
	login_check = "location.href='./AdminLogout.ko'";
	login_check1 = "로그아웃";
	login_ok = mem_id + "관리자님" + "환영합니다.";
	
session.setAttribute("mem_id", mem_id);
%>

<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>관리자 화면</title>
</head>
<body>
<%= login_ok %><br>
<button type="button" value="button" onclick="<%=login_check %>"><%=login_check1%></button>

<form action="./MemberManagement.ko">
<input type="submit" value="회원관리">
</form>

<form action="./GoItemManagement.ko">
<input type="submit" value="상품관리">
</form>

<form action="./GoBuyManagement.ko">
<input type="submit" value="구매관리">
</form>

<form action="./GoAdminManagement.ko">
<input type="submit" value="관리자 관리">
</form>

</body>
</html>