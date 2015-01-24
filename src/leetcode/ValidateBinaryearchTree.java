package leetcode;

/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 */

public class ValidateBinaryearchTree {

}

class ValidateBinaryearchTreeSolution {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		boolean leftCheck;
		boolean rightCheck;
		if (root.left == null) {
			leftCheck = true;
		} else {
			if (root.val <= root.left.val || root.left.val < min
					&& min != Integer.MIN_VALUE)
				leftCheck = false;
			else
				leftCheck = isValidBST(root.left, min, root.val - 1);
		}

		if (root.right == null) {
			rightCheck = true;
		} else {
			if (root.val >= root.right.val || root.right.val > max
					&& max != Integer.MAX_VALUE)
				rightCheck = false;
			else
				rightCheck = isValidBST(root.right, root.val + 1, max);
		}

		return leftCheck & rightCheck;
	}

}