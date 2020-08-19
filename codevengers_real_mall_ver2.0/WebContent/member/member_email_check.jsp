<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript">
    $(document)
            .ready(
                    function() {
                        $("#email_code_ck")
                                .click(
                                        function() {
                                            if ($("#code").val() == $("#mem_code").val()) {
                                                alert("인증되었습니다."); 
                                                return true;
                                            } else{
                                                alert("인증번호를 확인해주세요");
                                                $("#mem_code").focus();
                                                return false;
                                            }
                                        });  
                    				});
</script>


<body>

<form action="./MemberSendMail.do">
이메일<input type="text" name="mem_email" value="<c:out value="${mem_email}"/>" readonly="readonly">
<input type="submit" value="인증 메일보내기"><br>
</form>


<form action="./MemberMailCodeCheck.do">
<input type="hidden" name="mem_email" value="<c:out value="${mem_email}"/>"><br>
<input type="hidden" name="email_code" id="code" value="<c:out value="${AuthenticationKey}"/>">
인증코드<input type="text" name="mem_email_code" id="mem_code" required>
<input type="submit" id="email_code_ck" value="확인">
</form>
</body>
</html>