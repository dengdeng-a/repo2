package com.ServiceNode.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ServiceNode.Service.UserService1;
import com.ServiceNode.bean.User;

@Controller
public class UsersController {

	@Autowired
	private UserService1  userService1;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String RegisterLogin(User user,Model model,HttpServletRequest request,HttpSession httpSession){
		System.out.println("111111111111111");
		System.out.print(user.getUname()+""+ user.getPassword());
		user.setLevel(1);
		//调用service方法
		 userService1.RegisterLogin(user);
		 if(user != null){
	            model.addAttribute("user",user);
	            return "RegisterSuccess";
	        }
	     return "Regiterfail";
	}
}
