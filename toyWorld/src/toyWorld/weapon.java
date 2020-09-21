package toyWorld;

import java.util.concurrent.ThreadLocalRandom;

/* CLASS INFORMATION / REQUIREMENTS
 * Weapon Class
 * This class should hold stats for weapons
 * This class should be able to generate the following
 * Weapon gName						-> String										-> The name someone gives the weapon (ex: Goblin Slayer)
 * Weapon name						-> String										-> The NAME of the weapon (ex: Longsword)
 * Weapon Type						-> String[]										-> Weapon Type (ex: Ranged, Melee, etc)
 * Weapon Damage					-> Int[]										-> The damage the weapon deals, array for size differences
 * Weapon Is Enchanted (Optional)	-> Boolean										-> Sets whether or not the weapon is enchanted
 * Weapon Enchantment (Optional)	-> String[]										-> Array of possible enchantments that can be given to a Weapon
 * Weapon Masterwork (Optional)		-> Boolean										-> Sets whether or not the weapon is Masterwork (if so +1 Attack Rolls)
 * Weapon Damaged Amount (Optional)	-> Int											-> Amount of damage the weapon has taken
 * Weapon DamageType				-> String[]										-> Returns a string value for equivalent of damage (ex: lightly damaged)
 * Weapon AC						-> Int											-> The AC of the weapon 
 * Weapon  Material Type			-> String										-> The Material the weapon is made of (ex: Steel, Silver, Gold, Brass)
 * Weapon Engravings (Optional)		-> String										-> Returns a string of misc cosmetic engravings on it 
 * Weapon Size						-> String[]										-> Returns the size of the weapon, which can affect damage and who can use it
 * Weapon Requirements				-> String[]										-> Requirements the user must have to use the weapon
 * 
 * These should be generated based off of in order:
 * type, name, size, masterwork, isEnchanted(->Enchantment), material, damageAmount, damageType, (ETC)
 * 
 * There should be an option to return basic information such as the gName, damage, and condition for simple loot generation
 * 
 * UPDATE: 4/18/2018
 * The Addition of randomly generating damage to loot has been removed for now
 * 
 */

public class weapon {  // weapon Class
	
	// EXCEPTION
	// item object created for reference in engravList Array
	item randItem = new item();
	// Constant Array Values
	// Basic
	public final static String[] sizeType = {"Small", "Medium", "Large"};  // Sizes for weapons
	// final String[] weaponMainType = {"Simple", "Martial", "Exotic"};  // Sub-type for weapons <UNARMED REMOVED: 4/21/2018>, Completely removed, included in weapon info 4/21/2018
	final String[] weaponType = {"Ranged", "Melee"};  // Main Types for weapons
	final String[] hands = {"Unarmed", "One-Handed", "Two-Handed"};  // Either one hand or two hand weapons
	// Ranged
	final String[] weaponRangeType = {"Thrown", "Projectile"};  // Either throwing weapons or weapons that use ammunition
	
	// Damage
	final String[] damagedType = {"Lightly scratched", "Fairly damaged", "Heavily damaged", "It wont take much more", "Destroyed"};  // Returned depending on amount of damage the weapon has taken
	public static final String[] materialType = {"Wood", "Bronze", "Gold", "Iron", "Steel", "Stone", "Leather", "Mithral", "Adamantine", 
			"Glass", "Steel with Gold Bits", "Wood with Steel Bits", "Obsidian", "Cold Iron", "Ice", "Bone", "Copper-Plated Steel", "Paper"};
	
