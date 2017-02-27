package Tree;

/**
 * Tree
 * description:根据给定的一棵树的先序和后续数组 重新构造树 （树中没有重复元素）
 * author:mingzhe Xiang
 * date:2017/2/27
 */
public class ConstructBinaryTreeFromInorderPreorder_106 {

    public static TreeNode buildTree(int[] preorder,int[] inorder){

        return getTreeRootNode(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
    }

    public static TreeNode getTreeRootNode(int[] inorder,int[] preorder,int inStartIndex,int inEndIndex,int preStartIndex,int preEndIndex){
      if(inEndIndex < inStartIndex || preEndIndex < preStartIndex)
          return null;
        //当前子树root节点
        TreeNode root = new TreeNode(preorder[preStartIndex]);
        //在中序遍历数组中找到当前root位置
        int nowRootInIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val){
                nowRootInIndex = i;
                break;
            }
        }
        //左子树个数
        int leftTreeLen = nowRootInIndex - inStartIndex;
        root.left = getTreeRootNode(inorder,preorder,inStartIndex,nowRootInIndex-1,preStartIndex+1,preStartIndex+leftTreeLen);
        root.right = getTreeRootNode(inorder,preorder,nowRootInIndex+1,inEndIndex,preStartIndex+leftTreeLen+1,preEndIndex);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,2,4,1,6,5,7},new int[]{1,2,3,4,5,6,7}));
    }
}
