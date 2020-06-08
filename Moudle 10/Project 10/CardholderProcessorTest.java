import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
 /** 	
  * CardholderProcessor class.
  *	
  * @author Xi Rao
  * @version 11/16/2018
  */	

public class CardholderProcessorTest {
   /**.
*/
   @Test public void getTest() { 
      CardholderProcessor ab = new CardholderProcessor();
      String[] a = {};
      String[] b = {"cardholder_data_1.txt"};
      Assert.assertEquals("getInvalidRecords Test",
         0, ab.getInvalidRecordsArray().length);
      Assert.assertEquals("getCardholder Test",
         0, ab.getCardholdersArray().length);    
   }      
   /** 
    * A test for readCardholderFile().
    * @throws FileNotFoundException throws an exception if no file found.
    */
   @Test public void readCardholderFileTest() throws FileNotFoundException {
      CardholderProcessor cList = new CardholderProcessor();
      String name = "Monthly Cardholder";
      cList.readCardholderFile("cardholder_data_1.txt");
      Assert.assertTrue(name.contains("Monthly Cardholder"));
   }
   
   /** FileNotFoundException file name errer.**/
   @Test public void addInvalidRecordTest() {
      String[] str = new String[2];
      str[0] = new String("aa");
      str[1] = new String("bb");
      CardholderProcessor c1 = new CardholderProcessor();
      c1.addInvalidRecord(new String("aa"));
      c1.addInvalidRecord(new String("bb"));
      Assert.assertArrayEquals(" ", str, c1.getInvalidRecordsArray());
   }
   /** 
    * A test for generateReportByClass().
    * @throws FileNotFoundException throws an exception if no file found.
    */
   @Test public void generateReportByClassTest() throws FileNotFoundException {
      CardholderProcessor clist = new CardholderProcessor();
      clist.readCardholderFile("cardholder_data_1.txt");  
      Assert.assertFalse("generateReportByClass Test",
         clist.generateReportByName().contains("cardholder"));
   }
    /** 
    * A test for generateReportByCurrentBalance().
    * @throws FileNotFoundException throws an exception if no file found.
    */
   @Test public void generateReportByCurrentBalanceTest() 
      throws FileNotFoundException {
      CardholderProcessor clist = new CardholderProcessor();
      clist.readCardholderFile("cardholder_data_1.txt");
      Assert.assertFalse("generateReportByClass Test",
         clist.generateReportByCurrentBalance().contains("cardholder")); 
   }
   /** 
    * A test for return 0.
    * @throws Exception throws an exception if no file found.
    */

   @Test public void currentBalanceTestEqual() {
      CurrentBalanceComparator currentBalanceCompare = 
         new CurrentBalanceComparator();
      Cardholder c1 = new BlueDiamondCardholder("King, Kelly", "1");
      Cardholder c2 = new BlueDiamondCardholder("Jenkins, Jordan", "1");
      Assert.assertEquals(0, currentBalanceCompare.compare(c1, c2));
   }
  
   
   /** 
    * A test for return 1.
    * @throws Exception throws an exception if no file found.
    */
   @Test public void currentBalanceTestPositive() {
      CurrentBalanceComparator currentBalanceCompare = 
         new CurrentBalanceComparator();
      Cardholder c1 = new SapphireCardholder("10001", "Smith, Sam"); 
      c1.setPrevBalance(1);
      Cardholder c2 = new BlueDiamondCardholder("10003", "King, Kelly");  
      c2.setPrevBalance(2);     
      Assert.assertEquals(1, currentBalanceCompare.compare(c1, c2));
   }
  
   /** 
    *  A test for return -1.
    * @throws Exception throws an exception if no file found.
    */
   @Test public void currentBalanceTestNegative() {
      CurrentBalanceComparator currentBalanceCompare = 
         new CurrentBalanceComparator();
      Cardholder c1 = new SapphireCardholder("10001", "Smith, Sam"); 
      c1.setPrevBalance(2);
      Cardholder c2 = new BlueDiamondCardholder("10003", "King, Kelly");  
      c2.setPrevBalance(1);     
      Assert.assertEquals(-1, currentBalanceCompare.compare(c1, c2));
   }
 
}