package sound;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A class for playing a sound clip.
 */
public class Sound implements Runnable {
//	public final static Logger LOGGER = Logger.getLogger(Sound.class.getName());
	private static FileHandler textfile;
	private static SimpleFormatter textFormatter;
	
    private static RunOnThreadN runner = new RunOnThreadN(5);
    private SourceDataLine line;
    private AudioInputStream currentDecoded;
    private AudioInputStream encoded;
    private AudioFormat encodedFormat;
    private AudioFormat decodedFormat;
    private boolean started = false;
    private boolean stopped = false;
    private boolean paused = false;
    private final int BUFFERSIZE = 4096;
//    private final int BUFFERSIZE = 128;

    static {
        runner.start();
        System.out.println("Sound laddas");
//        LOGGER.setUseParentHandlers(false);
//        LOGGER.setLevel(Level.INFO);
        try {
			textfile = new FileHandler("Logging.txt");
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        textFormatter = new SimpleFormatter();
        textfile.setFormatter(textFormatter);
//        LOGGER.addHandler(textfile);
//        LOGGER.info("Redo att logga");
    }

    /**
     * Constructs a Sound object specified by the filename argument
     * @param filename giving the location of the sound file
     */
    public Sound(String filename) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
//    	LOGGER.info("utlStr="+filename);
        File file = new File(filename);
//        LOGGER.info("file="+file);
        encoded = AudioSystem.getAudioInputStream(file);
        encodedFormat = encoded.getFormat();
        decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,  // Encoding to use
                encodedFormat.getSampleRate(),           // sample rate (same as base format)
                16,               // sample size in bits (thx to Javazoom)
                encodedFormat.getChannels(),             // # of Channels
                encodedFormat.getChannels() * 2,           // Frame Size
                encodedFormat.getSampleRate(),           // Frame Rate
                false                 // Big Endian
        );
        currentDecoded = AudioSystem.getAudioInputStream(decodedFormat, encoded);
        line = AudioSystem.getSourceDataLine(decodedFormat);
        line.open(decodedFormat);
        setPaused(true);
        setStopped(false);
//        LOGGER.info("Sound-konstruktor slut");
    }

    /**
     * Constructs a Sound object specified by the url argument
     * @param url giving the location of the sound file
     */
    public Sound(URL url) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
//    	LOGGER.info("url="+url);
//        File file = new File(url);
//        LOGGER.info("file="+file);
        encoded = AudioSystem.getAudioInputStream(url);
        encodedFormat = encoded.getFormat();
        decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,  // Encoding to use
                encodedFormat.getSampleRate(),           // sample rate (same as base format)
                16,               // sample size in bits (thx to Javazoom)
                encodedFormat.getChannels(),             // # of Channels
                encodedFormat.getChannels() * 2,           // Frame Size
                encodedFormat.getSampleRate(),           // Frame Rate
                false                 // Big Endian
        );
        currentDecoded = AudioSystem.getAudioInputStream(decodedFormat, encoded);
        line = AudioSystem.getSourceDataLine(decodedFormat);
        line.open(decodedFormat);
        setPaused(true);
        setStopped(false);
//        LOGGER.info("Sound-konstruktor slut");
    }

    /**
     * Begins to play the sound / resumes playback of a sound that is paused. A sound can only be started once.
     */
    public synchronized void play() {
        if(!started) {
            runner.execute(this);
            started = true;
        }
        setPaused(false);
        notify();
    }

    /**
     * Stops playback of the sound.
     */
    public synchronized void stop() {
        setStopped(true);
        setPaused(false);
        notify();
    }

    /**
     * Pauses playback of the sound.
     */
    public synchronized void pause() {
        setPaused(true);
    }

    private boolean getStopped() {
        return stopped;
    }

    private void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    private boolean getPaused() {
        return paused;
    }

    private void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * Sets volume of a sound. the volume argument should be between 0 and 1.
     * @param volume
     */
    public void setVolume(double volume) {
        if (line.isOpen()) {
            volume = (volume <= 0.0) ? 0.0001 : ((volume > 1.0) ? 1.0 : volume);
            try {
                float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                ((FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN)).setValue(dB);
            } catch (Exception ex) {

            }
        }
    }

    public void run() {
        line.start();
        byte[] b = new byte[BUFFERSIZE];
        int i = 0;
        setStopped(false);
        setPaused(false);
        while (!getStopped()) {
            while (getPaused()) {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        setStopped(true);
                        setPaused(false);
                    }
                }
            }
            try {
                i = currentDecoded.read(b, 0, b.length);
                if (i == -1) {
                    setStopped(true);
                } else
                    line.write(b, 0, i);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        line.drain();
        line.stop();
        line.close();
        try {
            currentDecoded.close();
            encoded.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
