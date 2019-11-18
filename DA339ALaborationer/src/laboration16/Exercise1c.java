package laboration16; 
import resources.InOut;
public class Exercise1c {
	public static void main( String[] args ) {
		InOut io = new InOut();
		double tal = io.readDouble(”Mata in ett decimaltal mindre än 10.0”);
		System.out.println( "Inmatat tal: " + tal );

	}
}