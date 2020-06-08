import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * The Icosahedron list app.
 *
 * @author Lingyi Zhu
 * @version 3/10/2018
 */
public class IcosahedronListApp {
   /**
    * The Icosahedron list app.
    * @param args the args.
    * @throws IOException the IOException.
    */
   public static void main(String[] args) throws IOException {
      ArrayList<Icosahedron> myList = new ArrayList<Icosahedron>();
      String icosahedronListName = "";
      String label = "";
      String color = "";
      double edge = 0;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      System.out.println();
      Scanner scanFile = new Scanner(new File(fileName));
      icosahedronListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         color = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         Icosahedron d = new Icosahedron(label, color, edge);
         myList.add(d);
      }
      IcosahedronList myDList = new 
         IcosahedronList(icosahedronListName, myList);
      System.out.println(myDList);
      System.out.println();
      System.out.println(myDList.summaryInfo());
   }
}