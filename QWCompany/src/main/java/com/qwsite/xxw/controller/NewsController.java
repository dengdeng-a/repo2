package com.qwsite.xxw.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwsite.xxw.bean.Msg;
import com.qwsite.xxw.bean.News;
import com.qwsite.xxw.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	NewsService newsService;
	/*
	 * responseBody自动把返回的字符串转化称json字符串
	 *导入jackson的包
	 */
	
	//跳转内容方法
	@RequestMapping("/context")
	public ModelAndView context(@RequestParam(value="id") Integer id,HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		News news = newsService.getOneNew(id);
		System.out.println("news.getContext()"+news.getContext());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/context");
		mav.addObject("context",news.getContext());
		mav.addObject("dw","dwdwdwdwdwdwdsbsbbsbs");
		mav.addObject("dwww","111111");
		return mav;	
	}
	
	
	@RequestMapping("/news")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn){
		//这不是一个分页查询
		//引入PageHelper分页插件
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的查询就是一个分页查询
		List<News> emps =newsService.getAll();
		//用PageInfo对结果进行包装,,,只需要将pageinfo交给页面就可以了
		//pageinfo封装了详细的分页信息，包括我们擦出来的数据  ,,连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		return Msg.success().add("pageInfo",page);
	}
	
	@RequestMapping("/newsziye")
	@ResponseBody
	public Msg getnewsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn){
		//这不是一个分页查询
		//引入PageHelper分页插件
		PageHelper.startPage(pn, 2);
		//startPage后面紧跟的查询就是一个分页查询
		List<News> emps =newsService.getAll();
		//用PageInfo对结果进行包装,,,只需要将pageinfo交给页面就可以了
		//pageinfo封装了详细的分页信息，包括我们擦出来的数据  ,,连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		return Msg.success().add("pageInfo",page);
	}
	
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveNews(@Valid News news,BindingResult result,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		 System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		//解析请求中的数据  
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
		String title = mpRequest.getParameter("title");		
		//解析图片相对路径
        file = mpRequest.getFile("htmltext");
		//获取原始图片的拓展名
		String originalFilename = file.getOriginalFilename();
	    System.out.println("获取到图片原始名了"+originalFilename);
		 String newFileName =df.format(new Date())+originalFilename;
		//设置图片上传路径
		String url = request.getSession().getServletContext().getRealPath("/newsPicture");
		//以绝对路径保存重名命后的图片
		file.transferTo(new File(url,newFileName));
		System.out.println(url+"   "+newFileName);	
		news.setHtmltext(url+"\\"+newFileName);
		newsService.saveNews(news);
		return Msg.success();
		}
	
	
	
	/**
	 * 根据id查询新闻
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/onenew/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getOneNew(@PathVariable("id")Integer id){
		News news = newsService.getOneNew(id);
		System.out.println("2222222222222222"+news);
		return Msg.success().add("news", news);
	}
	
	
	/**
	 * update新闻带图片更新
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@ResponseBody
	@RequestMapping(value="/updatenews/{nid}",method=RequestMethod.PUT)
	public Msg saveEmpWithpic(News news,HttpServletRequest request,MultipartFile file) throws IllegalStateException, IOException{
		/*System.out.println("请求体中的值："+request.getParameter("title"));
		System.out.println("将要更新的新闻数据"+news);*/
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		 System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		 
		 
		//解析请求中的数据  
        /*MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
		String title = mpRequest.getParameter("title");	*/
		System.out.println(news);
		//解析图片相对路径
        //file = mpRequest.getFile("htmltext");
		//获取原始图片的拓展名
		/*String originalFilename = file.getOriginalFilename();
	    System.out.println("获取到图片原始名了"+originalFilename);*/
		 String newFileName =df.format(new Date());
		//设置图片上传路径
		String url = request.getSession().getServletContext().getRealPath("/newsPicture");
		//以绝对路径保存重名命后的图片
		file.transferTo(new File(url,newFileName));
		System.out.println(url+"   "+newFileName);	
		news.setHtmltext(url+"\\"+newFileName);
		newsService.updateEmp(news);
		return Msg.success();
	}
	
	/**
	 * update新闻
	 * @param id
	 * @return
	 */
	@ResponseBody
	//@RequestMapping(value="/updatenews/{nid}",method=RequestMethod.PUT)
	public Msg saveEmp(News news,HttpServletRequest request){
		System.out.println("请求体中的值："+request.getParameter("title"));
		System.out.println("将要更新的新闻数据"+news);
		newsService.updateEmp(news);
		return Msg.success();
	}
	
	/*
	 * delete
	 */
	@RequestMapping(value="/delnews",method=RequestMethod.POST)
	@ResponseBody
	public Msg deleteNews(@RequestParam("id") Integer id){
		System.out.println("id="+id);
		newsService.deleteNews(id);
		return Msg.success();
	}
	
	
	
	/*
	 * 文件上传的方法
	@RequestMapping(value="/doupload",method=RequestMethod.POST)
	public void doUploadFile(@RequestParam("htmltext")MultipartFile file,HttpServletRequest request,Model model) throws IOException{
		String filePath = request.getSession().getServletContext().getRealPath("/newsPicture");//保存图片的路径
		System.out.println(filePath);
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        String newFileName = System.currentTimeMillis()+originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        //model.addAttribute("user",file);
		//return Msg.success();
	}
	*/
	
}

