
// MainGame.java
// This is the main file for Fort Galapagos, a text adventure game taking 
// place in an alternate universe where strange creatures are slayne! 
// This is the final project for CIS-18A Intro to Java Objects and is intended 
// to demonstrate what I learned in the course. 

// Import declarations
import java.util.Scanner;
import java.security.SecureRandom;

// Class MainGame begin
public class MainGame {
	
	//Method declarations
	/*******************************************************************************
	 * 
	 *  Method name: createAdventurer();
	 *  Description: Method createAdventurer() accepts an integer for difficulty, an  
	 *  							integer value for type, and a String for name. After, it creates 
	 *               and returns an Adventurer object based on difficulty. 
	 */
 
	public static Combatable createAdventurer(int difficulty, int type, String name) {
	
		Combatable adventurer = null;
	
		// Create and return an Adventurer object based on difficulty
		if (difficulty == 3) {
			adventurer = new Adventurer(type, name, 100, 75, 6);
		} else if (difficulty == 2) {
			adventurer = new Adventurer(type, name, 125, 90, 8);
		} else if (difficulty == 1) {
			adventurer = new Adventurer(type, name, 150, 100, 10);
		}
		return adventurer; 
	}
	/*
	 * 
	 *  Method name: createEnemy();
	 *  Description: Method createEnemy() accepts a single integer value for 
	 *               difficulty then creates and returns a Enemy object based 
	 *               on difficulty. 
	 */
	public static Combatable createEnemy(int difficulty) {
	
		// Create a SecureRandom object
		SecureRandom random = new SecureRandom();
	
		// List of Enemy names
		String[] enemyNames = { "Elvarg", "Rogue", "Raven", "Bloat",
				"Tyson", "Beelze", "Condor"};
	
		// List of possible kinds of enemies user can encounter
		String[] enemies = { "Dragon", "Dark Elf", "Dark Wizard", "Giant", "Griffin" }; 
		String kind = enemyNames[random.nextInt(enemyNames.length)] + " the " + 
  		          enemies[random.nextInt(enemies.length)];

		Combatable enemy = null;
 
		//Create and return an Enemy object based on difficulty
		if (difficulty == 3) {
			enemy = new Enemy(300, 30, kind);
		} else if (difficulty == 2) {
			enemy = new Enemy(200, 40, kind);
		} else if (difficulty == 1) {
			enemy = new Enemy(150, 50, kind);
		}
 
		return enemy;
	}

