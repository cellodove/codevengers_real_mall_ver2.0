<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="ven.shop.model.MallItemVO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="adminDAO" class="ven.shop.dao.AdminDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리</title>
</head>
<body>
	
	
	<h1>상품 관리</h1>
	총 상품: &nbsp;<strong><c:out value="${listcount}" /></strong>개
	<table>
		<caption>남자 신발</caption>
		<c:choose>
			<c:when test="${listcount>0}">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">이름</th>
						<th scope="col">종류</th>
						<th scope="col">성별</th>
						<th scope="col">가격</th>
						<th scope="col">재고</th>
						<th scope="col">총수</th>
						<th scope="col">사진</th>

					</tr>
				</thead>
				<!-- 해당페이지 저장된 글 호출 -->
				<c:forEach var="item" items="${itemList}">
					<tbody>
						<tr>
							<td>
							<c:out value="${item.item_num}" />
							</td>
							
							<td>
							<a href="./ADItemDetail.ko?item_num=<c:out value="${item.item_num}"/>">
								<c:out value="${item.item_name}" />
							</a>
							</td>
							
							<td>
								<c:out value="${item.item_type}" />
							</td>
							
							<td>
								<c:out value="${item.item_gender}" />
							</td>
							
							<td>
								<c:out value="${item.item_price}" />
							</td>
							
							<td>
								<c:out value="${item.item_remain}" />
							</td>
							
							<td>
								<c:out value="${item.item_allnumber}" />
							</td>
							
						<%-- 	<%	
							ArrayList<MallItemVO> list = adminDAO.getItemList(page, limit); 
							for(MallItemVO mallItemVO : list){
							%> -
							
							<td>
								<img src="../images/product/<%= mallItemVO.getItem_picture %>" width="250" height="250">
							</td>
							
						 	<%	} %> --%>
							
							<td>
								<a href="./ADItemDelete.ko?item_num=<c:out value="${item.item_num}"/>" onclick="return confirm('정말로 삭제하시겠습니까?');">
							<button type="button">삭제</button>
								</a>
							</td>
							
						</tr>
					</tbody>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	
	<a href="./GoItemAdd.ko">
		<button type="button">상품추가</button>
	</a> 
	
	
	
	<table >
					<tbody>
						<c:if test="${searchlistcount==0}">
							<tr>
								<td colspan="4"></td>
								<td>등록된 글이 없습니다.</td>
							</tr>
						</c:if>
						<tr>
							<td colspan="5"><c:choose>
									<c:when test="${page<=1}">[이전]&nbsp;</c:when>
									<c:otherwise>
										<a href="./GoItemManagement.ko?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
									</c:otherwise>
								</c:choose> <c:forEach var="start" begin="${startpage}" end="${endpage}"
									step="1">
									<c:choose>
										<c:when test="${start eq page}">[<c:out
												value="${start}" />]
										</c:when>
										<c:otherwise>
											<a href="./GoItemManagement.ko?page=<c:out value="${start}"/>">[<c:out
													value="${start}" />]
											</a>&nbsp;
										</c:otherwise>
									</c:choose>
								</c:forEach> <c:choose>
									<c:when test="${page>=maxPage}">[다음]</c:when>
									<c:otherwise>
										<a href="./GoItemManagement.ko?page=<c:out value="${page+1}"/>">[다음]</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</tbody>
				</table>
	
	
	
	
	
	
</body>
</html>