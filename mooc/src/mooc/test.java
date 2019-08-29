package mooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//import bean.DataBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {

	// 读取url，返回json串；
	//java访问url,并返回json 字符串
	public static String getData(String addess) {
		// 请求的url
		URL url = null;
		// 建立http的连接
		HttpURLConnection httpConn = null;
		// 请求的输入流
		BufferedReader in = null;
		// 输入流的缓冲
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(addess);
			in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			String str = null;
			//一行一行 的进行读
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
		} finally {
			try {
				if (in != null) {

					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String data = sb.toString();
		return data;
	}

	// json串转化为json对象
	public static JSONObject getjson(String data) {
		JSONObject json = JSONObject.fromObject(data);
		return json;
	}

	public static void main(String[] args) {
		// DataBean d=new DataBean();
		// List l = new ArrayList();
		String url = "https://xxzx.365kaili.net/data/iot-live-data-history/yumi/num75/jl-cmcc/b94e5cb8593bf47fdbc66228387c116bd8b50b59";

		String json = getData(url);
		JSONObject jj = getjson(json);
//		System.out.println("url返回的json data：" + jj);
		JSONArray jsarr = jj.getJSONArray("data");// jsonobject对象取得some对应的jsonarray数组
//		System.out.println("jsonObject里面的jsonarray:\n" + jsarr + "\n");
		JSONObject ao = jsarr.getJSONObject(0);
		
		
		
		
		
		test_two test = new test_two();
		String ss = "123,34,80,65,82,34,58,34,50,48,48,46,48,49,34,44,34,83,111,105,108,104,117,109,105,100,105,116,121,50,34,58,34,51,53,46,50,56,34,44,34,76,105,103,104,116,73,110,116,101,110,115,105,116,121,34,58,34,49,48,48,49,46,50,57,34,44,34,87,105,110,100,83,112,101,101,100,34,58,34,56,46,48,55,34,44,34,69,118,97,112,111,114,97,116,105,111,110,34,58,34,51,46,54,54,34,44,34,80,114,101,115,115,117,114,101,34,58,34,49,46,49,48,34,44,34,82,101,99,101,118,105,101,68,97,116,101,34,58,34,50,48,49,57,45,48,51,45,50,49,84,49,51,58,53,53,58,53,51,34,44,34,65,105,114,72,117,109,105,100,105,116,121,34,58,34,56,50,46,57,56,34,44,34,83,117,110,115,104,105,110,101,84,105,109,101,34,58,34,49,49,46,50,50,34,44,34,65,105,114,84,101,109,112,101,114,97,116,117,114,101,34,58,34,45,50,46,54,57,34,44,34,82,97,105,110,70,97,108,108,34,58,34,48,46,49,34,44,34,83,111,105,108,104,117,109,105,100,105,116,121,49,34,58,34,51,51,46,48,49,34,44,34,77,111,110,105,116,111,114,78,117,109,34,58,34,110,117,109,55,53,34,44,34,87,105,110,100,68,105,114,101,99,116,105,111,110,34,58,34,49,52,34,44,34,83,111,105,108,84,101,109,112,101,114,97,116,117,114,101,50,34,58,34,50,46,50,57,34,44,34,83,111,105,108,84,101,109,112,101,114,97,116,117,114,101,49,34,58,34,49,46,53,53,34,125";
		test.execCurl(ss);
	}

}