package tsp;
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
	static int[][] map = { { 0, 50, 100, 9 }, { 75, 0, 25, 15 }, { 30, 15, 0, 45 }, {25, 20, 30, 0}};
	static int minimum = 99999;

	/**
	 * Main
	 */
	public static void main(String[] args) {
		System.out.println("Traveling Salesman\n");

		int size = map.length;	
		int[] permute = new int[size];
		
		// populates permutations based on size of map
		for(int i = 0; i < permute.length; i++) {
			permute[i] = i;
		}

		// prints out the 2d array map
		System.out.println("Map");
		printMap(map, size);

		// performs permutations and calculates distances from all cities
		permutations(permute, permute.length, permute.length);
		System.out.println();

		System.out.println("minimum path: " + minimum);
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
			printArray(a);
			bruteForcetsp(map, a);
		}

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
		}
		sum += map[a[a.length - 1]][a[0]];

		System.out.print(" = " + sum + "\n");
		minimum = min(minimum, sum);
	}

	/**
	 * swaps the values in permutation array
	 * 
	 * @param array
	 * @param j 1st value to be swapped
	 * @param k 2nd value to be swapped
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
	 * will return the smallest value
	 * 
	 * @param minPath
	 * @param currentWeight
	 * @return
	 */
	static int min(int minPath, int currentWeight) {
		int minimum = 0;
		if (minPath < currentWeight) {
			minimum = minPath;
		} else {
			minimum = currentWeight;
		}

		return minimum;

	}

	/**
	 * prints out map contents neatly
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
