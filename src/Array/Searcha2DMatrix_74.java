package Array;

/**
 * Array
 * description:从2D矩阵中找到target元素
 * 矩阵具有一下特性：1.每行从左到右有序 2.n行首数大于n-1行末尾数
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,
 Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 * author:mingzhe Xiang
 * date:2016/11/23
 */
public class Searcha2DMatrix_74 {

    /**
     * 本题看似2D 实际上因为每行首位元素大于前一行末尾元素 很明显了整体（看作一维数组）是有序的
     * 从有序数组中找元素 首先可以考虑BinarySearch
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1])
            return false;
        //这里还是当作2维数组处理 先找出所在的一维数组在2分查找
        //因为整体是有序的可以找到维度转化的公式 直接模拟替换为一维数组 免去此处循环
        //对于整体看作一维数组N  n[0]=martix[0][0]  n[n.length-1] = martix.length * martix[0].length - 1;
        //N[midd] =  matrix[mid/col_num][mid%col_num]
        for (int i = 0; i < matrix.length; i++) {

            if(target <= matrix[i][matrix[i].length-1])
                return binarySearch(matrix[i],target);
        }

        return false;
    }

    private static boolean binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1;
        int midd;
        while (left <= right){
            midd = (right + left) >>> 1;
            if(target == nums[midd])
                return true;
            else if(target > nums[midd])
                left = midd + 1;
            else
                right = midd - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        //{1,3,5,7},{10,11,16,20},{23, 30, 34, 50}
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23, 30, 34, 50}},13));
    }
}
