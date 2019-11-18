package laboration10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

public class SurveyPanel extends JPanel {

	private JPanel pnlNorth = new JPanel( new BorderLayout() ); 
	private JPanel pnlNorthNorth = new JPanel(new BorderLayout());
	private JPanel pnlNorthCenter = new JPanel(new GridLayout(1,2)); 
	private JPanel pnlAge = new JPanel(new GridLayout(5,1));
	private JPanel pnlHobby = new JPanel(new GridLayout(5,1));
	private JTextArea taSummary = new JTextArea();
	private JButton btnSummary = new JButton( "Sammanfattning" );
	private JLabel lblName = new JLabel( "Namn: " ); 
	private JTextField tfName = new JTextField();
	private JRadioButton rb_017 = new JRadioButton( " 0 - 17" );
	private JRadioButton rb18_64 = new JRadioButton( " 18 - 64" );
	private JRadioButton rb65 = new JRadioButton( "65 -" );
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbSport = new JCheckBox( "Idrott" );
	private JCheckBox cbDance = new JCheckBox( "Folkdans" );
	private JCheckBox cbBirds = new JCheckBox( "Fågelskådning" );
	private JCheckBox cbBridge = new JCheckBox( "Bridge" ); 
	private JCheckBox cbSong = new JCheckBox( "Körsång" );
	
//	3 st JLabel (varav två osynliga) 
//	1 st JTextField
//	75 st JPanel
//	3 st JRadioButton
//	5 st JCheckBox 1 st JButton
//	1 st JTextArea.

	public SurveyPanel() {
		
		setPreferredSize( new Dimension(300,250) ); 
		setLayout( new BorderLayout() );
		
		add( pnlNorth, BorderLayout.NORTH );
		add( taSummary, BorderLayout.CENTER );
		
		btnSummary.addActionListener( new SummaryListener() );
		
		pnlNorth.add( pnlNorthNorth, BorderLayout.NORTH );
		pnlNorth.add( pnlNorthCenter, BorderLayout.CENTER );
		pnlNorth.add( btnSummary, BorderLayout.SOUTH );
		
		pnlNorthNorth.add( lblName, BorderLayout.WEST );
		pnlNorthNorth.add( tfName, BorderLayout.CENTER );
		pnlNorthCenter.add(pnlAge); 
		pnlNorthCenter.add(pnlHobby);
		pnlNorth.add(pnlNorthNorth, BorderLayout.NORTH);
		
		pnlAge.setBorder( BorderFactory.createTitledBorder( "Ålder" ));
		buttonGroup.add( rb_017 );
		buttonGroup.add( rb18_64);
		buttonGroup.add( rb65 );
		pnlAge.add( rb_017 );
		pnlAge.add( rb18_64 );
		pnlAge.add( rb65 );
		rb65.setSelected( true );
		
		pnlHobby.setBorder( BorderFactory.createTitledBorder( "Hobby" ));
		pnlHobby.add( cbSport );
		pnlHobby.add( cbDance );
		pnlHobby.add( cbBirds );
		pnlHobby.add( cbBridge ); 
		pnlHobby.add( cbSong );
		
	}
	
	private class SummaryListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			summary();
		}
	}
	
	public void summary() {
		String res = tfName.getText() + "\n";
		if( rb_017.isSelected() )
			res += "ålder: " + "0-17 år \n";
		else if( rb18_64.isSelected() )
			res += "ålder: " + "18-64 år \n";
		else if( rb65.isSelected() )
			res += "ålder: 65 år \n";
		
		res += "Hobby: ";
		if( cbSport.isSelected() )
			res += " Idrott";
			if( cbDance.isSelected() )
			res += " Folkdans"; if( cbBirds.isSelected() )
			res += " Fågelskådning"; if( cbBridge.isSelected() )
			res += " Bridge";
			if( cbSong.isSelected() )
			res += " Körsång"; res += "\n";
			taSummary.setText( res );
	}
	
}
