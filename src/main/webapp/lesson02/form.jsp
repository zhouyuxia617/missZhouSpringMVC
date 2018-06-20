<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
</head>
<body>
	
	<%-- <form action="${pageContext.request.contextPath}/user3" method="post"> --%>
	<form action="${pageContext.request.contextPath}/user3/12" method="post">
		<input type='hidden' name="_method" value="put" <!-- value="delete" -->>
		姓名：<input type="text" name="name"/>
		    <input type="submit" value="提交"/>
	</form>
	
</body>
</html>