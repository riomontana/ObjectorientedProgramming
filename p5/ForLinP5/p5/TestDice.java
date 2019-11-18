package p5;

/**
 * Klass som tar reda på om en tärning eller en spelare fuskar eller inte.
 * Klassen innehåller två metoder. Den första metoden jämför tärningsobjekt. 
 * Den andra metoden jämför player-objekt.	
 * @author Linus Forsberg
 */
public class TestDice {

	/**
	 * Metoden tar reda på om en tärning är en korrekt tärning eller en fusktärning.
	 * tar reda på hur många gånger tärningen landar på en viss sida och skriver ut resultatet
	 * @param dice Beskriver en tärning
	 * @param nbrOfThrows Beskriver ett tärningskast
	 */ 
	public static void test(Dice dice, int nbrOfThrows) {	
		int[] res = new int[ dice.getSides() ]; //lagrar antalet sidor i tärningen i en array

		for(int i = 0; i < nbrOfThrows; i++) { // tar reda på hur många prickar senaste kastet hade och lagrar resultatet i rätt räknare
			res[dice.throwDice()-1]++;
		}
		for(int i = 0; i < dice.getSides(); i++) {
			TextWindow.println(res[i]); // skriver ut resultatet i TextWindow
		}
	}

	/**
	 * Metod som tar reda på om en Player ger korrekta resultat vid anrop till spelarens throwDice-metod.
	 * @param player Beskriver en tärningsspelare
	 * @param nbrOfThrows Tärningskast
	 */
	public static void test( Player player, int nbrOfThrows ) {

		if(player instanceof OrdinaryPlayer) {  // kontrollerar om Player-objektet är OrdinaryPlayer med "instanceof"
			OrdinaryPlayer ordinaryPlayer = (OrdinaryPlayer) player; // Typkonverterar Player-objektet till referens till OrdinaryPlayer
			Dice dice = ordinaryPlayer.getDice(); // erhåller referens till tärningsobjektet genom att anropa metoden getDice
			dice.getSides(); // använder Dice-referensen till anrop av getSides-metoden.
			int[] res = new int[ dice.getSides() ]; //lagrar antalet sidor i tärningen i en array

			for(int i = 0; i < nbrOfThrows; i++) { // tar reda på hur många prickar senaste kastet hade och lagrar resultatet i rätt räknare
				res[player.throwDice()-1]++;
			}
			for(int i = 0; i < dice.getSides(); i++) {
				TextWindow.println(res[i]); // skriver ut resultatet i TextWindow
			}
		}
		else if(player instanceof Cheater) { // kontrollerar om Player-objektet är Cheater med "instanceof"
			Cheater cheater = (Cheater) player; // Typkonverterar Player-objektet till referens till Cheater
			Dice dice = cheater.getDice(); // erhåller referens till tärningsobjektet genom att anropa metoden getDice
			dice.getSides(); //använder Dice-referensen till anrop av getSides-metoden.
			int[] res = new int[ dice.getSides() ]; //lagrar antalet sidor i tärningen i en array

			for(int i = 0; i < nbrOfThrows; i++) { // tar reda på hur många prickar senaste kastet hade och lagrar resultatet i rätt räknare
				res[cheater.throwDice()-1]++;
			}
			for(int i = 0; i < dice.getSides(); i++) {
				TextWindow.println(res[i]);  // skriver ut resultatet i TextWindow
			}
		}
	}
}
