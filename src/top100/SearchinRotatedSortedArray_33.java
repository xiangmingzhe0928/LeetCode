package top100;

/**
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author: Xiang Mingzhe
 * @version SearchinRotatedSortedArray_33.java, v 0.1 2019/12/17 13:29 XiangMingZhe Exp $
 **/
public class SearchinRotatedSortedArray_33 {

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		return findMiddle(nums, 0, nums.length - 1, target);
	}

	/**
	 * 由于原数组是升序的 在旋转调整过后 2分后左右两边必然有一部分仍然是升序的
	 * 判断target在左右哪一边后 重复该操作缩小2分范围
	 * @param nums
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	private static int findMiddle(int[] nums, int left, int right, int target) {
		if (left >= right) {
			return nums[left] == target ? left : -1;
		}
		int middleIndex = left + ((right - left) >> 1);
		int temp = nums[middleIndex];
		if (temp == target) {
			return middleIndex;
		}
		if (nums[left] == target) {
			return left;
		}
		if (nums[right] == target) {
			return right;
		}
		// 左边有序
		if (nums[left] < temp) {
			// target是否在左边
			if (nums[left] < target && temp > target) {
				return findMiddle(nums, left, middleIndex - 1, target);
			}
			return findMiddle(nums, middleIndex + 1, right, target);
		} else {
			if (temp < target && target < nums[right]) {
				return findMiddle(nums, middleIndex + 1, right, target);
			}
			return findMiddle(nums, left, middleIndex - 1, target);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3};
		System.out.println(search(nums, 0));
	}
}
