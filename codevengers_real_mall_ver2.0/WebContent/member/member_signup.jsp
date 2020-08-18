<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }  
    
</script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="jquery.ui.datepicker-ko.js"></script>
<script type="text/javascript">
    $(document)
            .ready(
                    function() {
                    	$.datepicker.setDefaults({
                    	    dateFormat: 'yy-mm-dd' //Input Display Format 변경
                    	    ,showOtherMonths: true
                    	});
                        $("#btn_join")
                                .click(
                                        function() {
                                            var tel1_pattern = /(^01[016789]$)/; //정규식
                                            
                                            //alert("ok");
                                            if ($("#id").val() == "") {
                                                alert("아이디를 꼭 입력하세요!");
                                                $("#id").focus();
                                                return false;
                                            } else if ($("#pwd").val() == "") {
                                                alert("비밀번호를 꼭 입력하세요!");
                                                $("#pwd").focus();
                                                return false;
 
                                            } else if ($("#pwd2").val() == "") {
                                                alert("비밀번호확인 을 꼭 입력하세요!");
                                                $("#pwd2").focus();
                                                return false;
 
                                            } else if ($("#pwd").val() != $(
                                                    "#pwd2").val()) {
                                                alert("비밀번호와 비밀번호 확인이 일치하지않습니다.");
                                                $("#pwd").val("");
                                                $("#pwd2").val("");
                                                $("#pwd1").focus();
                                                return false;
 
                                            } else if ($("#name").val() == "") {
                                                alert("이름을 꼭 입력하세요!");
                                                $("#name").focus();
                                                return false;
 
                                            } else if ($("#mem_birth").val() == "") {
                                                alert("생일을  꼭 입력하세요!");
                                                $("#mem_birth").focus();
                                                return false;
 
                                            } else if ($("#tel1").val() == "") {
                                                alert("전화번호 첫번째자리 입력하세요!");
                                                $("#tel1").focus();
                                                return false;
 
                                            } else if ($("#tel1").val().length != 3) {
 
                                                alert("전화1을 3개의 숫자로 꼭 입력하세요!");
                                                $("#tel1").val("");
                                                $("#tel1").focus();
                                                return false;
 
                                            } else if (isNaN($("#tel1").val())) {
                                                alert("전화1을 3개의 숫자로 꼭 입력하세요!");
                                                $("#tel1").val("");
                                                $("#tel1").focus();
                                                return false;
 
                                            } else if (!tel1_pattern.test($(
                                                    "#tel1").val())) {
                                                alert("010만 가능합니다.")
                                                $("#tel1").val("")
                                                $("#tel1").focus();
                                                return false;
                                            }
 
                                            else if ($("#tel2").val() == "") {
                                                alert("전화번호 두번째자리를 입력하세요!");
                                                $("#tel2").focus();
                                                return false;
 
                                            } else if ($("#tel1").val().length != 3) {
 
                                                alert("전화1을 3개의 숫자로 꼭 입력하세요!");
                                                $("#tel2").val("");
                                                $("#tel2").focus();
                                                return false;
 
                                            } else if (isNaN($("#tel2").val())) {
                                                alert("전화2을 3~4개의 숫자로 꼭 입력하세요!");
                                                $("#tel2").val("");
                                                $("#tel2").focus();
                                                return false;
 
                                            } else if ($("#tel2").val() != ""
                                                    & $("#tel2").val().length > 4
                                                    & isNaN($("#tel2").val())) {
                                                alert("okkkkkkk");
                                                //var pattern = /(^010$)/; //정규식 슬래쉬(/)로 시작해서, 슬래쉬(/)로 끝났다.
                                                var tel1 = $("#tel2").val();
                                                if (!pattern.test(tel1)) {
                                                    //틀리면
                                                    alert("010만 가능합니다.")
                                                    $("#te2").val("")
                                                    $("#te2").focus();
                                                    return false;
                                                }
                                            }
 
                                            else if ($("#tel3").val() == "") {
                                                alert("전화번호 세번째자리를 입력하세요!");
                                                $("#tel3").focus();
                                                return false;
 
                                            } else if ($("#sample6_postcode").val() == "") {
                                                alert("우편번호를 꼭 입력하세요!");
                                                $("#sample6_postcode").focus();
                                                return false;
 
                                            }else if ($("#sample6_address").val() == "") {
                                                alert("주소를 꼭 입력하세요!");
                                                $("#sample6_address").focus();
                                                return false;
 
                                            } else if ($("#sample6_detailAddress").val() == "") {
                                                alert("상세주소를 꼭 입력하세요!");
                                                $("#sample6_detailAddress").focus();
                                                return false;
 
                                            }  else if ($("#yes").is(':checked') == false
                                                    && $("#no").is(':checked') == false) {
                                     			   alert("이메일수신 여부를  꼭 선택하세요!");
                                     			  return false;
                                        
                                    		} else if ($("#yess").is(':checked') == false
                                                    && $("#noo").is(':checked') == false) {
                                                alert("문자수신 여부를  꼭 선택하세요!");
                                                return false;
                                                
                                            } else if ($("#man").is(':checked') == false
                                                    && $("#woman").is(':checked') == false) {
                                                alert("성별를  꼭 선택하세요!");
                                                return false;
                                                
                                            } else if ($("#email").val() == "") {
                                                alert("이메일을 꼭 입력하세요!");
                                                $("#email").focus();
                                                return false;
                                                
                                            } else {
                                                alert("가입되었습니다");
                                                alert("이메일 인증창으로 이동합니다.");
                                            }
                                        });
                      
                        $("#mem_birth").datepicker();
                        
                    });
