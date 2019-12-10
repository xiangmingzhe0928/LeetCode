package top100;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version TwoSum_1.java, v 0.1 2019/12/9 17:07 XiangMingZhe Exp $
 **/
public class TwoSum_1 {

	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		Map<Integer, Integer> temp = new HashMap(length);
		int[] res = new int[2];
		for (int i = 0; i < length; i++) {
			int firstKey = target - nums[i];
			if (temp.containsKey(firstKey)) {
				res[0] = temp.get(firstKey);
				res[1] = i;
				break;
			}
			temp.put(nums[i], i);
		}
		return res;
	}
}
