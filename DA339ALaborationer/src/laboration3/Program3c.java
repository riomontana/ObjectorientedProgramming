package laboration3;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Program3c {

	public void dateAndTime() {
		Calendar cal = Calendar.getInstance();
		String message = "Dagens datum: " + cal.get(Calendar.DAY_OF_MONTH) +
		"/" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR); message += "\n";
		message += "Klockan är " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		JOptionPane.showMessageDialog(null, message);
		}
		public static void main(String[] args) { Program3c prog = new Program3c(); prog.dateAndTime();
		// prog.time();
}
}