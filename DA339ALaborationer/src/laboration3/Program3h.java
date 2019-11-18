package laboration3;

import java.awt.Color;
import gu1.PaintWindow_GU1;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Program3h {
	public void flyttgubbe() {
		PaintWindow_GU1.showWindow(1200, 1200, "laboration3h", Color.BLACK);
		int x,y;
		String str;
		
		ImageIcon image = new ImageIcon("images/gubbe.jpg");
		PaintWindow_GU1.addIcon("gubbe", image, 500, 300, true);
		
		str = JOptionPane.showInputDialog("Ange x-koordinat");
		x = Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Ange y-koordinat");
		y = Integer.parseInt(str);
		PaintWindow_GU1.setIconXY("gubbe", x, y);
		
	}
	
	public static void main(String[] args) {
		Program3h prog = new Program3h();
		prog.flyttgubbe();
	}
	
}
