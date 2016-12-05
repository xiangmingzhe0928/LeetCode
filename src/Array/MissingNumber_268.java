package Array;

/**
 * Array
 * description:给定一个不重复元素的数组 数组元素为[0,N] 其中会丢失一个数 找到该元素
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 For example,
 Given nums = [0, 1, 3] return 2.
 * author:mingzhe Xiang
 * date:2016/12/5
 */
public class MissingNumber_268 {

    /**
     * 本题是大学的时候做的一道题 本质上上一道数学题 因为不重复元素，无论顺序如何或者无论丢失哪个数
     * 数组总数不会，因此Sum(1-N) - Sum(nums)得到的值就是Missing的值
     *
     * XOR后运算 效率更高
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            //XOR运算 相同数异或为0  0与任何数异或为任何数
            temp ^= (i ^ nums[i]);
        }
        return temp^nums.length;
    }
}
