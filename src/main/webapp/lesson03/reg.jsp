<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 引入这个包 -->    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getScheme()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>My JSP 'login.jsp' starting page</title>
	
		<!-- <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		 -->
	</head>
	
	<!-- 前端验证 -->
	<script type="text/javascript">
		function checkSubmit(){
			//校验不通过就不提交
		/*  	var userName = document.getElementsByName("userName")[0].value;
			var password = document.getElementsByPassword("password")[1].value;
			var repassword = document.getElementsByRepPassowrd("repassword")[2].value;
			
			//用户名为空不执行
			if(userName == null || userName == ""){
				alert("用户名不能为空！");
				return ;
			}
			
			//判断密码不能为空
			if(password == null || password == ""){
				alert("密码不能为空！");
				return ;
			}
			if(repassword == null || repassword == ""){
				alert("请再次确认密码！");
				return ;
			}
			
			//两次输入的密码不相同
			if(password != repassword){
				alert("两次输入的密码不一致！");
				return ;
			}
			 */
			 
			//手工提交
			document.forms[0].submit();
		}
	</script>
	
	<body>
		<%-- <form action="<%=path %>/reg" method="post">
			用户名：<input type="text" name="userName"/><%-- ${userInfo.userName}--%》<br/>
			密码：<input type="password" name="password"/><br/>
			重复密码：<input type="password" name="repassword"/><br/>
			邮件：<input type="text" name="email"/><br/>
			年龄：<input type="text" name="age"/><br/>
			手机号码：<input type="text" name="phone"/><br/>
		<!-- 体重：<input type="text" name="weight"/><br/> -->
			<input type="button" onclick="checkSubmit()" value="注册"/>
			<!-- <input type="submit" value="提交"/>
			<input type="reset" value="重置"/> -->
		</form><br/> --%>
		
		
		<form action="<%=path %>/reg" method="post">
			用户名：<input type="text" name="userName"/>
			<!-- 把字体变成红色 -->
			<font color="red">
			<!-- 在表格旁提示字体 -->
			<form:errors path="userInfo.userName"></form:errors>
			</font><br/>
			密码：<input type="password" name="password"/>
			<font color="red"><form:errors path="userInfo.password"></form:errors></font>
			<br/>
			重复密码：<input type="password" name="repassword"/>
			<font color="red"><form:errors path="userInfo.repassword"></form:errors></font>
			<br/>
			邮件：<input type="text" name="email"/>
			<font color="red"><form:errors path="userInfo.email"></form:errors></font>
			<br/>
			年龄：<input type="text" name="age"/>
			<font color="red"><form:errors path="userInfo.age"></form:errors></font>
			<br/>
			手机号码：<input type="text" name="phone"/>
			<font color="red"><form:errors path="userInfo.phone"></form:errors></font>
			<br/>
			<input type="button" onclick="checkSubmit()" value="注册"/>
		</form><br/>
	</body>
</html>