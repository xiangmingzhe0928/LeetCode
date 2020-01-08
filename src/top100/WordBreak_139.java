package top100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 * @author: Xiang Mingzhe
 * @version WordBreak_139.java, v 0.1 2020/1/7 11:08 XiangMingZhe Exp $
 **/
public class WordBreak_139 {


	public boolean wordBreak(String s, List<String> wordDict) {
		// 动态规划 设dp[i]表示s(0,i)子串是否是满足条件的子串 则s(0,j)=s(0,i)&&s(i,j)
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;// 空字符串
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[s.length()];
	}

	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new WordBreak_139().wordBreak("leetcode", wordDict));
	}
}
