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
    
 
</head>
<body>
    <h3 align="center">注册页面</h3>
    <hr/>
    <form class="form-horizontal" action="" method="post" id="register_form">
	  <div class="form-group">
	    <label class="col-sm-4 control-label">用户名</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control"  name="uname" id="name_input" placeholder="name">
	      <span class="help-block"></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-4 control-label">密码</label>
	    <div class="col-sm-4">
	      <input type="password" class="form-control" name="password" id="password" placeholder="password">
	    	<span class="help-block"></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-10">
	      <button type="button" class="btn btn-default" id="btn">注册</button>
	    </div>
	  </div>
	</form> 
	
	
	
<script type="text/javascript">
	
	  function validate_form(){
		  var name = $("#name_input").val();
		  var password = $("#password").val();
		  if(name==""){	
			  validate_add_msg("#name_input","error","用户名不可以为空")
			  return false;
		  }
		  else{
			  validate_add_msg("#name_input","success","");
		  }
		  if(password==""){
			  validate_add_msg("#password","error","密码不可以为空")
			  return false;
		  }
		  else{
			  validate_add_msg("#password","success","");
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
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}
	  }
	  
	  
	  $("#name_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var name = this.value;
			$.ajax({
				url:"${APP_PATH}/checkuser",
				type:"GET",
				data:"uname="+name,
				success:function(result){
					if(result.code==100){
						validate_add_msg("#name_input","succes","");
						$("#btn").attr("ajax_val","success");
					}
					else {
						validate_add_msg("#name_input","error",result.extend.va_msg);
						$("#btn").attr("ajax_val","error");
					}
				}
			});
			
		});
	  
	 $("#btn").click(function(){
	    	//2.先对要提交的数据进行校验
			 if(!validate_form()){
				return false;
			}
			//4.判断之前的用户名校验是否成功，成功则进行保存操作，
			if($(this).attr("ajax_val")=="error"){
				return false;
			} 
			 $.ajax({
				url:"${APP_PATH}/register",
				type:"POST",	
				data:$("#register_form").serialize(),
				success:function(result){
					alert($("#name_input").val());
						//成功跳转登陆页面	
						var name = $("#name_input").val();
						window.location.href = '${APP_PATH}/RegisterSuccess.jsp?name='+name;
				}
			});
	 });
	</script>
</body>
</html>