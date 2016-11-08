package String;

/**
 * String
 * description:二进制字符串相加
 *
    Given two binary strings, return their sum (also a binary string).
     For example,
     a = "11"
     b = "1"
     Return "100"
 * author:mingzhe Xiang
 * date:2016/11/8
 */
public class AddBinary_67 {

    /**
     * 本题逻辑难度还是不大的 考虑到进位（carry）操作即可
     *
     *
     * @param a
     * @param b
     * @return
     */
    private static  String addBinary(String a,String b){
        StringBuilder sb = new StringBuilder();
        int carry = 0;//进位标志
        String longerString=b,lesserString=a;
        if(a.length() > b.length()){
            longerString = a;
            lesserString = b;
        }
        int currData = 0;
        //以短字符串为准 求的各位运算结果

        //这里若以长字符串长度为标准 可少去后面的第二个for循环，但需要在本for中每次if来避免下标越界
        //从结果来看 两者差距不大
        for (int i = 1; i <= lesserString.length() ; i++) {
            //当前位实际运算结果
            currData = longerString.charAt(longerString.length() - i)-'0'+lesserString.charAt(lesserString.length()-i)-'0'+carry;
            //进位数
            carry = currData/2;

            sb.append(currData%2);
        }
        //长字符串多出部分单独运算(即也可看作短字符串不足位补0)
        for (int i = longerString.length()-lesserString.length() - 1; i >=0 ; i--) {
            currData = longerString.charAt(i) - '0' + carry;
            carry = currData/2;
            sb.append(currData%2);
        }

        return carry == 1?carry+sb.reverse().toString():sb.reverse().toString();
    }

    /**
     * Discuss上Votes最高的答案 原答案是C++
     * 特点就在 （|| C==1）
     * @param a
     * @param b
     * @return
     */
    private static String mosetVotes(String a,String b){
        String s = "";
        int c = 0, i = a.length() - 1, j = b.length() - 1;
        while(i >= 0 || j >= 0 || c == 1)
        {
            c += i >= 0 ? a.charAt(i--) - '0' : 0;
            c += j >= 0 ? b.charAt(j--) - '0' : 0;
            s = c % 2 + s;
            c /= 2;
        }

        return s;

    }

    /**
     * Disscuss上Votes较高的代码
     * 本质与自己的方式是一样的 但这种方式需要每次循环都进行2次判断 即使短字符串所有位都已经结束运算
     * @param a
     * @param b
     * @return
     */
    private static String mosetVotes1(String a,String b){
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() -1, carry = 0;
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (j >= 0) sum += b.charAt(j--) - '0';
                if (i >= 0) sum += a.charAt(i--) - '0';
                sb.append(sum % 2);
                carry = sum / 2;
            }
            if (carry != 0) sb.append(carry);
            return sb.reverse().toString();
        }
    public static void main(String[] args) {
        System.out.println(mosetVotes("111","1011"));
    }
}
