package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Array
 * description:用数组来表示一个10进制数 对这个数加1后仍然用该数组表示。实际就是模拟10进制加1
 *
 *Given a non-negative number represented as an array of digits, plus one to the number.
 The digits are stored such that the most significant digit is at the head of the list.
 * author:mingzhe Xiang
 * date:2016/8/10
 */
public class PlusOne_66 {


    /**
     * 拿到本题 因为早前做了一个字符串模拟2进制加法的题
     * 先入为主了。强迫的想计算是否有进位 然后判断首位来确定是否需要增加数组长度
     *
     * 等写完后 看代码觉得很别扭 其实对于本题而言只是PLUS ONE。
     * 其实根本无需记录是进位 从“个位”开始只要判断当前位若不等于9则当前位+1后方法即可返回
     * 等于9则当前位赋值0 进入下一位。当数组遍历完后方法仍然未返回则必然是原数组所有位全为9 则新建length+1长度的首位为1的数组即可。
     * 后来看Discuss上 果然这种方式才是正解。
     *
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits){
        int carry = 1;//进位
        int temp;
        for (int i = digits.length-1; i >= 0  ; i--) {
            temp = digits[i] + carry;
            digits[i] = temp%10;
            carry = temp/10;
            //当前位无需进位 则可结束运算
            if(carry == 0)
                return digits;
        }
        //能运行完for且未return 表明所有位都有进位[9] [9,9,9]...
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * Discuss上MostVotes答案
     * 无需记录是否进位
     * @param digits
     * @return
     */
    public static int[] mostVotes(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{})));
    }
}
