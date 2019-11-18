package laboration14;

import java.awt.*; 
import javax.swing.*;

public class NameProfession extends JLabel {
	private JPanel panel1 = new JPanel(new GridLayout(2,1));
	private JPanel panel2 = new JPanel(new GridLayout(2,1));
	private JLabel label1 = new JLabel("name");
	private JLabel label2 = new JLabel("yrke");
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();


	public NameProfession() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 60));

		panel1.add(label1);
		panel1.add(label2);
		panel2.add(tf1);
		panel2.add(tf2);

		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
	}
	// metoder som anropas från konstruktorn – vid behov
	// get-metoder
	public String getName() {
		return tf1.getText();
	}
	public String getProfession() { 
		return tf2.getText();
	}
}

