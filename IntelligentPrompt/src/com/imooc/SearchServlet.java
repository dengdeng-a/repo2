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
		//这些是模拟数据
		datas.add("ajax");
		datas.add("ajax post");
		datas.add("becky");
		datas.add("bill");
		datas.add("james");
		datas.add("jerry");
		datas.add("你");
		datas.add("你好");
		datas.add("你真好");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("123");
		//首先获得客户端发送过来的数据keyword
		String keyword =request.getParameter("keyword");
		//获得关键字之后进行处理，得到关联数据
		List<String> listData =getData(keyword);
		//返回json格式
		System.out.println(JSONArray.fromObject(listData).toString());
		response.getWriter().write(JSONArray.fromObject(listData).toString());
	}

	//获得关联数据的方法
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
