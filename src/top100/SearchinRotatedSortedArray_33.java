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

		return searchByLoop(nums, target);
//		return searchByRecursive(nums, 0, nums.length - 1, target);
	}

	/**
	 * 由于原数组是升序的 在旋转调整过后 2分后左右两边必然有一部分仍然是升序的
	 * 判断target在左右哪一边后 重复该操作缩小2分范围
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int searchByLoop(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int middleIndex = (left + ((right - left) >> 1));
			if (nums[middleIndex] == target) {
				return middleIndex;
			}
			if (nums[left] > nums[middleIndex]) {
				// 右边有序
				if (nums[middleIndex] < target && nums[right] >= target ) {
					// target在右边
					if (target == nums[right]) {
						return right;
					}
					left = middleIndex + 1;
				} else {
					// target在左边
					right = middleIndex - 1;
				}
			} else {
				//左边有序
				if (nums[middleIndex] > target && nums[left] <= target) {
					// target在左边
					if (target == nums[left]) {
						return left;
					}
					right = middleIndex - 1;
				} else {
					// target在右边
					left = middleIndex + 1;
				}
			}
		}

		return -1;
	}
	
	/**
	 * 递归的方式
	 * @param nums
	 * @param left
	 * @param right
	 * @param target
	 * @return
	 */
	private static int searchByRecursive(int[] nums, int left, int right, int target) {
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
				return searchByRecursive(nums, left, middleIndex - 1, target);
			}
			return searchByRecursive(nums, middleIndex + 1, right, target);
		} else {
			if (temp < target && target < nums[right]) {
				return searchByRecursive(nums, middleIndex + 1, right, target);
			}
			return searchByRecursive(nums, left, middleIndex - 1, target);
		}
	}

	//=====================上面两种[循环]和[递归]只是实现方式不一样,本质是一样的即找到有序的一部分然后判断target所在部分,从而缩小查找范围重复操作找到target
	//=====================另一种思路,因为原数组有序,旋转调整后[最大值]与[最小值]相邻,且[最大值]左边部分有序,[最小值]右边部分有序,找到[最大值]与[最小值]交界的index后可定位target在哪边,直接2分查找即可

	/**
	 * 找到交叉点的方式
	 * @param nums
	 * @param target
	 * @return
	 */
	private static int  searchByFindCrossIndex(int[] nums, int target) {
		int crossIndex = findCrossIndex(nums);
		int leftIndex, rightIndex;
		if (target >= nums[0] && target <= nums[crossIndex]) {
			leftIndex = 0;
			rightIndex = crossIndex;
		} else {
			leftIndex = crossIndex + 1;
			rightIndex = nums.length - 1;
		}
		return binarySearch(nums, leftIndex, rightIndex, target);
	}

	private static int binarySearch(int[] nums, int leftIndex, int rightIndex, int target) {
		while (leftIndex <= rightIndex) {
			int middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
			if (nums[middleIndex] == target) {
				return middleIndex;
			} else if (nums[middleIndex] > target) {

				rightIndex = middleIndex - 1;
			} else {
				leftIndex = middleIndex + 1;
			}
		}
		return -1;
	}

	/**
	 * 找到交叉点中 前面那个元素 [7,8,9,10,-1,0,1,2]===>10     [0,1,2,3]===>3
	 * @param nums
	 * @return
	 */
	private static int findCrossIndex(int[] nums) {
		int leftIndex = 0, rightIndex = nums.length - 1;
		int middleIndex;
		while (leftIndex < rightIndex) {
			middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
			if (nums[leftIndex] > nums[middleIndex]) {
				rightIndex = middleIndex;
			} else if (nums[leftIndex] == nums[middleIndex]) {
				return leftIndex;
			} else {
				leftIndex = middleIndex;
			}
		}

		return leftIndex;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {7,8,9,-1,0,1,2};
//		int[] nums = new int[] {6,7,8,9,10,11,12,-1,0,1,2};
		System.out.println(searchByFindCrossIndex(nums, 2));
	}
}
