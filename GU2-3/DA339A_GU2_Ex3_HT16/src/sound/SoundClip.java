package sound;

import javax.swing.JApplet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

/**
 * A class for playing a sound clip.
 */
public class SoundClip {
	private AudioClip clip;

	/**
     * Constructs a SoundClip object specified by the filename argument
     * @param filename giving the location of the clip
	 */
	public SoundClip(String filename) {
		try {
			URL url = new File(filename).toURI().toURL();
			clip = JApplet.newAudioClip(url);
		}catch(Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
     * Constructs a SoundClip object specified by the url argument
     * @param url giving the location of the clip
	 */
	public SoundClip(URL url) {
		try {
			clip = JApplet.newAudioClip(url);
		}catch(Exception e) {
			System.err.println(e.toString());
		}
	}

    /**
     * Begins to play the clip / resumes playback of a clip that is stoped.
     */
	public synchronized void start() {
		clip.play();
	}

    /**
     * Pauses playback of the clip.
     */
	public synchronized void stop() {
		clip.stop();
	}

    /**
     * Starts playing this clip in a loop.
     */
	public synchronized void loop() {
		clip.loop();
	}


	@Override
	protected void finalize() throws Throwable {
		if(clip!=null)
			clip.stop();
		super.finalize();
	}
//
//	public static void main(String[] args) {
//		SoundClip myclip = new SoundClip("sounds/airplane2.wav");
//		myclip.loop();
//	}
}
