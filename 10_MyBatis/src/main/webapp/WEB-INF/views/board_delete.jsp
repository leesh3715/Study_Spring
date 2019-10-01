<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<hr width="50%" color="skyblue">
	<h3>BOARD 게시글 삭제 페이지</h3>
	<hr width="50%" color="skyblue">
	
	<form method="post" action="<%=request.getContextPath() %>/board_delete_ok.do">
		<table border="1" width="400" cellspacing="0">
			<c:set var="dto" value="${delete }"/>
			<c:if test="${!empty dto }">
			 	<input type="hidden" name="board_no" value="${dto.getBoard_no() }">
				<input type="hidden" name="db_pwd" value="${dto.getBoard_pwd() }">
			 	<tr>
			 		<th> 삭제할 비밀번호</th>
			 		<td><input type="password" name="board_pwd">
			 	</tr>
			 	<tr>
			 		<td colspan="2" align="center">
			 		<input type="submit" value="삭제"> &nbsp;&nbsp;&nbsp;
			 		<input type="reset" value="취소">
			 		</td>
			 	</tr>
			</c:if>
		</table>
	</form>
</div>
</body>
</html>