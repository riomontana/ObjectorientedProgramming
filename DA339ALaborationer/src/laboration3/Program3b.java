package laboration3;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Program3b {
	public void date() {
		 int dayOfMonth, dayOfYear, month, year;
	        String res = "";
	        Calendar cal = Calendar.getInstance();
	        
	        dayOfMonth = cal.get( Calendar.DAY_OF_MONTH );
	        month = cal.get( Calendar.MONTH ) + 1;  // Månadsnummer 0-11
	        year = cal.get( Calendar.YEAR );
	        
	        res += "Dagens datum: " + dayOfMonth +"/" + month + "/" +  year;
	        JOptionPane.showMessageDialog(null,res); // Visa sträng i en dialog
	    }
	

	public static void main(String[] args) {
		Program3b prog = new Program3b();
		prog.date();

	}
}