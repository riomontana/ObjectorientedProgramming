//------------------------------------------------------
// Programmet frågar efter användarens ålder.
// Om svaret är under 18 ges svaret "du är ett barn"
// Om svaret är 18 eller mer ges svaret" du är vuxen"
//------------------------------------------------------

package laboration4;

import javax.swing.JOptionPane; //importerar fönster

public class Program4c {  //klassens namn
	
	// koden nedan ger ett fönster som har texten "Ange din ålder"
	// om svaret är under 18 ges svaret "du är ett barn"
	// om svaret är 18 eller mer ges svaret" du är vuxen"
	
	public void question() { // objektets namn
		int age;
		
		age = Integer.parseInt(JOptionPane.showInputDialog("Hur gammal är du?"));
		if (age<18) {
			JOptionPane.showInputDialog("Du är ett barn"); }
			else { JOptionPane.showInputDialog("Du är vuxen");
		}
	}
	
	public static void main(String[] args) {
		Program4c p4a = new Program4c();
		p4a.question();
		
	}

	
}
