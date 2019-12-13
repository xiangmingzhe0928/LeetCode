package top100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 模拟手机键盘 输入2-9的数字字符串 生成所有的可能组合
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 * @author: Xiang Mingzhe
 * @version LetterCombinationsPhoneNumber_17.java, v 0.1 2019/12/13 9:10 XiangMingZhe Exp $
 **/
public class LetterCombinationsPhoneNumber_17 {
	/**键盘上 数字到字母的映射**/
	private static String[] LETTER_MAPPING = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	/**
	 * 可以借鉴 2叉树按层遍历的方式 在队列中记录下上层遍历的元素再以队列中的元素作tag生成新的队列元素
	 * 此处可以不用借助额外的queue，linedList这种List本身就是Queue的实现类
	 * @param digits
	 * @return
	 */
	public  List<String> letterCombinations(String digits) {
		int length = digits.length();
		if (0 == length) {
			return Collections.emptyList();
		}

		LinkedList<String> result = new LinkedList<>();
		result.add("");
		int digit;
		String mappingString;

		// 前一层遍历完后 生成的字符串
		String preString;
		// 当前层生成的最新字符串
		String currentString;
		for (int i = 0; i < length; i++) {
			digit = digits.charAt(i) - '0';
			if (1 >= digit) {
				return Collections.emptyList();
			}
			mappingString = LETTER_MAPPING[digit];
			// 为了节约内存 不适用额外其他集合 所有操作均在一个List中操作 因此需要判断每轮的结束位置
			while (result.getFirst().length() == i) {
				preString = result.pop();

				for (int j = 0; j < mappingString.length(); j++) {
					currentString = preString + mappingString.charAt(j);

					// 节约内存 直接将本轮新生成的String放入原来的List 但此时List中的元素长度已经+1了 即在本次for结束后 while条件也不满足
					result.add(currentString);
				}
			}

		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("239"));
		System.out.println(letterCombinations("213"));
	}
}
