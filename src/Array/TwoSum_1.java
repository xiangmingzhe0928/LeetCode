package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Array
 * description:LeetCode 第一题：在给定的Int[]找出元素和为指定target的下标，需确保给给定的int[]和target一定有解。
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     You may assume that each input would have exactly one solution.
     Example:Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9,return [0, 1].
     UPDATE (2016/2/13):【最初题目结果下标以1开始 2/13更新变为0开始 更符合大多数编程习惯】
     The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * author:mingzhe Xiang
 * date:2016/8/7
 */
public class TwoSum_1 {

    /**
     * 利用Java里HashMap 遍历数组并记录和快速查找元素 关键在借助containsKey()来快速判断元素是否存在
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //以元素为Key 下标为Value
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,2,3,5},6)));
    }
}
