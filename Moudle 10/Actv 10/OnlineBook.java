/**
 * Online book class.
 *
 * Activity_10.
 * @author Xi Rao
 * @version 11/12/2018
 */
public class OnlineBook extends OnlineTextItem {
   protected String author;
   
   /**
    * @param nameIn the input name.
    * @param priceIn the input price.
    */
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   /**
    * @return the author's name and price as string.
    */
   public String toString() {
      return name + " - " + author + ": $" + price;
   }
   /**
    * @param authorIn sets the author's name.
    */
   public void setAuthor(String authorIn) {
      author = authorIn;
   }
}
