
// Enemy.java
// Class Enemy is used to create a new Enemy for the user to fight against

// Import declarations
import java.security.SecureRandom;

// Class Enemy Adventure
public final class Enemy extends Entity {
	
  //Enemy state
	String kind; // Kind of creature

	//Constructor
	public Enemy(int health, int maxHit, String kind) 
			throws IllegalArgumentException {
		
		super(health, maxHit);
		this.kind = kind;
	}

	// Method declarations
	public String getKind() { // Method retrieves kind
		return kind;
	}
	
	@Override
	public int attack() {
		SecureRandom random = new SecureRandom();
		int damageDealt = random.nextInt(this.getMaxHit());
		System.out.println("*The enemy dealt " + damageDealt + " damage!*\n");
		return damageDealt;
	}

	@Override
	public void defend(int damage) {
		if ((this.getHealth() - (damage/2) < 1)) {
			this.setHealth(0);
			System.out.println("\n** You have slayed the enemey! **\n");
		} else if ((this.getHealth() - (damage/2)) > 1) {
			this.setHealth((this.getHealth() - (damage/2)));
			System.out.println("\n\t*ENEMY REDUCED DAMAGE*\n");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%n%s%n%s : %s%s", "Enemy Stats\n***********", 
				"Kind", getKind(), super.toString());
	}

} // End of class Enemy

