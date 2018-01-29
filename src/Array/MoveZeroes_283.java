package Array;

import java.util.Arrays;

/**
 * Array
 * description:移动数组中所有0到数组末位，非0元素移动到数组前部分但需要维持原有顺序
 *
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 * author:mingzhe Xiang
 * date:2016/11/10
 */
public class MoveZeroes_283 {

	/**
	 * 本题想到2种处理思路：
	 * 1.最直接的也最能想到的方案（也是Discuss上MostVotes的方案）：遍历数组把非0元素放到数组前部分 然后根据数组大小用0补满0元素 详见mostVotes()方法
	 * 2.交换0和非0元素 这种较为麻烦 但也是一个思路 这里实现这种方式作为自己锻炼 本题最好应该采用（1）的方式
	 * @param nums
	 */
	private static void moveZeros(int[] nums) {
		if (nums.length <= 1)
			return;
		int zeroPoint = 0, nonZeroPoint = 0;//定义2个指针 分别指向当前0元素和非0元素
		while (nonZeroPoint < nums.length && zeroPoint < nums.length) {
			//zeroPoint率先移动
			while (zeroPoint < nums.length) {
				if (nums[zeroPoint] == 0) {
					nonZeroPoint = zeroPoint + 1;//此时not-zero从zeroPoint下一位
					break;
				}
				zeroPoint++;
			}
			//nonZeroPoint移动
			while (nonZeroPoint < nums.length && zeroPoint < nums.length) {
				if (nums[nonZeroPoint] != 0) {
					//交换当前0元素和当前非0元素
					nums[zeroPoint] = nums[nonZeroPoint];
					nums[nonZeroPoint] = 0;
					zeroPoint++;//此时zeroPoint变更为no-zeroPoint
					break;
				}
				nonZeroPoint++;
			}

		}
	}

	public static void mostVotes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		//"新"数组最后一位非0元素的index
		int insertPos = 0;
		//遍历原数组 将非0元素一次放入“新"数组
		for (int num : nums) {
			if (num != 0)
				//这里用到了Java的i++ 先赋值再++
				nums[insertPos++] = num;
		}
		//补齐0元素
		while (insertPos < nums.length) {
			nums[insertPos++] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 0, 3, 12};
		mostVotes(nums);
		//moveZeros(nums);
		System.out.println(Arrays.toString(nums));
	}
}
