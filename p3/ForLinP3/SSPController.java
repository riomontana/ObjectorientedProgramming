package p3;

import javax.swing.JPanel;

//Lösning inlämningsupgift P3
//Inlämnad av Linus Forsberg 26/10-2016

//Den här klassen sköter själva spelet
//ordnar med nytt spel
//jämför spelarens val med datorns val och delar ut poäng
//avslutar spelet då en spelare nått 3 poäng
//dimmar knapparna för sten sax och påse när spelet tagit slut

public class SSPController extends JPanel {

	private SSPViewer viewer; // instansvariabler
	private SSPPlayer player;
	private SSPUserInput userInput;
	private int humanScore = 0;
	private int computerScore = 0;


	public SSPController(SSPPlayer player, SSPViewer viewer) { // konstruktor för klassen
		this.viewer = viewer;
		this.player = player;

	}

	public void initGame() { // metod som skapar ett nytt spel vid klick på "nytt spel" knappen
		this.humanScore = 0; // raderna nedan nollställer alla variabler för nytt spel
		this.computerScore = 0;
		userInput.enableButtons();
		viewer.setlblBigInfo("Först till 3 vinner!");
		viewer.setlblComputerScore("0");
		viewer.setlblHumanScore("0");
		viewer.setlblComputerChoice("");
		viewer.setlblHumanChoice("");
	}

	public void game(int userChoice) { // metod för spelets logik. 
		int computerChoice = player.newChoice(); // sätter värdet för datorns val som den hämtar från SSPPlayer klassen.

		if(userChoice == 0) { // kommande sex if-satser används för att skriva över värdet i viewerfönstret beroende på vilka val spelarna gör (STEN, SAX, PÅSE) 
			viewer.setlblHumanChoice("STEN!");
		}

		if(userChoice == 1) {
			viewer.setlblHumanChoice("SAX!");
		}

		if(userChoice == 2) {
			viewer.setlblHumanChoice("PÅSE!");
		}

		if(computerChoice == 0) {
			viewer.setlblComputerChoice("STEN");
		}

		if(computerChoice == 1) {
			viewer.setlblComputerChoice("SAX");
		}

		if(computerChoice == 2) {
			viewer.setlblComputerChoice("PÅSE");
		}	

		if (userChoice == computerChoice) { // om datorn väljer samma som användaren händer ingenting

		}
		else if (userChoice == 0 && computerChoice == 1 || userChoice == 1 && computerChoice == 2 || userChoice == 2 && computerChoice == 0) {
			this.humanScore++; // denna sats ger användaren 1 poäng om den väljer rätt i förhållande till datorn
			viewer.setlblHumanScore(String.valueOf(this.humanScore)); // när användare får poäng uppdateras siffran i viewer-fönstret och översätter värdet till en sträng
		}
		else { // om inte användaren får poäng eller väljer samma som datorn får datorn ett poäng.
			this.computerScore++;
			viewer.setlblComputerScore(String.valueOf(this.computerScore)); // även när datorn får poäng uppdateras detta i viewer-fönstret.
		}


		if (humanScore == 3) { // om användaren når först till 3 poäng visas texten "DU VANN!!!" i viewer-fönstret
			viewer.setlblBigInfo(" DU VANN!!!"); 
			userInput.disableButtons(); // knapparna sten, sax, påse dimmas så de inte går att trycka på
		}

		if (computerScore == 3) { // om datorn når först till 3 poäng visas texten "DU FÖRLORADE!!!" i viewer-fönstret
			viewer.setlblBigInfo(" DU FÖRLORADE!!!");
			userInput.disableButtons(); // knapparna sten, sax, påse dimmas så de inte går att trycka på
		}


	}

	public void setUserInput(SSPUserInput userInput) { // Används för att dimma knapparna. uppdaterar userInput objektet i controller klassen med den förändrade userInput klassen
		this.userInput = userInput; 

	}

}

