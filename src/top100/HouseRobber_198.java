package top100;

/**
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version HouseRobber_198.java, v 0.1 2020/1/10 10:14 XiangMingZhe Exp $
 **/
public class HouseRobber_198 {

	/**
	 * 动态规划,设M(k)为到索引k能抢到的最大财产.
	 * 则M(k) = Math.max(M(k-2), M(k-3)) + nums[k]; 不存在M(k-4)的情况因为k-4和k-2重合
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0],nums[1]);
		}


		if (nums.length == 3) {
			return Math.max(nums[1], nums[0] + nums[2]);
		}

		nums[2] = nums[0] + nums[2];
		int maxMoney = Math.max(nums[1], nums[2]);
		for (int i = 3; i < nums.length; i++) {
			nums[i] = Math.max(nums[i-2], nums[i-3]) + nums[i];
			maxMoney = Math.max(maxMoney, nums[i]);
		}

		return maxMoney;
	}

	public static void main(String[] args) {
		System.out.println(new HouseRobber_198().rob(new int[]{2,7,9,3,1}));
	}
}
