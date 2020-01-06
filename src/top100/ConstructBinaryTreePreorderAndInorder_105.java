package top100;

import Tree.TreeNode;

/**
 *
 *Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author: Xiang Mingzhe
 * @version ConstructBinaryTreePreorderAndInorder_105.java, v 0.1 2020/1/6 9:44 XiangMingZhe Exp $
 **/
public class ConstructBinaryTreePreorderAndInorder_105 {


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildRoot(preorder, inorder, 0, 0, inorder.length - 1);
	}

	/**
	 * 前序遍历中当前子树的root节点在最前
	 * 中序遍历中左右子树分布在root节点两侧
	 * @param preorder
	 * @param inorder
	 * @param preIndex
	 * @param inorderStart
	 * @param inorderEnd
	 * @return
	 */
	private TreeNode buildRoot(int[] preorder, int[] inorder, int preIndex, int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd) {
			return null;
		}

		TreeNode currentRoot = new TreeNode(preorder[preIndex]);

		int currentRootInorderIndex = -1;
		for (int i = inorderStart; i <= inorderEnd ; i++) {
			if (inorder[i] == currentRoot.val) {
				currentRootInorderIndex = i;
				break;
			}
		}
		int leftTreeSize = currentRootInorderIndex - inorderStart;
		currentRoot.left = buildRoot(preorder, inorder, preIndex + 1, inorderStart, currentRootInorderIndex - 1);
		currentRoot.right = buildRoot(preorder, inorder, preIndex + leftTreeSize + 1, currentRootInorderIndex + 1, inorderEnd);
		return currentRoot;
	}
}
