package p3;

import javax.swing.*;

// Lösning inlämningsupgift P3
// Inlämnad av Linus Forsberg 26/10-2016

// Den här klassen startar spelet

public class SSPApp {

	// Rolfs Main-metod som startar spelet

	public static void main( String[] args ) {
		SSPPlayer player = new SSPPlayer();
		SSPViewer viewer = new SSPViewer();
		SSPController controller = new SSPController(player, viewer); 
		SSPUserInput userInput = new SSPUserInput(controller);
		JFrame frame1 = new JFrame( "SSPViewer" ); 
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		frame1.add( viewer );
		frame1.pack();
		frame1.setLocation(500, 140);
		frame1.setVisible( true );
		JFrame frame2 = new JFrame( "SSPUserInput" ); 
		frame2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		frame2.add( userInput );
		frame2.pack();
		frame2.setLocation(500, 300);
		frame2.setVisible( true ); 
	}
}
