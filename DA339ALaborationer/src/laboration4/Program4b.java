//------------------------------------------------------
// Programmet frågar efter ett heltal 
// Skrivs ett heltal över 100 in, ges meddelande:
// "Talet är större än 100"
// Skrivs ett heltal under 100 in, ges meddelande:
// "Talet är högst 100"
//------------------------------------------------------

package laboration4;

import javax.swing.JOptionPane; //importerar fönster

public class Program4b {  //klassens namn
	
	// koden nedan ger ett fönster som har texten "skriv in ett heltal"
	// skrivs ett helttal över 100 in ges texten:
	// "talet är större än 100"
	// Skrivs ett heltal under 100 in, ges meddelande:
	// "Talet är högst 100"
	
	public void question() { // objektets namn
		int number;
		
		number = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ett heltal:"));
		if (number>100) {
			JOptionPane.showInputDialog("Talet är större än 100"); }
			else { JOptionPane.showInputDialog("Talet är högst 100");
		}
	}
	
	public static void main(String[] args) {
		Program4b p4a = new Program4b();
		p4a.question();
		
	}

	
}
