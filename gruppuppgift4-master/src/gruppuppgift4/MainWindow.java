package gruppuppgift4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sun.applet.Main;

/**
 * Klass för testfönstret i uppgift 4.2
 * @author Maximilian Falkenström
 *
 */
public class MainWindow extends JFrame {
	private JPanel pnlMain = new JPanel();
	private JPanel pnlGrid = new JPanel();
	private JPanel pnlArrayHorizontal = new JPanel();
	private JPanel pnlArrayVertical = new JPanel();
	private JPanel pnlRight = new JPanel();
	private JTextField[] tfArrayHorizontal = new JTextField[7];
	private JTextField[] tfArrayVertical = new JTextField[7];
	private JLabel[][] lblGrid = new JLabel[7][7];
	private JButton btnReadRow = new JButton("Läs rad");
	private JButton btnWriteRow = new JButton("Skriv rad");
	private JButton btnReadCol = new JButton("Läs kol");
	private JButton btnWriteCol = new JButton("Skriv kol");
	private JTextField tfInputRow = new JTextField("Input rad nr");
	private JTextField tfInputCol = new JTextField("Input kol nr");
	private ButtonListener buttonListener = new ButtonListener(this);
	private Array7x7 array = new Array7x7();
	private Array7 leftArray = new Array7();
	private Array7 bottomArray = new Array7();
	
	/**
	 * Skapar fönstret, sätter ut knappar, labels och textfält i fönstret
	 */
	public MainWindow() {
		setTitle("4.2.1");
		pnlGrid.setLayout(new GridLayout(7, 7));
		pnlGrid.setPreferredSize(new Dimension(400, 400));
		
		pnlArrayHorizontal.setLayout(new GridLayout(1, 7));
		pnlArrayHorizontal.setPreferredSize(new Dimension(400, 50));
		pnlArrayHorizontal.setBorder(new EmptyBorder(0, 48, 0, 97));
		
		pnlArrayVertical.setLayout(new GridLayout(7, 1));
		pnlArrayVertical.setPreferredSize(new Dimension(50, 400));
		
		pnlRight.setLayout(new GridLayout(6, 1));
		pnlRight.setPreferredSize(new Dimension(100, 400));
		
		pnlMain.setLayout(new BorderLayout());
		
		// Sätter ut alla JLabels i fönstret i ett 7x7-system
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				lblGrid[i][j] = new JLabel("0");
				pnlGrid.add(lblGrid[i][j]);
			}
		}
		
		// Sätter ut 7 textfields för att ändra värden horisontellt
		for(int i = 0; i < tfArrayHorizontal.length; i++) {
			tfArrayHorizontal[i] = new JTextField();
			pnlArrayHorizontal.add(tfArrayHorizontal[i]);
		}

		// Sätter ut 7 textfields för att ändra värden vertikalt
		for(int i = 0; i < tfArrayVertical.length; i++) {
			tfArrayVertical[i] = new JTextField();
			pnlArrayVertical.add(tfArrayVertical[i]);
		}
		
		btnReadRow.addActionListener(buttonListener);
		btnWriteRow.addActionListener(buttonListener);
		btnReadCol.addActionListener(buttonListener);
		btnWriteCol.addActionListener(buttonListener);
		
		pnlRight.add(btnReadRow);
		pnlRight.add(btnWriteRow);
		pnlRight.add(tfInputRow);
		pnlRight.add(btnReadCol);
		pnlRight.add(btnWriteCol);
		pnlRight.add(tfInputCol);
		
		pnlMain.add(pnlGrid, BorderLayout.CENTER);
		pnlMain.add(pnlArrayVertical, BorderLayout.WEST);
		pnlMain.add(pnlArrayHorizontal, BorderLayout.SOUTH);
		pnlMain.add(pnlRight, BorderLayout.EAST);
		
		setLayout(new GridLayout(1, 1));
		add(pnlMain);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Metod som läser av en rad i rutnätet med labels och sätter in värdena i textfälten i botten av fönstret
	 * @param row - Numret på den rad i rutnätet man vill flytta till textfälten
	 */
	public void readRow(int row) {
		Array7 rowArray = array.getRow(row);
		
		for(int i = 0; i < 7; i++) {
			System.out.println(rowArray.getElement(i));
			tfArrayHorizontal[i].setText(String.valueOf(rowArray.getElement(i)));
		}
	}
	
	/**
	 * Skriver värdena från raden med textfält i botten av fönstret till angiven rad i rutnätet
	 * @param row - Numret på den rad i rutnätet man vill sätta in värdena i
	 */
	public void writeRow(int row) {
		Array7 rowArray = new Array7();
		
		for(int i = 0; i < 7; i++) {
			rowArray.setElement(i, Integer.parseInt(tfArrayHorizontal[i].getText()));
			lblGrid[row][i].setText(String.valueOf(rowArray.getElement(i)));
		}
		
		array.setRow(row, rowArray);
	}
	
	/**
	 * Metod som läser av en kolumn i rutnätet med labels och sätter in värdena i textfälten till vänster i fönstret
	 * @param col - Numret på den kolumn i rutnätet man vill flytta till textfälten
	 */
	public void readCol(int col) {
		Array7 colArray = array.getCol(col);
		
		for(int i = 0; i < 7; i++) {
			tfArrayVertical[i].setText(String.valueOf(colArray.getElement(i)));
		}
	}
	
	/**
	 * Skriver värdena från kolumnen med textfält till vänster i fönstret till angiven kolumn i rutnätet
	 * @param col - Numret på den kolumn i rutnätet man vill sätta in värdena i
	 */
	public void writeCol(int col) {
		Array7 rowArray = new Array7();
		
		for(int i = 0; i < 7; i++) {
			rowArray.setElement(i, Integer.parseInt(tfArrayVertical[i].getText()));
			lblGrid[i][col].setText(String.valueOf(rowArray.getElement(i)));
		}
		
		array.setCol(col, rowArray);
	}
	
	/**
	 * Lyssnarklass för de olika knapparna i fönstret
	 * @author Maximilian Falkenström
	 *
	 */
	public class ButtonListener implements ActionListener {
		MainWindow window;
		
		/**
		 * Tar emot fönster-instansen som parameter och sparar den som en instansvariabel i den här inre klassen
		 * @param window
		 */
		public ButtonListener(MainWindow window) {
			super();
			this.window = window;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnReadRow) {
				window.readRow(Integer.parseInt(tfInputRow.getText()));
			} else if(e.getSource() == btnWriteRow) {
				window.writeRow(Integer.parseInt(tfInputRow.getText()));
			} else if(e.getSource() == btnReadCol) {
				window.readCol(Integer.parseInt(tfInputCol.getText()));
			} else if(e.getSource() == btnWriteCol) {
				window.writeCol(Integer.parseInt(tfInputCol.getText()));
			}
		}
		
	}

	public static void main(String[] args) {
		MainWindow window = new MainWindow();
	}
}
