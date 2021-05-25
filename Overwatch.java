public class Overwatch {
	
	// Basic Overwatch hero attributes
	private String heroName;
	private int heroHealth;
	private int heroArmor;
	private int heroDamage;
	private int heroAmmo;

	// Overwatch hero constructor
	public Overwatch(String name, int health, int armor, int damage, int ammo) {

		heroName = name;
		heroHealth = health;
		heroArmor = armor;
		heroDamage = damage;
		heroAmmo = ammo;

	}

	// Combat simulator, no reloads, no headshots, maximum damage assumed
	// Shotgun-style and over-time attack calculations are not accurate against armor
	public static void oneClipSimulator(Overwatch attackingHero, Overwatch defendingHero) {

		// Assign instance variables to new ones for manipulation
		double remainingArmor = (double) defendingHero.heroArmor;
		int remainingHealth = defendingHero.heroHealth;
		int attackDamage = attackingHero.heroDamage;
		int remainingAmmo = attackingHero.heroAmmo;
        
        // Print basic stats
        System.out.println(attackingHero.heroName + ": " + attackDamage + " damage per shot, " + remainingAmmo + " shots per clip");
        System.out.println(defendingHero.heroName + ": " + (remainingArmor + remainingHealth) + " Total Health (" + remainingHealth + " Base + " + remainingArmor + " Armor)");
        System.out.println();
        
        System.out.println((remainingArmor + (double) remainingHealth) + " - Start");
        
		// Account for armor damage reduction
		while (remainingArmor > 0 && remainingAmmo > 0) {

			// If incoming damage is less than 10, hero takes half damage
			if (attackingHero.heroDamage < 10) {

				remainingAmmo--;
				remainingArmor -= (double) attackDamage / 2;
				
			// If incoming damage is greater than 10, hero takes 5 less damage
			} else {

				remainingAmmo--;
				remainingArmor -= (attackDamage - 5);

			}
			
			System.out.println((remainingArmor + (double) remainingHealth) + " - Shot " + (attackingHero.heroAmmo - remainingAmmo));
			if (remainingAmmo <= 0) {
				    
				System.out.println("\n" + attackingHero.heroName + " could not kill " + defendingHero.heroName + " with a single clip.\nTotal damage dealt: " + (defendingHero.heroArmor - remainingArmor));
				    
			}
		}

		// Extra damage done to armor is carried over to base health
		remainingHealth += remainingArmor;
		if (defendingHero.heroArmor != 0) {
		    
		    System.out.println("Armor depleted");
		    
		}

		// Base health is straightforward, damage value equals health lost
		while (remainingHealth > 0 && remainingAmmo > 0) {

			remainingAmmo--;
			remainingHealth -= attackDamage;
			if (remainingHealth <= 0) {
				
				// Hero is dead, health is 0
				System.out.println("Dead - Shot " + (attackingHero.heroAmmo - remainingAmmo));
				System.out.println();
				System.out.println(attackingHero.heroName + " killed " + defendingHero.heroName + " in " + (attackingHero.heroAmmo - remainingAmmo) + " shots.");

			} else {
				
				System.out.println((double) remainingHealth + " - Shot " + (attackingHero.heroAmmo - remainingAmmo));
				if (remainingAmmo <= 0) {
				    
				    System.out.println("\n" + attackingHero.heroName + " could not kill " + defendingHero.heroName + " with a single clip.\nTotal damage dealt: " + (defendingHero.heroHealth - remainingHealth + defendingHero.heroArmor));
				    
				}

			}

		}
	}

	public static void main(String[] args) {
        
        // All Overwatch Heroes. Do not pass DEFENSE ONLY heroes in as attacking hero.
        // Their primary fire does not have ammo, but rather does continuous damage.
        // INACCURATE heroes have shotgun-style or over-time damage, resulting in wrong calculations.
        
		Overwatch dva = new Overwatch("D.Va", 300, 300, 22, 99999); // INACCURATE
		Overwatch orisa = new Overwatch("Orisa", 200, 250, 11, 75);
		Overwatch reinhardt = new Overwatch("Reinhardt", 300, 200, 85, 99999);
		Overwatch roadhog = new Overwatch("Roadhog", 600, 0, 165, 5); // INACCURATE
		Overwatch sigma = new Overwatch("Sigma", 300, 100, 55, 99999);
		Overwatch winston = new Overwatch("Winston", 350, 150, 0, 0); // DEFENSE ONLY
		Overwatch wreckingball = new Overwatch("Wrecking Ball", 500, 100, 5, 80);
		Overwatch zarya = new Overwatch("Zarya", 400, 0, 0, 0); // DEFENSE ONLY
		Overwatch ashe = new Overwatch("Ashe", 200, 0, 75, 12);
		Overwatch bastion = new Overwatch("Bastion", 200, 100, 20, 35);
		Overwatch doomfist = new Overwatch("Doomfist", 250, 0, 66, 4); // INACCURATE
		Overwatch echo = new Overwatch("Echo", 200, 0, 51, 12); // INACCURATE
		Overwatch genji = new Overwatch("Genji", 200, 0, 28, 30);
		Overwatch hanzo = new Overwatch("Hanzo", 200, 0, 125, 99999);
		Overwatch junkrat = new Overwatch("Junkrat", 200, 0, 120, 5);
		Overwatch mccree = new Overwatch("McCree", 225, 0, 70, 6);
		Overwatch mei = new Overwatch("Mei", 250, 0, 75, 12);
		Overwatch pharah = new Overwatch("Pharah", 200, 0, 120, 6);
		Overwatch reaper = new Overwatch("Reaper", 250, 0, 120, 8); // INACCURATE
		Overwatch soldier76 = new Overwatch("Soldier: 76", 200, 0, 19, 30);
		Overwatch sombra = new Overwatch("Sombra", 200, 0, 8, 60);
		Overwatch symmetra = new Overwatch("Symmetra", 225, 0, 0, 0); // DEFENSE ONLY
		Overwatch torbjorn = new Overwatch("Torbjörn", 200, 50, 70, 18);
		Overwatch tracer = new Overwatch("Tracer", 150, 0, 6, 40);
		Overwatch widowmaker = new Overwatch("Widowmaker", 175, 0, 120, 7);
		Overwatch ana = new Overwatch("Ana", 200, 0, 70, 12); // INACCURATE
		Overwatch baptiste = new Overwatch("Baptiste", 200, 0, 24, 45);
		Overwatch brigitte = new Overwatch("Brigitte", 150, 50, 35, 99999);
		Overwatch lucio = new Overwatch("Lúcio", 200, 0, 20, 20);
		Overwatch mercy = new Overwatch("Mercy", 200, 0, 20, 20);
		Overwatch moira = new Overwatch("Moira", 200, 0, 0, 0); // DEFENSE ONLY
		Overwatch zenyatta = new Overwatch("Zenyatta", 200, 0, 48, 20);
		
		oneClipSimulator(genji, winston);
	}
}
