package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Array
 * description:给定数组nums[n] 数组元素满足1<=a[i]<=n 找出[1,n]中未出现在nums中的所有元素
 *
 Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.
 Find all the elements of [1, n] inclusive that do not appear in this array.
 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 Example:Input:[4,3,2,7,8,2,3,1] Output:[5,6]
 * author:mingzhe Xiang
 * date:2016/11/8
 */
public class FindAllNumbersDisappeared_448 {

	private static List<Integer> findAllNumbersDisa(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= nums.length; i++) {
			set.add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			set.remove(nums[i]);
		}
		return new ArrayList<>(set);
	}
}
