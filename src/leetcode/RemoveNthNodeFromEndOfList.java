package leetcode;

/*
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 Given n will always be valid.
 Try to do this in one pass. 
 */

public class RemoveNthNodeFromEndOfList {

}

class RemoveNthNodeFromEndOfListSolution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 0;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			i++;
		}
		node = head;
		if (n == i)
			return head.next;
		else {
			for (int j = 1; j < i - n; j++) {
				node = node.next;
			}
			node.next = node.next.next;
		}
		return head;
	}
}