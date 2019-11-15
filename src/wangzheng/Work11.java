package wangzheng;

import java.util.Arrays;

/**
 *
 *
 *
 * @author: Xiang Mingzhe
 * @version Work11.java, v 0.1 2019/11/14 9:37 XiangMingZhe Exp $
 **/
public class Work11 {

	/**
	 * 冒泡
	 * @param arr
	 * @return
	 */
	private static int[] bubbleSort(int[] arr) {

		int length = arr.length;
		if (length <= 1)
			return arr;
		for (int i = 0; i < length; i++) {
			boolean exchange = false;
			for (int j = 0; j < length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					exchange = true;
				}
			}

			if (!exchange) {
				break;
			}
		}

		return arr;
	}

	/**
	 * 直接插入
	 * @param arr
	 * @return
	 */
	private static int[] insertionSort(int[] arr) {
		int length = arr.length;

		if (length <= 1)
			return arr;
		for (int i = 1; i < length; ++i) {
			int value = arr[i];
			int j ;
			// 找插入位置
			for (j = i - 1; j >= 0; --j) {
				if (arr[j] > value) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}

			// 插入数据
			arr[j+1] = value;
		}
		return arr;
	}

	/**
	 * 选择排序
	 * @param arr
	 * @return
	 */
	private static int[] selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// 找到未排序片段中最小元素
			int minIndex = i;
			for (int j = i+1 ; j < arr.length ; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// 放入排序片段中指定位置(此处替换方式 主要是考虑内存空间 )
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}

		return arr;
	}

	/**
	 * 快速排序
	 * @param arr
	 * @return
	 */
	private static int[] quickSort(int[] arr) {
		if (null == arr || arr.length <= 1)
			return arr;

		doQuickSort(arr, 0, arr.length-1);
		return arr;
	}

	private static void doQuickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int pivotIndex = getQuickPivotIndex(arr, low, high);
		doQuickSort(arr, low, pivotIndex);
		doQuickSort(arr, pivotIndex + 1, high);
	}

	private static int getQuickPivotIndex(int[] arr, int leftIndex, int rightIndex) {
		if (leftIndex >= rightIndex)
			return leftIndex;
		int pivot = arr[leftIndex];
		while (leftIndex < rightIndex) {

			while (pivot <= arr[rightIndex] && leftIndex < rightIndex) {
				rightIndex --;
			}
			arr[leftIndex] = arr[rightIndex];

			while (pivot >= arr[leftIndex] && leftIndex < rightIndex) {
				leftIndex ++;
			}
			arr[rightIndex] = arr[leftIndex];
		}

		arr[leftIndex] = pivot;
		return leftIndex;
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low >= high)
			return ;
		int middleIndex = (high+low)/2;
		mergeSort(arr, low, middleIndex);
		mergeSort(arr, middleIndex+1, high);

		merge(arr, low, middleIndex, high);

	}

	/**
	 * 合并arr[low, middleIndex], arr(middleIndex+1, high]
	 * @param arr
	 * @param low
	 * @param middleIndex
	 * @param high
	 */
	private static void merge(int[] arr, int low, int middleIndex, int high) {
		// 初始化临时数组
		int tempSize = high - low + 1;
		int[] temp = new int[tempSize];

		// 按顺序合并两数组
		int lIndex = low;
		int rIndex = middleIndex + 1;
		int tempIndex = 0;
		while (lIndex <= middleIndex && rIndex <= high) {
			int min = arr[lIndex] <= arr[rIndex] ? arr[lIndex++] : arr[rIndex++];
			temp[tempIndex++] = min;
		}
		while (lIndex <= middleIndex) {
			temp[tempIndex++] = arr[lIndex++];
		}
		while (rIndex <= high) {
			temp[tempIndex++] = arr[rIndex++];
		}

		// 将排序后的临时数组复制还原到原数组片段：即需要从原数组的 low下标开始
//		for (int i = 0; i < tempSize; i++) {
//			arr[low + i] = temp[i];
//		}
		System.arraycopy(temp, 0, arr, low, tempSize);

	}


	public static void main(String[] args) {
		int[] arr = {5,4,7,2,10,22,51,2,4,100};

		mergeSort(arr, 0 , arr.length-1);

		System.out.println(Arrays.toString(arr));
	}
}
