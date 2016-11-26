package Tree;

/**
 * Tree
 * description:树节点
 * author:mingzhe Xiang
 * date:2016/11/17
 */
public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int x) { val = x; }
}
