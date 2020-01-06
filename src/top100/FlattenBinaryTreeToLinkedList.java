package top100;

import Tree.TreeNode;

/**
 *
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * @author: Xiang Mingzhe
 * @version FlattenBinaryTreeToLinkedList.java, v 0.1 2020/1/6 10:57 XiangMingZhe Exp $
 **/
public class FlattenBinaryTreeToLinkedList {


	private TreeNode prev = null;

	/**
	 * 从底到顶
	 * @param root
	 */
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

	/**
	 * 从顶到底 每一层将left挂载到right上 同时将原来right挂载到原left上
	 * @param root
	 */
	public void flatten3(TreeNode root) {
		if (root == null) {
			return ;
		}
		while (null != root) {

			if (root.left == null) {
				root = root.right;
				continue;
			}
			TreeNode tempRight = root.right;
			root.right = root.left;
			root.left = null;
			TreeNode temp = root;
			while (temp.right != null) {
				temp =  temp.right;
			}

			temp.right = tempRight;

			root = root.right;

		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left2 = new TreeNode(1);
		TreeNode right2 = new TreeNode(3);
		TreeNode left31 = new TreeNode(0);
		TreeNode right31 = new TreeNode(4);
		TreeNode left32 = new TreeNode(7);
		TreeNode right32 = new TreeNode(9);
//		TreeNode left42 = new TreeNode(3);
//		TreeNode right42 = new TreeNode(5);

		root.setLeft(left2);
		root.setRight(right2);
		left2.left = left31;
		left2.right = right31;
		right2.left = left32;
		right2.right = right32;

	new FlattenBinaryTreeToLinkedList().flatten3(root);
	}
}
