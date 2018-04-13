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
		if (m * n <= 0)
			return 0;
		int[][] temp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//
				if (i * j == 0) {
					temp[i][j] = 1;
					continue;
				}
				//到达K[i][j]格的路径 必然是到达K[i-1][j]与到达K[i][j-1]的和
				temp[i][j] = temp[i][j - 1] + temp[i - 1][j];
			}
		}
		return temp[m - 1][n - 1];
	}

	/**
	 *
	 * 一维数组的方式记录 空间复杂度更低
	 * 理解上稍微有点绕（可理解为逐行或逐列mark）
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths_1DArray(int m, int n) {
		// 以行为准
		int[] arr = new int[n];
		//首行元素
		for (int i = 0; i < n; i++) {
			arr[i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				arr[j] = arr[j] + arr[j - 1];
			}
		}
		return arr[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 4));
	}
}
