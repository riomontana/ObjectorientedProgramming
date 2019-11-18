package laboration7; /**
* Programmet använder ett objekt av typen Circle. Men på felaktigt sätt. * Rätta till felen i programmet.
* @author Rolf Axelsson
*/
public class CircleTest {
public static void main(String[] args) {
Circle c = new Circle (23.2);
//c.setRadius23,2; // setRadius eller initiera via konstruktor 
System.out.println( "CIRKEL med radie = " + c.getRadius() ); 
System.out.println( "CIRKEL med area = " + Math.PI * c.getRadius() * c.getRadius() );
//båda understrykningarna och lite till kan ersättas med area
c.setRadius(c.getRadius() + 5.7); // setRadius och getRadius, 1 el 2 rader med kod 
System.out.println( "CIRCLE, radius = " + c.getRadius() );
System.out.println( c.toString() );
// toString
} }