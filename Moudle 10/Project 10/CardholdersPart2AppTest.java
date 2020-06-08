import org.junit.Assert;
import org.junit.Test;

/**
 * A Test class of Cardholder Part2 App.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/16/2018
 */


public class CardholdersPart2AppTest {
   /**
    * A test for main when reads no file.
    * @throws Exception throws an exception if no file found.
    */
   @Test public void mainTest1() throws Exception {
      CardholdersPart2App app = new CardholdersPart2App();
      String[] args1 = {};
      CardholdersPart2App.main(args1);
      Assert.assertEquals(0, Cardholder.INTEREST_RATE, 0.01);
   }
   
   /**
    * A test for main when the file exists.
    * @throws Exception throws an exception if no file found.
    */
   @Test public void mainTest2() throws Exception {
      CardholdersPart2App app = new CardholdersPart2App();
      String[] args2 = {"cardholder_data_1.txt"};
      CardholdersPart2App.main(args2);
      Assert.assertEquals(0.01, Cardholder.INTEREST_RATE, 0.01);
   }
}