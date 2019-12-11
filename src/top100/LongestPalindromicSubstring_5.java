package top100;

/**
 * 最大回文子字符串
 *
 *
 * @author: Xiang Mingzhe
 * @version LongestPalindromicSubstring_5.java, v 0.1 2019/12/11 14:21 XiangMingZhe Exp $
 **/
public class LongestPalindromicSubstring_5 {

	/**
	 *
	 * <pre>
	  最容易想到的方式：遍历以i为中间元素求最大回文字符串 时间复杂度太高不考虑；
	  回文字符串最大的特性就是两边对称。
	  abcba是回文字符串 那么从左右边界像中间同时移动后所有子字符串也是回文字符串(bcb也是回文字符串)
	 因此这个是一个典型的DP问题
	 DP公式:
	 	若s(i)==s(j) 则只要s(i-1)==s(j-1)是回文字符串那么s(i,j)也是回文字符串。
	 	DP解决此问题代码简单但是时间复杂度依然不低,并不是最优解O(N^2)
	  </pre>
	 *
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		int length = s.length();
		if (length <= 1) {
			return s;
		}

		//定义二维boolean数组 a[i][j]表示字符串s的S[i,j]子字符串是否是回文字符串
		boolean[][] subStringTag = new boolean[length][length];

		char tempI;
		char tempJ;
		String maxSubString="";

		// 由于需要S(i,j)的结果依赖S(i-1, j+1)的结果，左边界i需要从lengh-1递减，同理右边界需要从i递增
		for (int i = length-1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				tempI = s.charAt(i);
				tempJ = s.charAt(j);
				if (tempI != tempJ) {
//					subStringTag[i][j] = false;
					continue;
				}
				if (j - i <= 2 || subStringTag[i+1][j-1]) {
					subStringTag[i][j] = true;
					String maxSubStringTemp = s.substring(i, j+1);
					maxSubString = maxSubStringTemp.length() > maxSubString.length() ? maxSubStringTemp : maxSubString;
				}
			}
		}
		return maxSubString;
	}

	public static void main(String[] args) {
		String s = "cxcbfbc";
		System.out.println(longestPalindrome(s));
	}
}
