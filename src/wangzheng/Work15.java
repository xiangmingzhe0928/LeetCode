package wangzheng;

/**
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version Work15.java, v 0.1 2019/11/21 8:34 XiangMingZhe Exp $
 **/
public class Work15 {
	private static final double PRECISION = 1e-6;

	/**
	 * 二分查找法
	 * @param n
	 * @return
	 */
	private static double sqrtBinarySearch(double n) {
		if (n < 1)
			throw new IllegalArgumentException("un support");

		double low = 0;
		double high = n;
		double midd = low + ((high - low) / 2.0);
		double m2 = midd * midd;

		while (Math.abs(m2 - n) > PRECISION) {
			if (m2 - n > PRECISION) {
				high = midd;
			} else if (m2 - n < -PRECISION) {
				low = midd;
			} else {
				return midd;
			}

			midd = low + ((high - low) / 2.0);
			m2 = midd * midd;
		}

		return midd;

	}

	/**
	 * 牛顿迭代公式: x = (x + n / x) / 2.0;
	 * @param n
	 * @return
	 */
	private static double sqrtNewTon(double n) {
		// 初始猜想
		double guess = n / 2.0;
		while (Math.abs(guess - n / guess) > PRECISION) {
			guess = (guess + n / guess) / 2.0;
		}
		return guess;
	}

	public static void main(String[] args) {
		double d = 2.0d;
		System.out.println(sqrtBinarySearch(d));
		System.out.println(sqrtNewTon(d));
	}
}
