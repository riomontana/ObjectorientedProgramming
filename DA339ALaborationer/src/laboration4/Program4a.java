//------------------------------------------------------
// Programmet frågar efter ett heltal.
// Skrivs ett heltal över 100 in, ges meddelande:
// "Talet är större än 100"
//------------------------------------------------------

package laboration4;

import javax.swing.JOptionPane; //importerar fönster

public class Program4a {  //klassens namn
	
	public void question() { // objektets namn
		int number;
		
		// koden nedan ger ett fönster som har texten "skriv in ett heltal"
		// skrivs ett helttal över 100 in ges texten:
		// "talet är större än 100"
		
		number = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett heltal:"));
		if (number>100) {
			JOptionPane.showInputDialog("Talet är större än 100");
		}
	}
	
	public static void main(String[] args) {
		Program4a p4a = new Program4a();
		p4a.question();
		
	}

	
}
