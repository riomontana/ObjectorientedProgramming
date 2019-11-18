package laboration2;

public class Program2g {

    public void country() {
        System.out.println("Land: Sverige");
    }

    public void residents() {
        System.out.println("Ca 9 miljoner invånare");
    }

    public void bigCities() {
        System.out.println("Tre stora städer:");
        System.out.println("Stockholm");
        System.out.println("Göteborg");
        System.out.println("Malmö");
    }

    public static void main( String[] args ) {
    	Program2g p2g = new Program2g();
    	p2g.country();
    	p2g.residents();
    	p2g.bigCities();
    }
}
