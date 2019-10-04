<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print("=="+basePath+"====");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <script src="<%=basePath %>js/jquery-1.8.3.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>unauthorized.jsp</title>
</head>
<body>
<h4>unauthorized.jsp</h4>
<button type="button" class=delete id="deletes" value="50">删除</button>
</body>
<script type="text/javascript">

$(".delete").click(function(){
	var id = $(this).val();
	  if(confirm("确认删除id为【"+id+"】的用户吗？")){
         $.ajax({
        	url:"<%=basePath%>deletes?id="+id,
        	type:"post",
        	success:function(){
        		
        		window.location.reload()
        	}
         })
         }  
      
});
</script>
</html> 