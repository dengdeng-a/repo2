<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
     <title>page</title>
    
    <%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>


	<link rel="stylesheet" href="jquerypage/paging.css">
   

</head>

<body>
    <div class="pagger-box pagger" id="box"></div>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="${APP_PATH}/jquerypage/paging.js"></script>
    <script>
         var setTotalCount = 1000;
        $('#box').paging({
            initPageNo: 3, // 初始页码
            totalPages: 750, //总页数
            totalCount: '合计' + setTotalCount + '条数据', // 条目总数
            slideSpeed: 600, // 缓动速度。单位毫秒
            jump: true, //是否支持跳转
            callback: function(page) { // 回调函数
                console.log(page);
            }
        }) 
        
        
       /* $('#box').paging({
		    nowPage: 1, // 当前显示页
		    allPages: Math.ceil(data.count / 6), // 所有页（由传入的数据决定）
		    displayPage: 7,  // 分页列表显示的个数
		    callBack: function (now) { // 回调函数，用于数据获取
		      var currentPages = now * 6 < books.length ? 6 : books.length - (now - 1) * 6;
		      $oResultBox.html('');
		      for (var i = 0; i < currentPages; i++) {
		        var num = (now - 1) * 6 + i;
		        var create_dl = $('<dl></dl>');
		        var _html = '<dt>'+
		                      '<a href='+books[num].alt+' target="_blank"><img src='+books[num].image+'></a>'+
		                    '</dt>'+
		                    '<dd>'+
		                      '<a href='+books[num].alt+' target="_blank" class="title">'+books[num].title+'</a>'+
		                      '<p class="author">'+books[num].author+'</p>'+
		                      '<p class="publisher">'+books[num].publisher+'</p>'+
		                    '</dd>';
		 
		        create_dl.html(_html).addClass('bounceIn animated');
		        $oResultBox.append(create_dl);
      }
    }
  });  */
    </script>
</body>

</html>