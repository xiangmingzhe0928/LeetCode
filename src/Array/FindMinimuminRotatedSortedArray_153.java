package Array;

/**
 * Array
 * description:nums[]是一个有序数无重复组在事先不知道的情况下部分元素进行旋转得到的元素 如{6,7,0,1,2}由{0,1,2,6,7}旋转得来 找出最小元素
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 Find the minimum element.

 You may assume no duplicate exists in the array.
 * author:mingzhe Xiang
 * date:2016/11/12
 */
public class FindMinimuminRotatedSortedArray_153 {

    /**
     * 单纯思考题的角度：就是找最小值 遍历求得就能得
     * 但遍历的复杂度为O(N)自然不是这道难度为Medium的本意
     * 看了本题的showTags后表明这题属于Array和BinarySearch 后面才去思考BinarySearch的解法
     * 先遍历的方式
     * @param nums
     * @return
     */
    private static int findMinMumRotated(int[] nums){
        if (nums.length == 1)
            return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1])
                return nums[i];
        }
        return nums[0];
    }

    /**
     * BinarySearch的方式 复杂度O(longN)
     * 思路：元数组本是有序的 旋转后会出现从某以元素开始一边有序一边无序的情况，无序的一边必然包含了最小值
     * @param nums
     * @return
     */
    private static int findMinMumByBinarySearch(int[] nums){
        if (nums.length == 0)
            return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int midd;
        while (left < right){
            midd = (right + left) >>> 1;
            if (nums[midd] < nums[midd-1])
                return nums[midd];
            //因为原数组有序 无论旋转哪部分 旋转后无序部分中必然包含最小
            if (nums[midd] > nums[right])
                left = midd + 1;
            else if (nums[midd] < nums[left])
                right = midd - 1;
            else
                return nums[left];
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMinMumByBinarySearch(new int[]{4,5,6,7,8,0,1,2}));
    }
}
