package laboration2;

import javax.swing.*;

public class Program2i {
	public void hundredYears() {
		int year, age, hundred;
		String name;
		
		name = JOptionPane.showInputDialog( "Ange ditt namn" );
		age = Integer.parseInt( JOptionPane.showInputDialog( "Ange din ålder" ) );
		year = Integer.parseInt( JOptionPane.showInputDialog( "Ange nuvarande år" )
				);
		hundred = year+100-age;
		JOptionPane.showMessageDialog( null, name + ", år " + hundred + " fyller du 100 år" );	
	}
	public static void main( String[] args ) { Program2i p2i = new Program2i(); p2i.hundredYears();
	} }

