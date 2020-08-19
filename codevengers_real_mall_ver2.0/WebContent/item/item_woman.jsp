<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여자신발</title>
</head>
<body>
	<h1>여자 신발</h1>
	여자신발: &nbsp;<strong><c:out value="${listcount}" /></strong>개
	<table>
		<caption>여자 신발</caption>
		<c:choose>
			<c:when test="${listcount>0}">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">신발이름</th>
						<th scope="col">신발종류</th>
						<th scope="col">성별</th>
						<th scope="col">가격</th>
						<th scope="col">사진</th>

					</tr>
				</thead>
				<!-- 해당페이지 저장된 글 호출 -->
				<c:forEach var="man_item" items="${itemManList}">
					<tbody>
						<tr>
							<td><c:out value="${man_item.item_num}" /></td>
							<td>
							<a href="./ItemDetail.no?item_num=<c:out value="${man_item.item_num}"/>">
								<c:out value="${man_item.item_name}" />
							</a>
							</td>
							
							<td>
								<c:out value="${man_item.item_type}" />
							</td>
							
							<td>
								<c:out value="${man_item.item_gender}" />
							</td>
							
							<td>
								<c:out value="${man_item.item_price}" />
							</td>
							
							<td>
								<img src="../images/product/<c:out value="${man_item.item_picure}" />" width="442" height="442">
							</td>
							
						</tr>
					</tbody>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	
	
	
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
										<a href="./ItemManList.no?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
									</c:otherwise>
								</c:choose> <c:forEach var="start" begin="${startpage}" end="${endpage}"
									step="1">
									<c:choose>
										<c:when test="${start eq page}">[<c:out
												value="${start}" />]
										</c:when>
										<c:otherwise>
											<a href="./ItemManList.no?page=<c:out value="${start}"/>">[<c:out
													value="${start}" />]
											</a>&nbsp;
										</c:otherwise>
									</c:choose>
								</c:forEach> <c:choose>
									<c:when test="${page>=maxPage}">[다음]</c:when>
									<c:otherwise>
										<a href="./ItemManList.no?page=<c:out value="${page+1}"/>">[다음]</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</tbody>
				</table>
	
	
	
	
	
	
</body>
</html>