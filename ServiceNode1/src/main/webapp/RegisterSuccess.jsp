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
</head>
<body>

    <div>
        <strong> welcome,${sessionScope.user.username}! 注册成功！</strong>
    </div>
      <form action="${APP_PATH}/user/checkLogin" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input id="username" name="username" type="text"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input id="password" name="password" type="password"></td>
            </tr>
            <tr >
                <td><input type="submit" value="登录"  ></td>
                <td><input type="button" value="注册" onclick="window.location.href='/user/regist'"> </td>
            </tr>

        </table>
    </form>
</body>
</html>