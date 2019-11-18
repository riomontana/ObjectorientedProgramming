package laboration12;

/**
 * Klassen lagrar ett lands befolkning
 * @author Rolf
 */
public class Population {
    private String country;
    private long population;
    
    public Population( String country, long population ) {
        this.country = country;
        this.population = population;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public long getPopulation() {
        return this.population;
    }
    
    public String toString() {
        return String.format( "%-30s%15d", this.country, this.population );
    }
}