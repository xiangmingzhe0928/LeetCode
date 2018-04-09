package Math;

/**
 * 求质数
 */
public class Prime {

	/**
	 * 求的n以内的所有质数
	 * @param n
	 */
	private static void primes_1(int n) {
		if (n <= 1)//1不是质数
			return;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i))
				System.out.println("prime:" + i);

		}

	}

	private static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) { //只需要遍历到开方根Math.sqrt(n)即可 无序完全遍历到n
			if (n % i == 0)
				return false; // 非质数
		}
		return true;
	}

	//===========================================================

	/**
	 * 埃拉托斯特尼筛法（Sieve of Eratosthenes）
	 * @param n
	 */
	private static void primes_2(int n) {
		boolean[] notPrime = new boolean[n]; // 非质数boolean数组
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				System.out.println("prime:" + i);
				for (int j = 2; i * j < n; j++) { // Sieve of Eratosthenes算法思想
					notPrime[i * j] = true;
				}
			}
		}

	}

	public static void main(String[] args) {
		primes_1(100);
		primes_2(100);
	}

}
