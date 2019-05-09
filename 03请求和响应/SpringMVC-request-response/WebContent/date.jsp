<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("myDate", new java.util.Date());
	%>
	
	北京时间:<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>