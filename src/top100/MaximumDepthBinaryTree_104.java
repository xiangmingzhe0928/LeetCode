package top100;

import Tree.TreeNode;

/**
 *Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 *
 * @author: Xiang Mingzhe
 * @version MaximumDepthBinaryTree_104.java, v 0.1 2020/1/6 9:21 XiangMingZhe Exp $
 **/
public class MaximumDepthBinaryTree_104 {

	public int maxDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}

		return calculateMaxDepth(root);
	}

	private int calculateMaxDepth(TreeNode root) {
		if (null == root) {
			return 0;
		}
		return Math.max(calculateMaxDepth(root.left), calculateMaxDepth(root.right)) + 1;
	}
}
