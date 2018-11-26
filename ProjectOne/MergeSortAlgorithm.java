package projectOne;

import java.util.Random;
import java.util.Timer;

/**
 * Name: Miguel Menjivar 
 * Course: CS 3310 
 * Design and Analysis of Algorithms
 * 
 * Due Date: 10/24/18
 * 
 * Task #1a: 
 * Sorting Algorithms 
 * Program Merge Sort and Quick Sort
 *
 * MergeSortAlgorithm.java
 *
 */
public class MergeSortAlgorithm {

	/**
	 * start of program
	 */
	public static void main(String[] args) {
		// title
		System.out.println("Merge Sort Algorithm");
		
		// will generate random values to populate array
		Random rand = new Random();
		
		// MODIFY THIS VALUE TO INCREASE SIZE OF ARRAY
		int arrayLength = 10000;

		// example array
		int unsortedArray[] = new int[arrayLength];
		
		// will populate unsorted array with random values ranging from 1 - 100
		for(int i = 0; i < arrayLength; i++) {
			unsortedArray[i] = rand.nextInt(arrayLength) + 1;
		}

		// starts timer in nanoseconds how long it takes to run through program
		long startTime = System.nanoTime();
		
		// merge sort algorithm
		mSort(unsortedArray, 0, arrayLength - 1);
		
		// will get total time
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Time: " + totalTime);

	}

	/**
	 * Merge sort recursive part
	 * 
	 * @param array
	 * @param first
	 * @param last
	 */
	static void mSort(int[] array, int first, int last) {

		if (first < last) {
			int middle = (first + last) / 2;

			mSort(array, first, middle);
			mSort(array, middle + 1, last);
			merge(array, first, middle, last);
		}
	}

	static void merge(int[] array, int first, int middle, int last) {
		int middleOne = middle - first + 1;
		int middleTwo = last - middle;

		// instantiate arrays with designated sizes
		int[] leftArray = new int[middleOne];
		int[] rightArray = new int[middleTwo];

		// copy values from original array to left side of temp array
		for (int i = 0; i < middleOne; i++) {
			leftArray[i] = array[first + i];
		}

		// copy values from original array to right side of temp array
		for (int j = 0; j < middleTwo; j++) {
			rightArray[j] = array[middle + 1 + j];
		}

		// indexes for left, right, arrays
		int i = 0;
		int j = 0;
		int k = first;

		// 
		while ((i < middleOne) && (j < middleTwo)) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// copy the remaining values of the left array
		while (i < middleOne) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		// copy remaining values of right array
		while (j < middleTwo) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	/**
	 * print out array
	 * 
	 * @param array
	 */
	static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
