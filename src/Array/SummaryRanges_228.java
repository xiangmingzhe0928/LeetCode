package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Array
 * description:返回有序数组中连续的子串列表
 Given a sorted integer array without duplicates, return the summary of its ranges.
 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * author:mingzhe Xiang
 * date:2016/11/14
 */
public class SummaryRanges_228 {

    /**
     * 遍历暴力解法
     * 复杂读高 LeetCode上Beats率太低
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int n = 0;
        int left,right;
        while(n < nums.length){
            left = nums[n];
            while(n<nums.length-1 && nums[n+1] == nums[n]+1)
                n++;

            right = nums[n];
            if(left == right)
                res.add(""+nums[n]);
            else
                res.add(left+"->"+right);
            n++;
        }
        return res;
    }

    public static List<String> summaryRangesBinarySearch(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int midd;
//        while(left < right){
//            midd = (right+left)>>>1;
//            if(nums[left] == nums[midd] - (midd-left)){
//                StringBuilder sb = new StringBuilder();
//                int temp = left;
//               while(temp < midd){
//                   sb.append(nums[temp++]);
//               }
//               if(nums[midd] + 1)
//            }else if(){
//
//            }
//        }
        return null;
    }
}
