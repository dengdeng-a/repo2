package mooc;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import org.apache.commons.collections.map.StaticBucketMap;
import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;
import org.omg.CORBA.PUBLIC_MEMBER;
import net.sf.json.JSONObject;


public class test_two {
	public static String ur = "http://192.168.1.117:8888/v1/chain";
	public static ProcessBuilder process;
    public static  Process p;
    public static StringBuilder builder;
    
    
	/*
	 * 	ascii字符转hex字符
	 */
    public static String execCurl(String parm){
    	String[] cmds = {"curl","-H","Content-Type:application/json","-X","POST","-d","{\\\"str\\\":"+"\\\""+parm+"\\\"}",ur+"/char2hex"};
    	process = new ProcessBuilder(cmds);
    	all();
        System.out.println("ascii字符转hex字符："+builder); 
        String str = builder.toString().substring(0, builder.length()-3);
        sign(str);
        return builder.toString();
     }
    
    
    /**
     * 给交易签名
     * @param cmds
     * @return
     */
    public static String sign(String parm){
    	//获取当前系统时间
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	String time = df.format(System.currentTimeMillis()).replaceAll(" ", "T");
    	String before = "\"{\\\"trx\\\":{\\\"time_point\\\":\\\""+time+"\\\",\\\"data\\\":\\\"";
    	String after = "\\\",\\\"attach\\\":\\\"74686973206973207465737420617474616368\\\"},\\\"key\\\":\\\"5JYouEPmPwaFi6LoN3TS3S2ud8sL9UggJbEbAeP3cfxHd1u4mh1\\\"}\"";
    	String[] cmds = {"curl",ur+"/sign_trx","--data",before+parm+after};
        process = new ProcessBuilder(cmds);
        all();
        String str = builder.toString().substring(0, builder.length()-2);
        str = str.replace("\"", "\\\"");
        System.out.println("交易签名："+str);
        transaction(str);
        return builder.toString();
    }

    /**
     * 发布交易
     * @param parm
     * @return
     */
    public static String transaction(String parm){
    	//获取当前系统时间
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	String time = df.format(System.currentTimeMillis()).replaceAll(" ", "T");
    	String before = "\"{\\\"time_point\\\":\\\""+time+"\\\",\\\"data\\\":\\\"";
    	String after = "\\\",\\\"attach\\\":\\\"74686973206973207465737420617474616368\\\"},\\\"key\\\":\\\"5JYouEPmPwaFi6LoN3TS3S2ud8sL9UggJbEbAeP3cfxHd1u4mh1\\\"}\"";
    	String[] cmds = {"curl",ur+"/push_transaction","--data","\""+parm+"\""};
        process = new ProcessBuilder(cmds);
        all();
        System.out.println("transaction json："+builder);
//        publish();
        return builder.toString();
    }
    
    /**
     * 交易打包上链
     * @return
     */
    public static String publish(){
    	String[] cmds = {"curl",ur+"/publish_blk"};
        process = new ProcessBuilder(cmds);
        all();
        System.out.println("交易打包上链："+builder);
        return builder.toString();
    }  
    /**
     * 抽取的方法
     * @return
     */
    public static String all(){
    	try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        builder = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            builder.append(line);
	            builder.append(System.getProperty("line.separator"));
	        }
	        return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
}
