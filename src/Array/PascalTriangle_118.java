package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Array
 * description:返回前n行的杨辉三角
 Given numRows, generate the first numRows of Pascal's triangle.
 For example, given numRows = 5,
 Return
 [
            [1],
            [1,1],
            [1,2,1],
            [1,3,3,1],
            [1,4,6,4,1]
 ]
 * author:mingzhe Xiang
 * date:2016/11/10
 */
public class PascalTriangle_118 {


    /**
     * 杨辉三角题 因为当时是做先做的119 后做的本题 所以和119一样的思路 主要还是借助杨辉三角自身的特点
     * @param numRows
     * @return
     */
    private static List<List<Integer>> generate(int numRows){
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      List<Integer> temp ;
        if(numRows == 0)
            return res;
        temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        if(numRows == 1)
            return res;
        temp = new ArrayList<>(temp);
        temp.add(1);
        res.add(temp);
        if(numRows == 2)
            return  res;
        List<Integer> currRow;
        for (int i = 3; i <= numRows ; i++) {
            currRow = new ArrayList<>(temp);
            for (int j = i - 2; j > 0 ; j--) {
                //核心部分 杨辉三角特性
                currRow.set(j,temp.get(j) + temp.get(j-1));
            }
            //末尾元素1
            currRow.add(1);
            res.add(currRow);
            temp = currRow;
        }

        return res;
    }

    /**
     * Discuss上MostVotes答案
     * 整体思路都是一样的 这种更简洁
     * @param numRows
     * @return
     */
    public static List<List<Integer>> mostVotest(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    public static void main(String[] args) {
        System.out.println(generate(7));
    }
}
