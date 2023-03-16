package algestudiante.p32;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Skyline {
	private Map<Integer, Integer> heightInPosition = new HashMap<Integer, Integer>(); //key = position; value = height; that is, it stores the height in a particular position of the skyline
	private int leftSide; //left side of the skyline (first point of the skyline)
	private int rightSide; //right side of the skyline (last poaint of the skyline)
	//private List<Integer> listEndPoint = new ArrayList<Integer>();
	public Skyline ( ) {
		
	}
	/**
	 * Creates a new skyline from scratch
	 * @param building the only building used to create the skyline
	 */
	public Skyline(Building building) throws IllegalArgumentException{

		
		if( building.left < 0 || building.right < 0 || building.height <= 0 || building.right == building.left){

			System.out.println( "Argument of building not valid must be \n building.left < 0 || building.right < 0 || building.height < 0 || building.right == building.left ");

		}else{

			leftSide = building.left;
			rightSide = building.right;
			
			heightInPosition.put(leftSide, building.height);
			
			//listEndPoint.add(rightSide);
		}


	}
	
	/**
	 * Creates a new skyline joining together other 2 previous skylines
	 * @param s1 one of the skylines
	 * @param s2 the other of the skylines
	 */
	public Skyline(Skyline s1, Skyline s2) {
		
			
		if( s1.getLeftSide() <= s2.getLeftSide() ){
			leftSide = s1.getLeftSide();
		}else{
			leftSide = s2.getLeftSide();
		}

		if( s1.getRightSide() >= s2.getRightSide()){
			rightSide = s1.getRightSide();
		}else{
			rightSide = s2.getRightSide();
		}

		
		for ( int i = leftSide ; i <= rightSide ; i ++ ){
			
			int s1Height = s1.getHeightInPosition( i );
			int s2Height = s2.getHeightInPosition ( i );

			if ( ( ( s2Height != 0 && s2Height != 0) || ( s1Height == 0 || s2Height == 0 ) )  ) {
				
				
				if( s1Height >= s2Height && ( s1.getRightSide() > s2.getRightSide() || s1.getLeftSide() < s2.getLeftSide() ) ){

					heightInPosition.put(i,s1Height);

				}else if (s1Height <= s2Height && ( s1.getRightSide() < s2.getRightSide() || s1.getLeftSide() > s2.getLeftSide() )){

					heightInPosition.put(i,s2Height);
				}else {
					
					heightInPosition.put(i, 0);
				}
				
			}

		}


	}
	
	/**
	 * Gets the height in a specific position
	 * @param position the position in the skyline
	 * @return the height in the skyline
	 */
	public int getHeightInPosition(int position) {
		if (this.heightInPosition.containsKey(position))
			return this.heightInPosition.get(position);
		return 0;
	}
	
	/**
	 * Returns the first position of the skyline
	 * @return the first position of the skyline
	 */
	public int getLeftSide() {
		return this.leftSide;
	}
	
	/**
	 * Returns the last position of the skyline
	 * @return the last position of the skyline
	 */
	public int getRightSide() {
		return this.rightSide;
	}
	
	/**
	 * Prints the skyline, that is, the height in each of the positions of the skyline
	 */
	public void printHeights() {
		for (int i = this.leftSide; i <= this.rightSide; i++) {
			//System.out.printf("x =%3d y =%3d  \n",i  , this.heightInPosition.get(i));
			if( i != rightSide && heightInPosition.get(i) != 0  ) {
				System.out.printf("x =%3d y =%3d  \n",i  , this.heightInPosition.get(i));
				
			}else if ( i == rightSide && heightInPosition.get(i) == 0) {
				System.out.printf("x =%3d y =%3d  \n",i  , this.heightInPosition.get(i));
			}
			
			
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}
	
}
