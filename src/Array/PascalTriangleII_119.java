package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Array
 * description:求杨辉三角第n行
 *
 Given an index k, return the kth row of the Pascal's triangle.
 For example, given k = 3,
 Return [1,3,3,1].
 Note:Could you optimize your algorithm to use only O(k) extra space?
 * author:mingzhe Xiang
 * date:2016/11/8
 */
public class PascalTriangleII_119 {


    /**
     * 题目已经很明显了 杨辉三角 C[n](i) = C[n-1](i-1)+  C[n-1](i)
     *              1
                1       1
     *       1      2      1
     *     1    3       3      1
     * @param rowIndex :以0为首行下标
     * @return
     */
    private static List<Integer> getRow(int rowIndex){
        List<Integer> res = new ArrayList<Integer>();

        // 1，2行直接处理
        res.add(1);
        if(rowIndex == 0)
            return res;
        res.add(1);
        if(rowIndex == 1)
            return res;


        int prevJ;//上一行第j位
        int prevJsubtraction1 = 1;//上一行第j-1位
        //从第3行开始(rowIndex=2)
        for (int i = 2; i <= rowIndex ; i++) {
            for(int j=1;j<i;j++){
                //记录本行原J位，因为直接在结果List上操作 因此每次更新List的值 会影响后面位的计算。需先临时存储
                prevJ = res.get(j);//记录本行J位
                //杨辉三角特性：C1[i] = C0[i]+C0[i+1]
                res.set( j,res.get(j) + prevJsubtraction1);
                prevJsubtraction1 = prevJ;//原J位数值变为下轮循环中J-1
            }
            res.add(1);//行尾元素
        }
        return  res;
    }

    /**
     * Discuss上MostVotes答案
     *
     * 和上面自己的实现方式思路是一样的
     * 但这种方式每次从索引大到小遍历 能避免从小到大的方式需要记录原j的弊端
     * @param rowIndex
     * @return
     */
    public static List<Integer> mostVotes(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = ret.get(j - 1) + ret.get(j);
                ret.set(j, tmp);
            }
            ret.add(1);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
}
