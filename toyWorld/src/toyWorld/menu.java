package toyWorld;

import java.util.Scanner;
import java.util.Random;

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


public class menu {
	final String TITLE = "toyWorld\tGenerator";
	String[] menuOptions = {"New World", "Load World", "Enemy Generator", "Anomalies", "Quit\t"};
	String[] menuOptionBtn = {"N", "L", "E", "A", "Q"};
	String[] rollOptions = {"d2", "d3", "d4", "d6", "d8", "d10", "d12", "d20", "perc"};
	
	public final static String BUILD = "13";  // Constant Build Value only incremented when application is being written
	public final static String VERSION = "0.0.1";  // Constant Version Value only incremented when application is being written
	String mainUserSelection = "";
	
	public menu(int numGens) {  // Constructor that runs when the class is used
		createMenu(numGens);
	}  // End of Constructor

	public void createMenu(int numberOfGens) {  // Creates the main menu for the user
		while (!mainUserSelection.equalsIgnoreCase(menuOptionBtn[menuOptionBtn.length - 1].toString())/* "Q" */) {  // Repeats the main menu function while the users response is not "Q"
			// Creation of Menu
			// This displays the information the user needs to use the application
			
			for (int i = 0; i < 50; i++) {  // Runs 50 times to create blank space
				System.out.println();  // Create Blank Line
			}  // End of for loop
			
			// ABOVE CREATES GAP FOR MENU TO BE SEEN CLEARLY ^^
			System.out.println(TITLE + "\nBuild: " + BUILD + "\tVersion: " + VERSION);  // Displays build, version, and title
			for (int i = 0; i < menuOptions.length; i++) {  //Displays the menu options that takes the user to different areas
				System.out.println(menuOptions[i] + "\t" + menuOptionBtn[i]);
			}  // End of For loop
			// System.out.println();  // Adds a gap
			System.out.println("Type the roll choices to roll the selected die");
			for (int i = 0; i < rollOptions.length; i++){  // Displays dice that the user can roll from the menu
				System.out.print(rollOptions[i] + " ");
			}  // End of For loop
			System.out.println();  // Adds a gap
			// End of Menu Creation
			
			checkResponse(numberOfGens);  // Allows the user to enter input for the Menu Options
		}  // End of WHILE Loop
	}  // End of createMenu Method
	
