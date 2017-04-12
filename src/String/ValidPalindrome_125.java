package String;

/**
 * String
 * description:判断字符串中（仅字母和数字）是否是回文字符串
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.
 * author:mingzhe Xiang
 * date:2017/2/23
 */
public class ValidPalindrome_125 {

    /**
     * 最初想到的方式 借助Java Buffer的reverse反转整体String 与原来字符串比较
     *
     * 这种方式虽然代码简单 但借助了JDK的API终究不是题目的本意 回文字符串还是需要双指针来处理
     * @param s
     * @return
     */
    public static boolean validByJDKAPI(String s) {
        //正则替换掉所有非alphanumeric
        String newS = s.replaceAll("[^0-9a-zA-Z]", "");
        //借助JDK自带的部分API
        return newS.equalsIgnoreCase(new StringBuffer(newS).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdcbagvfada"));
    }


    /**
     * 最长回文子串
     * DP问题：dp[i][j] = 【 char[i]==char[j] && dp[i+1][j-1] 】
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;

        int len = s.length();
        int maxLen = 1;
        int resultBegin = 0;
        boolean [][] dp = new boolean[len][len];

        for(int subLen=0; subLen<s.length(); subLen++){
            for(int i=0; i<len-subLen; i++){
                int j = i+subLen;
                if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j]=true;

                    //记录当前最大回文子串的长度和起始下标
                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        resultBegin = i;
                    }
                }
            }
        }

        return s.substring(resultBegin,maxLen+resultBegin);
    }
}
