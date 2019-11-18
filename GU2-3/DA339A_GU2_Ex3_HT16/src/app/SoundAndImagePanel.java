package app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sound.Sound;
import sound.SoundClip;

public class SoundAndImagePanel extends JPanel {
	private JLabel lblImage = new JLabel();
	private JButton btnSound = new JButton("Spela Sound");
	private JButton btnSoundClip = new JButton("Spela SoundClip");
	private String soundFilename;
	private SoundClip clip;
	
	public SoundAndImagePanel(String imageFilename, String soundFilename, String soundClipFilename) {
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		ImageIcon image = StartApp.getImageIcon(imageFilename);
		setLayout(new BorderLayout());
		
		lblImage.setIcon(image);
		buttonPanel.add(btnSound);
		buttonPanel.add(btnSoundClip);
		add(lblImage,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		btnSound.addActionListener(new ButtonListener());
		btnSoundClip.addActionListener(new ButtonListener());

		this.soundFilename = soundFilename;
		clip = StartApp.getSoundClip(soundClipFilename);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnSound) {
				Sound sound = StartApp.getSound(soundFilename);
				if(sound!=null)
					sound.play();
			} else if(e.getSource()==btnSoundClip) {
				clip.start();
			}
		}
	}
}
