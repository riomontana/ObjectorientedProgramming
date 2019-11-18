package laboration9;

import javax.swing.JFrame;

public class FCConverter {

	public void start() {
		JFrame frame = new JFrame( "Konverterare" ); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add( new FCConverterPanel() ); 
		frame.pack(); 
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		FCConverter app = new FCConverter();
		app.start();
	}
}
