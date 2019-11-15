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

	private static int[] insertionSort(int[] arr) {
		int length = arr.length;

		if (length <= 1)
			return arr;
		for (int i = 1; i < length; ++i) {
			int value = arr[i];
			int j ;
			for (j = i - 1; j >= 0; --j) {
				if (arr[j] > value) {
					arr[j+1] = arr[j];
				} else {
					break;
				}
			}
			arr[j+1] = value;
		}
		return arr;
	}

	private static int[] selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i+1 ; j < arr.length ; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}

		return arr;
	}


	private static int[] quickSort(int[] arr) {
		if (null == arr || arr.length <= 1)
			return arr;

		doQuickSort(arr, 0, arr.length-1);
//		int pivotIndex = getQuickPivotIndex(arr, 0, arr.length-1);
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

	public static void main(String[] args) {
//		int[] arr = {1,4,5,3,2,7,-22,10,14,13,22,24,26};
		int[] arr = {5,4,7,2,10};

		System.out.println(Arrays.toString(quickSort(arr)));
	}
}
