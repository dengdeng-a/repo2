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
		response.addHeader("Access-Control-Allow-Origin","*");//����������Դ����
		response.addHeader("Access-Control-Allow-Methods","POST");//��Ӧ����
		success1 succ = new success1("��ǰ�����ļ��ļ۸�ϵͳ���ܸ���ʵ����������۸�","��ǰ�۸���γ�ԭ��","�������ػ���","��ʽ�ȱ��λ���˵�������㹫ʽ��","��������ͨ����Կ", "��Կ��Ч��","���ܷ�ʽ��ϵͳԤ����ֵ�����������","�洢�ڵ�ip/port","ϵͳ��Կ","ǰ�����ǩ��");
		return  Msg.success().add("body", succ);
	}
	
	@RequestMapping(value="/blockBegin/{fileId}/{blockNum}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBlock(@PathVariable("fileId") Integer fileId,@PathVariable("blockNum") Integer blockNum,@RequestParam(value = "account")Integer account, HttpServletRequest request,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");//����������Դ����
		response.addHeader("Access-Control-Allow-Methods","POST");//��Ӧ����		
		success_3_2 succ = new success_3_2("��ͷ����base64����", "��Կ", "ǰ�����ǩ��");
		return  Msg.success().add("body", succ);
	}
	
	@RequestMapping(value="/blockEnd/{fileId}/{blockNum}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBlockEnd(@PathVariable("fileId") Integer fileId,@PathVariable("blockNum") Integer blockNum,@RequestParam(value = "account")Integer account, HttpServletRequest request,HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");//����������Դ����
		response.addHeader("Access-Control-Allow-Methods","POST");//��Ӧ����	
		success_3_2 succ = new success_3_2("��ͷ����base64����", "��Կ", "ǰ�����ǩ��");
		return  Msg.success().add("body", succ);
	}
}
