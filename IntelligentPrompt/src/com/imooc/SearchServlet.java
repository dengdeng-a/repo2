package com.imooc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SearchServlet
 */

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	static List<String> datas = new ArrayList<String>();
	static {
		//��Щ��ģ������
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("becky");
		datas.add("bill");
		datas.add("james");
		datas.add("jerry");
		datas.add("��");
		datas.add("���");
		datas.add("�����");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("123");
		//���Ȼ�ÿͻ��˷��͹���������keyword
		String keyword =request.getParameter("keyword");
		//��ùؼ���֮����д����õ���������
		List<String> listData =getData(keyword);
		//����json��ʽ
		System.out.println(JSONArray.fromObject(listData).toString());
		response.getWriter().write(JSONArray.fromObject(listData).toString());
	}

	//��ù������ݵķ���
	public List<String> getData(String keyword){
		List<String> list =new ArrayList<String>();
		for (String data :datas){
			if (data.contains(keyword)) {
				list.add(data);
			}
		}
		return list;
	}
}
