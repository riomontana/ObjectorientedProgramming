package laboration10;

import java.awt.*;
import javax.swing.*;

public class ImageViewer extends JPanel {

	private JLabel lblTitle = new JLabel();
	private JLabel lblImage = new JLabel("INGEN BILD VALD", JLabel.CENTER);

	public ImageViewer() {
		
		setLayout( new BorderLayout() );
		lblImage.setPreferredSize( new Dimension( 640, 480 ) );
		add(lblTitle, BorderLayout.NORTH);
		add(lblImage, BorderLayout.CENTER);
		
	}
	
	public void noImage() {
		lblImage.setIcon(null);
		lblImage.setText("INGEN BILD VALD");
		lblTitle.setText("");
	}
	
	public void showImage(String filename) {
		lblImage.setText("");
		lblImage.setIcon(new ImageIcon(filename));
		lblTitle.setText(filename);
	}
	
	
	public static void main(String args[]) {
		ImageViewer viewer = new ImageViewer(); 
		viewer.showImage("/Users/LFO/Documents/filmlogga.jpg");// alt. viewer.noImage();
		JOptionPane.showMessageDialog(null, viewer);
	}
}