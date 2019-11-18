package arrays;

// Lösning för inlämningsuppgift 4a
// av Linus Forsberg 13/11 - 2016


/** Klassen innehåller ett antal klassmetoder som hanterar endimensionella arrayer*/
public class IntegerArrays {

	public static String toString(int[] array) { // Metoden returnerar en heltals-array som en sträng.
		String str = "{";
		for(int i = 0; i < array.length; i++) { // for-loopen går igenom elementen i arrayen
			if(i < array.length-1) { // om räknaren är mindre än arrayens längd - 1
				str += array[i] + ",";  // läggs värdena från arrayen in i strängen med kommatecken efter
			}
			else // sista värdet ska inte ha kommatecken efter
				str += array[i];
		}
		return str + "}"; // returnerar strängen
	}

	public static int max(int[] array) { // Metoden returnerar största värdet i en array
		int maxValue = 0; // sätter räknare till 0
		for(int i = 0; i < array.length; i++) { // loopen går igenom alla elementen i arrayen och tar reda på det största värdet
			if(maxValue < array[i]) {
				maxValue = array[i];
			}	
		}
		return maxValue; // returnerar största värdet
	}

	public static int min(int[] array) { // Metoden returnerar minsta värdet i en array
		int minValue = array[0]; 
		for (int i = 1; i < array.length; i++) { //  loopen går igenom alla elementen i arrayen och tar reda på det minsta värdet
			if (array[i] < minValue) {
				minValue = array[i];
			}
		}
		return minValue; // returnerar minsta värdet
	}

	public static int sum(int[] array) { // Metoden returnerar summan av en array
		int sum = 0;
		for(int i = 0; i < array.length; i++) { // räknar ut summan av array
			sum += array[i];
		}
		return sum; // returnerar summan av arrayen
	}

	public static double average(int[] array) { // Metod som returnerar medelvärdet från en array i formen av ett flyttal
		int sum = sum(array);
		return (double) sum / array.length; // medelvärdet är summan av värdena i arrayen delat på antalet element i arrayen.
	}


	public static int range(int[] array) { // Metoden returnerar skillnaden mellan lägsta och högsta talet i en array
		int max = 0; // instansvariabel för maxvärde
		int min = array[0]; // instansvariabel för minsta värde
		for(int i = 0; i < array.length; i++) { // räknar ut största värdet
			if(max < array[i]) {
				max = array[i];
			}	
		}
		for (int i = 1; i < array.length; i++) { // räknar ut minsta värdet
			if (array[i] < min) {
				min = array[i];
			}
		}
		return max - min; // returnerar högsta värdet minus lägsta värdet
	}

	public static int sortAsc(int[] array) { // sorterar arrayen från lägsta värde till högsta värde
		int temp = 0; 
		for (int i = 0; i < array.length; i++) { // loopen går igenom alla element och placerar dem i storleksordning från lägst till högst
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return temp;
	}

	public static int sortDesc(int[] array) { // sorterar arrayen från högsta till lägsta värdet
		int temp = 0; 
		for (int i = 0; i < array.length; i++) { // loopen går igenom alla element och placerar dem i storleksordning från högst till lägst
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return temp; // returnerar värden från arrayen sorterat från högsta till lägsta värde
	}

	public static int[] copy(int[] array) { // skapar en kopia av arrayen
		int[] copyArray = new int[array.length]; // skapar en ny array
		for(int i = 0; i < array.length; i++) {
			copyArray[i] = array[i]; // lägger in värdena från arrayen i en ny array
		}
		return copyArray; // returnerar kopian på arrayen
	}
}
