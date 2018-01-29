package Array;

/**
 * Array
 *
 * description:LeetCode 414 找到非空数组中第3大的数并返回，未找到则返回最大的值
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 Example 1: Input: [3, 2, 1] Output: 1 Explanation: The third maximum is 1.
 Example 2:Input: [1, 2] Output: 2 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3: Input: [2, 2, 3, 1] Output: 1 Explanation: Note that the third maximum here
 * author:mingzhe Xiang
 * date:2016/11/7
 */
public class ThirdMaximumNumber_414 {

	/**
	 * 本题最初的想法是类似快排采用分治法处理 对元素K而言 K左边元素全小于K K右边全大于K。从而当右边元素个数为n=2时 K即为第3大元素。但该方法不符合题目要求的O(N)复杂度
	 * 而且考虑到题目中有相同元素的存在 会对左右子列个数造成影响 涉及到去重处理<br>
	 *
	 * 最后采用网上和Discuss推荐的方式 3变量记录max,second,third大小 只需要注意初始类型为long以便能处理Integer.MIN_VALUE的特殊情况
	 * Integer.MIN_VALUE=-2147483648
	 * Long.MIN_VALUE = -9223372036854775808
	 * @param nums
	 * @return
	 */
	private static int thirdMax(int[] nums) {
		long max, second, third;
		max = second = third = Long.MIN_VALUE;
		for (long n : nums) {
			if (n > max) {
				third = second;
				second = max;
				max = n;
			} else if (n < max && n > second) {
				third = second;
				second = n;

			} else if (n < second && n > third) {
				third = n;
			}
		}
		return (int)(third == Long.MIN_VALUE ? max : third);
	}

	public static void main(String[] args) {
		System.out.println(thirdMax(new int[] {1, 3, 3, 15, 8, 4, 6, 17, 10}));
	}
}
