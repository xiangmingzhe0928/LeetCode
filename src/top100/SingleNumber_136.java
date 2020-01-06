package top100;

/**
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 *
 * @author: Xiang Mingzhe
 * @version SingleNumber_136.java, v 0.1 2020/1/6 14:59 XiangMingZhe Exp $
 **/
public class SingleNumber_136 {

	public int singleNumber(int[] nums) {
		int single = nums[0];
		for (int i = 1; i < nums.length; i++) {
			single = single ^ nums[i];
		}

		return single;
	}

	public static void main(String[] args) {
		System.out.println(new SingleNumber_136().singleNumber(new int[]{4,1,2,1,2}));
	}
}
