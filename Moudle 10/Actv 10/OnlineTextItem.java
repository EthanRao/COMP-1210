/**
 * Online text item class.
 *
 * Activity_10.
 * @author Xi Rao
 * @version 11/12/2018
 */
public abstract class OnlineTextItem extends InventoryItem {
   /**
    * @param nameIn the input name.
    * @param priceIn the input price.
    */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   /**
    * @return the total cost.
    */
   public double calculateCost() {
      return price;
   }
}