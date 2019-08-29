package com.qw.chain.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class PrintReponseUname {
	//将得到的结果转换成json串的结构，并且获取到前台要调用的回调函数，并且将json串给回调函数
			//最后执行打印回提交页面，在页面执行回调函数，将带回的处理结果json串的值写到相应的页面元素值中
			public static void printResult(HttpServletRequest request,
					HttpServletResponse response,Messages ms) {
				response.setContentType("text/html;charset=utf-8");
				//获取默认的AJAX回调函数
				String callback = request.getParameter("c");// 获得回调函数名callback是默认回调函数名
				System.out.println("回调函数方法名:"+callback);
				JSONObject jsonObject = JSONObject.fromObject(ms);// 将rs对象拼成json串
			    //将Result这个对象转换成json串的格式
				System.out.println(jsonObject);
				String str = callback + "(" + jsonObject.toString() + ")";// 将回调函数名和json串(处理完毕的结果)连接到一起
				                                                        //目的是将处理完毕的结果返回给前台页面的ajax的函数，
				 //将处理完毕的结果 以json串的形式传递给回调函数          //由这个函数将jsonp串的结果显示或者打印等操作。
			    System.out.println("最后返回的函数格式为："+str);  
				PrintWriter writer = null;
				try {
					writer = response.getWriter();
					writer.write(str);// 将str打印到JSP页面
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					writer.flush();
					writer.close();
				}
			}
}
