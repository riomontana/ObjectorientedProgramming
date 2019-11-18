package laboration5;

/**
 * Träna for-loop 
 * @author Rolf Axelsson
 */
public class Exercise5a5 
	{
    public void exercise5a2() 
    {
    	int start = 0, n=5;
        for( int i = 1 ; i <=n ; i++ ) 
        {
        	if( i < n ) 
        	{
            System.out.print( start + " ");
        	} 
        	else 
        	{
        		System.out.print( start);
        	}
        	start +=2;
        }
    }

    public static void main(String[] args) 
    {
        Exercise5a5 e5a = new Exercise5a5();
        e5a.exercise5a2();
//        System.out.println();
//        e5a.exercise5a1();
//        System.out.println();
//        e5a.exercise5a2();
//        System.out.println();
//        e5a.exercise5a3();
//        System.out.println();
//        e5a.exercise5a4();
//        System.out.println();
//        e5a.exercise5a5();
//        System.out.println();
//        e5a.exercise5a6();
    }
}
