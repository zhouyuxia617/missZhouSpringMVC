<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<!--
	 js中写完可以不使用分号，它会直接根据换行来判断。
	 js中大小写区分是根据所适用的浏览器来判断的，ie浏览器不区分大小写，
	 -->
	<script type="text/javascript">
		function query(){
			//无刷新调用 http://localhost:8080/missZhouSpringMVC/queryFood 获取到数据，数据通过dom方式添加到table中
			//ajax(异步的ajax)+json
			var xmlhttp = null;
			
			//兼容所有的浏览器来创建这个对象
			if(window.XMLHttpRequest){ //支持code for IE7,Firefox,Chrome,Opera,Safari
				xmlhttp = new XMLHttpRequest();
			}else{ //支持code for IE6,IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			//不需要自己调的函数叫做：回调函数（当请求发送后，收到结果后会自动调用该方法）
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			//		document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
				
					//返回的是字符串的json
					var resultJson = xmlhttp.responseText;
					//调用
			//		alert(resultJson);
					
					//转换为js对象
					var resultObj = JSON.parse(resultJson);
					//调用
					alert(resultObj.length);
					
					//获取表格的对象
					var table = document.getElementById("myTable");
					
					
					//将所有名字为dataTr的tr全部删除
					var allDataTr = document.getElementsByName("dataTr");
					var length = allDataTr.length;
					for(var i=0; i<=length; i++){
						//因为数组是变化的，所以不写i，写0
						//document.removeElement(allDataTr[0]);
						table.removeChild(allDataTr[0]);
					}

					//根据json的函数追加多个tr
					for(var i=0; i<resultObj.length; i++){
						var obj = resultObj[i];
					//	var trHtml = "<tr><td>"+obj.username+"</td><td>"+obj.lostedmoney+"</td></tr>";
						//追加到table中
					//	table.appendChild(trHtml); //不能直接追加
						
						var td = document.createElement("td");
						td.innerText = obj.username;
						var td2 = document.createElement("td");
						td2.innerText = obj.lostedmoney;
						var tr = document.createElement("tr");
					
					//	tr.name="dataTr";
						//设置一个名字好用作删除tr
						tr.setAttribute("name","dataTr");
						
						//追加
						tr.appendChild(td);
						tr.appendChild(td2);
						table.appendChild(tr);
					}
				}
			}
			
			var username = document.getElementsByName("username")[0].value;
			
			//调用匿名函数(这个函数不需要自己去调)
		//	xmlhttp.onreadystatechange();
			//open方法表示产生一个请求大的关系（get提交）
			xmlhttp.open("GET","${pageContext.request.contextPath}/queryFood?username="+username,true);
			xmlhttp.send();
		}
	</script>

</head>
<body>
	<input type="button" name="foodName"/>
	<input type="button" value="查询" onclick="query()">
	
	<table id="myTable">
		<tr>
			<th>用户名</th>
			<th>余额</th>
		</tr>
	</table>
</body>
</html>