	// Extra
	final String[] langList = {"Common", "Dwarven", "Elven", "Catfolk", "Druidic", "Gnome", "Halfling", "Draconic"};
	final String[] engravList = {"Floral Pattern", ThreadLocalRandom.current().nextInt(0, langList.length) + "Words", "Lightning Bolts",
			"People fighting a Dragon", "A Demon", "A Dwarf with several floozies", "A woman holding a spatula", "An " + randItem.generateRandomItem(false)};
	final String[] enchList = {"Shock, deals extra 1d6 electricity damage", "Spell Storing, 1 spell up to level 3, can be refilled by spellcaster",
			"Frost, deals extra 1d6 cold damage", "Speed, allows the user to make 2 attacks instead of one"};
	// These are lists of Weapon names, damage, AC, and possible specialEffects of the weapon
	//These arrays are parallel to their sections (ex: thrownWeapon Arrays are parallel with other thrownWeapon Arrays)
	// RANGED -------------------------------------
	// Throwing Weapons
	final String[] thrownWeaponNames = {"Javelin", "Dart", "Shuriken"};
	final String[] thrownWeaponMainTypes = {"Simple", "Simple", "Exotic"};
	final String[] thrownWeaponSmDamage = {"1d4", "1d3", "1, just 1"};
	final String[] thrownWeaponMeDamage = {"1d6", "1d4", "1d2"};
	// Projectile Weapons
	final String[] projWeaponNames = {"Blowgun", "Light Crossbow", "Heavy Crossbow", "Sling", "Shortbow", "Longbow", "Hand Crossbow", "Double Crossbow"};
	final String[] projWeaponMainTypes = {"Simple", "Simple", "Simple", "Simple", "Martial", "Martial", "Exotic", "Exotic"};
	final String[] projWeaponSmDamage = {"1, just 1", "1d6", "1d8", "1d3", "1d4", "1d6", "1d3", "1d6"};
	final String[] projWeaponMeDamage = {"1d2", "1d8", "1d10", "1d4", "1d6", "1d8", "1d4", "1d8"};
	final String[] projWeaponAmmoType = {"Blowgun Darts", "Bolts", "Bolts", "Rocks(-1 Attack Roll), Pellets, Bullets", "Arrows", "Arrows", "Bolts", "Bolts"};
	// MELEE --------------------------------------
	final String[] mWeaponNames = {"Gauntlet", "Brass Knife", "Dagger", "Sickle", "Wooden Stake", "Club", "Heavy Mace", "Morningstar", "Spear", "Quarterstaff",
			"Light Hammer", "Hand Axe", "Machete", "Short Sword", "Battleaxe", "Scimitar", "Warhammer", "Long Sword", "Glaive", "Greataxe", "Great Sword", 
			"Halberd", "Pick Axe", "Scythe", "Nunchaku", "Bastard Sword", "Dwarven Waraxe", "Harpoon", "Garrote", "Two-Bladed Sword"};
	final String[] mWeaponMainTypes = {"Simple", "Simple", "Simple", "Simple", "Simple", "Simple", "Simple", "Simple", "Simple", "Simple", 
			"Martial", "Martial", "Martial", "Martial", "Martial", "Martial", "Martial", "Martial", "Martial", "Martial", "Martial", 
			"Martial", "Martial", "Martial", "Exotic", "Exotic", "Exotic", "Exotic", "Exotic", "Exotic"};
	final String[] mWeaponHandReq = {"Unarmed", "One-Handed(Light)", "One-Handed(Light)", "One-Handed(Light)", "One-Handed(Light)", "One-Handed", "One-Handed", "One-Handed", "Two-Handed", "Two-Handed",
			"One-Handed(Light)", "One-Handed(Light)", "One-Handed(Light)", "One-Handed(Light)", "One-Handed", "One-Handed", "One-Handed", "One-Handed", "Two-Handed", "Two-Handed", "Two-Handed", 
			"Two-Handed", "Two-Handed", "Two-Handed", "One-Handed(Light)", "One-Handed", "One-Handed", "Two-Handed", "Two-Handed", "Two-Handed"};
	final String[] mWeaponSmDamage = {"1d2", "1d3", "1d3", "1d4", "1d3", "1d4", "1d6", "1d6", "1d6", "1d4/1d4",
			"1d3", "1d4", "1d4", "1d4", "1d6", "1d4", "1d6", "1d6", "1d8", "1d10", "1d10", 
			"1d8", "1d6", "1d6", "1d4", "1d8", "1d8", "1d6", "1d4", "1d6"};
	final String[] mWeaponMeDamage = {"1d3", "1d4", "1d4", "1d6", "1d4", "1d6", "1d8", "1d8", "1d8", "1d6/1d6", 
			"1d4", "1d6", "1d6", "1d6", "1d8", "1d6", "1d8", "1d8", "1d10", "1d12", "1d6/1d6", 
			"1d10", "1d8", "2d4", "1d6", "1d10", "1d10", "1d8", "1d6", "1d8/1d8"};
	// End of Weapon Lists
	
	
	// Values held for the item created
	static String gName, name, material, engravings, size, reqHands, mainType, type, rangeType, damageRoll, ammo, enchantment;
	static boolean isEnchanted, isMasterwork, hasEngravings;
	static int weaponAC, weaponDamagedAmount, ammoAmount;
	
	
	
	
	
