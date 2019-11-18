package app;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import sound.Sound;
import sound.SoundClip;

public class StartApp {
	public static ImageIcon getImageIcon(String filename) {
		ImageIcon icon = null;
		URL url = StartApp.class.getResource(filename);
		if(url != null) {
			System.out.println("getImageicon: url="+url);
		    icon = new ImageIcon(url);
			System.out.println("getImageicon: image="+icon.getImage());
		} else {
			System.out.println("getImageicon: url=null");
		}
		return icon;
	}
	
	public static Sound getSound(String filename) {
		Sound sound = null;
		System.out.println(filename);
		URL url = StartApp.class.getResource(filename);
		try {
		    sound = new Sound(url);
		} catch(Exception e) {
			System.out.println("getSound: "+e.toString());
		}
		return sound;
	}
	
	public static SoundClip getSoundClip(String filename) {
		SoundClip clip = null;
		URL url = StartApp.class.getResource(filename);
		try {
		    clip = new SoundClip(url);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return clip;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Sound and Image demo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				frame.add(new SoundAndImagePanel("/images/sommar.jpg","/sound/chimes.wav","/sound/gong.au"));
				frame.add(new SoundAndImagePanel("/images/sommar.jpg","/sound/click.mp3","/sound/gong.au"));
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}
