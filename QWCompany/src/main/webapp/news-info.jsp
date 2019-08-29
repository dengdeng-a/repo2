<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
	
	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
	
	

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>
	
	<!-- Header section start -->   
	<header class="header-area">
		<a href="index.html" class="logo-area">
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
				<li><a href="product.html">产品业务</a></li>
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
		<div class="padding-50 margin-v-lg" style="background: #f6f5f5;">
		  <div class="news-info-biaoti text-center" id="title"></div>
		  <div class="news-time text-center padding-v-lg" >
		  	<span id="time"></span>
		  	<span></span>
		  	<span>文章来源：百度新闻</span>
		  	<span></span>
		  	<span class="fa fa-eye"></span>
		  	<span>650</span>
		  </div>
		  <div class="news-info-zhengwen text-justify" id="con"></div>
		  <div class="news-info-zhengwen text-justify" id="pic"></div>
		 <div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
		</div>
		</div>
		
		
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
		$(document).ready(function() {
			var id = GetQueryString("id");
			findbyid(id);
	
		})
		function findbyid(id){
			$.ajax({
				url:"${APP_PATH}/onenew/"+id,
				type:"GET",
				success:function(result){
					var data = result.extend.news
					console.log(result);
					$("#title").text(data.title);
					$("#time").text(data.createtime);
					$("#con").text(data.context);
					$("#pic").text(data.htmltext);
				}
			});
			
		}
		//获取地址栏参数
		function GetQueryString(name){
		
		     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		
		     var r = window.location.search.substr(1).match(reg);
		
		     if(r!=null)return  unescape(r[2]); return null;
		
		}
	</script>
</body>
</html>