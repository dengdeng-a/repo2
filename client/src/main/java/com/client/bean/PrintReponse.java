package com.client.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintReponse {

	//���õ��Ľ��ת����json���Ľṹ�����һ�ȡ��ǰ̨Ҫ���õĻص����������ҽ�json�����ص�����
	//���ִ�д�ӡ���ύҳ�棬��ҳ��ִ�лص������������صĴ�����json����ֵд����Ӧ��ҳ��Ԫ��ֵ��
	/*public static void printResult(HttpServletRequest request,
			HttpServletResponse response,Result rs) {
		response.setContentType("text/html;charset=utf-8");
		//��ȡĬ�ϵ�AJAX�ص�����
		String callback = request.getParameter("callback");// ��ûص�������callback��Ĭ�ϻص�������
		System.out.println("�ص�����������:"+callback);
		JSONObject jsonObject = JSONObject.fromObject(rs);// ��rs����ƴ��json��
	    //��Result�������ת����json���ĸ�ʽ
		System.out.println(jsonObject);
		String str = callback + "(" + jsonObject.toString() + ")";// ���ص���������json��(������ϵĽ��)���ӵ�һ��
		                                                        //Ŀ���ǽ�������ϵĽ�����ظ�ǰ̨ҳ���ajax�ĺ�����
		 //��������ϵĽ�� ��json������ʽ���ݸ��ص�����          //�����������jsonp���Ľ����ʾ���ߴ�ӡ�Ȳ�����
	    System.out.println("��󷵻صĺ�����ʽΪ��"+str);  
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(str);// ��str��ӡ��JSPҳ��
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
	}*/
}
