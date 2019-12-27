package top100;

/**
 *
 *给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 * @author: Xiang Mingzhe
 * @version JumpGame_55.java, v 0.1 2019/12/27 13:50 XiangMingZhe Exp $
 **/
public class JumpGame_55 {

	public static boolean canJump(int[] nums) {
		// 当前能jump到的最大Index
		int nowMaxIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > nowMaxIndex) // 前面能Jump到的最大index都比i小====>没有能Jump到i的元素
				return false;
			nowMaxIndex = Math.max(nowMaxIndex, i + nums[i]);
		}
		return true;
	}

	/**
	 * 递归判断当前Index能达到的后续index 是否可以到达lastIndex
	 * 该方法在nums中元素较大和较多时 耗时太长
	 * 复杂度太高
	 * @param nums
	 * @param currentIndex
	 * @return
	 */
	private static boolean jump(int[] nums, int currentIndex) {
		if (nums[currentIndex] == 0) {
			return false;
		}
		int maxJumpIndex = currentIndex + nums[currentIndex];
		if (maxJumpIndex >= nums.length - 1) {
			return true;
		}
		int nowMaxCurrentIndex = 0;
		for (int i = currentIndex; i <= maxJumpIndex; i++) {
			if (i + nums[i] >= nums.length - 1)
				return true;
			nowMaxCurrentIndex = Math.max(nowMaxCurrentIndex, i + nums[i]);
		}

		return jump(nums, nowMaxCurrentIndex);
	}
}
