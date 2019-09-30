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
		<hr width="50%" color="green">
		<h3>BOARD 게시글 상세 내역</h3>
		<hr width="50%" color="green">
		<table border="1" width="400" cellspacing="0">
			<c:set var="dto" value="${Cont }"/>
			<c:if test="${!empty dto }">
				
				<tr>
					<th>글 번호</th>
					<td>${dto.getBoard_no() }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${dto.getBoard_writer() }</td>
				</tr>
				<tr>
					<th>글 제목</th>
					<td>${dto.getBoard_title() }</td>
				</tr>
				<tr>
					<th>글 내용</th>
					<td><textarea rows="8" cols="30" readonly>${dto.getBoard_cont() }</textarea></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${dto.getBoard_hit() }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${dto.getBoard_date() }</td>
				</tr>
			</c:if>
			<c:if test="${empty dto }">
			<tr>
				<td colspan="2" align="center">
				<h3>검색된 레코드가 없습니다.</h3>
				</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="수정" onclick="location.href='board_edit.do?no=${dto.getBoard_no() }'">
				<input type="button" value="삭제" onclick="location.href='board_delete.do?no=${dto.getBoard_no() }'">
				<input type="button" value="목록" onclick="location.href='board_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>