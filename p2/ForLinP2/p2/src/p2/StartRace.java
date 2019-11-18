package p2;

import java.awt.Color;

import gu2.PaintWindow_GU2;

import javax.swing.ImageIcon;

/**
 * Klassen startar programmet Race
 * @author TSROAX
 */
public class StartRace { // /Volumes/Home/TSROAX/
    public static void main(String[] args) { 
        PaintWindow_GU2 window = new PaintWindow_GU2(800,600,"P2",Color.GREEN);
        Car c1 = new Car(new ImageIcon("images/CarBlue.GIF"));
        Car c2 = new Car(new ImageIcon("images/CarRed.GIF"));
        Race race = new Race(window,c1,c2);
        race.action();
        // Kod för bättre funktion i programmet TestP2
        if(args.length>0) {
            PaintWindow_GU2.pause(2000);
            window.dispose();
        }
    }
}
