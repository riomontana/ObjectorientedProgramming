package gruppuppgift4;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import p6.Color;
import p6.ColorDisplay;

/**
 * Klass för att visa scrollande text. Texten anger man i en inmatningsruta.
 * @author Maximilian Falkenström och Linus Forsberg
 *
 */
public class TheWindow extends JFrame {
	private JPanel pnlMain = new JPanel();
	private ColorDisplay colorDisplay = new ColorDisplay(1, 5, Color.WHITE, Color.BLACK, 2, 5);
	private String message = "";
	private int messageLength = 0;
	private Array7x7[] messageLetterArray;
	private int[][] messageArray;
	private Timer timer;
	
	/**
	 * Konstruktorn som startar upp fönstret, ber om inmatning och visar den inmatade texten scrollande i ett annat fönster
	 */
	public TheWindow() {
		pnlMain.setLayout(new GridLayout(1, 1));
		pnlMain.setPreferredSize(new Dimension(1000, 500));
		
		pnlMain.add(colorDisplay);
		add(pnlMain);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(false);
		
		getMessage();
		
		setVisible(true);
		
		updateDisplay();
		useTimer();
	}
	
	/**
	 * Metod för att visa inmatningsfönster och sätta in värdena i en Array7x7-array
	 */
	public void getMessage() {
 		message = JOptionPane.showInputDialog("Skriv in ett meddelande").toLowerCase();
 		message += " ";
		messageLength = message.length();
		
		if(messageLength >= 5) {
			messageLetterArray = new Array7x7[messageLength];
			for(int i = 0; i < messageLength; i++) {
				messageLetterArray[i] = Array7x7.getChar(message.charAt(i));
			}
		}
		else {
			messageLetterArray = new Array7x7[5];
			for(int i = 0; i < 5; i++) {
				if(i < messageLength) {
					messageLetterArray[i] = Array7x7.getChar(message.charAt(i));
				}
				else {
					messageLetterArray[i] = new Array7x7(Chars.EMPTY);
				}
			}
		}
	}
	
	/**
	 * Metod som flyttar texten ett steg åt vänster och uppdaterar displayen
	 */
	public void updateDisplay() {
		int lastElem = 5;
		
		// Variabel för att spara den kolumn som ska flyttas från första till sista platsen i fönstret
		Array7 shiftRes = new Array7();
		
		// Om det finns mer än 5 bokstäver i meddelandet blir det sista elementet den sista bokstaven
		if(messageLength > 5) {
			lastElem = messageLength;
		}
		
		// Array för att hålla de int-värden med färgvärden man skickar till ColorDisplay
		int[][][] letter = new int[lastElem][7][7];
		
		// Itererar över alla bokstäver
		for(int nbr = 0; nbr < lastElem; nbr++) {
			
			// Itererar över alla punkter i Array7x7-objektet och sparar innehållet till letter-arrayen
			for(int row = 0; row < 7; row++) {
				for(int col = 0; col < 7; col++) {
					letter[nbr][row][col] = messageLetterArray[nbr].getElement(row, col);
				}
			}
			
			// Om man är på en av de första 5 bokstavsplatserna i arrayen (de som får plats i fönstret)
			// så ska man uppdatera displayen med de nya värdena.
			if(nbr < 5) {
				colorDisplay.setDisplay(letter[nbr], 0, nbr);
				colorDisplay.updateDisplay();
			}
			
			// Körs om bokstavsplatsen man är på är mindre än den sista platsen
			if(nbr < lastElem - 1) {
				
				// Om man är på den första bokstavsplatsen ska värdena från den första kolumnen sparas till shiftRes-variabeln
				// och värdena från den andra kolumnen ska flyttas till den första kolumnen
				if(nbr == 0) {
					shiftRes = messageLetterArray[nbr].shiftLeft(messageLetterArray[nbr + 1].getCol(0));
				}
				// Om man inte är på den första bokstavsplatsen ska man flytta värdena från kolumnen till höger om den man
				// är på till den man är på
				else {
					messageLetterArray[nbr].shiftLeft(messageLetterArray[nbr+1].getCol(0));
				}
			}
			else {
				// Om man är på den sista bokstavsplatsen skall alla kolumner flyttas ett steg åt vänster och alla värden
				// från shiftRes-variabeln ska flyttas in i den sista kolumnen
				messageLetterArray[nbr].shiftLeft(shiftRes);
			}
		}
	}
	
	/**
	 * Startar en timerinstans som återupprepar förflyttningen åt vänster
	 */
	public void useTimer() {
		timer = new Timer();
		timer.schedule(new MoveChars(), 150, 150);
	}
	
	/**
	 * Inre klass för att utföra uppgifter i ett visst timerintervall
	 * @author Linus Forsberg och Maximilian Falkenström
	 *
	 */
	private class MoveChars extends TimerTask {
		/**
		 * Anger vad som ska hända i timer-intervallet
		 */
		public void run() {
			updateDisplay();
		}
	}
	
	
	/**
	 * Main-klass för att instansiera fönstret
	 * @param args
	 */
	public static void main(String[] args) {
		TheWindow window = new TheWindow();
	}
}
