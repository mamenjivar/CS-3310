package projectOne;

import java.util.Random;

/**
 * Name: Miguel Menjivar 
 * Course: CS 3310 
 * Design and Analysis of Algorithms
 * 
 * Due Date: 10/24/18
 * 
 * Task #3a: 
 * Classical Matrix Multiplication
 * 
 * ClassicalMatrixMultiplication.java
 *
 */
public class ClassicalMatrixMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Matrix Multiplication");
		
		// sets the size of the n x n matrix
		int matrixSize = 3;
		
		// instantiate matrices A and B and C
		// matrices A and B are constants
		// matrix C is the solution of [A x B]
		int[][] matrixA = new int[matrixSize][matrixSize];
		int[][] matrixB = new int[matrixSize][matrixSize];
		int[][] matrixC = new int[matrixSize][matrixSize];
		
		System.out.println("Matrix A");
		populateMatrix(matrixA);
		printMatrix(matrixA);
		
		System.out.println("Matrix B");
		populateMatrix(matrixB);
		printMatrix(matrixB);
		
		classicalMatrixMultiplication(matrixSize - 1, matrixA, matrixB, matrixC);
		
		System.out.println("Matrix C (solution)");
		printMatrix(matrixC);
	}

	/**
	 * Classical
	 * 
	 * @param n
	 * @param matrixA
	 * @param matrixB
	 * @param matrixC
	 */
	static void classicalMatrixMultiplication(int n, int[][] matrixA, int[][] matrixB, int[][] matrixC) {

		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
//				matrixC[i][j] = 0;
				for(int k = 0; k <= n; k++) {
					matrixC[i][j] = matrixC[i][j] + matrixA[i][k] * matrixB[k][j];
				}
			}
		}
	}
	
	/**
	 * will populate matrix with random values
	 * 
	 * @param matrix
	 */
	static void populateMatrix(int[][] matrix) {
		// generates random values for matrix
		Random rand = new Random();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rand.nextInt(10) + 1;
			}
		}
	}
	
	/**
	 * prints out contents of the matrix
	 * 
	 * @param matrix
	 */
	static void printMatrix(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
