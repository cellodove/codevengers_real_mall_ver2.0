<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>

<form action="./MemberLoginCheck.do">
아이디&nbsp;&nbsp;&nbsp;<input type="text" name="mem_id"><br/>
비밀번호<input type="password" name="mem_passwd"><br/>
<input type="submit" value="로그인">
</form>
<br/>

<button type="button" onclick="location.href='./MemberFindAccountGo.do'">	아이디 비밀번호찾기</button>
<button type="button" onclick="location.href='./MemberSignup.do'">	회원가입</button>


</body>
</html>