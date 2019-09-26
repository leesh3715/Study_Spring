<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h3>회원 정보 출력</h3>
	<table border="1" width="300" cellspacing="0">
	<tr>
		<th>이름</th>
		<td>${name }</td>
	</tr>
	<tr>
		<th>나이</th>
		<td>${age }</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${phone}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<a href="<%=request.getContextPath() %>/insert.do">[돌아가기]</a>
		</td>
	</tr>
	</table>
	</div>
</body>
</html>