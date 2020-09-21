package toyWorld;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
 * armor Class
 * Author: Matt Kimball
 * Date: 4/22/2018
 * 
 * The purpose of this class is to generate items for players or NPCs
 * 
 * Item Requirements
 * 
 * 
 */


public class item {  // armor Class that will generate items
	// These arrays hold item types
	final String[] entItems = {"Cards", "Crossword Puzzle", "Dartboard Set", "Dice", "Loaded Dice", "Dominos", "Kite", "Marbles", "Puzzle Box", "Tennis Gear"};  // Entertainment Items
	final String[] instItems = {"Guitar", "Sitar", "Lute", "Piano", "Drum Set", "Grand Piano", "Pipe Organ", "Whistle", "Ocarina", "Flute"};  // Instruments
	final String[] wriBooks = {"Journal", "Adventurers Chronicle", "SpellBook", "Dungeon Guide", "Chalk", "Ink", "Glowing Ink", "Invisible Ink", "Inkpen", 
			"Chalkboard", "Paper", "Parchment", "Stationary", "Map", "Scroll", "Printing Press", "Quill", "Sealing Wax"};  // Writing and Books
	final String[] advGear = {"Collapsible Bathtub", "Bedroll", "Blanket", "Hammock", "Soap", "Small Tent", "Medium Tent", "Large Tent", "Fishhook", "Fishing Net", "Butterfly Net",  
			"Bell", "Compass", "Heatstone", "Small Mirror", "Signal Horn", "Candle", "Lamp", "Lantern", "Moonrod", "Sunrod", "Torch", "Everburning Torch"};  // Adventuring Gear
	final String[] foodDrink = {"Absinthe", "Ale", "Grog", "Mead", "Whiskey", "Wine", "Coffee", "Exotic Coffee", "Tea", "Medicinal Tea", "Milk", "Powdered Milk", "Bread", 
			"Cheese", "Chocolate", "Honey", "Ice Cream", "Yogurt", "Maple Syrup", "Onion"};  // Food and Drink
	final String[] gemsLow = {"Aurite", "Blue Quartz", "Lapis Lazuli", "Malachite", "Obsidian", "Tigereye", "Turquoise"};
	final String[] gemsSemi = {"Bloodstone", "Moonstone", "Onyx", "Rose Quartz"};
	final String[] gemsMid = {"Aquamarine", "Violet Garnet", "Black Pearl", "Deep Blue Spinel", "Golden Yellow Topaz"};
	final String[] gemsNice = {"Emerald", "White Opal", "Black Opal", "Fire Opal", "Blue Sapphire", "Yellow Corundum", "Purple Corundum", "Black Star Sapphire"};
	final String[] gemsSupNice = {"Clear Bright Green Emerald", "Diamond", "Jacinth", "Ruby"};
	// Arrays for Special Rings
	final String[] spRingType = {"Ring of Climbing", "Ring of Evasion", "Ring of Invisibility", "Ring of Jumping", "Ring of Regeneration", "Ring of Sustenence"};
	final String[] spRingDesc = {"+5 competence bonus on Climb Checks", "Whenever a Reflex saving throw is made to determine whether the player takes half damage, they take no damage",
			"The ring can be activated to use an invisibility spell", "+5 competence bonus on Acrobatics checks to make high or long jumps", 
			"When the ring is worn, the wearer heals 1 point of damage per round and an equal amount of nonlethal damage. In addition, the wearer is immune to bleed damage.\nIf the user loses a limb, organ, or any other body part, the ring regenerates it as a regenerate spell. Only damage taken while the ring is worn is affected.", 
			"Provices life-sustaining nourishment, the wearer only needs 2 hours of sleep, must be worn for a full week before it begins to work. If it is removed, the user needs to wear it for another week to reattune"};
	final ArrayList<String> itemList = new ArrayList<String>(entItems.length + instItems.length + wriBooks.length + advGear.length + foodDrink.length + spRingType.length);  // This holds all possible items
	final ArrayList<String> gemList = new ArrayList<String>(gemsLow.length + gemsSemi.length + gemsMid.length + gemsNice.length + gemsSupNice.length);  // Holds Gem Types
	String chosenItem = "";  // Variable that Holds the Given Item
	public String theItem = "";
	public item() {  // Constructor for item Class
		generateItemList();  // Setup itemList ArrayList
		theItem = generateRandomItem(true);
		
		
	}  // End of Constructor
	
	
	
	public String generateRandomItem(boolean giveInfo) {
		String ringDesc = "";
		boolean isSpRing = false;
		chosenItem = itemList.get(ThreadLocalRandom.current().nextInt(0, itemList.size() - 1));
		for (int i = 0; i < spRingType.length; i++) {
			if (chosenItem.equalsIgnoreCase(spRingType[i])) {
				isSpRing = true;
				ringDesc = "\tUse: " + spRingDesc[i];
			}  // End of IF Statement
		}  // End of For Loop
		if (ThreadLocalRandom.current().nextInt(0,1) > 0 & isSpRing) {  // Creates a regular ring instead
			isSpRing = false;
			chosenItem = weapon.materialType[ThreadLocalRandom.current().nextInt(0, weapon.materialType.length - 1)] + " ring ";
			if (ThreadLocalRandom.current().nextInt(0,1) > 0) {  // Adds gem to ring
				chosenItem += "with a " + gemList.get(ThreadLocalRandom.current().nextInt(0, gemList.size() - 1));
			}  // End of Gem Generation
		}  // End of Regular Ring Generation
		if (!isSpRing & !giveInfo) {
			return chosenItem;
		}
		else{
			return chosenItem + "\n" + ringDesc;
		}
	}  // End of generateRandomItem Method
	
	
	private void generateItemList() {
		// Creates the itemList ArrayList
		for (int x = 0; x < entItems.length; x++) {  // add entItems array to itemList
			itemList.add(entItems[x]);
		}
		for (int y = 0; y < instItems.length; y++) {  // add instItems array to itemList
			itemList.add(instItems[y]);
		}
		for (int z = 0; z < wriBooks.length; z++) {  // add wriBooks array to itemList
			itemList.add(wriBooks[z]);
		}
		for (int a = 0; a < advGear.length; a++) {  // add advGear array to itemList
			itemList.add(advGear[a]);
		}
		for (int b = 0; b < foodDrink.length; b++) {  // add foodDrink array to itemList
			itemList.add(foodDrink[b]);
		}
		for (int c = 0; c < spRingType.length; c++) {  // add spRingType array to itemList
			itemList.add(spRingType[c]);
		}
	}  // End of generateItemList Method
	
}  // End of item Class
