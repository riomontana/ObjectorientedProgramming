package laboration3;

import javax.swing.JOptionPane;

public class Program3a {
	 public void nameInfo1() {
	        String name, upperCase, lowerCase, res="";
	        int count;
	        char firstLetter;

	        name = JOptionPane.showInputDialog("Mata in ditt förnamn");
	        count = name.length();  // length() => antal tecken i String-objektet
	        upperCase = name.toUpperCase();  // toUpperCase => nytt String-objekt
	        lowerCase = name.toLowerCase();  // toLowerCase => nytt String-objekt
	        firstLetter = name.charAt(0);  // charAt(index) => returnerar tecken i visst index

	        res += "Du heter " + name + "\n" 
	        		+ "ditt namn innehåller: " + count + " bokstäver" + "\n" 
	        		+ "ditt namn med stora bokstäver: " + upperCase + "\n"
	        		+ "ditt namn med små bokstäver: " + lowerCase + "\n"
	        		+ "första bokstaven i ditt namn är: " + firstLetter;
	        
	        JOptionPane.showMessageDialog(null, res);
	    }

	    public static void main(String[] args) {
	        Program3a sp = new Program3a();
	        sp.nameInfo1();
	    }
	}


