package Array;

import java.util.Arrays;

/**
 * Array
 * description:就是一个含有0,1,2重复元素的排序问题
 * author:mingzhe Xiang
 * date:2016/11/22
 */
public class SortColors_75 {

	/**
	 * 本题就是排序问题 但本题快排并不算最佳选择，因为已确定就3种数字(0,1,2)。可以借鉴快排的思路 简化下本题
	 * （直接用快排 顺便复习下快排）
	 *
	 * @param nums
	 */
	public static void sortColors(int[] nums) {

		//快排方式 仅仅是为了复习下快排
		sort(nums, 0, nums.length - 1);
		// twoPoint(nums);
	}

	/**
	 * 本题情况特殊 已定了就0,1,2三种元素 可以借鉴快排分治的思路 以1为标志位 0在左 2在右
	 * @param nums
	 */
	private static void twoPoint(int[] nums) {
		int leftP = 0, rightP = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			while (2 == nums[i] && i < rightP)
				swap(nums, i, rightP--);
			while (0 == nums[i] && i > leftP)
				swap(nums, i, leftP++);
		}
	}

	private static void swap(int[] nums, int left, int right) {
		int temp = nums[right];
		nums[right] = nums[left];
		nums[left] = temp;
	}

	/**
	 * 快排的方式
	 * @param nums
	 * @param left
	 * @param right
	 */
	private static void sort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		//中间标志位
		int flag = nums[left];
		//左右哨兵
		int leftPoint = left, rightPoint = right;
		//调整标志位左右数据
		while (leftPoint < rightPoint) {
			while (leftPoint < rightPoint && nums[rightPoint] >= flag)
				rightPoint--;
			nums[leftPoint] = nums[rightPoint];
			while (leftPoint < rightPoint && nums[leftPoint] <= flag)
				leftPoint++;
			nums[rightPoint] = nums[leftPoint];
		}
		//标志位归位
		nums[leftPoint] = flag;
		//分治递归
		sort(nums, left, leftPoint - 1);
		sort(nums, leftPoint + 1, right);
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0, 0, 1, 2, 1, 2, 1, 1, 0, 1, 0, 0, 1, 2, 1, 2, 1};
		long begin = System.currentTimeMillis();
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
