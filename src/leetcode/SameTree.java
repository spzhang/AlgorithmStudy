package leetcode;

/*
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 */

public class SameTree {

}

class SameTreeSolution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (null == p && null == q)
			return true;
		if (null == p && null != q)
			return false;
		if (null != p && null == q)
			return false;
		boolean value = (p.val == q.val);
		boolean left = true;
		boolean right = true;
		left = isSameTree(p.left, q.left);
		right = isSameTree(p.right, q.right);
		return value && left && right;
	}

}
