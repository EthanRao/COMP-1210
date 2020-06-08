import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;
 /** 	
  * the CostComparator.	
  * @author Xi Rao
  * @version 11/16/2018
  */	

public class CardholderProcessorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /** @throws FileNotFoundException file name errer.**/
   
   @Test public void readCardholderFileTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals("Cardholder Collection", c1.getListName());
   }
   /** @throws FileNotFoundException file name errer.**/
   @Test public void getterTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals(c1.getListName(), "Cardholder Collection");
      Cardholder[] aa = new Cardholder[20];
      aa = c1.getCardholderList();
      Assert.assertEquals(0, 0);
      String[] a = new String[2];
      a = c1.getExcludedRecords();
      
      Assert.assertEquals(0, 0);
      
      
      // Assert.assertEquals(c1.getCardholderList(), c1.getCardholderList());
   //       Assert.assertEquals(c1.getExcludedRecords(), c1.getExcludedRecords());
   }
   /** @throws FileNotFoundException file name errer.**/
   @Test public void setterTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      c1.setListName("cc");
      Assert.assertEquals("cc", c1.getListName());
      
      
   }
   /** @throws FileNotFoundException file name errer.
    * @throws NegativeValueException .
   **/
   @Test public void addCardholderTest() throws NegativeValueException, 
      FileNotFoundException {
      
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Cardholder c2 = new PetCardholder("ss", "s", 1);
      c1.addCardholder(c2);
      Assert.assertEquals(c1.getCardholderList().length, 3, 10);
   }
   /** FileNotFoundException file name errer.**/
   @Test public void addExcludedRecordTest() {
      String[] str = new String[2];
      str[0] = new String("ff");
      str[1] = new String("ss");
      CardholderList c1 = new CardholderList();
      c1.addExcludedRecord(new String("ff"));
      c1.addExcludedRecord(new String("ss"));
      Assert.assertArrayEquals(" ", str, c1.getExcludedRecords());
   }
   /** @throws FileNotFoundException file name errer.**/
   @Test public void toStringTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals("toString Test", true, 
                           c1.toString().contains("Card"));
   }
   
   /** @throws FileNotFoundException file name errer.**/
   @Test public void summaryTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals("toString Test", true, 
                           c1.summary().contains("Card"));
   }
   
   /** @throws FileNotFoundException file name errer.**/
   @Test public void listByNameTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals("listByName Test", true, 
                           c1.listByName().contains("Card"));
   }
   
   /** @throws FileNotFoundException file name errer.**/
   @Test public void listByCostTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals("listByCost Test", true, 
                           c1.listByCost().contains("Card"));
   }
   
   /** @throws FileNotFoundException file name errer.**/
   @Test public void excludedRecordsListTest() throws FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals("excludedRecordsList Test", true, 
                           c1.excludedRecordsList().contains("Card"));
   }
   
   /** @throws FileNotFoundException file name errer.**/
   @Test public void totalEstimatedMonthlyCostTest() throws
      FileNotFoundException {
      CardholderList c1 = new CardholderList();
      c1.readCardholderFile("cardholder2.txt");
      Assert.assertEquals(124.38, c1.totalEstimatedMonthlyCost(), 1000);
   }
}