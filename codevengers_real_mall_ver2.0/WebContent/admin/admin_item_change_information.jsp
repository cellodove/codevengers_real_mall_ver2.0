<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 파일을 전송하기 위한 enctype -->
	<form action="./ItemUpdate.ko" enctype="multipart/form-data"	 method="post">
		<table style="width: 80%">
			<tr>
				<th>** 상품 수정 **</th>
			</tr>
			
			
			<tr>
				<td style="width: 20%">상품번호</td>
				<td>		
					<input type="text" name="item_num" value="${mallItemVO.item_num}"size="4" maxlength="4" readonly="readonly">
				</td>
			</tr>
			
			
			
			
			<tr>
				<td style="width: 20%">상품명</td>
				<td>
					<input type="text" name="item_name" value="${mallItemVO.item_name}">		
				</td>
			</tr>
			
			
			<tr>
				<td>종류</td>
				<td>
					<input type="radio" name="item_type" value="suitshoes" checked="checked">구두 
                    <input type="radio" name="item_type" value="running">운동화
				</td>
			</tr>
			
			<tr>
				<td>크기</td>
				<td>
					<input type="text" name="item_size" value="${mallItemVO.item_size}">
				</td>
			</tr>

			
			
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="item_gender" value="man" checked="checked">남자 
                    <input type="radio" name="item_gender" value="woman">여자
				</td>
			</tr>
			
			<tr>
                <td>제조일자</td>
                <td>
                    <input type="date" name="item_maketime" value="${mallItemVO.item_maketime}" />
                </td>
            </tr>
			
			
			<tr>
				<td>가격</td>
				<td><input type="text" name="item_price" value="${mallItemVO.item_price}"></td>
			</tr>
			
			<tr>
				<td>남은수량</td>
				<td><input type="text" name="item_remain" value="${mallItemVO.item_remain}"></td>
			</tr>
			
			<tr>
				<td>처음수량</td>
				<td><input type="text" name="item_allnumber" value="${mallItemVO.item_allnumber}"></td>
			</tr>
			
			<tr>
				<td>설 명</td>
				<td>
				<textarea name="item_summary" rows="3" cols="30" >${mallItemVO.item_summary}</textarea>
				</td>
			</tr>
			
			<tr>
				<td>이미지</td>
				<td>
					<input type="file" name="item_picture" size="30" value="${mallItemVO.item_picture}">
				</td>
			</tr>
			
			<tr>
				<td colspan="2"><br/> 
					<input type="submit" value="상품 수정">
					<input type="reset" value="새로 입력" onclick="resetInsertData()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>