package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array
 * description:找到数组的所有不重复的子集。(数组中可能会有重复数字)
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 Note: The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:
 [
 [2],[1],[1,2,2],[2,2],[1,2],[]
 ]
 * author:mingzhe Xiang
 * date:2016/11/15
 */
public class SubsetsII_90 {

	public static List<List<Integer>> subset2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, 0, res, new ArrayList<Integer>());
		return res;
	}

	private static void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
		if (pos <= nums.length) {
			System.out.println("ps:" + pos + "--->" + tmpRes);
			res.add(new ArrayList<>(tmpRes));
		}

		for (int i = pos; i < nums.length; i++) {
			if (i > pos && nums[i] == nums[i - 1])
				continue;
			tmpRes.add(nums[i]);
			dfs(nums, i + 1, res, tmpRes);
			tmpRes.remove(tmpRes.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(subset2(new int[] {1, 2, 2}));
	}
}
