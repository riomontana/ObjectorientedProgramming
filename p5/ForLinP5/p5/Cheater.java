package p5;

/**
 *  Klassen representerar en fuskande tärningsspelare
 *  Cheater-objektet anger en prick för mycket vid ca hälften av kasten
 *  Om tärningen visar max antal prickar så låter Cheater bli att fuska.
 *  Cheater ärver den abstrakta klassen Player
 *  @author Linus Forsberg
 */
import java.util.Random;

public class Cheater extends Player {

	private Dice dice;
	
	/**
	 * Konstruktorn skapar ett objekt som beskriver en tärningsspelare 
	 * @param name Namnet på spelaren
	 */
	public Cheater(String name) {
		super(name);
		this.dice = new SimpleDice();
		}

	/**
	 * Skapar ett objekt som beskriver en tärningsspelare
	 * @param dice Tärningen
	 * @param name Namnet på spelaren
	 */
	public Cheater(String name, Dice dice) {
		super(name);
		this.dice = dice;
	}
	
	/**
	 * @param dice Sätter värdet på tärningsobjektet
	 */
	public void setDice(Dice dice) 	{
		this.dice = dice;
	}
	
	/**
	 * @return Returnerar värdet på tärningsobjektet
	 */
	public Dice getDice() {
		return dice;
	}
	
	/**
	 * Metoden returnerar fuskande tärningskast som 
	 * anger en prick för mycket vid ca hälften av kasten
	 * Om tärningen visar max antal prickar så låter Cheater bli att fuska
	 * @return Returnerar tärningskast
	 */
	public int throwDice() {
		Random rnd = new Random();
		int cheat = rnd.nextInt(2);
		int nbr = dice.throwDice();
		if (nbr < dice.getSides()) {
			
			if(cheat == 0) {
				nbr++;
			}
		}
		return nbr;
	}
}