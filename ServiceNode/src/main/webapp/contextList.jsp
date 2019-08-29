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
			p{
				width:300px ;
	   		    height:20px;
			}
			
			.col-md-12{
				margin-bottom:50px
			} 
	</style>

<title>Insert title here</title>
</head>
<body>
		<div height="10%">
			<div class="row">
				<div class="col-md-2 col-md-offset-1">
			  	<h2 id="h2"></h2>
			  </div>
			</div>
		</div>
		<br><br>
		
		
		<div height="30%" id="big_div">	
			  <div class="row" >
			  <div class="col-md-12" >
				  	<span>
					  	<div class="col-md-2 col-md-offset-1" >
						  	<img src="" title="蓝天白云天马" class="img-rounded"/>
						  	<span>显示文件标题</span>	
					 	</div>
				  		<div class="col-md-2 col-md-offset-1" >
						  	<img src="" title="蓝天白云天马" class="img-rounded"/>
						  	<span>显示文件标题</span>	
					 	</div>
					 	<div class="col-md-2 col-md-offset-1">
						  	<img src="" title="蓝天白云天马" class="img-rounded"/>
						  	<span>显示文件标题</span>	
					 	</div>
				  	</span>
			  </div>
			  <hr style="height:10px;border:none;border-top:10px groove skyblue;" /> 
			</div>
		</div>
	<!--  显示分页信息  -->
		<div class="row">
			<div class="col-md-6 col-md-offset-6" id="page_nav_area">
				
			</div>
		</div>
	

	<script type="text/javascript">
		$(function() {
			to_page(1);
		});
		function to_page(pn){
			var tid=${param.tid};
			//alert(tid);
			$.ajax({
				url:"${APP_PATH}/oneToManyContext?pn="+pn,
				data:{tid:tid},
				type:"GET",
				success:function(result){
					  //1.解析并显示分类类型名字
					$("#h2").html="";
					var res = result.extend.pageInfo.list;
					$("#h2").html(res[1].tname);
					//解析显示文件内容简介
					build_bigDiv(result);
					//解析显示分页条
					build_page_nav(result); 
				}
			});
		}
	
		//解析显示文件信息
		function build_bigDiv(result){
			var html = "";
			$("#big_div").html="";
			var res = result.extend.pageInfo.list;
			for( var i=0;i<res.length;i+=3){
				html += "<div class='\row\'>";
				html += "<div class='\col-md-12\' id='row_div'>";
				html += "<span>";
				html += "<div class='\col-md-2 col-md-offset-1\'>";
				html +="<img class='\img-rounded\' src="+res[i].csrc+">";
				html +="<span>"+res[i].ctitle+"</span>";
				html += "</div>";
				if(i+1<res.length){
					html += "<div class='\col-md-2 col-md-offset-1\'>";
					html +="<img class='\img-rounded\' src="+res[i+1].csrc+">";
					html +="<span>"+res[i].ctitle+"</span>";
					html += "</div>";
				}
				if(i+2<res.length){
					html += "<div class='\col-md-2 col-md-offset-1\'>";
					html +="<img class='\img-rounded\' src="+res[i+2].csrc+">";
					html +="<span>"+res[i].ctitle+"</span>";
					html += "</div>";
				}
				html += "</span>";
				html += "</div>";
				html += "</div>";
				//$("#br").append($("</br>"));
				$("#big_div").html(html);

			} 	
		}
		//解析显示分页信息
		function build_page_nav(result){
			//$("#page_nav_area").empty();
			var html = "";
			html += "<nav aria-label='\Page navigation\'>";
			html += "<ul class='\pager\'>";
			if(result.extend.pageInfo.hasPreviousPage==false){
				html += "<li class='\disabled\'><a aria-label='\Previous\' href='javascript:void(0);'>";
				html += "<span aria-hidden='\true\'>"+"&laquo;"+"</span>";
				html += "</span></li>";
			}else{
				html += "<li class='\active\'><a aria-label='\Previous\' href='javascript:void(0);' onclick="+toPage(result.extend.pageInfo.pageNum-1);+"</a>";
				html += "<span aria-hidden='\true\'>"+"&laquo;"+"</span>";
				html += "</span></li>";
			}
			
			for(var i=1;i<=result.extend.pageInfo.navigatepageNums;i++){
				html += "<li><a href='javascript:void(0);' onclick="+toPage(i);+"</a></li>";
			}
			
			html += "";
			html += "";
			html += "";
			html += "";
			html += "";
			html += "";
			
			$("#page_nav_area").html(html);

		}
	
	
	
	 /* $(function(){
		var tid=${param.tid};
		alert(tid);
		$.ajax({
			url:"${APP_PATH}/oneToManyContext?tid="+tid,
			type:"GET",
			success:function(result){
				build_h3(result);
				 //1.解析并显示新闻数据
				build_news_table(result);
				//解析显示分页信息
				build_page_info(result);
				//解析显示分页条
				build_page_nav(result);  
			}
		});
	});  */
	
	</script>
</body>
</html>