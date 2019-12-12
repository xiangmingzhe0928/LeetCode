package top100;

/**
 *
 * 装水容器
 * 给定一个数组  求这个数组中 每2个元素：下标索引间隔为底长，元素值为高 求能组成的最大面积()
 *
 * @author: Xiang Mingzhe
 * @version ContainerWithMostWater_11.java, v 0.1 2019/12/12 14:29 XiangMingZhe Exp $
 **/
public class ContainerWithMostWater_11 {

	/**
	 * 两元素能组成的最大容器面积公式: area = (j - i) * Math.min(height[i], height[j])
	 *
	 * 此方法是最简单的 能AC但时间复杂度O(N^2) 效率太差
	 * @param height
	 * @return
	 */
	private static int maxArea(int[] height) {
		int size = height.length;
		if (size <= 1) {
			throw new IllegalArgumentException("height at least 2");
		}

		int mostWater = 0;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				mostWater = Math.max(mostWater, (j - i) * Math.min(height[i], height[j]));
			}
		}

		return mostWater;
	}


	/**
	 * <pre>
	 *  Discuss中性能更高的算法
	 *
	 * 	依靠左右指针向中间靠拢 O(N)
	 * 	每次移动高度小的一边,以争取获得更高的高度。
	 *
	 * 	此算法实现简单、难点是在需要反证法证明算法是正确的===>即证明此算法没有错过最优解
	 * </pre>
	 *
	 *
	 * @param height
	 * @return
	 */
	private static int maxArea2(int[] height) {
		int size = height.length;
		if (size <= 1) {
			throw new IllegalArgumentException("height at least 2");
		}

		int low = 0, high = size -1 ;
		int mostWater = 0;
		while (low < high) {
			mostWater = Math.max(mostWater, (high - low) * Math.min(height[low], height[high]));
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}
		return mostWater;
	}
	public static void main(String[] args) {
		int[] height = new int[]{1,8,6,2,5,4,6,8};
		System.out.println(maxArea(height));
		System.out.println(maxArea2(height));
	}
}
