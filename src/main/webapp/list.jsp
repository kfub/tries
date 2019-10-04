<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("=="+basePath+"====");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script src="<%=basePath %>js/jquery-1.8.3.min.js"></script>
<body>
	<h4>list page</h4>
	welcome:<shiro:principal></shiro:principal>
	<br><br>
			<shiro:hasRole name="zhangsan">
				<a href="<%=basePath%>admin.jsp">admin.jsp</a>
			</shiro:hasRole><br><br>
			<shiro:hasRole name="users">
				<a href="<%=basePath%>user.jsp">user.jsp</a>
			</shiro:hasRole><br><br> 
			<shiro:hasRole name="admin">			
			<a href="<%=basePath%>index.jsp">index.jsp</a><br><br> 
			</shiro:hasRole>
				<a href="<%=basePath%>logout">logout</a><br><br><%-- 
			<a href="<%=basePath%>testShiroAnnotation">testShiroAnnotation</a><br><br> --%>
				<%--  <a href="<%=basePath%>user.jsp">user.jsp</a><br><br>
				<a href="<%=basePath%>admin.jsp">admin.jsp</a><br><br> 
				<a href="<%=basePath%>index.jsp">index.jsp</a><br><br> 
				<a href="<%=basePath%>logout">logout</a><br><br> --%>
	<shiro:hasRole name="admin">
		<form action="<%=basePath%>regsiter" method="post">
			名字:&nbsp;&nbsp;&nbsp;<input type="text" name="username"><br>
			密码:&nbsp;&nbsp;&nbsp;<input type="password" name="password"><br>
			盐值:&nbsp;&nbsp;&nbsp;<input type="text" name="password_salt"><br>
			status:<input type="text" name="status"><br>
			<input type="submit" value="注册"></input>
		</form>
	</shiro:hasRole>
</body>

	

</html>