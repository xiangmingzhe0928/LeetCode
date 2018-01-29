package Array;

/**
 * Array
 * description：将一个N*N的2D矩阵 顺时针旋转90°
 You are given an n x n 2D matrix representing an image.Rotate the image by 90 degrees (clockwise).
 * author:mingzhe Xiang
 * date:2016/11/8
 */
public class RotateImage_48 {

	/**
	 * 本题主要在找到矩阵旋转前后下标位置变化关系,两种思考方式：
	 * 1.根据找到的位置变化关系直接求出新的矩阵（从逻辑和CODE实现上都比较繁琐，有种硬编的感觉）
	 * 2.大学矩阵知识：先求转置矩阵(行列互换) 然后以水平交换列
	 *
	 *
	 * @param matrix
	 */
	private static void roate(int[][] matrix) {
		int temp;
		//1 求的转置矩阵
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[i].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		//2 水平对称交换列
		for (int i = 0; i < matrix.length; i++) {
			//只需遍历到length/2列即可
			for (int j = 0; j < matrix.length / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
				matrix[i][matrix[i].length - 1 - j] = temp;
			}
		}
	}

	/**
	 * Console打印矩阵
	 * @param matrix
	 */
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int element : matrix[i]) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9}};
		printMatrix(matrix);
		System.out.println("---------After Roate----------");
		roate(matrix);
		printMatrix(matrix);

	}
}
