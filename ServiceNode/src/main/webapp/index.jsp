<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户注册页面</title>
    <%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
	
	<!--引入Bootstrap  -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/static/jquery/jquery-3.1.1/jquery-3.1.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


	<style type="text/css">
		 img{
			width:400px ;
   		    height:200px;
		} 
		span{
		font-size:17px;
		text-align:left;
		}
		a{
			width:300px ;
   		    height:20px;
		}
		
	</style>


</head>
<body>
		<div height="10%">
			<div class="row">
				<div class="col-md-2 col-md-offset-5">
			  	<h2>欢迎观看</h2>
			  </div>
			</div>
		</div>
		<div height="30%" id="type_count">
			<div class="row" id="row_div">
			  <div class="col-md-12 col-md-offset-1" id="tname_h3">
			  	<h3>
			  		<div class="col-md-2 col-md-offset-1" id="img_div">
					  	<a href="#">sfghghghghghgh </a>
				 	</div><br><br>
				  	<div class="col-md-2 col-md-offset-1" id="img_div">
					  	<img src="" title="蓝天白云天马" class="img-rounded">
					  	<span>显示文件标题</span>	
				 	</div>
			  		<div class="col-md-2 col-md-offset-1" id="img_div">
					  	<img src="" title="蓝天白云天马" class="img-rounded">
					  	<span>显示文件标题</span>	
				 	</div>
				 	<div class="col-md-2 col-md-offset-1" id="img_div">
					  	<img src="" title="蓝天白云天马" class="img-rounded">
					  	<span>显示文件标题</span>	
				 	</div>
			  	</h3>
			  </div>
			  <hr style="height:10px;border:none;border-top:10px groove skyblue;" />
			</div>
		</div>
		
		<script type="text/javascript">
			//页面加载完毕，要到分类信息
			$(function(){
				$.ajax({
					url:"${APP_PATH}/tnameInfo",
					type:"GET",
					success:function(result){
						var html = "";
						$("#tname_h3").html = "";
						var res = result.extend.type;
						console.log(res);
						for( var i=0;i<res.length;i++){
							 html += "<h3><a href='/ServiceNode/contextList.jsp?tid="+res[i].tid+"'>"+res[i].tname+"</h3>"
							 $("#tname_h3").html(html);
						 }
					}
				});
			});
	
	</script>
			
			

		

</body>
</html>