package laboration3;

import java.awt.Color;

import javax.swing.ImageIcon;

import gu1.PaintWindow_GU1;

public class Program3f {

	    public void demo2() {
	    	PaintWindow_GU1.showWindow(2000, 2000, "Laboration 3f", Color.WHITE);
	        ImageIcon image = new ImageIcon("images/gubbe.jpg");
	        ImageIcon image1 = new ImageIcon("images/låda.jpg");
	        ImageIcon image2 = new ImageIcon("images/bil.jpg");
	        ImageIcon image3 = new ImageIcon("images/bil2.jpg");
	        PaintWindow_GU1.addIcon("bil1",image1, 1, 1,true);
	        PaintWindow_GU1.addIcon("bil2",image1, 400, 150,true);
	        PaintWindow_GU1.addIcon("låda",image1, 2000, 1500,true);
	    }
	    public static void main(String[] args) {
	        Program3f prog = new Program3f();
	        prog.demo2();
	    }
	}
