package leetcode;

import java.util.LinkedList;

/*
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {

}

class SimplifyPathSolution {
	public String simplifyPath(String path) {
		StringBuffer sb = new StringBuffer();
		LinkedList<String> stack = new LinkedList<String>();
		for (char c : path.toCharArray()) {
			if (c == '/') {
				if (sb.toString().equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else if (!sb.toString().equals(".") && sb.length() != 0) {
					stack.push(sb.toString());
				}
				sb = new StringBuffer();
			} else {
				sb.append(c);
			}
		}
		if (sb.toString().equals("..")) {
			if (!stack.isEmpty())
				stack.pop();
		} else if (!sb.toString().equals(".") && sb.length() != 0) {
			stack.push(sb.toString());
		}
		sb = new StringBuffer();
		while (!stack.isEmpty()) {
			sb.append("/");
			sb.append(stack.removeLast());
		}
		if (sb.length() == 0)
			sb.append("/");
		return sb.toString();

	}
}
