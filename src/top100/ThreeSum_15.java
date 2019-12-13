package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 找到所有3个元素组合 使得和为0 结果不能重复
 *
 * @author: Xiang Mingzhe
 * @version ThreeSum_15.java, v 0.1 2019/12/13 10:43 XiangMingZhe Exp $
 **/
public class ThreeSum_15 {

	/**
	 * 求指定组合的和, 根据当前组合的值 利用双指针逐步向target值靠拢
	 * 但这种左右双指针 依赖有序.可以先排序再处理
	 * @param nums
	 * @return
	 */
	private static List<List<Integer>> threeSum(int[] nums) {
		int length = nums.length;
		if (length < 3) {
			return Collections.emptyList();
		}
		Arrays.sort(nums);

		int leftIndex;
		int rightIndex;

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < length - 2; i++) {

			// 最小元素大于0 直接结束
			if (nums[i] > 0) {
				break;
			}

			// 已经排序过 则判断重复直接判断前一元素是否与当前元素相等
			if (i > 0 && nums[i] == nums[i-1]) {
				// 跨过重复情形
				continue;
			}
			leftIndex = i + 1;
			rightIndex = length - 1;

			while (leftIndex < rightIndex) {
				if (nums[leftIndex] + nums[rightIndex] < -nums[i]) {
					leftIndex ++;
				} else if(nums[leftIndex] + nums[rightIndex] > -nums[i]) {
					rightIndex -- ;
				} else {
					List<Integer> temp = new ArrayList<>(3);
					temp.add(nums[i]);
					temp.add(nums[leftIndex]);
					temp.add(nums[rightIndex]);
					result.add(temp);

					leftIndex ++ ;
					rightIndex--;
					while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
						leftIndex ++;
					}
					while (rightIndex > leftIndex && nums[rightIndex] == nums[rightIndex + 1]) {
						rightIndex --;
					}
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
