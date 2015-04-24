package leetcode;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (k == 0)
			return head;

		ListNode cur = head;
		int count = 1;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		}
		cur.next = head;  //point tail to head
		k = k % count;		
		// count total

		cur = head;
		int i = 1;
		int j = count - k;
		while (i < j) {
			cur = cur.next;
			i++;
		}

		ListNode result = cur.next;
		cur.next = null;
		return result;
	}
}

// 统计 取余 重连
