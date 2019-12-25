package top100;

import java.util.Arrays;

/**
 *
 *给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11]                                                                                                                                                      ],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author: Xiang Mingzhe
 * @version RotateImage_44.java, v 0.1 2019/12/25 13:49 XiangMingZhe Exp $
 **/
public class RotateImage_44 {

	/**
	 * n*n的矩阵 90°旋转等价于：
	 * 1.按列对分翻转
	 * 2.按对角线交换
	 *
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}

		int n = matrix[0].length;
		int leftIndex,rightIndex;

		// 按列对分翻转
		for (int i = 0; i < n ; i++) {
			leftIndex = 0;
			rightIndex = matrix[i].length - 1;
			while (leftIndex < rightIndex) {
				int temp = matrix[i][leftIndex];
				matrix[i][leftIndex] = matrix[i][rightIndex];
				matrix[i][rightIndex] = temp;
				leftIndex ++;
				rightIndex --;
			}
		}
		// 按对角线交换
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1 ; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][n-1-i];
				matrix[n-1-j][n-1-i] = temp;
			}
		}

		System.out.println(Arrays.deepToString(matrix));
	}

	public static void main(String[] args) {
//		rotate(new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}});
		rotate(new int[][]{{1,2},{3,4}});
	}
}
