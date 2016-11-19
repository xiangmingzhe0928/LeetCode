package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Array
 * description:找到数组中重复的元素
 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 Find all the elements that appear twice in this array.
 Could you do it without extra space and in O(n) runtime?
 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]
 * author:mingzhe Xiang
 * date:2016/11/18
 */
public class FindAllDuplicates_442 {

    /**
     * 借助JAVA Set特性实现很方便
     * 但开辟了新空间 不符合题目的进阶要求（without extra space and in O(n) ）
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if(set.remove(n))
                res.add(n);
            else
                set.add(n);

        }
        return res;
    }

    /**
     * Discuss上MostVotes答案（no extra sapce）
     * 因为题目限制了 1<=nums[i]<=n
     * 可以反转思路：将元素内容作为元素下标。已操作过的元素赋为负数。
     * 4,3,2,7,8,2,3,1
     * @param nums
     * @return
     */
    public static List<Integer> mostVotes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1,4}));
    }
}
