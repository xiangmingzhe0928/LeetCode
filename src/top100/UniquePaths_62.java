package top100;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 */
public class UniquePaths_62 {

	/**
	 * 经典的DP问题
	 * 到达k(i,j)的路径只有2条：k(i-1, j)和k(i,j-1)
	 * 即k(i,j) = k(i-1,j) + k(i,j-1)
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0) {
			return 0;
		}
		// 设paths[i][j] 表示到达坐标(i,j)的所有路径
		int[][] paths = new int[m][n];

		// 初始化第一列数据
		for (int i = 0; i < m; i++) {
			paths[i][0] = 1;
		}
		// 初始化第一排数据
		for (int i = 0; i < n; i++) {
			paths[0][i] = 1;
		}

		for (int i = 1; i < m ; i++) {
			for (int j = 1; j < n ; j++) {
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}

		return paths[m-1][n-1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(7,3));
	}
}
