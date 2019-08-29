<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<!DOCTYPE>
<html lang="en">
<head>
	<title>桥王链-新闻中心</title>
	<meta charset="UTF-8">
	<meta name="description" content="Arcade - Architecture Template">
	<meta name="keywords" content="arcade, architecture, onepage, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->   
	<link href="img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<link rel="stylesheet" href="css/animate.css"/>
	<link rel="stylesheet" href="css/owl.carousel.css"/>
	<link rel="stylesheet" href="css/style.css"/>



<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>

	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	
	<!-- Header section start -->   
	<header class="header-area">
		<a href="home.html" class="logo-area">
			<img src="img/logo.png" alt="">
		</a>
		<div class="nav-switch">
			<i class="fa fa-bars"></i>
		</div>
		<!--<div class="phone-number">+675 334 567 223</div>-->
		<nav class="nav-menu">
			<ul>
				<li class="active"><a href="index.html">首页</a></li>
				<li><a href="about.html">关于我们</a></li>
				<li><a href="news.html">新闻中心</a></li>
				<li><a href="portfolio.html">产品业务</a></li>
				<li><a href="joinus.html">诚聘精英</a></li>
				<li><a href="contact.html">联系我们</a></li>
			</ul>
		</nav>
	</header>
	<!-- Header section end -->   

	

	<!-- Page header section start -->
	<section class="page-header-section set-bg" data-setbg="img/header-bg-3.jpg">
		<div class="container">
			<h1 class="header-title">News<span>.</span></h1>
		</div>
	</section>
	<!-- Page header section end -->

<!--菜单-->
	<div class="container-fluid bread padding-lg ">
		<div class=" text-muted">
			<div class="pull-left">
	<span class="fa fa-home"></span>
			<span>首页</span>
			<span>/</span>
			<span>新闻中心</span>
			
				</div>
			
			
		</div>
	</div>
	<!--面包屑菜单结束-->

	
	
	<!--主体开始-->
	
	<div class="container-fluid">
		<div class="news">
			<ul id="ul1">
			<!-- <li>
			  <div class="news-biaoti">区块链日报：瑞波利好频频，印度否认设立数字机构研究部门</div>
			  <div class="news-time"><span class="news-icon-new">new</span><span>2018-09-28</span><span class="fa fa-eye"></span><span>650</span></div>
			  <div class="news-zhengwen text-justify">据BusinessStandard消息，Ripple和几家初创公司于9月27日宣布成立了一个确保美国价值的互联网联盟，以联合起来游说加密货币立法者和监管机构，并且计划支付给华盛顿的支持者数字货币。随着国会和美国SEC等机构还对数字货币以及区块链技术所使用的法案尚待决定...(这里请程序员进行字数控制，控制在2行字。后面加省略效果。)</div>
				<p class="text-right"><a href="#">阅读全文</a></p>
			  </li>
			<li>
			  <div class="news-biaoti">区块链日报：瑞波利好频频，印度否认设立数字机构研究部门</div>
			  <div class="news-time"><span class="news-icon-new">new</span><span>2018-09-28</span><span class="fa fa-eye"></span><span>650</span></div>
			  <div class="news-zhengwen text-justify">据BusinessStandard消息，Ripple和几家初创公司于9月27日宣布成立了一个确保美国价值的互联网联盟，以联合起来游说加密货币立法者和监管机构，并且计划支付给华盛顿的支持者数字货币。随着国会和美国SEC等机构还对数字货币以及区块链技术所使用的法案尚待决定...(这里请程序员进行字数控制，控制在2行字。后面加省略效果。)</div>
				<p class="text-right"><a href="#">阅读全文</a></p>
			  </li> -->
			
			</ul>
		</div>
		
		
		
		
		<!--分页-->
		
		<div class="fy" id="fy">
			<!-- <a href="#" class="fy-disabled" aria-hidden="true">上一页</a>
				<a href="#" class="fy-active" aria-hidden="true">01</a>
				<a href="#">02</a>
				<a href="#">03</a>
				
				<a href="#">下一页</a> -->
		</div>
		
		<!--分页结束-->
	</div>

	
