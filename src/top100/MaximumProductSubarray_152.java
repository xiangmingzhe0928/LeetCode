package top100;

/**
 *
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author: Xiang Mingzhe
 * @version MaximumProductSubarray_152.java, v 0.1 2020/1/9 10:13 XiangMingZhe Exp $
 **/
public class MaximumProductSubarray_152 {

	public int maxProduct(int[] nums) {
		if (null == nums) {
			return 0;
		}
		if (1 == nums.length) {
			return nums[0];
		}

		int maxProduct = nums[0];
		int preMaxProduct = nums[0];
		int preMinProduct = nums[0];

		int currMaxProduct;
		int currMinProduct;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				currMaxProduct = Math.max(nums[i], nums[i] * preMinProduct);
				currMinProduct = Math.min(nums[i], nums[i] * preMaxProduct);
			} else {
				currMaxProduct = Math.max(nums[i], nums[i] * preMaxProduct);
				currMinProduct = Math.min(nums[i], nums[i] * preMinProduct);
			}
			preMaxProduct = currMaxProduct;
			preMinProduct = currMinProduct;
			maxProduct = Math.max(maxProduct, currMaxProduct);
		}

		return maxProduct;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumProductSubarray_152().maxProduct(new int[]{2,3,-2,4,-5,-3}));
	}
}
