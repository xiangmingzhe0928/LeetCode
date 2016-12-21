package Array;

/**
 * Array
 * description:在不重复的有序数组nums[]中找到target的下标 未找到则给出target应插入的下标
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 You may assume no duplicates in the array.
 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 * author:mingzhe Xiang
 * date:2016/12/21
 */
public class SearchInsertPosition_35 {

    /**
     * 最典型的BinarySearch
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;
        if(target > nums[nums.length-1])return nums.length;

        int leftIndex = 0,rightIndex = nums.length -1;
        int middIndex;
        //BinarySearch
        while (leftIndex <= rightIndex){
            //求的midd下标
            middIndex = (rightIndex + leftIndex) >>> 1;
            //缩小Search范围
            if(target == nums[middIndex])return middIndex;
            else if(nums[middIndex] > target) rightIndex = middIndex - 1;
            else leftIndex = middIndex+1;

        }
        return leftIndex;
    }


    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,3,4,5,10},2));
    }
}
