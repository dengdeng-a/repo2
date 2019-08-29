package com.scxz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping
public class FileController {

	/*
	 * ����һ�ļ��ϴ�
	 */
	
	 @RequestMapping("/onefile")  
	    public String oneFileUpload(  
	            @RequestParam("file") CommonsMultipartFile file,  
	            HttpServletRequest request, ModelMap model) {  
	        // ���ԭʼ�ļ���  
	        String fileName = file.getOriginalFilename();  
	        System.out.println("ԭʼ�ļ���:" + fileName);  
	        // ���ļ���  
	        String newFileName = UUID.randomUUID() + fileName;  
	  
	        // �����Ŀ��·��  
	        ServletContext sc = request.getSession().getServletContext();  
	        // �ϴ�λ��  
	        String path = sc.getRealPath("/img") + "/"; // �趨�ļ������Ŀ¼  
	  
	        File f = new File(path);  
	        if (!f.exists())  
	            f.mkdirs();  
	        if (!file.isEmpty()) {  
	            try {  
	                FileOutputStream fos = new FileOutputStream(path + newFileName);  
	                InputStream in = file.getInputStream();  
	                int b = 0;  
	                while ((b = in.read()) != -1) {  
	                    fos.write(b);  
	                }  
	                fos.close();  
	                in.close();  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	  
	        System.out.println("�ϴ�ͼƬ��:" + path + newFileName);  
	        // �����ļ���ַ������JSPҳ�����  
	        model.addAttribute("fileUrl", path + newFileName);  
	        return "fileUpload";  
	    }  
	  
	    /** 
	     * �������ϴ��ļ���һ��һ�� 
	     */  
	    @RequestMapping("/onefile2")  
	    public String oneFileUpload2(HttpServletRequest request,HttpServletResponse response) throws Exception {  
	        CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());  
	        if (cmr.isMultipart(request)) {  
	            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);  
	            Iterator<String> files = mRequest.getFileNames();  
	            while (files.hasNext()) {  
	                MultipartFile mFile = mRequest.getFile(files.next());  
	                if (mFile != null) {  
	                    String fileName = UUID.randomUUID()  
	                            + mFile.getOriginalFilename();  
	                    String path = "d:/upload/" + fileName;  
	  
	                    File localFile = new File(path);  
	                    mFile.transferTo(localFile);  
	                    request.setAttribute("fileUrl", path);  
	                }  
	            }  
	        }  
	        return "fileUpload";  
	    }  
	    
	    
	}  
