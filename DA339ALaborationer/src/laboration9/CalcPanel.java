package laboration9;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

public class CalcPanel extends JPanel implements ActionListener {

	private JLabel lblNbr1 = new JLabel( "tal 1" );
	private Font fontLabels = new Font( "SansSerif", Font.PLAIN, 18 );
	private JTextField tfNbr = new JTextField();
	private JLabel lblNbr2 = new JLabel( "tal 2" );
	private JTextField tfNbr2 = new JTextField();
	private JButton btnAdd = new JButton( "+" );
	private Font fontButtons = new Font( "SansSerif", Font.PLAIN, 24);
	private JButton btnSub = new JButton( "-" );
	private JLabel lblRes = new JLabel( "resultat" );

	public CalcPanel() {
		setPreferredSize( new Dimension( 250,105 ) );
		lblNbr1.setPreferredSize( new Dimension( 100, 20 ));
		lblNbr1.setFont( fontLabels );
		add( lblNbr1 );
		tfNbr.setPreferredSize( new Dimension( 100, 20 ));
		add( tfNbr );
		lblNbr2.setPreferredSize( new Dimension( 100, 20 ));
		lblNbr2.setFont( fontLabels );
		add( lblNbr2);
		tfNbr2.setPreferredSize( new Dimension( 100, 20 ));
		add( tfNbr2 );
		btnAdd.setPreferredSize(new Dimension( 100, 20 ));
		btnAdd.setFont( fontButtons );
		add( btnAdd );
		btnSub.setPreferredSize(new Dimension( 100, 20 ));
		btnSub.setFont( fontButtons);
		add(btnSub);
		lblRes.setPreferredSize(new Dimension( 100, 20 ));
		lblRes.setFont( fontLabels );
		add( lblRes );
		btnAdd.addActionListener( this );
	}

	public void actionPerformed( ActionEvent e ) {
		double nbr1, nbr2;
		String nbr1Str, nbr2Str, res, res2;
		nbr1Str = tfNbr.getText();
		nbr2Str = tfNbr2.getText();
		nbr1 = Double.parseDouble( nbr1Str );
		nbr2 = Double.parseDouble( nbr2Str );
		if( e.getSource() == btnAdd ) {
			res = nbr1Str + " + " + nbr2Str + " = " + (nbr1 + nbr2);
			lblRes.setText( res );
				}
		else if( e.getSource() == btnSub ) {
			res2 = nbr1Str + " - " + nbr2Str + " = " + (nbr1 - nbr2);
			lblRes.setText( res2 );
		}
	}
}


