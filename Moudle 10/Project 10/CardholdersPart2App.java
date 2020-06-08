import java.io.FileNotFoundException;

/**
 * Cardholder Part2 App class.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/16/2018
 */
public class CardholdersPart2App {
/**.
   * Add
   * @param args
   * @throw throws Exceptionan exception if nofilefound FileNotFoundException.
   */  
   public static void main(String[] args) throws FileNotFoundException {
      if (args.length != 0) {
         CardholderProcessor list = new CardholderProcessor();
         list.readCardholderFile(args[0]);
         System.out.println(list.generateReport());
         System.out.println(list.generateReportByName());
         System.out.println(list.generateReportByCurrentBalance());
      }
      else {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
   }
}