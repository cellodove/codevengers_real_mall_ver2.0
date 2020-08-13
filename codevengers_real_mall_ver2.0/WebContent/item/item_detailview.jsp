<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세</title>
</head>
<body>
<div >
		<section >
			<h1>상품 내용</h1>
			<p>선택한 상품 내용입니다.</p>
			<div >
				<input type="hidden" name="item_num"
					value="<c:out value='${mallItemVO.item_num}'/>">
				<fieldset>
					<legend> 상품 내용</legend>
					<p>
						<label> 이름  :</label> <br/>
						<c:out value="${mallItemVO.item_name }" />
					</p>
					<p>
						<label> 종류  :</label> <br/>
						<c:out value="${mallItemVO.item_type }" />
					</p>
					
					<p>
						<label> 성별  :</label> <br/>
						<c:out value="${mallItemVO.item_gender }" />
					</p>
					
					<p>
						<label> 사이즈  :</label> <br/>
						<c:out value="${mallItemVO.item_size }" />
					</p>
					
					<p>
						<label> 가격  :</label> <br/>
						<c:out value="${mallItemVO.item_price }" />
					</p>
					
					<p>
						<label> 설명  :</label> <br/>
						<c:out value="${mallItemVO.item_summary }" />
					</p>
					
					<p>
						<label> 사진 </label> <br/>
						<img src="../images/product/<c:out value="${mallItemVO.item_picture }" />" width="442" height="442">
					</p>
					
					 
					 

					<div >
						<button type="button" onclick="location.href='./BoardList.bf'">
							구매</button>
						<button type="button" onclick="location.href='./BoardList.bf'">
							장바구니</button>
					</div>
				</fieldset>
			</div>
		</section>
	</div>

</body>
</html>