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
	
		/**
		封装的发送ajax的函数
		   url：发送请求的地址
		         方法类型：get或者post
		         参数：通过键=值&键=值 方式
		         回调函数：当结果返回后，自动调用的函数，第一个参数就是返回的结果
		      function(responseText){
			 		具体的逻辑（页面渲染）
			  }
		}   
		         
		*/
		//把每次都用的到的东西封装起来
		function sendAjax(url,methodType,param,retnFunction){
			var xmlhttp = null;
			
			if(window.XMLHttpRequest){
				xmlhttp = new XMLHttpRequest();
			}else{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			//回调函数，当请求发送后，收到结果自动调用方法
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
					retnFunction(xmlhttp.responseText);
				}
			}
			
			if(methodType == "get" || methodType=="GET"){
				xmlhttp.open("GET",+url+"?"+param,true);
				xmlhttp.send();
			}else{
				xmlhttp.open("POST",url,true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
				xmlhttp.send(param);
			}
			
			
		}
		
		
		/**
		查询的方法 ,删除
		*/
		function query(){
			
			var username = document.getElementsByName("username")[0].value;
			sendAjax("${pageContext.request.contextPath}/queryFood","GET","username="+username,function(responseText){
	
				//返回的是字符串的json
				var resultJson = responseText;
	
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
					
					var td3 = document.createElement("td");
					
					//删除按钮
					var ib = document.createElement("button");
					ib.innerText = "X";
					td3.appendChild(ib);
					//修改按钮
					var ib2 = document.createElement("button");
					ib2.innerTest = "U";
					td3.appendChild(ib2);
				
					
					var tr = document.createElement("tr");
					//把当前行的json对象绑在当前按钮上
					ib.foodObj = obj;
					//把当前行的tr也绑在当前按钮上面
					ib.myLineTr = tr;
					//删除按钮的事件
					ib.addEventListener("click",function(){
						//获取当前按钮
						var eventSrc = event.srcElement;
						//删除当前行+发送ajax请求到后台，删除数据库
						table.removeChild(eventSrc.myLineTr);
						
						sendAjax("${pageContext.request.contextPath}/food/"+ib.foodObj.id,"POST","_method=delete",function(responseText){
							if(responseText == 1){
								alert("删除成功！");
							}else{
								alert("删除失败！");
							}
						});
					}); 
					
					
					//将当前的json对象绑定到当前按钮上
					ib2.foodObj = obj;
					//修改按钮的事件
					ib2.addEventListener("click",function(){
						//获取当前按钮
						var eventSrc = event.srcElement;
						document.getElementById('updateDiv').style.display='block';
						
						//把值赋到文本框上
						document.getElementsByName("umyUserName")[0].value=eventSrc.foodObj.username;
						document.getElementsByName("umyLostedMoney")[0].value=eventSrc.foodObj.lostedmoney;
						
						//可以从隐藏表单域上取值
						document.getElementsByName("umyId")[0].value=eventSrc.foodObj.id;
					});
					
					
					//设置一个名字好用作删除tr
					tr.setAttribute("name","dataTr");
					
					//追加
					tr.appendChild(td);
					tr.appendChild(td2);
					tr.appendChild(td3);
					table.appendChild(tr);
				}
			});
		}
			
		
		/**
		新增的方法
		*/
		function saveFood(){
			var myUserName = document.getElementsByName("myUserName")[0].value;
			var myLostedMoney = document.getElementsByName("myLostedMoney")[0].value;
		
			sendAjax("${pageContext.request.contextPath}/food","POST","foodName="+myUserName+"&lostedmoney="+myLostedMoney,function(responseText){
				if(responseText == 1){
					//关闭新增窗口
					document.getElementById('AddDiv').style.display='none';
					//查询新增后的数据
					query();
					alert("新增成功！");
				}else{
					alert("新增失败！");
				}
			});
		}
		
		
		/**
		修改的方法
		*/
		function updateFood(){
			var myUserName = document.getElementsByName("umyUserName")[0].value;
			var myLostedMoney = document.getElementsByName("umyLostedMoney")[0].value;
		
			var myId = document.getElementsByName("umyId")[0].value;
			
			sendAjax("${pageContext.request.contextPath}/food/"+myId,"POST","_method=put&foodName="+myUserName+"&lostedmoney="+myLostedMoney,function(responseText){
				if(responseText == 1){
					//关闭修改窗口
					document.getElementById('updateDiv').style.display='none';
					//查询修改后的数据
					query();
					alert("修改成功！");
				}else{
					alert("修改失败！");
				}
			});
		}
		
	</script>

</head>
<body>
	<input type="button" name="foodName"/>
	<input type="button" value="查询" onclick="query()">&nbsp;&nbsp;
	<input type="button" value="新增" onclick="document.getElementById('addDiv').style.display='none';">
	
	<table id="myTable">
		<tr>
			<th>用户名</th>
			<th>余额</th>
			<th>操作</th>
		</tr>
	</table>
</body>


<!-- 新增      ， displey：none---隐藏新增的表格 -->
<div id="addDiv" style="display:none;position:absolute;letf:40%;top:40%;z-index=100;border:1px;solid:black;width:250px;height:150px">
	用户名；<input type="text" name="myUserName"><br/>
	余&nbsp;&nbsp;&nbsp;额：<input type="text" name="myLostedMoney"><br/>
	    <input type="button" value="保存" onclick="saveFood()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="button" value="关闭" onclick="document.getElementById('addDiv').style.display='none';">
</div>


<!-- 修改 -->
<div id="updateDiv" style="display:none;position:absolute;letf:40%;top:40%;z-index=100;border:1px;solid:black;width:250px;height:150px">
	<!-- 弄一个隐藏表单域 -->
	<input type="hidden" name="umyId">
	
	用户名；<input type="text" name="umyUserName"><br/>
	余&nbsp;&nbsp;&nbsp;额：<input type="text" name="umyLostedMoney"><br/>
	    <input type="button" value="修改" onclick="updateFood()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="button" value="关闭" onclick="document.getElementById('updateDiv').style.display='none';">
</div>

</html>