package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *<pre>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *</pre>
 *
 * @author: Xiang Mingzhe
 * @version CombinationSum_39.java, v 0.1 2019/12/23 14:26 XiangMingZhe Exp $
 **/
public class CombinationSum_39 {

	/**
	 * 最常见的回溯题,只是考虑下本题的一点特殊性：元素可以重复出现
	 *
	 * @param candidates
	 * @param target
	 * @return
	 */
	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0 || target <= 0) {
			return new ArrayList<>();
		}
		Arrays.sort(candidates);

		List<List<Integer>> result = new ArrayList<>();
		backTrace(result, candidates, target, new ArrayList<>(), 0);
		return result;
	}

	private static void backTrace(List<List<Integer>> result, int[] candidates, int target, List<Integer> existsList, int fromIndex) {

		if (target == 0) {
			result.add(new ArrayList<>(existsList));
			return;
		}
		// 已经排序过, 能保证本轮回溯后续元素均不满足
		if (target < 0) {
			return ;
		}

		for (int i = fromIndex; i < candidates.length; i++) {
			existsList.add(candidates[i]);
			// 递归处理下一层情况  因为元素可以重复出现因此传递的fromIndex为i 而非i+1
			backTrace(result, candidates, target - candidates[i], existsList, i);
			// 回溯
			existsList.remove(existsList.size() - 1);
		}

	}
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{2,3,6,7,9}, 16));
	}

}
