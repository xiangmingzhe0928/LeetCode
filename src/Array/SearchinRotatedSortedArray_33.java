package Array;

/**
 * Array
 * description：数组nums[]是由不重复有序数组旋转得来的 从nums[]中找出给定的target的下标index 未找到则返回-1
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 *
 * author:mingzhe Xiang
 * date:2016/11/19
 */
public class SearchinRotatedSortedArray_33 {

    /**
     * 虽然数组是经过旋转后的，但由于原数组是有序的 仍然可以考虑变通使用BinarySearch
     * 2分查找后数组必然被分成有序和无序两部分 这时就能先判断target是否在有序子串内从而达到缩小下轮查找范围的目的
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int index = -1;
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int middIndex;
        while (leftIndex <= rightIndex){
            middIndex = (rightIndex + leftIndex) >>> 1;
            if(nums[middIndex] == target)
                return middIndex;

            //旋转后 数组必然被middIndex分割为有序和无序的两个小数组
            if(nums[middIndex] > nums[rightIndex]){//midd元素>right元素 则右边必然是无序的
                if(target == nums[leftIndex])
                    return leftIndex;
                //左边有序
                if(target < nums[middIndex] && target > nums[leftIndex])
                    rightIndex = middIndex - 1;
                else
                    leftIndex = middIndex + 1;
            }else{
                //右边有序
                if(target == nums[rightIndex])
                    return rightIndex;
                if(target > nums[middIndex] && target < nums[rightIndex])
                    leftIndex = middIndex+1;
                else
                    rightIndex = middIndex - 1;

            }
        }

        return index;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,3,1},3));
    }
}
