package game3;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import paintpanel.Sound;
import paintpanel.SoundClip;
import paintpanel.Text;
import controller.Controller;
import controller.StartApp;
import gu2.PaintWindow_GU2;

public class Game3 {
	private PaintWindow_GU2 mWindow;
	private Controller mController;
	private int delay = 40;
	private boolean mRunning;
	private ImageIcon new1;
	private ImageIcon new2;
	private ImageIcon new3;
	private ImageIcon new4;
	private ImageIcon new5;
	private ImageIcon new6;
	private ImageIcon new7;
	private ImageIcon new8;
	private ImageIcon new9;
	private ImageIcon new10;
	private Text animSpeed;
	private int index;
	
	public Game3(PaintWindow_GU2 window, Controller controller, int x, int y) {
		Font font = new Font("SansSerif",Font.PLAIN,24);
		ImageIcon btnMenu = StartApp.getImageIcon("/application/images/meny.png");
		mWindow = window;
		mController = controller;
		
		mWindow.fillRect(x, y, Controller.GAME_WIDTH, Controller.GAME_HEIGHT, Color.GREEN);
		new1 = StartApp.getImageIcon("/game3/images/new1.JPG");
		new2 = StartApp.getImageIcon("/game3/images/new2.JPG");
		new3 = StartApp.getImageIcon("/game3/images/new3.JPG");
		new4 = StartApp.getImageIcon("/game3/images/new4.JPG");
		new5 = StartApp.getImageIcon("/game3/images/new5.JPG");
		new6 = StartApp.getImageIcon("/game3/images/new6.JPG");
		new7 = StartApp.getImageIcon("/game3/images/new7.JPG");
		new8 = StartApp.getImageIcon("/game3/images/new8.JPG");
		new9 = StartApp.getImageIcon("/game3/images/new9.JPG");
		new10 = StartApp.getImageIcon("/game3/images/new10.JPG");
		
		Text instruction1 = new Text("Använd pil-upp för att öka hastigheten", font, Color.BLACK);
		Text instruction2 = new Text("Använd pil-ner för att minska hastigheten", font, Color.BLACK);
		animSpeed = new Text("delay: " + delay, font, Color.BLACK);
		mWindow.addText(instruction1, x+100, y+10);
		mWindow.addText(instruction2, x+100, y+50);
		mWindow.addText(animSpeed, x+100, y+90);
		
		int iconX = (Controller.GAME_WIDTH-new1.getIconWidth())/2;
		int iconY = (Controller.GAME_HEIGHT-new1.getIconHeight())/2;
		mWindow.addIcon(new1, x+iconX, y+iconY, true);
		mWindow.addIcon(new2, x+iconX, y+iconY, false);
		mWindow.addIcon(new3, x+iconX, y+iconY, false);
		mWindow.addIcon(new4, x+iconX, y+iconY, false);
		mWindow.addIcon(new5, x+iconX, y+iconY, false);
		mWindow.addIcon(new6, x+iconX, y+iconY, false);
		mWindow.addIcon(new7, x+iconX, y+iconY, false);
		mWindow.addIcon(new8, x+iconX, y+iconY, false);
		mWindow.addIcon(new9, x+iconX, y+iconY, false);
		mWindow.addIcon(new10, x+iconX, y+iconY, false);
		mWindow.addIcon(btnMenu, x+550, y+500, true);
		
		mWindow.setIconAction(btnMenu,  this, "menu");		
		mWindow.setKeyPressed(PaintWindow_GU2.VK_DOWN, this, "slowDown");
		mWindow.setKeyPressed(PaintWindow_GU2.VK_UP, this, "speedUp");
	}
	
	public void start() {
		if(!mRunning) {
			mRunning = true;
			run();
		}
	}
	
	public void stop() {
	    mRunning = false;
	}
	
	public void run() {
		ImageIcon hide=null, show=null;
		while(mRunning) {
			switch(index) {
			case 0 : 
				hide = new1;
				show = new2;
				break;
			case 1 : 
				hide = new2;
				show = new3;
				break;
			case 2 : 
				hide = new3;
				show = new4;
				break;
			case 3 : 
				hide = new4;
				show = new5;
				break;
			case 4 : 
				hide = new5;
				show = new6;
				break;
			case 5 : 
				hide = new6;
				show = new7;
				break;
			case 6 : 
				hide = new7;
				show = new8;
				break;
			case 7 : 
				hide = new8;
				show = new9;
				break;
			case 8 : 
				hide = new9;
				show = new10;
				break;
			case 9 : 
				hide = new10;
				show = new1;
				break;
			}
			index = (index+1)%10;
			mWindow.showIcon(show);
			mWindow.hideIcon(hide);
			PaintWindow_GU2.pause(delay);
		}
	}
	
	public void menu() {
		Sound sound = StartApp.getSound("/application/sound/click.mp3");
		if(sound!=null)
			sound.play();
		stop();
		mController.menu();
	}
	
	public void speedUp() {
		if(delay>1) {
			delay--;
			animSpeed.setText("delay: " + delay);
		}
	}
	
	public void slowDown() {
		if(delay<80) {
			delay++;
			animSpeed.setText("delay: " + delay);
		}
	}
}
