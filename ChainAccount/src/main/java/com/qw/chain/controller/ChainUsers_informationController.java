package com.qw.chain.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.qw.chain.bean.ChainUsers_information;
import com.qw.chain.bean.ChainUsers_types;
import com.qw.chain.bean.Messages;
import com.qw.chain.bean.Msg;
import com.qw.chain.bean.PrintReponseUname;
import com.qw.chain.bean.PrintReponseUpass;
import com.qw.chain.bean.PrintReponseUregistname;
import com.qw.chain.bean.PrintReponseUregistpass;
import com.qw.chain.bean.PrintReponseUregistphone;
import com.qw.chain.service.ChainUsers_informationServer;

@Controller
public class ChainUsers_informationController {
	@Autowired
    private ChainUsers_informationServer chaininforService;
	/*
	 * 登录
	 */
	@RequestMapping(value="/chainuserlogin",method=RequestMethod.POST)
	public String checkLogin(ChainUsers_information chaininfor,Model model,HttpServletRequest request,HttpSession httpSession){
		String Goto="";
		System.out.print(chaininfor.getC_usersinfor_telphone()+""+ chaininfor.getC_usersinfor_password());
		//调用service方法
		chaininfor = chaininforService.checkLogin(chaininfor.getC_usersinfor_telphone(), chaininfor.getC_usersinfor_password());
		//若有user则添加到model里并且跳转到成功页面
		if(chaininfor != null){
			model.addAttribute("chaininfor",chaininfor);
			httpSession.setAttribute("password", chaininfor.getC_usersinfor_password());
			return "forward:showOne";
		}
		else{
			request.setAttribute("Msg", "用户名或密码错误！");
			System.out.println("用户名或密码错误！");
			return "dlfail";
		}
    }
	/*
	 * 注册
	 */
	@RequestMapping("/chainusersregeist")
	@ResponseBody
	public String usersRegister(@Valid ChainUsers_information chaininfor,Model model,HttpServletRequest request,@RequestParam("c_usersinfor_images")MultipartFile file,HttpSession httpSession) throws Exception{
		//System.out.println("111111111111111");
		System.out.print(chaininfor.getC_usersinfor_telphone()+""+ chaininfor.getC_usersinfor_password());
		ChainUsers_information chainusersinfor= new ChainUsers_information();
		System.out.println("开始获取原始图片的拓展名");
		//获取原始图片的拓展名
		String originalFilename = file.getOriginalFilename();
		 String newFileName = UUID.randomUUID()+originalFilename;
		//设置图片上传路径
		String url = request.getSession().getServletContext().getRealPath("/img");
		System.out.println(url+"*********");
		//以绝对路径保存重名命后的图片
		file.transferTo(new File(url,newFileName));
		System.out.println(url+"   "+newFileName);
		String a = "/img/"+newFileName;
		//把图片存储路径保存到数据库
		//news.setHtmltext("upload/"+newFileName);
		
		//userService.addUser(user);
		//重定向到查询所有用户的Controller，测试图片回显
		model.addAttribute("a", a);
		//调用service方法chaininfor
		chaininforService.resgistUsers(chainusersinfor);
		//若有user则添加到model里并且跳转到成功页面
		System.out.println("注册成功!");
		return "login";
		
    }
	/*	//注销
	@RequestMapping("/CreatorRemove")
	public String  UsersRemove(Users users,HttpServletRequest request){
		request.getSession().removeAttribute("uname");
		//request.getSession().invalidate();
		return "index";
	}*/
	//登录时验证登录名是否存在
	   @RequestMapping("/UsersCheckLoginPhone") 
	   public String SelectByuname(ChainUsers_information cusers,Messages mm,HttpServletRequest request,HttpServletResponse response){
		   System.out.print("cusers"+cusers.getC_usersinfor_telphone()); 
		   ChainUsers_information c = chaininforService.getUsersByPhone(cusers);
	     if(c==null){
	    	 mm.setMessages("没有该用户，请注册！");	    	
	     }else{
	    	 mm.setMessages("");
	    	  System.out.print("有该用户");    	
	     }
	     //将处理完毕的结果以json串形式封装起来，并且返回给视图层
	     PrintReponseUname.printResult(request, response, mm);
	        return "regist";
	     
	   }
	/* 
	 * 注册时验证登录名是否存在
	 */
	   @RequestMapping("/UsersCheckRegisterName") 
	   public void SelectByUnameRegister(ChainUsers_information cusers,Messages mm,HttpServletRequest request,HttpServletResponse response){
		   ChainUsers_information u = chaininforService.getUsersByName(cusers);
	     if(u==null){
	    	 mm.setMessages("");	    	
	     }else{
	    	 mm.setMessages("该用户名已经存在！");   	
	     }
	     //将处理完毕的结果以json串形式封装起来，并且返回给视图层
	     PrintReponseUregistname.printResult(request, response, mm);
		
	     
	   }
	   /* 
		 * 注册时验证密码是否重复
		 */
		   @RequestMapping("/UsersCheckRegisterPass") 
		   public void SelectByUpassRegister(ChainUsers_information cusers,Messages mm,HttpServletRequest request,HttpServletResponse response){
			   ChainUsers_information u = chaininforService.selectuserbyregistupass(cusers);
		     if(u==null){
		    	 mm.setMessages("");	    	
		     }else{
		    	 mm.setMessages("该密码已存在！请重新输入！");   	
		     }
		     //将处理完毕的结果以json串形式封装起来，并且返回给视图层
		     PrintReponseUregistpass.printResult(request, response, mm);
			
		     
		   }
	   /* 
		 * 注册时验证登录手机号码是否存在
		 */
		   @RequestMapping("/UsersCheckRegisterPhone") 
		   public void SelectByUphoneRegister(ChainUsers_information cusers,Messages mm,HttpServletRequest request,HttpServletResponse response){
			   ChainUsers_information u = chaininforService.selectuserbyregistuphone(cusers);
		     if(u==null){
		    	 mm.setMessages("");	    	
		     }else{
		    	 mm.setMessages("该手机号码已经注册！请核对！");   	
		     }
		     //将处理完毕的结果以json串形式封装起来，并且返回给视图层
		     PrintReponseUregistphone.printResult(request, response, mm);
			
		     
		   }
		/*
		 *  验证登录名密码是否正确
		 */		 
	   @RequestMapping("/UsersCheckLoginPass") 
	   public void SelectUpassByUpass(ChainUsers_information cusers,Messages mm,HttpServletRequest request,HttpServletResponse response){
		   //System.out.println(name+"******************");
	   /**/  ChainUsers_information u = chaininforService.getUserspasssByUPass(cusers);
	     System.out.print("根据用户查密码："+u); 
	     if(u!=null&&u.getC_usersinfor_password().equals(cusers.getC_usersinfor_password())){
	    	 mm.setMessages("");
	    	  System.out.print("密码正确");  
	    	   	
	     }else{
	    	 mm.setMessages("密码不正确，请核对！");	  
	     }
	     //将处理完毕的结果以json串形式封装起来，并且返回给视图层
	     PrintReponseUpass.printResult(request, response, mm);
	   }
	
	   

		
		
