package toyWorld;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class anomalies {

	
	// INT used to hold number of people;
	private int population = 0;
	
	public anomalies() {  // Constructor for anomalies		
		createAnomalies();  // Creates the Anomalies
	}  // End of Constructor
	
	
	public int determineAffected(int numberOfPeople) {
		
		Random tempStorage = new Random();
		int affectedPeople;
			
		affectedPeople = tempStorage.nextInt((numberOfPeople - 1)+1)+1;  // Has minimum of one person affected
		population -= affectedPeople;  // This reduces the remaining amount of people by the amount affected
		return affectedPeople;
	}
	
	
	public void createAnomalies() {  // Generates what will happen
		
		@SuppressWarnings("resource")  // Suppresses the warning that kbA does not close
		Scanner kbA = new Scanner(System.in);  // Scanner used within the anomalies Class
		System.out.println("How many people are in the area?");
		population = kbA.nextInt();
		kbA.nextLine();
		
		System.out.println("How many anomalies are present?");
		final int numAnom = kbA.nextInt();
		kbA.nextLine();  // Clears Scanner
		System.out.println("---------------------------------------------------------");  // Separates input form listed anomalies
		for (int i = 0; i < numAnom; i++) {  // Creates the amount of anomalies that the user wants
			System.out.println();  // Adds a gap between anomalies
			String anom = "";
			determineType(affectPeople(), population);  // Creates and Displays the Anomaly
			
		}  // End of FOR Loop
		System.out.println("Press Enter");
		kbA.nextLine();
	}  // End of createAnomalies Method
	
	
	public boolean affectPeople() {
		// Random tempStorage = new Random();
		int people;
			
		// THIS SHOULD SAVE MEMORY ON THE PROGRAM AS WELL AS REDUCE CODE >>
		// Trying a new way to get a random number
		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		// previously (and not working may i add)
		// people = tempStorage.nextInt((1 - 0)+1)+0;  // Has minimum of one person affected
		people = ThreadLocalRandom.current().nextInt(0, 1 + 1);
		if(people == 1 && population > 0) {  // This means it will affect people
			return true;
		}
		else {  // This will affect objects, buildings, or any non people things
			return false;
		}
		
	}
	
	
	public void determineType(boolean affect, int curPop) {  // Uses affectPeople Method
		
		// These arrays are used for anomalies
		// List of races
		String[] raceList = {"Orcs", "Gobins", "Elves", "Humans", "Dwarfs", "Halflings", "Gnomes", "Catfolk",
				"Vishkanyans", "Teiflings", "Tengu", "Half-Elves", "Half-Orcs"};
		// List of animals/monsters/beastiary
		String[] animalList = {"Squirrels", "Dogs", "Cats", "Sharks", "Dragons", "Giants", "Walrus'", "Drakes", "Sharks",
				"Ladybugs", "Spiders", "Rats", "Parrots", "Bears", "Horses", "Penguins", "SeaHorses", "Talking Horses", "Elephants",
				"Dire Badgers", "Dire Bears"};
		// List of items
		String[] itemList = {"Apples", "Grapes", "Pieces of Meat", "GreatSwords", "Half-Plate Armor", "Rocks", "Cutlary", "Onions",
				"Steaks", "Potatoes", "Magical Rings with their souls trapped in them", "Chairs", "Statues", "Carriages",
				"2 Buildings", "A Castle", "Daggers", "Shields", "Full-Plate Armor", "Chain-Mail Armor", "LongSwords", "TowerShields",
				"WoodenShields", "Death Potions", "Health Potions", "Max Health Potions", "Magic Potions", "Max-Magic Potions"};
		
		String[] worldAffects = {"An Earthquake happens", "An aurora appears in the sky", "Several Houses Disappear",
				"A forrest nearby disappears", "A talking goat appears, their name is " + enemyGenerator.mThingNames[ThreadLocalRandom.current().nextInt(0, enemyGenerator.mThingNames.length - 1)],
				"A magic ring with a persons soul appears, their name is " + enemyGenerator.mThingNames[ThreadLocalRandom.current().nextInt(0, enemyGenerator.mThingNames.length - 1)],
				"A statue of an onion appears", "A building appears", "A house appears 'Upgraded'",
				"A characters item disappears", "A party member disappears", "A mountain is torn apart and tossed into the distance",
				"A dangerous electrical storm appears quickly", "Abnormal weather begins"};
		
		// List of replacement things, a combination of the arrays above
		ArrayList<String> posRepl = new ArrayList<String>(raceList.length + animalList.length + itemList.length);

		// Creates the posRepl ArrayList
		for (int x = 0; x < raceList.length; x++) {  // Adds the raceList to the posRepl ArrayList
			posRepl.add(raceList[x]);
		}
		for (int y = 0; y < animalList.length; y++) {  // Adds the animalList to the posRepl ArrayList
			posRepl.add(animalList[y]);
		}
		for (int z = 0; z < itemList.length; z++) {  // Adds the itemList to the posRepl ArrayList
			posRepl.add(itemList[z]);
		}// End of Creating posRepl ArrayList
		
		item randKiller = new item();  // This is solely used for the stabbing of people in <theAffect> array
		
		
		
		String[] theAffect = {"Get Stabbed with a " + randKiller.generateRandomItem(true), "Disappear", "Explode", "Catch on Fire",
				"Gain " + ThreadLocalRandom.current().nextInt(1, 800) + " Gold pieces", "Loose control of their bowels",
				"Fall over dead", "Get replaced with " + posRepl.get(ThreadLocalRandom.current().nextInt(0, posRepl.size()))};
		
		if (affect) {  // If the Anomaly affects people
			int tempNum = ThreadLocalRandom.current().nextInt(0, theAffect.length);
			int affectedPeople = determineAffected(curPop);
			if (affectedPeople > 1) {  // If theres more than one affected person
				System.out.println(affectedPeople + " people " + theAffect[tempNum]);
			}
			else {  // If there is one or no affected person/people
				System.out.println(affectedPeople + " person " + theAffect[tempNum]);
			}
		}
		else {  // If the Anomaly affects objects or other things
			int d6 = ThreadLocalRandom.current().nextInt(0, 6);
			if (d6 >= 3) {  // Generates anomalies that affect the world
				System.out.println(worldAffects[ThreadLocalRandom.current().nextInt(0, worldAffects.length)]);
			}
			else {  // More Likely Item Appearance
				int d4 = ThreadLocalRandom.current().nextInt(0, 3);
				switch (d4) {
				case 0:  // Weapons
					int d2 = ThreadLocalRandom.current().nextInt(0, 1);  // Generates coin flip
					String size = "";
					if (d2 == 1) {  // if Heads
						size = "Medium";
					}
					else {
						size = "Small";
					}
					weapon randWeapon = new weapon(size);
					System.out.println("A ----\n" + randWeapon.displayWeaponInfo() + "\n----Appears");
					
					break;
				case 1:  // Items
					item randItem = new item();
					System.out.println("A " + randItem.generateRandomItem(true) + " Appears");
					break;
				case 2:  // Armor
					// ARMOR Generation not present yet, case 2 is currently being used to create additional chance for items
					item randItemDup = new item();
					System.out.println("A " + randItemDup.generateRandomItem(true) + " Appears");
					break;
				case 3:  // NPC
					// NPC Generation not present yet, case 3 is currently being used to create additional chance for worldAffects[]
					System.out.println(worldAffects[ThreadLocalRandom.current().nextInt(0, worldAffects.length)]);
					break;
				default:  // Error
					System.out.println("ERROR - Switch reached default on anomalies line " + Thread.currentThread().getStackTrace()[1].getLineNumber());  // Displays current line num	
					break;
				}  // End of Switch
			}
		}  // End of IF/ELSE Block
	}  // End of determineType Method
	
}  // End of anomalies Class
