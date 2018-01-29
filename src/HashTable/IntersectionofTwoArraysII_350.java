package HashTable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * HashTable
 * description:找到2数组中交集，结果数组中元素可重复，顺序无关
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:进阶选项
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * author:mingzhe Xiang
 * date:2017/1/12
 */
public class IntersectionofTwoArraysII_350 {

	/**
	 * 对数组分别排序后，借助双指针分别指向nums1,nums2 一一比较
	 * 1.相等(交集)则存入数组 两指针同时后移
	 * 2.不相等 则移动较小数组指针
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		//排序原数组
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int point1 = 0, point2 = 0;
		ArrayList<Integer> intersectList = new ArrayList<>();
		while (point1 < nums1.length && point2 < nums2.length) {

			if (nums1[point1] == nums2[point2]) {
				//记录交集元素
				intersectList.add(nums1[point1]);
				//后移指针
				point1++;
				point2++;
			} else if (nums1[point1] > nums2[point2])
				point2++;
			else
				point1++;
		}

		int[] res = new int[intersectList.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = intersectList.get(i);
		}
		return res;
	}
}
