import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode aa = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		b.left = a;
		a.left = aa;
		b.right = c;
		Solution s = new Solution();
		s.flatten(b);
		System.out.println(a);
	}

	public void flatten(TreeNode root) {

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if (root == null)
			return;
		inorder(list, root);
		int n = list.size();
		root = list.remove();
		TreeNode pre = root;
		for (int i = 1; i < n; i++) {
			TreeNode cur = list.remove();
			pre.right = cur;
			pre = cur;
		}

	}

	void inorder(List<TreeNode> list, TreeNode node) {
		if (node.left != null) {
			inorder(list, node.left);
		}
		list.add(node);
		if (node.right != null) {
			inorder(list, node.right);
		}

	}
}