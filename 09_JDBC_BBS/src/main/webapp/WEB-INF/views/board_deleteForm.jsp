<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="green">
		<h3>BOARD 게시글 삭제</h3>
		<hr width="50%" color="green">
		<form method="post" action="<%=request.getContextPath() %>/board_delete_ok.do">
		<c:set var="dto" value="${Delete }" />
		<input type="hidden" name="dbpwd" value="${dto.getBoard_pwd() }">
		<table border="1" width="400" cellspacing="0">
			<tr>
				<td><input name="board_no" value="${dto.getBoard_no() }" readonly></td>
			</tr>
			<tr>
				<td><input type="password" name="board_pwd"></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
						<input type="submit" value="삭제 완료">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소">
			</tr>
		</table>
		</form>
	</div>
</body>
</html>