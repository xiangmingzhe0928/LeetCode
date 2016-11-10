package Array;

import java.util.Arrays;

/**
 * Array
 * description: 合并两个有序数组 合并后数组也必须有序 【nums2合并到nums1 】
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * author:mingzhe Xiang
 * date:2016/11/10
 */
public class MergeSortedArray_88 {


    /**
     *
     * 应从后往前遍历 能避免nums1的所有元素都必须移动的问题
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void mergeSortedArray(int[] nums1,int m ,int[] nums2,int n){
        //合并后新数组的有效元素最大索引
        int newIndex = m + n - 1;

        //每轮获取当前最大元素放在m+n-1处 直到其中一数组遍历完
        while (m-1>=0 && n-1 >= 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[newIndex] = nums1[m-1];
                m --;
            }else{
                nums1[newIndex] = nums2[n-1];
                n -- ;
            }
            newIndex --;
        }
        //若num1还未遍历结束 可直接返回了 因为本来就是在nums1上合并的 nums1剩余的元素无需变动位置
        //若num2还未遍历结束 直接将nums2剩余元素放入剩下nums1中
        while(n-1 >= 0){
            nums1[newIndex] = nums2[n-1];
            n--;
            newIndex--;
        }


    }

    /**
     * Discuss上MostVotes答案
     * 逻辑其实是和自己一样的 牛就牛在代码简洁 不过可阅读性不是太强
     * @param A
     * @param m
     * @param B
     * @param n
     */
    private static void mostVotes(int[] A,int m,int[] B,int n){

//        while(n>0)
//            A[m+n-1]= (m==0||B[n-1]>A[m-1]) ? B[--n] : A[--m];

        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1)
            A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        while (j>-1)
            A[k--]=B[j--];
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,4,6,8,10,0,0,0,0,0};
        int[] nums2 = new int[]{3,5,7,9};
        mergeSortedArray(nums1,5,nums2,4);
        System.out.println(Arrays.toString(nums1));
//        mergeArray(nums1,5,nums2,4);

    }
}
