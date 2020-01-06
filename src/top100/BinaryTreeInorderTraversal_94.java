package top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.TreeNode;

/**
 *
 *Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author: Xiang Mingzhe
 * @version BinaryTreeInorderTraversal_94.java, v 0.1 2020/1/3 14:13 XiangMingZhe Exp $
 **/
public class BinaryTreeInorderTraversal_94 {

	/**
	 * 中序遍历二叉树 忽略null
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
//		recursive(res, root);
		iteratively(res, root);
		return res;
	}

	/**
	 * 递归方式 中序遍历
	 * @param root
	 */
	private static void recursive(List<Integer> res, TreeNode root) {
		if (null == root) {
			return ;
		}
		if (root.left != null) {
			recursive(res, root.left);
		}
		res.add(root.val);
		if (root.right != null) {
			recursive(res, root.right);
		}
	}

	/**
	 * 迭代方式
	 * 依赖一个Stack
	 * @param res
	 * @param root
	 */
	private static void iteratively(List<Integer> res, TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (null != root || !stack.isEmpty()) {
			while (null != root) {
				stack.push(root);
				root = root.left;
			}
			TreeNode topE = stack.pop();
			res.add(topE.val);
			root = topE.right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode rigth1 = new TreeNode(2);
		TreeNode left22 = new TreeNode(3);
		root.right = rigth1;
		rigth1.left = left22;
		System.out.println(inorderTraversal(root));
	}
}
