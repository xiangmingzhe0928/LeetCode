package Array;

/**
 * Array
 * description:找到数组中任意一个峰值(大于左右兄弟元素)元素 num[-1]和num[n]视为无穷小
 A peak element is an element that is greater than its neighbors.
 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 You may imagine that num[-1] = num[n] = -∞.
 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * author:mingzhe Xiang
 * date:2016/11/11
 */
public class FindPeakElement_162 {

	/**
	 * 本题感觉难度不大 注意下边界问题就可以了
	 * @param nums
	 * @return
	 */
	private static int findPeakElement(int[] nums) {

		if (nums.length == 1 || nums[0] > nums[1])
			return 0;
		if (nums[nums.length - 1] > nums[nums.length - 2])
			return nums.length - 1;

		//        for (int i = 1; i < nums.length-1; i++) {
		//            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
		//                return i;
		//        }
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				return i - 1;
		}
		return -1;
	}

	/**
	 * 做完后才看到题目有进阶内容:能否让复杂度为对数级复杂度 Your solution should be in logarithmic complexity.
	 *
	 * 谈到O(longN)最所熟悉的就是2分查找了(当时也完全不知道2分查找对这题有什么用 就单纯的想到2分查找 边做边思考)
	 * 虽然不满足2分查找的特殊要求(数组有序) 但可以变通使用2分查找
	 * 1.当num[i] > num[i+1] 那么nums[0]到nums[i-1]至少存在一位峰值
	 * 2.当num[i] < num[i+1] 那么nums[i+1]到nums[length-1]至少存在一位峰值
	 * 因此完全可以每次分半处理
	 * @param nums
	 * @return
	 */
	private static int logarithmicComplexity(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int midIndex;
		while (left < right) {
			midIndex = (left + right) >>> 1;
			if (nums[midIndex] < nums[midIndex + 1])
				left = midIndex + 1;
			else
				right = midIndex;
		}
		return left;
	}

	public static void main(String[] args) {
		System.out.println(logarithmicComplexity(new int[] {2, 3, 5, 4, 6, 3, 8}));
	}
}
