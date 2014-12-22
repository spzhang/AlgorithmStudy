package algorithm;


public class Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Math.ceil((2 + 3) / 2.0));

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
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
				merge(l1.next, l2, node);
			} else {
				ListNode node = new ListNode(l2.val);
				merge(l1, l2.next, node);
			}
		}
	}

}
