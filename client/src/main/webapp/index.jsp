<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
<script src="${APP_PATH}/jquery/jquery-3.1.1.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
			<form id= "updatefile" action="http://192.168.1.123:8080/client/download/file/1?" method="post"> 
					<table>
						<tr><td>fileId</td><td><input type="text" name="fileId" value="1" id="fileId"/></td></tr>
						<tr><td>account</td><td><input type="text"  name="account" value="2" id="fileId"/>  </td></tr>
						<tr><td>signature</td><td><input type="text"  name="signature" /></td></tr>	
						<tr><td colspan='2'><input type="submit"  value="修改文件"  id ="sub" /></td></tr>
					</table>
					</form> 
					
					
					
<!-- 	<script type="text/javascript">
		$("#sub").click(function(){
			var fileId = $("#fileId").val();
			alert($("#updatefile").serialize());
				 $.ajax({
					url:"${APP_PATH}/file/"+fileId,
					type:"POST",	
					data:$("#updatefile").serialize()+"&_method=PUT",
					success:function(result){
						alert(result.msg);
	</script> -->	
</body>
</html>