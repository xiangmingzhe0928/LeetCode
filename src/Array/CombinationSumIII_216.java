package Array;

import java.util.*;

/**
 * Array
 * description:
 * author:mingzhe Xiang
 * date:2016/11/14
 */
public class CombinationSumIII_216 {


    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if(k<1 || n<1 || k>n)
            return result;
        dfs(result, cur, 0, k, n, 1);
        return result;
    }

    /**
     * 回溯算法
     * 深度遍历DFS
     * @param result
     * @param cur
     * @param sum
     * @param k
     * @param n
     * @param level
     */
    public static void dfs(List<List<Integer>> result, List<Integer> cur, int sum, int k, int n, int level) {
        if(sum == n && k==0) {
            result.add(new ArrayList(cur));
            return;
        }
        if(sum> n || k<0)
            return;
        for(int i=level;i<=9;i++){
            cur.add(i);
            dfs(result, cur, sum+i, k-1, n, i+1);
            cur.remove(cur.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }
}
