package leetcode;

/*
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 */

import java.util.List;

public class MergeKSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		int n = lists.size();
		if (lists == null || n == 0)
			return null;
		if (n == 1)
			return lists.get(0);
		if (n == 2)
			return merge(lists.get(0), lists.get(1));
		int i = 1;
		int j = 2;
		while (j + 1 < n && j + 2 < n) {
			i = i + 1;
			j = j + 2;
		}
		return merge(mergeKLists(lists.subList(0, i + 1)),
				mergeKLists(lists.subList(i + 1, n)));
	}

	ListNode merge(ListNode list1, ListNode list2) {
		ListNode cur = new ListNode(0);
		ListNode hd = cur;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cur.next = list1;
				cur = cur.next;
				list1 = list1.next;
			} else {
				cur.next = list2;
				cur = cur.next;
				list2 = list2.next;
			}
		}

		if (list1 != null)
			cur.next = list1;
		if (list2 != null)
			cur.next = list2;

		return hd.next;
	}
}