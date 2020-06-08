import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
/**
 * Icosahedron list.
 * Defines objects with a name and a list of Icosahedron objects.
 * @author Xi Rao
 * @version 10/08/2018
 */
public class IcosahedronList {
   private String listName;
   private ArrayList<Icosahedron> iList;
   /**
    * @param listNameIn the list name.
    * @param iListIn the Icosahedron list.
    */
   public IcosahedronList(String listNameIn, ArrayList<Icosahedron> iListIn) {
      listName = listNameIn;
      iList = iListIn;
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
      return iList.size();
   }
   /**
    * @return the total surface area.
    */
   public double totalSurfaceArea() {
      double totalS = 0;
      int index = 0;
      while (index < iList.size()) {
         totalS += iList.get(index).surfaceArea();
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
      while (index < iList.size()) {
         totalV += iList.get(index).volume();
         index++;
      }
      return totalV;
   }
   /**
    * @return the average area.
    */
   public double averageSurfaceArea() {
      double avgA = 0;
      if (iList.size() > 0) {
         avgA = totalSurfaceArea() / iList.size();
      }
      return avgA;
   }
   /**
    * @return the average volume.
    */
   public double averageVolume() {
      double avgV = 0;
      if (iList.size() > 0) {
         avgV = totalVolume() / iList.size();
      }
      return avgV;
   }
   /**
    * @return the total surface area/volume ratio.
    */
   public double totalRatio() {
      double totalR = 0;
      int index = 0;
      while (index < iList.size()) {
         totalR += iList.get(index).surfaceToVolumeRatio();
         index++;
      }
      return totalR;
   }
   /**
    * @return the average surface area/volume ratio.
    */
   public double averageSurfaceToVolumeRatio() {
      double avgR = 0;
      if (iList.size() > 0) {
         avgR = totalRatio() / iList.size();
      }
      return avgR;
   }
   /**
    * @return the result as string.
    */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < iList.size()) {
         result += "\n" + iList.get(index) + "\n";
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
   /**
    * @return the list.
    */
   public ArrayList<Icosahedron> getList() {
      return iList;
   }
   /**
    * @param fileNameIn for fileName to read.
    * @return IcosahedronList.
    * @throws FileNotFoundException if the file cannot be opened.
    */
   public IcosahedronList readFile(String fileNameIn) 
                     throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Icosahedron> myList = new ArrayList<Icosahedron>();
      String label = "";
      String color = "";
      double edge = 0;
      listName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         Icosahedron i = new Icosahedron(label, color, edge);
         myList.add(i);
      }
      IcosahedronList iL = new IcosahedronList(listName, myList);
      return iL;
   }
   /**
    * @param labelIn the label.
    * @param colorIn the color.
    * @param edgeIn the edge.
    */
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      Icosahedron i = new Icosahedron(labelIn, colorIn, edgeIn);
      iList.add(i);
   }
   /**
    * @param labelIn the label.
    * @return iList.get(index) the index of the label.
    */
   public Icosahedron findIcosahedron(String labelIn) {
      int index = -1;
      for (Icosahedron i : iList) {
         if (i.getLabel().equalsIgnoreCase(labelIn)) {
            index = iList.indexOf(i);
            break;
         }
      }
      if (index >= 0) {
         return iList.get(index);
      }
      else {
         return null;
      }
   }
   /**
    * @param labelIn the label.
    * @return i1 the Icosahedron.
    */
   public Icosahedron deleteIcosahedron(String labelIn) {
      int index = iList.indexOf(findIcosahedron(labelIn));    
      if (index >= 0) {
         return iList.remove(index);
      } else {
         return null;
      }
   }
   /**
    * @param labelIn the label.
    * @param colorIn the color.
    * @param edgeIn the edge.
    * @return true if input is correct.
    */
   public boolean editIcosahedron(String labelIn, String colorIn, 
      double edgeIn) {
      Icosahedron result = null;
      int index = -1;
      for (Icosahedron i : iList) {
         if (i.getLabel().equalsIgnoreCase(labelIn)) {
            index = iList.indexOf(i);
            break;
         }
      }
      if (index >= 0) {
         result = iList.get(index);
         result.setColor(colorIn);
         result.setEdge(edgeIn);
         return true;
      }
      return false;
   }
}