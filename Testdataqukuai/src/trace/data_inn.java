package trace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class data_inn {

	public static ProcessBuilder process;
    public static Process p;
    public static StringBuilder builder;
    public static String publicKey=null;
    public static StringBuilder head_block_num=null;
    public static StringBuilder chain_id=null;
    public static String head_block_time=null;
    public static String head_block_time1=null;
    public static StringBuilder ref_block_prefix=null;
    public static StringBuilder binargs=null;
    public static String required_keys=null;
    public static String signatures=null;
    public static String firstData=null;

    
    /**
     * 1.钱包解锁
     * @param parm
     * @return
     */
    public static StringBuilder walletUnlock(String ur,String port1,String port2,String user,String userid,String actor){
    	String parm = "\"[\\\"default\\\",\\\"PW5JDSeMeHEWfjefffepMaqB13krDK6Tw5z7tNHL9jPTyjaGH5WbA\\\"]\"";
    	String[] cmds = {"curl",ur+":"+port1+"/v1/wallet/unlock","-d"," "+parm};
        process = new ProcessBuilder(cmds);
        all();
        getPublicKey(ur,port1,port2,user,userid,actor);
        return builder;
    }
	
    /**
     *2、获取钱包中可用公钥
     * @return
     */
    public static StringBuilder getPublicKey(String ur,String port1,String port2,String user,String userid,String actor){
    	String[] cmds = {"curl",ur+":"+port1+"/v1/wallet/get_public_keys"};
        process = new ProcessBuilder(cmds);
        all();
        System.out.println("2.得到返回公钥："+builder);
        //未经处理的publickey
        String publicKey1 = builder.toString();
        //对“”进行处理的publickey
        publicKey = publicKey1.replaceAll("\"", "\\\\\"");
        getInfo(ur,port1,port2,user,userid,actor);
        return builder;
    } 
     
    /**
     * 3.获取区块信息
     * @return
     */
    public static StringBuilder getInfo(String ur,String port1,String port2,String user,String userid,String actor) {
    	String[] cmds = {"curl",ur+":"+port2+"/v1/chain/get_info"};
    	process = new ProcessBuilder(cmds);
        all();
        System.out.println("3.区块信息："+builder);
        // json字符串转化为json对象jsonObject
        JSONObject jsonObject  = JSONObject.fromObject(builder.toString());
        head_block_num = new StringBuilder(jsonObject.getString("head_block_num"));
        chain_id = new StringBuilder(jsonObject.getString("chain_id"));
        head_block_time = jsonObject.getString("head_block_time"); 
        head_block_time1 = head_block_time.replaceAll("T", " ");
        getBlockInfo(ur,port1,port2,user,userid,actor);
        return builder;
	}
    
    /**
     * 4.获得区块详细信息
     * @return
     */
    public static StringBuilder getBlockInfo(String ur,String port1,String port2,String user,String userid,String actor) {
    	String pram = "\"{\\\"block_num_or_id\\\":\\\""+head_block_num+"\\\"}\"";
    	String[] cmds = {"curl",ur+":"+port2+"/v1/chain/get_block","-d",pram};
    	process = new ProcessBuilder(cmds);
        all();
        System.out.println("4.区块详细信息："+builder);
        // json字符串转化为json对象jsonObject
        JSONObject jsonObject  = JSONObject.fromObject(builder.toString());
        ref_block_prefix = new StringBuilder(jsonObject.getString("ref_block_prefix"));
        getInternetData(ur,port1,port2,user,userid,actor);
        return builder;
	}
    /**
     * 5.获得物联网的第一个数据
     * @return
     */
    public static StringBuilder getInternetData(String ur,String port1,String port2,String user,String userid,String actor) {
    	String[] cmds = {"curl","https://xxzx.365kaili.net/data/iot-live-data-history/yumi/num75/jl-cmcc/b94e5cb8593bf47fdbc66228387c116bd8b50b59"};
    	process = new ProcessBuilder(cmds);
        all();
        System.out.println("5.物联网数据："+builder);
        // json字符串转化为json对象jsonObject
        JSONObject jsonObject  = JSONObject.fromObject(builder.toString());
        // jsonObject获取JSONArray  data里面的数组
        JSONArray dat=jsonObject.getJSONArray("data");
        //获取JSONArray  data里面的第一条数据
        JSONObject firstData1=dat.getJSONObject(0);
	    String zhuanao=firstData1.toString();		   
	    firstData= zhuanao.trim();
        abiJsonToBin(ur,port1,port2,user,userid,actor);
        return builder;
	}
    
    /**
     * 6.将交易转换成二进制
     * @return
     */
    public static StringBuilder abiJsonToBin(String ur,String port1,String port2,String user,String userid,String actor){
    	String parm = "\"{\\\"code\\\":\\\"trace\\\",\\\"action\\\":\\\"insert\\\",\\\"args\\\":{\\\"user\\\":\\\""+user+"\\\",\\\"userid\\\":\\\""+userid+"\\\",\\\"time_point\\\":\\\""+head_block_time+"\\\",\\\"data\\\":\\\""+firstData+"\\\",\\\"attach\\\":\\\"\\\"}}\"";
    	String[] cmds = {"curl","-s",ur+":"+port2+"/v1/chain/abi_json_to_bin","-X","POST","-d",parm};
    	process = new ProcessBuilder(cmds);
    	all();
        System.out.println("6.交易转换成二进制："+builder.toString()); 
     // json字符串转化为json对象jsonObject
        JSONObject jsonObject  = JSONObject.fromObject(builder.toString());
        binargs = new StringBuilder(jsonObject.getString("binargs"));
        getRequiredKeys(ur,port1,port2,user,userid,actor);
        return builder;
    }
    
    /**
     * 7.获得账户可用公钥
     * @return
     */
	 public static StringBuilder getRequiredKeys(String ur,String port1,String port2,String user,String userid,String actor) {
		String pram = "\"{\\\"available_keys\\\":"+publicKey+",\\\"transaction\\\":{\\\"actions\\\":[{\\\"account\\\":\\\"trace\\\",\\\"authorization\\\":[{\\\"actor\\\":\\\""+actor+"\\\",\\\"permission\\\":\\\"active\\\"}],\\\"data\\\":\\\""+binargs+"\\\"\\\"name\\\":\\\"insert\\\"}],\\\"context_free_actions\\\":[],\\\"context_free_data\\\":[],\\\"delay_sec\\\":0,\\\"expiration\\\":\\\""+head_block_time+"\\\",\\\"max_kcpu_usage\\\":0,\\\"max_net_usage_words\\\":0,\\\"ref_block_num\\\":\\\""+head_block_num+"\\\",\\\"ref_block_prefix\\\":\\\""+ref_block_prefix+"\\\",\\\"signatures\\\":[]}}\"";
		String[] cmds = {"curl",ur+":"+port2+"/v1/chain/get_required_keys","-d",pram};
    	process = new ProcessBuilder(cmds);
    	all();
        System.out.println("7.获得账户可用公钥："+builder); 
     // json字符串转化为json对象jsonObject
        JSONObject jsonObject  = JSONObject.fromObject(builder.toString());
        String required_keys1 = jsonObject.getString("required_keys");
        required_keys = required_keys1.replaceAll("\"", "\\\\\"");
        signTransaction(ur,port1,port2,user,userid,actor);
        return builder;
	  }
	 
	 /**
	  * 8.给交易签名
	  * @return
	  */
	 public static StringBuilder signTransaction(String ur,String port1,String port2,String user,String userid,String actor){
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	Date date = null;
		try {
			date = formatter.parse(head_block_time1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	long time=date.getTime()+20000; //这是毫秒数
    	//获取String类型的时间
        String createdate = formatter.format(time);
        createdate = createdate.replaceAll(" ", "T");
	    String parm = " \"[{\\\"ref_block_num\\\":\\\""+head_block_num+"\\\",\\\"ref_block_prefix\\\":\\\""+ref_block_prefix+"\\\",\\\"expiration\\\":\\\""+createdate+"\\\",\\\"actions\\\":[{\\\"account\\\":\\\"trace\\\",\\\"name\\\":\\\"insert\\\",\\\"authorization\\\":[{\\\"actor\\\":\\\""+actor+"\\\",\\\"permission\\\":\\\"active\\\"}],\\\"data\\\":\\\""+binargs+"\\\"}],\\\"signatures\\\":[]},"+required_keys+",\\\""+chain_id+"\\\"]\"";
	    String[] cmds = {"curl",ur+":"+port1+"/v1/wallet/sign_transaction","-d",parm};
    	process = new ProcessBuilder(cmds);
    	all();
        System.out.println("8.给交易签名："+builder); 
        // json字符串转化为json对象jsonObject
        JSONObject jsonObject  = JSONObject.fromObject(builder.toString());
        String signatures1 = jsonObject.getString("signatures");
        signatures = signatures1.replaceAll("\"", "\\\\\"");
        pushTransaction(ur,port1,port2,user,userid,actor);
        return builder;
	 }
	 
	 /**
	  * 9.提交交易
	  * @return
	 * @throws ParseException 
	  */
	 public static StringBuilder pushTransaction(String ur,String port1,String port2,String user,String userid,String actor) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	Date date = null;
		try {
			date = formatter.parse(head_block_time1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	long time=date.getTime()+20000; //这是毫秒数
    	//获取String类型的时间
        String createdate = formatter.format(time);
        createdate = createdate.replaceAll(" ", "T");
	    String parm = "\"{\\\"compression\\\":\\\"none\\\",\\\"transaction\\\":{\\\"expiration\\\":\\\""+createdate+"\\\",\\\"ref_block_num\\\":\\\""+head_block_num+"\\\",\\\"ref_block_prefix\\\":\\\""+ref_block_prefix+"\\\",\\\"context_free_actions\\\":[],\\\"actions\\\":[{\\\"account\\\":\\\"trace\\\",\\\"name\\\":\\\"insert\\\",\\\"authorization\\\":[{\\\"actor\\\":\\\""+actor+"\\\",\\\"permission\\\":\\\"active\\\"}],\\\"data\\\":\\\""+binargs+"\\\"}],\\\"transaction_extensions\\\":[]},\\\"signatures\\\":"+signatures+"}\"";
	    String[] cmds = {"curl","-s",ur+":"+port2+"/v1/chain/push_transaction","-d",parm};
	    process = new ProcessBuilder(cmds);
    	all();
        System.out.println("9.提交交易："+builder); 
        return builder;
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
     
    public static void main(String[] args) throws ParseException { 
    	String ur = System.getProperty("url");
    	String port1 = System.getProperty("port1");
    	String port2 = System.getProperty("port2");
    	String user = System.getProperty("user");
    	String userid = System.getProperty("userid");
    	String actor = System.getProperty("actor");
    	walletUnlock(ur,port1,port2,user,userid,actor);
    	
	}
	
}
