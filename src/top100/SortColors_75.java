package top100;

import java.util.Arrays;

/**
 *
 *Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * @author: Xiang Mingzhe
 * @version SortColors_75.java, v 0.1 2020/1/2 11:33 XiangMingZhe Exp $
 **/
public class SortColors_75 {

	/**
	 * 本质就是排序
	 * 可借助快排思想 双指针左右逼近 中间数取1即可
	 * @param nums
	 */
	public static void sortColors(int[] nums) {

		if (nums.length <= 1) {
			return;
		}
		int left = 0;
		int right = nums.length - 1;
		int currIndex = 0;
		while (currIndex <= right) {
			if (nums[currIndex] == 0) {
				swap(nums, left, currIndex);
				left ++;
				currIndex ++;
			} else if (nums[currIndex] == 2) {
				swap(nums, right, currIndex);
				right --;
			} else {
				currIndex ++;
			}
		}

	}


	private static void swap(int[] nums, int aIndex, int bIndex) {
		int temp = nums[aIndex];
		nums[aIndex] = nums[bIndex];
		nums[bIndex] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,0,2,1,1,1};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
