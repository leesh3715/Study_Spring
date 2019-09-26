<%@page import="com.sist.model.PersonDTO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* 자바파일에 접근하기 위해서 사용 */
	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
	
	PersonDTO dto = ctx.getBean("dto", PersonDTO.class);
	
	request.setAttribute("person", dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${person.getName() } / ${person.getAge() } / ${person.getPhone() } / ${person.getAddr() }</h3>
	
</body>
</html>