	public weapon(String creatureSize) {  // Constructor (Requires Creature Size to get size of weapon)
		/*
		 * This Constructor is different, as it has the methods running within it rather than calling one method containing them
		 * 
		 * Determine Weapon MAINTYPE			// This was removed and added to create weapon method as generating it separately was useless
		 * Determine Weapon SIZE *
		 * Determine Weapon HANDS Requirements *
		 * Determine Weapon WEAPONTYPE *
		 * 		(IF APPLICABLE) Determine Weapon SUBTYPE *
		 * Determine Weapon NAME, DAMAGE, (AC <REMOVED>)
		 * Determine Weapon MASTERWORK
		 * Determine Weapon ENCHANTMENT
		 * Determine Weapon DAMAGED <REMOVED>
		 * Determine Weapon ENGRAVINGS
		 * Determine Weapon GNAME
		 * 
		 */
		gName = "No Special Name";  // Sets init value for gName
		determineSize(creatureSize);  // Sets the Size of the Weapon {SMALL, MEDIUM, LARGE}
		determineHands(creatureSize);  // Sets the Weapons Hand Requirements {ONE-HANDED, TWO-HANDED}
		determineWeaponType();  // Sets the WeaponType {RANGED, MELEE}
		determineWeapon();  // Sets ranged, or melee
		createWeapon();  // Sets the Weapons name, attack roll, damage, dc, and whether or not the weapon  itself is damaged {(RANGETYPE POSSIBLE), NAME, DAMAGE, DC, DAMAGEDAMOUNT}
		if (isEnchanted) {  // Creates and enchantment if the item is enchanted
			determineEnchantment();
		}  // End of Enchant Check
		
		
		// Place displayWeaponInfo here later?
		
		
	}  // End of Constructor
	
	public static String displayWeaponInfo() {  // Displays information about the weapon
		// This is temporary, as displayWeaponInfo() is not in use yet
				return"Weapon: " + name + "\t\tSpecial Name: " + gName + "\t\tMaterial: " + material + "\t\tSize: " + size + "\t\tMasterwork: " + isMasterwork
		+ "\nRequired Hands: " + reqHands + "\t\tType: " + type + "\t\tRange Type: " + rangeType + "\t\tDamage Roll: " +
				damageRoll + "\nEnchantment: " + enchantment + "\nEngravings: " + engravings;
		
	}  // End of displayWeaponInfo Method
	
	public void determineEnchantment() {
		  int randomNum = ThreadLocalRandom.current().nextInt(1, 100);  // int for random number generation
		  // Generate Basic qualities of weapon that are visible
		  if (randomNum >=1 & randomNum <= 31) {  // If the item sheds light
			  enchantment = "The weapon glows as though it has the light spell cast upon it / ";
		  }
		  else if (randomNum >=32 & randomNum <= 45) {  // If the item has a noticeable inscription, design motif, or anything else
			  
			  enchantment = "There  is a clue on the weapon for the enchantment / ";
		  
		  }
		  else if (randomNum >=46) {  // If there is no noticeable quality
			  enchantment = "There is nothing visually special about the weapon / ";
		  }  // End  of IF/ELSEIF Block
		  enchantment += enchList[ThreadLocalRandom.current().nextInt(0, enchList.length)];
		  
	}  // End of determineEnchantment Method
	
