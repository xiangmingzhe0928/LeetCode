package top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author: Xiang Mingzhe
 * @version Subsets_78.java, v 0.1 2020/1/3 10:02 XiangMingZhe Exp $
 **/
public class Subsets_78 {

	public static List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		for (int i = 0; i <= nums.length; i++) {
			tempList.clear();
			findSubset(res, tempList, nums, 0, i);
		}

		return res;
	}

	/**
	 * 回溯算法.大致思路和回溯一致,只是加入当前一轮的长度来保证长度顺序而已
	 * @param res
	 * @param tempList
	 * @param nums
	 * @param index
	 * @param length
	 */
	private static void findSubset(List<List<Integer>> res, List<Integer> tempList, int[] nums, int index, int length) {


		if (length == tempList.size()) {
			res.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = index; i < nums.length; i++) {
			tempList.add(nums[i]);
			findSubset(res, tempList, nums, i+1, length);
			tempList.remove(tempList.size()-1);
		}
	}


	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	/**
	 * 使用传统的回溯模板处理,代码简单 直接使用回溯代码模板即可，只是不保证顺序
	 *
	 * @param list
	 * @param tempList
	 * @param nums
	 * @param start
	 */
	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(subsets2(new int[]{4,2,3}));
		System.out.println(subsets(new int[]{4,2,3}));
	}
}
