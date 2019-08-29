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
            }else{      //map�в����ڵ�ǰ�ַ�       
                if((i-now+1) > maxLength){ //������ִ��ĳ���  
                    maxLength = i-now+1;  
                }                    
            }                
            map.put(s.charAt(i), i);//�޸ĵ�ǰ�ַ���value����¼����λ��     
        }  
        return maxLength;  
    }
}
