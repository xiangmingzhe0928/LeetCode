package Array;

/**
 * Array
 * description:给定一个M * N量的非负格子 找到从左上角到右下角路径中途径数值和最小的路径 并返回数字和
 * 限定：只能往右或往下走
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 Note: You can only move either down or right at any point in time.
 * author:mingzhe Xiang
 * date:2016/11/11
 */
public class MinimumPathSum_64 {

    /**
     * 典型的DP问题
     * 到达(x,y)格子的最小和 必然是到达(x-1,y)和(x,y-1)的较小一个
     * 即：MinSum(x,y)表示到达(x,y)的最小和值：MinSum(x,y) = Math.min(MinSum(x-1,y),MinSum(x,y-1))+Value(x,y)
     * @param grid
     * @return
     */
    private static int minimumPathSum(int[][] grid){

        //将grid中原格子中代表本格子元素值替换为表示到达本格子最小和值

        //只能向右或者向下移动 因此对于(0,y) (x,0)的MinSum需要单独处理
        //首行MinSum
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }
        //首列MinSum
        for (int i = 1; i <grid.length ; i++) {
            grid[i][0] += grid[i-1][0];
        }
        //其余格子MinSum（最基本的二维数组遍历赋值）
        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                //MinSum(x,y) = Math.min(MinSum(x-1,y),MinSum(x,y-1))+Value(x,y)
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[grid.length-1][grid[0].length-1];


    }

    public static void main(String[] args) {
        System.out.println(minimumPathSum(new int[][]{{1,2,13,4},{5,16,7,8},{9,10,11,12}}));
    }
}
