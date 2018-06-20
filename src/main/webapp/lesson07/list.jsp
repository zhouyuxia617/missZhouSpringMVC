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
			
			console.log(xmlhttp.readyState);  //0：请求未初始化
			
			//不需要自己调的函数叫做：回调函数（当请求发送后，收到结果后会自动调用该方法）
			xmlhttp.onreadystatechange = function(){
				//日志打印
				console.log(xmlhttp.readyState); //1：服务器连接已建立,2：请求已接收,3：请求处理中,4：请求已完成，且响应已就绪
				
				/**
				 为什么要判断这个if语句的原因：
				 	存有XMLHttpRequest的状态，readyState从0到4发生变化：
				 	  0：请求未初始化（没有调用send方法）
				 	  1：服务器连接已建立（cocket已连接）
				 	  2：请求已接收（获取到了参数，没有执行action方法）
				 	  3：请求处理中（已经在执行action方法，未执行完）
				 	  4：请求已完成，且响应已就绪（已经响应，并且能获取到最终的数据）
				    status响应的状态：
				      200：成功
				      404：找不到页面
				      500：异常
				*/
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			
					//返回的是字符串的json
					var resultJson = xmlhttp.responseText;
		
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
						table.removeChild(allDataTr[0]);
					}

					//根据json的函数追加多个tr
					for(var i=0; i<resultObj.length; i++){
						var obj = resultObj[i];
					
						var td = document.createElement("td");
						td.innerText = obj.username;
						var td2 = document.createElement("td");
						td2.innerText = obj.lostedmoney;
						var tr = document.createElement("tr");
					
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
	
			//open方法表示产生一个请求大的关系（get提交）
	//		xmlhttp.open("GET","${pageContext.request.contextPath}/queryFood?username="+username,true);
	//		xmlhttp.send();
			
			/**
				默认是异步true。
				一个ajax线程是否执行完成，可以通过回调函数xmlhttp.onreadystatechange是否执行完成来判断
			 * true异步：多个线程同时执行，无法判断谁先执行。
			 * false同步：一次只允许一个线程执行 ，页面会假死
			 */
			//post提交,一个&号代表一个值
			xmlhttp.open("POST","${pageContext.request.contextPath}/queryFood",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
			xmlhttp.send("username="+username+"&a=1");
			
			//为true，这个有可能先执行，为false这个必须是后执行
		//	console.log("你好"); //渲染页面的逻辑代码建议放在回调函数中，放在这里就说明必须要用同步，使用ajax尽量使用true异步模式，防假死
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