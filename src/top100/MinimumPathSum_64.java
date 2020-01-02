package top100;

/**
 *Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 * @author: Xiang Mingzhe
 * @version MinimumPathSum_64.java, v 0.1 2020/1/2 10:39 XiangMingZhe Exp $
 **/
public class MinimumPathSum_64 {

	/**
	 * 与62题类似 DP问题
	 * 设grid[i][j]为到达坐标(i,j)的最小路径总和
	 * 则grid[m][n] = Math.min(grid[m-1][n], gird[m][n-1])
	 * @param grid
	 * @return
	 */
	public static int minPathSum(int[][] grid) {
		if (null == grid) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		if (n == 0) {
			return 0;
		}

		// 初始化grid[0][j]
		for (int j = 1; j < n; j++) {
			grid[0][j] += grid[0][j-1];
		}

		// 初始化grid[i][0]
		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i-1][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}

		return grid[m-1][n-1];
	}

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{},{},{}}));
	}
}