	// Main method
	public static void main(String[] args) {
		
		// Create a Scanner object to obtain user input
		Scanner scan = new Scanner(System.in);
		
		// Welcome the user
		System.out.printf("%n%s%n%s%n%n%s",
				"\n------------------------------------------", 
				"*****  Welcome to Fort Galapagos !!  *****", 
				"Test your might. How many beasts can YOU slay?!\n");
		
		
		// Prompt the user for their name
		System.out.print("Begin by pressing enter OR by entering a username: ");
	  // Store new user value for name
    String name = scan.nextLine(); 
    // If name is empty, default name is Ghost
    if (name == "" || name == null) { 
    	name = "Ghost";
    }
   
    
    // Prompt the user for game difficulty 
    System.out.println("\nWhat difficulty would you like to play on?\n\t" + 
    		"Enter [1] - Easy\n\tEnter [2] - Normal\n\tEnter [3] - Hard");
	  // Check user input for an integer 
		while (!scan.hasNextInt()) { 
			// User did not enter an integer. Re prompt user
			System.out.printf("%nEnter an integer between %d and %d%n%s", 1, 3, 
	    		"\tEnter [1] - Easy\n\tEnter [2] - Normal\n\tEnter [3] - Hard");
			scan.next(); 			
		}	
		// If user input if an integer, store input for game difficulty
		int difficulty = scan.nextInt();	
		// Validate user input for an integer between 1 and 3
		while ((difficulty < 1) || (difficulty > 3)) {
		  // User did not enter an integer between 1 and 3. Re prompt 
			System.out.printf("%nEnter an integer between %d and %d%n%s", 1, 3,  
	    		"\tEnter [1] - Easy\n\tEnter [2] - Normal\n\tEnter [3] - Hard\n");
			difficulty = scan.nextInt(); 
		}
    
		
		// Prompt the user for the type of character they want to play as
		System.out.println("What type of adventurer would you like yo play as?" + 
		"\n\tEnter [1] - Berserker\n\tEnter [2] - Ranger\n\tEnter [3] - Mager");
		// Check user input for an integer 
		while (!scan.hasNextInt()) { 
			// User did not enter an integer. Re prompt user
			System.out.printf("%nEnter an integer between %d and %d%n%s", 1, 3, 
		    	"\tEnter [1] - Easy\n\tEnter [2] - Normal\n\tEnter [3] - Hard");
			scan.next(); 			
		}	
		// Store user input for type
		int type = scan.nextInt();
	  // Validate user input for an integer between 1 and 3
		while ((type < 1) || (type > 3)) {
		 // User did not enter an integer between 1 and 3. Re prompt 
		 System.out.printf("%nEnter an integer between %d and %d%n%s", 1, 3,
					"\n\tEnter [1] - Berserker\n\tEnter [2] - Ranger\n\tEnter [3] - Mager");
		 type = scan.nextInt(); 
  	}
		 

		// Create a new Adventurer object for the user to play as
		Combatable adventurer = createAdventurer(difficulty, type, name);
		// Greet the user once again
		System.out.println("\nHello, mighty " + ((Adventurer) adventurer).getName() 
				+ ". We have been receieving reports \nof night creatures in the area!!\n");  	
		GAME:
			while(true) { // While player decides to play
				
				// Create new Enemy object 
				Combatable enemy = createEnemy(difficulty);
				System.out.println("---------------------------------------------------");
				System.out.println("\nAs you brave off into adventure, out of the bush...\n" 
						+ ((Enemy) enemy).getKind() + " appeared with a menacing look!\n");
				
				// While enemy is not dead
				while(((Entity) enemy).isDead() != true) {
					
					// Print Adventurer and Enemy's health
			  	System.out.println(((Enemy) enemy).getKind() + "'s Health is: " 
			  				+ ((Entity) enemy).getHealth());
				  System.out.println("Your health is: " + 
				  			((Entity) adventurer).getHealth()); 
					
					// Prompt user to either attack, defend, or flee
					System.out.println("\nWhat will you do?\n\tEnter [1] - Attack aggressively!" + 
							"\n\tEnter [2] - Attack defensively! \n\tEnter [3] - " + 
							"Run! Find a new opponent\n\tEnter [4] - Check my stats\n\t" + 
							"Enter [5] - Check opponent's stats\n\t" + "Enter [6] - QUIT Game");
					// Obtain user selection
				  int combatMenu = scan.nextInt(); 
				  // If user decides to attack aggressively
				  if (combatMenu == 1) { 
				  	int damageDealt = adventurer.attack(); // User's attack
				  	int damageTaken  = enemy.attack();     // Enemy's attack
				  	((Entity) enemy).setHealth(((Entity) enemy).getHealth() - damageDealt); 
				  	((Entity) adventurer).setHealth(((Entity) adventurer).getHealth() 
				  				- damageTaken); 
				  	if (((Entity) adventurer).isDead()) {
				  		System.out.println("\n\tLet's rest before moving on....\n\t" + 
				  				"We must replenish health..."); 
				  		((Entity) adventurer).setHealth(100);
				  	} else if (((Entity) enemy).isDead()) {
				  		System.out.println("\n*****  You slayed " + ((Enemy) enemy).getKind() 
				  					+ "! You recieved 50 health points. Nicely done.  *****");
				  		((Entity) adventurer).setHealth(((Entity) adventurer).getHealth() + 50); 
				  	} 
				  } else if (combatMenu == 2) { // Else if user decides to attack defensively
				  	int damageTaken  = enemy.attack(); // Enemies attack
				  	adventurer.defend(damageTaken); // Nerfed enemy damage
				  	int damageDealt = adventurer.attack(); // User's attack 
				  	enemy.defend(damageDealt); // Nerfed user attack
				  	if (((Entity) adventurer).isDead()) {
				  		System.out.println("\n\tLet's rest before moving on....\n\t" + 
				  				"We must replenish health..."); 
				  		((Entity) adventurer).setHealth(((Entity) adventurer).getHealth() + 100);
				  	} else if (((Entity) enemy).isDead()) {
				  		System.out.println("\n*****  You slayed " + ((Enemy) enemy).getKind() 
			  					+ "! You recieved 50 health points. Nicely done.  *****");
			  		((Entity) adventurer).setHealth(((Entity) adventurer).getHealth() + 50); 
				  	} 
				  } else if (combatMenu == 3) { // Else if user decides to QUIT
				  	System.out.println("\nYou cowardly run away from " + 
				  			((Enemy) enemy).getKind() + "... but saftly.");
				  	continue GAME;
				  } else  if (combatMenu == 4) {
				  	System.out.println(adventurer);
				  } else if (combatMenu == 5) {
				  	System.out.println(enemy);
				  } else if (combatMenu == 6) {
				  	System.out.println("THANK YOU FOR PLAYING");
				  	System.out.println("\n*****     End of program.     *****");
						scan.close();
				  	System.exit(0); // Exit program successfully
				  } else {
				  	System.out.println("\tInvalid input, try again.");
				  }
					
				} // End of menu selection

			} // End of program
		
	} // End of main method 

} // End of class MainGame


