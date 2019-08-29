<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
<link href="https://vjs.zencdn.net/7.2.4/video-js.css" rel="stylesheet">

  <!-- If you'd like to support IE8 (for Video.js versions prior to v7) -->
  <script src="https://vjs.zencdn.net/ie8/ie8-version/videojs-ie8.min.js"></script>

<style>
        body{background-color: #191919}
        .m{ width: 1300px; height: 650px; margin-left: auto; margin-right: auto; }
    </style>
</head>
<body>

<div class="m">
        <video id="my-video" class="video-js" controls preload="auto" width="640" height="264" poster="MY_VIDEO_POSTER.jpg" data-setup="{}">
            <source src="../media/video.qsv" type="video/mp4">
            <p class="vjs-no-js">
              To view this video please enable JavaScript, and consider upgrading to a web browser that
              <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
            </p>
          </video>
          <script src="http://vjs.zencdn.net/5.18.4/video.min.js"></script>    
          <script type="text/javascript">
            var myPlayer = videojs('my-video');
            videojs("my-video").ready(function(){
                var myPlayer = this;
                myPlayer.play();
            });
        </script> 

    </div>
</body>
</html>

