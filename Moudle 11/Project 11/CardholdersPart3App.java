import java.io.FileNotFoundException;
/**
 * Cardholder Part3 App class.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/16/2018
 */
public class CardholdersPart3App {
/**.
   * Add
   * @param args ewladslbh
   * @throws FileNotFoundException adsfnasdaf
   * @throw throws Exceptionan exception if nofilefound FileNotFoundException.
   */  
   public static void main(String[] args) throws FileNotFoundException {
      if (args.length != 0) {
         try {
            CardholderProcessor list = new CardholderProcessor();
            list.readCardholderFile(args[0]);
            System.out.print(list.generateReport());
            System.out.print(list.generateReportByName());
            System.out.print(list.generateReportByCurrentBalance());
            System.out.print(list.generateInvalidRecordsReport());
         }
         catch (FileNotFoundException e) {
            System.out.println(" *** Attempted to read file: " + args[0]  
                             + " (No such file or directory)");
         }
      }
      else {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
   }
}