<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 引入这个包 -->    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- 用于国际化 -->
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getScheme()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>国际化</title>
	
	</head>
	
	<!-- 前端验证 -->
	<script type="text/javascript">
		function checkSubmit(){
			//手工提交
			document.forms[0].submit();
		}
	</script>
	
	<body>
		<!-- 这里的locale=是和mvc-servlet.xml中配置的那个value=locale必须相同的名字 -->
		<a href=${pageContext.request.contextPath}"/mid?locale=zh_CN">中文</a><br/>
		<a href=${pageContext.request.contextPath}"/mid?locale=en_US">英文</a><br/>
		
		<form action="<%=path %>/reg" method="post">
			<s:message code="userName"></s:message>：<input type="text" name="userName"/>
			<!-- 把字体变成红色 -->
			<font color="red">
			<!-- 在表格旁提示字体 -->
			<form:errors path="userInfo.userName"></form:errors>
			</font><br/>
			
			<s:message code="password"></s:message>：<input type="password" name="password"/>
			<font color="red"><form:errors path="userInfo.password"></form:errors></font>
			<br/>
			
			<s:message code="repassword"></s:message>：<input type="password" name="repassword"/>
			<font color="red"><form:errors path="userInfo.repassword"></form:errors></font>
			<br/>
			
			<s:message code="email"></s:message>：<input type="text" name="email"/>
			<font color="red"><form:errors path="userInfo.email"></form:errors></font>
			<br/>
			
			<s:message code="age"></s:message>：<input type="text" name="age"/>
			<font color="red"><form:errors path="userInfo.age"></form:errors></font>
			<br/>
			
			<s:message code="phone"></s:message>：<input type="text" name="phone"/>
			<font color="red"><form:errors path="userInfo.phone"></form:errors></font>
			<br/>
			<input type="button" onclick="checkSubmit()" value=<s:message code="register"></s:message> />
		</form><br/>
	</body>
</html>