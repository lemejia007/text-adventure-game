
// Entity.java
// Abstract class Entity helps with the creation of either Hero or Enemy objects 

// Abstract class Entity begin
public abstract class Entity implements Combatable {
	
	// Object state
	private int     health; // Health
	private int     maxHit; // Max hit
	private boolean isDead; // Dead?
	
	// Constructor 
	public Entity(int health, int maxHit) 
			throws IllegalArgumentException {
		
		if (health < 1) {
			throw new IllegalArgumentException("Health cannot be less than 1");
		} else {
			this.health = health;
		}
		
		if (maxHit < 1) {
			throw new IllegalArgumentException("Max hit cannot be less than 1");
		} else {
			this.maxHit = maxHit;
		}
		
		this.isDead = false; // New Entity objects are created alive
		
	}
	
	// Method declarations
	public int getHealth() { // Method retrieves Entity's health
		return health;
	}
	
	public void setHealth(int health) { // Method sets Entity's health
		this.health = health;
		if (this.getHealth() < 1) {
			this.isDead = true; 
		}
	}
	
	public int getMaxHit() { // Method retrieves Entity's max hit
		return maxHit;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	@Override 
	public String toString() {
		return String.format("%n%s : %s %n%s : %s %n", "Health",getHealth(), 
																									 "Max Hit", getMaxHit());
	}

} // End of class Entity
