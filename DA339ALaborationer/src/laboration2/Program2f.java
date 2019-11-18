package laboration2;

public class Program2f {

    public void club() {
        System.out.println("Klubbens namn är Landskrona BOIS.");
    }

    public void supporter() {
        System.out.println("BOIS är bäst.");
    }

    public void league() {
        System.out.println("Klubben ligger i Div 1 Södra");
    }

    public void coach() {
        System.out.println("Tränare är Zvezdan Milošević");
    }

    public void expert() {
        System.out.println("Det blir nog Superettan nästa år");
    }

    public static void main(String[] args) {
        Program2f p2f = new Program2f();
        p2f.club();
        p2f.coach();
        p2f.league();
        p2f.supporter();
        p2f.expert(); 
    }
}
