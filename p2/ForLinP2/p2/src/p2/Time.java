package p2;

import java.util.*;

/* Klassen inehåller lösningar på inlämningsuppgift 2b
 * @author Linus Forsberg den 13/10-2016
 * 
 * Klassen Time innehåller information om tid. */

public class Time {

	private int hour; // instansvariablerna i klassen representerar timme, minut och sekund
	private int minute;
	private int second;
	
	Calendar cal = Calendar.getInstance(); // skapar ett objekt som kan hämta tidssinformation ur paketet java.util
	
	public Time() { // konstruktorn instansierar ett nytt objekt av klassen Time

		hour = cal.get(Calendar.HOUR_OF_DAY); // för över aktuell information om tid till instansvariablerna
		minute = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND);
	}
	
	public int getHour() { // tar reda på värdet i instansvariabeln hour
		return hour;
	}
	
	public int getMinute() { 
		return minute;
	}
	
	public int getSecond() {
		return second;
	}

	
	public String toString() { // returnerar en sträng med den aktuella tiden i formen "TT:MM:SS"
		return this.hour + ":" + this.minute +":"+ this.second;
	}
	
	
	public void update() { // metoden skriver över de gamla värdena i instansvariablerna
		cal.setTime( new Date() ); 
		hour = cal.get(Calendar.HOUR_OF_DAY);
		minute = cal.get(Calendar.MINUTE);
		second = cal.get(Calendar.SECOND);
	}	
}

	
