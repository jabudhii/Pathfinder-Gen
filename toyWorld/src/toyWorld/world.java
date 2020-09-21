package toyWorld;

import java.util.Scanner;

//toyWorld Package
//world Class
//@author: Matt Kimball <JaBudhii>

/*
* toyWorld: base world generator for pathfinder dungeon masters
* Requirements:
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* BASICS
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Generate Climate
* Generate a random map associated with the world
* Determine the populations of continents available
* Generate World Powers
* Generate Estimation of recommended CR monster areas
* Generate random towns, cities, and outposts based on climate and geography
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* GAME SEPCIFIC
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Generate anomalies in the world resulting from Travelers
* Generate random encounters based on anomalies
* 
* 
* 
* 
*/

// I will begin using this for generating random numbers
import java.util.concurrent.ThreadLocalRandom;  // This does not require creating a new random object
// Example:  int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
// (4/6/2018)  After using this, it is far mroe useful than java.util.Random




@SuppressWarnings("unused")  // Temporary solution while import ThreadLocalRandom is not being used in this class currently
public class world {  // world Class
		
	enum climate{hot, norm, cold}
	 
	climate worldClimate = climate.norm;
	
	public world() {  // Constructor for world Class
		baseLess();
	}  // End of Constructor
	
	
	public void baseLess() {
		@SuppressWarnings("resource")  // Suppresses the warning that kbWT is not closed
		Scanner kbWT = new Scanner(System.in);
		toyWorld.slowConsole("Ubiquitus Hellos Given");  // Types slow, gives random
		System.out.println("\nPress Enter to return to the Menu");
		kbWT.nextLine();
		
	}
	
	
	
}  // End of world Class
