<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻详细内容</title>

	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>

	<!--引入Bootstrap  -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/static/jquery/jquery-3.1.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="border-radius: 0px;">
		<h1 id="title" style="margin-left:44%; margin-top:78px;margin-bottom:0cm;"></h1>
		</div>
		<div style="text-indent: 2em; padding:80px;font-size:141%;line-height:36px">
			<span id="con"></span>
		</div>
	<script type="text/javascript">
	$(document).ready(function() {
		var id = GetQueryString("id");
		findbyid(id);

	})
	function findbyid(id){
		$.ajax({
			url:"${APP_PATH}/onenew/"+id,
			type:"GET",
			success:function(result){
				var data = result.extend.news
				console.log(result);
				$("#title").text(data.title);
				$("#con").text(data.context);
			}
		});
		
	}
	//获取地址栏参数
	function GetQueryString(name){
	
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	
	     var r = window.location.search.substr(1).match(reg);
	
	     if(r!=null)return  unescape(r[2]); return null;
	
	}
	</script>
		
		
</body>
</html>
