package Array;

import java.util.Arrays;

/**
 * Array
 * description:26题的升级版 同一元素最多能出现2次 去除多余的元素后数组个数
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array nums = [1,1,1,2,2,3],
 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * author:mingzhe Xiang
 * date:2016/11/18
 */
public class RemoveDuplicatesfromSortedArrayII_80 {

    private static int removeDuplicate(int[] nums){
        int leftIndex = 1, rightIndex = 1;
        int itemCount = 1;
        while (rightIndex < nums.length) {
            if (nums[rightIndex] != nums[rightIndex-1]) {
                itemCount = 1;//遇到新元素 itemCount重置为1
                nums[leftIndex] = nums[rightIndex];
                leftIndex++;
            }else {
                if (itemCount < 2) {
                    nums[leftIndex] = nums[rightIndex];
                    leftIndex++;
                    itemCount++;
                }
            }
            rightIndex++;
        }
        return leftIndex;
    }


    /**
     *
     * @param nums
     * @param dupCount 允许重复最大次数
     * @return
     */
    private static int mostVotes(int[] nums,int dupCount){
        if(nums.length<dupCount) return nums.length;
        int i,j;
        for(i=dupCount,j=dupCount ; i<nums.length;i++)
            if(nums[j-dupCount]!=nums[i])
                nums[j++]=nums[i];
        return j;

//        int i = 0;
//        for (int n : nums)
//            if (i < 2 || n > nums[i-2])
//                nums[i++] = n;
//        return i;
    }
    public static void main(String[] args) {
//        Arrays.asList(1,2,3,4,5).forEach(e -> System.out.println(e));

//        Arrays.asList(1,2,3,4,5).forEach(System.out::println);
        System.out.println(removeDuplicate(new int[]{1,1,1,2,2,2,3,3}));
    }
}