		/*
		 * 登录之后查看个人信息
		 */
		@RequestMapping(value="/showOne",method=RequestMethod.GET)
		@ResponseBody
		public ChainUsers_information selectOneById(HttpServletRequest request){
			HttpSession session = request.getSession(true);//新建session对象
			session.setAttribute("ss", 4);  //将对应数据存入session中
			int uid = (int) session.getAttribute("ss");
			ChainUsers_information information = chaininforService.selectOneById(uid);
			return information;
		}
		
		/*
		 * 查询角色信息
		 */
		@RequestMapping(value="/selectTypes",method=RequestMethod.GET)
		@ResponseBody
		public Msg up_type() {
			List<ChainUsers_types> list = new ArrayList<ChainUsers_types>();
			list = chaininforService.selectTypes();
			return Msg.success().add("list", list);
		}
		
		/*
		 * 修改用户信息
		 */
		@RequestMapping(value="/updateUser/{c_usersinfor_id}",method=RequestMethod.PUT)
		@ResponseBody
		public Msg updataUser(HttpServletRequest request,ChainUsers_information information) {
			System.out.println("请求体中的值："+request.getParameter("c_usersinfor_sex"));
			chaininforService.updateUser(information);
			return Msg.success();
			
		}
		
		/*
		 * 修改用户头像
		 */
		@RequestMapping(value="/changeUpload",method=RequestMethod.POST)
		@ResponseBody
		public Msg ChangeUpload(@RequestParam("c_usersinfor_images") CommonsMultipartFile file,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException {
			int uid = (int) session.getAttribute("ss");
			ChainUsers_information chainUsers_information= new ChainUsers_information();
			//获取原始图片的拓展名
			String originalFilename = file.getOriginalFilename();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			 String newFileName = (df.format(new Date())+originalFilename);
			//设置图片上传路径
			String url = request.getSession().getServletContext().getRealPath("/img");
			//以绝对路径保存重名命后的图片
			file.transferTo(new File(url,newFileName));
			System.out.println(url+"   "+newFileName);
			//把图片存储路径保存到数据库
			chainUsers_information.setC_usersinfor_id(uid);
			chainUsers_information.setC_usersinfor_images(newFileName);	
			chaininforService.changeUploadImg(chainUsers_information);
			return Msg.success();
		}
		
		/*
		 * 修改用户密码
		 */
		@RequestMapping(value="/changePwd/{c_usersinfor_id}",method=RequestMethod.PUT)
		@ResponseBody
		public Msg changePwd(HttpServletRequest request,ChainUsers_information information) {
			System.out.println("请求体中的值："+request.getParameter("c_usersinfor_password"));
			chaininforService.changepwd(information);
			return Msg.success();
			
		}
}
