//import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
/**
* Create an Icosahedron class that stores the label, color, and edge.
* Project 7 
* @author Xi Rao
* @version 10/17/2018
*/
public class IcosahedronList2 {
   private String listName;
   private Icosahedron[] iList;
   private int numberOfIcosahedrons;
   
   /**
    * Constuctor.
    * @param listNameIn for listName
    * @param iListIn for listIn
    * @param numberOfIcosahedronsIn for numberOfIcosahedrons
    */
   public IcosahedronList2(String listNameIn, Icosahedron[] iListIn, 
                        int numberOfIcosahedronsIn) {
      listName = listNameIn;
      iList = iListIn;
      numberOfIcosahedrons = numberOfIcosahedronsIn;
   }
    /**
    * Getter for listName.
    * @return listName
    */
   public String getListName() {
      return listName;
   }
   
   /**
    * @return the number of Icosahedron objects in the iList.
    */
   public int numIcosahedrons() {
      return  numberOfIcosahedrons;
   }
/**
* @return the totalSurfaceArea.
*/   
   public double totalSurfaceArea() {
      int number = 0;
      double total = 0;
      while (number < numberOfIcosahedrons) {
         total += iList[number].surfaceArea();
         number++;
      }
      return total;
   }

/**
* @return the totalVolume
*/    
   public double totalVolume() {
      int number = 0;
      double total = 0;
      while (number < numberOfIcosahedrons) {
         total += iList[number].volume();
         number++;
      }
      return total;
   }
/**
* @return the averageSurfaceArea
*/    
   public double averageSurfaceArea() {
      int number = 0;
      double total = 0;
      double result = 0;
      if (number != numberOfIcosahedrons) {
         result = totalSurfaceArea() / numberOfIcosahedrons;
      }
      else {
         result = 0.0;
      }
   
      return result;
   }
/**
* @return the averageVolume
*/     
   public double averageVolume() {
      int number = 0;
      double total = 0;
      double result = 0;
      if (number != numberOfIcosahedrons) {
         result = totalVolume() / numberOfIcosahedrons;
      }
      else {
         result = 0.0;
      }
   
      return result;
   }
/**
* @return the totalAverageSurfaceToVolumeRatio
*/     
   public double totalAverageSurfaceToVolumeRatio() {
      int number = 0;
      double total = 0;
      double result = 0;
      while (number < numberOfIcosahedrons) {
         total += iList[number].surfaceToVolumeRatio();
         number++;
      }
      return total;
   }
   
/**
* @return the averageSurfaceToVolumeRatio
*/        
   public double averageSurfaceToVolumeRatio() {
      int number = 0;
      double result = 0;
   
      
      if (number != numberOfIcosahedrons) {
         result = totalAverageSurfaceToVolumeRatio() / numberOfIcosahedrons;
      }
      else {
         result = 0.0;
      }
   
      return result;
   }
/**
* @return toString
*/

   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < numberOfIcosahedrons) {
         result += "\n" + iList[index] + "\n"; 
         index++;  
      }   
      return result;
      
   }

 /**
    * @return summaryInfo
    */
   public String summaryInfo() {
      DecimalFormat f1 = new DecimalFormat("#,##0.0##");
      String output = "----- Summary for " + listName 
         +  " -----";
      output += "\nNumber of Icosahedrons: "
          + numberOfIcosahedrons;
      output += "\nTotal Surface Area: " + f1.format(totalSurfaceArea());
      output += "\nTotal Volume: " + f1.format(totalVolume());
      output += "\nAverage Surface Area: " + f1.format(averageSurfaceArea());
      output += "\nAverage Volume: " + f1.format(averageVolume());
      output += "\nAverage Surface/Volume Ratio: "
          + f1.format(averageSurfaceToVolumeRatio());
      return output; 
   
   }
    /**
    * @return the list.
    */
   public Icosahedron[] getList() {
      return iList;
   }
   /**
    * @param fileNameIn for fileName to read.
    * @return IcosahedronList.
    * @throws IOException for file reading.
    */
   public IcosahedronList2 readFile(String fileNameIn) throws IOException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Icosahedron[] myList = new Icosahedron[20];
      String label = "";
      String color = "";
      double edge = 0;
      listName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         Icosahedron d = new Icosahedron(label, color, edge);
         myList[numberOfIcosahedrons] = d;
         numberOfIcosahedrons++;
      }
      IcosahedronList2 dL = new IcosahedronList2(listName, myList, 
                             numberOfIcosahedrons);
      return dL;
   }
   /**
    * @param labelIn the label.
    * @param colorIn the color.
    * @param edgeIn the edge.
    */
   public void addIcosahedron(String labelIn, String colorIn, double edgeIn) {
      Icosahedron d = new Icosahedron(labelIn, colorIn, edgeIn);
      iList[numberOfIcosahedrons] = d;
      numberOfIcosahedrons++;
   }
   /**
    * @param labelIn the label.
    * @return iList.get(index) the index of the label.
    */
   public Icosahedron findIcosahedron(String labelIn) { 
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (iList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = iList[i];
            break;
         }
      }
      return result;
   }
   /**
    * @param labelIn the label.
    * @return d1 the Icosahedron.
    */
   public Icosahedron deleteIcosahedron(String labelIn) {
      Icosahedron result = null;
      for (int i = 0; i < numberOfIcosahedrons; i++) {
         if (iList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = iList[i];
            for (int j = i; j < numberOfIcosahedrons - 1; j++) {
               iList[j] = iList[j + 1];
            }
            iList[numberOfIcosahedrons - 1] = null;
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
         if (iList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = iList[i];
            iList[i].setColor(colorIn);
            iList[i].setEdge(edgeIn);
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
         if (iList[j].getEdge() <= iList[i].getEdge()) {
            i = j;
         }
      }
      return iList[i];
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
         if (iList[j].getEdge() > iList[i].getEdge()) {
            i = j;
         }
      }
      return iList[i];
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
         if (iList[j].volume() <= iList[i].volume()) {
            i = j;
         }
      }
      return iList[i];
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
         if (iList[j].volume() > iList[i].volume()) {
            i = j;
         }
      }
      return iList[i];
   }

}