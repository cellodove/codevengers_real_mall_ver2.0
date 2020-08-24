<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
<h1>회원관리</h1>
	회원수: &nbsp;<strong><c:out value="${listcount}" /></strong>명
	<table>
		<caption>회원 관리</caption>
		<c:choose>
			<c:when test="${listcount>0}">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">아이디</th>
						<th scope="col">이름</th>
						<th scope="col">생일</th>
						<th scope="col">전화번호</th>
						<th scope="col">성별</th>
						<th>
						<th scope="col">이메일</th>
						<th scope="col">등급</th>
						<th scope="col">포인트</th>
						<th scope="col">매니져</th>

					</tr>
				</thead>
				<!-- 해당페이지 저장된 글 호출 -->
				<c:forEach var="member" items="${memberList}">
					<tbody>
						<tr>
							<td>
							<c:out value="${member.mem_num}" />
							</td>
							
							<td>
							<a href="./MemberDetail.ko?mem_id=<c:out value="${member.mem_id}"/>">
								<c:out value="${member.mem_id}" />
							</a>
							</td>
							
							<td>
								<c:out value="${member.mem_name}" />
							</td>
							
							<td>
								<c:out value="${member.mem_birth}" />
							</td>
							
							<td>
								<c:out value="${member.mem_tel1}" />-<c:out value="${member.mem_tel2}" />-<c:out value="${member.mem_tel3}" />
							</td>
							
							<td>
								<c:out value="${member.mem_gender}" />
							</td>
							
							<td>
							
							<td>
								<c:out value="${member.mem_email}" />
							</td>
							
							<td>
								<c:out value="${member.mem_grade}" />
							</td>
							
							<td>
								<c:out value="${member.mem_point}" />
							</td>
							
							<td>
								<c:out value="${member.mem_manager}" />
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
										<a href="./MemberManagement.ko?page=<c:out value="${page-1}"/>">[이전]</a>&nbsp;
									</c:otherwise>
								</c:choose> <c:forEach var="start" begin="${startpage}" end="${endpage}"
									step="1">
									<c:choose>
										<c:when test="${start eq page}">[<c:out
												value="${start}" />]
										</c:when>
										<c:otherwise>
											<a href="./MemberManagement.ko?page=<c:out value="${start}"/>">[<c:out
													value="${start}" />]
											</a>&nbsp;
										</c:otherwise>
									</c:choose>
								</c:forEach> <c:choose>
									<c:when test="${page>=maxPage}">[다음]</c:when>
									<c:otherwise>
										<a href="./MemberManagement.ko?page=<c:out value="${page+1}"/>">[다음]</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</tbody>
				</table>
	
	
	
	
	
	

</body>
</html>