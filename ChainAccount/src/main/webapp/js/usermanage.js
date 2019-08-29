/**
 * 
 */

$(document).ready(function (){
	//失去焦点blur
	/*
	 * 用户登录名验证
	 */
	$("#c_usersinfor_telphone").blur(function(){
	  if($("#c_usersinfor_telphone").val()!=""){
			//var uname=$("#u_name").val();
			$("#span1").html("");
		    $.ajax({
		     	url:"UsersCheckLoginPhone",
		     	type:"post",
		    	 data:{
		    		 c_usersinfor_password : $("#c_usersinfor_password").val(),
		    		 c_usersinfor_telphone : $("#c_usersinfor_telphone").val()
		     	},
		     	dataType:"jsonp",
		     	cache : false,
				async: false,
				//当jsonp将处理完毕的结果返回给页面时，通过下面的回调函数名
				//获得到回调函数
				jsonp:"c",
				//定义的回调函数名，也就是当后台处理完之后，返回结果时所必须掉的函数
				jsonpCallback:"showspan1"
		    });
		    var uuname=$("#c_usersinfor_telphone").val();
	  	  localStorage.setItem("userss",uuname);
	  }else{
	  	$("#span1").html("用户账号不能为空!!");
	  }
	});

	/*
	 * 用户登录时密码验证
	 */
	$("#c_usersinfor_password").blur(function(){
	      if($("#c_usersinfor_password").val()!=""){
				$("#span2").html("");
			    $.ajax({
			     	url:"UsersCheckLoginPass",
			     	type:"post",
			    	 data:{
			    		 c_usersinfor_password : $("#c_usersinfor_password").val(),
			    		 c_usersinfor_telphone : $("#c_usersinfor_telphone").val()
			    		// u_name : $("#c_usersinfor_password").val()
			     	},
			     	dataType:"jsonp",
			     	cache : false,
					async: false,
					//当jsonp将处理完毕的结果返回给页面时，通过下面的回调函数名
					//获得到回调函数
					jsonp:"cp",
					//定义的回调函数名，也就是当后台处理完之后，返回结果时所必须掉的函数
					jsonpCallback:"showspan2"
			    });
			    var uuname=$("#c_usersinfor_password").val();
			  	  localStorage.setItem("userss",uuname);
	      }else{
	      	$("#span2").html("密码不能为空!!");
	      }
	}); 
	/*
	 * 用户注册时昵称验证
	 */
	$("#c_usersinfor_name").blur(function(){
	  if($("#c_usersinfor_name").val()!=""){
			//var uname=$("#u_name").val();
			$("#span3").html("");
		    $.ajax({
		     	url:"UsersCheckRegisterName",
		     	type:"post",
		    	 data:{ 
		    		 c_usersinfor_name : $("#c_usersinfor_name").val(),
		    		 c_usersinfor_password : $("#c_usersinfor_password").val(),
		    		 c_usersinfor_telphone : $("#c_usersinfor_telphone").val(),
		    		 c_usersinfor_publickey : $("#c_usersinfor_publickey").val(),
		    		 c_usersinfor_images : $("#c_usersinfor_images").val(),
		    		 c_userstypes_id : $("#c_userstypes_id").val(),
		    		 c_usersinfor_sex : $("#c_usersinfor_sex").val()	 
		     	},
		     	dataType:"jsonp",
		     	cache : false,
				async: false,
				//当jsonp将处理完毕的结果返回给页面时，通过下面的回调函数名
				//获得到回调函数
				jsonp:"cregistname",
				//定义的回调函数名，也就是当后台处理完之后，返回结果时所必须掉的函数
				jsonpCallback:"showspan3"
		    });
		    var uuname=$("#c_usersinfor_name").val();
		    //localStorage.setItem("userss",uuname);
	  }else{
	  	$("#span3").html("用户昵称不能为空!!");
	  }
	});
	/*
	 * 用户注册时密码验证
	 */
	$("#c_usersinfor_password").blur(function(){
	  if($("#c_usersinfor_password").val()!=""){
			//var uname=$("#u_name").val();
			$("#span4").html("");
		    $.ajax({
		     	url:"UsersCheckRegisterPass",
		     	type:"post",
		    	 data:{ 
		    		 c_usersinfor_name : $("#c_usersinfor_name").val(),
		    		 c_usersinfor_password : $("#c_usersinfor_password").val(),
		    		 c_usersinfor_telphone : $("#c_usersinfor_telphone").val(),
		    		 c_usersinfor_publickey : $("#c_usersinfor_publickey").val(),
		    		 c_usersinfor_images : $("#c_usersinfor_images").val(),
		    		 c_userstypes_id : $("#c_userstypes_id").val(),
		    		 c_usersinfor_sex : $("#c_usersinfor_sex").val()	 
		     	},
		     	dataType:"jsonp",
		     	cache : false,
				async: false,
				//当jsonp将处理完毕的结果返回给页面时，通过下面的回调函数名
				//获得到回调函数
				jsonp:"cregistpass",
				//定义的回调函数名，也就是当后台处理完之后，返回结果时所必须掉的函数
				jsonpCallback:"showspan4"
		    });
		    var uuname=$("#c_usersinfor_password").val();
		    //localStorage.setItem("userss",uuname);
	  }else{
	  	$("#span4").html("用户注册密码不能为空!!");
	  }
	});
	/*
	 * 用户注册时手机号码验证
	 */
	$("#c_usersinfor_telphone").blur(function(){
	  if($("#c_usersinfor_telphone").val()!=""){
			//var uname=$("#u_name").val();
			$("#span5").html("");
		    $.ajax({
		     	url:"UsersCheckRegisterPhone",
		     	type:"post",
		    	 data:{ 
		    		 c_usersinfor_name : $("#c_usersinfor_name").val(),
		    		 c_usersinfor_password : $("#c_usersinfor_password").val(),
		    		 c_usersinfor_telphone : $("#c_usersinfor_telphone").val(),
		    		 c_usersinfor_publickey : $("#c_usersinfor_publickey").val(),
		    		 c_usersinfor_images : $("#c_usersinfor_images").val(),
		    		 c_userstypes_id : $("#c_userstypes_id").val(),
		    		 c_usersinfor_sex : $("#c_usersinfor_sex").val()	 
		     	},
		     	dataType:"jsonp",
		     	cache : false,
				async: false,
				//当jsonp将处理完毕的结果返回给页面时，通过下面的回调函数名
				//获得到回调函数
				jsonp:"cregistphone",
				//定义的回调函数名，也就是当后台处理完之后，返回结果时所必须掉的函数
				jsonpCallback:"showspan5"
		    });
		   // var uuname=$("#c_usersinfor_telphone").val();
		    //localStorage.setItem("userss",uuname);
	  }else{
	  	$("#span5").html("手机号码不能为空!!");
	  }
	});
	/*
	 * 修改查看个人信息
	 */
	showOne();
	
});

