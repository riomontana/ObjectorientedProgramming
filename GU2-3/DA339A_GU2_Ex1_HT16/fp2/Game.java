package fp2;
import gu2.PaintWindow_GU2;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

import paintpanel.Sound;
import paintpanel.SoundClip;
import paintpanel.Text;

public class Game {
    private PaintWindow_GU2 window;
    private Head head1;
    private Head head2;
    private Cake cake;
    private ImageIcon btnStartGameEnabled;
    private ImageIcon btnStartGameDisabled;
    private Text txtWinner = new Text("JAG VANN!", new Font("SansSerif", Font.PLAIN, 36), Color.MAGENTA);
    private Sound sound;
    private SoundClip clip;

    public Game(Head head1, Head head2, Cake cake) {
        ImageIcon im = StartApplication.getImageIcon("/images/sommar.jpg");
        btnStartGameEnabled = StartApplication.getImageIcon("/images/start_game_enabled.png");
        btnStartGameDisabled = StartApplication.getImageIcon("/images/start_game_disabled.png");
        
        this.head1 = head1;
        this.head2 = head2;
        this.cake = cake;
        
        this.head1.init(50,60,0);
        this.head2.init(100,60,0);
        this.cake.init(150, 60, 0, 0);
        
        this.window = new PaintWindow_GU2(800,600,"Inför P2",im,0,0);

        window.addIcon(btnStartGameEnabled, 10, 510, true);
        window.addIcon(btnStartGameDisabled, 10, 510, false);
        
        window.addIcon(head1.getImageClean(), head1.getX(), head1.getY(),false);
        window.addIcon(head1.getImageDirty(), head1.getX(), head1.getY(),true);
        window.addIcon(head2.getImageClean(), head2.getX(), head2.getY(),false);
        window.addIcon(head2.getImageDirty(), head2.getX(), head2.getY(),true);
        window.addIcon(cake.getImage(), cake.getX(), cake.getY(),true);
        window.addIcon(txtWinner, 100, 180,false);
        
        window.setIconAction(btnStartGameEnabled, this, "playGame");
        clip = StartApplication.getSoundClip("/sound/gong.au");
    }

    private void init() {
        Random random = new Random();
        int cakeX,cakeY,cakeDx,cakeDy;
        
        window.hideIcon(btnStartGameEnabled);
        window.showIcon(btnStartGameDisabled);
        
        window.hideIcon(head1.getImageDirty());
        window.hideIcon(head2.getImageDirty());
        window.hideIcon(txtWinner);
        
        head1.init(0, 60, 2);
        head2.init(0, 300, 3);
        head1.setClean(true);
        head2.setClean(true);
        
        cakeX = random.nextInt(360) + 200;
        cakeY = random.nextInt(340);
        cakeDx = random.nextInt(3) + 1;
        cakeDy = random.nextInt(6)-3; // cakeY = -3,-2,-1,0,1,2
        if(cakeDy==0)
            cakeDy = 3;
        cake.init(cakeX, cakeY, cakeDx, cakeDy);
        
        window.setIconXY(head1.getImageClean(), head1.getX(), head1.getY());
        window.setIconXY(head2.getImageClean(), head2.getX(), head2.getY());
        window.setIconXY(cake.getImage(), cake.getX(), cake.getY());
        window.showIcon(head1.getImageClean());
        window.showIcon(head2.getImageClean());
        window.showIcon(cake.getImage());
        try {
            sound = StartApplication.getSound("/sound/chimes.wav");
        }catch(Exception e) {}
    }
    
    private void moveHead(Head head) {
        head.act();
        if ((head.getX() <= 0) || (head.getX() >=window.getBackgroundWidth()-head.getImageClean().getIconWidth())) {
            head.changeDx();
        }
        window.setIconXY(head.getImageClean(), head.getX(), head.getY());
    }

    private void moveCake() {
        cake.act();
        if ((cake.getX() <= 0) || (cake.getX() >= window.getBackgroundWidth()-cake.getImage().getIconWidth())) {
            cake.changeDx();
        }
        if ((cake.getY() <= 0) || (cake.getY() >= window.getBackgroundHeight()-cake.getImage().getIconHeight())) {
            cake.changeDy();
        }
        window.setIconXY(cake.getImage(), cake.getX(), cake.getY());
    }
    
//    private void intersect(Cake cake, Head head) {
//    	int headWidth = head.getImageClean().getIconWidth();
//    	int headHeight = head.getImageClean().getIconHeight();
//        int x1 = head.getX(), y1 = head.getY();
//        int x2 = x1 + headWidth, y2 = y1;
//        int x3 = x2, y3 = y1 + headHeight;
//        int x4 = x1, y4 = y3;
//        int cakeX = cake.getX();
//        int cakeY = cake.getY();
//        boolean leftUp = (x1>=cakeX) && (x1<=cakeX+headWidth) && (y1>=cakeY) && (y1<=cakeY+headHeight);
//        boolean rightUp = (x2>=cakeX) && (x2<=cakeX+headWidth) && (y2>=cakeY) && (y2<=cakeY+headHeight);
//        boolean rightDown = (x3>=cakeX) && (x3<=cakeX+headWidth) && (y3>=cakeY) && (y3<=cakeY+headHeight);
//        boolean leftDown = (x4>=cakeX) && (x4<=cakeX+headWidth) && (y4>=cakeY) && (y4<=cakeY+headHeight);
//        if (leftUp || rightUp || rightDown || leftDown) {
//            head.setClean(false);
//        }
//    }
    
    public void intersect(Cake cake, Head head) {
    	int radius = head.getImageClean().getIconWidth() / 2;

        int cakeX = cake.getX()+radius, cakeY = cake.getY()+radius;
        int headX = head.getX() + radius, headY = head.getY() + radius;
        double distance = Math.sqrt((cakeX-headX)*(cakeX-headX) + (cakeY-headY)*(cakeY-headY));
        if(distance<=radius*2) {
            head.setClean(false);
        }
    }

    private void play() {
        sound.play();
        while (head1.getClean() && head2.getClean()) {
            moveHead(head1);
            moveHead(head2);
            moveCake();
            intersect(cake, head1);
            intersect(cake, head2);
            PaintWindow_GU2.pause(10);
        }
        clip.start();
    }
    
    private void showWinner(Head winner, Head looser) {
    	window.hideIcon(looser.getImageClean());
    	window.setIconXY(looser.getImageDirty(), looser.getX(), looser.getY());
    	window.showIcon(looser.getImageDirty());
    	
        window.setIconXY(winner.getImageClean(), 320, 180);
        window.showIcon(txtWinner);
    }

    private void result() {
        if (head1.getClean()) {
            showWinner(head1,head2);
        } else {
            showWinner(head2,head1);
        }
        window.hideIcon(btnStartGameDisabled);
        window.showIcon(btnStartGameEnabled);
    }

    public void playGame() {
        init();
        play();
        result();
    }
}
