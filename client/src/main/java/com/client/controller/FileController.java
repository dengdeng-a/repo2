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
		
		//����maps
		for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key: " + key + " value: " + value);
		}
		success1 succ = new success1("��ǰ�ϴ��ļ��ļ۸�ϵͳ���ܸ���ʵ����������۸�","��ǰ�۸���γ�ԭ��","�����ϴ�����","��ʽ�ȱ��λ���˵��������","�����ϴ�ͨ����Կ", "��Կ��Ч��","���ܷ�ʽ��ϵͳԤ����ֵ�����������","�洢�ڵ�ip/port","��Կ","ǰ�����ǩ��");
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
		//����maps
		for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key: " + key + " value: " + value);
		}
		
		//�ļ��ϴ�
		/*
		//˵�������������Ϣ����UTF-8���뷽ʽ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//Servlet3.0��������ķ�������������multipart/form-data���ͱ���ı�
		Part part = request.getPart("file");
		//��ȡHTTPͷ��ϢheaderInfo=��form-data; name="file" filename="�ļ���"��
		String headerInfo = part.getHeader("content-disposition");
		System.out.println("��ȡHTTPͷ��ϢheaderInfo"+headerInfo);
		//��HTTPͷ��Ϣ�л�ȡ�ļ���fileName=���ļ�����
		String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
		System.out.println("��HTTPͷ��Ϣ�л�ȡ�ļ���"+fileName);
		//��ô洢�ϴ��ļ����ļ���·��
		String fileSavingFolder = request.getServletContext().getRealPath("/UploadServlet");
		System.out.println("��ô洢�ϴ��ļ����ļ���·��"+fileSavingFolder);
		//��ô洢�ϴ��ļ�������·�����ļ���·��+�ļ�����
		//�ļ���λ�ù̶����ļ��в������ϴ��ļ���ԭʼ������ͬ
		String fileSavingPath = fileSavingFolder + File.separator + fileName;
		System.out.println(fileSavingPath);
		//����洢�ϴ��ļ����ļ��в����ڣ��򴴽��ļ���
		File f = new File(fileSavingFolder + File.separator);
		if(!f.exists()){
			f.mkdirs();
		}
		//���ϴ����ļ�����д��������ļ���
		part.write(fileSavingPath);
		//����ϴ��ɹ���Ϣ
		//out.println("�ļ��ϴ��ɹ�~��");
*/		//success2 succ = new success2("�ɹ�");
		return  Msg.success();
	}
	
	/*
	 * 3.URI��http://{serviceNode}/client/file?account=���û�Ǯ����ַ��&batch=����ҳ��С ��&page=���ڼ�ҳ��
	 */
	
	@RequestMapping(value="/file",method=RequestMethod.GET)
	@ResponseBody
	public Msg FileList(@RequestParam(value = "account") Integer account,@RequestParam(value = "batch") Integer batch, @RequestParam(value = "page") Integer page,HttpServletRequest request){
		success3 suc= new success3("�ļ�sha256ֵ", "�ļ���", "�ļ���С���ֽ�", "�ļ����", "�ļ���ǩ");
	/*	List<success3> list = new ArrayList<success3>();
		list.add(suc.getFileId())*/
		success1 succ = new success1("��ǰ�ϴ��ļ��ļ۸�ϵͳ���ܸ���ʵ����������۸�","��ǰ�۸���γ�ԭ��","�����ϴ�����","��ʽ�ȱ��λ���˵��������","�����ϴ�ͨ����Կ", "��Կ��Ч��","���ܷ�ʽ��ϵͳԤ����ֵ�����������","�洢�ڵ�ip/port","��Կ","ǰ�����ǩ��");
		return  Msg.success().add("fileList", suc);
	}
	
	/*
	 * 4.
	 */
	
	@RequestMapping(value="/file/{fileId}",method=RequestMethod.GET)
	@ResponseBody
	public Msg FileGet(@PathVariable("fileId") Integer fileId, HttpServletRequest request){
		success3 suc= new success3("�ļ�sha256ֵ", "�ļ���", "�ļ���С���ֽ�", "�ļ����", "�ļ���ǩ");
	/*	List<success3> list = new ArrayList<success3>();
		list.add(suc.getFileId())*/
		//success1 succ = new success1("��ǰ�ϴ��ļ��ļ۸�ϵͳ���ܸ���ʵ����������۸�","��ǰ�۸���γ�ԭ��","�����ϴ�����","��ʽ�ȱ��λ���˵��������","�����ϴ�ͨ����Կ", "��Կ��Ч��","���ܷ�ʽ��ϵͳԤ����ֵ�����������","�洢�ڵ�ip/port","��Կ","ǰ�����ǩ��");
		return  Msg.success().add("fileList", suc);
	}
	
	/*
	 * 5.
	 */
	@RequestMapping(value="/file/{fileId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg FileUpdate(@PathVariable("fileId") Integer fileId,@RequestParam(value = "account") Integer account, HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		response.addHeader("Access-Control-Allow-Origin","*");//����������Դ����
		response.addHeader("Access-Control-Allow-Methods","PUT");//��Ӧ����
		
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
		success3 suc= new success3("�ļ�sha256ֵ", "�ļ���", "�ļ���С���ֽ�", "�ļ����", "�ļ���ǩ");
			List<success3> list = new ArrayList<success3>();
			return  Msg.success().add("fileList", suc);
		}
	
	
	
}


