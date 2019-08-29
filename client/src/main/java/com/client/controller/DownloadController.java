package com.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.client.bean.Msg;
import com.client.bean.success1;
import com.client.bean.success_3_2;
@Controller
@RequestMapping(value="/download")
public class DownloadController {

	@RequestMapping(value="/file/{fileId}",params="account",method=RequestMethod.POST)
	@ResponseBody
	public Msg Download(@PathVariable("fileId") Integer fileId,@RequestParam(value = "account")Integer account, HttpServletRequest request,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");//允许所有来源访问
		response.addHeader("Access-Control-Allow-Methods","POST");//响应类型
		success1 succ = new success1("当前下载文件的价格，系统可能根据实际情况调整价格","当前价格的形成原因","本次下载花费","公式等本次花费说明，计算公式等","本次下载通信秘钥", "秘钥有效期","加密方式，系统预定义值（具体待定）","存储节点ip/port","系统公钥","前几项的签名");
		return  Msg.success().add("body", succ);
	}
	
	@RequestMapping(value="/blockBegin/{fileId}/{blockNum}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBlock(@PathVariable("fileId") Integer fileId,@PathVariable("blockNum") Integer blockNum,@RequestParam(value = "account")Integer account, HttpServletRequest request,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");//允许所有来源访问
		response.addHeader("Access-Control-Allow-Methods","POST");//响应类型		
		success_3_2 succ = new success_3_2("块头内容base64编码", "公钥", "前几项的签名");
		return  Msg.success().add("body", succ);
	}
	
	@RequestMapping(value="/blockEnd/{fileId}/{blockNum}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBlockEnd(@PathVariable("fileId") Integer fileId,@PathVariable("blockNum") Integer blockNum,@RequestParam(value = "account")Integer account, HttpServletRequest request,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");//允许所有来源访问
		response.addHeader("Access-Control-Allow-Methods","POST");//响应类型	
		success_3_2 succ = new success_3_2("块头内容base64编码", "公钥", "前几项的签名");
		return  Msg.success().add("body", succ);
	}
}
