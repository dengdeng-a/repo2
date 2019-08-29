package mooc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class work {
	
	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
        
        // 读取原始json文件并进行操作和输出  
        try {  
            BufferedReader br = new BufferedReader(new FileReader(  
                    "D:/workspace1/mooc/src/tracing.json"));// 读取原始json文件  
     
            String s = null, ws = null;  
            while ((s = br.readLine()) != null) {  
                  
                String string = s.toString();
/*                for (int i = 0; i < string.length(); i++) {
					if ((string.charAt(i)=='}'||string.charAt(i)=='{')&&string.charAt(i-1)=='"') {
						
					}
				}*/
                System.out.println(s);
            }  
    
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
    }  
}