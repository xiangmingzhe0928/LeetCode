package top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Tree.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal_102 {

	/**
	 * 经典的按层遍历二叉树,借助一个队列即可
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (null == root) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> levelNodeList = new LinkedList<>();
		levelNodeList.add(root);
		// 递归方式
		levelTraversal(res, levelNodeList);
		// 迭代
		//levelTraversalIteratively(res, levelNodeList);
		return res;
	}

	/**
	 * 递归
	 * @param res
	 * @param levelNodeList
	 */
	private void levelTraversal(List<List<Integer>> res, LinkedList<TreeNode> levelNodeList) {
		LinkedList<TreeNode> nextLevelList = new LinkedList<>();
		List<Integer> currentLevelList = new ArrayList<>();
		TreeNode currentNode;
		while (levelNodeList.size() > 0) {
			currentNode = levelNodeList.pop();

			currentLevelList.add(currentNode.val);
			if (currentNode.left != null) {
				nextLevelList.addLast(currentNode.left);
			}
			if (currentNode.right != null) {
				nextLevelList.addLast(currentNode.right);
			}
		}

		if (currentLevelList.size() > 0) {
			res.add(currentLevelList);
			levelTraversal(res, nextLevelList);
		}
	}

	private void levelTraversalIteratively(List<List<Integer>> res, LinkedList<TreeNode> levelNodeList) {
		int currentLevelSize = levelNodeList.size();
		TreeNode currentNode;
		while (currentLevelSize > 0) {
			List<Integer> currentLevelList = new ArrayList<>();
			for (int i = 0; i < currentLevelSize; i++) {
				currentNode = levelNodeList.pop();
				currentLevelList.add(currentNode.val);
				if (currentNode.left != null) {
					levelNodeList.addLast(currentNode.left);
				}
				if (currentNode.right != null) {
					levelNodeList.addLast(currentNode.right);
				}
			}
			res.add(currentLevelList);
			currentLevelSize = levelNodeList.size();
		}
	}
}
