package com.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.client.bean.Msg;
import com.client.bean.PrintReponse;
import com.client.bean.Result;
import com.client.bean.success1;
import com.client.bean.success3;


@Controller
public class FileController {

	//@RequestParam(value = "account",defaultValue="1") 
	@RequestMapping(value="/file",method=RequestMethod.POST)
	@ResponseBody
	public Msg FileRequest(@RequestParam(value = "account") String account, HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		map.put("fileld", request.getParameter("fileld"));
		map.put("filename", request.getParameter("filename"));
		map.put("size", request.getParameter("size"));
		map.put("publicKey", request.getParameter("publicKey"));
		map.put("brief", request.getParameter("brief"));
		map.put("tags", request.getParameter("tags"));
		map.put("signature", request.getParameter("signature"));
		
		//遍历maps
		for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key: " + key + " value: " + value);
		}
		success1 succ = new success1("当前上传文件的价格，系统可能根据实际情况调整价格","当前价格的形成原因","本次上传花费","公式等本次花费说明，计算","本次上传通信秘钥", "秘钥有效期","加密方式，系统预定义值（具体待定）","存储节点ip/port","公钥","前几项的签名");
		return  Msg.success().add("body", succ);
	}
	
	/**
	 * 
	 * @param request   2
	 * @return
	 * @throws ServletException 
	 * @throws IOException 
	 */
	@RequestMapping(value="/file/{fileId}",method=RequestMethod.POST)
	@ResponseBody
	public Msg Fileupload(@PathVariable("fileId") Integer fileId, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		Map<String,String> map = new HashMap<String,String>();
		map.put("fileld", request.getParameter("fileId"));
		map.put("verifyId", request.getParameter("verifyId"));
		map.put("account", request.getParameter("account"));
		map.put("speed", request.getParameter("speed"));
		map.put("retries", request.getParameter("retries"));
		map.put("duration", request.getParameter("duration"));
		map.put("location", request.getParameter("location"));
		map.put("signature", request.getParameter("signature"));
		//遍历maps
		for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key: " + key + " value: " + value);
		}
		
		//文件上传
		/*
		//说明输入的请求信息采用UTF-8编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//Servlet3.0中新引入的方法，用来处理multipart/form-data类型编码的表单
		Part part = request.getPart("file");
		//获取HTTP头信息headerInfo=（form-data; name="file" filename="文件名"）
		String headerInfo = part.getHeader("content-disposition");
		System.out.println("获取HTTP头信息headerInfo"+headerInfo);
		//从HTTP头信息中获取文件名fileName=（文件名）
		String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
		System.out.println("从HTTP头信息中获取文件名"+fileName);
		//获得存储上传文件的文件夹路径
		String fileSavingFolder = request.getServletContext().getRealPath("/UploadServlet");
		System.out.println("获得存储上传文件的文件夹路径"+fileSavingFolder);
		//获得存储上传文件的完整路径（文件夹路径+文件名）
		//文件夹位置固定，文件夹采用与上传文件的原始名字相同
		String fileSavingPath = fileSavingFolder + File.separator + fileName;
		System.out.println(fileSavingPath);
		//如果存储上传文件的文件夹不存在，则创建文件夹
		File f = new File(fileSavingFolder + File.separator);
		if(!f.exists()){
			f.mkdirs();
		}
		//将上传的文件内容写入服务器文件中
		part.write(fileSavingPath);
		//输出上传成功信息
		//out.println("文件上传成功~！");
*/		//success2 succ = new success2("成功");
		return  Msg.success();
	}
	
	/*
	 * 3.URI：http://{serviceNode}/client/file?account=”用户钱包地址“&batch=”分页大小 “&page=”第几页”
	 */
	
	@RequestMapping(value="/file",method=RequestMethod.GET)
	@ResponseBody
	public Msg FileList(@RequestParam(value = "account") Integer account,@RequestParam(value = "batch") Integer batch, @RequestParam(value = "page") Integer page,HttpServletRequest request){
		success3 suc= new success3("文件sha256值", "文件名", "文件大小，字节", "文件简介", "文件标签");
	/*	List<success3> list = new ArrayList<success3>();
		list.add(suc.getFileId())*/
		success1 succ = new success1("当前上传文件的价格，系统可能根据实际情况调整价格","当前价格的形成原因","本次上传花费","公式等本次花费说明，计算","本次上传通信秘钥", "秘钥有效期","加密方式，系统预定义值（具体待定）","存储节点ip/port","公钥","前几项的签名");
		return  Msg.success().add("fileList", suc);
	}
	
	/*
	 * 4.
	 */
	
	@RequestMapping(value="/file/{fileId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg FileGet(@PathVariable("fileId") Integer fileId, HttpServletRequest request){
		success3 suc= new success3("文件sha256值", "文件名", "文件大小，字节", "文件简介", "文件标签");
	/*	List<success3> list = new ArrayList<success3>();
		list.add(suc.getFileId())*/
		//success1 succ = new success1("当前上传文件的价格，系统可能根据实际情况调整价格","当前价格的形成原因","本次上传花费","公式等本次花费说明，计算","本次上传通信秘钥", "秘钥有效期","加密方式，系统预定义值（具体待定）","存储节点ip/port","公钥","前几项的签名");
		return  Msg.success().add("fileList", suc);
	}
	
	/*
	 * 5.
	 */
	@RequestMapping(value="/file/{fileId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg FileUpdate(@PathVariable("fileId") Integer fileId,@RequestParam(value = "account") Integer account, HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		response.addHeader("Access-Control-Allow-Origin","*");//允许所有来源访问
		response.addHeader("Access-Control-Allow-Methods","PUT");//响应类型
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("fileId", request.getParameter("fileId"));
		map.put("filename", request.getParameter("filename"));
		map.put("brief", request.getParameter("brief"));
		map.put("tags", request.getParameter("tags"));
		map.put("signature", request.getParameter("signature"));
		System.out.println("dfgdgfdgdfgfdggddgfdfdgfdgfdgfdfdgfdgfdgfd"+"           "+request.getParameter("fileId"));		
		for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key: " + key + " value: " + value);
		}
		/*PrintWriter writer = response.getWriter();
		//Map<String, String> map = new HashMap<>();
		//map.put("status", "success");
		writer.write(map.toString());
		writer.close();*/
		return  Msg.success();
	}
	
	/*
	 * 6.
	 */
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	@ResponseBody
	public Msg FileSearch(@RequestParam(value = "key") Integer key, HttpServletRequest request){
		success3 suc= new success3("文件sha256值", "文件名", "文件大小，字节", "文件简介", "文件标签");
			List<success3> list = new ArrayList<success3>();
			return  Msg.success().add("fileList", suc);
		}
	
	
	
}


