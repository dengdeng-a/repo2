package com.ServiceNode.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ServiceNode.Service.UserService;
import com.ServiceNode.bean.Msg;
import com.ServiceNode.bean.User;

@Controller
public class UsersController {

	@Autowired
	private UserService  userService;
	
	/*
	 * �����½�û���������
	 */
	@RequestMapping(value="/LoginCheck")
	@ResponseBody
	public Msg LoginCheck(User user,String uname,String password){
		System.out.println(user.toString());
		System.out.print(user.getUname()+"////////"+ user.getPassword());
		//����service����
		user = userService.LoginCheck(user.getUname(),user.getPassword());
		if(user !=null){
			return Msg.success();
		}
		return Msg.fail().add("va_msg", "�û������������");
	}
	
	/*
	 * У��ע���û����Ƿ����
	 */
	@RequestMapping(value="/checkuser")
	@ResponseBody
	public Msg checkUser(String uname){
		
		//���ݿ��û��ظ�У��
				boolean b = userService.checkuser(uname);
				if(b){
					return Msg.success();
				}
				else {
					return Msg.fail().add("va_msg", "�û���������");
				}
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Msg RegisterLogin(User user,HttpServletRequest request){
		System.out.println(user.toString());
		 user.setLevel(1);
		 userService.RegisterLogin(user);
		return Msg.success();
		
	}
}