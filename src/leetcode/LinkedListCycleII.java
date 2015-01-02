package leetcode;

/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Follow up:
 Can you solve it without using extra space? 
 */

import java.util.HashSet;

public class LinkedListCycleII {

}

class LinkedListCycleIISolution {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		HashSet<ListNode> set = new HashSet<ListNode>();
		set.add(head);
		while (fast.next != null && fast.next.next != null) {
			if (!set.add(slow.next))
				return slow.next;
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return null;
	}
}