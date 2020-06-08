import java.util.Scanner;
/**
* @author Xi Rao
* @version 9/19/2018
*/
public class IcosahedronApp {
   /**
   * @param args not used.
   */
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter label, color, and edge length for an "
         + "icosahedron.");
      System.out.print("\tlabel: ");
      String label = scan.nextLine();
      
      System.out.print("\tcolor: ");
      String color = scan.nextLine();
      
      System.out.print("\tedge: ");
      double edge = scan.nextDouble();
      
      if (edge > 0) {
         Icosahedron d;
         d = new Icosahedron(label, color, edge);
         System.out.println("\n" + d.toString());
      } else {
         System.out.println("Error: edge must begreater than 0.");
      }
   }
}
