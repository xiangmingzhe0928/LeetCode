package Tree;

import java.util.Arrays;

/**
 *
 * description:HeapSort
 * <pre>
 * 堆本质是一颗完全二叉树。O(nlog2n)
 * 则有一个节点n，它的左子节点为2n+1 右子节点为2n+2
 * </pre>
 * 今天遇到需要堆排的相关东西，又特么有点模糊了，记录一下
 * author:mingzhe Xiang
 * date:2017/11/09
 */
public class HeapSort {

	//构建初始堆
	private static void buildHeap(int[] array) {
		int lastIndex = array.length - 1;
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			heapSort(array, i, array.length);
		}
	}

	/**
	 * 调整堆
	 * @param array
	 * @param rootIndex 本轮子树的根节点
	 * @param size 待排剩余数组长度
	 */
	private static void heapSort(int[] array, int rootIndex, int size) {
		int leftIndex = rootIndex * 2 + 1;
		int rightIndex = rootIndex * 2 + 2;
		int lagerIndex = rootIndex;
		if (leftIndex < size && array[leftIndex] > array[lagerIndex]) {
			lagerIndex = leftIndex;
		}
		if (rightIndex < size && array[rightIndex] > array[lagerIndex]) {
			lagerIndex = rightIndex;
		}
		if (lagerIndex != rootIndex) {
			int temp = array[lagerIndex];
			array[lagerIndex] = array[rootIndex];
			array[rootIndex] = temp;

			heapSort(array, lagerIndex, size);
		}
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 100, 26, 22, 3, 69, 5, 6, 18, 14, 7, 44, 19};
		//初始化堆
		buildHeap(arr);

		//交换首位元素 重调堆
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapSort(arr, 0, i);
		}

		System.out.println(Arrays.toString(arr));
	}
}
