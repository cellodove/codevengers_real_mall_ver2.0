<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 찾기</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    $(document)
            .ready(
                    function() {
                        $("#btn_join")
                                .click(
                                        function() {
                                            
                                            //alert("ok");
                                            if ($("#mem_name").val() == "") {
                                            	alert("이름을  꼭 입력하세요!");
                                                $("#mem_name").focus();
                                                return false;
                                            }else if($("#mem_birth").val() == ""){
                                            	alert("생일을  꼭 입력하세요!");
                                                $("#mem_birth").focus();
                                            }
                                       });
                    });
</script>
</head>

<body>
<form action="./MemberFindAccountPasswd.do" method="post" name="signupform"> 
아이디:&nbsp;<input type="text" name="mem_id" id="mem_id" size="8" maxlength="8" required="required"/><br>
이름:&nbsp;<input type="text" name="mem_name" id="mem_name" size="8" maxlength="8" required="required"/><br>
생일:&nbsp;<input type="date" name="mem_birth" id="mem_birth" id="mem_birth"size="8" maxlength="8" required="required"/><br><br>
<input type="submit" id="btn_join"  value="확인">
</form>
</body>
</html>