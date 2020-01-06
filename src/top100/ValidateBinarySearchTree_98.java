package top100;

import Tree.TreeNode;

/**
 *
 *Given a binary tree, determine if it is a valid binary search tree (BST).
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
 *
 * @author: Xiang Mingzhe
 * @version ValidateBinarySearchTree_98.java, v 0.1 2020/1/3 17:05 XiangMingZhe Exp $
 **/
public class ValidateBinarySearchTree_98 {

	public static boolean isValidBST(TreeNode root) {

		if (null == root) {
			return true;
		}

		return recursive(root,root.val, root.val);
	}


	private static boolean recursive(TreeNode root, int minValue, int maxValue) {
			if (null != root.left) {
				if (root.left.val >= minValue) {
					return false;
				}

				recursive(root.left, root.left.val, maxValue);
			}
			if (null != root.right) {
				if (root.right.val <= maxValue) {
					return false;
				}
				recursive(root.right, minValue, root.right.val);
			}

			return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode rootl1 = new TreeNode(5);
		TreeNode rootr1 = new TreeNode(15);

		TreeNode rootl2 = new TreeNode(6);
		TreeNode rootr2 = new TreeNode(10);

		root.left = rootl1;
		root.right = rootr1;

		rootr1.left = rootl2;
		rootr1.right = rootr2;
		System.out.println(isValidBST(root));
	}
}
