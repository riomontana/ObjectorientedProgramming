package game1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import controller.Controller;
import controller.StartApp;
import gu2.PaintWindow_GU2;
import paintpanel.Sound;
import paintpanel.SoundClip;
import paintpanel.Text;

public class Game1 {
	private PaintWindow_GU2 mWindow;
	private Controller mController;
	private int mX;
	private int mY;
	private Numbers numbers1;
	private Numbers numbers2;
	private boolean mStarted;
	private boolean mRunning;
	private SoundClip clip;
	private Text text1;
	private Text text2;
	private ImageIcon explosion;
	
	public Game1(PaintWindow_GU2 window, Controller controller, int x, int y) {
		Font font = new Font("Monospaced",Font.PLAIN,192);
		mWindow = window;
		mController = controller;
		mX = x;
		mY = y;
		
		mWindow.fillRect(x, y, Controller.GAME_WIDTH, Controller.GAME_HEIGHT, Color.PINK);
		
		clip = StartApp.getSoundClip("/game1/sound/gong.au");
		text1 = new Text("10",font,Color.BLACK, Color.WHITE);
		text2 = new Text(" 0",font,Color.WHITE, Color.BLACK);
		explosion = StartApp.getImageIcon("/game1/images/explosion.png");
		mWindow.addText(text1, x+25, y+180);
		mWindow.addText(text2, x+25+text1.getIconWidth()+40, y+180);
		mWindow.addIcon(explosion, x-10, y+200, false);
		
		initButtons();
		init();
	}
	
	private void initButtons() {
		int y = mY+100;
		ImageIcon btnStart = StartApp.getImageIcon("/application/images/starta.png");
		ImageIcon btnStop = StartApp.getImageIcon("/application/images/stoppa.png");
		ImageIcon btnPause = StartApp.getImageIcon("/application/images/pausa.png");
		ImageIcon btnResume = StartApp.getImageIcon("/application/images/fortsatt.png");
		ImageIcon btnMenu = StartApp.getImageIcon("/application/images/meny.png");

		mWindow.addIcon(btnStart, mX+550, y+10, true);
		y += btnStart.getIconHeight() + 10;
		mWindow.addIcon(btnResume, mX+550, y+10, true);
		y += btnResume.getIconHeight() + 10;
		mWindow.addIcon(btnPause, mX+550, y+10, true);
		y += btnPause.getIconHeight() + 10;
		mWindow.addIcon(btnStop, mX+550, y+10, true);
		y += btnStop.getIconHeight() + 40;
		mWindow.addIcon(btnMenu, mX+550, mY+500, true);
//		mWindow.addIcon(btnMenu, mX+550, y+10, true);
		
		mWindow.setIconAction(btnStart, this, "start");
		mWindow.setIconAction(btnPause, this, "pause");
		mWindow.setIconAction(btnResume, this, "resume");
		mWindow.setIconAction(btnStop, this, "stop");
		mWindow.setIconAction(btnMenu,  this, "menu");
	}
	
	private void init() {	
		mStarted = false;
		mRunning = false;
		numbers1 = new Numbers(10,10,-1);
		numbers2 = new Numbers(0,Integer.MAX_VALUE,1);
		text1.setText("10");
		text2.setText(" 0");
	}
	
	public void menu() {
		Sound sound = StartApp.getSound("/application/sound/click.mp3");
		if(sound!=null)
			sound.play();
		pause();
		mController.menu();
	}
	
	public void start() {
		if(mStarted==false && mRunning==false) {
			init();
			mStarted = true;
			resume();
		}
	}
	
	public void resume() {
		if(mRunning==false && mStarted==true) {
    		mRunning=true;
	    	run();
		}
	}
	
	public void pause() {
		mRunning = false;
	}
	
	public void stop() {
		mRunning = false;
		mStarted = false;
	}
	
	public void run() {
		int nbr;
		PaintWindow_GU2.pause(500);
		while(mRunning == true) {
			nbr = numbers1.nextValue();
			text1.setText( String.format("%2d",nbr) );
			if(nbr==0) {
				text2.setText( String.format("%2d",numbers2.nextValue()%100) );
				mWindow.hideIcon(text1);
				mWindow.showIcon(explosion);
				clip.start();
			} 
			PaintWindow_GU2.pause(500);
			mWindow.showIcon(text1);
			mWindow.hideIcon(explosion);
		}
	}
}
