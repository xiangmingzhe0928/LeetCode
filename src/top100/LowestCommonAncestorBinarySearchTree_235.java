package top100;

import Tree.TreeNode;

/**
 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

 示例 1:

 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 输出: 6
 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 示例 2:

 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 输出: 2
 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
  

 说明:

 所有节点的值都是唯一的。
 p、q 为不同节点且均存在于给定的二叉搜索树中。。
 *
 */
public class LowestCommonAncestorBinarySearchTree_235 {

	/**
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (null == root) {
			return null;
		}
		TreeNode minNode;
		TreeNode maxNode;
		if (p.val < q.val) {
			minNode = p;
			maxNode = q;
		} else {
			minNode = q;
			maxNode = p;

		}
		return findCommonAncestor(root, minNode, maxNode);

	}

	/**
	 * 	 根据二叉搜索树的特性 左节点小于root 右节点大于root
	 * 	 <li>p,q节点分布在当前root两侧 则root即为LCA</li>
	 * 	 <li>p,q节点同在root左侧 则root变更为左子节点 继续同样方法检测</li>
	 * 	 <li>p,q节点同在root右侧 则root变更为由子节点 继续同样方法检测</li>
	 * @param root
	 * @param minNode
	 * @param maxNode
	 * @return
	 */
	private static TreeNode findCommonAncestor(TreeNode root, TreeNode minNode, TreeNode maxNode) {

		if (minNode.val == root.val || maxNode.val == root.val) {
			return root;
		}
		if (minNode.val < root.val && root.val < maxNode.val) {
			return root;
		} else if (minNode.val < root.val) {
			return findCommonAncestor(root.left, minNode, maxNode);
		} else if (root.val < maxNode.val) {
			return findCommonAncestor(root.right, minNode, maxNode);
		}

		return null;
	}

	public static void main(String[] args) {
		//root = [6,2,8,0,4,7,9,null,null,3,5]
		TreeNode root = new TreeNode(2);
		TreeNode left2 = new TreeNode(1);
		TreeNode right2 = new TreeNode(3);
		TreeNode left31 = new TreeNode(0);
		TreeNode right31 = new TreeNode(4);
		TreeNode left32 = new TreeNode(7);
		TreeNode right32 = new TreeNode(9);
		TreeNode left42 = new TreeNode(3);
		TreeNode right42 = new TreeNode(5);

		root.setLeft(left2);
		root.setRight(right2);

//		left2.setLeft(left31);
//		left2.setRight(right31);
//
//		right2.setLeft(left32);
//		right2.setRight(right32);
//
//		left31.setLeft(null);
//		left31.setRight(null);
//
//		right31.setLeft(left42);
//		right31.setRight(right42);

		System.out.println(lowestCommonAncestor(root, right2, left2).val);
	}
}
