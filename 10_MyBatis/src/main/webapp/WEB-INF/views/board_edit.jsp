<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="gray">
		<h3>BOARD 게시글 수정폼</h3>
		<hr width="50%" color="gray">
		<form method="post"
			action="<%=request.getContextPath()%>/board_edit_ok.do">
			<table border="1" width="400" cellspacing="0">
				<c:set var="dto" value="${modify }" />
				<c:if test="${!empty dto }">
				
					<input type="hidden" name="board_no" value="${dto.getBoard_no() }">
					<input type="hidden" name="db_pwd" value="${dto.getBoard_pwd() }">
					
					<tr>
						<th>작성자</th>
						<td><input name="board_writer" value="${dto.getBoard_writer() }" readonly></td>
					</tr>
					<tr>
						<th>글제목</th>
						<td><input name="board_title" value="${dto.getBoard_title() }"></td>
					</tr>
					<tr>
						<th>글내용</th>
						<td><textarea rows="8" cols="30" name="board_cont">${dto.getBoard_cont() }</textarea></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="board_pwd"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소">
						</td> 
					</tr>
				</c:if>
			</table>
		</form>
	</div>
</body>
</html>