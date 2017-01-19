package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * HashTable
 * description:判断字符串t是否是字符串s打乱顺序后的单词
 Given two strings s and t, write a function to determine if t is an anagram of s.
 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 Note:
 You may assume the string contains only lowercase alphabets.
 * author:mingzhe Xiang
 * date:2017/1/18
 */
public class ValidAnagram_243 {


    /**
     * 思路：因为本题题意翻译过来只要求判断两字符串S-T各Char个数是否一致即可 无需关心顺序难度降低很多
     * 可以借助HashMap的特性，
     * 记录字符串S包含的每个Char的个数，以Char为Key Char出现的次数为Value的tempMap
     * 遍历字符串T--》每个字符Tchar，查找tempMap中当前保存的 Tchar的个数 小于1的都表示当前Tchar数与S中不一致
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        Map<Character,Integer> tempMap = new HashMap<>();
        Character tempChar;
        //记录原字符串S 各Char出现次数
        for (int i = 0; i < s.length(); i++) {
            tempChar = s.charAt(i);
            tempMap.put(tempChar,tempMap.containsKey(tempChar) ? tempMap.get(tempChar)+1 : 1);
        }
        //对比T和tempChar中相同Char的个数
        for (int i = 0; i < t.length(); i++) {
            tempChar = t.charAt(i);
            if(tempMap.get(tempChar) == null || tempMap.get(tempChar).intValue() < 1)return false;
            tempMap.put(tempChar,tempMap.get(tempChar) - 1);
        }
        return true;
    }

    /**
     * Discuss上MostVotes的答案
     * 用数组保存26个字母
     * 最终的本质思路还是一样的 类似投票算法 S字符串对Char数++ T字符串对Char数--
     *
     * 代码较为简洁 但原程序多了一个for循环
     * 其实完全可以将alphabet[s.charAt(i) - 'a']++ alphabet[t.charAt(i) - 'a']--放在一个for循环中处理
     * 原因：源程序因为没有单独判断T和S的长度问题 所以它需要分别单独遍历T和S从而造成多一个for循环
     * @param s
     * @param t
     * @return
     */
    public boolean mostVotes(String s, String t) {
    //Discuss上源程序
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;

        //可以优化后少一次for循环
//        if(s.length() != t.length())return false;
//        int[] alphabet = new int[26];
//        for (int i = 0; i < s.length(); i++){
//            alphabet[s.charAt(i) - 'a']++;
//            alphabet[t.charAt(i) - 'a']--;
//        }
//        for (int i : alphabet) if (i != 0) return false;
//        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nabaram"));
    }
}
