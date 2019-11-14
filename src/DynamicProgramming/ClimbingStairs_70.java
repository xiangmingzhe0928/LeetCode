package DynamicProgramming;

/**
 * DynamicProgramming
 * description:第70题 爬梯题目：每次有两种爬梯方式：一次能爬1阶/一次爬2阶 爬到顶阶(n)有多少种方式
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * author:mingzhe Xiang
 * date:2016/11/7
 */
public class ClimbingStairs_70 {

	/**
	 *
	 *
	 * 对于第K阶：能爬到K的方式只有两种 1：从k-2层以2阶/次的方式  2：从k-1层以1阶/次的方式
	 * 而对于要爬到k-1来说同样 1：从k-3层以2阶/次的方式  2：从k-2层以1阶/次的方式
	 * 典型的DP问题：最优解中包含了子问题的最优解
	 * SO能爬山K的方式：f(k) = f(k-1) + f(k-2) //其实看到就是斐波拉契数列
	 * @param n
	 * @return
	 */
	private static int climbingStairs(int n) {
		if (n < 3)
			return n;
		int fn = 0;
		int fnPrePre = 1;//f(k-2)
		int fnPre = 2;//f(k-1)
		for (int i = 3; i <= n; i++) {
			fn = fnPrePre + fnPre;//f(k) = f(k-2) + f(k-1)
			fnPrePre = fnPre;//f(k-1)变为下一轮f(k-2)
			fnPre = fn;//f(k)变为下一轮f(k-1)
		}

		return fn;
	}

	public static void main(String[] args) {
		System.out.println(climbingStairs(10));
	}
}
