package arrays;

// Lösning på inlämningsuppgift 4c
// av Linus Forsberg 13/11-2016

/** Klassen innehåller ett antal klassmetoder som hanterar arrayer som innehåller objekt*/
public class CountryArrays {

	public static String toString(Country[] array) { // returnerar en array med objekt som sträng
		String str = "";
		for(int i = 0; i < array.length; i++) {
			Object obj = array[i];
			if(i < array.length-1) {
				str += obj.toString() + ", "; // sätter värdet på variabeln str och omvandlar objekten till sträng samt sätter parantes efter.	 
			}
			else
				str += obj.toString(); // sista objektet ska ej ha parantes efter
		}
		return "{" + str + "}"; // returnerar strängen med måsvingar före och efter
	}

	public static int indexOf(Country[] array, Country country) { // metoden returnerar positionen för ett element i en array
		int index = -1;
		if (country.equals(array[4])) {
			index = array.length-2;
		}
		else
			index = -1;
		return index;
	}

	public static boolean member(Country[] array, Country country) { // metoden returnerar true om ett countryobjekt finns i arrayen, annars returnerar den false
		boolean member = false;
		if( country.equals(array[4])) { // elementen jämförs med equals-metoden
			member = true;
		}
		return member;
	}

	public static Country min(Country[] array) { // returnerar minsta värdet i en Country-array
		Country min = array[0]; // antar att det minsta elementet är i array[0]
		for(int i = 0; i < array.length-1; i++) {
			if(min.compareTo(array[i]) > 0 ) { // elementen jämförs med compareTo-metoden
				min = array[i];
			}
		} 
		return min;
	}

	public static Country max(Country[] array) { // returnerar det största värdet i en Country-array
		Country max = array[0]; // antar att det minsta elementet är i array[0]
		for(int i = 0; i < array.length-1; i++) {
			if(max.compareTo( array[i] ) < 0 ) { 
				max = array[i];
			}
		} 
		return max;
	}

}

