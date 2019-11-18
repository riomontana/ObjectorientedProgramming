package laboration2;

public class Program2c {
    public void message() {
        String mess1 = "***********************************";
        String mess2 = "*          Landskrona IP          *";
        String mess3 = "*          14/9 kl 15.00          *";
        String mess4 = "*          FOTBOLLSMATCH          *";
        String mess5 = "*    Landskrona BOIS - Hammarby   *";
        System.out.println( mess1 );       
        System.out.println( mess5 );
        System.out.println( mess4 );
        System.out.println( mess3 );
        System.out.println( mess2 );
        System.out.println( mess1 );

    }

    public static void main(String[] args) {
    	Program2c prog = new Program2c();
    	prog.message();
    	}
}