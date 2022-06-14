
// Adventurer.java
// Class Adventurer is used to create an Adventurer object for the user to play 
// as.

// Import declarations
import java.security.SecureRandom;

// Class Adventurer begin
public final class Adventurer extends Entity {

	// Adventurer state
	private int    type;   // Type
	private String name;  // Name
	private int    armor; // Armor
	
	// Constructor
	public Adventurer(int type, String name, int health, int maxHit, int armor) 
			throws IllegalArgumentException { 
		
		super(health, maxHit);
		if (type < 1 || type > 3) {
			throw new IllegalArgumentException("Type is out of range");
		} else {
			this.type = type;
		};
		if (name == "") {
			throw new IllegalArgumentException("Name cannot be blank");
		} else {
			this.name = name;
		};
		
		if (armor < 1) {
			throw new IllegalArgumentException("Armor cannot be less than 1");
		} else {
			this.armor = armor;
		}
	}
	
	// Method declarations
	public String getType() { // Method retrieves Entity's description
		String t = null;
		if (type == 1) {
			t = "Berserker";
		} else if (type == 2) {
			t = "Ranger";
		} if (type == 3) {
			t = "Mager";
		}
		return t;
	}
	
	public String getName() { // Method retrieves name
		return name;
	}
	
	public int getArmor() { // Method retrieves armor
		return armor;
	}
	
	public void setArmor(int armor) { // Method sets armor
		if (armor < 1) {
			System.out.println("Uh-Oh! Your armor has broken.");
			this.armor = 0;
		} else {
			this.armor = armor;
		}
	}
	
	@Override
	public int attack() { // Method randomly generates attack damage 
		SecureRandom random = new SecureRandom();
		int damageDealt = random.nextInt(this.getMaxHit());
		System.out.println("*You dealt " + damageDealt + " damage!*");
		return damageDealt;
	}

	@Override
	public void defend(int damage) {
		if (this.getArmor() > 0) {
			this.setArmor(this.getArmor() - 1);
			System.out.println("\t*NO DAMAGE* Phew! What a block!!\n\t" + 
			this.getArmor() + " armor left.\n");
		} else if ((this.getArmor() < 1) && (this.getHealth() - (damage/2)) > 1) {
			System.out.println("\t\nYour armour is too weak, couldn't completely block!" 
					+ " \nand took " + (damage/2) + " damage!\n");
			this.setHealth(this.getHealth() - (damage/2));
		} else if ((this.getArmor() < 1) && ((this.getHealth() - (damage/2)) < 1)) {
			System.out.println("\nYou fought a courageous fight...\n");
		  this.setHealth(0);
		}
	}

	@Override 
	public String toString() {
		return String.format("%n%s%n%s : %s%n%s : %s%s%s : %s%n", 
				"Player Stats\n************", "Type", getType(), "Name", getName(), 
				super.toString(), "Armor", getArmor());
	}
	
} // End of class Adventurer
