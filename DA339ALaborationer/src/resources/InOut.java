package resources;

import javax.swing.JOptionPane;

public class InOut {
	public static double readDouble(String txt) {
		double value = 0;
		boolean inputOK = false; 
		do {
			try {
				value = Double.parseDouble(JOptionPane.showInputDialog( txt ) );
				inputOK = true;
			}
			catch( NumberFormatException ex1 ) {}
			catch( NullPointerException ex2 ) {}
		} while( inputOK == false );
		return value	;
	}
	public static double readDouble() {
		return readDouble("Mata in ett decimaltal");
	}

}
