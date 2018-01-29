package Array;

/**
 * Array
 * description:返回数组中连续最大乘积
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6
 * author:mingzhe Xiang
 * date:2016/11/12
 */
public class MaximumProductSubarray_152 {

	/**
	 * DP问题
	 * 到i时最大连续乘积：MaxProduct(i) = MaxProduct(i-1) * nums[i]
	 * 但因为是乘而不是加 因此在当前MaxProduct为负数时还需要考虑后续元素仍有负数 导致负负为正的情况
	 * 因此本题相比传统的DP需要维护一个优解变量的情况，本题需要维护2个变量：到最大解和最小解
	 * @param nums
	 * @return
	 */
	private static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxPro = nums[0];//当前最大解
		int minPro = nums[0];//当前最小解
		int max = nums[0];//最终最大解
		int tempMax, tempMin;
		for (int i = 1; i < nums.length; i++) {
			tempMax = maxPro * nums[i];
			tempMin = minPro * nums[i];
			maxPro = Math.max(Math.max(tempMax, nums[i]), tempMin);
			minPro = Math.min(Math.min(tempMax, nums[i]), tempMin);
			max = Math.max(maxPro, max);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {1, 2, 4, 5, 6, 9, 11, 12, 14, 15, 16, 22, 23, 45, 57}));

	}

}
