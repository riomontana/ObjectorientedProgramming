package p3;

import java.util.Random;

//Lösning inlämningsupgift P3
//Inlämnad av Linus Forsberg 26/10-2016

// Denna klass sköter datorspelaren och levererar nya val till klassen SSPController.

public class SSPPlayer {
	private Random rand = new Random(); // instansvariabel för slumpgenerator

	public int newChoice() { // metoden skapar slumpvärden för datorspelaren
		return rand.nextInt(3);
	}
}
