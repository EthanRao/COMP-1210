import java.util.Scanner;

/**
* Perform calculations based on the input user information.
* Based on the two coordinates output midpoint
*
* @author Xi Rao
* @version 9/5/2018
*/
public class MidpointOfLineSegment
{
/**
* Allows the user input two endpoints an output of
* midpoint, based off coordinate, prints to 
* midpoint coordinate.
*
* @param args Command line arguments (not used)
*/
   public static void main(String[] args)
   {
      double x1 = 0;
      double y1 = 0;
      double x2 = 0; 
      double y2 = 0;
      double xMid = 0;
      double yMid = 0;
   
      Scanner userInput = new Scanner(System.in);
      System.out.println("Enter the coordinates for endpoint 1:");
      //Input point1 abscissa
      System.out.print("\tx1 = ");
      x1 = userInput.nextDouble();
      //Input point1 ordinate
      System.out.print("\ty1 = ");
      y1 = userInput.nextDouble();
   
      System.out.println("Enter the coordinates for endpoint 2:");
      //Input point2 abscissa 
      System.out.print("\tx2 = ");
      x2 = userInput.nextDouble();
      //Input point2 ordinate
      System.out.print("\ty2 = ");
      y2 = userInput.nextDouble();
      System.out.println("");
      // Calculate the coordinates into midpoint
      xMid = (double) (x1 + x2) / 2;
      yMid = (double) (y1 + y2) / 2;
    
      //Output midpoint
      System.out.println("For endpoints (" + x1 + ", " + y1 + ") and ("
         					+ x2 + ", " + y2 + "), the midpoint is (" 
                        + xMid + ", " + yMid + ").");
   }
}
