package mooc;
import mooc.ListNode;
public class ListNode1 {

	public static void main(String args[]){
		ListNode l1 = new ListNode(2);
		l1.next =new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next= new ListNode(4);
		addTwoNumbers(l1,l2);
	}

	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	if (l1 ==null || l2==null){
	            return l1 == null ? l2:l1;
	        }
	        int value = l1.val + l2.val;
	        ListNode result = new ListNode(value %10);
	        //节点相加
	        result.next = addTwoNumbers(l1.next,l2.next);
	        //节点相加的结果和余数相加
	        if(value >=10){
	            result.next = addTwoNumbers(new ListNode(value /10),result.next);
	        }
	        return result;
	    }
	
}