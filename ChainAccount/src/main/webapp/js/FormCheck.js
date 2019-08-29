/**
 * 
 */
/*
 * 用户在“姓名”文本框中填写完信息后，将光标的焦点从“姓名”文本框中移出时，
 * 需要即时判断姓名是否符合验证规则。当光标的焦点从“邮箱”文本框移出时，
 * 也需要即时判断“邮箱”填写是否正确，因此需要给表单元素添加失去焦点事件，即 blur 事件。
 */
//为表单的元素添加失去焦点事件
$(document).ready(function (){
	//为表单元素添加失去焦点事件
    $("#updateInfo form input").blur(function(){
    	//验证姓名
        if($(this).is("#up_name")){
            var nameVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
            var regName =  /[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]/im;  
            if(nameVal == "" || nameVal.length < 6 || regName.test(nameVal)){
                var errorMsg = " 姓名非空，长度6位以上，不包含特殊字符！";
                //class='msg onError' 中间的空格是层叠样式的格式
                $(this).next().removeClass("onSuccess");
                $(this).next().addClass("onError");
                $(this).next().text(errorMsg);
            }
            else{
                var okMsg=" 输入正确";
                $(this).next().removeClass("onError");
                $(this).next().addClass("onSuccess");    
                $(this).next().text(okMsg);
            }
        }
        
      //验证邮箱
        if($(this).is("#up_phone")){
            var phoneVal = $.trim(this.value);
            var regEmail = /[0-9,]{11}/;
            if(phoneVal== "" || (phoneVal != "" && !regEmail.test(phoneVal))){
                var errorMsg = " 请输入正确的E-Mail住址！";
                $(this).next().removeClass("onSuccess");
                $(this).next().addClass("onError");
                $(this).next().text(errorMsg);
            }
            else{
                var okMsg=" 输入正确";
                $(this).next().removeClass("onError");
                $(this).next().addClass("onSuccess");    
                $(this).next().text(okMsg);
            }
        }
    
    });
    
    $("#updatePwddModal form input").blur(function(){
    	//验证姓名
        var pwdVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
        var regName = /\s+/;
        if(pwdVal == "" || pwdVal.length < 8 ||pwdVal.length > 16 || regName.test(pwdVal)){
            var errorMsg = " 请输入8-16位密码，不能使用空格";
            //class='msg onError' 中间的空格是层叠样式的格式
            $(this).next().removeClass("onSuccess");
            $(this).next().addClass("onError");
            $(this).next().text(errorMsg);
        }
        else{
            var okMsg=" 输入正确";
            $(this).next().removeClass("onError");
            $(this).next().addClass("onSuccess");    
            $(this).next().text(okMsg);
        }  
    });
    	
})


