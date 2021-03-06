import java.text.DecimalFormat;
/**
 * Compute the value generated by aspecified expression.
 * project 10
 * @author Xi Rao
 * @11/14/2018 
 */
public class BlueDiamondCardholder extends DiamondCardholder {
   private int bonusPurchasePoints = 2500;
   /**
    * @param acctNumberIn the acctNumber.
    * @param nameIn the name.
    * 
    */
   public BlueDiamondCardholder(String acctNumberIn, String nameIn) {
      super(acctNumberIn, nameIn);
      category = "Blue Diamond Cardholder";
      discountRate = 0.10;
   }
/**
* @param bonusPurchasePointsIn the bonusPurchasePoints.
*/
   public void setBonusPurchasePoints(int bonusPurchasePointsIn) {
      bonusPurchasePoints = bonusPurchasePointsIn;
   }   
/**
* @return name.
*/
   public int getBonusPurchasePoints() {
      return bonusPurchasePoints;
   }
/**
* @return purchasePoints.
*/
   public int purchasePoints() {
      int purchasePoints = 0;
      if (totalPurchases() > 2500)
      {
         purchasePoints = (int) super.totalPurchases() * 5  
             + 2500;
      }
      else {
         purchasePoints = (int) super.totalPurchases() * 5;
      }
      return purchasePoints;
   }
 /**
 * @return toString.
 */ 
   public String toString() {
      DecimalFormat r = new DecimalFormat("#,##0");
      if (totalPurchases() > 2500) {
         return super.toString()
            + "\n(includes " + r.format(bonusPurchasePoints)  
            + " bonus points added to Purchase Points)";
      }
      else 
      {
         return super.toString();
            
      }
   
   }
   
}