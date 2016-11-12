package Array;

/**
 * Array
 * description:求数组nums中 元素和>=s的子数组最小长度
 Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.
 * author:mingzhe Xiang
 * date:2016/11/12
 */
public class MinimumSizeSubarraySum_209 {


    /**
     * 想到的方案：
     * (1)穷举所有符合条件的子数组 算的最小长度 算法复杂度太高
     * (2）滑动窗口法 借助前后双指针 O(N)
     * @param s
     * @param nums
     * @return
     */
    private static int minMumSizeSbuarraySum(int s,int[] nums){
        //滑动窗口方式
        int leftPoint = 0;
        int rightPoint = 0;
        int nowMinSum = 0;
        int minSbuarryLength = nums.length + 1;//初始最小子数组长度为原数组长度+1(即初始假定找不到这样的子数组)
        while (rightPoint < nums.length){
            while (nowMinSum < s && rightPoint < nums.length)
                nowMinSum += nums[rightPoint++];
            while (nowMinSum >= s){
                minSbuarryLength = Math.min(minSbuarryLength,rightPoint - leftPoint);
                nowMinSum -= nums[leftPoint++];
            }
        }
       return minSbuarryLength == nums.length + 1 ? 0 : minSbuarryLength;
    }



    public static void main(String[] args) {
        System.out.println(minMumSizeSbuarraySum(7,new int[]{1,1,1,5,4,3}));
    }

}
