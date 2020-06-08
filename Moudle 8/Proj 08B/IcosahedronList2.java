import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;
/**
 * Stores the name of the list and an array.
 * Project_08B
 * @author Xi Rao
 * @version 11/02/2018
 */
public class IcosahedronList2 {
   private String listName;
   private Icosahedron[] dList;
   private int numberOfIcosahedrons;
   /**
    * @param listNameIn the list name.
    * @param dListIn the dodecahedron list.
    * @param numberOfIcosahedronsIn the number of dodecahedrons.
    */
   public IcosahedronList2(String listNameIn, Icosahedron[] dListIn, 
                            int numberOfIcosahedronsIn) {
      listName = listNameIn;
      dList = dListIn;
      numberOfIcosahedrons = numberOfIcosahedronsIn;
   }
   /**
    * @return the list name.
    */
   public String getName() {
      return listName;
   }
   /**
    * @return the number of dodecahedrons objects in the dlist.
    */
   public int numberOfIcosahedrons() {
      return numberOfIcosahedrons;
   }
   /**
    * @return the total surface area.
    */
   public double totalSurfaceArea() {
      double totalS = 0;
      int index = 0;
      while (index < numberOfIcosahedrons) {
         totalS += dList[index].surfaceArea();
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
      while (index < numberOfIcosahedrons) {
         totalV += dList[index].volume();
         index++;
      }
      return totalV;
   }
   /**
    * @return the average area.
    */
   public double averageSurfaceArea() {
      double avgA = 0;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         avgA += dList[i].surfaceArea() / numberOfIcosahedrons;
      }
      return avgA;
   }
   /**
    * @return the average volume.
    */
   public double averageVolume() {
      double avgV = 0;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         avgV += dList[i].volume() / numberOfIcosahedrons;
      }
      return avgV;
   }
   /**
    * @return the average surface area/volume ratio.
    */
   public double averageSurfaceToVolumeRatio() {
      double avgR = 0;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         avgR += dList[i].surfaceToVolumeRatio() / numberOfIcosahedrons;
      }
      return avgR;
   }
   /**
    * @return the result as string.
    */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < numberOfIcosahedrons) {
         result += "\n" + dList[index] + "\n";
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
   public Icosahedron[] getList() {
      return dList;
   }
   /**
    * @param fileNameIn for fileName to read.
    * @return IcosahedronList.
    * @throws FileNotFoundException for file reading.
    */
   public IcosahedronList2 readFile(String fileNameIn)
         throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Icosahedron[] myList = new Icosahedron[20];
      int number = 0;
      String label = "";
      String color = "";
      double edge = 0;
      listName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         Icosahedron d = new Icosahedron(label, color, edge);
         myList[number] = d;
         number++;
      }
      IcosahedronList2 dL = new IcosahedronList2(listName, myList, 
                             number);
      return dL;
   }
   /**
    * @param labelIn the label.
    * @param colorIn the color.
    * @param edgeIn the edge.
    */
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      Icosahedron d = new Icosahedron(labelIn, colorIn, edgeIn);
      dList[numberOfIcosahedrons] = d;
      numberOfIcosahedrons++;
   }
   /**
    * @param labelIn the label.
    * @return dList.get(index) the index of the label.
    */
   public Icosahedron findIcosahedron(String labelIn) { 
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (dList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = dList[i];
            break;
         }
      }
      return result;
   }
   /**
    * @param labelIn the label.
    * @return d1 the dodecahedron.
    */
   public Icosahedron deleteIcosahedron(String labelIn) {
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (dList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = dList[i];
            for (int j = i; j < numberOfIcosahedrons - 1; j++) {
               dList[j] = dList[j + 1];
            }
            dList[numberOfIcosahedrons - 1] = null;
            numberOfIcosahedrons--;
            break;
         }
      }
      return result;
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
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (dList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = dList[i];
            dList[i].setColor(colorIn);
            dList[i].setEdge(edgeIn);
            return true;
         }
      }
      return false;
   }
   /**
    * @return the result.
    */
   public Icosahedron findIcosahedronWithShortestEdge() {
      if (numberOfIcosahedrons <= 0) {
         return null;
      }
      int i = 0;
      for (int j = 0; j < numberOfIcosahedrons; j++) {
         if (dList[j].getEdge() <= dList[i].getEdge()) {
            i = j;
         }
      }
      return dList[i];
   }
   /**
    * @return the result.
    */
   public Icosahedron findIcosahedronWithLongestEdge() {
      if (numberOfIcosahedrons <= 0) {
         return null;
      }
      int i = 0;
      for (int j = 0; j < numberOfIcosahedrons; j++) {
         if (dList[j].getEdge() > dList[i].getEdge()) {
            i = j;
         }
      }
      return dList[i];
   }
   /**
    * @return the result.
    */
   public Icosahedron findIcosahedronWithSmallestVolume() {
      if (numberOfIcosahedrons <= 0) {
         return null;
      }
      int i = 0;
      for (int j = 0; j < numberOfIcosahedrons; j++) {
         if (dList[j].volume() <= dList[i].volume()) {
            i = j;
         }
      }
      return dList[i];
   }
   /**
    * @return the result.
    */
   public Icosahedron findIcosahedronWithLargestVolume() {
      if (numberOfIcosahedrons <= 0) {
         return null;
      }
      int i = 0;
      for (int j = 0; j < numberOfIcosahedrons; j++) {
         if (dList[j].volume() > dList[i].volume()) {
            i = j;
         }
      }
      return dList[i];
   }
}
