package laboration9;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener; 

public class TransportPanel extends JPanel {
	
	private JLabel howTravel = new JLabel( "		Hur reser du till malmö högskola?" );
	private JLabel answerTravel = new JLabel( "		Du reser med: " );
	private JCheckBox boxCar = new JCheckBox( "Bil" );
	private JCheckBox boxBus = new JCheckBox( "Buss" );
	private JCheckBox boxTrain = new JCheckBox( "Tåg" );
	private JCheckBox boxCycle = new JCheckBox( "Cykel" );
	private JCheckBox boxWalk = new JCheckBox( "Går" );
	private Font font = new Font( "TimesNewRoman", Font.BOLD, 12 );
	
	
	public TransportPanel() {
		
		int boxWidth = 70;
		int boxHeight = 20;
		
		setPreferredSize( new Dimension( 450, 85 ));
		setBackground( Color.CYAN );
		
		howTravel.setPreferredSize( new Dimension( 400, 20 ));
		howTravel.setFont(font);
		add( howTravel );
		
		boxCar.setPreferredSize( new Dimension( boxWidth, boxHeight ));
		boxCar.setFont(font);
		add( boxCar );
		
		boxBus.setPreferredSize( new Dimension( boxWidth, boxHeight ));
		boxBus.setFont(font);
		add( boxBus );
		
		boxTrain.setPreferredSize( new Dimension( boxWidth, boxHeight ));
		boxTrain.setFont(font);
		add( boxTrain );
		
		boxCycle.setPreferredSize(new Dimension( boxWidth, boxHeight ));
		boxCycle.setFont(font);
		add( boxCycle );
		
		boxWalk.setPreferredSize( new Dimension( boxWidth, boxHeight ));
		boxWalk.setFont(font);
		add( boxWalk );
		
		answerTravel.setPreferredSize( new Dimension( 400, 20 ));
		answerTravel.setFont( font );;
		add( answerTravel );
		
		addListeners();
	
	}
	
	private void addListeners() {
		CheckBoxListener listener = new CheckBoxListener(); 
		boxCar.addItemListener(listener); 
		boxTrain.addItemListener(listener); 
		boxBus.addItemListener(listener); 
		boxCycle.addItemListener(listener); 
		boxWalk.addItemListener(listener);
	
	}
	
	private class CheckBoxListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			String res = "		Du reser med: ";
			
			if (boxCar.isSelected()==true) {
				res += "bil";
			}
			if (boxBus.isSelected()==true) {
				res += "buss";		
			}
			if (boxTrain.isSelected()==true) {
				res += "tåg";
			}
			if (boxCycle.isSelected()==true) {
				res += "cykel";
			}
			if (boxWalk.isSelected()==true) {
				res += "går";
			}		
			
			answerTravel.setText( res );
		}
			
		}
		
	

	public static void main( String[] args ) {
		TransportPanel TransportPanel = new TransportPanel();
		TransportPanel.setBorder( BorderFactory.createLineBorder( Color.BLACK ));
		JOptionPane.showMessageDialog( null, TransportPanel);
	}
}
