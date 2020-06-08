import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 * Icosahedron list.
 *
 * @author Xi Rao
 * @version 10/03/2018
 */
public class IcosahedronList {
   private String listName;
   private ArrayList<Icosahedron> dList;
   /**
    * @param listNameIn the list name.
    * @param dListIn the icosahedron list.
    */
   public IcosahedronList(String listNameIn, ArrayList<Icosahedron> dListIn) {
      listName = listNameIn;
      dList = dListIn;
   }
   /**
    * @return the list name.
    */
   public String getName() {
      return listName;
   }
   /**
    * @return the size of the list.
    */
   public int numberOfIcosahedrons() {
      return dList.size();
   }
   /**
    * @return the total surface area.
    */
   public double totalSurfaceArea() {
      double totalS = 0;
      int index = 0;
      while (index < dList.size()) {
         totalS += dList.get(index).surfaceArea();
         index++;
      }
      return totalS;
   }
   /**
    * @return the total volume.
    */
   public double totalVolume() {
      double totalV = 0;
      int index = 0;
      while (index < dList.size()) {
         totalV += dList.get(index).volume();
         index++;
      }
      return totalV;
   }
   /**
    * @return the average area.
    */
   public double averageSurfaceArea() {
      double avgA = 0;
      if (dList.size() > 0) {
         avgA = totalSurfaceArea() / dList.size();
      }
      return avgA;
   }
   /**
    * @return the average volume.
    */
   public double averageVolume() {
      double avgV = 0;
      if (dList.size() > 0) {
         avgV = totalVolume() / dList.size();
      }
      return avgV;
   }
   /**
    * @return the total surface area/volume ratio.
    */
   public double totalRatio() {
      double totalR = 0;
      int index = 0;
      while (index < dList.size()) {
         totalR += dList.get(index).surfaceToVolumeRatio();
         index++;
      }
      return totalR;
   }
   /**
    * @return the average surface area/volume ratio.
    */
   public double averageSurfaceToVolumeRatio() {
      double avgR = 0;
      if (dList.size() > 0) {
         avgR = totalRatio() / dList.size();
      }
      return avgR;
   }
   /**
    * @return the result as string.
    */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < dList.size()) {
         result += "\n" + dList.get(index) + "\n";
         index++;
      }
      return result;
   }
   /**
    * @return the summary info.
    */
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String result = "";
      result += "----- Summary for " + getName() + " -----";
      result += "\nNumber of Icosahedrons: " + numberOfIcosahedrons();
      result += "\nTotal Surface Area: " + fmt.format(totalSurfaceArea());
      result += "\nTotal Volume: " + fmt.format(totalVolume());
      result += "\nAverage Surface Area: " + fmt.format(averageSurfaceArea());
      result += "\nAverage Volume: " + fmt.format(averageVolume());
      result += "\nAverage Surface/Volume Ratio: " 
         + fmt.format(averageSurfaceToVolumeRatio());
      return result;
   }
}