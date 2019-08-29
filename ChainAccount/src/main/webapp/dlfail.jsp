<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>员工列表</title>

	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>

	<!--引入Bootstrap  -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${APP_PATH}/static/jquery/jquery-3.1.1.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    
    <style>
		h2 {text-align:center;}  
	       
   </style>
	
    
    
</head>
<body>
<!-- enctype="multipart/form-data" -->
     <h2>管理员登录</h2>
	
	<form class="form-horizontal" action="dl" method="post">
	  <div class="form-group">
	    <label class="col-sm-4 control-label">name</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control"  name="aname" placeholder="name">
	    </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-4 control-label">password</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control"name="password" placeholder="password">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-4 col-sm-10">
	      <button type="submit" class="btn btn-default">login</button>
	    </div>
	  </div>
	</form> 

	
	
	
	
	
	
	
	
</body>
</html>