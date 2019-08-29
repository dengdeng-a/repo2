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
	 * 	ascii�ַ�תhex�ַ�
	 */
    public static String execCurl(String parm){
    	String[] cmds = {"curl","-H","Content-Type:application/json","-X","POST","-d","{\\\"str\\\":"+"\\\""+parm+"\\\"}",ur+"/char2hex"};
    	process = new ProcessBuilder(cmds);
    	all();
        System.out.println("ascii�ַ�תhex�ַ���"+builder); 
        String str = builder.toString().substring(0, builder.length()-3);
        sign(str);
        return builder.toString();
     }
    
    
    /**
     * ������ǩ��
     * @param cmds
     * @return
     */
    public static String sign(String parm){
    	//��ȡ��ǰϵͳʱ��
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	String time = df.format(System.currentTimeMillis()).replaceAll(" ", "T");
    	String before = "\"{\\\"trx\\\":{\\\"time_point\\\":\\\""+time+"\\\",\\\"data\\\":\\\"";
    	String after = "\\\",\\\"attach\\\":\\\"74686973206973207465737420617474616368\\\"},\\\"key\\\":\\\"5JYouEPmPwaFi6LoN3TS3S2ud8sL9UggJbEbAeP3cfxHd1u4mh1\\\"}\"";
    	String[] cmds = {"curl",ur+"/sign_trx","--data",before+parm+after};
        process = new ProcessBuilder(cmds);
        all();
        String str = builder.toString().substring(0, builder.length()-2);
        str = str.replace("\"", "\\\"");
        System.out.println("����ǩ����"+str);
        transaction(str);
        return builder.toString();
    }

    /**
     * ��������
     * @param parm
     * @return
     */
    public static String transaction(String parm){
    	//��ȡ��ǰϵͳʱ��
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	String time = df.format(System.currentTimeMillis()).replaceAll(" ", "T");
    	String before = "\"{\\\"time_point\\\":\\\""+time+"\\\",\\\"data\\\":\\\"";
    	String after = "\\\",\\\"attach\\\":\\\"74686973206973207465737420617474616368\\\"},\\\"key\\\":\\\"5JYouEPmPwaFi6LoN3TS3S2ud8sL9UggJbEbAeP3cfxHd1u4mh1\\\"}\"";
    	String[] cmds = {"curl",ur+"/push_transaction","--data","\""+parm+"\""};
        process = new ProcessBuilder(cmds);
        all();
        System.out.println("transaction json��"+builder);
//        publish();
        return builder.toString();
    }
    
    /**
     * ���״������
     * @return
     */
    public static String publish(){
    	String[] cmds = {"curl",ur+"/publish_blk"};
        process = new ProcessBuilder(cmds);
        all();
        System.out.println("���״��������"+builder);
        return builder.toString();
    }  
    /**
     * ��ȡ�ķ���
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
