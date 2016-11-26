package Array;

/**
 * Array
 * description:从表格左上角(0,0)到右下角(m,n) 有多少种不重复路径 每次只能向右或者向下移动
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?
 * author:mingzhe Xiang
 * date:2016/11/25
 */
public class UniquePaths_62 {

    /**
     *
     * DP 动态规划问题
     * K(i,j) = K(i-1,j)+K(i,j-1)
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if(m * n <= 0)
            return 0;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //
                if(i * j == 0){
                    temp[i][j] = 1;
                    continue;
                }
                //到达K[i][j]格的路径 必然是到达K[i-1][j]与到达K[i][j-1]的和
                temp[i][j] = temp[i][j-1]+temp[i-1][j];
            }
        }
        return temp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,4));
    }
}
