package laboration3;

import javax.swing.JOptionPane;


public class Program3i {
	public void action() {
		String name, firstName, lastName, initials, message;
		int whiteSpace;
		name = JOptionPane.showInputDialog("mata in förnamn och efternamn");
		whiteSpace = name.indexOf(' ');
		firstName = name.substring(0,whiteSpace);
		lastName = name.substring(whiteSpace+1);
		initials = "" + name.charAt(0) + name.charAt(whiteSpace+1);
		message = "Ditt namn: " + name + "\n" +
				  "Ditt förnamn: " + firstName + "\n" + 
				  "Ditt efternamn: " + lastName + "\n" + 
				  "Dina initialer är: " + initials;
		
		JOptionPane.showInputDialog(null, message);
	}
	public static void main(String[] args) {
		Program3i prog = new Program3i();
		prog.action();
		
	}

}
