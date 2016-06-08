package mySort;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {

		int[] array = { 2, 13, 43, 23, 1, 5, 21, 11, 8, 7 };

		System.out.println("unsorted array:");
		System.out.println(Arrays.toString(array));

		// Basic search algorithms running in O(n^2)
		// bubbleSort(array);
		// selectionSort(array);
		// insertionSort(array);

		// Quicksort runs in O(n log n)
		quickSort(array, 0, array.length - 1);
		
		System.out.println("sorted array:");
		System.out.println(Arrays.toString(array));

		// Linear search works in O(n)
		// linearSearch(array, 2);

		// Binary runs in O(log n), needs array to be sorted
		binarySearch(array, 5);
	}

	/**
	 * Quicksort runs in O(n log n)
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	private static void quickSort(int[] array, int left, int right) {

		if (left >= right)
			return;

		int leftPointer = left - 1;
		int rightPointer = right;
		int pivot = array[right];

		System.out.println(Arrays.toString(array));
		System.out.println("L: " + left + " R: " + right + " pivot is " + pivot);

		while (true) {
			while (array[++leftPointer] < pivot)
				;

			while (rightPointer > 0 && array[--rightPointer] > pivot)
				;

			if (leftPointer >= rightPointer)
				break;
			else {
				System.out.println("swapping " + array[leftPointer] + " with " + array[rightPointer]);
				int temp = array[leftPointer];
				array[leftPointer] = array[rightPointer];
				array[rightPointer] = temp;
			}
		}

		// insert pivot into right place
		array[right] = array[leftPointer];
		array[leftPointer] = pivot;

		// sort remaining parts
		quickSort(array, left, leftPointer - 1);
		quickSort(array, leftPointer + 1, right);
	}

	/**
	 * Insertion sort, complexity O(n^2)
	 * 
	 * @param array
	 */
	private static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {

			int j = i;
			int toInsert = array[i];

			while (j > 0 && array[j - 1] > toInsert) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = toInsert;
		}
	}

	/**
	 * Bubble sort, complexity O(n^2)
	 * 
	 * @param array
	 */
	private static void bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}

	/**
	 * Selection sort, complexity O(n^2)
	 * 
	 * @param array
	 */
	private static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minimum = i;

			for (int j = i; j < array.length; j++)
				if (array[minimum] > array[j])
					minimum = j;

			int temp = array[i];
			array[i] = array[minimum];
			array[minimum] = temp;
		}
	}

	/**
	 * Linear search runs in O(n)
	 * 
	 * @param array
	 * @param elem
	 */
	private static void linearSearch(int[] array, int elem) {
		for (int i = 0; i < array.length; i++)
			if (array[i] == elem)
				System.out.println("found elem " + elem + " at index " + i);
	}

	/**
	 * Binary search, complexity O(log n)
	 * 
	 * @param array
	 * @param elem
	 */
	private static void binarySearch(int[] array, int elem) {
		int lowIndex = 0;
		int highIndex = array.length - 1;

		while (lowIndex <= highIndex) {
			int middleIndex = (lowIndex + highIndex) / 2;

			if (array[middleIndex] > elem)
				highIndex = middleIndex - 1;
			else if (array[middleIndex] < elem)
				lowIndex = middleIndex + 1;
			else {
				System.out.println("found value at " + middleIndex);
				return;
			}
		}
		System.out.println("value not found");
	}
}
