package BinarySearch;

import java.util.Arrays;

/**
 * BinarySearch
 * description:从有序数组中找出指定target的范围，返回下标区间。需保证target确实在nums[]里存在
 *
 Given a sorted array of integers, find the starting and ending position of a given target value.
 Your algorithm's runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return [-1, -1].
 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * author:mingzhe Xiang
 * date:2016/11/8
 */
public class SearchforaRange_34 {

    /**
     * 很典型的BinarySearch
     * 看到有序数组+查找 应该条件反射到BinarySearch，无论最终是否选用BinarySearch
     *
     * 本题可BinarySearch查找到target后，以找到的index为起点前后遍历直到2边界的target.[...8,8,【8】,8,8]
     * @param nums
     * @param target
     * @return
     */
    private static int[] searchForRange(int[] nums,int target){
        //初始化各标志位
        int middleElement;
        int leftIndex = 0,rightIndex = nums.length - 1;
        int targetIndex = -1,middleIndex = -1;
        //BinarySearch通用方式
        while(leftIndex <= rightIndex){
            middleIndex = (rightIndex + leftIndex)>>>1;
            middleElement = nums[middleIndex];
            if(middleElement == target){
                targetIndex = middleIndex;
                break;
            }else if(middleElement > target){
                rightIndex = middleIndex - 1;
            }else{
                leftIndex = middleIndex + 1;
            }
        }

        if(targetIndex == -1)
            return new int[]{-1,-1};

        //以targetIndex为起点 前后遍历寻找target边界
        int startIndex=targetIndex,endIndex=targetIndex;
        while(endIndex < nums.length - 1 && nums[endIndex + 1] == target){
            endIndex = endIndex + 1;
        }
        while(startIndex > 0 && nums[startIndex - 1] == target){
            startIndex = startIndex - 1;
        }
        return new int[]{startIndex,endIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchForRange(new int[]{1,2,3,4,6,6,6,6,6,8,9,11},6)));
    }
}
