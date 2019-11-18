package gruppuppgift4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import p6.Color;
import p6.ColorDisplay;

public class ScrollWindow extends JFrame {

	private JPanel pnlMain =  new JPanel();
	private JPanel pnlBoard = new JPanel(new GridLayout(1, 1));
	private JButton jbLeft = new JButton("<--Vänster--");
	private Array7x7 array7x7 = new Array7x7(Chars.A);
	private Array7 array7 = new Array7();
	private ColorDisplay colorDisplay = new ColorDisplay(1, 1, Color.WHITE, Color.BLACK, 2, 5);

	/**
	 * Konstruktor, öppnar fönstret och sätter ut alla objekten
	 */
	public ScrollWindow() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension (1000,1000));

		pnlBoard.add(colorDisplay);

		add(pnlBoard, BorderLayout.CENTER);

		pnlMain.add(jbLeft);
		add(pnlMain, BorderLayout.NORTH);
		jbLeft.addActionListener(new Listener());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		updateDisplay();
	}

	/**
	 * Uppdaterar displayen med de senaste värdena från Array7x7-objektet
	 */
	public void updateDisplay() {
		int [][] tempArray = new int [7][7];

		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 7; col++) {
				tempArray[row][col]=array7x7.getElement(row, col);
			}
		}
		colorDisplay.setDisplay(tempArray, 0, 0);
		colorDisplay.updateDisplay();
	}
	
	/**
	 * Klass som lyssnar efter knapptryck
	 * 
	 * @author Maximilian Falkenström och Jimmy Åkesson
	 *
	 */
	public class Listener implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			if(a.getSource()==jbLeft){
				array7x7.shiftLeft(array7);
				updateDisplay();
			}
		}
	}


	public static void main (String[] args){
		ScrollWindow exe = new ScrollWindow();

	}
}


