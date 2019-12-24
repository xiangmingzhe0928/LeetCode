package wangzheng;

/**
 * 有n种不同币值的硬币,要支付t元,最少使用硬币数
 *
 * 如：有3种不同的硬币， 1元、 3元、 5元，我们要支付9元，最少需要3个硬币（3个3元的硬币）
 *
 * @author: Xiang Mingzhe
 * @version MinCoin.java, v 0.1 2019/12/24 14:11 XiangMingZhe Exp $
 **/
public class MinCoin {
	private static int minCoins(int amount) {
		if (amount <= 0) {
			return 0;
		}
		// 为了便于直观描述 使用了amount+1长度的数组 实际使用amount长度即可
		int[] conins = new int[amount+1];
		conins[0] = 0;
		conins[1] = 1; // 1
		conins[2] = 2; // 1，1
		conins[3] = 1; // 3
		conins[4] = 2; // 1，1
		conins[5] = 1; // 5
		for (int i = 6; i <= amount ; i++) {
			conins[i] = Math.min(Math.min(conins[i-1], conins[i-3]), conins[i-5]) + 1;
		}

		return conins[amount];

	}

	public static void main(String[] args) {
		System.out.println(minCoins(500));
	}
}
