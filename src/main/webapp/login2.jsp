<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("=="+basePath+"====");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <script src="<%=basePath %>js/jquery-1.8.3.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>

${lastw }
<h3>cookieTest</h3>
<form action="<%=basePath%>cookies1" method="post">
	名字；<input type = "text" name=username1><br><br>
	密码；<input type = "password" name=password2><br><br>
	<input type = "submit" value="登录">
</form>
</body>
<script type="text/javascript">
</script>
</html> 