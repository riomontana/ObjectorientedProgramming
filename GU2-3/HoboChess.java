package newHoboChess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** En klass för spelbrädet*/
public class GUI extends JPanel implements ActionListener { 

	private JFrame window = new JFrame("LuffarSchack"); //instansvariabel
	private JPanel panel = new JPanel();
	private JLabel whoWon = new JLabel("3 i rad vinner!", JLabel.CENTER);
	private JButton newGame = new JButton("Nytt Spel");
	private JButton backToMenu = new JButton("Tillbaka till Menyn");
	private JButton btn1 = new JButton(""); 
	private JButton btn2 = new JButton("");
	private JButton btn3 = new JButton("");
	private JButton btn4 = new JButton("");
	private JButton btn5 = new JButton("");
	private JButton btn6 = new JButton("");
	private JButton btn7 = new JButton("");
	private JButton btn8 = new JButton("");
	private JButton btn9 = new JButton("");
	private Font bigFont = new Font("TimesNewRoman", Font.BOLD, 30);
	private String str = ""; // tom sträng som ska uppdateras med x eller o under spelets gång
	private int nbr = 0; // räknare som används för att avgöra om x eller o ska sättas
	private boolean win = false; // boolean för vinst sant eller falskt
	


	public GUI() { // konstruktor
	

		
		window.setSize(450,350); // storlek på fönster
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		window.setResizable(false);

		window.setLayout(new FlowLayout());

		window.add(newGame);
		window.add(backToMenu);

		backToMenu.setPreferredSize(new Dimension(150, 20));
		newGame.setPreferredSize(new Dimension(150, 20));
		whoWon.setFont(bigFont);
		whoWon.setPreferredSize(new Dimension(450, 50));

		window.add(panel);
		panel.setSize(450,300); // storlek på panelen
		panel.setLayout(new GridLayout(3,3));
	
		panel.add(btn1); // lägger till knappar 1-9
		btn1.setPreferredSize(new Dimension(100,80));

		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);

		window.add(whoWon);
		
		newGame.addActionListener(this);
		backToMenu.addActionListener(this);
		
		btn1.addActionListener(this); // lägger till actionlisteners till knapparna
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		
		window.setVisible(true); // gör fönster synligt
	}
	

	
	public void actionPerformed(ActionEvent e) { // knapplyssnare

		nbr++; // räknare 
		if(nbr == 1 || nbr == 3 || nbr == 5 || nbr == 7 || nbr == 9) { 
			str = "X";
		}
		else if(nbr == 2 || nbr == 4 || nbr == 6 || nbr == 8 || nbr == 10) {
			str = "O";
		}
		
		if(e.getSource() == btn1) {
			 btn1.setText(str);
			 btn1.setEnabled(false);
		}
		if(e.getSource() == btn2) {
			 btn2.setText(str);
			 btn2.setEnabled(false);
		}
		if(e.getSource() == btn3) {
			 btn3.setText(str);
			 btn3.setEnabled(false);
		}
		if(e.getSource() == btn4) {
			 btn4.setText(str);
			 btn4.setEnabled(false);
		}
		if(e.getSource() == btn5) {
			 btn5.setText(str);
			 btn5.setEnabled(false);
		}
		if(e.getSource() == btn6) {
			 btn6.setText(str);
			 btn6.setEnabled(false);
		}
		if(e.getSource() == btn7) {
			 btn7.setText(str);
			 btn7.setEnabled(false);
		}
		if(e.getSource() == btn8) {
			 btn8.setText(str);
			 btn8.setEnabled(false);
		}
		if(e.getSource() == btn9) {
			 btn9.setText(str);
			 btn9.setEnabled(false);
		}
		
		if(btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText() && btn1.getText() != "") { // kollar efter horisontell vinst
			win = true;
		}
		else if(btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText() && btn4.getText() != "") {
			win = true;
		}
		else if(btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText() && btn7.getText() != "") {
			win = true;
		}
		
		else if(btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText() && btn1.getText() != "") { // kollar efter vertikal vinst
			win = true;
		}
		else if(btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText() && btn2.getText() != "") {
			win = true;
		}
		else if(btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText() && btn3.getText() != "") {
			win = true;
		}
		
		else if(btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText() && btn1.getText() != "") { // kollar efter diagonal vinst
			win = true;
		}
		else if(btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText() && btn3.getText() != "") {
			win = true;
		}
		else {
			win = false;
		}
		
		if(win == true) {
			whoWon.setText(str + " vann spelet! :D");
			 btn1.setEnabled(false);
			 btn2.setEnabled(false);
			 btn3.setEnabled(false);
			 btn4.setEnabled(false);
			 btn5.setEnabled(false);
			 btn6.setEnabled(false);
			 btn7.setEnabled(false);
			 btn8.setEnabled(false);
			 btn9.setEnabled(false);

		}
		else if(nbr == 9 &&  win == false) {
			whoWon.setText("Det blev lika...");
		}
	}
	
	public static void main(String[] args) {
	new GUI();
	
	}
}
