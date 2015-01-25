import java.util.Stack;


public class Solution {

	public static void main(String[] args) {
		//test
		
		Stack<Integer> s1 = new Stack<Integer>();
		
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null & l2==null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int curval, shift = 0;
        ListNode cur, pre, result;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        curval = cur1.val + cur2.val;
        if(curval > 10){
            shift = 1;
            curval = curval - 10;
        }
        result = new ListNode(curval);
        pre = result;
        cur1 = cur1.next;
        cur2 = cur2.next;
        
        while(cur1 != null && cur2 != null){
            curval = cur1.val + cur2.val + shift;
            if(curval > 10){
                shift = 1;
                curval = curval - 10;
            }
            else{ shift = 0; };
            cur = new ListNode(curval);
            pre.next = cur;
            pre = cur;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        while(cur1 != null){
            curval = cur1.val + shift;
            if(curval > 10){
                shift = 1;
                curval = curval - 10;
            }
            else{ shift = 0;};
            cur = new ListNode(curval);
            pre.next = cur;
            pre = cur;
            cur1 = cur1.next;
        }
        
        while(cur2 != null){
            curval = cur2.val + shift;
            if(curval > 10){
                shift = 1;
                curval = curval - 10;
            }
            else{ shift = 0;};
            cur = new ListNode(curval);
            pre.next = cur;
            pre = cur;
            cur2 = cur2.next;
        }
        
        return result;
        
    }
}
