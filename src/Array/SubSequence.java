package Array;

/**
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.
 */
public class SubSequence {

	/**
	 * 最大递增子序列
	 * @return
	 */
	private static int lengthOfLis(int[] nums) {
		//以nums[i]结尾的递增子序列长
		int[] dp = new int[nums.length];
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}

	/**
	 * 最大公共子序列
	 * DP：dp[i][j] : nums1前i子序列与nums2前j子序列的公共子序列
	 * dp[i][j] = dp[i-1][j-1] + 1 //nums1[i] == nums2[j]
	 * dp[i][j] = max(dp[i-1][j], dp[i][j-1]) //nums1[i] != nums2[j]
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private static int lengthOfLcs(int[] nums1, int[] nums2) {
		int[][] dp = new int[nums1.length][nums2.length];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (i * j == 0)
					dp[i][j] = 0;
				else if (nums1[i] == nums2[j])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[nums1.length - 1][nums2.length - 1];
	}

	/**
	 * 最大公共子串(一种特殊的公共子序列：连续)
	 * DP：DP：dp[i][j] : nums1前i子序列与nums2前j子序列的公共子序列
	 * dp[i][j] = dp[i-1][j-1] + 1 //nums1[i] == nums2[j]
	 * dp[i][j] = 0 //nums1[i] != nums2[j]
	 * @return
	 */
	private static int lengthOfSubString(int[] nums1, int[] nums2) {
		int[][] dp = new int[nums1.length][nums2.length];
		int maxLength = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					maxLength = Math.max(maxLength, dp[i][j]);
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] nums1 = {10, 9, 44, 1, 2, 3, 7, 101, 18};
		int[] nums2 = {11, 9, 25, 1, 8, 2, 3, 6, 7, 18};
		System.out.println(lengthOfLis(nums1));
		System.out.println(lengthOfLcs(nums1, nums2));
		System.out.println(lengthOfSubString(nums1, nums2));
	}
}
