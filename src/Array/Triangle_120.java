package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Array
 * description:找到三角形顶部到底部最短和 每次只能移动到下一行的相邻元素
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * author:mingzhe Xiang
 * date:2016/11/16
 */
public class Triangle_120 {

    /**
     * 典型的动态规划：
     * 到第R行第i个元素最小路径:选择第i个元素只有2种情况 【R-1】(i)或者【R-1】(i-1)；但因为是三角形关系 从底部往顶部倒序处理能避免代码上处理越界问题
     * 从局部来看： SumMin([R](i)) = Math.min([R+1](i),[R+1](i+1))+[R](i)
     * @param triangle
     * @return
     */
    public static  int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j <triangle.get(i).size() ; j++) {
                triangle.get(i).set(j,Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
            }
            System.out.println("I:"+i+";>>>"+triangle.get(i));
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> tringle = new ArrayList<>();
        tringle.add(new ArrayList<Integer>(){{add(2);}});
        tringle.add(new ArrayList<Integer>(){{add(3);add(4);}});
        tringle.add(new ArrayList<Integer>(){{add(6);add(5);add(7);}});
        tringle.add(new ArrayList<Integer>(){{add(4);add(1);add(8);add(3);}});
        System.out.println(minimumTotal(tringle));
    }

}
