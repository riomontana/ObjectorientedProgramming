//********************************************************************
//  AverageOfThree.java        Java Foundations
//
//  Solution to Programming Project 2.2 	
//********************************************************************
package laboration2;
import java.util.Scanner;

public class AverageOfThree
{
   //-----------------------------------------------------------------
   //  Reads three integers from the user and prints their average.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int num1, num2, num3;
      double average;
	Scanner scan = new Scanner (System.in);

      System.out.print ("Enter the first number: ");
      num1 = scan.nextInt();
      System.out.print ("Enter the second number: ");
      num2 = scan.nextInt();
      System.out.print ("Enter the third number: ");
      num3 = scan.nextInt();

      average = (double) (num1+num2+num3) / 3;

      System.out.println ("The average is: " + average);
   }
}
