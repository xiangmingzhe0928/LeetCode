package Array;

import java.util.Arrays;

/**
 * Array
 * description:给定数字n 用1—n^2 螺旋填充方形数组
 Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 For example,
 Given n = 4,
 You should return the following matrix:
 [
 [ 1,  2,   3 ,4],
 [ 12, 13,  14 ,5],
 [ 11, 16,  15 , 6],
 [ 10, 9,   8 ,  7],
 ]
 * author:mingzhe Xiang
 * date:2016/11/28
 */
public class SpiralMatrixII_59 {

    /**
     *  1 to n^2 能产生的方形矩阵为 n * n
     * 本题最直观的思路就是单纯的用代码模拟“螺旋生成”
     * 螺旋生成其实就是对矩阵而言由外至内 一层一层赋值
     * 定义4个标志位记录当前层的：顶部Row、底部Row、左Cloumn、右Cloumn即可
     * @param n
     * @return
     */
    public  static int[][] generateMatrix(int n) {
        if(n <= 0) return null;

        int[][] res = new int[n][n];

        int topRow = 0,bottomRow = n-1,leftCloumn=0,rightCloumn=n-1;
        int data = 1;//元素从1计数
        //标记指针路径:左-》右 上-》下 右-》左 下-》上
        while (bottomRow >= topRow && rightCloumn >= leftCloumn){

            //左-》右
            for (int i = leftCloumn; i <= rightCloumn ; i++)
                res[topRow][i] = data++;

            //上-》下
            for (int i = topRow+1; i <= bottomRow ; i++)
                res[i][rightCloumn] = data++;

            //右-》左
            for (int i = rightCloumn-1 ; i>= leftCloumn ; i--)
                res[bottomRow][i] = data++;
            //下-》上
            for (int i = bottomRow-1; i > topRow ; i--)
                res[i][leftCloumn] = data++;

            topRow++;
            leftCloumn++;
            rightCloumn--;
            bottomRow--;
        }
        return  res;
    }

}
