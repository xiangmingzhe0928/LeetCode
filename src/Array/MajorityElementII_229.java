package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Array
 * description:169题(找到出现超过n/2的元素)的升级版：找到出现超过n/3的元素
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * author:mingzhe Xiang
 * date:2016/8/9
 */
public class MajorityElementII_229 {

	/**
	 * 169题中求出现n/2次元素时 或许还能"偷巧" 排序后取n/2。本题n/3次元素种类较多不太适合。
	 * 但思路是一致的:元素出现超过n/2次，最多就1个这样的元素；出现超过n/3次，最多就2个这样的元素
	 * SO：和169题一样摩尔投票算法记录出现次数最多的前2个元素，然后遍历得到其出现次数
	 *
	 * @param nums
	 * @return
	 */
	private static List<Integer> majorityElementII(int[] nums) {
		List<Integer> resList = new ArrayList<>();
		if (nums.length == 0)
			return resList;
		//出现次数最多的2个元素
		int targetElement1 = nums[0], targetElement2 = nums[0];
		//出现次数最多的2个元素的出现次数
		int targetCount1 = 0, targetCount2 = 0;

		//遍历nums 记录元素出现次数
		for (int i = 0; i < nums.length; i++) {
			if (targetElement1 == nums[i]) {
				targetCount1++;
			} else if (targetElement2 == nums[i]) {
				targetCount2++;
			} else if (targetCount1 == 0) {
				//元素1位置为空 用当前nums[i]占住元素1位置
				targetElement1 = nums[i];
				targetCount1++;
			} else if (targetCount2 == 0) {
				//元素2位置为空 用当前nums[i]占住元素2位置
				targetElement2 = nums[i];
				targetCount2++;
			} else {
				//当前nums[i]
				targetCount1--;
				targetCount2--;
			}

		}
		targetCount1 = 0;
		targetCount2 = 0;
		for (int num : nums) {
			if (num == targetElement1)
				targetCount1++;
			else if (num == targetElement2)
				targetCount2++;
		}

		if (targetCount1 > nums.length / 3)
			resList.add(targetElement1);
		if (targetCount2 > nums.length / 3)
			resList.add(targetElement2);

		return resList;
	}

	public static void main(String[] args) {
		majorityElementII(new int[] {});
	}
}
