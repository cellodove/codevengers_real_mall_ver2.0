<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ven.shop.model.MallItemVO"%>
<%@page import="java.util.ArrayList"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="adminDAO" class="ven.shop.dao.AdminDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
</head>


<body>
<div >
		<section >
			<h1>상품 내용</h1>
			<div >
				<fieldset>
					<legend> 상품 내용</legend>

					<p>
						<label> 번호 </label> <br/>
						<c:out value="${mallItemVO.item_num}"/>
						<input type="hidden" name="item_num" value="${mallItemVO.item_num}">
						
					</p>

					<p>
						<label> 이름 </label> <br/>
						<c:out value="${mallItemVO.item_name}"/>
						
					</p>
					
					<p>
						<label> 종류 </label> <br/>
						<c:out value="${mallItemVO.item_type}"/>
					</p>
					
					<p>
						<label> 크기 </label> <br/>
						<c:out value="${mallItemVO.item_size}"/>
						
					</p>
					
					<p>
						<label> 성별 </label> <br/>
						<c:out value="${mallItemVO.item_gender}"/>
					</p>
					
					<p>
						<label> 제조일자 </label> <br/>
						<c:out value="${mallItemVO.item_maketime}"/>
					</p>
					
					<p>
						<label> 가격 </label> <br/>
						<c:out value="${mallItemVO.item_price}"/>
					</p>
					
					<p>
						<label> 재고 </label> <br/>
						<c:out value="${mallItemVO.item_remain}"/>
					</p>
					
					
					<p>
						<label> 전체 수량 </label> <br/>
						<c:out value="${mallItemVO.item_allnumber}"/>
					</p>
					
					<p>
						<label> 상품설명 </label> <br/>
						<textarea rows="10" cols="5"><c:out value="${mallItemVO.item_summary}"/></textarea>
					</p>
					
					
					<p>
						<label> 등록일자 </label> <br/>
						<c:out value="${mallItemVO.item_date}"/>
					</p>
					


					<p>
						<label> 사진 </label> <br/>
						<img src="../images/product/${mallItemVO.item_picture}" width="442" height="442">
					</p>
						
						
					<div class="btnJoinArea">
						
						<a href="./GoAdminItemChangeInformation.ko?item_num=<c:out value="${mallItemVO.item_num}"/>">
							<button type="button">수정</button>
						</a> 
						
						<a href="./ADItemDelete.ko?item_num=<c:out value="${mallItemVO.item_num}"/>" onclick="return confirm('정말로 삭제하시겠습니까?');">
							<button type="button">삭제</button>
						</a>
						
						<button type="button" value="button"onclick="location.href='./MemberManagement.ko'">메인</button>
					</div>
				</fieldset>
			</div>
		</section>
	</div>

</body>
</html>