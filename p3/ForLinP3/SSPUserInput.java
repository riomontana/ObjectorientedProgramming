package p3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

//Lösning inlämningsupgift P3
//Inlämnad av Linus Forsberg 26/10-2016

// Klass för användarinterface. Låter användaren välja STEN/SAX/PÅSE, Nytt spel eller att Avsluta programmet.

public class SSPUserInput extends JPanel implements ActionListener { 
	// klassen ärver JPanel som används för att skapa fönstret och ActionListener som lyssnar på knapptryck från användaren.

	private JButton btnRock = new JButton("STEN"); // instansvariabler som beskriver knapparna i interfacet
	private JButton btnScissor = new JButton("SAX");
	private JButton btnPaper = new JButton("PÅSE");
	private JButton btnNewGame = new JButton("NYTT SPEL");
	private JButton btnExitGame = new JButton("AVSLUTA");
	private Font font = new Font("TimesNewRoman", Font.BOLD, 15); // teckensnitt som används interfacet
	private SSPController controller; // instansvariabel för controllerklassen som får information från denna klassen

	public SSPUserInput(SSPController controller) { // konstruktor för klassen
		this.controller = controller; // uppdaterar controllerklassen
		this.controller.setUserInput( this ); // skickar nuvarande userInput till setUserInput- metoden i controllerklassen

		setPreferredSize( new Dimension( 300 , 175 ) ); // fönsterstorlek

		btnRock.setPreferredSize(new Dimension(90, 50)); // anger utseende för knapparna i GUI
		btnRock.setFont(font);

		btnScissor.setPreferredSize(new Dimension(90, 50));
		btnScissor.setFont(font);

		btnPaper.setPreferredSize(new Dimension(90, 50));
		btnPaper.setFont(font);

		btnNewGame.setPreferredSize(new Dimension(280, 50));
		btnNewGame.setFont(font);

		btnExitGame.setPreferredSize(new Dimension(280, 50));
		btnExitGame.setFont(font);

		add(btnRock); // lägger till knappar
		add(btnScissor);
		add(btnPaper);
		add(btnNewGame);
		add(btnExitGame);

		btnScissor.addActionListener(this); // lägger till knapplyssnare
		btnRock.addActionListener(this);
		btnPaper.addActionListener(this);
		btnNewGame.addActionListener(this);
		btnExitGame.addActionListener(this);
	}

	public void actionPerformed( ActionEvent e ) { // denna metod används för att lyssna efter knapptryck från användaren
		if( e.getSource() == btnExitGame ) {
			System.exit(0);
		}

		else if( e.getSource() == btnRock) {
			controller.game(0);
		}

		else if( e.getSource() == btnScissor) {
			controller.game(1);
		}

		else if( e.getSource() == btnPaper) {
			controller.game(2);
		}

		else if( e.getSource() == btnNewGame) {
			controller.initGame();
		}

	}

	public void enableButtons() { // metoden gör knapparna sten/sax/påse klickbara
		btnRock.setEnabled( true );
		btnScissor.setEnabled( true );
		btnPaper.setEnabled( true );

	}

	public void disableButtons() { // metoden gör knapparna sten/sax/påse ej klickbara
		btnRock.setEnabled( false );
		btnScissor.setEnabled( false );
		btnPaper.setEnabled( false );
	}
}


