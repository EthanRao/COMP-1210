/**
 * Compute the value generated by aspecified expression.
 * project 10
 * @Xi Rao
 * @11/16/2018 
 */
public class SapphireCardholder extends Cardholder {
/**
    * Constuctor.
    * @param acctNumberIn the acctNumberIn.
    * @param nameIn the nameIn.
    * 
    */
   public SapphireCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
   }
/**
* @return purchasePoints.
*/
   public int purchasePoints() {
   
      int purchasePoints = (int) super.totalPurchases();
      return purchasePoints;
   }
}