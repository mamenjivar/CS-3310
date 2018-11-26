package projectTwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * Name: Miguel Menjivar 
 * Course: CS 3310 Design and Analysis of Algorithms
 * 
 * Due: 11/26/18
 * 
 * Task #1: Use greedy approach to implement Fractional Knapsack
 * 
 * FractionalKnapsack.java
 *
 */
public class FractionalKnapsack {
	// global variables
	static Random rand = new Random();
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Fractional Knapsack\n");

		// 2d array change for weight and profits
//		double[][] wp = {{1, 3, 0},  {3, 5, 0}, {5, 8, 0}, {6, 6, 0}, {3, 1, 0}, {10, 2, 0}};
		double[][] wp;
		
		System.out.print("Knapsack capacity: ");
		int capacity = keyboard.nextInt();
		
		System.out.print("n = ");
		int n = keyboard.nextInt();
		
		wp = new double[3][n];
		populateKnapsack(wp);
		ratios(wp);

//		int cap = 50;

//		sortArray(wp);
		printArray(wp);

		 fractionalKnapsack(wp, capacity);
		 
		 keyboard.close();
	}
	
	/**
	 * populates 2D array with weight and value
	 * 
	 * @param wp
	 */
	static void populateKnapsack(double[][] wp) {
		int length = wp.length;
		
		for(int i = 0; i < length; i++) {
			wp[i][0] = i + 1;
			wp[i][1] = rand.nextInt(100) + 1;
		}
	}

	/**
	 * ratio = weight / value
	 * 
	 * @param wp
	 */
	
	static void ratios(double[][] wp) {
		for (int i = 0; i < wp.length; i++) {
			wp[i][2] = wp[i][1] / wp[i][0];
		}
	}

	/**
	 * 
	 */
	static void fractionalKnapsack(double[][] array, int capacity) {
		int length = array.length;
		double totalValue = 0;
		double totalWeight = 0;
		double fraction = 0;
		double wt;

		for (int i = 0; i < length-1; i++) {
			if (array[i][0] + totalWeight <= capacity) {
				totalValue += array[i][1];
				totalWeight += array[i][0];
			} else {
				wt = (double)capacity - totalWeight;
				fraction = wt * (array[i][1] / array[i][0]);
				
				totalValue += fraction;
				totalWeight += wt;
				
				break;
			}
		}

//		return totalWeight;
		System.out.println("Weight: " + totalWeight);
		System.out.println("Value: " + totalValue);
	}

	/**
	 * 
	 * @param wp
	 */
	static void sortArray(double[][] wp) {
		Arrays.sort(wp, new Comparator<double[]>() {

			public int compare(final double[] one, final double[] two) {
				if (one[2] < two[2]) {
					return 1;
				} else {
					return -1;
				}
			}
		});
	}

	/**
	 * prints out the array 
	 * 
	 * @param array
	 */
	static void printArray(double[][] array) {
		int size = array.length;

		System.out.println("Weight Value  Ratio");
		System.out.println("============");

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < array[i].length - 1; j++) {
				System.out.print(" " + (int)array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
