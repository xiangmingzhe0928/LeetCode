package Array;

/**
 * Array
 * description:
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 For example,
 Given input array nums = [1,1,2],
 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * author:mingzhe Xiang
 * date:2016/11/9
 */
public class RemoveDuplicatesfromSortedArray_26 {

    /**
     * 遍历原数组 记录与新数组前一位是否相等 相等则continue
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        //记录不重复的个数
        int count = 1;
        //当前标志数
        int currItem = nums[0];
        //当前标志位index
        int currIndex = 0;
        for(int i=1;i<=nums.length - 1;i++){
            //遍历得到下一个与标志位不重复的元素 并将该元素放置在标志位后一位 同时标志位变更为该元素进行后续循环
            if(currItem != nums[i]){
                currItem = nums[i];
                nums[currIndex + 1] = nums[i];
                currIndex ++;
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,3};
        removeDuplicates(nums);
        for (int n : nums) {
            System.out.print(n+",");

        }
    }
}
