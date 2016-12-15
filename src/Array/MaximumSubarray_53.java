package Array;

/**
 * Array
 * description:求int数组最大连续子串和
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * author:mingzhe Xiang
 * date:2016/12/15
 */
public class MaximumSubarray_53 {

    /**
     * 典型的DP问题
     *
     * 到下标K时【子串】和Sum(k) 必然是Sum(k-1)+nums[K]
     * 又因考虑到数组中负数的情况：到下标K时【最大子串】和MaxSum(k) 必然是max(MaxSum(k-1)+nums[K],MaxSum(k-1))
     *
     * MaxSum(k) = Math.max(MaxSum(k-1)+nums[k],MaxSum(k-1))
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //MaxSum(k) = Math.max(MaxSum(k-1)+nums[k],MaxSum(k-1))
        int maxSubLen = nums[0];//总最大
        int maxCurrenSub = nums[0];//到当前下标 最大子串
        for(int i=1;i<nums.length;i++){
//            if(maxCurrenSub < 0)maxCurrenSub = 0;//若s(k-1)为负数 则以k开始重新求和
//            maxCurrenSub+=nums[i];

            maxCurrenSub = Math.max(maxCurrenSub+nums[i],nums[i]);
            maxSubLen = Math.max(maxSubLen,maxCurrenSub);
        }

        return maxSubLen;
    }
}
