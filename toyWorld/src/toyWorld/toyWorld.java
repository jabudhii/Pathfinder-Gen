package toyWorld;
import java.time.LocalDateTime;
import java.util.Scanner;

//toyWorld Package
//world Class
//@author: Matt Kimball <JaBudhii>

/*
* toyWorld: base world generator for Pathfinder dungeon masters
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
* Build 9 Date: 4/16/2018
* Build 10 Date: 
*/

public class toyWorld {  // toyWorld Class
	/*
	 * This Class is the primary class that the application runs
	 * This Class creates a menu object based on the menu class
	 * This class also creates text regarding this application and displays a change-log
	 */

	
	// This is used for file saving
	public int numOfGensThisSession = 0;  // Used durring saveToFile Method, counts number of generations made durring the session and allows numbering of the files being saved
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner kb = new Scanner(System.in);
		
		int generationsOfFile = 0;
		weapon jiggy = new weapon("Medium");
		System.out.println(LocalDateTime.now().toString());
		slowConsole("This is an experimental application\nThis application is meant for basic generation of anomalies, loot, and enemies\n"
				+ "This should not be used as a final product, nor should it reflect anything that is considered useful in any way\n"
				+ "This application is only applicable to the Gem Campaign, added ability to view changelog via 'changeLog' command in menu\n" + 
				showChangeLog(menu.BUILD, false), 8);
		@SuppressWarnings("unused")
		menu mainMenu = new menu(generationsOfFile);
		
		kb.close();  // Closes the kb Scanner when the Main Method Ends
	}  // End of Main Method

	public static void slowConsole(String output) {  // Allows slow output to be given on the console screen
		char[] newOut = output.toCharArray();
		for (int i = 0; i < newOut.length; i++) {
			System.out.print(newOut[i]);
			try {  // Will cause the program to wait 48 milliseconds before printing the next character
			    Thread.sleep(48);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {  // Runs if an Exception is found
			    Thread.currentThread().interrupt();  // I believe this displays the error + line occurred in the program
			}  // End of TryCatch
		}  // End of For loop
		System.out.println();  // Ends the line
	}  // End of slowConsole Method
	public static void slowConsole(String output, int sleepTime) {  // Allows slow output to be given on the console screen -- This variant allows variable print speeds
		char[] newOut = output.toCharArray();
		for (int i = 0; i < newOut.length; i++) {
			System.out.print(newOut[i]);
			try {  // Will cause the program to wait 48 milliseconds before printing the next character
			    Thread.sleep(sleepTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {  // Runs if an Exception is found
			    Thread.currentThread().interrupt();  // I believe this displays the error + line occurred in the program
			}  // End of TryCatch
		}  // End of For loop
		System.out.println();  // Ends the line
	}  // End of slowConsole Method

	public static String[] changeLog = {"Build 7:\tenemyGenerator was added, currently being worked on",
			"Build 8:\tDamage was added to looted items, Unique names added to some magical items", "Build 9:\tweapon Class added, not implemented", 
			"Build 10:\tweapon class implemented into enemyGenerator, basic information about some weapons now generated, damage to items removed, standard weapons added", 
			"Build 11:\tweapon Class finished, added armor and item classes, not yet implemented", "Build 12:\tanomalies now able to use item and weapon classes to generate random items\n\t Added Saving to each generation of loot or anomaly", 
			"Build 13:\tFinalized File creation, added ways to interpret how the files are named, fixes some aspects of file saving"};
	
	public static String showChangeLog(String build, boolean showAll) {  // Returns changelog String
		String log = "";  // init log variable
		if (!showAll) {  // If show all is false
			int buildInt = Integer.parseInt(build) - 7;  // Sets the buildlog to the current one (buildLog was setup on build 7, list starts at 0, 7-0=0 -> build 7 changelog is element 0)
			log = changeLog[buildInt];  // Sets the current changelog string to the current relevant changelog addition
		}
		else{  // Displays the whole changelog
			for (int i = 0; i < changeLog.length; i++) {  // Loops for each change in the application
				log += changeLog[i] + "\n";
			}  // End of FOR Loop
		}  // End of IF/ELSE Block
		return log;
	}
}  // End of toyWorld Class
