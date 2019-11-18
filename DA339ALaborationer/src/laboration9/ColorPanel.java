package laboration9;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random; 

public class ColorPanel extends JPanel {

	private JLabel lblChsClr = new JLabel( "Välj en färg" );
	private JRadioButton btnRed = new JRadioButton( "Röd" );
	private JRadioButton btnGreen = new JRadioButton( "Grön" );
	private JRadioButton btnBlue = new JRadioButton( "Blå" );
	private JRadioButton btnRand = new JRadioButton( "Slump" );
	private Font font1 = new Font( "TimesNewRoman", Font.BOLD, 15 );
	private Font font2 = new Font( "TimesNewRoman", Font.BOLD, 12 );

	public ColorPanel() {

		int width = 100;
		int height = 30;

		setPreferredSize( new Dimension ( 150, 200 ));

		lblChsClr.setPreferredSize( new Dimension ( width, height ));
		lblChsClr.setFont(font1);
		add(lblChsClr);

		btnRed.setPreferredSize( new Dimension( width, height ));
		btnRed.setFont( font2 );
		add( btnRed );

		btnGreen.setPreferredSize( new Dimension( width, height ));
		btnGreen.setFont( font2 );
		add( btnGreen );

		btnBlue.setPreferredSize( new Dimension( width, height ));
		btnBlue.setFont( font2 );
		add( btnBlue );

		btnRand.setPreferredSize( new Dimension( width, height ));
		btnRand.setFont( font2 );
		add( btnRand );

		ButtonGroup group = new ButtonGroup();
		group.add( btnRed );
		group.add( btnGreen );
		group.add( btnBlue );
		group.add( btnRand );
		
		ColorListener listener = new ColorListener();
		btnRed.addActionListener( listener );
		btnGreen.addActionListener( listener );
		btnBlue.addActionListener( listener );
		btnRand.addActionListener( listener );

	}

	private class ColorListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
		
			
			if (btnRed.isSelected()==true) {
				setBackground(Color.RED);
			} 
			else if (btnGreen.isSelected()==true) {
				setBackground(Color.GREEN);
			}
			else if (btnBlue.isSelected()==true) {
				setBackground(Color.BLUE);
			}
			else if (btnRand.isSelected()==true) {
				Random rand = new Random();
				Color color = new Color(rand.nextInt(256));
				setBackground(color); 
			}
		}
	}

	public static void main(String[] args) {

		ColorPanel ColorPanel = new ColorPanel();
		ColorPanel.setBorder( BorderFactory.createLineBorder( Color.BLACK ));
		JOptionPane.showMessageDialog( null, ColorPanel);
	}
}
