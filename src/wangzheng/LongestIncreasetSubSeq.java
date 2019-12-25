package wangzheng;

/**
 *
 * 无重复数组中求最大递增子序列长度
 * 比如2, 9, 3, 6, 5, 1, 7这样一组数字序列，它的最长递增子序列就是2, 3, 5, 7，所以最长递增子序列的长度是4
 * @author: Xiang Mingzhe
 * @version LongestIncreasetSubSeq.java, v 0.1 2019/12/24 15:23 XiangMingZhe Exp $
 **/
public class LongestIncreasetSubSeq {

	private static int longestIncreaseSeq(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int maxLength = 1;
		// 下标为i的元素 对应的最长子序列长度
		int[] subLength = new int[nums.length];
		subLength[0] = 1;
		for (int i = 1; i < nums.length; i++) {

			// 下标为i的最大递增子序列为 nums(0...i-1)中小于nums[i]的最大子序列数+1
			subLength[i] = 1;
			for (int j = i-1; j >= 0; j--) {
				if (nums[i] > nums[j]) { // 若支持重复元素的序列 >=即可
					subLength[i] = Math.max(subLength[i], subLength[j] + 1);
				}
			}
			maxLength = Math.max(maxLength, subLength[i]);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestIncreaseSeq(new int[]{1,3,6,6,9,4,10,5,7}));
	}
}
