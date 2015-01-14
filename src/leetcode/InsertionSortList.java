package leetcode;

/*
 Sort a linked list using insertion sort.
 */
public class InsertionSortList {

}

class InsertionSortListSolution {
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode cur = head, pre = null;
		int count = 1;
		while (true) {
			cur = head;
			for (int i = 0; i < count; i++) {
				pre = cur;
				cur = cur.next;
			}
			if (cur == null)
				break;
			ListNode node = head;
			ListNode nodepre = null;
			for (int i = 0; i < count; i++) {
				if (cur.val <= node.val) {
					if (node == head) {
						pre.next = cur.next;
						cur.next = head;
						head = cur;
						break;
					} else {
						pre.next = cur.next;
						nodepre.next = cur;
						cur.next = node;
						break;
					}
				}
				nodepre = node;
				node = node.next;
			}
			count++;
		}

		return head;
	}
}