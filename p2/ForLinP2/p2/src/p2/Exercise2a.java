package p2;

import javax.swing.JOptionPane;

public class Exercise2a {

	public void demo() {
		Painting p1 = new Painting("Mona Lisa", "Leonardo da Vinci", 1507); 
		Painting p2 = new Painting("Guernica", "Pablo Picasso", 1937);
		JOptionPane.showMessageDialog(null, p1.getTitle() +
				" målad av den enastående konstnären " + p1.getPainter() + ", färdigställd " + p1.getYear());
		JOptionPane.showMessageDialog(null, p2.toString()); 

	}


 class Painting {

	private String title;
	private String painter;
	private int year;
	
	public Painting( String title, String painter, int year ) {
		this.title = title;
		this.painter = painter;
		this.year = year;
	}
	
	public void setTitle( String title ) {
		this.title = title;
	}
	
	public String getTitle() {
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
	
	public String toString() {
		return this.title + " av " + this.painter +", " + this.year;
	}
	
}


	public static void main(String[] args) {
		Exercise2a prog = new Exercise2a(); 
		prog.demo();

	} 
}



