package top100;

import java.util.Arrays;

/**
 *
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * @author: Xiang Mingzhe
 * @version MajorityElement_169.java, v 0.1 2020/1/10 9:00 XiangMingZhe Exp $
 **/
public class MajorityElement_169 {

	/**
	 * 排序后n/2即为出现超过半数的数
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	/**
	 * moore投票法
	 * @param nums
	 * @return
	 */
	public int majorityElementByMooreVote(int[] nums) {
		int mooreValue = nums[0];
		int mooreCount = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == mooreValue) {
				mooreCount ++;
			} else {
				mooreCount --;
				if (mooreCount == 0) {
					mooreCount = 1;
					mooreValue = nums[i];
				}
			}
		}

		return mooreValue;
	}

	public static void main(String[] args) {
		System.out.println(new MajorityElement_169().majorityElementByMooreVote(new int[]{2,2,1,1,1,2,2}));
	}
}
