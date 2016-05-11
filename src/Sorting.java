public class Sorting {

	public static void main(String[] args) {
		final int[] array = { 99, 2, 43, 4, 8, 48, 15, 2, 43, 4, 7, 48, 1 };

		// bubbleSort(array);
		// selectionSort(array);
		insertionSort(array);
		// binarySearch(array, 1);

	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i;

			while (j > 0 && array[j - 1] > array[j]) {
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j = j - 1;
			}
			printArray(array);
		}
	}

	public static void selectionSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					int temp = array[j];
					array[j] = array[min];
					array[min] = temp;
				}
			}
			printArray(array);
		}
	}

	public static void bubbleSort(int[] array) {

		printArray(array);
		boolean moved = false;

		for (int i = array.length - 1; i > 1; i--) {
			moved = false;
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					moved = true;
					System.out.println("tausche " + array[j] + " mit " + array[j + 1]);
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				printArray(array);
			}
			if (!moved)
				break;
		}
	}

	public static void binarySearch(int[] array, int what) {

		printArray(array);
		System.out.println("searching for " + what);
		int low = 0, high = array.length - 1;
		int middle = (high + low) / 2;

		while (low <= high) {
			middle = (high + low) / 2;
			System.out.println(low + " " + middle + " " + high);
			if (array[middle] > what)
				high = middle - 1;

			else if (array[middle] < what)
				low = middle + 1;

			else {
				System.out.println("Found " + what + " at " + middle);
				return;
			}
		}
		System.out.println("value not found");
	}

	public static void printArray(int[] array) {
		for (int x = 0; x < array.length; x++)
			System.out.print(array[x] + "|");
		System.out.println();
	}

}
