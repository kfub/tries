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
 <script src="<%=basePath %>js/jquery-1.8.3.min.js"></script>

<body>
<a href="<%=basePath %>logout">安全退出</a>
<div id=likes >
	<input type="text" id="like" style=" height: 22px;width: 232px;"/>
	<input style="  position: relative;  left: -5px;top: 3px;" type = "button" value="搜索" id=find />
</div>
	<table border="1">
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td><button class="batchDelete" type="button" style="position:relative;left:21px; ">批量删除</button></td>
	</tr>
		<tr>
			<td><button style="width:70px" type="button" class="allcheck" id="all" >全选</button></td>
			<td>姓名</td>
			<td>密码</td>
			<td>操作<button type="button" class=add style="position:relative;left:16px; "  >添加</button></td>
		</tr>
		<tr>
			
		</tr>
		<c:forEach items="${user}" var="list">
			<tr id="list">
				<td><input type="checkbox" value="${list.userid }" class="checks"></td>
				<td>${list.username }</td>
				<td>${list.password}</td>
				<td>
					<button type="button" class=delete id="deletes" value="${list.userid}">删除</button>
					<button type="button" class=update id="update" value="${list.userid}">修改</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
<script>
	/*通过userid 删除一条数据   */
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
	
	/* 修改 先获取要修改的值在去修改页面进行修改*/
	
	$(".update").click(function(){
		var id = $(this).val();  
		 if(confirm("确认修改id为【"+id+"】的用户吗？")){
			window.location.href="<%=basePath%>update?id="+id;
             }   
	});
	/*添加一条shu'ju*/
	$(".add").click(function(){
		window.location.href="<%=basePath%>add";
		
	});
	/*批量删除*/
	$(".batchDelete").click(function(){
	var vals = [];
	$("input[type='checkbox']:checked").each(function(index,item){
		vals.push($(this).val());
	})
	 if(confirm("确认批量删除id为【"+vals+"】的用户吗？")){
	$.ajax({
		url:"<%=basePath%>batchDel",
		type:"post",
		data:{"vals":vals},
		success:function(){
			window.location.reload()
		}
		
	});
	 }
	});
	/*全选*/
	$(".allcheck").click(function(){

		$("#list :checkbox").each(function () {  
	        if($(this).prop("checked")==true){
	        	$("#list :checkbox,#all").prop("checked", false);
			   var v = $("#all").text("全选");
			}else{
			   $("#list :checkbox,#all").prop("checked", true);
	        	var v = $("#all").text("全不选");
			}
	    });
			
	});
	
	/*搜索*/
	$("#find").click(function(){
		var str = $("#likes input:first-child").val();
		alert(str)
        $.ajax({
        		url:"<%=basePath%>findlike",
        		type:"post",
        		data:{"str":str},
        		success:function(){
        			window.location.reload()
        		}
        	
        	
        });
		
	});
</script>
</html>