/**
 * Online article class.
 *
 * Activity_09.
 * @author Xi Rao
 * @version 11/05/2018
 */
public class OnlineArticle extends OnlineTextItem {
   private int wordCount;
   
   /**
    * @param nameIn the input name.
    * @param priceIn the input price.
    */
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      wordCount = 0;
   }
   /**
    * @param wordCountIn set the amount of words.
    */
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}