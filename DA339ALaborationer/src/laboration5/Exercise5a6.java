package laboration5;

/**
 * Träna for-loop 
 * @author Rolf Axelsson
 */
public class Exercise5a6 
	{
    public void exercise5a2() 
    {
    	int start = 30, n=1;
        for( int i = 14 ; i >=10 ; i-- ) 
        {
        	if( i > n ) 
        	{
            System.out.print( start + " ");
        	} 
        	else 
        	{
        		System.out.print( start);
        	}
        	start -=5;
        }
    }

    public static void main(String[] args) 
    {
        Exercise5a6 e5a = new Exercise5a6();
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
