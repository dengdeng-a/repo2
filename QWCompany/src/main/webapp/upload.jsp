<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	<form id="uploadForm" enctype="multipart/form-data"> 
		   <p>上传文件：<input type="file" name="htmltext" /></p> 
		   <input type="button" onclick="upload()" value="上传"  /> 
	</form>
 <script type="text/javascript">
function upload() { 
   var formData = new FormData($("#uploadForm")[0]); 
   alert(formData);
   $.ajax({ 
     url:"${APP_PATH}/doupload", 
     type:"POST", 
     data: formData, 
     async: false, 
     cache: false, 
     contentType: false, 
     processData: false, 
     success: function(result) {
    	 alert(result.msg);
     }, 
     error: function(data) {   
     } 
   }); 
}
</script>
</body>
</html>