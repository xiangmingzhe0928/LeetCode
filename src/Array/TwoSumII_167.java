package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Array
 * description:找到有升序数组中 和为target的两元素 返回元素坐标（元素下标以1开始）
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * author:mingzhe Xiang
 * date:2016/11/11
 */
public class TwoSumII_167 {

	/**
	 * 该题是LeetCode首题：TwoSum的升级版 但对于借助HashMap来处理的方式没有任何变化 因为先做了TwoSum 有固定思维了直接就用HashMap做了
	 *
	 * 既然交TwoSumII 肯定有不同的解法 而且HashMap的方式Beats率不高
	 * @param numbers
	 * @param target
	 * @return
	 */
	private static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> temp = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (temp.containsKey(target - numbers[i])) {
				res[0] = temp.get(target - numbers[i]) + 1;//题目要求返回下标以1为基数
				res[1] = i + 1;
			}
			temp.put(numbers[i], i);
		}
		return res;
	}

	/**
	 * HashMap虽然也能AC成功 Beats率不理想
	 * 由于numbers是升序的 可以考虑双指针处理
	 * 果然这种方式Beats率比HashMap高了N倍
	 *
	 * PS：这里后来还想到如果题目指明数组全是正数 那这种方式还可以优化先BinarySearch找到target应当处于的index,然后从index开始递减遍历 而不是从length-1开始
	 *
	 * @param numbers
	 * @param target
	 * @return
	 */
	private static int[] twoSumByTwoPoint(int[] numbers, int target) {
		int leftPoint = 0;
		int rightPoint = numbers.length - 1;
		while (leftPoint <= rightPoint) {
			//当num[left]+num[right]大于target时 由于数组是升序 需要变为加上一个更小的数 因此rightPoint--
			while (leftPoint <= rightPoint && numbers[leftPoint] + numbers[rightPoint] > target)
				rightPoint--;
			//当num[left]+num[right]小于target时 由于数组是升序 需要变为加上一个更大的数 因此left++
			while (leftPoint <= rightPoint && numbers[leftPoint] + numbers[rightPoint] < target)
				leftPoint++;
			//本轮while结束 判断结束原因
			if (numbers[leftPoint] + numbers[rightPoint] == target) {
				return new int[] {leftPoint + 1, rightPoint + 1};
			}

		}
		return new int[] {-1, -1};
	}

	/**
	 * 果然Discuss上MostVotes答案 也是用的前后指针的方式
	 * @param num
	 * @param target
	 * @return
	 */
	public static int[] mostVotes(int[] num, int target) {
		int[] indice = new int[2];
		if (num == null || num.length < 2)
			return indice;
		int left = 0, right = num.length - 1;
		while (left < right) {
			int v = num[left] + num[right];
			if (v == target) {
				indice[0] = left + 1;
				indice[1] = right + 1;
				break;
			} else if (v > target) {
				right--;
			} else {
				left++;
			}
		}
		return indice;
	}

	public static void main(String[] args) {
		int[] nums = {12, 13, 23, 28, 43, 44, 59, 60};
		System.out.println(nums.length);
		System.out.println(Arrays.toString(twoSumByTwoPoint(nums, 67)));
	}
}
