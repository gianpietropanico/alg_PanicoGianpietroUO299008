package algestudiante.p32;

import java.util.List;
import java.util.Random;

public class SkylineProblem {
	/**
	 * Creates a solution from a text file
	 * @param fileName the name of the file to be processed with the input data
	 */
	public SkylineProblem(String fileName) {
	}
	
	/**
	 * Creates a random solution with a given number of buildings
	 * @param nBuildings the number of desired buildings in the skyline
	 */
	@SuppressWarnings("unused")
	public SkylineProblem(int nBuildings) {
		int positions = 2*nBuildings; //the number of positions in the skyline is proportional to the number of buildings
		for (int i = 0; i < nBuildings; i++) {
			int left = new Random().nextInt(positions-5); //should leave some positions to place the building
			int right = left + 1 + new Random().nextInt(5); //should be a little bigger than left to get a valid position
			int height = new Random().nextInt(90) + 10; //between 10 and 99 meters
			//do something with the new randomly created building
		}
	}
	
	/**
	 * Prints the buildings' information given to the problem
	 */
	public void printBuildings() {
	}
	
	/**
	 * Solves the problem using brute force (without thinking too much)
	 * Complexity is going to be polynomial
	 */
	public void solveBruteForce() {
	}
	
	/**
	 * Solves the problem using divide and conquer (thinking a little bit)
	 * Complexity and times are going to be much better
	 */
	public void solveDivideAndConquer() {
	}
	
	/**
	 * Prints the final solution (the key points for the generated skyline)
	 */
	public void printSolution() {
	}
	
	/**
	 * Returns the solution for the problem
	 * @return the list of key points for the generated skyline
	 */
	public List<KeyPoint> getSolution() {
		return null;
	}
}
