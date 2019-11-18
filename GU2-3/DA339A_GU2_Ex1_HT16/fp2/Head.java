package fp2;

import javax.swing.ImageIcon;

public class Head {
    private int x;
    private int y;
    private int dx;
    private boolean clean;
    private ImageIcon imageClean;
    private ImageIcon imageDirty;
    
    public Head(ImageIcon imageClean,ImageIcon imageDirty) {
        this.imageClean = imageClean;
        this.imageDirty = imageDirty;
        this.clean = true;
    }
    
    public void init(int x, int y, int dx) {
        this.x = x;
        this.y = y;
        this.dx = dx;
    }
    
    public boolean getClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
        
    public ImageIcon getImageClean() {
        return imageClean;
    }
    
    public ImageIcon getImageDirty() {
        return imageDirty;
    }
    
    public void changeDx() {
        this.dx = -this.dx;
    }
    
    public void act() {
        this.x = this.x + this.dx;
    }
}
