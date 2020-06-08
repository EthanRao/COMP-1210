import org.junit.Assert;
//import static org.junit.Assert.*
//import org.junit.Before;
import org.junit.Test;
/**
 * Cardholder class.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/18/2018
 */
public class SapphireCardholderTest {
/**.
*/
   @Test public void getTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0, 666.0);
      sc.setPrevBalance(1200.0);
      sc.setPayment(200); 
      Assert.assertEquals("getter Test", "10001", sc.getAcctNumber());
      Assert.assertEquals("getter Test", "Smith, Sam", sc.getName());
      Assert.assertEquals("getter Test", 1200.0, sc.getPrevBalance(), 0.001);
      Assert.assertEquals("getter Test", 200, sc.getPayment(), 0.001);  
      Assert.assertEquals("getter Test", 5, sc.getPurchases().length);    
   }
 /**.
  */
   @Test public void singledeletPurchasesTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc.deletePurchases(350.0);
      Assert.assertEquals("singledeletePurchases Test",
         198.0, sc.totalPurchases(), 0.001); 
   }
 /**.
  */
   @Test public void multideletePurchasesTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc.deletePurchases(34.5, 350.0);
      Assert.assertEquals("multideletePurchases Test",
         163.5, sc.totalPurchases(), 0.001); 
   }
 /**.
  */
   @Test public void setTest() {
      SapphireCardholder sc = new SapphireCardholder("Smith, Sam", "10001"); 
      sc.setName("Jones, Pat");
      sc.setAcctNumber("10002");
      double[] a = {34.5, 100.0, 63.50, 300.0, 100.0};
      sc.setPurchases(a);
      Assert.assertEquals("setter Test", "10002", sc.getAcctNumber());
      Assert.assertEquals("setter Test", "Jones, Pat", sc.getName());
      Assert.assertEquals("setter Test", 598, sc.totalPurchases(), 0.001);
   }
 /**.
  */
   @Test public void balanceTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      Assert.assertEquals("balance Test",
         1758.00, sc.balance(), 0.01);
   }
 /**.
  */
   @Test public void purchasePointsTest() {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      Assert.assertEquals("purchasePoints Test", 548, sc.purchasePoints());
   }
}