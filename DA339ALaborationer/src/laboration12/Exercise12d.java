package laboration12;

public class Exercise12d {
    public void increase(double[][] arr, double nbr) {

    }
    
    public int greaterThan(long[][] arr, long nbr) {
    	return 0;
    }
    
    public int sumInterval(int[][] arr, int min, int max) {
		return 0;
    }

    public double max(double[][] arr) {
		return 0;
    }
    
    public double min(double[][] arr) {
		return 0;
    }

    private void print(double[][] array, int width, int decimals) {
        for(double[] arr : array) {
            for(double elem : arr) {
                System.out.printf("%"+width+"."+decimals+"f",elem);
            }
            System.out.println();
        }        
    }
    
    public void exercise12d1() {
        double[][] array1 = {{2.3,6.1},{3.3,8.6},{5.4,5.2}};
        double[][] array2 = {{2.3,6.1,7.0,3.5},{3.3,8.6},{5.4,5.5,5.2}};
        increase(array1, 1.2);
        increase(array2, -1);
        print(array1,5,1);
        System.out.println();
        print(array2,5,1);
    }
    
    public void exercise12d2() {
        long[][] array1 = {{2,6},{3,8},{5,3}};
        long[][] array2 = {{2,6,7,3},{3,8},{5,5,4,7}};
        int count1 = greaterThan(array1, 4);
        int count2 = greaterThan(array2, 4);
        System.out.println("Greater than 4: array1="+count1+", array2="+count2);
    }
    
    public void exercise12d3() {
        int[][] array1 = {{2,6},{3,8},{5,3}};
        int[][] array2 = {{2,6,7,3},{3,8},{5,5,4,7}};
        int sum1 = sumInterval(array1, 3, 4);
        int sum2 = sumInterval(array2, 3, 7);
        System.out.println("sum1="+sum1+", sum2="+sum2);
    }
    
    public void exercise12d4() {
        double[][] array1 = {{2.3,6.1},{3.3,10.8},{5.4,5.2}};
        double[][] array2 = {{2.3,6.1,-7.0,3.5},{3.3,8.6},{5.4,5.5,-5.2}};
        double max1 = max(array1);
        double max2 = max(array2);
        System.out.println("max1="+max1+", max2="+max2);
    }
    
    public void exercise12d5() {
        double[][] array1 = {{2.3,-6.1},{3.3,10.8},{-5.4,5.2}};
        double[][] array2 = {{2.3,6.1,-7.0,3.5},{3.3,8.6},{5.4,5.5,-5.2}};
        double min1 = min(array1);
        double min2 = min(array2);
        System.out.println("min1="+min1+", min2="+min2);
    }
    
    public static void main(String[] args) {
        Exercise12d e12d = new Exercise12d();
        e12d.exercise12d1();
//        e12d.exercise12d2();
//        e12d.exercise12d3();
//        e12d.exercise12d4();
//        e12d.exercise12d5();
    }
}
