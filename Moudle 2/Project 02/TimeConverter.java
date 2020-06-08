import java.util.Scanner;

/**
* Perform calculations based on the input user information.
* based on the seconds output days, hours, seconds. 
*
* @author Xi Rao
* @version 9/5/2018
*/
public class TimeConverter
{
/**
* Allows the user to input seconds an output  
* of days, hours, seconds. Based off seconds,
* prints to days,hours, seconds.
*
* @param args Command line arguments (not used)
*/
   public static void main(String[] args)
   {
      int min = 0;
      int input = 0;
      int days = 0; 
      int hours = 0;
      int minutes = 0;
      int seconds = 0;
   
      Scanner userInput = new Scanner(System.in);
     
      //Input seconds.
      System.out.print("Enter the raw time measurement in seconds: ");
      input = userInput.nextInt();
      //Determine the positive and negative
      if (input < min) { //output the warning
         System.out.print("Measurement must be non-negative!");
      }
      else { 
         System.out.println("Measurement by combined days,"
                           + " hours, minutes, seconds:");
         
         //Calculate number of seconds
         seconds = input % 60;
          //Calculate number of minutes
         minutes = input / 60 % 60;
          //Calculate number of hours
         hours = input / 60 / 60 % 24;
         //Calculate number of days
         days = input / 60 / 60 / 24;
         
         //Output result by combined days, hours, minutes, seconds
         System.out.println("\tdays: " + days);
         System.out.println("\thours: " + hours);
         System.out.println("\tminutes: " + minutes);
         System.out.println("\tseconds: " + seconds);
         System.out.println("");
         System.out.println(input + " seconds = " + days + " days, " 
                     + hours + " hours, " + minutes + " minutes, " 
                     + seconds + " seconds");
      }
   }
}
