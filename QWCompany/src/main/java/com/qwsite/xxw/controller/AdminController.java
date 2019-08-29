package com.qwsite.xxw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qwsite.xxw.bean.Admin;
import com.qwsite.xxw.service.AdminService;

@Controller
public class AdminController {

	@Autowired
    private AdminService adminService;
	
	@RequestMapping("/dl")
	public String checkLogin(Admin admin,Model model,HttpServletRequest request,HttpSession httpSession){
		System.out.println("111111111111111");
		System.out.print(admin.getAname()+""+ admin.getPassword());
		//调用service方法
		admin = adminService.checkLogin(admin.getAname(), admin.getPassword());
		//若有user则添加到model里并且跳转到成功页面
		if(admin != null){
			model.addAttribute("admin",admin);
			httpSession.setAttribute("password", admin.getPassword());

			return "dlsuccess";
		}
		else{
			request.setAttribute("Msg", "用户名或密码错误！");
			return "dlfail";
		}
		
    }

}
