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
<title>成功页面</title>
</head>
<body>
<h4>成功</h4>
<a href="<%=basePath %>logout">安全退出</a>
</body>
<script type="text/javascript">


</script>
</html> 