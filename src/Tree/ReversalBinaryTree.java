package Tree;

/**
 * 翻转2叉树
 */
public class ReversalBinaryTree {

	private static void reveral(TreeNode treeNode) {
		if (treeNode == null)
			return;
		if (treeNode.left == null && treeNode.right == null)
			return;

		reveral(treeNode.left);
		reveral(treeNode.right);

		TreeNode temp = treeNode.left;
		treeNode.left = treeNode.right;
		treeNode.right = temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;

		System.out.println("before:");
		printValue(root);
		reveral(root);
		System.out.println("after:");
		printValue(root);

	}

	private static void printValue(TreeNode treeNode) {
		if (null == treeNode)
			return;
		Integer leftValue = treeNode.left == null ? null : treeNode.left.val;
		Integer rightValue = treeNode.right == null ? null : treeNode.right.val;
		System.out.println(
			String.format("val:%s, left:%s, right:%s", treeNode.val, leftValue, rightValue));
		printValue(treeNode.left);
		printValue(treeNode.right);
	}
}
