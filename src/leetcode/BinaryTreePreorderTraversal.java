package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
 \
 2
 /
 3

 return [1,2,3]. 

 */

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		return list;

	}

	public void visit(TreeNode node, List<Integer> list) {
		list.add(node.val);
		if (null != node.left) {
			visit(node.left, list);
		}
		if (null != node.right) {
			visit(node.right, list);
		}

	}
}

class BinaryTreePreorderTraversalSolution {


}