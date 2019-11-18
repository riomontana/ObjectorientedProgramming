package p1;
import gu1.PaintWindow_GU1;

import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/************************************************************
 * Klassen inehåller lösningar på inlämningsuppgift 1a - 1f *
 * @author Linus Forsberg den 21/9-2016                     *
 ************************************************************/

public class Exercise1 {

	/****************************************************************
	 * Metoden beräknar totala biljettpriset och det genomsnittliga *
	 * biljettpriset för ett antal vuxna, barn och pensionärer.     *
	 ****************************************************************/
	
	public void exercise1a() {

		// Deklarerar de olika variablerna i programmet
		
		int vuxen, barn, gammal, antalPers, totalPris, genomsnittPris;

		
		// Visar 3 fönster efter varandra där användaren matar in information
		
		vuxen = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet vuxna:"));
		barn = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet barn:"));
		gammal = Integer.parseInt(JOptionPane.showInputDialog("Ange antalet pensionärer:"));

		
		// Räknar ut antalet personer, totalpriset samt genomsnittspriset per person
		
		antalPers = vuxen + barn + gammal;
		totalPris = vuxen * 110 + barn * 60 + gammal * 80;
		genomsnittPris = totalPris / antalPers ;

		
		// Visar ett meddelandefönster med totalpris samt genomsnittspris
		
		JOptionPane.showMessageDialog(null, "Totalt pris är:" + " " + totalPris + "\n"
				+ "Genomsnittspris är:" + " " + genomsnittPris);

	}

	/******************************************************
	 * Metoden skriver ut alla udda tal mellan 1 till 100 *
	 ******************************************************/
	
	public void exercise1b() {

		// Loop som skriver ut alla udda tal mellan 1-100 i konsollen
		
		for(int udda = 1; udda <= 99; udda += 2) {
			System.out.print(udda + " ");
		}
	}

	/******************************************************************************************************************
	 * Metoden frågar användaren efter ett heltal och skriver därefter ut om talet var positivt, negativt eller noll. *
	 * När programmet har frågat efter heltal fyra gånger avslutas det.												  *
	 ******************************************************************************************************************/
	
	public void exercise1c() {

		// Loopen skapar ett fönster som frågar användaren efter ett heltal. När 4 tal matats in avslutas programmet.

		for(int t = 0; t < 4; t ++) {
			int heltal = Integer.parseInt(JOptionPane.showInputDialog("Ange ett heltal:"));

			
			// Skriver ut om talen är positiva, negativa eller noll

			if(heltal > 0) {
				System.out.println("Talet " + heltal + " är positivt");
			}
			if(heltal < 0) {
				System.out.println("Talet " + heltal + " är negativt");
			}	
			if(heltal == 0) {
				System.out.println("Talet " + heltal + " är noll");
			}
		}
	}

	/**************************************************************************************
	 * Metoden ber användaren att mata in ett minsta värde och därefter ett högsta värde. *
	 * Efter det skriver den ut vart sjunde tal inom intervallet.						  *
	 **************************************************************************************/
	
	public void exercise1d() {

		//Deklarerar variablerna i programmet
		
		int min, max, m;
		
		
		// Visar ett fönster där användare matar in ett minsta värde (heltal)
		// Därefter visas ett fönster till där användare matar in ett högsta värde (heltal)

		min = Integer.parseInt(JOptionPane.showInputDialog("Ange minsta värdet: "));
		max = Integer.parseInt(JOptionPane.showInputDialog("Ange största värdet: "));

		
		// Skriver ut vart sjunde tal mellan intervallen som angivits av användaren.
		// loopen bryts när minsta talet som angivits blir större än högsta talet som angivits
		
		m = min;
		while(m <= max) {
			System.out.print(min);
			min += 7;

			if(min > max)
				break;
			
			System.out.print(", ");
		
		}
	}

	/*****************************************************************************************************************
	 * Metoden visar ett fönster med hjälp av biblioteket PaintWindow_GU1.											 *
	 * I detta fönster visas sedan en gubbe som rör sig i sidled från höger till vänster.							 *
	 * När gubben når ena kanten studsar den tillbaka åt andra hållet och vice versa fram och tillbaka i oändlighet. *
	 *****************************************************************************************************************/
	
	public void exercise1e() {
	
		// Visar ett vitt fönster med en bild på en gubbe som rör sig i sidled
		
		Random rand = new Random();
		ImageIcon image = new ImageIcon("images/gubbe.jpg");
		PaintWindow_GU1.showWindow(600, 400, "P1", Color.WHITE);
		int height = PaintWindow_GU1.getBackgroundHeight();
		int dx = -3;  // gubbens startpositioner
		int dy = 0;
		int x = 100;
		int y = rand.nextInt(height-100);  // ger gubbens startposition olika värden i höjdled varje gång programmet körs
		PaintWindow_GU1.addIcon("Gubbe", image, 250, y, true);

		// oändlig loop, raderna 145-151 upprepas tills PaintWindow-fönstret stängs
		while(true) {
			PaintWindow_GU1.setIconXY("Gubbe",x,y);
			PaintWindow_GU1.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
			x += dx;
			y += dy;
			if(x<0 || x>500) { // när bilden rört sig till ena kanten studsar den tillbaka åt andra hållet
				dx = -dx;		

				}
			}
		}

	
	/**************************************************************************************************************
	 * Denna gör samma sak som excercise1e men med skillnaden att den även rör sig uppåt och neråt samtidigt. 	  *
	 * Rörelsen får även nya koordinater som den följer varje gång den exekveras								  *
	 **************************************************************************************************************/

	 public void exercise1f() {
			Random rand = new Random();
			ImageIcon image = new ImageIcon("images/gubbe.jpg");
			PaintWindow_GU1.showWindow(600, 400, "P1", Color.WHITE);
			int width = PaintWindow_GU1.getBackgroundWidth();
			int height = PaintWindow_GU1.getBackgroundHeight();
			int dx = rand.nextInt(7) -3;  // Ger olika startpositioner för gubben varje gång programmet körs
			int dy = rand.nextInt(7) -3;  // både höjdled och sidled har random intervaller.
			int x = rand.nextInt(width-500);
			int y = rand.nextInt(height-100);  
			PaintWindow_GU1.addIcon("Gubbe", image, x, y, true);

			// oändlig loop, raderna 176-185 upprepas tills PaintWindow-fönstret stängs
			while(true) {
				PaintWindow_GU1.setIconXY("Gubbe",x,y);
				PaintWindow_GU1.pause(20); // pausa exekveringen i 20 ms innan nästa förflyttning
				x += dx;
				y += dy;
				if(x<0 || x>500) { // när bilden rört sig till ena kanten studsar den tillbaka åt andra hållet
					dx = -dx;		
				}
				if(y<0 || y>300) {
					dy = -dy;		
				}
			}
	 	}
	}