package top100;

/**
 *
 *You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @author: Xiang Mingzhe
 * @version ClimbingStairs_70.java, v 0.1 2020/1/2 10:57 XiangMingZhe Exp $
 **/
public class ClimbingStairs_70 {

	/**
	 * 经典的爬梯子 DP问题
	 * 设P(n)为爬到第n阶的方式.
	 * 则P(n) = P(n-1) + P(n-2) // 能到达第n阶的方式 只有从n-1和n-2两种
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}

//		if (n <= 3) {
//			return n;
//		}

		int[] ways = new int[n+1];
		for (int i = 1; i <= n; i++) {
			if (i <= 3) {
				ways[i] = i;
			} else {
				ways[i] = ways[i-1] + ways[i-2];
			}
		}

		return ways[n];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("n == " + i + ">>>> " + climbStairs(i));
		}
	}
}
