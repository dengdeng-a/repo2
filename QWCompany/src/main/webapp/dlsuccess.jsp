<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新闻列表</title>

	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>

	<!--引入Bootstrap  -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/static/jquery/jquery-3.1.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


		<style type="text/css">
			.n{
			width:80px;
			white-space:nowrap;
			text-overflow:ellipsis;
			overflow:hidden;
			}
		</style>


		
</head>
<body>
	<!-- 新闻修改的模态框 -->
<div class="modal fade" id="newsUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">新闻修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">title</label>
		    <div class="col-sm-10">
		      <input type="text" name="title" class="form-control" id="title_update_input">
		      <span class="help-block"></span>
		    </div>
		  </div>
		 <div class="form-group">
		    <label class="col-sm-2 control-label">context</label>
		    <div class="col-sm-10">
		      <textarea cols="60" rows="10" name="context" id="context_update_input"></textarea><br>
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">createtime</label>
		    <div class="col-sm-10">
		      <input type="text" name="createtime" class="form-control" id="createtime_update_input">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">sources</label>
		    <div class="col-sm-10">
		      <input type="text" name="sources" class="form-control" id="from_update_input">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <!-- <div class="form-group">
		    <label class="col-sm-2 control-label">图片</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="htmltext_update_input" >
		      <input type="file" name="htmltext" id="picture_update_input" accept="image/*" style="width:200px" > 
		      <span class="help-block"></span>
		    </div>
		  </div> -->
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="news_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>

	<!-- 新闻添加模态框     emp_add_modal-->
	<div class="modal fade" id="news_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">添加</h4>
	      </div>
	      <div class="modal-body">
	      <!--enctype="multipart/form-data"  -->
	        <form class="form-horizontal">
			  <div class="form-group">
			    <label class="col-sm-2 control-label">标题</label>
			    <div class="col-sm-10">
			      <input type="text" name="title" class="form-control" id="title_add_input" >
			       <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label" >内容</label>
			    <div class="col-sm-10">
			    	<textarea cols="60" rows="10" name="context" id="content_add_input"></textarea><br>
			      <!-- <input type="text" name="context" class="form-control" id="email_add_input"> -->
			      <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label class="col-sm-2 control-label">时间</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
					  <input type="text" name="createtime" id="time_add_input"> 
					</label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label class="col-sm-2 control-label">来源</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
					  <input type="text" name="sources" id="from_add_input"> 
					</label>
			    </div>
			  </div>
			   <div class="form-group">
			    <label class="col-sm-2 control-label">图片</label>
			    <div class="col-sm-10">
			      <label class="radio-inline">
					  <input type="file" name="htmltext" id="picture_add_input" accept="image/*" style="width:200px" > 
					</label>
			    </div>
			  </div>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" id="news_save_btn">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>




	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>新闻信息</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-10">
				<button class="btn btn-success" id="news_add_modal_btn">内容新增</button>
				
				<!--<button class="btn btn-danger">删除</button>-->
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row text-overflow">
			<div class="col-md-14 text-overflow">
				<table class="table table-hover text-overflow" id="news_table">
					<thead>
						<tr>
							<th>#</th>
							<th>标题</th>
							<th>内容</th>
							<th>时间</th>
							<th>图片</th>
							<th>来源</th>
							<th>操作</th>
						</tr>
					</thead>	
					<tbody>
						<tr>
							<th>#</th>
							<th>title</th>
							<th>content</th>
							<th>creatTime</th>
							<th>htmlText</th>
							<th>sources</th>
							<th>操作</th>
						</tr>
					</tbody>			
				</table>
			</div>
		</div>
			<!--显示分页信息  -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info_area">
				
			</div>
			
			<!-- 分页条信息 -->
			<div class="col-md-6 col-md-offset-8" id="page_nav_area">
				
			</div>
		</div>
		
	</div>
	
	
	<script type="text/javascript">
		var totalRecord;
		//1.页面加载完成以后，直接发送一个ajax请求，要到分页数据
		$(function() {
			to_page(1);
		});
		   
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/news",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//console.log(result);
					//1.解析并显示新闻数据
					build_news_table(result);
					//解析显示分页信息
					build_page_info(result);
					//解析显示分页条
					build_page_nav(result);
				}
			});
		}
		
		
		
		//解析显示新闻表格
		function build_news_table(result){
		     //清空table表格#news_table tbody
			var table_html = "";
			$("#news_table tbody").html("");
			var res = result.extend.pageInfo.list;
			console.log(res);
			for( var i=0;i<res.length;i++){
				 table_html += "<tr>";
				 table_html += "<th>"+res[i].nid+"</th>";
				 var newsId=res[i].nid;
				 table_html += "<th>"+res[i].title+"</th>";
				 var context1 = "";
				 if(res[i].context!=null){
					 context1 = res[i].context.substring(0,10)+"...";
				 }
				  
				//table_html += "<th>"+res[i].context+"</th>";
				 table_html += "<th><a href='/QWCompany/context.jsp?id="+res[i].nid+"'>"+context1+"</a></th>";
				 table_html += "<th>"+res[i].createtime+"</th>";
				 table_html += "<th>"+res[i].htmltext+"</th>";
				 table_html += "<th>"+res[i].sources+"</th>";
				 table_html += "<th>";
			     table_html += "<button class=\"btn btn-primary btn-sm edit_btn\"  edit-id="+newsId+" ><span class=\"glyphicon glyphicon-pencil\">编辑</span></button>";
				 table_html += " ";
				 table_html += "<button class=\"btn btn-danger btn-sm delete_btn\"  del-id="+newsId+"><span class=\"glyphicon glyphicon-trash\">删除</span></button>";
				 table_html += "</th>"; 
				 table_html += "</tr>";				  
				$("#news_table tbody").html(table_html);
				
			} 
			
					
		}
		/*
		*解析显示分页信息
		*/
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，总"+result.extend.pageInfo.pages+"页，总"+result.extend.pageInfo.total+"记录数");
			totalRecord = result.extend.pageInfo.pages;
			currentPage=result.extend.pageInfo.pageNum;
		}
		
		/*
		*解析显示分页条
		*/
		function build_page_nav(result){
			$("#page_nav_area").empty();
			
			//#page_nav_area
			var ul = $("<ul></ul>").addClass("pagination");

			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageLi.addClass("disabled")
				prePageLi.addClass("disabled");
			}
			else{
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum-1);
				});
			}
					
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum+1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}

			ul.append(firstPageLi).append(prePageLi);
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum==item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		
		
		
		
		/*
		* 点击内容新增按钮弹出模态框
		*/
		$("#news_add_modal_btn").click(function(){
			/*  //清除表单数据（数据和样式）
			reset_form("#news_add_modal form");  */
			$("#news_add_modal form")[0].reset();
			//弹出模态框
			$("#news_add_modal").modal({
				backdrop:"static"
			});
		});
		
		
		
		
		//校验表单数据（title和内容是否为空）
		function validate_add_form(){
			//1.检验title
			var title = $("#title_add_input").val();
			if(title==null){
				//alert("j1nknmknj1111111111111");
				$("#title_add_input").next("span").text("标题不能为空");
				//validate_add_msg("#title_add_input","error","标题不能为空");
				return false;
			}
			else {
				$("#title_add_input").next("span").text("");
				//validate_add_msg("#title_add_input","success","");
			}
			
			//2.校验content
			var content = $("#content_add_input").val();
			if(content==null){
				//alert("用户名是2-5位中文或者6-16位英文和数字的组合");
				$("#context_add_input").next("span").text("内容不能为空");
				//validate_add_msg("#title_add_input","error","标题不能为空");
				return false;
			}
			else {
				$("#context_add_input").next("span").text("");
				//validate_add_msg("#title_add_input","success","");
			}
			return true;
		}
		
		
		
		$("#news_save_btn").click(function(){
			//1.模态框中填写的表单数据交给服务器进行保存
			//2.先对要提交的数据进行校验
			 if(!validate_add_form()){
				return false;
			} 
			//3.发送ajax请求新闻保存
		 	var formdata = new FormData($('#news_add_modal form')[0]); 
			 $.ajax({
				url:"${APP_PATH}/new",
				type:"POST",	
				async: false,
                contentType: false,  
                processData: false,
                cache: false,
				data:formdata,
				success:function(result){
					//if(result.code ==100){
						 //1.保存成功
						//2.关闭模态框
						$("#news_add_modal").modal('hide');					 
						//3.来到最后一夜显示
						//发送ajax请求，显示最后一夜即可
						to_page(totalRecord);			
					}
			});
		});
		
		
		
		//1、我们是按钮创建之前就绑定了click，所以绑定不上。
		//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
		//jquery新版没有live，使用on进行替代
		$(document).on("click",".edit_btn",function(){
			//alert("edit");
			//2、查出新闻信息，显示新闻信息
			getEmp($(this).attr("edit-id"));			
			//3、把新闻的id传递给模态框的更新按钮
			$("#news_update_btn").attr("edit-id",$(this).attr("edit-id"));
			$("#newsUpdateModal").modal({
				backdrop:"static"
			});
		});
		
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/onenew/"+id,
				type:"GET",
				success:function(result){
					//console.log(result);
					 var empData = result.extend.news; 
					$("#title_update_input").val(empData.title);
					$("#context_update_input").val(empData.context);
					$("#createtime_update_input").val(empData.createtime);
					$("#htmltext_update_input").val(empData.htmltext); 
					$("#from_update_input").val(empData.sources);
				}
			});
		}
		
		
		$("#news_update_btn").click(function(){
			alert($("#picture_update_input").val());
			 if($("#picture_update_input").val()!=null){
				 var formdata = new FormData($('#news_add_modal form')[0]);  
				// alert(formdata);
				 $.ajax({
						url:"${APP_PATH}/updatenews/"+$(this).attr("edit-id"),
						type:"POST",
						data:formdata+"&_method=PUT",
						success:function(result){
							//alert(result.msg);
							//1、关闭对话框
							$("#newsUpdateModal").modal("hide");
							//2、回到本页面
							to_page(currentPage);
						}
					});
			} 
			
		});
		
		/* 
		$("#news_update_btn").click(function(){
			$.ajax({
				url:"${APP_PATH}/updatenews/"+$(this).attr("edit-id"),
				type:"POST",
				data:$("#newsUpdateModal form").serialize()+"&_method=PUT",
				success:function(result){
					//alert(result.msg);
					//1、关闭对话框
					$("#newsUpdateModal").modal("hide");
					//2、回到本页面
					to_page(currentPage);
				}
			});
		}); */
		
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//1、弹出是否确认删除对话框
			var empName = $(this).parents("tr").find("th:eq(1)").text();
			var id = $(this).attr("del-id");
			if(confirm("确认删除【"+empName+"】吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/delnews",
					data:{
						id:id,
					},
					type:"POST",
					success:function(result){
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				});
			}
		});
		
		
	</script>		
</body>
</html>
