package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Array
 * description:LeetCode 217题 查找数组中是否有重复元素，只要有任何一个元素重复即为true
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * author:mingzhe Xiang
 * date:2016/11/7
 */
public class ContainsDuplicate_217 {

    /**
     * 借助Java中Set特性能方便处理 但不知道是不是有违题目的本意
     * @param nums
     * @return
     */
    private static boolean containsDuplicate(int[] nums){
        if(nums.length < 2)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{11,2,13,1,3,234,235}));
    }
}
