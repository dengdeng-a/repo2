package com.qwsite.xxw.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.qwsite.xxw.bean.News;

@Controller
public class uploadController {

	@RequestMapping(value = "/doupload")
	public String addUser(HttpServletRequest request ,@Valid News news,MultipartFile file,Model model) throws Exception{
		System.out.println("///////////");
		//获取原始图片的拓展名
		String originalFilename = file.getOriginalFilename();
		 String newFileName = UUID.randomUUID()+originalFilename;
		//设置图片上传路径
		String url = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println(url+"*********");
		//以绝对路径保存重名命后的图片
		file.transferTo(new File(url,newFileName));
		System.out.println(url+"   "+newFileName);
		String a = "/upload/"+newFileName;
		//把图片存储路径保存到数据库
		//news.setHtmltext("upload/"+newFileName);
		
		//userService.addUser(user);
		//重定向到查询所有用户的Controller，测试图片回显
		model.addAttribute("a", a);
		return "showpicture";
		
	}


}
