package p5;

/** 
 * Klassen skapar ett objekt som representerar en tärningsspelare 
 * OrdinaryPlayer ärver den abstrakta klassen Player.
 * @author Linus Forsberg
 */
public class OrdinaryPlayer extends Player {

	private Dice dice;
	
	/**
	 * Kontstruktorn skapar en spelare 
	 * @param name Namnet på spelaren
	 */
	public OrdinaryPlayer(String name) {
		super(name);
		this.dice = new SimpleDice();
	}
	
	/**
	 * Konstruktorn skapar en spelare
	 * @param dice Tärningen
	 * @param name Namnet på spelaren
	 */
	public OrdinaryPlayer(String name, Dice dice) {
		super(name);
		this.dice = dice;
	}
	
	/**
	 * @param dice Sätter värdet på dice objektet
	 */
	public void setDice(Dice dice) 	{
		this.dice = dice;
	}

	/**
	 * @return Returnerar värdet på dice objektet
	 */
	public Dice getDice() {
		return dice;
	}
	
	/**
	 * @return Returnerar tärningskast
	 */
	public int throwDice() {
		return dice.throwDice();
	}
}
