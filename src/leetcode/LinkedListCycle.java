package leetcode;

/*
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space? 
 */
public class LinkedListCycle {

}

class LinkedListCycleSolution {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {

		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		if (fast.next != fast && fast.next != null)
			fast = fast.next;

		while (fast.next != null && fast.next.next != null) {
			if (fast == slow)
				return true;
			fast = fast.next.next;
			if (slow.next != null)
				slow = slow.next;
		}

		return false;

	}
}