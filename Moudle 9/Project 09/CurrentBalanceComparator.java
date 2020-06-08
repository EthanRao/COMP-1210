import java.util.Comparator;
/**
 * CurrentBalanceCompartor class.
 *
 * Project 10.
 * @author Xi Rao
 * @version 11/16/2018
 */
public class CurrentBalanceComparator implements Comparator<Cardholder> {
   /**
    * @param r1 a card holder.
    * @param r2 another card holder.
    * @return returns an int representing the order.
    */
   public int compare(Cardholder c1, Cardholder c2) {
      if (c1.currentBalance() > c2.currentBalance()) {
         return -1;
      }
      else if (c1.currentBalance() < c2.currentBalance()) {
         return 1;
      }
      return 0;
   }
}
