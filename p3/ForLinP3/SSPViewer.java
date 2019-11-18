package p3;

import java.awt.*;
import javax.swing.*;

//Lösning inlämningsupgift P3
//Inlämnad av Linus Forsberg 26/10-2016

// Klass som beskriver ett fönster som visar information om spelet,
// hur många poäng spelarna har samt vem som vunnit

public class SSPViewer extends JPanel { // Klassen ärver JPanel som används för att skapa fönstret

	private JLabel lblBigInfo = new JLabel("Först till 3 vinner!", JLabel.CENTER); // instansvariabler för informationen som ska visas i fönstret
	private JLabel lblHuman = new JLabel("Human", JLabel.CENTER); // bl.a hur många poäng spelarna har, vilket val de gjort och vem som vunnit
	private JLabel lblComputer = new JLabel("Computer", JLabel.CENTER);
	private JLabel lblHumanScore = new JLabel("0", JLabel.CENTER);
	private JLabel lblComputerScore = new JLabel("0", JLabel.CENTER);
	private JLabel lblHumanChoice = new JLabel("-", JLabel.CENTER);
	private JLabel lblComputerChoice = new JLabel("-", JLabel.CENTER);
	private Font font = new Font("TimesNewRoman", Font.BOLD, 15);


	public SSPViewer() { // Konstruktor som skapar ny instans av klassen.
//		lägger till informationen om spelet och var informationen är placerad i fönstret

		setPreferredSize( new Dimension(300 , 130)); // anger hur stort fönstret ska vara

		lblBigInfo.setPreferredSize(new Dimension(250, 20)); // anger hur stora "etiketterna" ska vara
		lblBigInfo.setFont(font);
		lblHuman.setPreferredSize(new Dimension(100, 30));
		lblComputer.setPreferredSize(new Dimension(100, 30));
		lblHumanScore.setPreferredSize(new Dimension(100, 30));
		lblComputerScore.setPreferredSize(new Dimension(100, 30));
		lblHumanChoice.setPreferredSize(new Dimension(100, 30));
		lblComputerChoice.setPreferredSize(new Dimension(100, 30));

		add(lblBigInfo); // lägger till "etiketterna"
		add(lblHuman);
		add(lblComputer);
		add(lblHumanScore);
		add(lblComputerScore);
		add(lblHumanChoice);
		add(lblComputerChoice);

	}

	public void setlblHumanChoice(String lblHumanChoice) { // metoden uppdaterar informationen om vilket val spelaren gör och visar det i viewerfönstret
		this.lblHumanChoice.setText(lblHumanChoice);
	}

	public void setlblComputerChoice(String lblComputerChoise) { // uppdaterar info om vilket val datorn gör
		this.lblComputerChoice.setText(lblComputerChoise);
	}

	public void setlblHumanScore(String lblHumanScore) { // uppdaterar användarens poängställning
		this.lblHumanScore.setText(lblHumanScore);
	}

	public void setlblComputerScore(String lblComputerScore) { // uppdaterar datorns poängställning
		this.lblComputerScore.setText(lblComputerScore);
	}

	public void setlblBigInfo(String lblBigInfo) { // uppdaterar spelinformationen till vem som vunnit spelet
		this.lblBigInfo.setText(lblBigInfo);
	}

}

