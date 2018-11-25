package tsp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Member Names: 
 * Miguel Menjivar 
 * Richard Cota 
 * Chris Rauch
 * 
 * Course: CS 3310
 * 
 * Project: Traveling Salesman
 */
public class TravelingSalesman {
	// global variables
	static Scanner keyboard = new Scanner(System.in);

	// example purposes fixed 2d array
	static int[][] map = { { 0, 50, 100, 9 }, { 75, 0, 25, 15 }, { 30, 15, 0, 45 }, { 25, 20, 30, 0 } };
	static int[][] randMap;
	static int MAP_SIZE = map.length;
	static int minimum = 99999;
	// static int[] pathResult = new int[MAP_SIZE];
	static int[] pathResult;

	static ArrayList<Integer> al = new ArrayList<>();

	/**
	 * Main
	 */
	public static void main(String[] args) {
		System.out.println("Traveling Salesman\n");

		// modify this value to get matrix size n x n
		System.out.print("n=");
//		int n = 4;
		int n = keyboard.nextInt();
		System.out.println();
		populateArray(n);

		// amount of cities on map
//		int[] permute = new int[MAP_SIZE];
		int[] permute = new int[n];

		// populates permutations based on size of map
		for (int i = 0; i < permute.length; i++) {
			permute[i] = i;
		}

		// prints out the 2d array map
		System.out.println("Map:");
//		printMap(map, MAP_SIZE);
		printMap(randMap, n);

		System.out.println("Paths:");
		// performs permutations and calculates distances from all cities
		permutations(permute, permute.length, permute.length);
		System.out.println();

		// prints out minimum distance to other cities
		System.out.println("minimum path:");
		printArray(pathResult);
		System.out.println(" = " + minimum);
		
		keyboard.close();

	}

	/**
	 * randomize a random array
	 */
	static void populateArray(int matrixSize) {
		Random rand = new Random();
		randMap = new int[matrixSize][matrixSize];
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if (i == j) {
					randMap[i][j] = 0;
				} else {
					randMap[i][j] = rand.nextInt(100);
				}
			}
		}
	}

	/**
	 * will compute all permutations of array
	 * 
	 * @param a
	 * @param size
	 * @param n
	 */
	static void permutations(int a[], int size, int n) {

		if (size == 1) {
//			printArray(a);
//			bruteForcetsp(map, a);
			bruteForcetsp(randMap, a);
		}

		// research this
		for (int i = 0; i < size; i++) {
			permutations(a, size - 1, n);

			// if odd
			if (size % 2 == 1) {
				swap(a, 0, size - 1);
			}
			// if even
			else {
				swap(a, i, size - 1);
			}
		}
	}

	/**
	 * traveling salesman problem brute force
	 */
	static void bruteForcetsp(int[][] map, int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length - 1; i++) {
			 sum += map[a[i]][a[i + 1]];
//			sum += randMap[a[i]][a[i + 1]];
		}
		sum += map[a[a.length - 1]][a[0]];
//		sum += randMap[a[a.length - 1]][a[0]];

//		System.out.print(" = " + sum + "\n");
		minimum = min(minimum, sum, a);

//		if (duplicates(sum)) {
			printArray(a);
			System.out.print(" = " + sum + "\n");
//		}

	}

	/**
	 * 
	 * @param sum
	 */
	static boolean duplicates(int sum) {
		if(al.contains(sum)) {
			return false;
		} else {
			al.add(sum);
			return true;
		}
	}

	/**
	 * swaps the values in permutation array
	 * 
	 * @param array
	 * @param j     1st value to be swapped
	 * @param k     2nd value to be swapped
	 */
	static void swap(int[] array, int j, int k) {
		int temp = array[j];
		array[j] = array[k];
		array[k] = temp;
	}

	/**
	 * prints each path
	 * 
	 * @param a
	 */
	static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "-");
		}
		System.out.print(a[0]);
	}

	/**
	 * will return the smallest value of two inputs
	 * 
	 * @param minPath
	 * @param currentWeight
	 * @return
	 */
	static int min(int minPath, int currentWeight, int[] array) {
		int minimum = 0;
		if (minPath < currentWeight) {
			minimum = minPath;
		} else {
			minimum = currentWeight;
			copyArray(array);
		}
		return minimum;
	}

	/**
	 * copy contents of array as result to pathResult array it will hold path to
	 * shortest distance amongst all cities back to origin
	 * 
	 * @param array
	 */
	static void copyArray(int[] array) {
		pathResult = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			pathResult[i] = array[i];
		}
	}

	/**
	 * prints out map contents of 2D array
	 * 
	 * @param map  holds contents of 2d array
	 * @param size the size of array which is size x size
	 */
	static void printMap(int[][] map, int size) {
		// column header
		System.out.printf("%-4s", "");
		for (int i = 0; i < size; i++) {
			System.out.printf("%-4d", i);
		}
		System.out.println();
 
		for (int i = 0; i < size; i++) {
			System.out.printf("%-4d", i);
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%-4d", map[i][j]);

			}
			System.out.println();
		}
		System.out.println();
	}
}