</script>


<body>
<form action="./MemberAdd.do" method="post" name="signupform">
<fieldset>
<table>
	<h1>회원가입</h1>
	
			<tr>
                <th>아이디</th>
                <td>
                    <input type="text" name="mem_id" id="id" size="12" maxlength="12" />
                </td>
            </tr>
            
            <tr>
                <th>비밀번호</th>
                <td>
                    <input type="password" name="mem_passwd" id="pwd" size="12" maxlength="12" />
                </td>
            </tr>
            
            <tr>
                <th>비밀번호확인</th>
                <td>
                    <input type="password"  id="pwd2" size="12" maxlength="12" />
                </td>
            </tr>
            
           <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="mem_name" id="name" size="12" maxlength="12" />
                </td>
            </tr>
            
            <tr>
                <th>생일</th>
                <td>
                    <input type="text" name="mem_birth" id="mem_birth" id="mem_birth"size="8" maxlength="8" />
                </td>
            </tr>
            
            <tr>
                <th>전화번호</th>
                <td>
                    <input type="text" name="mem_tel1" id="tel1" size="3"maxlength="3" />- 
                    <input type="text" name="mem_tel2" id="tel2"size="4" maxlength="4" />- 
                    <input type="text" name="mem_tel3" id="tel3" size="4" maxlength="4" />
                </td>
            </tr>
            
            <tr>
                <th>우편번호</th>
                <td>
            
                	<input type="text" name="mem_zipcode" id="sample6_postcode" size="12" maxlength="12" placeholder="우편번호">
                	<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
                </td>
            </tr>
            
            <tr>
                <th>
                	주소
                </th>
                <td>
                	
                    <input type="text" name="mem_address1" id="sample6_address" placeholder="주소" />
                    <input type="text" name="mem_address2" id="sample6_detailAddress" placeholder="상세주소"/>
                    <input type="text" id="sample6_extraAddress" placeholder="참고항목">
                </td>
            </tr>
            
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="mem_gender" id="man"  value="남자" checked="checked">남자 
                    <input type="radio" name="mem_gender" id="woman"  value="여자">여자
                </td>
            </tr>
            
            <tr>
                <th>이메일</th>
                <td>
                    <input type="text" name="mem_email" id="email" size="30"maxlength="30" />
                </td>
            </tr>
            
            <tr>
                <th>이메일 수신여부</th>
                <td><input type="radio" name="mem_receive_email" id="yes" value="수신">수신
                    <input type="radio" name="mem_receive_email" id="no" value="미수신">미수신
                </td>
            </tr>
            
            <tr>
                <th>문자 수신여부</th>
                <td><input type="radio" name="mem_receive_sms" id="yess" value="수신">수신
                    <input type="radio" name="mem_receive_sms" id="noo" value="미수신">미수신
                </td>
            </tr></br>
            
            <tr>
                <td colspan="2">
                    <input type="submit" id="btn_join"  value="가입">
                    <input type="reset" id="btn_cancel" value="취소">
                </td>
            </tr>
</table>
</fieldset>
</form>
</body>
</html>