<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세</title>
</head>
<body>
<div >
		<section >
			<h1>회원 내용</h1>
			<div >
				<input type="hidden" name="mem_num"
					value="<c:out value='${memberVO.mem_num}'/>">
				<fieldset>
					<legend> 회원내용 내용</legend>

					<p>
						<label> 아이디 </label> <br/>
						<c:out value="${memberVO.mem_id}"/>
						<input type="hidden" name="mem_id" value="${memberVO.mem_id}">
					</p>
					
					<p>
						<label> 비밀번호 </label> <br/>
						<c:out value="${memberVO.mem_passwd}"/>
					</p>
					
					<p>
						<label> 이름 </label> <br/>
						<c:out value="${memberVO.mem_name}"/>
						
					</p>
					
					<p>
						<label> 생일 </label> <br/>
						<c:out value="${memberVO.mem_birth}"/>
					</p>
					
					<p>
						<label> 전화번호 </label> <br/>
						<c:out value="0${memberVO.mem_tel1}"/>-<c:out value="${memberVO.mem_tel2}"/>-<c:out value="${memberVO.mem_tel3}"/>
					</p>
					
					<p>
						<label> 우편번호 </label> <br/>
						<c:out value="${memberVO.mem_zipcode}"/>
					</p>
					
					<p>
						<label> 주소 </label> <br/>
						<c:out value="${memberVO.mem_address1}"/>&nbsp;<c:out value="${memberVO.mem_address2}"/>
					</p>
					
					<p>
						<label> 성별 </label> <br/>
						<c:out value="${memberVO.mem_gender}"/>
					</p>
					
					<p>
						<label> 이메일 </label> <br/>
						<c:out value="${memberVO.mem_email}"/>
					</p>
					
					<p>
						<label> 이메일 인증 </label> <br/>
						<c:out value="${memberVO.mem_email_ck}"/>
					</p>
					
					<p>
						<label> 회원등급 </label> <br/>
						<c:out value="${memberVO.mem_grade}"/>
					</p>
					
					<p>
						<label> 포인트 </label> <br/>
						<c:out value="${memberVO.mem_point}"/>
					</p>
					
					<p>
						<label> 이메일수신여부 </label> <br/>
						<c:out value="${memberVO.mem_receive_email}"/>
					</p>
					
					<p>
						<label> 문자수신여부 </label> <br/>
						<c:out value="${memberVO.mem_receive_sms}"/>
					</p>
					
					<p>
						<label> 회원등록일 </label> <br/>
						<c:out value="${memberVO.mem_register_datetime}"/>
					</p>
					
					<p>
						<label> 관리자 메모 </label> <br/>
						<c:out value="${memberVO.mem_adminmemo}"/>
					</p>	
						
					<p>
						<label> 회원 그룹 </label> <br/>
						<c:out value="${memberVO.mem_group}"/>
					</p>	
						
					<p>
						<label>	매니저 여부 </label> <br/>
						<c:out value="${memberVO.mem_manager}"/>
					</p>	
						
						
					<div class="btnJoinArea">
						
						<a href="./GoAdminMemberChangeInformation.ko?mem_id=<c:out value="${memberVO.mem_id}"/>">
							<button type="button">수정</button>
						</a> 
						<a href="./MemberDeleteGo.ko?mem_id=<c:out value="${memberVO.mem_id}"/>">
							<button type="button">탈퇴</button>
						</a>
						<button type="button" value="button"onclick="location.href='./MemberManagement.ko'">메인</button>
					</div>
				</fieldset>
			</div>
		</section>
	</div>

</body>
</html>