package p5;

/** 
 * Klassen representerar en tärning med minst en sida
 * SimpleDice implementerar gränssnittet Dice
 * @author Linus Forsberg
 */
public class SimpleDice implements Dice {
	private int sides;

	/**
 	* Konstruktorn skapar en 6-sidig tärning
 	*/
	public SimpleDice() {
		this(6);
	}

	/**
	* Konstruktor som skapar en tärning med så många sidor som anges av argumentet.
	* @param sides Antal sidor på tärningen. Antalet sidor måste vara större än 0.
	* @throws NegativeSidesException Om värdet på <code>sides</code> är mindre eller
	* lika med 0
	*/
	public SimpleDice(int sides) {
		if(sides <= 0)
			throw new NegativeSidesException("Tärningen måste ha minst 1 sida");
		this.sides = sides;
	}

	 /**
     * Returnerar antalet sidor på tärningen
     * @return Antalet sidor på tärningen
     */
	public int getSides() {
		return sides;
	}
	
	/**
     * Returnerar resultatet av ett tärningskast.
     * @return Resultatet av tärningskastet
     */
	public int throwDice() {
		int lastResult = (int)(Math.random()*sides+1) % sides; 
		return lastResult+1; 								
	}
}
