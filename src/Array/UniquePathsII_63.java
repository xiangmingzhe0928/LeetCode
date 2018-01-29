package Array;

/**
 * Array
 * description:62题的升级版 在grid中加入部分障碍(obstacles) 则在gird中空白格子和障碍格子分别用1,0代表 其他条件不变(与62一样) 求的左上角到右下角的路径
 * author:mingzhe Xiang
 * date:2016/11/26
 */
public class UniquePathsII_63 {

	/**
	 * 依然是DP问题：相对62增加了障碍设置 也只需要稍微改下就 仍然将nums[i][j]记录成到达nums[i][j]的路径数  K(i,j) = K(i-1,j)+K(i,j-1)
	 *
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePaths(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] + obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
			return 0;

		//针对 obstracleGrid只有一个元素的情况
		// PS：这里原先自己是用if去做的 后来看了Discuss上的老外代码 觉得很有想法 就换了
		// XOR运算在算法和性能上经常用到
		obstacleGrid[0][0] ^= 1;

		//首行 首列特殊处理
		// 对首行:i为1 则首行i格及i以后格子全不能到达
		for (int i = 1; i < obstacleGrid[0].length; i++)
			obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
		// 对首列:i为1 则首列i格及i以后格子全不能到达
		for (int i = 1; i < obstacleGrid.length; i++)
			obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];

		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				//到达K[i][j]格的路径 必然是到达K[i-1][j]与到达K[i][j-1]的和
				//若该格子为障碍格 无法到达 表明到达该格子的路径数为0
				obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] nums = new int[][] {{0}};
		//        System.out.println(" vote:"+uniquePathsWithObstacles2(nums));
		//        System.out.println("============================");
		System.out.println(" my:" + uniquePaths(nums));

		//        0
		//        000
		//        010
		//        000
		//        vote:0
	}
}
