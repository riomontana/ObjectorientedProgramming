//************************************************************************
// Programmet skriver ut det heltal som är störst av två inmatade heltal *
//************************************************************************

package laboration4;

import javax.swing.*; 

public class Program4f {
	public void brolo() {
		int nbr1, nbr2, bigNbr;
		
		nbr1 = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));
		nbr2 = Integer.parseInt(JOptionPane.showInputDialog("Mata in ett heltal"));
		
		if(nbr1 > nbr2) {
			bigNbr = nbr1;
				}
		else {
			bigNbr = nbr2;
		}
		JOptionPane.showMessageDialog(null, bigNbr + " är störst");
	}
	
	public static void main(String[] args) {
		Program4f p4f = new Program4f();
		p4f.brolo();
	}

}
