import java.util.Scanner;
import java.text.DecimalFormat;

/**
* Perform calculations based on the input user information.
* based on the two coordinates output midpoint
*
* @author Xi Rao
* @version 9/12/2018
*/
public class FormulaEval
{
/**
* Allows the user to input two endpoints
* an output of midpoint,
* based off coordinate, prints to midpoint coordinate.
*
* @param args Command line arguments (not used)
*/
   public static void main(String[] args)
   {
      double x;
      double result;
      Scanner userInput = new Scanner(System.in);
     
      //Input seconds
      System.out.print("Enter a value for x: ");
      x = Double.parseDouble(userInput.nextLine());
      
      //The calculation results.
      result = (1000 * x + Math.sqrt(Math.abs(
               (3.9 * Math.pow(x, 5)) - Math.pow(x, 3) + 1)))
               / (
               1.6 * Math.pow(x, 2) + 2.7 * x + 3.8
               );
               
      System.out.println("Result: " + result);
      
      // Double result --> String Result
      String strResult = Double.toString(result);
      
      // Location of decimal in String Result
      int decimalAt = strResult.indexOf('.');
      
      // Index of decimal is also the number of digits to the left
      System.out.println("# of characters to left of decimal point: " + decimalAt);
      
      // Length of string - 1 - decimal index equals digits to right of decimal
      System.out.println("# of characters to right of decimal point: "
                         + (strResult.length() - 1 - decimalAt));
     
     // Formats Number into written format. (ex. 1,000,000.0)
      DecimalFormat fmt = new DecimalFormat("#,##0.0####");
      System.out.println("Formatted Result: " + fmt.format(result));
   }
}
