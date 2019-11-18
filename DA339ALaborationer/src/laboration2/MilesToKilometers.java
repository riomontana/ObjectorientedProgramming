//********************************************************************
//  MilesToKilometers.java       Java Foundations
//
//  Solution to Programming Project 2.5
//********************************************************************

package laboration2;

import java.util.Scanner;

public class MilesToKilometers
{
   //-----------------------------------------------------------------
   //  Converts miles into kilometers. The value for miles is read
   //  from the user.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      final double MILES_PER_KILOMETER = 1.60935;

      double miles, kilometers;

	Scanner scan = new Scanner(System.in);

      System.out.print ("Enter the distance in miles: ");
      miles = scan.nextDouble();

      kilometers = MILES_PER_KILOMETER * miles;

      System.out.println ("That distance in kilometers is: " +
                          kilometers);
   }
}
