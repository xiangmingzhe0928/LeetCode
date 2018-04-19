package String;

/**
 * String
 * 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。
 * 如果在source中没有这样的子串，返回""，如果有多个这样的子串，返回起始位置最小的子串。

 * 在答案的子串中的字母在目标字符串中[不需要]具有相同的顺序
 *
 * 样例
 * 给出source = "ADOBECODEBANC"，target = "ABC" 满足要求的解 "BANC"
 * author:mingzhe Xiang
 * date:2018/4/16
 */
public class MinSubStringOverride {

	private static String minWindow(String source, String target) {
		//以字符的ascii码为下标 构建字符数组 代表对应字符出现次数
		int[] targetArray = new int[128];
		int[] sourceArray = new int[128];

		//初始化 targetArray
		for (int i = 0; i < target.length(); i++) {
			targetArray[target.charAt(i)]++;
		}
		//当前最小覆盖子串长度
		int minSubStringLength = source.length();
		//记录当前起始index
		int start = 0;
		//当前最小覆盖子串的begIndex
		int begIndex = -1;
		//当前最小覆盖子串的endIndex
		int endIndex = source.length();
		//当前匹配到的字符数
		int matchCount = 0;
		for (int i = 0; i < source.length(); i++) {
			sourceArray[source.charAt(i)]++;

			if (sourceArray[source.charAt(i)] <= targetArray[source.charAt(i)]) {
				matchCount++;
			}
			if (matchCount == target.length()) {
				//匹配成功 找到一个覆盖子串

				//找到本次子串的start
				while (start < i && sourceArray[source.charAt(start)] > targetArray[source.charAt(start)]) {
					sourceArray[source.charAt(start++)]--;//还原无效字符出现次数
				}

				//本次子串长度更小，记录最新数据
				if (i - start < minSubStringLength) {
					minSubStringLength = i - start;
					begIndex = start;
					endIndex = i;
				}

				//开始下一轮匹配
				sourceArray[source.charAt(start++)]--;
				matchCount--;
			}
		}

		if (begIndex == -1) {
			return "";
		}
		return source.substring(begIndex, endIndex + 1);
	}

	public static void main(String[] args) {
		String source = "ADOBEOODAEGFNC";
		String target = "ABC";
		System.out.println(minWindow(source, target));
	}
}
