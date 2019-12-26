package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 * @author: Xiang Mingzhe
 * @version GroupAnagrams_49.java, v 0.1 2019/12/26 14:06 XiangMingZhe Exp $
 **/
public class GroupAnagrams_49 {

	/**
	 * 排序后存入hashMap中
	 * 能解决问题,但每个元素均需要:1.转成char[] 2.排序char[] 3转成string存入hashMap 复杂度太高
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return Collections.emptyList();
		}

		Map<String, List<String>> anagrams = new HashMap<>();

		String itemStr;
		char[] itemCharArray;
		String tempStr;
		for (String str : strs) {
			itemStr = str;
			itemCharArray = itemStr.toCharArray();
			Arrays.sort(itemCharArray);

			tempStr = Arrays.toString(itemCharArray);
			if (anagrams.containsKey(tempStr)) {
				anagrams.get(tempStr).add(itemStr);
			} else {
				List<String> tempList = new ArrayList<>();
				tempList.add(itemStr);
				anagrams.put(tempStr, tempList);
			}
		}
		return new ArrayList<>(anagrams.values());
	}

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}
