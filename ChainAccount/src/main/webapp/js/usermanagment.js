/**
 * 
 */

$(document).ready(function (){
	//input=file 的样式修改
	 $('#my-img').click(function(){
	        $('#img-upload').click();
	    });
	 
	showOne();
});

//查询账户的信息
function showOne() { 
	var html = "";
	$.ajax({
		url:"./showOne",
		type:"GET",
		async:false,
		global:false,
		success:function(data){
			var obj = eval ("(" + data + ")");
			html+="<tr>";
			html+="<td id='user_id'>"+obj.c_usersinfor_id+"</td>";
			html+="<td>"+obj.c_usersinfor_name+"</td>";
			html+="<td>"+obj.c_usersinfor_telphone+"</td>";
			html+="<td id='pwd_id' style=\"display:none;\" >"+obj.c_usersinfor_password+"</td>";
			html+="<td>"+obj.c_usersinfor_publickey+"</td>";
			html+="<td>"+obj.c_usersinfor_sex+"</td>";
			html+="<td>"+obj.c_userstypes_name+"</td>";
			html+="<td><button id='edit_btn' class='\btn btn-primary btn-lg\'>"+"修改"+"</button></td>";
			html +="</tr>";
			$("#tbody").html(html);
			$("#headimg")[0].src="./img/"+obj.c_usersinfor_images;
			$("#updateImg")[0].src="./img/"+obj.c_usersinfor_images;
			$("#name_p")[0].innerHTML=obj.c_usersinfor_name;
			//给模态框设置回显的src地址
			$("#updateImgModal").attr("this_img",obj.c_usersinfor_images);
		}
	});
}

//1、我们是按钮创建之前就绑定了click，所以绑定不上。
//1）、可以在创建按钮的时候绑定。    2）、绑定点击.live()
//jquery新版没有live，使用on进行替代
$(document).on("click","#edit_btn",function(){
	//1、查出部门信息，并显示部门列表
	showType();
	//2、查出员工信息，显示员工信息
	getOne();
	
	$("#updateInfo form span").text("");
	$("#updateInfo").modal({
		backdrop:"static"
	});
});

/*
 * 修改的回显信息
 */
function getOne() {
	var html = "";
	$.ajax({
		url:"./showOne",
		type:"GET",
		async:false,
		global:false,
		success:function(data){
			var obj = eval ("(" + data + ")");
			$("#up_id").val(obj.c_usersinfor_id);
			$("#up_name").val(obj.c_usersinfor_name);
			$("#up_phone").val(obj.c_usersinfor_telphone);
			$("#up_password").val(obj.c_usersinfor_password);
			$("#up_publickey").val(obj.c_usersinfor_publickey);
			$("#up_sex").val(obj.c_usersinfor_sex);
			$("#up_type").val([obj.c_userstypes_id]);
		}
	});
}


/*
 * 查出角色信息，显示在下拉列表
 */
function showType() {
	var html = "";
	$.ajax({
		url:"./selectTypes",
		type:"GET",
		async:false,
		global:false,
		success:function(data){
			var data = eval ("(" + data + ")");
			console.log(data);
			var obj = data.extend.list;
			for(var i=0;i<obj.length;i++){
				html +="<option value="+obj[i].c_userstypes_id+">"+obj[i].c_userstypes_name+"</option>";
			}
			$("#up_type").html(html);
			
		}
	})
}

/*
 * 信息修改的提交
 */
$(document).on("click","#user_update_btn",function(){
	//trigger 事件执行完后，浏览器会为submit按钮获得焦点
    $("#updateInfo form input").trigger("blur"); 
    var numError = $("#updateInfo form .onError").length;
    if(numError){
        return false;
    }
    
	var c_usersinfor_id = $("#up_id").val();
	$.ajax({
		url:"./updateUser/"+c_usersinfor_id,
		type:"POST",
		data:$("#updateInfo form").serialize()+"&_method=PUT",
		success:function(result){
			var data = eval ("(" + result + ")");
			alert(data.msg);
			//1、关闭对话框
			$("#updateInfo").modal("hide");
			//2、回到本页面
			showOne();
		}
	});
})

//点击头像弹出模态框
function updateImg() {
	$('#updateImgModal').modal({
		backdrop: 'static'
		});
	$("#updateImg")[0].src="./img/"+$("#updateImgModal").attr("this_img");
}

//换头像模态框的确认
function changeUpload(){
	window.open ("usermanage.html","name1");
	$("#updateImgModal form").submit();
}

//换头像的图片预览
function preview(file,img){  
    var prevDiv = document.getElementById(img);  
    if (file.files && file.files[0]){     
            //alert(file.files[0].name); //名称  
            //alert(file.files[0].size);  //大小 字节 
            //alert(file.files[0].type);//类型 
        var size = file.files[0].size;
        if(size > 2 * 1024*1024){
            alert("上传大小不符合");
            return false;
        }
         // 获取文件名 包含后缀  
         var src = file.files[0].name;  
         // 获取文件后缀                                                      
         var type=(src.substr(src.lastIndexOf("."))).toLowerCase(); 
        // 判断文件类型                                   
        if(type != ".jpg" && type != ".gif" && type !=".jpeg" && type != ".png"){           
            alert("您上传图片的类型不符合(.jpg|.jpeg|.gif|.png)！");
            return false;
        }
          
        var reader = new FileReader(); 
        reader.readAsDataURL(file.files[0]);            //将文件以Data URL形式读入页面
        reader.onload = function(evt){                  //onload 成功读取 
            //显示文件
            prevDiv.src = evt.srcElement.result;             
        }  
    }  
 }  

//修改密码的button的绑定事件，调出modal
function pwdButton(){
	//清除修改密码模态框的校验信息
	$("#updatePwdModal form span").text("");
	$("#updatePwdModal form input").val("");
	$("#updatePwdModal").modal({
		backdrop:"static"
	});
}

//修改密码的确定，发送请求
function changePwd() {
	var password = $("#pwd_id").text();
	console.log(($("#up_password").val()));
	if($("#up_password").val() ==""){
		$("#pwd_span").addClass("onError"); 
		$("#pwd_span").text("原始密码为空"); 
	}else {
		if($("#up_password").val() ==$("#up_password1").val()){
			$("#pwd_span").addClass("onError"); 
			$("#pwd_span").text("新密码与就密码相同"); 
		}else {
			if($("#up_password1").val() !=$("#up_password2").val()){	
				$("#pwd_span").addClass("onError"); 
				$("#pwd_span").text("新密码两次输入不同"); 
			}
			else {
				if($("#up_password").val() ==password){
					var c_usersinfor_id = $("#user_id").text();
					alert(c_usersinfor_id);
					$.ajax({
							url:"./changePwd/"+c_usersinfor_id,
							type:"POST",
							data:$("#updatePwdModal form").serialize()+"&_method=PUT",
							success:function(result){
								var data = eval ("(" + result + ")");
								alert(data.msg);
								//1、关闭对话框
								$("#updatePwdModal").modal("hide");
								//2、回到本页面
								showOne();
							}
					})
				}else {
					$("#pwd_span").addClass("onError"); 
					$("#pwd_span").text("原密码错误");
				}
			}
			
		}
	}
	
	
}

