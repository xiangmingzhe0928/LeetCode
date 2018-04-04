package Math;

public class GreatestCommonDivisor {

	/**
	 * 欧几里得算法
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcd(int a, int b) {
		// 递归
		// return b == 0 ? a : gcd(b, a % b);

		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}

	/**
	 * 最小公倍数
	 * @param a
	 * @param b
	 * @return
	 */
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		System.out.println(gcd(12, 24));
		System.out.println(lcm(12, 24));
	}
}
