package top100;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray_53 {

	/**
	 * 设以nums[i]为子序列的尾元素 则：max(i) = Math.max(nums[i], max(i-1) + nums[i]);
	 * @param nums
	 * @return
	 */
	private static int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		// 最大子序列和
		int maximum = nums[0];
		// 以上一元素为尾元素的最大子序列和
		int	preSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum = Math.max(nums[i], preSum + nums[i]);
			maximum = Math.max(maximum, preSum);
		}

		return maximum;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{1,-2}));
	}
}
