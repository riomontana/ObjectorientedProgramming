package p2;

/* Klassen inehåller lösningar på inlämningsuppgift 2a
 * @author Linus Forsberg den 13/10-2016
 * 
 * Klassen Painting är en modell av en målning. */

public class Painting {

	// klassens instansvariabler är titel, konstnären och året tavlan färdigställdes.
	
	private String title;
	private String painter;
	private int year;
		

	public Painting( String title, String painter, int year ) { // konstruktorn skapar en ny instans av objektet Painting.
		this.title = title;
		this.painter = painter;
		this.year = year;
	}
	
	public void setTitle( String title ) { // metoden anropas för att ändra instansvariabelns värde
		this.title = title;
	}
	
	public String getTitle() { // avläser instansvariabelns värde
		return this.title;
	}
	
	public void setPainter( String painter ) {
		this.painter = painter;
	}
	
	public String getPainter() {
		return this.painter;
	}
	
	public void setYear( int year ) {
		this.year = year;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String toString() { // metoden returnerar en sträng med titel, konstnär och året tavlan färdigställdes
		return this.title + " av " + this.painter +", " + this.year;
	}
	
}
