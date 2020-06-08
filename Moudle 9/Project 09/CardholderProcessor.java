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
    * @Cardholders array representing the holderList.
    */
   public Cardholder[] getCardholders() {
      return cardholders;
   }
   /**
    * @StringRecords array representing the invalidRecords.
    */
   public String[] getStringRecords() {
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
   
   public void addString(String invalidIn) {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = invalidIn; 
   }

   /**
    * @ FileNotFoundException exception if no file found.
    * @param fileName for
    */
   public void readCardholderFile(String fileName) 
       throws FileNotFoundException {
   
      Scanner scanFile = new Scanner(new File(fileName));
   
      while (scanFile.hasNext()) {
         String line = scanFile.nextLine();
         Scanner scanLine = new Scanner(line);
         scanLine.useDelimiter(";");
      
         while (scanLine.hasNext()) {
            char option = scanLine.next().charAt(0);
            String acctNumber = scanLine.next();
            String name = scanLine.next();
            double prevBalance = Double.parseDouble(scanLine.next());
            double payment = Double.parseDouble(scanLine.next()); 
            double[] rList = new double[0];
            
            while (scanLine.hasNext()) {
               double purchases = Double.parseDouble(scanLine.next()); 
               rList = Arrays.copyOf(rList, rList.length + 1);
               rList[rList.length - 1] = purchases;
            }
            Cardholder r = null;
         
            switch (option) {
               case '1':
                  r = new SapphireCardholder(acctNumber, name);
                  r.setPrevBalance(prevBalance);
                  r.setPayment(payment);
                  r.addPurchases(rList);
                  this.addCardholder(r);
                  break;            
            
               case '2':
                  r = new DiamondCardholder(acctNumber, name);
                  r.setPrevBalance(prevBalance);
                  r.setPayment(payment);
                  r.addPurchases(rList);
                  this.addCardholder(r);
                  break;
            
               case '3':
                  r = new BlueDiamondCardholder(acctNumber, name);
                  r.setPrevBalance(prevBalance);
                  r.setPayment(payment);
                  r.addPurchases(rList);
                  this.addCardholder(r);
                  break;
            
               default:
                  break;
            }
         }
      }
   }
   /**
    * @Cardholder report by using the original order.
    */
   public String generateReport() {
      String output = "---------------------------------------\n"
                    + "Monthly Cardhold Report " 
                    + "\n---------------------------------------";
      for (int i = 0; i < cardholders.length; i++) {
         output += "\n" + cardholders[i] + "\n";
      }
      return output;
   }
   /**
    * @Cardholder report by Name.
    */
   public String generateReportByName() {
      Arrays.sort(cardholders);
      String output = "---------------------------------------\n"
                    + "Monthly Cardhold Report " + " (by Name)"  
                    + "\n---------------------------------------";
      for (Cardholder rr : cardholders) {
         output += "\n" + rr.toString() + "\n";
      }
      return output;
   }
   /**
    * @Cardholder report by Current Balance.
    */
   public String generateReportByCurrentBalance() {
      Arrays.sort(cardholders, new CurrentBalanceComparator());
      String output = "---------------------------------------\n"
                    + "Monthly Cardhold Report " + " (by Current Balance)"  
                    + "\n---------------------------------------";
      for (int i = 0; i < cardholders.length; i++) {
         output += "\n" + cardholders[i] + "\n";
      }         
      return output;
   }
}