	public void createWeapon() {  // Randomly Selects a Weapon Based on the previously set data
		@SuppressWarnings("unused")  // Suppresses unused error on element VAR below
		int element;
		
		if (ThreadLocalRandom.current().nextInt(1,4) >= 2) { 
			material = materialType[ThreadLocalRandom.current().nextInt(0, materialType.length)];  // Get Random Material
		}
		else {
			material = "Normal Material";  // Standard Material for Item
		}
		
		
		if (type.equalsIgnoreCase("Ranged")) {
			switch (rangeType) {
				case "Thrown":
					element = ThreadLocalRandom.current().nextInt(0, thrownWeaponNames.length);  // Get Random Assignment
					name = thrownWeaponNames[element];  // Get Name
					if (size.equalsIgnoreCase("Small")) {  // Determine Damage Based on Size
						damageRoll = thrownWeaponSmDamage[element];  // SMALL
					}
					else {
						damageRoll = thrownWeaponMeDamage[element];  // MEDIUM/LARGE/ETC
					}  // End of IF/ELSE Block
					
					break;
				case "Projectile":
					element = ThreadLocalRandom.current().nextInt(0, projWeaponNames.length);  // Get Random Assignment
					name = projWeaponNames[element];  // Get Name
					if (size.equalsIgnoreCase("Small")) {  // Determine Damage Based on Size
						damageRoll = projWeaponSmDamage[element];  // SMALL
					}
					else {
						damageRoll = projWeaponMeDamage[element];  // MEDIUM/LARGE/ETC
					}  // End of IF/ELSE Block
					
					
					break;
					
				default:
					System.out.println("ERROR - DEFAULT AT LINE 124 in weapon.class");
					break;
				
			}  // End of Switch within RANGED selection
		}  // End of RANGED SELECTION
		else {  // If the Weapon was MELEE
			element = ThreadLocalRandom.current().nextInt(0, mWeaponNames.length);  // Get Random Assignment
			name = mWeaponNames[element];  // Get Name
			if (size.equalsIgnoreCase("Small")) {  // Determine Damage Based on Size
				damageRoll = mWeaponSmDamage[element];  // SMALL
			}
			else {
				damageRoll = mWeaponMeDamage[element];  // MEDIUM/LARGE/ETC
			}  // End of IF/ELSE Block
		}  // End of MELEE Weapon  Generation
		// Now its time to generate the possibility of it having a supername
		for (int i = 0; i < 4; i++) {
			int sNameChance = ThreadLocalRandom.current().nextInt(0, 100);  // Random number used for name, master-work, and enchantment
			if (sNameChance > 95 & i == 0) {  // Generates a special name for the weapon
				gName = "The " + name + " of " + enemyGenerator.generateSuperName();
			} 
			if (material.equalsIgnoreCase(materialType[7]) || material.equalsIgnoreCase(materialType[8])) {  // Mithral and Adamantine are automatically Masterwork
				isMasterwork = true;
			}
			else {  // If material is not Mithral / Adamantine
				if (sNameChance > 70 & i == 1) {  // Master-Works
					isMasterwork = true;
				}
				else {
					isMasterwork = false;
				}
			}
			if ((sNameChance > 70  & isMasterwork) & i == 2) {  // Enchants
				isEnchanted = true;
			}
			else {
				isEnchanted = false;
				enchantment = "N/A";
			}
			if (sNameChance > 70 & i == 3){
				hasEngravings = true;
				engravings = engravList[ThreadLocalRandom.current().nextInt(0, engravList.length)];
			}
			else {  // If there are no engravings
				engravings = "N/A";
			}// End of IF Blocks
		}  // End of FOR Loop
	}  // End of createWeapon Method
	
	public void determineWeapon() {  // Determines whether or not the weapon is ranged or melee, those subtypes, then randomly selects a weapon of that variation
		// This sets the weapons types, the weapon itself, its attack, its dc, its damage, and whether or not its damaged
		
		if (type.equalsIgnoreCase("Ranged")) {  // Determines whether the weapon is ranged or melee, then chooses the weapons NAME, DAMAGE, DC
			rangeType = weaponRangeType[ThreadLocalRandom.current().nextInt(0, weaponRangeType.length)];
			if (rangeType.equalsIgnoreCase("Thrown")) {  // If the rangeType is Thrown
				
			}
			else {  // If the rangeType is Projectile
				rangeType = "Projectile";
				
			}  // End of IF/ELSE Block for Range Types
		}  // End of IF RANGED
		else {  // If the Weapon is MELEE
			rangeType = "N/A";
			
		}  // End of IF/ELSE Block
		
	}  // End of determineWeapon Method
	
	public void determineWeaponType() {  // Randomly Selects a WeaponType
		type = weaponType[ThreadLocalRandom.current().nextInt(0, weaponType.length)];
	}  // End of determineWeaponType Method

	
	public void determineHands(String thingSize) {  // Randomly Sets the hands that are required for the weapon
		if (thingSize.equalsIgnoreCase("Small") & size.equalsIgnoreCase("Medium")) {  // If the Character is SMALL and the weapon is MEDIUM size
			reqHands = "Two-Handed";
		}
		else {  // Randomly generate whether the weapon is One-Handed or Two-Handed
			reqHands = hands[ThreadLocalRandom.current().nextInt(0, hands.length)];  // Randomly Generate reqHands
		}
		//reqHands = hands[ThreadLocalRandom.current().nextInt(0, hands.length)];
		
	}  // End of determineHands Method
	
	
	public void determineSize(String thingSize) {  // Determines the size of the weapon based on creature size
		// int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1    /* dont +1 if it is getting a list/array size */);
		// 
		switch (thingSize){
			case "Small":  // If the creature is Small
				size = sizeType[ThreadLocalRandom.current().nextInt(0, 1)];  // Can use medium One Hand at 
				break;
			case "Medium":  // If the creature is Medium
				size = sizeType[ThreadLocalRandom.current().nextInt(0, 2)];  // Can use all
				break;
				
			case "Large":  // If the creature is Large
				size = sizeType[ThreadLocalRandom.current().nextInt(1,2)];
				break;
			default:
				System.out.println("DEFAULT REACHED");
				size = sizeType[ThreadLocalRandom.current().nextInt(0, 2)];  // Can use all
				break;
		}  // End of Switch Block
	}  // End of determineType Method
	
	
	
}  // End of weapon Class
