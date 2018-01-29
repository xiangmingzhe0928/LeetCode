package Math;

/**
 * Math
 * description:对长度为n的数组A旋转得到数组B 给A定义方法F(n)：顺时针旋转[0,n]次并运算 求最大F(n)
 *
 * Given an array of integers A and let n to be its length.
 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 Calculate the maximum value of F(0), F(1), ..., F(n-1).
 Note: n is guaranteed to be less than 10^5.
 Example:
 A = [4, 3, 2, 6]
 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * author:mingzhe Xiang
 * date:2016/11/7
 */
public class RotateFunction_396 {

	/**
	 * 数学推导题
	 *
	 * F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1].
	 * F(k)   = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
	 * 数组B是由数组A顺时针旋转得来的 BK-1[0]==BK[1]    BK-1[n-1] == BK[0]
	 * F(k)  =  1*BK-1[0] + 2*BK-1[1] + ... +  0 * BK-1[n-1]
	 * F(k) - F(k-1) = BK-1[0]+BK-1[1]+Bk-1[2]+ .. BK-1[n-2] - n*BK-1[n-1] + BK-1[n-1]
	 * F(k) - F(k-1) = SUM(BK-1)- n*BK-1[n-1] //无论是BK还是BK-1 本质都是数组A 只是元素顺序旋转了而已
	 * SO:F(k) - F(k-1)= SUM(A) - n * BK[0] ====>F(k) = F(k-1) + SUM(A) - n * BK[0]
	 * @param nums
	 * @return
	 */
	private static int rotateFunction(int[] nums) {
		int sumA = 0;
		int nowF = 0;//当前F(n)的值
		for (int i = 0; i < nums.length; i++) {
			sumA += nums[i];
			nowF += i * nums[i];//F(0)
		}

		int maxF = nowF;//最大F(n)
		for (int i = 1; i < nums.length; i++) {
			//F(k) = F(k-1) + SUM(A) - n * BK[0]
			nowF = nowF + sumA - nums.length * nums[nums.length - i];
			maxF = maxF < nowF ? nowF : maxF;
		}

		return maxF;

	}

	public static void main(String[] args) {
		System.out.println(rotateFunction(new int[] {4, 3, 2, 6, 7, 1}));
	}
}
