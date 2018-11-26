package projectOne;

import java.util.Random;

/**
 * Name: Miguel Menjivar 
 * Course: CS 3310 
 * Design and Analysis of Algorithms
 * 
 * Due Date: 10/24/18
 * 
 * Task #1b: 
 * Sorting Algorithms 
 * Program Merge Sort and Quick Sort
 * 
 * QuickSortAlgorithm.java
 *
 */
public class QuickSortAlgorithm {

	/**
	 * start of program
	 */
	public static void main(String[] args) {
		// will populate array with random values
		Random rand = new Random();
		
		System.out.println("Quick Sort Algorithm");
		
		// MODIFY THIS VALUE TO INCREASE SIZE OF ARRAY
		int arraySize = 10000;
		int[] array = new int[arraySize];
		
		// populates array with random values
		for(int i = 0; i < arraySize; i++) {
			array[i] = rand.nextInt(arraySize) + 1;
		}
		
//		// prints out randomized array
//		System.out.print("Unordered: ");
//		printArray(array);
//		System.out.println();
		
		// starts timer in nanoseconds how long it takes to run through program
		long startTime = System.nanoTime();
		quickSort(array, 0, arraySize - 1);
		
		// will get total time
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Time: " + totalTime);
		
	}
	
	/**
	 * quick sort algorithm recursive
	 * 
	 * @param array
	 * @param low
	 * @param high
	 */
	static void quickSort(int[] array, int low, int high) {
		int position = 0;
		if(low < high) {
			position = partition(array, low, high);
			
			quickSort(array, low, position - 1);
			quickSort(array, position + 1, high);
		}
		
	}
	
	/**
	 * will split the array (partition it)
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	static int partition(int[] array, int low, int high) {
		// pivot
		int pivot = 0;
		// pivot with highest value in array
		pivot = array[high];
		
		int i = 0;
		
		i = low - 1;
		
		// compares values with pivot
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i++;
				
				// swap values
				swap(array, i, j);
			}
		}
		swap(array, i + 1, high);
		
		return i + 1;
	}
	
	/**
	 * swaps two values within array
	 * 
	 * @param array 
	 * @param i
	 * @param j
	 */
	static void swap(int[] array, int i, int j) {
		int temp = 0;
		temp = array[i];
		
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * prints out array for testing purposes
	 * 
	 * @param array
	 */
	static void printArray(int[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
	}

}
