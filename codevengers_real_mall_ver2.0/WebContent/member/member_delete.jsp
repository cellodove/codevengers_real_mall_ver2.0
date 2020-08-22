<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
</head>
<body>
<form action="./MemberDelete.do">
		<input type="text" name="mem_id" value="${mem_id}" readonly="readonly"><br>
		<input type="password" name="mem_passwd" placeholder="비밀번호를 입력하세요"><br>
		<input type="submit" value="회원삭제">
	</form>

</body>
</html>