import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Cardholder Processor class.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/16/2018
 */
public class CardholderProcessor {
   private String raolistName;
   private Cardholder[] cardholders;
   private String[] invalidRecords;
   
   /**
    * Initialize the instance fields.
    */
   public CardholderProcessor() {
      //raolistName = "not yet assigned";
      cardholders = new Cardholder[0];
      invalidRecords = new String[0];
   }
   /**
    * @return Cardholder array representing the holderList.
    */
   public Cardholder[] getCardholdersArray() {
      return cardholders;
   }
   /**
    * @return InvalidRecords array representing the invalidRecords.
    */
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
  /**.
   * Add
   * @param holderIn for
   */  
   public void addCardholder(Cardholder holderIn) {
      cardholders = Arrays.copyOf(cardholders, cardholders.length + 1);
      cardholders[cardholders.length - 1] = holderIn; 
   }
  /**.
   * Add
   * @param invalidIn for
   */  
   
   public void addInvalidRecord(String invalidIn) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = invalidIn; 
   }

   /**
    * FileNotFoundException exception if no file found.
    * @throws FileNotFoundException trsxdcghfvjkl
    * @param fileName for
    */
   public void readCardholderFile(String fileName) 
   
       throws FileNotFoundException {
   /** 
    * A test for throws FileNotFoundException().
    * @throws FileNotFoundException throws an exception if no file found.
    */
      Scanner scanFile = new Scanner(new File(fileName));
      String line = " ";
      while (scanFile.hasNext()) {
         try {
            line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            scanLine.useDelimiter(";");
            char option = scanLine.next().charAt(0);
            String acctNumber = scanLine.next();
            String name = scanLine.next();
            double[] rList = new double[0];
            Cardholder r = null;
            double prevBalance = 0;
            double payment = 0;
           
            switch (option) {
               case '1':
                  prevBalance = Double.parseDouble(scanLine.next());
                  payment = Double.parseDouble(scanLine.next()); 
                  r = new SapphireCardholder(acctNumber, name);
                  r.setPrevBalance(prevBalance);
                  r.setPayment(payment);
                  r.addPurchases(rList);
                  break;            
               
               case '2':
                  prevBalance = Double.parseDouble(scanLine.next());
                  payment = Double.parseDouble(scanLine.next()); 
                  r = new DiamondCardholder(acctNumber, name);
                  r.setPrevBalance(prevBalance);
                  r.setPayment(payment);
                  r.addPurchases(rList);
                  break;
               
               case '3':
                  prevBalance = Double.parseDouble(scanLine.next());
                  payment = Double.parseDouble(scanLine.next()); 
                  r = new BlueDiamondCardholder(acctNumber, name);
                  r.setPrevBalance(prevBalance);
                  r.setPayment(payment);
                  r.addPurchases(rList);
                  break;
               
               default:
                  throw new InvalidCategoryException();
            }
            while (scanLine.hasNext()) {
               double purchases = Double.parseDouble(scanLine.next()); 
               r.addPurchases(purchases);
            }
            this.addCardholder(r);
         }
         catch (NumberFormatException e)
         { 
            addInvalidRecord(line + " *** invalid numeric value ***");          
         }
            
         catch (InvalidCategoryException e)
         {
            addInvalidRecord(line + " *** invalid category ***");
         } 
         
      }
   }
   /**
    * @return Cardholder report by using the original order.
    */
   public String generateReport() {
      String output = "---------------------------------------\n"
                    + "Monthly Cardholder Report" 
                    + "\n---------------------------------------";
      for (int i = 0; i < cardholders.length; i++) {
         output += "\n" + cardholders[i] + "\n";
      }
      return output + "\n";
   }
   /**
    * @return Cardholder report by Name.
    */
   public String generateReportByName() {
      Arrays.sort(cardholders);
      String output = "---------------------------------------\n"
                    + "Monthly Cardholder Report" + " (by Name)"  
                    + "\n---------------------------------------";
      for (Cardholder rr : cardholders) {
         output += "\n" + rr.toString() + "\n";
      }
      return output + "\n";
   }
   /**
    * @return Cardholder report by Current Balance.
    */
   public String generateReportByCurrentBalance() {
      Arrays.sort(cardholders, new CurrentBalanceComparator());
      String output = "---------------------------------------\n"
                    + "Monthly Cardholder Report" + " (by Current Balance)"  
                    + "\n---------------------------------------";
      for (int i = 0; i < cardholders.length; i++) {
         output += "\n" + cardholders[i] + "\n";
      }         
      return output + "\n";
   }
    /**
    * @return returns the Invalid Records Report.
    */
   public String generateInvalidRecordsReport() {
      String output = "-----------------------\n" 
                    + "Invalid Records Report\n" 
                    + "-----------------------\n";
      for (int i = 0; i < invalidRecords.length; i++) {
         output += invalidRecords[i] + "\n\n";
      }
      return output + "\n";
   }
}