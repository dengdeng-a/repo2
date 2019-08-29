<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script src="${APP_PATH}/static/jquery/jquery-3.1.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    
    
    <script type="text/javascript">
    $("#btn").click(function(){
	 	var name = $("#name").val();
	 	var password = $("#password").val();
		 $.ajax({
			url:"${APP_PATH}/register",
			type:"POST",	
			async: false,
            contentType: false,  
            processData: false,
            cache: false,
			data:name,password,
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
    
 </script>
</head>
<body>
    <h3 align="center">注册页面</h3>
    <hr/>
    <form class="form-horizontal" action="" method="post">
	  <div class="form-group">
	    <label class="col-sm-4 control-label">用户名</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control"  name="aname" id="name" placeholder="name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-4 control-label">密码</label>
	    <div class="col-sm-4">
	      <input type="password" class="form-control" name="password" id="password" placeholder="password">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-10">
	      <button type="button" class="btn btn-default" id="btn">注册</button>
	    </div>
	  </div>
	</form> 
</body>
</html>