package laboration2;

import javax.swing.*;

public class Program2b {
	public void example(){
		String message, name; 
		
		name = JOptionPane.showInputDialog("Ange ditt namn");
		message = "Hej " + name + "! Vilket fint namn!";
		JOptionPane.showMessageDialog( null, message );
		
	}
	
	public static void main(String[] args) {
		Program2b prog = new Program2b();
		prog.example();
	}
}
/*
public class Program2b {
    public void info() {
        // Hej mitt namn är Eskil
    	// Jag har skrivit 3 program i Java
    }
    {
    System.out.println("Hej mitt namn är Eskil");
    System.out.println("Jag har skrivit 3 program i Java");
    System.out.println("Det är KUL med java!!");
    
    }
    

    public static void main( String[] args ) {
        Program2b p2 = new Program2b();
        p2.info();
    }
}
*/