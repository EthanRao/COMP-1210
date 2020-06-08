import org.junit.Assert;
import org.junit.Test;

/**
 * A Test class of Cardholder Part3 App.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/16/2018
 */


public class CardholdersPart3AppTest {
   /**
    * A test for main when reads no file.
    * @throws Exception throws an exception if no file found.
    */
   @Test public void mainTest1() throws Exception {
      CardholdersPart3App app = new CardholdersPart3App();
      String[] args1 = {};
      CardholdersPart3App.main(args1);
      Assert.assertEquals(0, Cardholder.INTEREST_RATE, 0.01);
   }
   
   /**
    * A test for main when the file exists.
    * @throws Exception throws an exception if no file found.
    */
   @Test public void mainTest3() throws Exception {
      CardholdersPart3App app = new CardholdersPart3App();
      String[] args3 = {"cardholder_data_1.txt"};
      CardholdersPart3App.main(args3);
      Assert.assertEquals(0.01, Cardholder.INTEREST_RATE, 0.01);
   }
}