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
		<hr width="400" color="green">
			<h3>파일 업로드 폼</h3>
		<hr width="400" color="green">
		
	<form method="post" action="<%=request.getContextPath() %>/upload_ok.do"
		enctype="multipart/form-data">
		<table border="1" width="400" cellspacing="0">
		<tr>
			<th>첨부파일1</th>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<th>첨부파일2</th>
			<td><input type="file" name="file2"></td>
		</tr>
		<tr>
			<th>첨부파일3</th>
			<td><input type="file" name="file3"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="파일 전송">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
			</td>
		</tr>
		</table>
	</form>	
	</div>
</body>
</html>