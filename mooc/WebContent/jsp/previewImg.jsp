<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>

<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
	
	
	<script type="text/javascript">
		$(function(){
			$(".thumbs a").click(function(){
				var largePath = $(this).attr("href");
				var largeAlt = $(this).attr("title");
				$("#largeImg").attr({
					src:largePath,
					alt:largeAlt
				});
				return false;
			});		
			
			$("#myfile").change(function(){
				var src = $("#myfile").val();
				if(src.indexOf("\\")>0) {
				    filename=src.substring(src.lastIndexOf("\\")+1,src.length);
				}
				else{
				    filename=src;
				}
				$("#previewImg").attr("src","../images/" + filename);
			});
			
			var la = $("#large");
			la.hide();
			
			$("#previewImg").mousemove(function(e){
				la.css({
					top:e.pageY,
					left:e.pageX
				}).html("<img src = "+this.src +">").show();
			}).mouseout(function(){
				la.hide();
			});
		});
		
		
		
		
		/* //使用js实现文件上传图片的预览
		function showPreview(obj){
			var path = obj.value;
			//从路径中截取图片名[包括后缀名]
			var filename;
			if(path.indexOf("\\")>0) {
				    filename=path.substring(path.lastIndexOf("\\")+1,path.length);
			}
			else
			{
			    filename=path;
			}
			document.getElementById("previewImg").innerHTML=
				"<img src = ../images/" +filename+">";
		}
		 */
	
	</script>
	
</head>
<body>
	<!-- <form action="">
		 请选择图片：<input id="myfile" name="myfile" type="file" onchange="showPreview(this)"/>
		<div id="previewImg"></div>
	</form> -->
	
	<img id="previewImg" src="../images/27.jpg" width="80px" height="80px">
	<form action="">
		 请选择图片：<input id="myfile" name="myfile" type="file" />
	</form>
	
	<div id="large"></div>
	
	
<hr><br><br><br><br><br><br><br><br><br><br>
    <!-- 图片预览 -->
	<h2>图片预览</h2>
	<p><img id="largeImg" src="../images/11.jpg" alt="Large Image"/></p>
	<p class="thumbs">
		<a href="../images/12.jpg" title="Image12"><img src="../images/12.jpg"></a>
		<a href="../images/13.jpg" title="Image13"><img src="${APP_PATH}/images/13.jpg"></a>
		<a href="../images/2.jpg" title="Image2"><img src="${APP_PATH}/images/2.jpg"></a>
		<a href="../images/3.jpg" title="Image3"><img src="${APP_PATH}/images/3.jpg"></a>
		<a href="../images/7.jpg" title="Image7"><img src="${APP_PATH}/images/7.jpg"></a>
		
	</p>
</body>
</html>