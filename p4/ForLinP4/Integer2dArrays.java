package arrays;

// Lösning på inlämningsuppgift 4b
// av Linus Forsberg 13/11-2016

/** Klassen innehåller ett antal klassmetoder som hanterar tvådimensionella arrayer*/
public class Integer2dArrays {

	public static String toString(int[][]array) { // metoden returnerar en tvådimensionell heltalsarray som en sträng
		String str = "{"; // strängen börjar med en måsvinge
		for(int row = 0; row < array.length; row++) { // for-loopen går igenom alla element i arrayen
			str += "{";
			for(int col = 0; col < array[row].length; col++) { // då det är en array i en array behövs en nestad for-loop
				if(col < array[row].length-1) { // kommatecken efter varje element utom det sista i varje inre array
					str += array[row][col] + ",";
				}
				else
					str += array[row][col]; // sista elementet i varje inre array ska ej ha kommatecken efter
			}
			if(row < array.length-1) { // lägger till måsvinge med kommatecken efter varje inre array förutom den sista arrayen
				str += "},";
			}
			else	str += "}"; // lägger till måsvinge i strängen
		}
		return str + "}"; // returnerar strängen
	}	

	public static int elements(int[][] array) { // metoden returnerar antalet element i en tvådimensionell array 
		int elem = 0; // sätter räknare till noll
		for (int i = 0; i < array.length; i++) { // loopen går igenom alla element i arrayen och lägger till antalet i variabeln elem
			elem += array[i].length;
			if (elem < array[i].length) {
				elem = array[i].length;
			}
		}
		return elem; // returnerar antalet element i arrayen
	}

	public static int max(int[][] array) { // metoden returnerar högsta värdet från en tvådimensionell array
		int max = -Integer.MAX_VALUE; 
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				if(array[row][col] > max) {
					max = array[row][col];
				}
			}
		}
		return max;
	}

	public static int min(int[][] array) { // metoden returnerar lägsta värdet från en tvådimensionell array
		int min = Integer.MAX_VALUE;
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				if(array[row][col] < min) {
					min = array[row][col];
				}
			}
		}
		return min;
	}

	public static int sum(int[][] array) { // returnerar summan av alla element i en tvådimensionell array
		int sum = 0;
		for(int[] row : array) { // när man ska gå igenom alla värden i en array kan man använda sig av förenklad for-loop
			for(int elem : row) {
				sum += elem;
			} 
		}
		return sum; 
	}

	public static double average(int[][] array) { // metod som returnerar medelvärdet av en tvådimensionell array som ett flyttal
		int sum = 0; // två variabler används. den ena ska innehålla summan av arrayen och den andra antalet element i arrayen
		int elem = 0;
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				sum += array[row][col];
				elem++;
			}
		}
		return (double) sum / elem; // returnerar summan av arrayen delat på antalet element
	}
}


