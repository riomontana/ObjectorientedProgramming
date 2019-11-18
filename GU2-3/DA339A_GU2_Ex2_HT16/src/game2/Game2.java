package game2;

import gu2.PaintWindow_GU2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import paintpanel.Sound;
import paintpanel.Text;
import controller.Controller;
import controller.StartApp;

public class Game2 {
	private PaintWindow_GU2 mWindow;
	private Controller mController;
	private int mX;
	private int mY;
	private Text instruction;
	private Text result;
	private Text btnWin;
	private int click = 0;
	
	public Game2(PaintWindow_GU2 window, Controller controller, int x, int y) {
		Font font = new Font("SansSerif",Font.PLAIN,36);
		mWindow = window;
		mController = controller;
		mX = x;
		mY = y;
		
		mWindow.fillRect(x, y, Controller.GAME_WIDTH, Controller.GAME_HEIGHT, Color.LIGHT_GRAY);
		
		instruction = new Text("Klicka på knappen 'VINST' för att vinna",font,Color.BLACK, Color.WHITE);
		result = new Text("Du vann",font,Color.WHITE, Color.BLACK);
		btnWin = new Text("VINST",font,Color.WHITE, Color.BLACK);
		ImageIcon btnMenu = StartApp.getImageIcon("/application/images/meny.png");
		mWindow.addText(instruction, centerIconHorizontal(x,x+Controller.GAME_WIDTH,instruction), y+20);
		mWindow.addIcon(result, centerIconHorizontal(x,x+Controller.GAME_WIDTH,result), y+50+instruction.getIconHeight(),false);
		mWindow.addIcon(btnWin, centerIconHorizontal(x,x+Controller.GAME_WIDTH,btnWin), y+300,true);
		mWindow.addIcon(btnMenu, centerIconHorizontal(x,x+Controller.GAME_WIDTH,btnMenu), y+500, true);

		mWindow.setIconAction(btnWin, this, "win");
		mWindow.setIconAction(btnMenu,  this, "menu");		
	}
	
	public void init() {
		mWindow.hideIcon(result);
		result.setText("Du vann");
		click = 0;
	}
	
	public void win() {
		click++;
		switch(click) {
		case 1 : mWindow.showIcon(result); break;
		case 2 : result.setText("Du har redan vunnit!"); break;
		case 3 : result.setText("Klicka på 'Meny'!");
		}
	}
	
	private int centerIconHorizontal(int xLeft, int xRight, Icon icon) {
		return (xRight-xLeft-icon.getIconWidth()) / 2 + xLeft;
	}
	
	public void menu() {
		Sound sound = StartApp.getSound("/application/sound/click.mp3");
		if(sound!=null)
			sound.play();
		mController.menu();
	}
}
