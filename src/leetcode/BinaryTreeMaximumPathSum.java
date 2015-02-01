package leetcode;

/*
 Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 1
 / \
 2   3

 Return 6. 
 */

public class BinaryTreeMaximumPathSum {

}

class BinaryTreeMaximumPathSumSolution {
	int maxValue;

	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));		//get left side max branch
		int right = Math.max(0, maxPathDown(node.right));	//get right side max branch
		maxValue = Math.max(maxValue, left + right + node.val);	//compare to max value and update
		return Math.max(left, right) + node.val;			//only return max to upper level.
	}
}