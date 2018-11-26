package projectOne;

/**
 * Name: Miguel Menjivar 
 * Course: CS 3310 
 * Design and Analysis of Algorithms
 * 
 * Due Date: 10/24/18
 * 
 * Task #2: 
 * Towers of Hanoi
 * 
 * TowersofHanoi.java
 *
 */
public class TowersofHanoi {
	
	// how many steps to complete tower
	static int count = 1;

	/**
	 * start of program
	 */
	public static void main(String[] args) {
		System.out.println("Towers of Hanoi");
		
		// MODIFY THIS INT TO CHANGE TOWER SIZE
		int towerSize = 64;
		
		// starts timer in nanoseconds how long it takes to run through program
		long startTime = System.nanoTime();
		
		// tower of hanoi 
		tower(towerSize, "A", "B", "C");
		
		// will get total time
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Time: " + totalTime);
	}
	
	/**
	 * recursive method of tower of hanoi
	 * 
	 * @param height = number of disks
	 * @param fromPole = start pole
	 * @param toPole = destination pole
	 * @param withPole = 
	 */
	static void tower(int height, String fromPole, String toPole, String withPole) {
		if(height >= 1) {
			tower(height - 1, fromPole, withPole, toPole);
			// prints transitions amongst poles and disks
			//move(fromPole, toPole);
			
			tower(height - 1, withPole, fromPole, toPole);
		}
		
	}
	
	/**
	 * prints which disks and poles 
	 * 
	 * @param fromPole
	 * @param toPole
	 */
	static void move(String fromPole, String toPole) {
		System.out.println("Step " + count + " moving disk from " + fromPole + " to " + toPole);
		count++;
	}

}
