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
import com.client.bean.success_1;

@Controller
public class AccountController {
	
	/*
	 * 1.
	 */
	@RequestMapping(value="/account",method=RequestMethod.GET)
	@ResponseBody
	public Msg AccountList(@RequestParam(value = "Tag")Integer Tag,@RequestParam(value = "batch")Integer batch,@RequestParam(value = "page")Integer page, HttpServletRequest request){
		success_1 suc = new success_1("��ַǮ��","����");
		return  Msg.success().add("accountList", suc);
	}
	
	/*
	 * 2.
	 */
	@RequestMapping(value="/account/{address}",method=RequestMethod.GET)
	@ResponseBody
	public Msg AccountInfo(@PathVariable("address") Integer address, HttpServletRequest request,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");//����������Դ����
		response.addHeader("Access-Control-Allow-Methods","GET");//��Ӧ����
		String suc = "�û���Կ���ܣ������˺���Ϣ��";
		return  Msg.success().add("accountList", suc);
	}
	
	/*
	 * 3.
	 */
	@RequestMapping(value="/account/{account}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg AccountUpdate(@PathVariable("account") Integer account, HttpServletRequest request,HttpServletResponse response){
		//String suc = "signature: ��ǰ�����ǩ����";
		response.addHeader("Access-Control-Allow-Origin","*");//����������Դ����
		response.addHeader("Access-Control-Allow-Methods","PUT");//��Ӧ����
		return  Msg.success();
	}
	
}
