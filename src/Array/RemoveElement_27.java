package Array;

import java.util.Arrays;

/**
 * Array
 * description:26题的升级版 在不开辟新数组的情况下从数组Nums[]中删除指定val 只需要给出新数组的大小（It doesn't matter what you leave beyond the new length）
 Given an array and a value, remove all instances of that value in place and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 Example:
 Given input array nums = [3,2,2,3], val = 3
 Your function should return length = 2, with the first two elements of nums being 2.
 * author:mingzhe Xiang
 * date:2016/11/9
 */
public class RemoveElement_27 {

	/**
	 * 和26题相比 本题稍微增加了难度 数组不再有序
	 * 若像26题采用同样的方式处理：记录remove的index 并用未remove的元素来替换也是能方便实现的。
	 * 而且Discuss上MostVotes答案（见mostVotes方法）就是采用的这种方式 毕竟这种方式很容易理解且代码量较少
	 * 这种方式有点类似插入排序在极端情况下所有未remove的元素都需要整体移动一次，而本题和26不一样明确指明了新的数组无需保证原有的顺序
	 * 比如mostVotes({1,2,3,4,5,6},1)这种情况下本来只需要简单的将nums[0]赋值为nums[5]即可 而采用mostVotes则会对依次赋值6次 有点多余
	 *
	 * 因此思考能不能直接将需要remove的位置替换为符合条件的元素 想到快速排序中左右哨兵的方式就能解决了
	 * PS：这种和快排一样是不稳定的方式 运行速度依赖当次test cases。 自己在LeetCode Submit多次 平均RunTime和Beats率都还行。
	 *
	 *
	 *
	 * @param nums
	 * @param val
	 * @return
	 */
	private static int removeElements(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0] == val ? 0 : 1;
		int leftPoint = 0;//左指针
		int rightPoint = nums.length - 1;//右指针
		while (leftPoint <= rightPoint) {
			if (nums[leftPoint] == val) {
				while (leftPoint <= rightPoint) {
					if (nums[rightPoint] != val) {
						nums[leftPoint] = nums[rightPoint];
						leftPoint++;
						rightPoint--;
						break;
					}
					rightPoint--;
				}
			} else {
				leftPoint++;
			}

		}
		return leftPoint;
	}

	/**
	 * Discuss上MostVotes答案
	 * 和26题的处理方式一样 代码简洁逻辑也十分好理解
	 * @param A
	 * @param elem
	 * @return
	 */
	private static int mostVotes(int A[], int elem) {
		int begin = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem)
				A[begin++] = A[i];
		}
		return begin;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {3, 1, 3, 3};
		System.out.println(removeElements(nums, 3));
		System.out.println(Arrays.toString(nums));
	}
}
