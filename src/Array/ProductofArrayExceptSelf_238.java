package Array;

import java.util.Arrays;

/**
 * Array
 * description:给定一个长度大于1的数组nums,求的一个返回数组output（output的元素output[i]是nums除i元素外所有其他元素的乘积）
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 Solve it without division and in O(n).
 For example, given [1,2,3,4], return [24,12,8,6].
 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * author:mingzhe Xiang
 * date:2016/11/18
 */
public class ProductofArrayExceptSelf_238 {

    /**
     * O(N)
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(res));
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
