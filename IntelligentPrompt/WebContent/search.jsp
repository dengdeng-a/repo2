<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

	<style type="text/css">
		#mydiv{
			position: absolute;
			left: 50%;
			top: 50%;
			margin-left: -200px;
			margin-top: -50px;
		}
		.mouseOver{
			background: #708090;
			color: #FFFAFA;
		}
		.mouseOut{
			background: #FFFAFA;
			color: #000000;
		}
		
		
	</style>
	
	<script type="text/javascript">
	
		var xmlHttp;
		//获得用户输入内容关联信息的函数
		function getMoreContext(){
			//首先获得用户的输入
			var content = document.getElementById("keyword");
			if(content.value==""){
				clearContent();
				return;
			}
			//然后给服务器发送用户输入的内容，因为我们采用得是ajax一部发送数据
			//所以我们要使用一个对象，叫做XMLHttp对象
			xmlHttp = createXMLHttp();
			//要给服务器发送数据
			var url = "search?keyword="+escape(content.value);
			xmlHttp.open("GET",url,true);
			//xmlhttp绑定回调方法，这个回调方法会在xmlhttp状态改变的时候被调用
			//xmlhttp的状态0-4，我们只关心4这个状态，所以说的
			//当完成之后，在调用回调方法才有意义
			xmlHttp.onreadystatechange=callback;
			xmlHttp.send(null);
			
		}
	
		//获得xmlhttp对象
		function createXMLHttp(){
			var xmlHttp;
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlHttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			return xmlHttp;
		}
		
		//回调函数
		function callback(){
			//4代表完成
			//200代表服务器响应成功
			if(xmlHttp.readyState==4){
				if(xmlHttp.status==200){
					//交互成功，获得相应的数据，是文本格式
					var result = xmlHttp.responseText;
					//解析获得的数据
					var json = eval("("+result+")");
					//就可以动态的显示这些数据了，把这些数据展示到输入框下面
					//alert(json);
					setContent(json);					
				}
			}
		}
		
		//设置关联数据的展示动态
		function setContent(contents){
			clearContent();
			//首先获得关联数据的长度，以此来确定生成多少tr
			setLocation();
			var size = contents.length;
			//设置内容
			for(var i=0;i<size;i++){
				var nextNode = contents[i];//代表的是json格式数据的第i个元素
				var tr = document.createElement("tr");
				var td = document.createElement("td");
				td.setAttribute("border","0");
				td.setAttribute("bgcolor","#FFFAFA")
				td.onmouseover=function(){
					this.className='mouseOver';
				};
				td.onmouseout = function() {
					this.className='mouseOut';
				};
				td.onmousedown=function(){
				     document.getElementById("keyword").value = this.innerHTML;
				};
				var text = document.createTextNode(nextNode);
				td.appendChild(text);
				//alert("////"+td.innerHTML);
				tr.appendChild(td);
				document.getElementById("conten_table_body").appendChild(tr);
				
			}	
			
		}
		
		//清空之前的数据
		function clearContent() {
			var contentTableBody=document.getElementById("conten_table_body");
			var size = contentTableBody.childNodes.length;
			for(var i=size-1;i>=0;i--){
				contentTableBody.removeChild(contentTableBody.childNodes[i]);
			}
			document.getElementById("popDiv").style.border="none";
		}			
	   //当输入框失去焦点的时候，关联信息清空
		function keywordBlur(){
			clearContent();
		}
	   //设置显示关联信息的位置
		function setLocation(){
			//关联信息的显示位置要和输入框的一致
			var content = document.getElementById("keyword");
			var width = content.offsetWidth;   //输入框的宽度
			var left = content["offsetLeft"];//距离左边框的距离
			var top = content["offsetTop"]+content.offsetHeight; //距离顶部的距离
			//获得显示数据的div
			var popDiv=document.getElementById("popDiv");
			popDiv.style.border = "black 1px solid";
			popDiv.style.left = left+"px";
			popDiv.style.top = top+"px";
			popDiv.style.width = width+"px";
			document.getElementById("content_table").style.width=width+"px";
			
		}
</script>
	

</head>
<body>

	<div id="mydiv">
		<!-- 输入框 -->
		<input type="text" size="50" id="keyword" onkeyup="getMoreContext()" 
			onblur="keywordBlur()" onfocus="getMoreContext()"/>
		<input type="button" value="百度一下" width="50px"/>
		<!-- 内容展示区域 -->
		<div id="popDiv">
			<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
				<tbody id="conten_table_body">
					
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>