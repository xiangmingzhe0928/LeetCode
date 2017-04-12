package Tree;

/**
 * Tree
 * description:将一个2叉搜索树转成有序双向链表
 *
 * 对2叉搜索树：中序遍历结果即是有序
 * author:mingzhe Xiang
 * date:2017/4/12
 */
public class BinaryTreeToList {

    //记录当前链表的尾节点
    private static TreeNode lastNode = null;

    /**
     *
     * @param currNode 当前遍历到的节点
     * @return
     */
    public static void convert(TreeNode currNode){
       if(currNode == null)
           return ;
       //整体采用中序遍历（有序）

       //递归遍历左子节点
       if(currNode.left != null) convert(currNode.left);
       //当前遍历到的节点左节点指向链表尾部
       currNode.left = lastNode;
       //链表尾部节点变更为当前节点
       if (lastNode != null)lastNode.right = currNode;
       lastNode = currNode;

        //递归遍历右子节点
        if (currNode.right != null) convert(currNode.right);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(19);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(39);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(29);
        TreeNode node7 = new TreeNode(49);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        convert(root);
        TreeNode headNode = root;
        while (headNode.left != null){
            headNode = headNode.left;
        }

        System.out.println(headNode);

    }
}
