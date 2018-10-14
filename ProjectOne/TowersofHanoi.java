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
	
	static int count = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Towers of Hanoi");
		
		int towerSize = 3;
		
		
		tower(towerSize, "A", "B", "C");
		
		
	}
	
	/**
	 * 
	 * @param height
	 * @param fromPole
	 * @param toPole
	 * @param withPole
	 */
	static void tower(int height, String fromPole, String toPole, String withPole) {
		if(height >= 1) {
			tower(height - 1, fromPole, withPole, toPole);
			move(fromPole, toPole);
			tower(height - 1, withPole, fromPole, toPole);
		}
		
	}
	
	/**
	 * 
	 * @param fromPole
	 * @param toPole
	 */
	static void move(String fromPole, String toPole) {
		System.out.println("Step " + count + " moving disk from " + fromPole + " to " + toPole);
		count++;
	}

}