<!--主体结束-->

	




	<!-- Footer section start -->
	<footer class="footer-section">
		<!--<div class="footer-social">
			<div class="social-links">
				<a href="#"><i class="fa fa-pinterest"></i></a>
				<a href="#"><i class="fa fa-linkedin"></i></a>
				<a href="#"><i class="fa fa-instagram"></i></a>
				<a href="#"><i class="fa fa-facebook"></i></a>
				<a href="#"><i class="fa fa-twitter"></i></a>
			</div>
		</div>-->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<div class="col-md-8">
							<div class="footer-item">
								<ul>
									<li class="footer-title-font">吉林省桥王智能科技有限公司</li>
									<li>地址：硅谷大街与飞跃路交汇 吉大科技园 1307B</li>
									<li>电话：0431-66666666</li>
									<li>传真：0431-66666666</li>
									<li>Email：qiaowang@126.com</li>
								</ul>
							</div>
						</div>
						<div class="col-md-2">
							<div class="footer-item">
								<ul>
									<li class="footer-title-font">快速链接</li>
									<li><a href="index.html">首页</a></li>
									<li><a href="about.html">关于我们</a></li>
									<li><a href="news.html">新闻中心</a></li>
									<li><a href="#">产品业务</a></li>
									<li><a href="joinus.html">诚聘英才</a></li>
									<li><a href="contact.html">联系我们</a></li>
								</ul>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="footer-item">
								<ul>
									<li class="footer-title-font">关注公众号</li>
									<li><img src="img/qw.jpg" alt="" width="80%"></li>
								</ul>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>

		
     <div class="copyright">Copyright &copy; <script>document.write(new Date().getFullYear());</script> All rights reserved. 吉林省桥王智能科技有限公司 版权所有 吉ICP备10206706号-7 </div>
    

	</footer>
	<!-- Footer section end -->




	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.owl-filter.js"></script>
	<script src="js/magnific-popup.min.js"></script>
	<script src="js/circle-progress.min.js"></script>
	<script src="js/main.js"></script>
	
	
	
	
	
	
	
	<script type="text/javascript">
			var totalRecord;
			//1.页面加载完成以后，直接发送一个ajax请求，要到分页数据
			$(function() {
				to_page(1);
			});		   
			function to_page(pn){
				$.ajax({
					url:"${APP_PATH}/newsziye",
					data:"pn="+pn,
					type:"GET",
					success:function(result){
						//console.log(result);
						//1.解析并显示新闻数据
						build_news_table(result);
						//解析显示分页信息
						//build_page_info(result)
						//解析显示分页条
						build_page_nav(result);
					}
				});
			}
			
			/* <li id=li1>
			  <div class="news-biaoti">区块链日报：瑞波利好频频，印度否认设立数字机构研究部门</div>
			  <div class="news-time"><span class="news-icon-new">new</span><span>2018-09-28</span><span class="fa fa-eye"></span><span>650</span></div>
			  <div class="news-zhengwen text-justify">据BusinessStandard消息，Ripple和几家初创公司于9月27日宣布成立了一个确保美国价值的互联网联盟，以联合起来游说加密货币立法者和监管机构，并且计划支付给华盛顿的支持者数字货币。随着国会和美国SEC等机构还对数字货币以及区块链技术所使用的法案尚待决定...(这里请程序员进行字数控制，控制在2行字。后面加省略效果。)</div>
				<p class="text-right"><a href="#">阅读全文</a></p>
			  </li>
			<li> */
			function build_news_table(result){
			     //清空table表格#news_table tbody
				var table_html = "";
				$("#ul1").html("");
				var res = result.extend.pageInfo.list;
				//console.log(res);
				for( var i=0;i<res.length;i++){ 
					table_html += "<li>";
					 table_html += "<div class=\"news-biaoti\">"+res[i].title+"<div>";
					 var createtime = "";//
					 createtime = res[i].createtime;//
					if(createtime==null||createtime==""){
						table_html += "<div class=\"news-time\"><span class=\"news-icon-new\">new</span><span>"+createtime+"</span><div></br>";
					 }else{
						 //alert("aaaaa");
						 table_html += "<div class=\"news-time\"><span class=\"news-icon-new\">new</span><span>"+createtime+"</span><div>"; 
					 } 
					 var context1 = "";
					 if(res[i].context!=null){
						 context1 = res[i].context.substring(0,145)+"...";
					 }
					 table_html += "<div class=\"news-zhengwen text-justify\">"+context1+"<div>";
					 table_html += "<p class=\"text-right\"><a href='/QWCompany/news-info.jsp?id="+res[i].nid+"'>"+"阅读全文"+"</a></p>";
					 table_html += "</li>";
					$("#ul1").html(table_html);
					
				} 		
			}
			
			
			
			/* <!--分页-->
			<div class="fy">
				
			<a href="#" class="fy-disabled" aria-hidden="true">上一页</a>
			<a href="#" class="fy-active" aria-hidden="true">01</a>
			<a href="#">02</a>
			<a href="#">03</a>
			
			<a href="#">下一页</a>
				
			</div> */
			
			/*
			*解析显示分页条
			table_html += "<div class=\"news-biaoti\">"+res[i].title+"<div>";
			*/
			function build_page_nav(result){
				/* var fyinfo = "";
				$("#fy").html(""); 
				fyinfo += "<a href='javascript:void(0)' onclick='to_page(result.extend.pageInfo.pageNum-1);' class=\"fy-disabled\" aria-hidden=\"true\" >"+"上一页"+"</a>"+" ";
				$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
					if(result.extend.pageInfo.pageNum==item){
						alert(item);
						fyinfo += "<a href='javascript:void(0);' onclick='to_page(item);' class=\"fy-active\">"+item+"</a>"+" ";
					}
					else{
						fyinfo += "<a href='javascript:void(0);' onclick='to_page(item);'>"+item+"</a>"+" ";
					}
				});
				fyinfo += "<a href='javascript:void(0);' onclick='to_page(result.extend.pageInfo.pageNum+1);' class=\"fy-disabled\" aria-hidden=\"true\" >"+"下一页"+"</a>"+" ";
				$("#fy").html(fyinfo);  */
				
				 
				$("#fy").empty();
				//var tb=$("&nbsp");
				var prePageLi = $("<a></a>").text("上一页").attr("aria-hidden","true");
				prePageLi.innerHTML += " ";
				if(result.extend.pageInfo.hasPreviousPage==false){
					prePageLi.addClass("fy-disabled");
				}
				else{  
					prePageLi.click(function(){
						to_page(result.extend.pageInfo.pageNum-1);
					});
				}
					
				var nextPageLi = $("<a></a>").text("下一页");
				if(result.extend.pageInfo.hasNextPage==false){
					nextPageLi.addClass("fy-disabled");
				}else{
					nextPageLi.click(function(){
						to_page(result.extend.pageInfo.pageNum+1);
					});
				}

				prePageLi.appendTo("#fy");
				//$("#fy").innerHTML += " ";
				//tb.appendTo("#fy");
				$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
					
					var numLi =  $("<a></a>").append(item);
					if(result.extend.pageInfo.pageNum==item){
						numLi.addClass("fy-active").attr("aria-hidden","true");
					}
					numLi.click(function(){
						to_page(item);
					});
					numLi.appendTo("#fy");
					//tb.appendTo("#fy");
					//$("#fy").innerHTML += " ";
				});
				//tb.append(nextPageLi);
				nextPageLi.appendTo("#fy");
			}
		
			 
	</script>
</body>
</html>