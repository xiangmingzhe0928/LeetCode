package top100;

import java.util.Arrays;

/**
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author: Xiang Mingzhe
 * @version FindFirstAndLastPositionInSortedArray_34.java, v 0.1 2019/12/20 14:14 XiangMingZhe Exp $
 **/
public class FindFirstAndLastPositionInSortedArray_34 {

	public static int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) {
			return new int[]{-1,-1};
		}
		// 找到target第一次出现的index
		int first = findFirstIndex(nums, target);
		if (target != nums[first]) {
			return new int[]{-1,-1};
		}
		// 找到target最后一次出现的index====>等价于找到[target+1]第一次出现的index前一位
		int end = findFirstIndex(nums, target + 1);
		if (nums[end] >= target + 1) {
			end = end - 1;
		}
		return new int[]{first, end};
	}


	/**
	 * 变通一下2分查找 找到target第一次出现的前一位index
	 * 即返回的index存在两种情况 ：
	 * 1.nums[index]< target则index为最大的小于target元素
	 * 2.nums[index]>=target则index为第一个大于target的下标
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int findFirstIndex(int[] nums, int target) {
		int leftIndex = 0;
		int rightIndex = nums.length-1;

		int middleIndex;
		while (leftIndex < rightIndex) {
			middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
			if (target > nums[middleIndex]) {
				leftIndex = middleIndex + 1;
			} else {
				rightIndex = middleIndex;
			}
		}

		return leftIndex;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,3,3,3,3};

		System.out.println(findFirstIndex(nums, 5));
		System.out.println(Arrays.toString(searchRange(nums, 3)));
	}
}
