//-----------------------------------------------------------------------------------
// Programmet frågar efter användarens namn.
// Om namnet är max 5 tecken ges svaret: "XXX, ditt namn är kort och fint!"
// Om namnet är över 5 tecken ges svaret: "XXX, ditt namn är långt och svårstavat"
//-----------------------------------------------------------------------------------

package laboration4;

import javax.swing.JOptionPane; //importerar fönster

public class Program4d {  //klassens namn
	
	public void question() { // objektets namn
		String name = JOptionPane.showInputDialog("Mata in ditt förnamn");
		if(name.length()<=5) {
			JOptionPane.showMessageDialog(null, name + ", ditt namn är kort och fint!");
		}
		else {
			JOptionPane.showMessageDialog(null, name + ", ditt namn är långt och svårstavat!");
		
		}
	}
	
	public static void main(String[] args) {
		Program4d p4a = new Program4d();
		p4a.question();
		
	}

	
}
