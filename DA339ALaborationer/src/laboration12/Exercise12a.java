package laboration12;

public class Exercise12a {

	public void program() {

		// läs in information från befolkning.txt och lagra informationen 
		// i en array av typen Population[].
		Population[] countries = Populations.readPopulations("files/befolkning.txt" );
		// Lösning till deluppgift 0, avmarkera efter testkörning

		int counter = 0;
		for(int i = 0; i < countries.length; i++ ) {

			long inhabitants = countries[i].getPopulation();
			if((inhabitants >= 1000000) && (inhabitants <= 12000000)) {
				counter++;
			}
		}
		Population[] newArray = new Population[counter];
		for(int i = 0; i < countries.length; i++ ) {
			long inhabitants = countries[i].getPopulation();

			if((inhabitants >= 10000000) && (inhabitants <= 12000000)) {
				int index = 0;
				newArray[index] = countries[i];
				index++;
			}
		}
		for(int i = 0; i < newArray.length; i++) {
			System.out.println( newArray[ i ].toString() );
		}
	}
	public static void main( String[] args ) {
		Exercise12a e12a = new Exercise12a();
		e12a.program();
	}
}