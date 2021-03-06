<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./paging.css">
    <title>page</title>
</head>

<body>
    <div class="pagger-box pagger" id="box"></div>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="./paging.js"></script>
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
    </script>
</body>

</html>