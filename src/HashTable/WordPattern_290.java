package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * HashTable
 * description:给定一个字符串pattern作为格式,判断目标字符串str是否符合pattern格式
 Given a pattern and a string str, find if str follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * author:mingzhe Xiang
 * date:2017/1/16
 */
public class WordPattern_290 {

	/**
	 * 考虑借助HashMap保存pattern中各字符代表的字符串 对str一一比较
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static boolean wordPattern(String pattern, String str) {
		String[] targetStrArray = str.split(" ");
		if (pattern.length() != targetStrArray.length)
			return false;

		Map<Character, String> patternMap = new HashMap<>();
		Map<String, Character> strMap = new HashMap<>();
		char tempChar;
		String tempStr;
		for (int i = 0; i < pattern.length(); i++) {
			tempChar = pattern.charAt(i);
			tempStr = targetStrArray[i];

			if (patternMap.containsKey(tempChar)) {//该标志char已代表某个字符串
				if (!patternMap.get(tempChar).equals(tempStr))
					return false;
			} else {
				//target字符串是否已经被某个char代表
				if (strMap.containsKey(tempStr)) {//可以使用contansValue()简化代码 但这种方式O(N)效率不高
					if (!strMap.get(tempStr).equals(tempChar))
						return false;
				}
				//对应关系分别保存到2个hashMap
				patternMap.put(tempChar, tempStr);
				strMap.put(tempStr, tempChar);
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}
}
