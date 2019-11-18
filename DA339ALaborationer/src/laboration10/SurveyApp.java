package laboration10;

import javax.swing.JFrame;

public class SurveyApp {

	private void start() {
		JFrame frame = new JFrame( "Personundersökning" ); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add( new SurveyPanel() ); 
		frame.pack(); 
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		SurveyApp app = new SurveyApp();
		app.start();
	}
}
