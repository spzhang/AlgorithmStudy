package leetcode;

/*
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 */
public class MergeTwoSortedLists {

}

class MergeTwoSortedListsSolution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			ListNode node;
			if (l1.val <= l2.val) {
				node = new ListNode(l1.val);
				merge(l1.next, l2, node);
			} else {
				node = new ListNode(l2.val);
				merge(l1, l2.next, node);
			}
			return node;

		}
	}

	void merge(ListNode l1, ListNode l2, ListNode root) {
		if (l1 == null) {
			while (l2 != null) {
				ListNode node = new ListNode(l2.val);
				root.next = node;
				root = node;
				l2 = l2.next;
			}
		} else if (l2 == null) {
			while (l1 != null) {
				ListNode node = new ListNode(l1.val);
				root.next = node;
				root = node;
				l1 = l1.next;
			}
		} else {
			if (l1.val <= l2.val) {
				ListNode node = new ListNode(l1.val);
				root.next = node;
				merge(l1.next, l2, node);
			} else {
				ListNode node = new ListNode(l2.val);
				root.next = node;
				merge(l1, l2.next, node);
			}
		}
	}

}