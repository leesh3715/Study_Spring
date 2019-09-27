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
		<hr width="50%" color="purple">
		<h3>BOARD 게시글 수정</h3>
		<hr width="50%" color="purple">
		<form method="post" action="<%=request.getContextPath()%>/board_edit_ok.do">
			<table border="1" width="450" cellspacing="0">
				<c:set var="dto" value="${Modify }" />
				<c:if test="${!empty dto }">
				<input type="hidden" name="dbpwd" value="${dto.getBoard_pwd() }">
				<tr>
					<th>글 번호</th>
					<td><input name="board_no" value="${dto.getBoard_no() }" readonly></td>
				</tr>
				<tr>
					<tr>
						<th>작성자</th>
						<td>${dto.getBoard_writer() }"</td>
					</tr>
					<tr>
						<th>글 제목</th>
						<td><input name="board_title" value="${dto.getBoard_title() }"></td>
					</tr>
					<tr>
						<th>글 내용</th>
						<td><textarea rows="8" cols="30" name="board_cont">${dto.getBoard_cont() }"</textarea></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="board_pwd"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit" value="수정 완료">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소">
						</td>
					</tr>
				</c:if>
				<c:if test="${empty dto }">
					<tr>
						<td colspan="2" align="center">
							<h3>검색된 레코드가 없습니다.</h3>
						</td>
					</tr>
				</c:if>
			</table>
		</form>
	</div>
</body>
</html>