function showOne() { 
	var html = "";
	$.ajax({
		url:"./showOne",
		type:"GET",
		async:false,
		global:false,
		success:function(data){
			console.log(data);
			alert(data.c_usersinfor_id);
			html+="<tr>";
			html+="<td>"+data.c_usersinfor_id+"</td>";
			html+="<td>"+data.c_usersinfor_name+"</td>";
			html+="<td>"+data.c_usersinfor_telphone+"</td>";
			html+="<td>"+data.c_usersinfor_password+"</td>";
			html+="<td>"+data.c_usersinfor_publickey+"</td>";
			html+="<td>"+data.c_usersinfor_sex+"</td>";
			html+="<td><a href='#' class='font-red'>"+"修改"+"</a></td>";
			html +="</tr>";
			$("#tbody").html(html);
		}
	});
}
function showspan1(ts) {
	$("#span1").val(ts.messages);
	$("#span1").html(ts.messages);
}
/* */ 	function showspan2(up) {
$("#span2").val(up.messages);
$("#span2").html(up.messages);
}
function showspan3(u3) {
	$("#span3").val(u3.messages);
	$("#span3").html(u3.messages);
	}
function showspan4(u4) {
	$("#span4").val(u4.messages);
	$("#span4").html(u4.messages);
	}
function showspan5(u5) {
	$("#span5").val(u5.messages);
	$("#span5").html(u5.messages);
	}

