<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보전체</title>
</head>
<%
	String mem_id = (String)session.getAttribute("mem_id");
	session.setAttribute("mem_id", mem_id);
%>
<body>

<form action="./MemberMyInformation.do">
<input type="hidden" name="mem_id" value="<%=mem_id%>">
<input type="submit" value="회원정보">
</form>

<form action="./MemberMyWriting.do">
<input type="submit" value="내가쓴글">
</form>

<form action="./MemberMyBuy.do">
<input type="submit" value="구매내역">
</form>

<form action="MemberMyWishlist.do">
<input type="submit" value="장바구니">
</form>





</body>
</html>