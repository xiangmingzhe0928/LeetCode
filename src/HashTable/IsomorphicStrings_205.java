package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * HashTable
 * description:判断2字符串S、T是否是同形结构 （S,T长度相同）
 Given two strings s and t, determine if they are isomorphic.
 Two strings are isomorphic if the characters in s can be replaced to get t.
 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 For example,
 Given "egg", "add", return true.
 Given "foo", "bar", return false.
 Given "paper", "title", return true.
 * author:mingzhe Xiang
 * date:2017/1/19
 */
public class IsomorphicStrings_205 {

    /**
     * 用特殊的key-value HashMap存储S,T对应的Character关系即可
     *
     * 第一次submmit时没有考虑到["bbaad","aaaac"]的情况，只使用了一个Map<T,S> 导致["bbaad","aaaac"]情况失败。
     * 即题目需要ST双向的一一对应,增加一个Map<S,T>即可(也可不增加该Map而对Map<T,S>使用Map的contansValue去判断，但效率不高)
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        //s为key t为value
        Map<Character,Character> tempSTMap = new HashMap<>();
        //t为key s为value
        Map<Character,Character> tempTSMap = new HashMap<>();

        Character tempC;
        for (int i = 0; i < s.length(); i++) {
            //hashMap的Put方法 返回值为该key原来的值
            tempC = tempSTMap.put(s.charAt(i),t.charAt(i));
            if( tempC != null && tempC != t.charAt(i)) return false;

            tempC = tempTSMap.put(t.charAt(i),s.charAt(i));
            if( tempC != null && tempC != s.charAt(i)) return false;
        }
        return true;
    }

    /**
     * Discuss上MostVotes方案
     * 因为Character能被ASCII表示
     * 采用数组记录T、S一一对应的第i位的字符Char
     * @param s1
     * @param s2
     * @return
     */
     public boolean mostVotes(String s1, String s2) {
        int[] m = new int[512];//定义512 其实本质是int[] ms = new int[256];int[] mt = new int[256]  因为ASCII个数是256
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper","title"));
    }
}
