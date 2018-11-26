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
 * Strassen's Matrix Multiplication
 * 
 * StrassenMatrixMultiplication.java
 *
 */
public class StrassenMatrixMultiplication {

	/**
	 * start of program
	 */
	public static void main(String[] args) {
		System.out.println("Matrix Multiplication");
		
		// sets the size of the n x n matrix
		int matrixSize = 2;
		
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
		
		System.out.println("Matrix C (solution)");
		strassenMultiplicationMatrix(matrixSize, matrixA, matrixB, matrixC);
		printMatrix(matrixC);
		
	}
	
	/**
	 * Strassen's matrix multiplication
	 * 
	 * @param matrixSize
	 * @param matrixA
	 * @param matrixB
	 * @param matrixC
	 */
	static void strassenMultiplicationMatrix(int matrixSize, int[][] matrixA, int[][] matrixB, int[][] matrixC) {
		if(matrixSize == 2) {
			matrixC[0][0] = (matrixA[0][0] * matrixB[0][0]) + (matrixA[0][1] * matrixB[1][0]);
			matrixC[0][1] = (matrixA[0][0] * matrixB[0][1]) + (matrixA[0][1] * matrixB[1][1]);
			matrixC[1][0] = (matrixA[1][0] * matrixB[0][0]) + (matrixA[1][1] * matrixB[1][0]);
			matrixC[1][1] = (matrixA[1][0] * matrixB[0][1]) + (matrixA[1][1] * matrixB[1][1]);
		}
	}
	
	/**
	 * will populate matrix with random values
	 * 
	 * @param matrix
	 */
	static void populateMatrix(int[][] matrix) {
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
