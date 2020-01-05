package top100;

import java.util.LinkedList;

import Tree.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetricRecursive around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetricRecursive:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree_101 {

	private LinkedList<TreeNode> leftList = new LinkedList<>();
	private LinkedList<TreeNode> rightList = new LinkedList<>();

	public boolean isSymmetric(TreeNode root) {
		if (null == root) {
			return true;
		}
		return symmetricRecursive(root.left, root.right);
	}

	/**
	 * 递归的方式
	 * 比较子树是不是镜像 A.left==B.right && A.right==B.left
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean symmetricRecursive(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left != null && right != null) {
			if (left.val != right.val) {
				return false;
			}
			return symmetricRecursive(left.left, right.right) && symmetricRecursive(left.right, right.left);
		}

		return false;
	}

	private boolean symmerricIteratively(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			leftList.addLast(root.left);
			rightList.addLast(root.right);
			while (leftList.size() == rightList.size() && leftList.size() > 0) {
				TreeNode leftTreeNode = leftList.pop();
				TreeNode rightTreeNode = rightList.pop();
				if (leftTreeNode.val != rightTreeNode.val) {
					return false;
				}
				TreeNode leftLeft = leftTreeNode.left;
				TreeNode leftRight = leftTreeNode.right;
				TreeNode rightLeft = rightTreeNode.left;
				TreeNode rightRight = rightTreeNode.right;
				if ((leftLeft == null && rightRight != null) || (leftLeft != null && rightRight == null)) {
					return false;
				}

				if (leftLeft != null && rightRight != null) {
					leftList.addLast(leftLeft);
					rightList.addLast(rightRight);
				}

				if ((leftRight == null && rightLeft != null) || (leftRight != null && rightLeft == null)) {
					return false;
				}

				if (leftRight != null && rightLeft != null) {
					leftList.addLast(rightLeft);
					rightList.addLast(leftRight);
				}

			}

			return leftList.size() == rightList.size();
		}

		return false;
	}
}
