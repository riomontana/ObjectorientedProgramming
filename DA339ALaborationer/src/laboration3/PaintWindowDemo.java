package laboration3;
import java.awt.Color;
import gu1.PaintWindow_GU1;
import javax.swing.ImageIcon;

/**
 * Programmet demonstrerar olika metoder i PaintWindow
 * @author TSROAX
 */
public class PaintWindowDemo {
    public void demo1() {
    	PaintWindow_GU1.showWindow(600, 400, "Laboration 3e", Color.WHITE);
        ImageIcon image = new ImageIcon("images/gubbe.jpg");
        PaintWindow_GU1.line(200, 200, 400, 1000, Color.CYAN, 10);
        PaintWindow_GU1.line(100, 380, 200, 100, Color.YELLOW, 3);
        PaintWindow_GU1.drawRect(10, 10, 580, 380, Color.RED, 4);
        PaintWindow_GU1.fillRect(30, 280, 130, 60, Color.BLUE);
        PaintWindow_GU1.drawOval(240, 40, 100, 100, Color.BLACK, 10);
        PaintWindow_GU1.fillOval(270, 70, 40, 60, Color.GREEN);
        PaintWindow_GU1.addIcon("Gubbe",image, 400, 150,true);
    }
    
    public static void main(String[] args) {
        PaintWindowDemo prog = new PaintWindowDemo();
        prog.demo1();
    }
}
