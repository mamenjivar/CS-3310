package projectTwo;

import java.util.Random;
import java.util.Scanner;

/**
 * Name: Miguel Menjivar
 * Course: CS 3310
 * Design and Analysis of Algorithms
 * 
 * Due: 11/26/18
 * 
 * Task #1
 * 0/1 Knapsack
 * 
 * Knapsack01.java
 */
public class Knapsack01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("0/1 Knapsack\n");
		
		// [weight][value]
//		int[][] knapsack = {{10, 60}, {20, 100}, {30, 120}};
		int[][] knapsack;
		
		// user input for randomized knapsack
		System.out.print("Knapsack capacity: ");
		int capacity = keyboard.nextInt();
		System.out.print("n = ");
		int n = keyboard.nextInt();
		
//		int max = 50;
		
		knapsack = new int[2][n];
		populateknapsack(knapsack);
		
//		knapsack01(knapsack, max);
		knapsack01(knapsack, capacity);
		
		keyboard.close();
	}
	
	static void populateknapsack(int[][] knapsack) {
		Random rand = new Random();
		int size = knapsack.length;
		
		for(int i = 0; i < size; i++) {
			knapsack[i][0] = i + 1;
			knapsack[i][1] = rand.nextInt(200) + 1;
		}
	}
	
	/**
	 * 
	 * @param knapsack
	 * @param max
	 */
	static void knapsack01(int[][] knapsack, int max) {
		int length = knapsack.length;
		int[][] result = new int[length+1][max+1]; // maps the knapsack 
		
		// 
		for(int i = 0; i <= length; i++) {
			for(int j = 0; j <= max; j++) {
				if((i == 0) || (j == 0)) {
					result[i][j] = 0;
				}
				else if(knapsack[i - 1][0] <= j) {
					result[i][j] = findMax(knapsack[i-1][1] + result[i-1][j-knapsack[i-1][0]], result[i-1][j]);
				} else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		System.out.println(result[length][max]);
	}
	
	/**
	 * will return the max value between the 2 given
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int findMax(int a, int b) {
		if(a > b) {
			return a;
		} else {
			return b;
		}
	}

}
