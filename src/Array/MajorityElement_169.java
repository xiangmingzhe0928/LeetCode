package Array;

import java.util.Arrays;

/**
 * Array
 * description:找到数组中出现次数超过n/2次的元素 需确保所给出的数组确实存在这样的元素
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
   You may assume that the array is non-empty and the majority element always exist in the array.
 * author:mingzhe Xiang
 * date:2016/11/7
 */
public class MajorityElement_169 {

    /**
     * 思路：超过n/2次 那么排序后中间位必定就是该元素
     * 但这种方式多了排序过程 不是太好
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * LeetCode上MostVotes答案
     * 元素相同计数+1 元素不同计数-1 【简单理解2元素不同则抵消掉】
     * 在题目超过n/2并且必定有解的前提下 最终剩下的必定是超过n/2的元素
     * @param nums
     * @return
     */
    private static int mostVotes(int[] nums){
        int count = 1;
        int majorityElement = nums[0];//1,2,2,3,2,4,2
        for (int i = 1; i <nums.length ; i++) {
            if(count == 0){
                majorityElement = nums[i];
            }else if(majorityElement == nums[i]){
                count ++ ;
            }else{
                count --;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        System.out.println(mostVotes(new int[]{2,1,3,4,5,6,2}));
    }
}
