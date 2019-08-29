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
    	h2{
    		text-align:center;
			margin-left:auto;
			margin-right:auto;
    	}
    </style>
 
</head>
<body>
   <h2>welcome${param.name}! 注册成功！<h2><br>
    <h2> 请登录</h2>
    <hr/>
    <form class="form-horizontal" action="" method="post" id="login_form">
	  <div class="form-group">
	    <label class="col-sm-4 control-label">用户名</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control"  name="uname" id="login_name" placeholder="name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-4 control-label">密码</label>
	    <div class="col-sm-4">
	      <input type="password" class="form-control" name="password" id="login_password" placeholder="login_password">
	    	<span class="help-block"></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-10">
	      <button type="button" class="btn btn-default" id="login_btn">登录</button>
	    </div>
	  </div>
	</form> 
	
	
	
<script type="text/javascript">
	
	  function validate_form(){
		  var name = $("#login_name").val();
		  var login_password = $("#login_password").val();
		  if(name==""){
			  validate_add_msg("#login_name","error","用户名不可以为空")
			  return false;
		  }
		  else{
			  validate_add_msg("#login_name","success","");
		  }
		  if(login_password==""){
			  validate_add_msg("#login_password","error","密码不可以为空")
			  return false;
		  }
		  else{
			  validate_add_msg("#login_password","success","");
		  }
		  return true;
	  }
	  
	  /*
	  *抽取出来的检验提示信息
	  */
	  function validate_add_msg(ele,status,msg){
		  $(ele).parent().removeClass("has-error has-success");
		  $(ele).next("span").text("");
		  if(status=="error"){
			  $(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
		  }
		  else if (status=="success") {
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
	  }
	  
	  
	 $("#login_btn").click(function(){
	    	//2.先对要提交的数据进行校验
			 if(!validate_form()){
				return false;
			}
			//4.判断之前的用户名校验是否成功，成功则进行保存操作，
			/* if($(this).attr("ajax_val")=="error"){
				return false;
			}  */
			 $.ajax({
				url:"${APP_PATH}/LoginCheck",
				type:"POST",	
				data:$("#login_form").serialize(),
				success:function(result){
					if(result.code==100){
						validate_add_msg("#login_password","succes","");
						$("#btn").attr("ajax_val","success");
						//成功跳转登陆页面	
						var name = $("#login_name").val();
						window.location.href = '${APP_PATH}/index.jsp?name='+name;
					}
					else {
						validate_add_msg("#login_password","error",result.extend.va_msg);
						$("#btn").attr("ajax_val","error");
					}
				}
			});
	 });
	</script>
</body>
</html>