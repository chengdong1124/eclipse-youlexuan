<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>欢迎来到仙界</h1>
	<a href="http://192.168.59.132:8080/cas/logout?service=http://www.baidu.com">退出登录</a>
	<%= request.getRemoteUser() %>

</body>
</html>