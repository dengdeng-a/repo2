<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <!-- enctype 默认是 application/x-www-form-urlencoded -->
     <form action="FileUpLoad" enctype="multipart/form-data" method="post" >
        
                 普通表单：<input type="text" name="usename"> <br/>
               上传文件1：<input type="file" name="file1"><br/>
                      <input type="submit" value="提交"/>
     
     </form>  
</body>
</html>