	public void checkResponse(int gensForGenerator) {  // Allows the user to use a Scanner to input data into the menu
		// This method will allow the user to add input to the program, allowing the user to select the desired option from the menu
		// Selecting a menu option will take them to another part of the program
		
		// Creating Base values used within checkResponse Method
		String userSelection;  // Used if the users action is more than 1 character
		Scanner kbM = new Scanner(System.in);
		String dieSelect = "";  // String init as String with no characters (null?)
		boolean wasDie = false;  // bool init as false
		int dieNum;  // Number of Die to roll
		int rollMod;  // Modifier included in the roll totals
		int dieSelectType = 0;  // Int init as 0
		Random tempRollStorage = new Random();
		
		
		
		// An Error exists on the line below, am unsire why
		userSelection = kbM.nextLine();  // nextLine returns a String, so first the value is put into userSelection for checking
		mainUserSelection = userSelection;
		
		
		
		
		// Determine whether or not the input is relating to a Die Roll
		for (int i = 0; i < rollOptions.length; i++) {
			if (userSelection.equalsIgnoreCase(rollOptions[i].toString())) {  // Checks to determine if the 
				dieSelect = rollOptions[i];
				dieSelectType = i;
				wasDie = true;
				i += 100;  // This should end the for loop
			}  // End of if Statement
		}  // End of for loop
		
		if (wasDie) {
			if(userSelection.contains("d")) {  // Runs if the user entered a die roll request
				System.out.println("You have Selected to roll " + dieSelect + "\nHow many do you wish to roll?");
				dieNum = kbM.nextInt();
				kbM.nextLine();
				System.out.println("You are rolling " + dieNum + " " + dieSelect);
				System.out.println("Type a modifier if applicable, enter 0 if no modifier is necessary");
				rollMod = kbM.nextInt();  // Sets the rollMod that is added to each Roll
				
				// Roll Dice and determine roll equivalent
				int[] diceVal = {2, 3, 4, 6, 8, 10, 12, 20};  // Holds max values for die types
				int diceType = diceVal[dieSelectType];  // Sets the max value for possible max rolls determined by user chosen die type
				int[] rolledDice = new int[dieNum];  // Holds the values for rolled dice
				
				// Roll Dice to get rolledDice values
				for (int i = 0; i < rolledDice.length; i++) {  // Rolls Dice
					rolledDice[i] = tempRollStorage.nextInt((diceType - 1)+1)+1;
					rolledDice[i] += rollMod;
				}  // End of For Loop
				
				// Display Rolls and the Roll Type
				System.out.println("Roll:\t" + dieNum + "d" + diceType + "+" + rollMod);  // Displays the Roll Equivalent
				for (int i = 0; i < rolledDice.length; i++) {  // Displays each result from rolling the dice, as well as the Mod
					System.out.println("Die" + (i+1) + ":\t" + rolledDice[i]);
				}  // End of For Loop
				
				
			}  // End of If Statement for Choosing standard roll
			
			// Runs if the user requests a percentage
			else if (userSelection.equalsIgnoreCase("perc")) {  // Runs if the user chooses a percentile die
				System.out.println("Roll Percentile Dice");
				int percent = tempRollStorage.nextInt((100 - 1)+1)+1;  // Returns a percentage between 1 and 100
				System.out.println(percent + "%");  // displays the percentage value
			}  // End of Percentage else if Statement
			
			System.out.println("Press Enter");
			if (!userSelection.equalsIgnoreCase("perc")) { // If the user does not choose a percentile die
				// For some reason, this is needed only when the user selects a regular die, not a percentile die
				kbM.nextLine();  // Clears the kbM Line
			}  // End of clearing Scanner
			userSelection = kbM.nextLine();  // Gets the users response
			createMenu(gensForGenerator);
		}  // End of DiceCheck [if wasDie == true]
		
		
		//Check for Standard Menu Options
		else if (!wasDie) {
			String menuOptionChosen = "Base Value";  // Used to hold the vale for the menu item the user chose
			for (int i = 0; i < menuOptionBtn.length; i++) {
				if (userSelection.equalsIgnoreCase(menuOptionBtn[i])) {  // Checks to determine if the 
					menuOptionChosen = userSelection.toString();
				}  // End of if Statement for button items
				else if (userSelection.equalsIgnoreCase("changelog")) {  // Used if the user types the 'hidden option' changeLog
					menuOptionChosen = "changelog";
				}  // End of else if statement for changelog
				
				// End of User Menu Selection Check
				
				
			}  // End of for loop
			
			// Checks for values of menuOptionChosen variable
			//Place any new menu items check here
			if (menuOptionChosen.equalsIgnoreCase("N")) {  // If the user wants to create a new world
				
				@SuppressWarnings("unused")
				world master = new world();  // Generates new world
			}
			else if (menuOptionChosen.equalsIgnoreCase("L")){  // If the user wants to load a previous world
				System.out.println("Load World:\nThis option is not available yet - Press Enter");
				kbM.nextLine();
				createMenu(gensForGenerator);
			}
			else if (menuOptionChosen.equalsIgnoreCase("E")){  // If the user wants to load a previous world
				
				@SuppressWarnings("unused")
				enemyGenerator creator = new enemyGenerator(gensForGenerator);
			}
			else if (menuOptionChosen.equalsIgnoreCase("A")){  // If the user wants to load a previous world
				
				@SuppressWarnings("unused")
				anomalies bummer = new anomalies();  // Generates new anomalies
			}
			else if(menuOptionChosen.equalsIgnoreCase("Q")) {  // If the user wants to quit the program
				System.out.println("Thank you for using " + TITLE + "\nClosing Program...");
				kbM.close();
				System.exit(0);
			}
			else if (menuOptionChosen.equalsIgnoreCase("changelog")) {
				for (int i = 0; i < toyWorld.changeLog.length; i++) {
					System.out.println(toyWorld.changeLog[i]);
				}
				System.out.println("\nPress Enter to return to menu");
				kbM.nextLine();
				createMenu(gensForGenerator);
			}
			else {  // If the user has made an invalid option selection
				System.out.println("Error - No option was chosen, enter an available option - Press Enter");
				kbM.nextLine();
				createMenu(gensForGenerator);
			}
		}  // End of Standard Menu Option Check
		
	}  // End of checkResponse Method
	
	
}  // End of Menu Class
