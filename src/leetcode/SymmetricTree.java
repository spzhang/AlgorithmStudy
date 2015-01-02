package leetcode;

/*
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3

 But the following is not:

 1
 / \
 2   2
 \   \
 3    3

 */
public class SymmetricTree {

}

class SymmetricTreeSolution {
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode a, TreeNode b) {
		if (a == null)
			return b == null;
		if (b == null)
			return false;

		if (a.val != b.val)
			return false;

		if (!isSymmetric(a.left, b.right))
			return false;
		if (!isSymmetric(a.right, b.left))
			return false;

		return true;
	}
}