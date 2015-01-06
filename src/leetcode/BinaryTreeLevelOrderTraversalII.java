package leetcode;

/*
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7

 return its bottom-up level order traversal as:

 [
 [15,7],
 [9,20],
 [3]
 ]

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

}

class BinaryTreeLevelOrderTraversalIISolution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (null == root)
			return result;
		build(root, result, 1);
		Collections.reverse(result);
		return result;

	}

	void build(TreeNode node, List<List<Integer>> result, int lvl) {
		if (node == null)
			return;
		if (lvl > result.size()) {
			LinkedList<Integer> lvlResult = new LinkedList<Integer>();
			result.add(lvlResult);
		}
		result.get(lvl - 1).add(node.val);
		build(node.left, result, lvl + 1);
		build(node.right, result, lvl + 1);

	}
}