package gruppuppgift4;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

/**
 * En klass för att mata in variabler i en array och sedan flytta in den i en 2d array och flytta variablerna ett steg i 2d arrayn. 
 * @author Jimmy Åkesson
 * @author Olle Olsson
 */
public class TestWindow extends JFrame {

	private JPanel pnlLeft =  new JPanel(new GridLayout(7,1));
	private JPanel pnlRight = new JPanel(new GridLayout(7,1));
	private JPanel pnlSouth = new JPanel(new GridLayout(1,2));
	private JPanel pnlBoard = new JPanel(new GridLayout(7, 7));
	private JTextField[] tfLeft = new JTextField[7];
	private JTextField[] tfRight = new JTextField[7];
	private JTextField[][] tfBoard = new JTextField[7][7];
	private Font font = new Font("Helvetica", Font.BOLD, 30);
	private JButton btnLeft = new JButton("<--Flytta åt vänster--");
	private JButton btnRight = new JButton("--Flytta åt höger-->");

	private Array7x7 array7x7 = new Array7x7();
	private Array7 arrayLeft = new Array7();
	private Array7 arrayRight = new Array7();

	/**
	 * Konstruktor som skapar fönstret med TextFields och knappar.
	 */
	public TestWindow(){

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension (1000,1000));

		// Lägger till TextFields i center blocket.
		for (int x = 0; x < 7; x++) {
			for (int y = 0; y < 7; y++) {
				tfBoard[x][y] = new JTextField("0"); 
				tfBoard[x][y].setPreferredSize(new Dimension (150,150));
				tfBoard[x][y].setHorizontalAlignment(JTextField.CENTER);
				tfBoard[x][y].setFont(font);
				pnlBoard.add(tfBoard[x][y]);
			}
		}
		add(pnlBoard, BorderLayout.CENTER);

		// Lägger till vänster TextFields.
		for(int x=0; x < 7; x++){
			tfLeft[x] = new JTextField();
			tfLeft[x].setPreferredSize(new Dimension(150,150));
			tfLeft[x].setHorizontalAlignment(JTextField.CENTER);
			tfLeft[x].setFont(font);
			pnlLeft.add(tfLeft[x]);
		}
		add(pnlLeft, BorderLayout.WEST);

		// Lägger till höger TextFields.
		for(int x=0; x < 7; x++){
			tfRight[x] = new JTextField();
			tfRight[x].setPreferredSize(new Dimension(150,150));
			tfRight[x].setHorizontalAlignment(JTextField.CENTER);
			tfRight[x].setFont(font);
			pnlRight.add(tfRight[x]);

		}
		add(pnlRight, BorderLayout.EAST);

		btnLeft.setFont(font);
		btnRight.setFont(font);
		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);
		add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setPreferredSize(new Dimension (100,100));

		btnLeft.addActionListener(new Listener());
		btnRight.addActionListener(new Listener());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	/**
	 * Metod som flyttar in variablerna från vänster TextFields till ett Array7 objekt.
	 */
	public void setArrayLeft(){
		for (int row=0; row<tfLeft.length;row++){
			String number = tfLeft[row].getText();
			if(number==null){
				number="0";
			}else{
				try {
					arrayLeft.setElement(row, Integer.parseInt(number));
				}catch (NumberFormatException e) {

				}
			}System.out.println(arrayLeft.getElement(row));
		}
	}

	/**
	 * Metod som flyttar in variablerna från höger TextFields till ett Array7 objekt.
	 */
	public void setArrayRight(){
		for (int row = 0; row<tfRight.length; row++){
			String number = tfRight[row].getText();
			if(number==null){
				number="0";
			}else{
				try {
					arrayRight.setElement(row, Integer.parseInt(number));
				}catch (NumberFormatException e) {

				}
			}System.out.println(arrayRight.getElement(row));
		}
	}

	/**
	 * Metod som sätter variablerna i center TextFields till ett Array7x7 objekt.
	 */
	public void setArray2D(){
		for(int row=0; row<tfBoard.length;row++){
			for(int col=0;col<tfBoard[row].length;col++){
				String number=tfBoard[row][col].getText();
				if(number==null){
					number="0";
				}else{
					try{
						array7x7.setElement(row, col, Integer.parseInt(number));
					}catch (NumberFormatException e){
						
					}
				}
				System.out.print(array7x7.getElement(row,col));
			}
			System.out.println("");
		}
	}
	/**
	 * En inre klass för att sköta händelsehanteringen för knapparna i TestWindow.
	 * @author Jimmy Åkesson
	 * @author Olle Olsson
	 */
	public class Listener implements ActionListener{
		/**
		 * Metod som sköter händelsehanteringen för knapparna i TestWindow.
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnLeft){
				setArrayRight();
				for(int row=0; row < tfBoard.length; row++){
					for(int col=1; col<tfBoard.length; col++){
						String text=tfBoard[row][col].getText();
						tfBoard[row][col-1].setText(text);
					}
				}
				for(int row=0; row<tfRight.length; row++){
					String text = tfRight[row].getText();
					tfBoard[row][6].setText(text);
				}
				setArray2D();
			}
			
			if(e.getSource()==btnRight){
				setArrayLeft();
				for(int row = 0; row < tfBoard.length; row++){
					for (int col = tfBoard[row].length - 1; col > 0; col--){
						String text = tfBoard[row][col-1].getText(); 
						tfBoard[row][col].setText(text);
					}
				}
				for(int row = 0; row<tfLeft.length; row++) {
					String text = tfLeft[row].getText();
					tfBoard[row][0].setText(text);
				}
				setArray2D();
			}
		}
	}
	/**
	 * Main metod
	 * @param args
	 */
	public static void main (String[] args){
		TestWindow exe = new TestWindow();
	}
}

