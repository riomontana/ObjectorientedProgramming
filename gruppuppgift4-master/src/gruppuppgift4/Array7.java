package gruppuppgift4;
import java.util.*;

/**
 * @author Ingela Persson
 * En klass som skapar en endimensionell array.
 */

public class Array7 {

	private int[] elements = { 0, 0, 0, 0, 0, 0, 0 };
	private  int pos;
	private int value;
	
	/**
	 * Konstruktor
	 * @param elements - Array med värden man vill sätta in i instansvariabeln
	 */
	public Array7(int[] elements) {
		this.elements = elements;
	}
	
	public Array7() {
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param pos - Den position man vill sätta in ett element på
	 * @param value - Det värde man vill sätta in på positionen
	 */
	public void setElement(int pos, int value){
		elements[pos] = value;		
	}
	
	/**
	 * 
	 * @param pos - Position för det element man vill hämta
	 * @return
	 */
	public int getElement(int pos){
		return elements[pos];
	}
}

		  
		
		
		
		
	
	
		
	

