package Array;

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
	 * 本题最直观的思路就是单纯的用代码模拟“螺旋生成”(循环次数多)
	 * 螺旋生成其实就是对矩阵而言由外至内 一层一层赋值
	 * 定义4个标志位记录当前层的：顶部Row、底部Row、左Cloumn、右Cloumn即可
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {
		if (n <= 0)
			return null;

		int[][] res = new int[n][n];
		//定义矩阵4角标志位
		int topRow = 0, bottomRow = n - 1, leftCloumn = 0, rightCloumn = n - 1;
		int data = 1;//矩阵元素从1计数
		//矩阵路径:左->右 上->下 右->左 下->上
		while (bottomRow >= topRow && rightCloumn >= leftCloumn) {
			//左->右
			for (int i = leftCloumn; i <= rightCloumn; i++)
				res[topRow][i] = data++;
			//上->下
			for (int i = topRow + 1; i <= bottomRow; i++)
				res[i][rightCloumn] = data++;
			//右->左
			for (int i = rightCloumn - 1; i >= leftCloumn; i--)
				res[bottomRow][i] = data++;
			//下->上
			for (int i = bottomRow - 1; i > topRow; i--)
				res[i][leftCloumn] = data++;

			//当前最外层赋值结束 进入矩阵内一层
			topRow++;
			leftCloumn++;
			rightCloumn--;
			bottomRow--;
		}
		return res;
	}

	//Discuss上本题MostVotes是Python答案，Java答案普遍就是采用的上面4个标志位的方式
	//排行第一的Python答案利用了Python库中zip和range函数，十分方便，对java来说就稍显复杂了。但代码的思路可以参考
	//倒叙填充矩阵 即从n*n开始。
	// 1.每轮在矩阵最顶一行填充i（i为1--N）个数。
	// 2.填充完成后矩阵旋转90°

	//    ```python
	//        def generateMatrix(self, n):
	//            A, lo = [], n*n+1
	//                while lo > 1:
	//            lo, hi = lo - len(A), lo
	//            A = [range(lo, hi)] + zip(*A[::-1])
	//        return A
	//    ```
}
