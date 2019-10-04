<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print("=="+basePath+"====");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath %>updateing?id=${user.userid}" method="post">
			 <input type="hidden"  value="${user.userid}" name=userid></input><br/>
		名字:<input type="text"  value="${user.username}" name=username></input><br/>
		密码:<input type="text"  value="${user.password}" name=password></input><br/>
			<input type="submit" />
	</form>
</body>
</html>