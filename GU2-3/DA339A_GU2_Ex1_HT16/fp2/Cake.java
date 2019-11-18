package fp2;
import javax.swing.ImageIcon;

public class Cake {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private ImageIcon image;
    
    public Cake(ImageIcon image) {
        this.image = image;
    }
    
    public void init(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageIcon getImage() {
        return image;
    }
    
    public void changeDx() {
        this.dx = -this.dx;
    }
    
    public void changeDy() {
        this.dy = -this.dy;
    }
    
    public void act() {
        this.x = this.x + this.dx;
        this.y = this.y + this.dy;
    }
}
