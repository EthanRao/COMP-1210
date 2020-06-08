/**
 * Electronics item class.
 *
 * Activity_09.
 * @author Xi Rao 
 * @version 11/05/2018
 */
public class ElectronicsItem extends InventoryItem {
   protected double weight = 0;
   /**
    * The shipping cost.
    */
   public static final double SHIPPING_COST = 1.5;
   
   /**
    * @param nameIn the input name.
    * @param priceIn the input price.
    * @param weightIn the input weight.
    */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }
   /**
    * @return the total cost.
    */
   
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}