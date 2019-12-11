package top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 找到最长子字符串
 *
 * NOTE：此题只允许[substring] 不允许[subsequence]
 *
 * @author: Xiang Mingzhe
 * @version LongestSubstringWithoutRepartChar_3.java, v 0.1 2019/12/10 15:59 XiangMingZhe Exp $
 **/
public class LongestSubstringWithoutRepartChar_3 {

	/**
	 * 最直接的想法 遍历s
	 *
	 * O(N^2)不是该题的本意
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();

		if (length <= 1) {
			return length;
		}
		int longestLength = 0;
		Set<Character> longestChar = new HashSet<>(length);
		StringBuilder longestSubString;
		for (int i = 0; i < length; i++) {
			longestSubString = new StringBuilder(s.charAt(i) + "");
			longestChar.add(s.charAt(i));
			for (int j = i+1; j < length; j++) {
				char temp = s.charAt(j);
				if (longestChar.contains(temp)) {
					break;
				}
				longestChar.add(temp);
				longestSubString.append(temp);
			}
			if (longestSubString.length() > longestLength) {

				longestLength = longestSubString.length();
			}

			longestChar.clear();
		}

		return longestLength;
	}

	/**
	 * 滑动窗口法
	 * 左右指针控制窗口边界
	 * @param s
	 * @return
	 */
	private static int sloveWithWindowSliding(String s) {
		int length = s.length();
		if (length <= 1) {
			return length;
		}

		// 窗口左边界指针
		int leftP = 0;
		int maxLength = 0;
		char temp;

		// key:字符串字符 value:该字符所在字符串index
		Map<Character, Integer> elementMap = new HashMap<>(length);
		// 变量i即为窗口右边界指针
		for (int i = 0; i < length; i++) {
			temp = s.charAt(i);
			if (elementMap.containsKey(temp)) {
				// 若该字符已经出现过 则需要选择左边界位置
				int lastDuplicateIndex = elementMap.get(temp);
				if (leftP <= lastDuplicateIndex) {
					// 若该重复元素上次出现位置在 leftP左边 则需要跨过上次出现位置 以保证不重复子串
					leftP = lastDuplicateIndex + 1;
				}

				//leftP = Math.max(leftP, elementMap.get(temp) + 1);

			}
			elementMap.put(temp, i);
			maxLength = Math.max(maxLength, i - leftP + 1);
		}
		return maxLength;
	}


	public static void main(String[] args) {
		System.out.println(sloveWithWindowSliding("abbabc"));
		System.out.println(lengthOfLongestSubstring("abbabc"));

	}
}
