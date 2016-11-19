package Array;


import Tree.TreeNode;

/**
 * Array
 * description:给定中序遍历结果和后序遍历结果 给出该二叉树
 * author:mingzhe Xiang
 * date:2016/11/17
 */
public class ConstructBinaryTree_106 {

    public static TreeNode buildTree( int[] inorder,int[] postorder) {
         return createTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    /**
     * 后序遍历的尾元素即为Tree根节点，中序遍历中根节点将左右子树左右分开
     * 因此后序遍历找到根节点，中序遍历找到根节点index。递归构造子树
     * @param in
     * @param inStart
     * @param inEnd
     * @param post
     * @param postStart
     * @param postEnd
     * @return
     */
    public static TreeNode createTree( int[] in,  int  inStart,  int  inEnd,  int[] post,  int  postStart,int postEnd){
        if (inStart > inEnd || postStart > postEnd) return  null ;

        int rootVal = post[postEnd];
        int rootIndex = 0;
        //找到当前子树根节点在中序遍历中的Index
        for (int i = inStart; i <= inEnd; i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break ;
            }

        }
        //左子树的长度
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        //递归建树
        root.left = createTree(in, inStart, rootIndex-1, post, postStart, postStart+len-1);
        root.right = createTree(in, rootIndex+1, inEnd, post, postStart+len, postEnd-1);
        return root;
    }
}
