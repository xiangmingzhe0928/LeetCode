package String;

/**
 * String
 *
 * description: LeetCode第58题 求得给定字符串中最后一个空格"' '"后的单词长度<br>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 If the last word does not exist, return 0.
 Note: A word is defined as a character sequence consists of non-space characters only.
 For example, Given s = "Hello World", return 5.
 * author:mingzhe Xiang
 * date:2016/8/6
 */
public class LegthOfLastWord_58 {

	/**
	 * 从后往前循环 略过末尾是空字符(trim)的情况
	 *
	 *
	 * PS：第一次Submit时 未考虑末尾空字符串情况 导致AC失败 还是考虑不周
	 * @param s
	 * @return
	 */
	private static int lengthOfLastWord(String s) {
		int n = s.length(), count = 0;
		if (n == 0)
			return 0;
		//skip末尾空字符
		while (s.charAt(n - 1) == ' ')
			n--;
		while (n >= 1) {
			if (s.charAt(n - 1) == ' ')
				break;
			count++;
			n--;
		}
		return count;
	}

	/**
	 * LeetCode上MostVotes最多的方案
	 * 编写方便 但借助了String的内置API
	 * @param s
	 * @return
	 */
	public static int mostVotes(String s) {
		return s.trim().length() - 1 - s.trim().lastIndexOf(" ");
	}

	public static void main(String[] args) {
		String s = "Hello Java ";
		System.out.println(lengthOfLastWord(s));
	}
}
