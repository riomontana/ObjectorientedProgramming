package p2;

import java.util.Random;
import javax.swing.ImageIcon;
import gu2.PaintWindow_GU2;
import paintpanel.Sound;

/* Klassen inehåller lösningar på inlämningsuppgift 2c
 * @author Linus Forsberg den 13/10-2016
 * 
 * Programmet simulerar en tävling mellan två bilar. */

public class Race {

	private PaintWindow_GU2 window;
	private Car c1;
	private Car c2;

	public Race(PaintWindow_GU2 window, Car c1, Car c2) {  // skapar en ny instans av klassen Race
		this.window = window;
		this.c1 = c1;
		this.c2 = c2;
	}


	public void action() { // när denna metod anropas startar racet
		int width = window.getBackgroundWidth();
		int posx1 = width; 
		int posy1 = 195;
		int posx2 = width;
		int posy2 = 152;

		ImageIcon count = new ImageIcon("images/321.gif"); // deklarerar bilderna och gifarna som används
		ImageIcon backG = new ImageIcon("images/racingBackground.jpg");
		ImageIcon fast = new ImageIcon("images/fast.gif");
		ImageIcon explosion = new ImageIcon("images/explosion.gif-c200");
		ImageIcon end = new ImageIcon("images/end.gif");

		window.addIcon(count, 0, 0, true); 
		
		Sound sound = null; // lägger till ljud till nedräkning
		try {
			sound = new Sound("sounds/count.wav");
		} catch (Exception e) {}

		if(sound!=null) { 
			sound.play();
		}
		
		PaintWindow_GU2.pause(3000); // Pause på några sekunder för nedräkningen
		
		window.addIcon(backG, 0 , 0 , true); // bakgrund
		window.addIcon(fast, 150 , 300 , true); // vin diesel
		window.addIcon(c1.getImage(), posx1 , posy1 , true); // bil1
		window.addIcon(c2.getImage(), posx2 , posy2 , true); // bil2
	
		try { // lägger till ljud till bilarna
			sound = new Sound("sounds/v8.wav");
		} catch (Exception e) {}

		if(sound!=null) { 
			sound.play();
		}

		Random rand = new Random(); // används för att ge slumpmässiga värden för hur bilarna rör sig
		
		while( posx1 >= 0  && posx2 >= 0 ) { // den här loopen får bilarna att röra sig från höger till vänster
			window.setIconXY(c1.getImage(), c1.getX(), c1.getY());
			window.setIconXY(c2.getImage(), c2.getX(), c2.getY());
			posx1 -= rand.nextInt(10); // bilarna tilldelas slumpvärden  hur snabbt de rör sig på x-axeln
			posx2 -= rand.nextInt(10);
			c1.moveTo(posx1, posy1);
			c2.moveTo(posx2, posy2);
			PaintWindow_GU2.pause(20); // bilden uppdateras var 20 millisekund
		}

		sound.stop(); // när en av bilarna nått mål avslutas motorljudet och bilarna sprängs med ljudeffekt

		window.addIcon(end, 100, 300, true); 
												
		window.addIcon(explosion, -40 , 80 , true);
		try {
			sound = new Sound("sounds/explosion.wav");
		} catch (Exception e) {}

		if(sound!=null) { sound.play();
		}
	}
}
