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
        
        // ��ȡԭʼjson�ļ������в��������  
        try {  
            BufferedReader br = new BufferedReader(new FileReader(  
                    "D:/workspace1/mooc/src/tracing.json"));// ��ȡԭʼjson�ļ�  
     
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