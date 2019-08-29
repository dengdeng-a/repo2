package mooc;

import java.util.HashMap;
import java.util.Map;

public class ListNode {
	int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    
    public int lengthOfLongestSubstring(String s) {
    	Map<Character,Integer>  map = new HashMap<Character,Integer>();        
        int maxLength = 0;  
        int now = 0;                  
        for(int i=0; i<s.length(); i++ ){                
            if(map.containsKey(s.charAt(i))){
                now = Math.max(now, map.get(s.charAt(i))+1);
                if((i-now+1) > maxLength){  
                    maxLength = i-now+1;  
                }                    
            }else{      //map中不存在当前字符       
                if((i-now+1) > maxLength){ //更新最长字串的长度  
                    maxLength = i-now+1;  
                }                    
            }                
            map.put(s.charAt(i), i);//修改当前字符的value，记录最新位置     
        }  
        return maxLength;  
    }
}
