package top100;

import Tree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree_98 {

	public static boolean isValidBST(TreeNode root) {

		return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/**
	 * 在纸上画出2叉树找到规律即可
	 *
	 * @param root 当前需要判断的节点
	 * @param needGreater 当前节点需要大于的数字
	 * @param needLess 当前节点需要小于的数字
	 * @return 是否合法二叉树
	 *
	 * NOTE：规律不难找到 当时在submit时 没有使用long 直接使用int定义的needGreater,needLess结果AC失败
	 * 主要是没考虑到节点val中包含Long.MIN_VALUE, Long.MAX_VALUE的测试用例。
	 * 使用long后能AC 但只是在该题目范围内解决问题 治标不治本, 如果 TreeNode的val类型为long 依然有问题。
	 *
	 * 可以考虑使用包装类(Integer)定义needGreater,needLess。null值判断特殊testcase
	 */
	private static boolean valid(TreeNode root, long needGreater, long needLess) {
		if (null == root) {
			return true;
		}
		if (root.val > needGreater && root.val < needLess) {
			return valid(root.left, needGreater, root.val) && valid(root.right, root.val, needLess);
		}

		return false;
	}

	public static void main(String[] args) {
		// [2147483647]

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
