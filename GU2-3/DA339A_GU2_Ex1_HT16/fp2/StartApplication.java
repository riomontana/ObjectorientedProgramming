package fp2;
import java.net.URL;

import javax.swing.ImageIcon;

import paintpanel.Sound;
import paintpanel.SoundClip;

public class StartApplication {
    public static void main(String[] args) {
        ImageIcon head1Clean = StartApplication.getImageIcon("/images/blueClean.png");
        ImageIcon head1Sticky = StartApplication.getImageIcon("/images/blueSticky.png");
        ImageIcon head2Clean = StartApplication.getImageIcon("/images/redClean.png");
        ImageIcon head2Sticky = StartApplication.getImageIcon("/images/redSticky.png");
        ImageIcon cakeImage = StartApplication.getImageIcon("/images/cake.png");
        
        Head head1 = new Head(head1Clean, head1Sticky);
        Head head2 = new Head(head2Clean, head2Sticky);
        Cake cake = new Cake(cakeImage);
        
        Game game = new Game(head1, head2, cake);
    }
    
	public static ImageIcon getImageIcon(String filename) {
		ImageIcon icon = null;
		URL url = StartApplication.class.getResource(filename);
		if(url != null) {
		    icon = new ImageIcon(url);
		}
		return icon;
	}
	
	public static Sound getSound(String filename) {
		Sound sound = null;
		System.out.println(filename);
		URL url = StartApplication.class.getResource(filename);
		try {
		    sound = new Sound(url);
		} catch(Exception e) {
			System.out.println("getSound: "+e.toString());
		}
		return sound;
	}
	
	public static SoundClip getSoundClip(String filename) {
		SoundClip clip = null;
		URL url = StartApplication.class.getResource(filename);
		try {
		    clip = new SoundClip(url);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return clip;
	}
}
