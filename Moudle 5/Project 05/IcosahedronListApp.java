import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
@author Xi Rao
@version 10/03/18
*/
public class IcosahedronListApp {
   /**
   @param args comandline args not used 
   @throws IOException iicosahedron_data_0.txtdk
   */
   public static void main(String[] args) throws IOException {
      ArrayList<Icosahedron> dodObjList = new ArrayList<Icosahedron>();
      String listName = "";
      String label = "";
      String color = "";
      double edge = 0;
      
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println();
      
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         
         Icosahedron dodObj = new Icosahedron(label, color, edge);
         dodObjList.add(dodObj);
      }
      // #iHaveNoIdeaWhatImDoing
      IcosahedronList myList = new IcosahedronList(listName, dodObjList);
      
      System.out.println(myList.toString());
      System.out.println();
      System.out.println(myList.summaryInfo());
   }
}