package Array;

/**
 * Array
 * description:33题升级版
 * 数组nums[]是由有<B>可能重复</B>的有序数组旋转得来的 从nums[]能否中找出给定的target
 * author:mingzhe Xiang
 * date:2016/11/19
 */
public class SearchinRotatedSortedArray_81 {


    private static boolean search(int[] nums, int target) {
        int index = -1;
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int middIndex;
        while (leftIndex <= rightIndex){
            middIndex = (rightIndex + leftIndex) >>> 1;
            if(nums[middIndex] == target)
                return true;

            //旋转后 数组必然被middIndex分割为有序和无序的两个小数组
            if(nums[middIndex] > nums[rightIndex]){//midd元素>right元素 则右边必然是无序的
                if(target == nums[leftIndex])
                    return true;
                //左边有序
                if(target < nums[middIndex] && target > nums[leftIndex])
                    rightIndex = middIndex - 1;
                else
                    leftIndex = middIndex + 1;
            }else{
                //右边有序
                if(target == nums[rightIndex])
                    return true;
                if(target > nums[middIndex] && target < nums[rightIndex])
                    leftIndex = middIndex+1;
                else
                    rightIndex = middIndex - 1;

            }
            //作为33题升级版 本题的核心就在leftIndex++
            //因为相比33题本题允许出现重复数字。这就导致2分过后极端情况下会造成无法判断下次应该在左右哪一边进行
            // 比如(1,1,3,1,1)有这2种情况:11131  13111。出现这种情况后只能leftIndex左移移位重新2分查找
            leftIndex++;

        }

        return false;
    }




    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,1,1,3},3));//       11311   11131  13111
    }
}
