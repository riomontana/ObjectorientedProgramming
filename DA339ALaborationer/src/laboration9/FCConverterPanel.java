package laboration9;

import javax.swing.*; 
import java.awt.*; 
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FCConverterPanel extends JPanel implements ActionListener{

	private JLabel lbl1 = new JLabel( "Grader" );
	private JLabel lbl2 = new JLabel( "Resultat" );
	private JTextField tf = new JTextField();
	private JButton farenHeit = new JButton( "To Farenheit" );
	private JButton celsius = new JButton( "To Celsius" );
	private JButton exit = new JButton( "Avsluta" );
	private Font font1 = new Font( "SansSerif", Font.PLAIN, 18 );
	
	public FCConverterPanel() {
	setPreferredSize( new Dimension( 250 , 250 ) );
	lbl1.setPreferredSize( new Dimension ( 100, 40 ));
	lbl1.setFont( font1 );
	add( lbl1 );
	tf.setPreferredSize( new Dimension( 100, 40 ));
	add( tf );
	lbl2.setPreferredSize( new Dimension ( 200, 40 ));
	lbl2.setFont(font1);
	add( lbl2 );
	farenHeit.setPreferredSize( new Dimension( 200, 40 ));
	farenHeit.setFont( font1 );
	add( farenHeit );
	celsius.setPreferredSize( new Dimension( 200, 40 ));
	celsius.setFont( font1 );
	add( celsius );
	exit.setPreferredSize(new Dimension ( 200, 40 ));
	exit.setFont(font1);
	add( exit );
	farenHeit.addActionListener( this );
	celsius.addActionListener( this );
	exit.addActionListener( this );
	}
	
	public void actionPerformed( ActionEvent e ) {
	
		double degree, res;
		String txt;
		
		if( e.getSource() == farenHeit ) {
			degree = Double.parseDouble( tf.getText() );
			res = 32 + 1.8 * degree;
			txt = String.format( "Resultat: %1.1f F ", res );
			lbl2.setText( txt );
			
		} 
		else if( e.getSource() == celsius ) {
			degree = Double.parseDouble( tf.getText() );
			res = ( degree - 32 ) / 1.8;
			txt = String.format( "Resultat: %1.1f C ", res );
			lbl2.setText( txt );
		}
		else if( e.getSource() == exit ) { 
		System.exit( 0 );
		}
	}
}